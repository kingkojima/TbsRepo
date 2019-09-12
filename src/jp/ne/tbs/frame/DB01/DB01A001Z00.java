package jp.ne.tbs.frame.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>[クラス名]</p>
 * 　　DATA_PATIENT (患者情報)テーブル　DAOクラス
 * <p>[概要]</p>
 * 　　Ciao用のSQL Server 2016 の DATA_PATIENTテーブルより</br>
 * 　　データを取得し、DTOに格納するクラス。
 * <p>[変更履歴]</p>
 * 　　2019/09/12　小嶋純史　新規作成
 */
public class DB00A001Z00 {

	/** データベースのURL */
	private static final String dbURL = "jdbc:sqlserver://192.168.11.10";
	/** ユーザーID */
	private static final String user = "sa";
	/** パスワード */
	private static final String pass = "supply";
	/** 発行SQL */
	private static final String SQL = "select * from Ciao.dbo.DATA_PATIENT order by ID";

	/**
	 * <p>[メソッド名] </p>
	 * @param
	 * @return
	 */
	public List<DB00T001Z00> findAll() {

		List<DB00T001Z00> dtoList = new ArrayList<>();

		// コネクション定義
		Connection conn = null;
		PreparedStatement ps = null;

		// 接続開始
		try {
			//コネクション取得
			conn = DriverManager.getConnection(dbURL, user, pass);
			//SQL設定
			ps = conn.prepareStatement(SQL);
			//SQLを発行し、結果取得
			try (ResultSet rs = ps.executeQuery()) {
				//結果をDTOに格納
				while (rs.next()) {
					DB00T001Z00 dto = new DB00T001Z00();
					dto.setId(rs.getString("id"));
					dto.setFname(rs.getString("fname"));
					dto.setAname(rs.getString("aname"));
					dtoList.add(dto);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return dtoList;
	}
}

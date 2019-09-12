package jp.ne.tbs.frame.DB02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>[クラス名]</p>
 * 　　DATA_PATIENT_1 (在宅履歴)テーブル　DAOクラス
 * <p>[概要]</p>
 * 　　Ciao用のSQL Server 2016 の DATA_PATIENT_1 テーブルより</br>
 * 　　データを取得し、DTOに格納するクラス。
 * <p>[変更履歴]</p>
 * 　　2019/09/12　小嶋純史　新規作成
 */
public class DB02A001Z00 {

	/** データベースのURL */
	private static final String dbURL = "jdbc:sqlserver://192.168.11.10";
	/** ユーザーID */
	private static final String user = "sa";
	/** パスワード */
	private static final String pass = "supply";
	/** 発行SQL */
	private static final String SQL = "select * from Ciao.dbo.DATA_PATIENT_1 order by ID";

	/**
	 * <p>[メソッド名] </p>
	 * @param
	 * @return
	 */
	public List<DB02T002Z00> findAll() {

		List<DB02T002Z00> dtoList = new ArrayList<>();

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
					DB02T002Z00 dto = new DB02T002Z00();
					dto.setId(rs.getString("id"));
					dto.setSeq(rs.getString("seq"));
					dto.setZudate(rs.getString("zudate"));
					dto.setZstdate(rs.getString("zstdate"));
					dto.setZeddate(rs.getString("zeddate"));
					dto.setZriyu(rs.getString("zriyu"));
					dto.setDiedate(rs.getString("diedate"));
					dto.setEnddate(rs.getString("enddate"));
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

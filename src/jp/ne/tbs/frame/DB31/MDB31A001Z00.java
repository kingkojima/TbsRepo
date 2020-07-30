package jp.ne.tbs.frame.DB31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.ne.tbs.frame.AA00.MAA00B002Z00;

/**
 * <p>[クラス名]</p>
 * 　　MQL_PATIENT 患者テーブル　DAOクラス
 * <p>[概要]</p>
 * 　　新患登録用の MySql の MQL_PATIENT テーブルより</br>
 * 　　データを取得し、DTOに格納するクラス。
 * <p>[変更履歴]</p>
 * 　　2020/02/18　小嶋純史　新規作成
 */
public class MDB31A001Z00 {

	/** 発行SQL */
	private static final String SQL1 = "select pid,pname from Sample_Table order by pid asc";

	/**
	 * <p>[メソッド名] </p>
	 * @param allInOneData
	 * @param
	 * @return
	 */
	public List<MDB31T001Z00> findAll(MAA00B002Z00 allInOneData) throws Exception {

		List<MDB31T001Z00> dtoList = new ArrayList<>();

		// コネクション定義
		Connection conn = null;
		PreparedStatement ps = null;

		// 接続開始
		try {

			// ドライバクラスをロード
			Class.forName("com.mysql.jdbc.Driver");

			// データベースへ接続
			conn = DriverManager.getConnection("jdbc:mysql://192.168.11.41:3306/Sample_db", "tbs283", "tbs283");

			//SQL設定
			ps = conn.prepareStatement(SQL1);

			//SQLを発行し、結果取得
			try (ResultSet rs = ps.executeQuery()) {

				//結果をDTOに格納
				while (rs.next()) {
					MDB31T001Z00 dto = new MDB31T001Z00();
					dto.setPid(rs.getString("pid"));
					dto.setPname(rs.getString("pname"));
					dtoList.add(dto);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {

				if (ps != null) {
					ps.close();
				}

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

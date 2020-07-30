package jp.ne.tbs.frame.DB31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample {

	public static void main(String[] args) {

		Connection con = null;

		PreparedStatement ps = null;

		try {

			// ドライバクラスをロード
			Class.forName("com.mysql.jdbc.Driver");

			// データベースへ接続
			con = DriverManager.getConnection("jdbc:mysql://192.168.11.41:3306/Sample_db", "tbs283", "tbs283");

			// name,bloodType,ageのデータを検索するSQL文を作成
			String sql = "select pid,pname from Sample_Table";

			// ステートメントオブジェクトを生成
			ps = con.prepareStatement(sql);

			// クエリーを実行して結果セットを取得
			ResultSet rs = ps.executeQuery();

			// 検索された行数分ループ
			while (rs.next()) {

				// 患者IDデータを取得
				String pid = rs.getString("pid");
				// 患者nameデータを取得
				String pname = rs.getString("pname");

				// データの表示
				System.out.println("pid;" + " " + pid);
				System.out.println("pname;" + " " + pname);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {

				// close処理
				if (ps != null) {
					ps.close();
				}

				// close処理
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
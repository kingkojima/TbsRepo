package jp.ne.tbs.model.FD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FD01M001Z00 {

	//ＤＢ接続実行
	public void execute() throws SQLException {

		// (1) 接続用のURIを用意する(必要に応じて認証指示user/passwordを付ける)
		String uri = "jdbc:derby:memory:sample;create=true";

		// (2) DriverManagerクラスのメソッドで接続する
		Connection conn = DriverManager.getConnection(uri);

		// (3) SQL送信用インスタンスの作成
		Statement st = conn.createStatement();


	}

}

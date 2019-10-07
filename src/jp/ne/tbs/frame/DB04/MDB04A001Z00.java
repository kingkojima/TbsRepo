package jp.ne.tbs.frame.DB04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.ne.tbs.frame.AA00.MAA00B002Z00;
import jp.ne.tbs.frame.AA00.MAAT00;

/**
 * <p>[クラス名]</p>
 * 　　DATA_PATIENT_YOTEI (予定)テーブル　DAOクラス
 * <p>[概要]</p>
 * 　　Ciao用のSQL Server 2016 の DATA_PATIENT_YOTEI テーブルより</br>
 * 　　データを取得し、DTOに格納するクラス。
 * <p>[変更履歴]</p>
 * 　　2019/10/6　小嶋純史　新規作成
 */
public class MDB04A001Z00 {

	/** データベースのURL */
	private static final String dbURL = "jdbc:sqlserver://192.168.11.10";
	/** ユーザーID */
	private static final String user = "sa";
	/** パスワード */
	private static final String pass = "supply";
	/** 発行SQL */
	private static final String SQL1 = "select * from Ciao.dbo.DATA_PATIENT_YOTEI where FDATE = '";
	private static final String SQL2 = "' order by HOUMON asc, STTIME asc";

	/**
	 * <p>[メソッド名] </p>
	 * @param allInOneData
	 * @param
	 * @return
	 */
	public List<MDB04T001Z00> findAll(MAA00B002Z00 allInOneData) throws Exception {

		List<MDB04T001Z00> dtoList = new ArrayList<>();

		// コネクション定義
		Connection conn = null;
		PreparedStatement ps = null;

		//対象年月日が設定されいない場合、テーブル抽出は行わない。
		if (allInOneData.getAppData().getMsgIn(MAAT00.TRG_YMD) == null) {
			return dtoList;
		}

		//入力項目の取得
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		String trgYmd = sdFormat.format(sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.TRG_YMD)));

		// 接続開始
		try {
			//コネクション取得
			conn = DriverManager.getConnection(dbURL, user, pass);
			//SQL設定
			ps = conn.prepareStatement(SQL1 + trgYmd + SQL2);
			//SQLを発行し、結果取得
			try (ResultSet rs = ps.executeQuery()) {
				//結果をDTOに格納
				while (rs.next()) {
					MDB04T001Z00 dto = new MDB04T001Z00();
					dto.setId(rs.getString("id"));
					dto.setFdate(rs.getString("fdate"));
					dto.setSeq(rs.getString("seq"));
					dto.setRow(rs.getString("row"));
					dto.setService(rs.getString("service"));
					dto.setSttime(rs.getString("sttime"));
					dto.setStime(rs.getString("stime"));
					dto.setHoumon(rs.getString("houmon"));
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

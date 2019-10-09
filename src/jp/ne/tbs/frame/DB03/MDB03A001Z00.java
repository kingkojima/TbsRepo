package jp.ne.tbs.frame.DB03;

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
 * 　　DATA_PATIENT_KKIRIKU2 (記録２)テーブル　DAOクラス
 * <p>[概要]</p>
 * 　　Ciao用のSQL Server 2016 の DATA_PATIENT_KKIROKU2 テーブルより</br>
 * 　　データを取得し、DTOに格納するクラス。
 * <p>[変更履歴]</p>
 * 　　2019/09/12　小嶋純史　新規作成
 */
public class MDB03A001Z00 {

	/** 発行SQL */
	private static final String SQL1 = "select * from Ciao.dbo.DATA_PATIENT_KKIROKU2 where FDATE >= '";
	private static final String SQL2 = "' and FDATE <= '";
	private static final String SQL3 = "' order by ID asc, FDATE desc, SEQ desc";

	/**
	 * <p>[メソッド名] </p>
	 * @param allInOneData
	 * @param
	 * @return
	 */
	public List<MDB03T001Z00> findAll(MAA00B002Z00 allInOneData) throws Exception {

		List<MDB03T001Z00> dtoList = new ArrayList<>();

		// コネクション定義
		Connection conn = null;
		PreparedStatement ps = null;

		//集計開始日と集計終了日が設定されいない場合、テーブル抽出は行わない。
		if (allInOneData.getAppData().getMsgIn(MAAT00.DCP_SRT) == null
				|| allInOneData.getAppData().getMsgIn(MAAT00.DCP_END) == null) {
			return dtoList;
		}

		//入力項目の取得
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		String strYmd = sdFormat.format(sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_SRT)));
		String endYmd = sdFormat.format(sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_END)));

		// 接続開始
		try {
			//コネクション取得
			conn = DriverManager.getConnection(
					allInOneData.getCa().getDbUrl(),
					MAAT00.SYS.DB_USER,
					MAAT00.SYS.DB_PASS);
			//SQL設定
			ps = conn.prepareStatement(SQL1 + strYmd + SQL2 + endYmd + SQL3);
			//SQLを発行し、結果取得
			try (ResultSet rs = ps.executeQuery()) {
				//結果をDTOに格納
				while (rs.next()) {
					MDB03T001Z00 dto = new MDB03T001Z00();
					dto.setId(rs.getString("id"));
					dto.setFdate(rs.getString("fdate"));
					dto.setSeq(rs.getString("seq"));
					dto.setSubject(rs.getString("subject"));
					dto.setObject(rs.getString("object"));
					dto.setAssment(rs.getString("assment"));
					dto.setKplan(rs.getString("kplan"));
					dto.setSubject2(rs.getString("subject2"));
					dto.setMemo(rs.getString("memo"));
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

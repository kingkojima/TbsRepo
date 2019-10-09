package jp.ne.tbs.control.FD02;

import jp.ne.tbs.control.FD01.mdl.MFD01M002Z00;
import jp.ne.tbs.control.FD02.mdl.MFD02M002Z00;
import jp.ne.tbs.frame.AA00.MAA00B006Z00;
import jp.ne.tbs.frame.AA00.MAA00B008Z00;
import jp.ne.tbs.frame.AA00.MAAT00;

/**
 * <p>[クラス名]</p>
 * 　　インフルエンザ予防接種希望集計(往診列毎)　業務処理クラス
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2019/09/17　小嶋純史　新規作成
 */
public class MFD02B004Z00 extends MAA00B006Z00 {

	/**
	 * <p>[概 要] 業務処理を実行する。</p>
	 * <p>[詳 細] 業務処理を実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() throws Exception {

		//ログアウトを取得
		MAA00B008Z00 logOut =  super.getAllInOneData().getLogOut();

		//集計開始日、集計終了日　インフル集計クラスを実行し、
		//AOD.LOGOUTに処理結果マップを設定する。
		MFD01M002Z00 calcObj = new MFD01M002Z00();
		calcObj.setAllInOneData(super.getAllInOneData());
		calcObj.execute();
		logOut.setResultMap(MAAT00.BIZ_RST, calcObj.getResultMap());
		logOut.setResultMap(MAAT00.PAT_DIR, calcObj.getPatDisCnt());
		logOut.setResultMap(MAAT00.FMY_DIR, calcObj.getFmyDisCnt());

		//職員情報マップ編集クラスを実行し、
		//AOD.LOGOUTに職員情報マップを設定する。
		MFD02M002Z00 editObj = new MFD02M002Z00();
		editObj.setAllInOneData(super.getAllInOneData());
		editObj.execute();
		logOut.setResultMap(MAAT00.USR_INF, editObj.getUserMap());

	}

}

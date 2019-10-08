package jp.ne.tbs.control.FD02;

import jp.ne.tbs.control.FD01.mdl.MFD01M002Z00;
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

		//集計開始日、集計終了日　インフル集計クラスを実行
		MFD01M002Z00 calcObj = new MFD01M002Z00();
		calcObj.setAllInOneData(super.getAllInOneData());
		calcObj.execute();

		//AOD.LOGOUTに処理結果マップを設定。
		MAA00B008Z00 logOut =  super.getAllInOneData().getLogOut();
		logOut.setResultMap(MAAT00.BIZ_RESULT, calcObj.getResultMap());
		logOut.setResultMap(MAAT00.PAT_DIR, calcObj.getPatDisCnt());
		logOut.setResultMap(MAAT00.FMY_DIR, calcObj.getFmyDisCnt());

	}

}

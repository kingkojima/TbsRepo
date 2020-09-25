package jp.ne.tbs.control.RE01;

import jp.ne.tbs.frame.AA00.MAA00B006Z00;
import jp.ne.tbs.frame.AA00.MAA00B008Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.model.PT01.MPT01M002Z00;

/**
 * <p>[クラス名]</p>
 * 　　新患受付カナ検索　業務処理クラス
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2019/09/17　小嶋純史　新規作成
 */
public class MRE01B004Z00 extends MAA00B006Z00 {

	/**
	 * <p>[概 要] 業務処理を実行する。</p>
	 * <p>[詳 細] 業務処理を実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() throws Exception {

		//カナ検索クラスを実行
		MPT01M002Z00 calcObj = new MPT01M002Z00();
		calcObj.setAllInOneData(super.getAllInOneData());
		calcObj.execute();

		//AOD.LOGOUTに処理結果マップを設定。
		MAA00B008Z00 logOut =  super.getAllInOneData().getLogOut();
		logOut.setResultMap(MAAT00.BIZ_RST, calcObj.getResultMap());

	}

}

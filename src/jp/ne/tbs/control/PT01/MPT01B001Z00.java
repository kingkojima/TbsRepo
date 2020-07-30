package jp.ne.tbs.control.PT01;

import jp.ne.tbs.frame.AA00.MAA00B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B002Z00;
import jp.ne.tbs.frame.AA00.MAA00B004Z00;
import jp.ne.tbs.frame.AA00.MAA00B005Z00;
import jp.ne.tbs.frame.AA00.MAA00B006Z00;
import jp.ne.tbs.frame.AA00.MAA00B007Z00;

/**
 * <p>[クラス名]</p>
 * 　　レセプト対象一覧作成　業務メイン
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2020/04/10　小嶋純史　新規作成
 */
public class MPT01B001Z00 extends MAA00B001Z00 {

	/**
	 * <p>[概 要] TRXチェック</p>
	 * <p>[詳 細] トランザクションチェックを実装する。</p>
	 * <p>[備 考] </p>
	 * @param allInOneData セットする
	 */
	public void doTrxChk(MAA00B002Z00 allInOneData) {

		//TRXチェックを実行
		MAA00B004Z00 trxChkObj = new MPT01B002Z00();
		trxChkObj.setAllInOneData(allInOneData);
		trxChkObj.execute();

	}

	/**
	 * <p>[概 要] MSTチェック</p>
	 * <p>[詳 細] マスターチェックを実装する。</p>
	 * <p>[備 考] </p>
	 * @param allInOneData セットする
	 */
	public void doMstChk(MAA00B002Z00 allInOneData) {

		//マスターチェックを実行
		MAA00B005Z00 trxChkObj = new MPT01B003Z00();
		trxChkObj.setAllInOneData(allInOneData);
		trxChkObj.execute();

	}

	/**
	 * <p>[概 要] 業務処理実行</p>
	 * <p>[詳 細] 業務処理を実装する。</p>
	 * <p>[備 考] </p>
	 * @param allInOneData セットする
	 */
	public void doBizCtl(MAA00B002Z00 allInOneData) throws Exception {

		//業務コントロールを実行
		MAA00B006Z00 trxChkObj = new MPT01B004Z00();
		trxChkObj.setAllInOneData(allInOneData);
		trxChkObj.execute();

	}

	/**
	 * <p>[概 要] 帳票編集コントロール実行</p>
	 * <p>[詳 細] 帳票編集コントロールを実装する。</p>
	 * <p>[備 考] </p>
	 * @param allInOneData セットする
	 */
	public void doEdtCtl(MAA00B002Z00 allInOneData) {

		//帳票編集コントロールを実行
		MAA00B007Z00 trxChkObj = new MPT01B005Z00();
		trxChkObj.setAllInOneData(allInOneData);
		trxChkObj.execute();

	}
}

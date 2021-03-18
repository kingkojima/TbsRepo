package jp.ne.tbs.control.FD05;

import jp.ne.tbs.frame.AA00.MAA00B004Z00;
import jp.ne.tbs.model.FD01.MFD01M001Z00;
import jp.ne.tbs.model.FD02.MFD02M001Z00;

/**
 * <p>[クラス名]</p>
 * 　　新型コロナワクチン接種希望集計(往診列毎)　TRXチェッククラス
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2021/03/15　小嶋純史　新規作成
 */
public class MFD05B002Z00 extends MAA00B004Z00 {

	/**
	 * <p>[概 要] TRXチェックを実行する。</p>
	 * <p>[詳 細] TRXチェックを実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() {

		//集計開始日、集計終了日　チェッククラスを実行
		MFD01M001Z00 checkObj = new MFD01M001Z00();
		checkObj.setAllInOneData(super.getAllInOneData());
		checkObj.execute();

		//対象年月日　チェッククラスを実行
		MFD02M001Z00 checkObj2 = new MFD02M001Z00();
		checkObj2.setAllInOneData(super.getAllInOneData());
		checkObj2.execute();

	}

}


package jp.ne.tbs.model.FD01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.ne.tbs.frame.AA00.MAA00B002Z00;
import jp.ne.tbs.frame.AA00.MAAE00;
import jp.ne.tbs.frame.AA00.MAAT00;

/**
 * <p>[クラス名]</p>
 * 　　集計開始日、集計終了日　チェッククラス
 * <p>[概要]</p>
 * 　以下をチェックする。<br>
 * 　　①集計開始日と集計終了日が日付に変換できるか？<br>
 * 　　②集計開始日と集計終了日の大小関係が逆転していないか？<br>
 * 　　③集計開始日と集計終了日の間隔が150日以上になっていないか？<br>
 * <p>[使用方法]</p>
 * 　		MFD01M001Z00 checkObj = new MFD01M001Z00();<br>
 * 　		checkObj.setAllInOneData(super.getAllInOneData());<br>
 * 　		checkObj.execute();<br>
 * <p>[変更履歴]</p>
 * 　　2019/10/07　小嶋純史　新規作成
 */
public class MFD01M001Z00 {

	/** 	オールインワンデータ */
	private MAA00B002Z00 allInOneData = null;

	/**
	 * <p>[概 要] TRXチェックを実行する。</p>
	 * <p>[詳 細] TRXチェックを実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() {

		Date strYmd = null;
		Date endYmd = null;

		//文字列フォーマット、日付解析
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		sdFormat.setLenient(false);

		//====================
		//①集計開始日　エラーチェック
		//====================
		try {

			//日付変換できるか？
			strYmd = sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_SRT));

		} catch (ParseException e) {

			//エラーコードを設定
			allInOneData.getCa().setBussnesErrCode(MAAE00.EFD00A001);
			e.printStackTrace();
			return;
		}

		//====================
		//①集計終了日　エラーチェック
		//====================
		try {

			//日付変換できるか？
			endYmd = sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_END));

		} catch (ParseException e) {

			//エラーコードを設定
			allInOneData.getCa().setBussnesErrCode(MAAE00.EFD00A002);
			e.printStackTrace();
			return;
		}

		//====================
		//②日付の大小関係チェック
		//====================
		long MIN_DATE_Diff = 0;
		long dayDiff = (endYmd.getTime()- strYmd.getTime())/(1000*60*60*24);
		if(dayDiff < MIN_DATE_Diff) {
			//エラーコードを設定
			allInOneData.getCa().setBussnesErrCode(MAAE00.EFD00A003);
			return;
		}

		//====================
		//③日付の間隔チェック(150日以内)
		//====================
		long MAX_DATE_DIFF = 150;
		if(dayDiff > MAX_DATE_DIFF) {
			//エラーコードを設定
			allInOneData.getCa().setBussnesErrCode(MAAE00.EFD00A005);
			return;
		}
	}

	/**
	 * <p>[概 要] allInOneData を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return allInOneData
	 */
	protected MAA00B002Z00 getAllInOneData() {
		return allInOneData;
	}

	/**
	 * <p>[概 要] allInOneData を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param allInOneData セットする allInOneData
	 */
	public void setAllInOneData(MAA00B002Z00 allInOneData) {
		this.allInOneData = allInOneData;
	}
}

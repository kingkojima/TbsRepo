package jp.ne.tbs.model.FD03;

import jp.ne.tbs.frame.AA00.MAA00B002Z00;

/**
 * <p>[クラス名]</p>
 * 　　カルテ汎用検索　チェッククラス
 * <p>[概要]</p>
 * 　以下をチェックする。<br>
 * 　　①キーワードがすべて未設定ならNG？<br>
 * 　　②キーワードは詰めて入力されているか？<br>
 * 　　③項目名に区切り文字の入力があった場合はエラーとする。<br>
 * 　　④項目名が入力されている場合、同じ項目名がある場合はエラー。<br>
 * 　　⑤空欄、半/全スペースはNG(大量にヒットするため)<br>
 * <p>[使用方法]</p>
 * 　		MFD03M001Z00 checkObj = new MFD03M001Z00();<br>
 * 　		checkObj.setAllInOneData(super.getAllInOneData());<br>
 * 　		checkObj.execute();<br>
 * <p>[変更履歴]</p>
 * 　　2019/11/01　小嶋純史　新規作成
 */
public class MFD03M001Z00 {

	/** 	オールインワンデータ */
	private MAA00B002Z00 allInOneData = null;

	/**
	 * <p>[概 要] TRXチェックを実行する。</p>
	 * <p>[詳 細] TRXチェックを実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() {

//		Date strYmd = null;
//		Date endYmd = null;
//
//		//文字列フォーマット、日付解析
//		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
//		sdFormat.setLenient(false);

		//====================
		//①集計開始日　エラーチェック
		//====================
//		try {
//
//			//日付変換できるか？
//			strYmd = sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_SRT));
//
//		} catch (ParseException e) {
//
//			//エラーコードを設定
//			allInOneData.getCa().setBussnesErrCode(MAAE00.EFD00A001);
//			e.printStackTrace();
//			return;
//		}

		//====================
		//①集計終了日　エラーチェック
		//====================
//		try {
//
//			//日付変換できるか？
//			endYmd = sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_END));
//
//		} catch (ParseException e) {
//
//			//エラーコードを設定
//			allInOneData.getCa().setBussnesErrCode(MAAE00.EFD00A002);
//			e.printStackTrace();
//			return;
//		}

		//====================
		//②日付の大小関係チェック
		//====================
//		long MIN_DATE_Diff = 0;
//		long dayDiff = (endYmd.getTime()- strYmd.getTime())/(1000*60*60*24);
//		if(dayDiff < MIN_DATE_Diff) {
//			//エラーコードを設定
//			allInOneData.getCa().setBussnesErrCode(MAAE00.EFD00A003);
//			return;
//		}

		//====================
		//③日付の間隔チェック(150日以内)
		//====================
//		long MAX_DATE_DIFF = 150;
//		if(dayDiff > MAX_DATE_DIFF) {
//			//エラーコードを設定
//			allInOneData.getCa().setBussnesErrCode(MAAE00.EFD00A005);
//			return;
//		}
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

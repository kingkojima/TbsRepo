package jp.ne.tbs.model.FD02;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.ne.tbs.frame.AA00.MAA00B002Z00;
import jp.ne.tbs.frame.AA00.MAAE00;
import jp.ne.tbs.frame.AA00.MAAT00;

/**
 * <p>[クラス名]</p>
 * 　　対象年月日　チェッククラス
 * <p>[概要]</p>
 * 　以下をチェックする。<br>
 * 　　①対象年月日が日付に変換できるか？<br>
 * <p>[使用方法]</p>
 * 　		MFD02M001Z00 checkObj = new MFD02M001Z00();<br>
 * 　		checkObj.setAllInOneData(super.getAllInOneData());<br>
 * 　		checkObj.execute();<br>
 * <p>[変更履歴]</p>
 * 　　2019/10/07　小嶋純史　新規作成
 */
public class MFD02M001Z00 {

	/** 	オールインワンデータ */
	private MAA00B002Z00 allInOneData = null;

	/**
	 * <p>[概 要] TRXチェックを実行する。</p>
	 * <p>[詳 細] TRXチェックを実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() {

		//文字列フォーマット、日付解析
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		sdFormat.setLenient(false);

		//====================
		//①対象年月日　エラーチェック
		//====================
		try {

			//日付変換できるか？
			sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.TRG_YMD));

		} catch (ParseException e) {

			//エラーコードを設定
			allInOneData.getCa().setBussnesErrCode(MAAE00.EFD00A006);
			e.printStackTrace();
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

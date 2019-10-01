package jp.ne.tbs.control.FD01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.ne.tbs.frame.AA00.MAA00B004Z00;
import jp.ne.tbs.frame.AA00.MAAE00;
import jp.ne.tbs.frame.AA00.MAAT00;

/**
 * <p>[クラス名]</p>
 * 　　インフルエンザ予防接種希望集計　TRXチェッククラス
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2019/09/17　小嶋純史　新規作成
 */
public class MFD01B002Z00 extends MAA00B004Z00 {

	/**
	 * <p>[概 要] TRXチェックを実行する。</p>
	 * <p>[詳 細] TRXチェックを実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() {

		//文字列フォーマット、日付解析
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		sdFormat.setLenient(false);

		//集計開始日　エラーチェック
		try {

			//日付変換できるか？
			sdFormat.parse(super.getAllInOneData().getAppData().getMsgIn(MAAT00.DCP_SRT));

		} catch (ParseException e) {

			//エラーコードを設定
			super.getAllInOneData().getCa().setBussnesErrCode(MAAE00.EFD00A001);
			e.printStackTrace();
			return;
		}

		//集計終了日　エラーチェック
		try {

			//日付変換できるか？
			sdFormat.parse(super.getAllInOneData().getAppData().getMsgIn(MAAT00.DCP_END));

		} catch (ParseException e) {

			//エラーコードを設定
			super.getAllInOneData().getCa().setBussnesErrCode(MAAE00.EFD00A002);
			e.printStackTrace();
			return;
		}

		Date strYmd = null;
		Date endYmd = null;
		try {
			strYmd = sdFormat.parse(super.getAllInOneData().getAppData().getMsgIn(MAAT00.DCP_SRT));
			endYmd = sdFormat.parse(super.getAllInOneData().getAppData().getMsgIn(MAAT00.DCP_END));
		} catch (Exception e) {
			//エラーコードを設定
			super.getAllInOneData().getCa().setBussnesErrCode(MAAE00.EFD00A001);
			e.printStackTrace();
			return;
		}

		//日付の大小関係チェック
		if(!endYmd.after(strYmd)) {
			//エラーコードを設定
			super.getAllInOneData().getCa().setBussnesErrCode(MAAE00.EFD00A003);
			return;
		}

	}

}


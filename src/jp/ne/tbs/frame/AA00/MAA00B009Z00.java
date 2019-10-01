package jp.ne.tbs.frame.AA00;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * <p>[クラス名]</p>
 * 　　CA クラス
 * <p>[概要]</p>
 * 　　共通領域(Common Aria)を保持するクラス
 * 　　エラー情報 やユーザー情報を保持する。
 * <p>[変更履歴]</p>
 * 　　2019/09/30　小嶋純史　新規作成
 */
public class MAA00B009Z00 {

	/**
	 * 業務エラー
	 */
	private String bussnesErrCode;

	/**
	 * コンストラクタ
	 */
	public MAA00B009Z00() {
		this.bussnesErrCode = new String(MAAT00.CHAR.EMPTY_STRING);
	}

	/**
	 * <p>[概 要] bussnesErrCode を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return bussnesErrCode
	 */
	public String getBussnesErrCode() {
		return bussnesErrCode;
	}

	/**
	 * <p>[概 要] bussnesErrCode を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param bussnesErrCode セットする bussnesErrCode
	 */
	public void setBussnesErrCode(String bussnesErrCode) {
		JOptionPane.showConfirmDialog((Component)null, bussnesErrCode, "エラー", -1, 1);
		this.bussnesErrCode = bussnesErrCode;
	}


	/**
	 * <p>[概 要] エラーが発生しているかを返却する。</p>
	 * <p>[詳 細] エラー発生あり＝true</p>
	 * <p>            エラー発生なし＝false</p>
	 * <p>[備 考] </p>
	 * @param bussnesErrCode セットする bussnesErrCode
	 */
	public Boolean errOccurred() {

		//エラーが発生していない場合
		if(bussnesErrCode.equals(MAAT00.CHAR.EMPTY_STRING)) {
			return false;
		} else {
			return true;
		}
	}
}

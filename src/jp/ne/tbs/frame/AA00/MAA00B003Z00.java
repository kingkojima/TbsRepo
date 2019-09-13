package jp.ne.tbs.frame.AA00;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>[クラス名]</p>
 * 　　アプリデータクラス
 * <p>[概要]</p>
 * 　　MSG-INとMSG-OUTを保持するクラス
 * <p>[変更履歴]</p>
 * 　　2019/09/12　小嶋純史　新規作成
 */
public class MAA00B003Z00 {

	/**
	 * メッセージイン
	 * Key:キーワード
	 * Value:値
	 */
	private Map<String, String> msgIn;

	/**
	 * メッセージアウト
	 * Key:キーワード
	 * Value:値
	 */
	private Map<String, String> msgOut;

	/**
	 * コンストラクタ
	 */
	public MAA00B003Z00() {
		this.msgIn = new HashMap<String, String>();
		this.msgOut = new HashMap<String, String>();
	}

	/**
	 * <p>[概 要] msgIn から値を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param key
	 * @return value
	 */
	public String getMsgIn(String key) {
		return msgIn.get(key);
	}

	/**
	 * <p>[概 要] msgIn に値を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param key
	 * @param value
	 */
	public void setMsgIn(String key, String value) {
		msgIn.put(key, value);
	}

	/**
	 * <p>[概 要] msgOut から値を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param key
	 * @return value
	 */
	public String getMsgOut(String key) {
		return msgOut.get(key);
	}

	/**
	 * <p>[概 要] msgOut に値を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param key
	 * @param value
	 */
	public void setMsgOut(String key, String value) {
		msgOut.put(key, value);
	}
}

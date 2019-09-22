package jp.ne.tbs.frame.AA00;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>[クラス名]</p>
 * 　　ログアウトクラス
 * <p>[概要]</p>
 * 　　処理結果Mapを保持するクラス
 * <p>[変更履歴]</p>
 * 　　2019/09/22　小嶋純史　新規作成
 */
public class MAA00B008Z00 {

	/**
	 * 処理結果マップ
	 * Key:キーワード
	 * Value:オブジェクト型
	 */
	private Map<String, Object> resultMap;

	/**
	 * コンストラクタ
	 */
	public MAA00B008Z00() {
		this.resultMap = new HashMap<String, Object>();
	}

	/**
	 * <p>[概 要] 処理結果マップから値を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param key
	 * @return value
	 */
	public Object getResultMap(String key) {
		return resultMap.get(key);
	}

	/**
	 * <p>[概 要] 処理結果マップに値を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param key
	 * @param value
	 */
	public void setResultMap(String key, Object value) {
		resultMap.put(key, value);
	}
}

package jp.ne.tbs.frame.AA00;

/**
 * <p>[クラス名]</p>
 * 　　マスターチェック　フレームワーク
 * <p>[概要]</p>
 * 　　マスターチェックのフレームワーク。抽象クラス。
 * <p>[変更履歴]</p>
 * 　　2019/09/17　小嶋純史　新規作成
 */
public abstract class MAA00B005Z00 {

	/** 	オールインワンデータ */
	MAA00B002Z00 allInOneData = null;

	/**
	 * <p>[概 要] マスターチェックを実行する。</p>
	 * <p>[詳 細] 継承必須</p>
	 * <p>[備 考] </p>
	 */
	public abstract void execute();

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

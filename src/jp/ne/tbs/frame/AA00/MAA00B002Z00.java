package jp.ne.tbs.frame.AA00;

import java.util.List;

import jp.ne.tbs.frame.DB01.MDB01T001Z00;
import jp.ne.tbs.frame.DB02.MDB02T001Z00;
import jp.ne.tbs.frame.DB03.MDB03T001Z00;
import jp.ne.tbs.frame.DB04.MDB04T001Z00;
import jp.ne.tbs.frame.DB05.MDB05T001Z00;

/**
 * <p>[クラス名]</p>
 * 　　オールインワンデータクラス
 * <p>[概要]</p>
 * 　　CA、appData、マスター群、ログアウト、帳票データを保持するクラス
 * <p>[変更履歴]</p>
 * 　　2019/09/12　小嶋純史　新規作成
 */
public class MAA00B002Z00 {

	/**
	 * CA
	 */
	private MAA00B009Z00 ca;

	/**
	 * アプリデータ
	 */
	private MAA00B003Z00 appData;

	/**
	 * 患者情報TBLリスト
	 */
	private List<MDB01T001Z00> ptInfoTbls;

	/**
	 * 在宅履歴TBLリスト
	 */
	private List<MDB02T001Z00> zaHistTbls;

	/**
	 * 診療記録TBLリスト
	 */
	private List<MDB03T001Z00> snRecoTbls;

	/**
	 * 予定TBLリスト
	 */
	private List<MDB04T001Z00> yoteiTbls;

	/**
	 * 職員情報TBLリスト
	 */
	private List<MDB05T001Z00> userTbls;

	/**
	 * ログアウト
	 */
	private MAA00B008Z00 logOut;

	/**
	 * <p>[概 要] ca を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return ca
	 */
	public MAA00B009Z00 getCa() {
		return ca;
	}

	/**
	 * <p>[概 要] ca を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param ca セットする ca
	 */
	protected void setCa(MAA00B009Z00 ca) {
		this.ca = ca;
	}

	/**
	 * <p>[概 要] アプリデータを取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return appData
	 */
	public MAA00B003Z00 getAppData() {
		return appData;
	}

	/**
	 * <p>[概 要] アプリデータを設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param appData セットする appData
	 */
	protected void setAppData(MAA00B003Z00 appData) {
		this.appData = appData;
	}

	/**
	 * <p>[概 要] 患者情報テーブルを取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return ptInfoTbls
	 */
	public List<MDB01T001Z00> getPtInfoTbls() {
		return ptInfoTbls;
	}

	/**
	 * <p>[概 要] 患者情報テーブルを設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param ptInfoTbls セットする ptInfoTbls
	 */
	protected void setPtInfoTbls(List<MDB01T001Z00> ptInfoTbls) {
		this.ptInfoTbls = ptInfoTbls;
	}

	/**
	 * <p>[概 要] 在宅履歴テーブルを取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return zaHistTbls
	 */
	public List<MDB02T001Z00> getZaHistTbls() {
		return zaHistTbls;
	}

	/**
	 * <p>[概 要] 在宅履歴テーブルを設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param zaHistTbls セットする zaHistTbls
	 */
	protected void setZaHistTbls(List<MDB02T001Z00> zaHistTbls) {
		this.zaHistTbls = zaHistTbls;
	}

	/**
	 * <p>[概 要] 診療記録テーブルを取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return snRecoTbls
	 */
	public List<MDB03T001Z00> getSnRecoTbls() {
		return snRecoTbls;
	}

	/**
	 * <p>[概 要] 診療記録テーブルを設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param snRecoTbls セットする snRecoTbls
	 */
	protected void setSnRecoTbls(List<MDB03T001Z00> snRecoTbls) {
		this.snRecoTbls = snRecoTbls;
	}

	/**
	 * <p>[概 要] yoteiTbls を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return yoteiTbls
	 */
	public List<MDB04T001Z00> getYoteiTbls() {
		return yoteiTbls;
	}

	/**
	 * <p>[概 要] yoteiTbls を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param yoteiTbls セットする yoteiTbls
	 */
	protected void setYoteiTbls(List<MDB04T001Z00> yoteiTbls) {
		this.yoteiTbls = yoteiTbls;
	}

	/**
	 * <p>[概 要] userTbls を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return userTbls
	 */
	public List<MDB05T001Z00> getUserTbls() {
		return userTbls;
	}

	/**
	 * <p>[概 要] userTbls を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param userTbls セットする userTbls
	 */
	protected void setUserTbls(List<MDB05T001Z00> userTbls) {
		this.userTbls = userTbls;
	}

	/**
	 * <p>[概 要] LogOut を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return logOut
	 */
	public MAA00B008Z00 getLogOut() {
		return logOut;
	}

	/**
	 * <p>[概 要] LogOut を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param logOut セットする logOut
	 */
	protected void setLogOut(MAA00B008Z00 logOut) {
		this.logOut = logOut;
	}
}

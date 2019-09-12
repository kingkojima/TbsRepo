package jp.ne.tbs.frame.AA00;

import java.util.List;

import jp.ne.tbs.frame.DB01.DB01T001Z00;
import jp.ne.tbs.frame.DB02.DB02T001Z00;
import jp.ne.tbs.frame.DB03.DB03T001Z00;

public class AA00B002Z00 {

	/**
	 * 患者情報TBLリスト
	 */
	private List<DB01T001Z00> ptInfoTbls;

	/**
	 * 在宅履歴TBLリスト
	 */
	private List<DB02T001Z00> zaHistTbls;

	/**
	 * 診療記録TBLリスト
	 */
	private List<DB03T001Z00> snRecoTbls;

	/**
	 * <p>[概 要] ptInfoTbls を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return ptInfoTbls
	 */
	public List<DB01T001Z00> getPtInfoTbls() {
		return ptInfoTbls;
	}

	/**
	 * <p>[概 要] ptInfoTbls を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param ptInfoTbls セットする ptInfoTbls
	 */
	public void setPtInfoTbls(List<DB01T001Z00> ptInfoTbls) {
		this.ptInfoTbls = ptInfoTbls;
	}

	/**
	 * <p>[概 要] zaHistTbls を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return zaHistTbls
	 */
	public List<DB02T001Z00> getZaHistTbls() {
		return zaHistTbls;
	}

	/**
	 * <p>[概 要] zaHistTbls を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param zaHistTbls セットする zaHistTbls
	 */
	public void setZaHistTbls(List<DB02T001Z00> zaHistTbls) {
		this.zaHistTbls = zaHistTbls;
	}

	/**
	 * <p>[概 要] snRecoTbls を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return snRecoTbls
	 */
	public List<DB03T001Z00> getSnRecoTbls() {
		return snRecoTbls;
	}

	/**
	 * <p>[概 要] snRecoTbls を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param snRecoTbls セットする snRecoTbls
	 */
	public void setSnRecoTbls(List<DB03T001Z00> snRecoTbls) {
		this.snRecoTbls = snRecoTbls;
	}

}

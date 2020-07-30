package jp.ne.tbs.frame.DB31;

/**
 * <p>[概要]</p>
 * 　　MQL_PATIENT 患者テーブル　DTOクラス
 * <p>[詳細]</p>
 * <p>[備考]</p>
 * <p>[メモ]</p>
 * @since 2020/02/18
 * @version 1.0.0
 * @author TBS-System-Administr
 */
public class MDB31T001Z00 {

	/**
	 * 患者ID
	 */
	private String pid;

	/**
	 * 患者名(漢字)
	 */
	private String pname;

	/**
	 * <p>[概 要] 患者ID を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * <p>[概 要] 患者IDを設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param pid セットする pid
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * <p>[概 要] 患者名(漢字) を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * <p>[概 要] 患者名(漢字) を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param pname セットする pname
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

}

package jp.ne.tbs.frame.DB02;

/**
 * <p>[概要]</p>
 * 　　DATA_PATIENT_1 (在宅履歴)テーブル　DTOクラス
 * <p>[詳細]</p>
 * <p>[備考]</p>
 * <p>[メモ]</p>
 * @since 2019/9/12
 * @version 1.0.0
 * @author TBS-System-Administr
 */
public class DB02T002Z00 {

	/**
	 * 患者ID
	 */
	private String id;

	/**
	 * SEQ
	 */
	private String seq;

	/**
	 * ZUDATE　在宅受付日
	 */
	private String zudate;

	/**
	 * ZSTDATE　在宅開始日
	 */
	private String zstdate;

	/**
	 * ZEDDATE　在宅終了日
	 */
	private String zeddate;

	/**
	 * ZRIYU　終了理由
	 */
	private String zriyu;

	/**
	 * DIEDATE　死亡年月日
	 */
	private String diedate;

	/**
	 * ENDDATE　完全終了日
	 */
	private String enddate;

	/**
	 * <p>[概 要] 患者ID を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * <p>[概 要] 患者ID を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * <p>[概 要] SEQ を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * <p>[概 要] SEQ を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param seq セットする seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * <p>[概 要] 在宅受付日を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return zudate
	 */
	public String getZudate() {
		return zudate;
	}

	/**
	 * <p>[概 要] 在宅受付日を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param zudate セットする zudate
	 */
	public void setZudate(String zudate) {
		this.zudate = zudate;
	}

	/**
	 * <p>[概 要] 在宅開始日を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return zstdate
	 */
	public String getZstdate() {
		return zstdate;
	}

	/**
	 * <p>[概 要] 在宅開始日を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param zstdate セットする zstdate
	 */
	public void setZstdate(String zstdate) {
		this.zstdate = zstdate;
	}

	/**
	 * <p>[概 要] 在宅終了日を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return zeddate
	 */
	public String getZeddate() {
		return zeddate;
	}

	/**
	 * <p>[概 要] 在宅終了日を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param zeddate セットする zeddate
	 */
	public void setZeddate(String zeddate) {
		this.zeddate = zeddate;
	}

	/**
	 * <p>[概 要] 終了理由を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return zriyu
	 */
	public String getZriyu() {
		return zriyu;
	}

	/**
	 * <p>[概 要] 終了理由を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param zriyu セットする zriyu
	 */
	public void setZriyu(String zriyu) {
		this.zriyu = zriyu;
	}

	/**
	 * <p>[概 要] 死亡年月日を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return diedate
	 */
	public String getDiedate() {
		return diedate;
	}

	/**
	 * <p>[概 要] 死亡年月日を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param diedate セットする diedate
	 */
	public void setDiedate(String diedate) {
		this.diedate = diedate;
	}

	/**
	 * <p>[概 要] 完全終了日を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return enddate
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * <p>[概 要] 完全終了日を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param enddate セットする enddate
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

}

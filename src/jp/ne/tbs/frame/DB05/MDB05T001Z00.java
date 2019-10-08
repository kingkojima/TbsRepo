package jp.ne.tbs.frame.DB05;

/**
 * <p>[概要]</p>
 * 　　MST_USER (職員情報)テーブル　DTOクラス
 * <p>[詳細]</p>
 * <p>[備考]</p>
 * <p>[メモ]</p>
 * @since 2019/10/6
 * @version 1.0.0
 * @author TBS-System-Administr
 */
public class MDB05T001Z00 {

	/**
	 * 職員ID
	 */
	private String id;

	/**
	 * FNAME
	 */
	private String fname;

	/**
	 * ANAME
	 */
	private String aname;

	/**
	 * RYAK
	 */
	private String ryak;

	/**
	 * <p>[概 要] id を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * <p>[概 要] id を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * <p>[概 要] fname を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * <p>[概 要] fname を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param fname セットする fname
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * <p>[概 要] aname を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return aname
	 */
	public String getAname() {
		return aname;
	}

	/**
	 * <p>[概 要] aname を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param aname セットする aname
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}

	/**
	 * <p>[概 要] ryak を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return ryak
	 */
	public String getRyak() {
		return ryak;
	}

	/**
	 * <p>[概 要] ryak を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param ryak セットする ryak
	 */
	public void setRyak(String ryak) {
		this.ryak = ryak;
	}

}

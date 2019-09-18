package jp.ne.tbs.frame.DB01;

/**
 * <p>[概要]</p>
 * 　　DATA_PATIENT (患者情報)テーブル　DTOクラス
 * <p>[詳細]</p>
 * <p>[備考]</p>
 * <p>[メモ]</p>
 * @since 2019/9/12
 * @version 1.0.0
 * @author TBS-System-Administr
 */
public class MDB01T001Z00 {

	/**
	 * 患者ID
	 */
	private String id;

	/**
	 * 患者の漢字名
	 */
	private String fname;

	/**
	 * 患者のカナ名
	 */
	private String aname;

	/**
	 * 患者の性別
	 */
	private int sex;

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
	 * @param id セットする
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * <p>[概 要] 名前(漢字)を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * <p>[概 要] 名前(漢字)を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param fname セットする
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * <p>[概 要] 名前(フリガナ)を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return aname
	 */
	public String getAname() {
		return aname;
	}

	/**
	 * <p>[概 要] 名前(フリガナ)を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param aname セットする
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}

	/**
	 * <p>[概 要] 性別を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return sex
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * <p>[概 要] 性別を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param sex セットする
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}



}

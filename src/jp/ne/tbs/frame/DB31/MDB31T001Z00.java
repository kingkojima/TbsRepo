package jp.ne.tbs.frame.DB31;

/**
 * <p>[概要]</p>
 * 　　TBL_ｘｘｘｘｘｘｘｘ 患者テーブル　DTOクラス
 * <p>[詳細]</p>
 * <p>[備考]</p>
 * <p>[メモ]</p>
 * @since 2020/08/21
 * @version 1.0.0
 * @author TBS-System-Administr
 */
public class MDB31T001Z00 {

	/**
	 * 内部 ID
	 */
	private String i_id;

	/**
	 * 内部 更新年月日
	 */
	private String i_updateYmd;

	/**
	 * 内部 更新カウンター
	 */
	private String i_updateCnt;

	/**
	 * ヘッダー部 受付年月日
	 */
	private String h_receptYmd;

	/**
	 * ヘッダー部 受付者
	 */
	private String h_receptName;

	/**
	 * ヘッダー部 担当者
	 */
	private String h_staffName;

	/**
	 * 患者情報 カナ名
	 */
	private String p_fName;

	/**
	 * 患者情報 ID
	 */
	private String p_id;

	/**
	 * 患者情報 漢字
	 */
	private String p_cName;

	/**
	 * 患者情報 性別
	 */
	private String p_sex;

	/**
	 * 患者情報 生年月日
	 */
	private String p_birthYmd;

	/**
	 * 患者情報 年齢
	 */
	private String p_age;

	/**
	 * 患者情報 郵便番号
	 */
	private String p_postNo;

	/**
	 * 患者情報 住所
	 */
	private String p_address;

	/**
	 * 患者情報 駐車場
	 */
	private String p_park;

	/**
	 * 患者情報 電話番号
	 */
	private String p_phone;

	/**
	 * 患者情報 携帯番号
	 */
	private String p_mobileNo;

	/**
	 * <p>[概 要] i_id を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return i_id
	 */
	public String getI_id() {
		return i_id;
	}

	/**
	 * <p>[概 要] i_id を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param i_id セットする i_id
	 */
	public void setI_id(String i_id) {
		this.i_id = i_id;
	}

	/**
	 * <p>[概 要] i_updateYmd を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return i_updateYmd
	 */
	public String getI_updateYmd() {
		return i_updateYmd;
	}

	/**
	 * <p>[概 要] i_updateYmd を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param i_updateYmd セットする i_updateYmd
	 */
	public void setI_updateYmd(String i_updateYmd) {
		this.i_updateYmd = i_updateYmd;
	}

	/**
	 * <p>[概 要] i_updateCnt を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return i_updateCnt
	 */
	public String getI_updateCnt() {
		return i_updateCnt;
	}

	/**
	 * <p>[概 要] i_updateCnt を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param i_updateCnt セットする i_updateCnt
	 */
	public void setI_updateCnt(String i_updateCnt) {
		this.i_updateCnt = i_updateCnt;
	}

	/**
	 * <p>[概 要] h_receptYmd を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return h_receptYmd
	 */
	public String getH_receptYmd() {
		return h_receptYmd;
	}

	/**
	 * <p>[概 要] h_receptYmd を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param h_receptYmd セットする h_receptYmd
	 */
	public void setH_receptYmd(String h_receptYmd) {
		this.h_receptYmd = h_receptYmd;
	}

	/**
	 * <p>[概 要] h_receptName を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return h_receptName
	 */
	public String getH_receptName() {
		return h_receptName;
	}

	/**
	 * <p>[概 要] h_receptName を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param h_receptName セットする h_receptName
	 */
	public void setH_receptName(String h_receptName) {
		this.h_receptName = h_receptName;
	}

	/**
	 * <p>[概 要] h_staffName を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return h_staffName
	 */
	public String getH_staffName() {
		return h_staffName;
	}

	/**
	 * <p>[概 要] h_staffName を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param h_staffName セットする h_staffName
	 */
	public void setH_staffName(String h_staffName) {
		this.h_staffName = h_staffName;
	}

	/**
	 * <p>[概 要] p_fName を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_fName
	 */
	public String getP_fName() {
		return p_fName;
	}

	/**
	 * <p>[概 要] p_fName を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_fName セットする p_fName
	 */
	public void setP_fName(String p_fName) {
		this.p_fName = p_fName;
	}

	/**
	 * <p>[概 要] p_id を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_id
	 */
	public String getP_id() {
		return p_id;
	}

	/**
	 * <p>[概 要] p_id を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_id セットする p_id
	 */
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	/**
	 * <p>[概 要] p_cName を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_cName
	 */
	public String getP_cName() {
		return p_cName;
	}

	/**
	 * <p>[概 要] p_cName を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_cName セットする p_cName
	 */
	public void setP_cName(String p_cName) {
		this.p_cName = p_cName;
	}

	/**
	 * <p>[概 要] p_sex を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_sex
	 */
	public String getP_sex() {
		return p_sex;
	}

	/**
	 * <p>[概 要] p_sex を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_sex セットする p_sex
	 */
	public void setP_sex(String p_sex) {
		this.p_sex = p_sex;
	}

	/**
	 * <p>[概 要] p_birthYmd を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_birthYmd
	 */
	public String getP_birthYmd() {
		return p_birthYmd;
	}

	/**
	 * <p>[概 要] p_birthYmd を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_birthYmd セットする p_birthYmd
	 */
	public void setP_birthYmd(String p_birthYmd) {
		this.p_birthYmd = p_birthYmd;
	}

	/**
	 * <p>[概 要] p_age を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_age
	 */
	public String getP_age() {
		return p_age;
	}

	/**
	 * <p>[概 要] p_age を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_age セットする p_age
	 */
	public void setP_age(String p_age) {
		this.p_age = p_age;
	}

	/**
	 * <p>[概 要] p_postNo を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_postNo
	 */
	public String getP_postNo() {
		return p_postNo;
	}

	/**
	 * <p>[概 要] p_postNo を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_postNo セットする p_postNo
	 */
	public void setP_postNo(String p_postNo) {
		this.p_postNo = p_postNo;
	}

	/**
	 * <p>[概 要] p_address を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_address
	 */
	public String getP_address() {
		return p_address;
	}

	/**
	 * <p>[概 要] p_address を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_address セットする p_address
	 */
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}

	/**
	 * <p>[概 要] p_park を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_park
	 */
	public String getP_park() {
		return p_park;
	}

	/**
	 * <p>[概 要] p_park を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_park セットする p_park
	 */
	public void setP_park(String p_park) {
		this.p_park = p_park;
	}

	/**
	 * <p>[概 要] p_phone を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_phone
	 */
	public String getP_phone() {
		return p_phone;
	}

	/**
	 * <p>[概 要] p_phone を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_phone セットする p_phone
	 */
	public void setP_phone(String p_phone) {
		this.p_phone = p_phone;
	}

	/**
	 * <p>[概 要] p_mobileNo を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return p_mobileNo
	 */
	public String getP_mobileNo() {
		return p_mobileNo;
	}

	/**
	 * <p>[概 要] p_mobileNo を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param p_mobileNo セットする p_mobileNo
	 */
	public void setP_mobileNo(String p_mobileNo) {
		this.p_mobileNo = p_mobileNo;
	}

}

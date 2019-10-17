package jp.ne.tbs.frame.AA00;

public final class MAAT00 {

	//インスタンス化防止
	private MAAT00() {
	}

	public static class SYS {
		public static final String IP_EAST = "192.168.11";
		public static final String IP_WEST = "192.168.12";
//		public static final String DB_URL_EAST = "jdbc:sqlserver://192.168.11.10";
//TODO テスト用 ★東西IPアドレス変更★
		public static final String DB_URL_EAST = "jdbc:sqlserver://192.168.12.1";
		public static final String DB_URL_WEST = "jdbc:sqlserver://192.168.12.1";
		public static final String DB_USER = "sa";
		public static final String DB_PASS = "supply";
	}

	public static class CHAR {
		public static final String SLASH = "/";
		public static final String BLANK = " ";
		public static final String CRLF = System.getProperty("line.separator");
		public static final String LF = "¥n";
		public static final String EMPTY_STRING = "";
	}

	public static class DROP {
		public static final String STRING = "1";
		public static final String NUMBER = "2";
	}

	/** 集計期間　開始 */
	public static final String DCP_SRT = "FD00C001Z00";
	/** 集計期間　終了 */
	public static final String DCP_END = "FD00C002Z00";

	/** 項目1　名前 */
	public static final String ITM_NME_1 = "FD00C003Z00";
	/** 項目1　区切り */
	public static final String ITM_DLM_1 = "FD00C004Z00";
	/** 項目1　集計形式 */
	public static final String ITM_PTN_1 = "FD00C005Z00";
	/** 項目1　終了文字 */
	public static final String ITM_END_1 = "FD00C006Z00";

	/** 項目2　名前 */
	public static final String ITM_NME_2 = "FD00C007Z00";
	/** 項目2　区切り */
	public static final String ITM_DLM_2 = "FD00C008Z00";
	/** 項目2　集計形式 */
	public static final String ITM_PTN_2 = "FD00C009Z00";
	/** 項目2　終了文字 */
	public static final String ITM_END_2 = "FD00C010Z00";

	/** 項目3　名前 */
	public static final String ITM_NME_3 = "FD00C011Z00";
	/** 項目3　区切り */
	public static final String ITM_DLM_3 = "FD00C012Z00";
	/** 項目3　集計形式 */
	public static final String ITM_PTN_3 = "FD00C013Z00";
	/** 項目3　終了文字 */
	public static final String ITM_END_3 = "FD00C014Z00";

	/** 項目4　名前 */
	public static final String ITM_NME_4 = "FD00C015Z00";
	/** 項目4　区切り */
	public static final String ITM_DLM_4 = "FD00C016Z00";
	/** 項目4　集計形式 */
	public static final String ITM_PTN_4 = "FD00C017Z00";
	/** 項目4　終了文字 */
	public static final String ITM_END_4 = "FD00C018Z00";

	/** 項目5　名前 */
	public static final String ITM_NME_5 = "FD00C019Z00";
	/** 項目5　区切り */
	public static final String ITM_DLM_5 = "FD00C020Z00";
	/** 項目5　集計形式 */
	public static final String ITM_PTN_5 = "FD00C021Z00";
	/** 項目5　終了文字 */
	public static final String ITM_END_5 = "FD00C022Z00";

	/** 項目6　名前 */
	public static final String ITM_NME_6 = "FD00C023Z00";
	/** 項目6　区切り */
	public static final String ITM_DLM_6 = "FD00C024Z00";
	/** 項目6　集計形式 */
	public static final String ITM_PTN_6 = "FD00C025Z00";
	/** 項目6　終了文字 */
	public static final String ITM_END_6 = "FD00C026Z00";

	/** 項目7　名前 */
	public static final String ITM_NME_7 = "FD00C027Z00";
	/** 項目7　区切り */
	public static final String ITM_DLM_7 = "FD00C028Z00";
	/** 項目7　集計形式 */
	public static final String ITM_PTN_7 = "FD00C029Z00";
	/** 項目7　終了文字 */
	public static final String ITM_END_7 = "FD00C030Z00";

	/** 項目8　名前 */
	public static final String ITM_NME_8 = "FD00C031Z00";
	/** 項目8　区切り */
	public static final String ITM_DLM_8 = "FD00C032Z00";
	/** 項目8　集計形式 */
	public static final String ITM_PTN_8 = "FD00C033Z00";
	/** 項目8　終了文字 */
	public static final String ITM_END_8 = "FD00C034Z00";

	/** 項目9　名前 */
	public static final String ITM_NME_9 = "FD00C035Z00";
	/** 項目9　区切り */
	public static final String ITM_DLM_9 = "FD00C036Z00";
	/** 項目9　集計形式 */
	public static final String ITM_PTN_9 = "FD00C037Z00";
	/** 項目9　終了文字 */
	public static final String ITM_END_9 = "FD00C038Z00";

	/** 項目10　名前 */
	public static final String ITM_NME_10 = "FD00C039Z00";
	/** 項目10　区切り */
	public static final String ITM_DLM_10 = "FD00C040Z00";
	/** 項目10　集計形式 */
	public static final String ITM_PTN_10 = "FD00C041Z00";
	/** 項目10　終了文字 */
	public static final String ITM_END_10 = "FD00C042Z00";

	/** 患者　漢字名 */
	public static final String PTT_NME = "FD00C100Z00";
	/** 患者　フリガナ */
	public static final String PTT_ANM = "FD00C101Z00";

	/** 処理結果 */
	public static final String BIZ_RST = "FD00C102Z00";
	/** 本人希望 */
	public static final String PAT_DIR = "FD00C103Z00";
	/** 家族希望 */
	public static final String FMY_DIR = "FD00C104Z00";

	/** 対象年月日 */
	public static final String TRG_YMD = "FD00C105Z00";

	/** 職員　漢字名 */
	public static final String USR_NME = "FD00C106Z00";
	/** 職員　フリガナ */
	public static final String USR_ANM = "FD00C107Z00";
	/** 職員　略称 */
	public static final String USR_RYK = "FD00C108Z00";
	/** 職員　情報 */
	public static final String USR_INF = "FD00C109Z00";


}

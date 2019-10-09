package jp.ne.tbs.control.FD02.mdl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.ne.tbs.frame.AA00.MAA00B002Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.frame.DB05.MDB05T001Z00;

/**
 * <p>[クラス名]</p>
 * 　　職員情報マップ編集クラス
 * <p>[概要]</p>
 * <p>[使用方法]</p>
 * 　		MFD02M002Z00 calcObj = new MFD02M002Z00();<br>
 * 　		calcObj.setAllInOneData(super.getAllInOneData());<br>
 * 　		calcObj.execute();<br>
 * 　		calcObj.getUserMap();<br>
 * <p>[変更履歴]</p>
 * 　　2019/10/07　小嶋純史　新規作成
 */
public class MFD02M002Z00 {

	/** 	オールインワンデータ */
	private MAA00B002Z00 allInOneData = null;

	/** 職員情報Map In Map <Key:職員ID　value:項目Map<Key:キーワード　value:漢字名、フリガナ、略称>> */
	private Map<String, Map<String, String>> userMap = null;

	/**
	 * <p>[概 要] 職員情報マップ編集を実行する。</p>
	 * <p>[詳 細] 職員情報マップ編集を実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() throws Exception {

		/*********************/
		/* 業務処理用の変数Map群 */
		/*********************/
		//職員情報マップをインスタンス化(※Keyで自然ソート。)
		 userMap = new TreeMap<String, Map<String, String>>();

		//ADOより患者情報TBLを取得
		List<MDB05T001Z00> userTbls = allInOneData.getUserTbls();

		//患者情報TBLの件数分ループ処理
		for (MDB05T001Z00 userDto : userTbls) {

			//項目Map(Key:キーワード　value:漢字、フリガナ、略称)
			Map<String, String> itemMap = new HashMap<String, String>();
			itemMap.put(MAAT00.USR_NME, userDto.getFname().trim());
			itemMap.put(MAAT00.USR_ANM, userDto.getAname().trim());
			itemMap.put(MAAT00.USR_RYK, userDto.getRyak().trim());

			//職員情報マップに項目マップを格納
			userMap.put(userDto.getId().trim(), itemMap);
		}
	}

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

	/**
	 * <p>[概 要] userMap を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return userMap
	 */
	public Map<String, Map<String, String>> getUserMap() {
		return userMap;
	}

	/**
	 * <p>[概 要] userMap を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param userMap セットする userMap
	 */
	protected void setUserMap(Map<String, Map<String, String>> userMap) {
		this.userMap = userMap;
	}
}

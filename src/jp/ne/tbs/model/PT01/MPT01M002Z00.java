package jp.ne.tbs.model.PT01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.ne.tbs.frame.AA00.MAA00B002Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.frame.DB01.MDB01T001Z00;
import jp.ne.tbs.frame.DB02.MDB02T001Z00;

/**
 * <p>[クラス名]</p>
 * 　　レセプト対象一覧作成　インフル集計クラス
 * <p>[概要]</p>
 * 　以下を集計する。<br>
 * 　　①<br>
 * 　　②<br>
 * 　　③<br>
 * <p>[使用方法]</p>
 * 　		MPT01M002Z00 calcObj = new MPT01M002Z00();<br>
 * 　		calcObj.setAllInOneData(super.getAllInOneData());<br>
 * 　		calcObj.execute();<br>
 * 　		calcObj.getResultMap();<br>
 * 　		calcObj.getPatDisCnt();<br>
 * 　		calcObj.getFmyDisCnt();<br>
 * <p>[変更履歴]</p>
 * 　　2019/10/07　小嶋純史　新規作成
 */
public class MPT01M002Z00 {

	/** 	オールインワンデータ */
	private MAA00B002Z00 allInOneData = null;

	/** 処理結果Map In Map <Key:患者ID　value:項目Map<項目 名前,値>> */
	private Map<String, Map<String, String>> resultMap = null;

	/**
	 * <p>[概 要] 業務処理を実行する。</p>
	 * <p>[詳 細] 業務処理を実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() throws Exception {

		/*********************/
		/* 業務処理用の変数Map群 */
		/*********************/
		//漢字名Map<患者ID,名前>
		Map<String, String> kNameMap = new HashMap<>();
		//結果マップをインスタンス化(※Keyで自然ソート。)
		resultMap = new TreeMap<String, Map<String, String>>();

		//入力データより集計期間開始と集計期間終了を取得し、Date型に変換。
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date targetSrt = sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_SRT));
		Date targetEnd = sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_END));

		//①レセプト対象一覧作成処理
		//①－1.対象患者抽出(集計期間内に死亡含む、診療中の患者)⇒ID,名前,フリガナ,ステータス(診療中/死亡/待機)
		//ADOより患者情報TBLを取得
		List<MDB01T001Z00> ptInfoTbls = allInOneData.getPtInfoTbls();

		//患者情報TBLの件数分ループ処理
		for (MDB01T001Z00 ptInfoDto : ptInfoTbls) {

			//名前とフリガナを取得し、Mapに格納
			kNameMap.put(ptInfoDto.getId().trim(), ptInfoDto.getFname().trim());
		}

		//①－2.対象患者抽出(集計期間内に死亡含む、診療中の患者)⇒ID,名前,フリガナ,ステータス(診療中/入院中/死亡)
		//ADOより在宅履歴TBLを取得
		List<MDB02T001Z00> zaHistTbls = allInOneData.getZaHistTbls();

		//在宅履歴TBLの件数分ループ処理をしながら、対象患者Mapに設定
		for (MDB02T001Z00 zaHistDto : zaHistTbls) {

			//患者ID取得
			String targetId = zaHistDto.getId().trim();

			//項目Map(Key:キーワード　value:漢字、在宅開始日、在宅終了日)
			Map<String, String> itemMap = new HashMap<String, String>();
			//漢字を項目Mapに設定。
			itemMap.put(MAAT00.PTT_NME, kNameMap.get(targetId));

			//在宅開始日を項目Mapに設定。
			String zstDate = zaHistDto.getZstdate().trim();
			itemMap.put(MAAT00.ZAI_STR, zstDate);

			//訪問診療が開始されている場合
			//(在宅履歴TBL.在宅開始日が設定されている(空文字ではない)場合)
			if (!zstDate.equals(MAAT00.CHAR.EMPTY_STRING)) {

				//在宅履歴TBL.在宅開始日 ≦ 入力データ.集計期間終了
				Date zstDateDate = sdFormat.parse(zstDate);
				if (zstDateDate.compareTo(targetEnd) <= 0) {

					//在宅開始日を項目Mapに設定。
					String zedDate = zaHistDto.getZeddate().trim();
					itemMap.put(MAAT00.ZAI_END, zedDate);

					//在宅履歴TBL.在宅終了日が未設定(空文字)であれば、対象患者。
					if (zedDate.equals(MAAT00.CHAR.EMPTY_STRING)) {

						//処理結果マップにIDを設定
						resultMap.put(targetId, itemMap);

						//在宅履歴TBL.在宅終了日がある場合
					} else {

						//在宅履歴TBL.在宅終了日 ≧ 入力データ.集計期間開始
						Date zedDateDate = sdFormat.parse(zedDate);
						if (zedDateDate.compareTo(targetSrt) >= 0) {

							//処理結果マップにIDを設定
							resultMap.put(targetId, itemMap);
						}
					}
				}
			}
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
	 * <p>[概 要] resultMap を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return resultMap
	 */
	public Map<String, Map<String, String>> getResultMap() {
		return resultMap;
	}

	/**
	 * <p>[概 要] resultMap を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param resultMap セットする resultMap
	 */
	protected void setResultMap(Map<String, Map<String, String>> resultMap) {
		this.resultMap = resultMap;
	}
}

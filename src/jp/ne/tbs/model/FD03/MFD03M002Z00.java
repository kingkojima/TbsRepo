package jp.ne.tbs.model.FD03;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.ne.tbs.frame.AA00.MAA00B002Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.frame.DB01.MDB01T001Z00;
import jp.ne.tbs.frame.DB02.MDB02T001Z00;
import jp.ne.tbs.frame.DB03.MDB03T001Z00;

/**
 * <p>[クラス名]</p>
 * 　　カルテ汎用検索　汎用検索クラス
 * <p>[概要]</p>
 * 　以下を集計する。<br>
 * 　　①<br>
 * 　　②<br>
 * 　　③<br>
 * <p>[使用方法]</p>
 * 　		MFD03M002Z00 calcObj = new MFD03M002Z00();<br>
 * 　		calcObj.setAllInOneData(super.getAllInOneData());<br>
 * 　		calcObj.execute();<br>
 * 　		calcObj.getResultMap();<br>
 * <p>[変更履歴]</p>
 * 　　2019/10/24　小嶋純史　新規作成
 */
public class MFD03M002Z00 {

	/** 	オールインワンデータ */
	private MAA00B002Z00 allInOneData = null;

	/** 処理結果Map In Map <Key:患者ID_枝番　value:項目Map<項目 名前,値>> */
	private Map<String, Map<String, String>> resultMap = null;

	/*********************/
	/* 業務処理用の定数Map群 */
	/*********************/
	//入力項目　名前　配列
	String[] ITM_NME_LIST = {
			MAAT00.ITM_NME_1,
			MAAT00.ITM_NME_2,
			MAAT00.ITM_NME_3 };

	/**
	 * <p>[概 要] 業務処理を実行する。</p>
	 * <p>[詳 細] 業務処理を実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() throws Exception {

		/*********************/
		/* 業務処理用の変数Map群 */
		/*********************/

		//入力項目　名前　配列
		List<String> itmNmeList = new ArrayList<String>();

		//入力項目　区切り文字(始)　配列
		List<String> itmDlmList = new ArrayList<String>();

		//入力項目　区切り文字(終)　配列
		List<String> itmEndList = new ArrayList<String>();

		//漢字名Map<患者ID,名前>
		Map<String, String> kNameMap = new HashMap<String, String>();

		//フリガナMap<患者ID,フリガナ>
		Map<String, String> aNameMap = new HashMap<String, String>();

		//対象患者リスト
		List<String> targetList = new ArrayList<String>();

		//処理済みリスト(最新カルテのみを処理するために、患者IDを記録しておく)
		//患者ID + 検索文字(キーワード)
		List<String> prcssdList = new ArrayList<String>();

		//残り患者リスト（対象患者IDの中で、検索ヒットしなかった患者IDリスト）
		List<String> remainList = new ArrayList<String>();

		//処理結果マップをインスタンス化(※Keyで自然ソート。)
		resultMap = new TreeMap<String, Map<String, String>>();

		//入力データより集計期間開始と集計期間終了を取得し、Date型に変換。
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date targetSrt = sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_SRT));
		Date targetEnd = sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_END));

		//------------------------------------------------------
		//①検索文字列、区切り(開始/終了)を取得。
		//------------------------------------------------------

		//AOD.項目１名前が設定されている場合
		String s1 = allInOneData.getAppData().getMsgIn(MAAT00.ITM_NME_1);
		if (!s1.equals("検索文字１")) {
			itmNmeList.add(s1);
			itmDlmList.add(allInOneData.getAppData().getMsgIn(MAAT00.ITM_DLM_1));
			itmEndList.add(allInOneData.getAppData().getMsgIn(MAAT00.ITM_END_1));
		}
		String s2 = allInOneData.getAppData().getMsgIn(MAAT00.ITM_NME_2);
		if (!s2.equals("検索文字２")) {
			itmNmeList.add(s2);
			itmDlmList.add(allInOneData.getAppData().getMsgIn(MAAT00.ITM_DLM_2));
			itmEndList.add(allInOneData.getAppData().getMsgIn(MAAT00.ITM_END_2));
		}
		String s3 = allInOneData.getAppData().getMsgIn(MAAT00.ITM_NME_3);
		if (!s3.equals("検索文字３")) {
			itmNmeList.add(s3);
			itmDlmList.add(allInOneData.getAppData().getMsgIn(MAAT00.ITM_DLM_3));
			itmEndList.add(allInOneData.getAppData().getMsgIn(MAAT00.ITM_END_3));
		}

		//------------------------------------------------------
		//②すべての患者の「名前」と「フリガナ」を取得。
		//------------------------------------------------------

		//ADOより患者情報TBLを取得
		List<MDB01T001Z00> ptInfoTbls = allInOneData.getPtInfoTbls();
		//患者情報TBLの件数分ループ処理
		for (MDB01T001Z00 ptInfoDto : ptInfoTbls) {
			//名前とフリガナを取得し、Mapに格納
			kNameMap.put(ptInfoDto.getId().trim(), ptInfoDto.getFname().trim());
			aNameMap.put(ptInfoDto.getId().trim(), ptInfoDto.getAname().trim());
		}

		//------------------------------------------------------
		//③”集計期間”から対象患者を抽出
		//------------------------------------------------------

		//ADO.在宅履歴TBLを取得
		List<MDB02T001Z00> zaHistTbls = allInOneData.getZaHistTbls();

		//在宅履歴TBLの件数分ループ処理をしながら、対象患者Mapに設定
		for (MDB02T001Z00 zaHistDto : zaHistTbls) {

			//在宅履歴TBL.患者IDを取得
			String targetId = zaHistDto.getId().trim();

			//訪問診療が開始されている(在宅履歴TBL.在宅開始日が、
			//設定されている(空文字ではない))場合
			String zstDate = zaHistDto.getZstdate().trim();
			if (!zstDate.equals(MAAT00.CHAR.EMPTY_STRING)) {

				//在宅履歴TBL.在宅開始日 ≦ 入力データ.集計期間終了
				Date zstDateDate = sdFormat.parse(zstDate);
				if (zstDateDate.compareTo(targetEnd) <= 0) {

					//在宅履歴TBL.在宅終了日が未設定(空文字)であれば、対象患者。
					String zedDate = zaHistDto.getZeddate().trim();
					if (zedDate.equals(MAAT00.CHAR.EMPTY_STRING)) {

						//対象患者リストに患者IDを設定(同じ値は上書き)
						targetList.add(targetId);

						//在宅履歴TBL.在宅終了日がある場合
					} else {

						//在宅履歴TBL.在宅終了日 ≧ 入力データ.集計期間開始
						Date zedDateDate = sdFormat.parse(zedDate);
						if (zedDateDate.compareTo(targetSrt) >= 0) {

							//対象患者リストに患者IDを設定(同じ値は上書き)
							targetList.add(targetId);
						}
					}
				}
			}
		}

		//------------------------------------------------------
		//④診療記録より検索文字を抽出
		//------------------------------------------------------

		//対象患者リストを残り患者リストにコピー
		remainList = targetList;

		//ADOより診療記録TBLを取得
		List<MDB03T001Z00> snRecoTbls = allInOneData.getSnRecoTbls();

		//診療記録TBLのレコード分ループしながら、出力Map<ID,項目Map>に設定
		for (MDB03T001Z00 snRecoDto : snRecoTbls) {

			//診療記録TBL.患者ID を取得
			String targetId = snRecoDto.getId().trim();

			//当該レコードの患者(targetId)が対象患者リスト(targetListに含む)の場合
			if (targetList.contains(targetId)) {
//			if (targetList.contains(targetId) && targetId.equals("00004382")) {

				//当該レコードが、集計対象期間の場合
				//条件式：入力データ.集計期間開始 ≦ 診療記録TBL.FDATE ≦ 入力データ.集計期間終了
				String fDate = snRecoDto.getFdate().trim();
				Date fDateDate = sdFormat.parse(fDate);
				if (targetSrt.compareTo(fDateDate) <= 0
						&& fDateDate.compareTo(targetEnd) <= 0) {

					//記録２TBL.SUBJECT を取得
					String subject = snRecoDto.getSubject();

					//枝番の初期化(検索文字がカルテに２個以上あった場合の対策)
					int bNo = 1;

					//入力項目.検索文字 分ループ処理
					for (int i = 0; i < itmNmeList.size(); ++i) {

						//入力項目.検索文字を取得
						String itmNme = itmNmeList.get(i);

						//処理済みリスト(prcssdList)にない場合
						if (!prcssdList.contains(targetId + ITM_NME_LIST[i])) {

							//検索対象文字列に記録２TBL.SUBJECTを設定
							String targetStr1 = subject;

							//検索対象文字列に検索文字を含む場合
							while (targetStr1.contains(itmNme)) {

								//検索文字(含む)以降を取得
								int index = targetStr1.indexOf(itmNme);
								String targetStr2 = targetStr1.substring(index);

								//TODO 本来はここで区切文字(始)を読み込んで検索し切り出すが今後実装。

								//区切文字(終)まで切り出し
								String itmEnd = itmEndList.get(i);
								int indexEnd = targetStr2.indexOf(itmEnd);
								String result = MAAT00.CHAR.EMPTY_STRING;
								//区切文字(終)が見つからない場合。
								if (indexEnd < 0) {
									int full = targetStr2.length();
									if(full>30) {
										result = targetStr2.substring(0, 30);
									} else {
										result = targetStr2;
									}
								} else {
									//区切文字(終)が見つかった時は、検索文字～区切文字(終)までを切り出す。
									result = targetStr2.substring(0, indexEnd);
								}

								//項目Map(Key:キーワード　value:漢字、フリガナ、検索結果)
								Map<String, String> itemMap = new HashMap<String, String>();
								//漢字、フリガナ、検索結果を項目Mapに設定。
								itemMap.put(MAAT00.PTT_NME, kNameMap.get(targetId));
								itemMap.put(MAAT00.PTT_ANM, aNameMap.get(targetId));
								itemMap.put(ITM_NME_LIST[i], result);

								//処理結果マップに項目マップを設定
								resultMap.put(targetId + "_" + bNo, itemMap);

								//枝番を追加
								bNo++;

								//処理済みリストに患者ID+検索文字(キーワード)を設定
								prcssdList.add(targetId + ITM_NME_LIST[i]);

								//残り患者リストから、対象患者を削除
								int tIdx = remainList.indexOf(targetId);
								if(tIdx > 0) {
									remainList.remove(remainList.indexOf(targetId));
								}

								//検索対象文字列に残りの文字列を設定
								System.out.println(targetId + "_" + bNo);

								//終了文字が見つからない場合
								if(indexEnd<0) {
									targetStr1 = targetStr2.substring(itmNme.length());
								} else {
									targetStr1 = targetStr2.substring(indexEnd);
								}
							}
						}
					}
				}
			}
		}

		//------------------------------------------------------
		//⑤検索にヒットしなかったIDを処理結果マップに設定
		//------------------------------------------------------

		for(String remainId : remainList) {

			//項目Map(Key:キーワード　value:漢字、フリガナ)
			Map<String, String> itemMap = new HashMap<String, String>();
			//漢字、フリガナ、検索結果を項目Mapに設定。
			itemMap.put(MAAT00.PTT_NME, kNameMap.get(remainId));
			itemMap.put(MAAT00.PTT_ANM, aNameMap.get(remainId));

			//処理結果マップに項目マップを設定
			resultMap.put(remainId + "_1", itemMap);
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

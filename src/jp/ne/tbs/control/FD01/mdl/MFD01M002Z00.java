package jp.ne.tbs.control.FD01.mdl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.ne.tbs.frame.AA00.MAA00B002Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.frame.AA00.MAAW00;
import jp.ne.tbs.frame.DB01.MDB01T001Z00;
import jp.ne.tbs.frame.DB02.MDB02T001Z00;
import jp.ne.tbs.frame.DB03.MDB03T001Z00;

/**
 * <p>[クラス名]</p>
 * 　　集計開始日、集計終了日　インフル集計クラス
 * <p>[概要]</p>
 * 　以下を集計する。<br>
 * 　　①<br>
 * 　　②<br>
 * 　　③<br>
 * <p>[使用方法]</p>
 * 　		MFD01M002Z00 calcObj = new MFD01M002Z00();<br>
 * 　		calcObj.setAllInOneData(super.getAllInOneData());<br>
 * 　		calcObj.execute();<br>
 * 　		calcObj.getResultMap();<br>
 * 　		calcObj.getPatDisCnt();<br>
 * 　		calcObj.getFmyDisCnt();<br>
 * <p>[変更履歴]</p>
 * 　　2019/10/07　小嶋純史　新規作成
 */
public class MFD01M002Z00 {

	/** 	オールインワンデータ */
	private MAA00B002Z00 allInOneData = null;

	/** 処理結果Map In Map <Key:患者ID　value:項目Map<項目 名前,値>> */
	private Map<String, Map<String, String>> resultMap = null;

	/** 本人希望カウント */
	private int patDisCnt = 0;

	/** 本人以外希望カウント */
	private int fmyDisCnt = 0;

	/*********************/
	/* 業務処理用の定数Map群 */
	/*********************/
	//入力項目　名前　配列
	String[] ITM_NME_LIST = {
			MAAT00.ITM_NME_1,
			MAAT00.ITM_NME_2,
			MAAT00.ITM_NME_3,
			MAAT00.ITM_NME_4,
			MAAT00.ITM_NME_5,
			MAAT00.ITM_NME_6,
			MAAT00.ITM_NME_7,
			MAAT00.ITM_NME_8,
			MAAT00.ITM_NME_9,
			MAAT00.ITM_NME_10 };

	//入力項目　区切り文字　配列
	String[] ITM_DLM_LIST = {
			MAAT00.ITM_DLM_1,
			MAAT00.ITM_DLM_2,
			MAAT00.ITM_DLM_3,
			MAAT00.ITM_DLM_4,
			MAAT00.ITM_DLM_5,
			MAAT00.ITM_DLM_6,
			MAAT00.ITM_DLM_7,
			MAAT00.ITM_DLM_8,
			MAAT00.ITM_DLM_9,
			MAAT00.ITM_DLM_10 };

	//入力項目　終了文字　配列
	String[] ITM_END_LIST = {
			MAAT00.ITM_END_1,
			MAAT00.ITM_END_2,
			MAAT00.ITM_END_3,
			MAAT00.ITM_END_4,
			MAAT00.ITM_END_5,
			MAAT00.ITM_END_6,
			MAAT00.ITM_END_7,
			MAAT00.ITM_END_8,
			MAAT00.ITM_END_9,
			MAAT00.ITM_END_10 };

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
		//フリガナMap<患者ID,フリガナ>
		Map<String, String> aNameMap = new HashMap<String, String>();
		//処理済みリスト
		List<String> prcssdList = new ArrayList<String>();
		//結果マップをインスタンス化(※Keyで自然ソート。)
		resultMap = new TreeMap<String, Map<String, String>>();

		//入力データより集計期間開始と集計期間終了を取得し、Date型に変換。
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date targetSrt = sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_SRT));
		Date targetEnd = sdFormat.parse(allInOneData.getAppData().getMsgIn(MAAT00.DCP_END));

		//①インフル希望リスト作成処理
		//①－1.対象患者抽出(集計期間内に死亡含む、診療中の患者)⇒ID,名前,フリガナ,ステータス(診療中/死亡/待機)
		//ADOより患者情報TBLを取得
		List<MDB01T001Z00> ptInfoTbls = allInOneData.getPtInfoTbls();

		//患者情報TBLの件数分ループ処理
		for (MDB01T001Z00 ptInfoDto : ptInfoTbls) {

			//名前とフリガナを取得し、Mapに格納
			kNameMap.put(ptInfoDto.getId().trim(), ptInfoDto.getFname().trim());
			aNameMap.put(ptInfoDto.getId().trim(), ptInfoDto.getAname().trim());
		}

		//①－2.対象患者抽出(集計期間内に死亡含む、診療中の患者)⇒ID,名前,フリガナ,ステータス(診療中/入院中/死亡)
		//ADOより在宅履歴TBLを取得
		List<MDB02T001Z00> zaHistTbls = allInOneData.getZaHistTbls();

		//在宅履歴TBLの件数分ループ処理をしながら、対象患者Mapに設定
		for (MDB02T001Z00 zaHistDto : zaHistTbls) {

			//患者ID取得
			String targetId = zaHistDto.getId().trim();

			//項目Map(Key:キーワード　value:漢字、フリガナ、項目１～１０)
			Map<String, String> itemMap = new HashMap<String, String>();
			//漢字、フリガナを項目Mapに設定。
			itemMap.put(MAAT00.PTT_NME, kNameMap.get(targetId));
			itemMap.put(MAAT00.PTT_ANM, aNameMap.get(targetId));

			//訪問診療が開始されている場合
			//(在宅履歴TBL.在宅開始日が設定されている(空文字ではない)場合)
			String zstDate = zaHistDto.getZstdate().trim();
			if (!zstDate.equals(MAAT00.CHAR.EMPTY_STRING)) {

				//在宅履歴TBL.在宅開始日 ≦ 入力データ.集計期間終了
				Date zstDateDate = sdFormat.parse(zstDate);
				if (zstDateDate.compareTo(targetEnd) <= 0) {

					//在宅履歴TBL.在宅終了日が未設定(空文字)であれば、対象患者。
					String zedDate = zaHistDto.getZeddate().trim();
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

		//①－３.対象患者の診療記録抽出(全診療タイプ、期間指定の中で、"/*インフルエンザ希望希望"を含む最新の診療記録)⇒ID,診療記録,医師ID,診療タイプ
		//ADOより診療記録TBLを取得
		List<MDB03T001Z00> snRecoTbls = allInOneData.getSnRecoTbls();

		//診療記録TBLのレコード分ループしながら、出力Map<ID,項目Map>に設定
		for (MDB03T001Z00 snRecoDto : snRecoTbls) {

			//診療記録TBL.ID を取得
			String targetId = snRecoDto.getId().trim();

			//当該レコードの患者(targetId)が出力対象患者(resultMapに含む)の場合
			//かつ、処理済みリスト(prcssdList)にない場合
			if (resultMap.containsKey(targetId) && !prcssdList.contains(targetId)) {
				//			if (resultMap.containsKey(targetId) && !prcssdList.contains(targetId)
				//					&& targetId.equals("XXXXXXXX")) {

				//当該レコードが、集計対象期間の場合
				//条件式：入力データ.集計期間開始 ≦ 診療記録TBL.FDATE ≦ 入力データ.集計期間終了
				String fDate = snRecoDto.getFdate().trim();
				Date fDateDate = sdFormat.parse(fDate);
				if (targetSrt.compareTo(fDateDate) <= 0
						&& fDateDate.compareTo(targetEnd) <= 0) {

					//記録２TBL.SUBJECT に "/*インフルエンザ希望希望" を含む場合
					String title = allInOneData.getAppData().getMsgIn(MAAT00.ITM_NME_1);
					String subject = snRecoDto.getSubject();
					if (subject.contains(title)) {

						//インフルエンザ希望の入力内容を取得
						int index = subject.indexOf(title);
						String targetStr = subject.substring(index);

						//以下、入力項目.名前配列分ループ
						for (int i = 0; i < ITM_NME_LIST.length; i++) {

							//項目１　項目名　取得
							String nme1 = allInOneData.getAppData().getMsgIn(ITM_NME_LIST[i]);

							//項目名が(※１)空文字ではなくかつ、対象文字列内にある場合
							//※１）入力項目.名前が設定されていないかった場合(拡張分)の考慮。
							if (!nme1.equals(MAAT00.CHAR.EMPTY_STRING)
									&& targetStr.contains(nme1)) {

								//格納用結果を定義
								String result1 = MAAT00.CHAR.EMPTY_STRING;
								//項目１　区切り文字　取得
								String dlm1 = allInOneData.getAppData().getMsgIn(ITM_DLM_LIST[i]);
								//項目１　終了文字　取得
								String end1 = allInOneData.getAppData().getMsgIn(ITM_END_LIST[i]);
								//終了文字のインデックスを定義
								int indexEnd1 = 0;

								//区切り文字が設定されている場合
								if (!dlm1.equals(MAAT00.CHAR.EMPTY_STRING)) {

									//区切り文字のインデックスを取得
									int indexDlm1 = targetStr.indexOf(dlm1);
									//区切り文字を含めた文字列長を算出
									indexDlm1 += dlm1.length();
									//区切り文字以降の文字列を取得
									targetStr = targetStr.substring(indexDlm1);
									//終了文字のインデックスを取得
									indexEnd1 = targetStr.indexOf(end1);

									//カルテが改行無しで終わっている場合の対応
									if (indexEnd1 == -1) {
										//残りの文字をそのまま取得
										result1 = targetStr;
									} else {
										//終了文字以前の文字列を取得
										result1 = targetStr.substring(0, indexEnd1);
									}
									//区切り文字が設定されていない場合
								} else {

									//項目名のインデックスを取得
									int indexNme1 = targetStr.indexOf(nme1);
									//項目名を含めた文字列長を取得
									indexNme1 += nme1.length();
									//終了文字のインデックスを取得
									indexEnd1 = targetStr.indexOf(end1);
									//項目名以降、終了文字以前の文字列を取得
									result1 = targetStr.substring(indexNme1, indexEnd1);
								}

								//TODO テスト用 標準出力 格納文字列
//								System.out.println("格納文字⇒" + targetId + "：" + nme1 + "："
//										+ result1.replaceFirst("^[\\h]+", "").replaceFirst("[\\h]+$", ""));

								//処理結果マップ.項目マップに項目名と値を格納
								String val = result1.replaceFirst("^[\\h]+", "").replaceFirst("[\\h]+$", "");
								resultMap.get(targetId).put(ITM_NME_LIST[i], val);

								//最新の(最初に格納の)記録レコードのみを処理するため、
								//処理済み(結果格納済)のIDを処理済みリストに記憶しておく。
								prcssdList.add(targetId);

								//集計行用カウント
								if (ITM_NME_LIST[i].equals(MAAT00.ITM_NME_1)) {
									if (val.equals("あり")) {
										patDisCnt++;
									}
								}

								if (ITM_NME_LIST[i].equals(MAAT00.ITM_NME_2)) {
									if (!val.equals("無し")) {
										String removed = val.replace("人", MAAT00.CHAR.EMPTY_STRING);
										try {
											//人数を数値変換
											fmyDisCnt += Integer.parseInt(removed);
										} catch (NumberFormatException e) {
											//人数入力エラー
											allInOneData.getCa().setWarningCode(targetId + "の" + MAAW00.WFD00A001);
											continue;
										}
										//System.out.println("ID：" + targetId + "　　トータル：" + fmyDisCnt + "　　追加：" + Integer.parseInt(removed));
									}
								}

								//終了文字を含めた文字列長を算出
								indexEnd1 += end1.length();

								//残りの文字列長を取得
								int targetStrLen = targetStr.length();

								//まだ読み込む行がある場合
								if (targetStrLen > indexEnd1) {

									//さらにもう１つ分の改行を飛ばす。
									//　→カスタムウィザードでは項目と項目の間に空行が必ず入るため。
									indexEnd1 += MAAT00.CHAR.CRLF.length();
								}
								try {
									//終了文字以降の文字列を取得し、次の処理に渡す
									targetStr = targetStr.substring(indexEnd1);
								} catch (StringIndexOutOfBoundsException e) {
									//入力エラー
									allInOneData.getCa().setWarningCode(targetId + "の" + MAAW00.WFD00A001);
									continue;
								}
							}
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

	/**
	 * <p>[概 要] patDisCnt を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return patDisCnt
	 */
	public int getPatDisCnt() {
		return patDisCnt;
	}

	/**
	 * <p>[概 要] patDisCnt を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param patDisCnt セットする patDisCnt
	 */
	protected void setPatDisCnt(int patDisCnt) {
		this.patDisCnt = patDisCnt;
	}

	/**
	 * <p>[概 要] fmyDisCnt を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return fmyDisCnt
	 */
	public int getFmyDisCnt() {
		return fmyDisCnt;
	}

	/**
	 * <p>[概 要] fmyDisCnt を設定する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @param fmyDisCnt セットする fmyDisCnt
	 */
	protected void setFmyDisCnt(int fmyDisCnt) {
		this.fmyDisCnt = fmyDisCnt;
	}

}

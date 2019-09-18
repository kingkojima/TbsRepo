package jp.ne.tbs.control.FD01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import jp.ne.tbs.frame.AA00.MAA00B006Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.frame.DB01.MDB01T001Z00;
import jp.ne.tbs.frame.DB02.MDB02T001Z00;

/**
 * <p>[クラス名]</p>
 * 　　インフルエンザ予防接種希望集計　業務処理クラス
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2019/09/17　小嶋純史　新規作成
 */
public class MFD01B004Z00 extends MAA00B006Z00 {

	/**
	 * <p>[概 要] 業務処理を実行する。</p>
	 * <p>[詳 細] 業務処理を実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() throws Exception {

		//漢字名Map(ID,名前)
		HashMap<String, String> kNameMap = new HashMap<String, String>();
		//フリガナMap(ID,フリガナ)
		HashMap<String, String> aNameMap = new HashMap<String, String>();
		//対象患者Map(ID,フリガナ)
		HashMap<String, String> targetMap = new HashMap<String, String>();

		//入力データより集計期間開始と集計期間終了を取得し、Date型に変換。
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/mm/dd");
		Date targetSrt = sdFormat.parse(super.getAllInOneData().getAppData().getMsgIn(MAAT00.DCP_SRT));
		Date targetEnd = sdFormat.parse(super.getAllInOneData().getAppData().getMsgIn(MAAT00.DCP_END));

		//①インフル希望リスト作成処理
		//①－1.対象患者抽出(集計期間内に死亡含む、診療中の患者)⇒ID,名前,フリガナ,ステータス(診療中/入院中/死亡)
		//ADOより患者情報TBLを取得
		List<MDB01T001Z00> ptInfoTbls = super.getAllInOneData().getPtInfoTbls();

		//患者情報TBLの件数分ループ処理
		for (MDB01T001Z00 ptInfoDto : ptInfoTbls) {

			//名前とフリガナを取得し、Mapに格納
			kNameMap.put(ptInfoDto.getId(), ptInfoDto.getFname());
			aNameMap.put(ptInfoDto.getId(), ptInfoDto.getAname());
		}

		//①－2.対象患者抽出(集計期間内に死亡含む、診療中の患者)⇒ID,名前,フリガナ,ステータス(診療中/入院中/死亡)
		//ADOより在宅履歴TBLを取得
		List<MDB02T001Z00> zaHistTbls = super.getAllInOneData().getZaHistTbls();

		//在宅履歴TBLの件数分ループ処理をしながら、対象患者Mapに設定
		for (MDB02T001Z00 zaHistDto : zaHistTbls) {

			//在宅履歴TBL.在宅開始日 ＜ 入力データ.集計期間終了
			Date zstDate = sdFormat.parse(zaHistDto.getZstdate());
			if (zstDate.compareTo(targetEnd) <= 0) {

				//在宅履歴TBL.在宅終了日が未設定(空文字)であれば、対象患者。
				String zedDate = zaHistDto.getZeddate().trim();
				if (zedDate.equals(MAAT00.CHAR.EMPTY_STRING)) {


				//在宅履歴TBL.在宅終了日がある場合
				} else {

					//在宅履歴TBL.在宅終了日 ＞ 入力データ.集計期間開始
					Date zedDateDate = sdFormat.parse(zedDate);
					if (zedDateDate.compareTo(targetSrt) >= 0) {

					}
				}
			}

		}

		//①－３.対象患者の診療記録抽出(全診療タイプ、期間指定の中で、"/*インフルエンザ希望希望"を含む最新の診療記録)⇒ID,診療記録,医師ID,診療タイプ

		//①－４.対象診療記録の解析(項目名で文字列検索し、区切り文字後を取得、値の形式で格納)し、帳票データに格納

		//②データチェック
		//②－１.空データ、数値不備

		//③集計処理
		//③－１.特定の(数値/文字列)項目をカウントし、帳票データに格納

	}

}

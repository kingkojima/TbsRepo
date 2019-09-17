package jp.ne.tbs.frame.AA00;

import java.util.List;

import jp.ne.tbs.frame.DB01.MDB01A001Z00;
import jp.ne.tbs.frame.DB01.MDB01T001Z00;
import jp.ne.tbs.frame.DB02.MDB02A001Z00;
import jp.ne.tbs.frame.DB02.MDB02T001Z00;
import jp.ne.tbs.frame.DB03.MDB03A001Z00;
import jp.ne.tbs.frame.DB03.MDB03T001Z00;

/**
 * <p>[クラス名]</p>
 * 　　業務メインフレームワーク
 * <p>[概要]</p>
 * 　　AOD作成及び、業務メインのフレームワーク。抽象クラス。
 * <p>[変更履歴]</p>
 * 　　2019/09/12　小嶋純史　新規作成
 */
public abstract class MAA00B001Z00 {

	/** 	オールインワンデータ */
	MAA00B002Z00 allInOneData = null;

	/**
	 * <p>[概 要] 業務メインフレームワークを実行する。</p>
	 * <p>[詳 細] 継承不可</p>
	 * <p>[備 考] </p>
	 * @param appData セットする
	 */
	public final void execute(MAA00B003Z00 appData) {

		//AODをインスタンス化
		allInOneData = new MAA00B002Z00();
		//アプリデータを設定
		allInOneData.setAppData(appData);

		//トランザクションチェックを実行(要継承)
		this.doTrxChk(allInOneData);

		//マスターデータ取得を実行(継承不可)
		this.doGetMst(allInOneData);

		//マスターチェックを実行(要継承)
		this.doMstChk(allInOneData);

		//業務コントロールを実行(要継承)
		this.doBizCtl(allInOneData);

		//帳票編集コントロールを実行(要継承)
		this.doEdtCtl(allInOneData);

		//作業ログ出力(今後実装予定)

	}

	/**
	 * <p>[概 要] トランザクションをチェックする</p>
	 * <p>[詳 細] 継承必須</p>
	 * <p>[備 考] </p>
	 * @param allInOneData セットする
	 */
	public abstract void doTrxChk(MAA00B002Z00 allInOneData) ;

	/**
	 * <p>[概 要] マスターデータを取得する。</p>
	 * <p>[詳 細] 継承不可</p>
	 * <p>[備 考] </p>
	 * @param allInOneData セットする
	 */
	private void doGetMst(MAA00B002Z00 allInOneData) {

//		System.out.println("AOD設定開始！");

		//患者情報TBL
		MDB01A001Z00 patientDao = new MDB01A001Z00();
    	List<MDB01T001Z00> patientDtoList = patientDao.findAll();
    	allInOneData.setPtInfoTbls(patientDtoList);
//        for (DB01T001Z00 patientDto: patientDtoList) {
//            System.out.println(patientDto.getId());
//        }

        //在宅履歴TBL
		MDB02A001Z00 patient1Dao = new MDB02A001Z00();
    	List<MDB02T001Z00> patient1DtoList = patient1Dao.findAll();
    	allInOneData.setZaHistTbls(patient1DtoList);
//        for (DB02T001Z00 patient1Dto: patient1DtoList) {
//            System.out.println(patient1Dto.getId());
//        }

        //診療記録TBL
		MDB03A001Z00 patientKkiroku2Dao = new MDB03A001Z00();
    	List<MDB03T001Z00> patientKkiroku2DtoList = patientKkiroku2Dao.findAll();
    	allInOneData.setSnRecoTbls(patientKkiroku2DtoList);
//        for (DB03T001Z00 patientKkiroku2Dto: patientKkiroku2DtoList) {
//            System.out.println(patientKkiroku2Dto.getId());
//            System.out.println(patientKkiroku2Dto.getFdate());
//        }

//    		System.out.println("AOD設定終わり！");
	}

	/**
	 * <p>[概 要] マスターチェックを実行する</p>
	 * <p>[詳 細] 継承必須</p>
	 * <p>[備 考] </p>
	 * @param allInOneData セットする
	 */
	public abstract void doMstChk(MAA00B002Z00 allInOneData) ;

	/**
	 * <p>[概 要] 業務コントロールを実行する</p>
	 * <p>[詳 細] 継承必須</p>
	 * <p>[備 考] </p>
	 * @param allInOneData セットする
	 */
	public abstract void doBizCtl(MAA00B002Z00 allInOneData) ;

	/**
	 * <p>[概 要] 帳票編集コントロールを実行する</p>
	 * <p>[詳 細] 継承必須</p>
	 * <p>[備 考] </p>
	 * @param allInOneData セットする
	 */
	public abstract void doEdtCtl(MAA00B002Z00 allInOneData) ;

	/**
	 * <p>[概 要] allInOneData を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return allInOneData
	 */
	public MAA00B002Z00 getAllInOneData() {
		return allInOneData;
	}

}

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
 * 　　AOD作成及び、業務メインのフレームワーク
 * <p>[変更履歴]</p>
 * 　　2019/09/12　小嶋純史　新規作成
 */
public class MAA00B001Z00 {

	/** 	オールインワンデータ */
	MAA00B002Z00 allInOneData = null;

	public void execute() {

		System.out.println("AOD設定開始！");

		allInOneData = new MAA00B002Z00();

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

        System.out.println("AOD設定終わり！");

	}

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

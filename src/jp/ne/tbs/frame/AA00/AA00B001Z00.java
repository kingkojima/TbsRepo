package jp.ne.tbs.frame.AA00;

import java.util.List;

import jp.ne.tbs.frame.DB01.DB01A001Z00;
import jp.ne.tbs.frame.DB01.DB01T001Z00;
import jp.ne.tbs.frame.DB02.DB02A001Z00;
import jp.ne.tbs.frame.DB02.DB02T001Z00;
import jp.ne.tbs.frame.DB03.DB03A001Z00;
import jp.ne.tbs.frame.DB03.DB03T001Z00;

//AOD作成及び、業務メインのフレームワーク
public class AA00B001Z00 {

	AA00B002Z00 allInOneData = null;

	public void execute() {

		System.out.println("AOD設定開始！");

		allInOneData = new AA00B002Z00();

		//患者情報TBL
		DB01A001Z00 patientDao = new DB01A001Z00();
    	List<DB01T001Z00> patientDtoList = patientDao.findAll();
    	allInOneData.setPtInfoTbls(patientDtoList);
//        for (DB01T001Z00 patientDto: patientDtoList) {
//            System.out.println(patientDto.getId());
//        }

        //在宅履歴TBL
		DB02A001Z00 patient1Dao = new DB02A001Z00();
    	List<DB02T001Z00> patient1DtoList = patient1Dao.findAll();
    	allInOneData.setZaHistTbls(patient1DtoList);
//        for (DB02T001Z00 patient1Dto: patient1DtoList) {
//            System.out.println(patient1Dto.getId());
//        }

        //診療記録TBL
		DB03A001Z00 patientKkiroku2Dao = new DB03A001Z00();
    	List<DB03T001Z00> patientKkiroku2DtoList = patientKkiroku2Dao.findAll();
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
	public AA00B002Z00 getAllInOneData() {
		return allInOneData;
	}

}

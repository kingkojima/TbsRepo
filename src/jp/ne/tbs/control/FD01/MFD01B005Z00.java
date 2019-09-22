package jp.ne.tbs.control.FD01;

import java.awt.Component;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jp.ne.tbs.frame.AA00.MAA00B003Z00;
import jp.ne.tbs.frame.AA00.MAA00B007Z00;
import jp.ne.tbs.frame.AA00.MAA00B008Z00;
import jp.ne.tbs.frame.AA00.MAAT00;

/**
 * <p>[クラス名]</p>
 * 　　インフルエンザ予防接種希望集計　帳票編集コントロールクラス
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2019/09/17　小嶋純史　新規作成
 */
public class MFD01B005Z00 extends MAA00B007Z00 {

	//入力項目　名前　配列
	private String[] ITM_NME_LIST = {
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

	//もろもろ設定
	/* 可変項目以外のタイトル列(ID、漢字名、フリガナ) */
	private int VAR_COL = 3;
	/* 表の値が開始する行 */
	private int DATA_ROW = 2;

	/**
	 * <p>[概 要] 帳票編集コントロールを実行する。</p>
	 * <p>[詳 細] 帳票編集コントロールを実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() {

		System.out.println("帳票編集が始まったぜい！");

		// ワークブック
		XSSFWorkbook workBook = null;
		// シート
		XSSFSheet sheet = null;
		// 出力ファイル
		FileOutputStream outPutFile = null;
		// 出力ファイルパス
		String outPutFilePath = null;
		// 出力ファイル名
		String outPutFileName = null;

		// エクセルファイルの作成
		try {

			// ワークブックの作成
			workBook = new XSSFWorkbook();

			// シートの設定
			sheet = workBook.createSheet();
			workBook.setSheetName(0, "インフル希望");
			sheet = workBook.getSheet("インフル希望");

			//=======================
			//=タイトルの作成=============
			//=======================

			// 初期行の作成(行番号は0から始まる)
			XSSFRow row = sheet.createRow(0);

			// 「タイトル」のセルスタイル設定(セル番号は0から始まる)
			XSSFCellStyle titleCellStyle = workBook.createCellStyle();
			XSSFCell cell = row.createCell(0);
			XSSFFont titleFont = workBook.createFont();
			titleFont.setFontName("ＭＳ ゴシック");
			titleFont.setFontHeightInPoints((short) 18);
			titleFont.setUnderline(XSSFFont.U_SINGLE);
			titleCellStyle.setFont(titleFont);
			cell.setCellStyle(titleCellStyle);

			// セルに「タイトル」を設定
			cell.setCellValue("2019年　インフルエンザワクチン接種希望　集計表");

			//=======================
			//=表の作成=================
			//=======================

			// 「表のヘッダ」のセルスタイル設定
			XSSFCellStyle headerCellStyle = workBook.createCellStyle();
			XSSFFont headerFont = workBook.createFont();
			headerFont.setFontName("ＭＳ ゴシック");
			headerFont.setFontHeightInPoints((short) 12);
			headerCellStyle.setFont(headerFont);
			headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
			headerCellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.index);
			headerCellStyle.setBorderTop(BorderStyle.MEDIUM);
			headerCellStyle.setBorderBottom(BorderStyle.MEDIUM);
			headerCellStyle.setBorderRight(BorderStyle.MEDIUM);
			headerCellStyle.setBorderLeft(BorderStyle.MEDIUM);

			// セルに「表のヘッダ」を設定
			row = sheet.createRow(1);

			//「表のヘッダ」の列数を計算(ID,名前,フリガナ,項目１～１０)
			int hedColCnt = ITM_NME_LIST.length + VAR_COL;

			//アプリデータ取得
			MAA00B003Z00 appData = super.getAllInOneData().getAppData();

			// 「表のヘッダ」の横を出力
			for (int i = 0, j = -VAR_COL; i < hedColCnt; i++, j++) {
				cell = row.createCell(i);
				cell.setCellStyle(headerCellStyle);
				if (i == 0) {
					cell.setCellValue("ID");
				} else if (i == 1) {
					cell.setCellValue("名前");
				} else if (i == 2) {
					cell.setCellValue("フリガナ");
				} else {
					cell.setCellValue(appData.getMsgIn(ITM_NME_LIST[j]));
				}
			}

			// 「表の値」のセルスタイル設定
			XSSFCellStyle resultCellStyle = workBook.createCellStyle();
			XSSFFont resultFont = workBook.createFont();
			resultFont.setFontName("ＭＳ ゴシック");
			resultFont.setFontHeightInPoints((short) 12);
			resultCellStyle.setFont(resultFont);
			resultCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			resultCellStyle.setAlignment(HorizontalAlignment.CENTER);
			resultCellStyle.setFillForegroundColor(IndexedColors.WHITE.index);
			resultCellStyle.setBorderTop(BorderStyle.MEDIUM);
			resultCellStyle.setBorderBottom(BorderStyle.MEDIUM);
			resultCellStyle.setBorderRight(BorderStyle.MEDIUM);
			resultCellStyle.setBorderLeft(BorderStyle.MEDIUM);

			//ログアウト取得
			MAA00B008Z00 logout = super.getAllInOneData().getLogOut();
			@SuppressWarnings({ "unchecked"})
			Map<String, Map<String, String>> resultMap = (Map<String, Map<String, String>>) logout
					.getResultMap(MAAT00.BIZ_RESULT);

			// セルに値を設定
			int roopCnt = 0 + DATA_ROW;
			for (Map.Entry<String, Map<String, String>> entry : resultMap.entrySet()) {

				//処理する行を取得
				row = sheet.createRow(roopCnt);

				//患者IDを取得
				String pId = entry.getKey();
				//項目Mapを取得
				Map<String, String> itemMap = entry.getValue();

				for (int i = 0, j = -VAR_COL; i < hedColCnt; i++, j++) {
					cell = row.createCell(i);
					cell.setCellStyle(resultCellStyle);
					if (i == 0) {
						cell.setCellValue(pId);
					} else if (i == 1) {
						cell.setCellValue(itemMap.get(MAAT00.PTT_NME));
					} else if (i == 2) {
						cell.setCellValue(itemMap.get(MAAT00.PTT_ANM));
					} else {
						cell.setCellValue(itemMap.get(ITM_NME_LIST[j]));
					}
				}
				// 次の行の処理
				roopCnt++;
			}

			// 集計行の出力
			row = sheet.createRow(roopCnt);
			cell = row.createCell(0);
			cell.setCellValue("集計");
			cell = row.createCell(3);
			cell.setCellValue((Integer)logout.getResultMap(MAAT00.PAT_DIR));
			cell = row.createCell(4);
			cell.setCellValue((Integer)logout.getResultMap(MAAT00.FMY_DIR));

			//=======================
			//=最終調整=================
			//=======================
			//タイトル行以外の列幅を自動調節
			for (int i = 1; i < hedColCnt; i++) {
				sheet.autoSizeColumn(i, true);
			}

			//ウィンドウ枠の固定
			sheet.createFreezePane(0, 2, 0, 2);

			//印刷設定
			PrintSetup printSetup =sheet.getPrintSetup();
			printSetup.setPaperSize(PrintSetup.A4_PAPERSIZE);
			//縦(false)印刷
			printSetup.setLandscape(false);
			//横１枚
			printSetup.setFitHeight((short)5);
			//横１枚
			printSetup.setFitWidth((short)5);

			// エクセルファイルを出力
			try {

				// 現在の日付を取得
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

				//ファイルパス・ファイル名の指定
				outPutFilePath = System.getProperty("user.home") + "/Desktop/";
				outPutFileName = "インフル希望集計_" + dateFormat.format(date).toString() + ".xlsx";

				// エクセルファイルを出力
				outPutFile = new FileOutputStream(outPutFilePath + outPutFileName);
				workBook.write(outPutFile);

				System.out.println("「" + outPutFilePath + outPutFileName + "」を出力しました。");

			} catch (IOException e) {
				System.out.println(e.toString());
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		System.out.println("帳票編集が終わったぜい！");

		JOptionPane.showConfirmDialog((Component)null, "ﾃﾞｽｸﾄｯﾌﾟに集計表ができたンゴ", "集計完了", -1, 1);

	}
}

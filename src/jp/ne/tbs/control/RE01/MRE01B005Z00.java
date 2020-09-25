package jp.ne.tbs.control.RE01;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import jp.ne.tbs.frame.AA00.MAA00B007Z00;
import jp.ne.tbs.frame.AA00.MAA00B008Z00;
import jp.ne.tbs.frame.AA00.MAAE00;
import jp.ne.tbs.frame.AA00.MAAT00;

/**
 * <p>[クラス名]</p>
 * 　　新患受付カナ検索　画面編集コントロールクラス
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2019/09/17　小嶋純史　新規作成
 */
public class MRE01B005Z00 extends MAA00B007Z00 {

	//もろもろ設定
	/* リスト(行)数の定数宣言(ヘッダー含む) */
	private int LIST_MAX_ROW = 80;
	/* リスト(列)数の定数宣言 */
	private int LIST_MAX_COL = 3;

	/**
	 * <p>[概 要] 帳票編集コントロールを実行する。</p>
	 * <p>[詳 細] 帳票編集コントロールを実装する</p>
	 * <p>[備 考] </p>
	 */
	public void execute() {

		// ワークブック
		Workbook workBook = null;
		// シート
		SXSSFSheet sheet = null;
		// 出力ファイル
		FileOutputStream outPutFile = null;
		// 出力ファイルパス
		String outPutFilePath = null;
		// 出力ファイル名
		String outPutFileName = null;

		// エクセルファイルの作成
		try {

			// ワークブックの作成
			workBook = new SXSSFWorkbook();

			// シートの設定
			sheet = (SXSSFSheet)workBook.createSheet();
			workBook.setSheetName(0, "レセプト対象");
			sheet = (SXSSFSheet)workBook.getSheet("レセプト対象");

			//=======================
			//=表の作成=================
			//=======================

			// 現在の処理行数を保持する変数
			int currentRow = 0;
			// 現在の処理列数を保持する変数
			int currentCol = 0;
			// 現在の処理ページ数を保持する変数
			int currentPage = 0;

			//　現在の処理行オブジェクトと処理列オブジェクトを取得
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);

			//ログアウト取得
			MAA00B008Z00 logout = super.getAllInOneData().getLogOut();
			@SuppressWarnings({ "unchecked" })
			Map<String, Map<String, String>> resultMap = (Map<String, Map<String, String>>) logout
					.getResultMap(MAAT00.BIZ_RST);

			// レセプト対象患者リストの件数分ループ
			int listCnt = 1;
			for (Map.Entry<String, Map<String, String>> entry : resultMap.entrySet()) {

				// リスト件数が１ではなく、かつ ÷80 の商が1の時（改列処理）
				if((listCnt != 1)&&(listCnt % LIST_MAX_ROW == 1)) {

					// 現在の処理行数をリセット
					currentRow = 0;
					// 現在の処理列数をインクリメント +1
					currentCol++;

					// 現在の処理列数が3の場合(改頁処理)
					if(currentCol == LIST_MAX_COL) {

						//　現在の処理ページ数をインクリメント
						currentPage++;
						// 現在の処理列数をリセット 0
						currentCol = 0;
					}
				}

				// リスト件数が 1  もしくは  ÷ 80 の商が1の時
				if((listCnt == 1)||(listCnt % LIST_MAX_ROW == 1)) {

					// 「表のヘッダ」のセルスタイル設定
					CellStyle headerCellStyle = workBook.createCellStyle();
					Font headerFont = workBook.createFont();
					headerFont.setFontName("ＭＳ ゴシック");
					headerFont.setFontHeightInPoints((short) 8.5);
					headerCellStyle.setFont(headerFont);
					headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
					headerCellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.index);
					headerCellStyle.setBorderTop(BorderStyle.THIN);
					headerCellStyle.setBorderBottom(BorderStyle.THIN);
					headerCellStyle.setBorderRight(BorderStyle.THIN);
					headerCellStyle.setBorderLeft(BorderStyle.THIN);

					// ヘッダー設定(ID,氏名,開始年月日,終了年月日)
					if(currentCol == 0) {
						row = sheet.createRow(currentRow + currentPage * 81);
					} else {
						row = sheet.getRow(currentRow + currentPage * 81);
					}

					cell = row.createCell(0 + currentCol * 4);
					cell.setCellStyle(headerCellStyle);
					cell.setCellValue("ID");
					cell = row.createCell(1 + currentCol * 4);
					cell.setCellStyle(headerCellStyle);
					cell.setCellValue("氏名");
					cell = row.createCell(2 + currentCol * 4);
					cell.setCellStyle(headerCellStyle);
					cell.setCellValue("開始年月日");
					cell = row.createCell(3 + currentCol * 4);
					cell.setCellStyle(headerCellStyle);
					cell.setCellValue("終了年月日");

					//行の高さを設定
					row.setHeight((short)205);

					// 現在の処理行数をインクリメント
					currentRow++;
				}

				// 「表の値」のセルスタイル設定
				CellStyle resultCellStyleR = workBook.createCellStyle();
				Font resultFont = workBook.createFont();
				resultFont.setFontName("ＭＳ ゴシック");
				resultFont.setFontHeightInPoints((short) 8.5);
				resultCellStyleR.setFont(resultFont);
				resultCellStyleR.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				resultCellStyleR.setAlignment(HorizontalAlignment.RIGHT);
				resultCellStyleR.setVerticalAlignment(VerticalAlignment.CENTER);
				resultCellStyleR.setFillForegroundColor(IndexedColors.WHITE.index);
				resultCellStyleR.setBorderTop(BorderStyle.THIN);
				resultCellStyleR.setBorderBottom(BorderStyle.THIN);
				resultCellStyleR.setBorderRight(BorderStyle.THIN);
				resultCellStyleR.setBorderLeft(BorderStyle.THIN);

				CellStyle resultCellStyleL = workBook.createCellStyle();
				resultCellStyleL.setFont(resultFont);
				resultCellStyleL.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				resultCellStyleL.setAlignment(HorizontalAlignment.LEFT);
				resultCellStyleL.setVerticalAlignment(VerticalAlignment.CENTER);
				resultCellStyleL.setFillForegroundColor(IndexedColors.WHITE.index);
				resultCellStyleL.setBorderTop(BorderStyle.THIN);
				resultCellStyleL.setBorderBottom(BorderStyle.THIN);
				resultCellStyleL.setBorderRight(BorderStyle.THIN);
				resultCellStyleL.setBorderLeft(BorderStyle.THIN);

				//患者IDを取得
				String pId = entry.getKey();
//				System.out.println(pId);
				Pattern p = Pattern.compile("^0+([0-9]+.*)");
				Matcher m = p.matcher(pId);
				//項目Mapを取得
				Map<String, String> itemMap = entry.getValue();

				// ID,氏名,開始年月日,終了年月日を出力
				if(currentCol == 0) {
					row = sheet.createRow(currentRow + currentPage * 81);
				} else {
					row = sheet.getRow(currentRow + currentPage * 81);
				}

				cell = row.createCell(0 + currentCol * 4);
				cell.setCellStyle(resultCellStyleR);
				if(m.matches()) {
					cell.setCellValue(m.group(1));
				} else {
					cell.setCellValue(pId);
				}
				cell = row.createCell(1 + currentCol * 4);
				cell.setCellValue(itemMap.get(MAAT00.PTT_NME).replace("　", MAAT00.CHAR.BLANK));
				cell.setCellStyle(resultCellStyleL);
				cell = row.createCell(2 + currentCol * 4);
				cell.setCellStyle(resultCellStyleR);
				cell.setCellValue(itemMap.get(MAAT00.ZAI_STR));
				cell = row.createCell(3 + currentCol * 4);
				cell.setCellStyle(resultCellStyleR);
				cell.setCellValue(itemMap.get(MAAT00.ZAI_END));

				//行の高さを設定
				row.setHeight((short)205);

				// 現在の行のインクリメント
				currentRow++;

				// 次の行の処理
				listCnt++;
			}

			//=======================
			//=最終調整=================
			//=======================
			//タイトル行以外の列幅を調節
			sheet.setColumnWidth(0, 4*256);
			sheet.setColumnWidth(1, 10*256);
			sheet.setColumnWidth(2, 8*256);
			sheet.setColumnWidth(3, 8*256);
			sheet.setColumnWidth(4, 4*256);
			sheet.setColumnWidth(5, 10*256);
			sheet.setColumnWidth(6, 8*256);
			sheet.setColumnWidth(7, 8*256);
			sheet.setColumnWidth(8, 4*256);
			sheet.setColumnWidth(9, 10*256);
			sheet.setColumnWidth(10, 8*256);
			sheet.setColumnWidth(11, 8*256);

			//印刷設定
			//上余白(0.5)
			sheet.setMargin(Sheet.TopMargin, 0.197);
			//下余白(0.5)
			sheet.setMargin(Sheet.BottomMargin, 0.197);
			//右余白(0.5)
			sheet.setMargin(Sheet.RightMargin, 0.197);
			//左余白(0.5)
			sheet.setMargin(Sheet.LeftMargin, 0.197);

			PrintSetup printSetup = sheet.getPrintSetup();
			printSetup.setPaperSize(PrintSetup.A4_PAPERSIZE);
			//縦(false)印刷
			printSetup.setLandscape(false);
			//印刷倍率
			printSetup.setScale((short) 99);
			//ヘッダーフッター余白設定
			printSetup.setHeaderMargin(0.0);
			printSetup.setFooterMargin(0.0);

			// エクセルファイルを出力
			try {

				// 現在の日付を取得
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

				//ファイルパス・ファイル名の指定
				outPutFilePath = System.getProperty("user.home") + "/Desktop/";
				outPutFileName = "レセプト対象一覧_" + dateFormat.format(date).toString() + ".xlsx";

				try {
					// エクセルファイルを出力
					outPutFile = new FileOutputStream(outPutFilePath + outPutFileName);
				} catch (FileNotFoundException e) {
					super.getAllInOneData().getCa().setBussnesErrCode(MAAE00.EFD00A004);
					e.printStackTrace();
					return;
				}
				workBook.write(outPutFile);

//				System.out.println("「" + outPutFilePath + outPutFileName + "」を出力しました。");

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

//		System.out.println("帳票編集が終わったぜい！");

		JOptionPane.showConfirmDialog((Component) null, "デスクトップにレセプト一覧が出来ました。", "作成完了", -1, 1);

	}
}

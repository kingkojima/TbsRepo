package jp.ne.tbs.view.RE01;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import com.github.lgooddatepicker.components.DatePicker;

import jp.ne.tbs.frame.AA00.JTextFieldEx;

public class MRE01V002Z00 {

	/** テキストフィールド */
	private JTextFieldEx text_3_5;
	private JTextFieldEx text_3_7;

	protected void execute(MRE01V001Z00 obj, int LOW_PAT_INF) {

		//１行目
		JLabel label_1 = new JLabel("新患受付（非がん患者様用）");
		label_1.setFont(new Font("メイリオ", Font.BOLD, 36));
		label_1.setPreferredSize(MRE01V001Z00.LAYOUT_10BY2);
		label_1.setHorizontalAlignment(JLabel.CENTER);
		obj.addComp(label_1, 0, 0, 11, 1);

		//２行目(改行のための空白文字)
		JLabel label_2 = new JLabel("　");
		label_2.setFont(new Font("メイリオ", Font.PLAIN, 15));
		obj.addComp(label_2, 0, 1, 11, 1);

		//３行目
		//受付日　ラベル
		JLabel label_3_1 = new JLabel("<HTML><U>受付日</U></HTML>");
		label_3_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_3_1.setForeground(Color.BLUE);
		label_3_1.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_3_1.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_3_1, 1, 2, 1, 1);

		//受付日　テキスト
		DatePicker datePicker1 = new DatePicker();
		datePicker1.setDateToToday();
		datePicker1.setFont(new Font("メイリオ", Font.PLAIN, 17));
		datePicker1.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		obj.addComp(datePicker1, 2, 2, 1, 1);

		//受付者　ラベル
		JLabel label_3_4 = new JLabel("<HTML><U>受付者</U></HTML>");
		label_3_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_3_4.setForeground(Color.BLUE);
		label_3_4.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_3_4.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_3_4, 5, 2, 1, 1);

		//受付者　テキスト
		text_3_5 = new JTextFieldEx(8,0,100,JTextFieldEx.IM_HIRAGANA);
		text_3_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_3_5.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		obj.addComp(text_3_5, 6, 2, 1, 1);

		//担当　ラベル
		JLabel label_3_6 = new JLabel("担当");
		label_3_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_3_6.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_3_6.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_3_6, 7, 2, 1, 1);

		//担当　テキスト
		text_3_7 = new JTextFieldEx(8,0,100,JTextFieldEx.IM_HIRAGANA);
		text_3_7.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_3_7.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		obj.addComp(text_3_7, 8, 2, 1, 1);

		//４行目(改行のための空白文字)
		JLabel label_4 = new JLabel("　");
		label_4.setFont(new Font("メイリオ", Font.PLAIN, 10));
		obj.addComp(label_4, 0, 3, 11, 1);

	}

	/**
	 * <p>[概 要] text_3_5 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_3_5
	 */
	protected JTextFieldEx getText_3_5() {
		return text_3_5;
	}

	/**
	 * <p>[概 要] text_3_7 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_3_7
	 */
	protected JTextFieldEx getText_3_7() {
		return text_3_7;
	}

}

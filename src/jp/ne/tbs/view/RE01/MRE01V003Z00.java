package jp.ne.tbs.view.RE01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import jp.ne.tbs.frame.AA00.JTextFieldEx;

/**
 * <p>[クラス名]</p>
 *	 　　新患受付（非がん患者様用）　メイン画面　患者情報
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 *	 　　2020/08/21　小嶋純史　新規作成
 */
public class MRE01V003Z00 {

	/** テキストフィールド */
	private JTextFieldEx text_5_3;
	private JFormattedTextField text_5_5;
	private JTextFieldEx text_6_2;
	private JFormattedTextField text_6_6;
	private JTextField text_6_8;
	private JFormattedTextField text_7_2;
	private JTextField text_7_4;
	private JFormattedTextField text_8_4;
	private JFormattedTextField text_8_6;

	/** コンボボックス */
	private JComboBox<?> combo_6_4;
	private JComboBox<?> combo_8_2;

	/** ボタン */
	JButton button_4;
	JButton button_5;

	/** コンボボックスのデータ */
	private String[] comb_6_4 = { "", "男", "女" };
	private String[] comb_8_2 = { "", "有り", "無し" };

	protected void execute(MRE01V001Z00 obj, int LOW_PAT_INF) {

		//５行目
		JLabel label_5_1 = new JLabel("①患者情報");
		label_5_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_5_1.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_5_1.setHorizontalAlignment(JLabel.LEFT);
		obj.addComp(label_5_1, 0, LOW_PAT_INF, 1, 1);

		//フリガナ ラベル
		JLabel label_5_2 = new JLabel("<HTML><U>フリガナ</U></HTML>");
		label_5_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_5_2.setForeground(Color.BLUE);
		label_5_2.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_5_2.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_5_2, 1, LOW_PAT_INF, 1, 1);

		//フリガナ　テキスト
		text_5_3 = new JTextFieldEx(8, 0, 40, JTextFieldEx.IM_HALFKANA);
		text_5_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_5_3.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		obj.addComp(text_5_3, 2, LOW_PAT_INF, 1, 1);

		//カナ検索ボタン
		button_4 = new JButton("検索");
		button_4.addActionListener(obj);
		button_4.setFont(new Font("メイリオ", Font.PLAIN, 12));
		button_4.setPreferredSize(MRE01V001Z00.LAYOUT_05BY1);
		button_4.setActionCommand("grp_fnm_btn");
		obj.addComp(button_4, 3, LOW_PAT_INF, 1, 1);

		//カルテID ラベル
		JLabel label_5_4 = new JLabel("カルテID");
		label_5_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_5_4.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_5_4.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_5_4, 4, LOW_PAT_INF, 1, 1);

		//カルテID テキスト
		DecimalFormat df = new DecimalFormat("0");
		df.setMaximumIntegerDigits(8);
		df.setMinimumIntegerDigits(8);
		text_5_5 = new JFormattedTextField(df);
		text_5_5.setColumns(8);
		text_5_5.addActionListener(obj);
		text_5_5.setActionCommand("pat_inf_pid");
		text_5_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_5_5.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		obj.addComp(text_5_5, 5, LOW_PAT_INF, 1, 1);

		//カルテID検索
		button_5 = new JButton("検索");
		button_5.addActionListener(obj);
		button_5.setFont(new Font("メイリオ", Font.PLAIN, 12));
		button_5.setPreferredSize(MRE01V001Z00.LAYOUT_05BY1);
		button_5.setActionCommand("grp_pid_btn");
		obj.addComp(button_5, 6, LOW_PAT_INF, 1, 1);

		//６行目
		JLabel label_6_1 = new JLabel("氏名");
		label_6_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_6_1.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_6_1.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_6_1, 1, LOW_PAT_INF + 1, 1, 1);

		//氏名　テキスト
		text_6_2 = new JTextFieldEx(8, 0, 100, JTextFieldEx.IM_HIRAGANA);
		text_6_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_6_2.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		obj.addComp(text_6_2, 2, LOW_PAT_INF + 1, 1, 1);

		JLabel label_6_3 = new JLabel("<HTML><U>性別</U></HTML>");
		label_6_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_6_3.setForeground(Color.BLUE);
		label_6_3.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_6_3.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_6_3, 3, LOW_PAT_INF + 1, 1, 1);

		combo_6_4 = new JComboBox<>(comb_6_4);
		combo_6_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		combo_6_4.setPreferredSize(new Dimension(118, 38));
		combo_6_4.addActionListener(obj);
		combo_6_4.setActionCommand("sex");
		obj.addComp(combo_6_4, 4, LOW_PAT_INF + 1, 1, 1);

		JLabel label_6_5 = new JLabel("<HTML><U>生年月日</U></HTML>");
		label_6_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_6_5.setForeground(Color.BLUE);
		label_6_5.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_6_5.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_6_5, 5, LOW_PAT_INF + 1, 1, 1);

		//生年月日 テキスト
		MaskFormatter mfPtBrth = null;
		try {
			mfPtBrth = new MaskFormatter("U##/##/##");
			mfPtBrth.setPlaceholderCharacter('_');
		} catch (ParseException pe) {
		}
		text_6_6 = new JFormattedTextField(mfPtBrth);
		text_6_6.setColumns(7);
		text_6_6.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_6_6.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		text_6_6.addActionListener(obj);
		text_6_6.setActionCommand("pat_inf_bth");
		text_6_6.addKeyListener(obj);
		text_6_6.setFocusTraversalKeysEnabled(false);
		obj.addComp(text_6_6, 6, LOW_PAT_INF + 1, 1, 1);

		JLabel label_6_7 = new JLabel("年齢");
		label_6_7.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_6_7.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_6_7.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_6_7, 7, LOW_PAT_INF + 1, 1, 1);

		text_6_8 = new JTextField("");
		text_6_8.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_6_8.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		obj.addComp(text_6_8, 8, LOW_PAT_INF + 1, 1, 1);

		JLabel label_6_9 = new JLabel("歳");
		label_6_9.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_6_9.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_6_9.setHorizontalAlignment(JLabel.LEFT);
		obj.addComp(label_6_9, 9, LOW_PAT_INF + 1, 1, 1);

		//７行目
		JLabel label_7_1 = new JLabel("〒");
		label_7_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_7_1.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_7_1.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_7_1, 1, LOW_PAT_INF + 2, 1, 1);

		//郵便番号 テキスト
		MaskFormatter mfPost = null;
		try {
			mfPost = new MaskFormatter(" ###-####");
			mfPost.setPlaceholderCharacter('_');
		} catch (ParseException pe) {
		}
		text_7_2 = new JFormattedTextField(mfPost);
		text_7_2.setColumns(8);
		text_7_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_7_2.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		obj.addComp(text_7_2, 2, LOW_PAT_INF + 2, 1, 1);

		//住所ラベル
		JLabel label_7_3 = new JLabel("住所");
		label_7_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_7_3.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_7_3.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_7_3, 3, LOW_PAT_INF + 2, 1, 1);

		//住所テキスト
		text_7_4 = new JTextFieldEx(37, 0, 100, JTextFieldEx.IM_HIRAGANA);
		text_7_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_7_4.setPreferredSize(MRE01V001Z00.LAYOUT_5BY1);
		obj.addComp(text_7_4, 4, LOW_PAT_INF + 2, 5, 1);

		//８行目
		JLabel label_8_1 = new JLabel("駐車場");
		label_8_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_8_1.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_8_1.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_8_1, 1, LOW_PAT_INF + 3, 1, 1);

		//駐車場 リスト
		combo_8_2 = new JComboBox<>(comb_8_2);
		combo_8_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		combo_8_2.setPreferredSize(new Dimension(118, 38));
		combo_8_2.addActionListener(obj);
		combo_8_2.setActionCommand("parking");
		obj.addComp(combo_8_2, 2, LOW_PAT_INF + 3, 1, 1);

		//電話番号 ラベル
		JLabel label_8_3 = new JLabel("電話番号");
		label_8_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_8_3.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_8_3.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_8_3, 3, LOW_PAT_INF + 3, 1, 1);

		//電話番号　テキスト
		MaskFormatter mfPtPhone = null;
		try {
			mfPtPhone = new MaskFormatter("###-###-####");
			mfPtPhone.setPlaceholderCharacter('_');
		} catch (ParseException pe) {
		}
		text_8_4 = new JFormattedTextField(mfPtPhone);
		text_8_4.setFont(new Font("メイリオ", Font.PLAIN, 15));
		text_8_4.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		obj.addComp(text_8_4, 4, LOW_PAT_INF + 3, 1, 1);

		//携帯番号 ラベル
		JLabel label_8_5 = new JLabel("携帯番号");
		label_8_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_8_5.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		label_8_5.setHorizontalAlignment(JLabel.RIGHT);
		obj.addComp(label_8_5, 5, LOW_PAT_INF + 3, 1, 1);

		//携帯番号　テキスト
		MaskFormatter mfPtMobile = null;
		try {
			mfPtMobile = new MaskFormatter("###-####-####");
			mfPtMobile.setPlaceholderCharacter('_');
		} catch (ParseException pe) {
		}
		text_8_6 = new JFormattedTextField(mfPtMobile);
		text_8_6.setFont(new Font("メイリオ", Font.PLAIN, 15));
		text_8_6.setPreferredSize(MRE01V001Z00.LAYOUT_1BY1);
		obj.addComp(text_8_6, 6, LOW_PAT_INF + 3, 1, 1);

		//９行目(改行のための空白文字)
		JLabel label_9 = new JLabel("　");
		label_9.setFont(new Font("メイリオ", Font.PLAIN, 10));
		obj.addComp(label_9, 0, LOW_PAT_INF + 4, 11, 1);

	}

	/**
	 * <p>[概 要] text_5_3 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_5_3
	 */
	protected JTextFieldEx getText_5_3() {
		return text_5_3;
	}

	/**
	 * <p>[概 要] text_5_5 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_5_5
	 */
	protected JFormattedTextField getText_5_5() {
		return text_5_5;
	}

	/**
	 * <p>[概 要] text_6_2 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_6_2
	 */
	protected JTextFieldEx getText_6_2() {
		return text_6_2;
	}

	/**
	 * <p>[概 要] combo_6_4 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return combo_6_4
	 */
	protected JComboBox<?> getCombo_6_4() {
		return combo_6_4;
	}

	/**
	 * <p>[概 要] text_6_6 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_6_6
	 */
	protected JFormattedTextField getText_6_6() {
		return text_6_6;
	}

	/**
	 * <p>[概 要] text_6_8 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_6_8
	 */
	protected JTextField getText_6_8() {
		return text_6_8;
	}

	/**
	 * <p>[概 要] text_7_2 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_7_2
	 */
	protected JFormattedTextField getText_7_2() {
		return text_7_2;
	}

	/**
	 * <p>[概 要] text_7_4 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_7_4
	 */
	protected JTextField getText_7_4() {
		return text_7_4;
	}

	/**
	 * <p>[概 要] combo_8_2 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return combo_8_2
	 */
	protected JComboBox<?> getCombo_8_2() {
		return combo_8_2;
	}

	/**
	 * <p>[概 要] text_8_4 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_8_4
	 */
	protected JFormattedTextField getText_8_4() {
		return text_8_4;
	}

	/**
	 * <p>[概 要] text_8_6 を取得する。</p>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 * @return text_8_6
	 */
	protected JFormattedTextField getText_8_6() {
		return text_8_6;
	}

}

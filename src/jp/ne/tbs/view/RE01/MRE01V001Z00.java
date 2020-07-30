package jp.ne.tbs.view.RE01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import jp.ne.tbs.frame.AA00.JTextFieldEx;
import jp.ne.tbs.frame.AA00.MAAT00;

/**
 * <p>[クラス名]</p>
 * 　　新患受付（非がん患者様用）　メイン画面
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2020/02/06　小嶋純史　新規作成
 */
public class MRE01V001Z00 extends JFrame implements ActionListener,KeyListener {

	/** 部品群 */
	private JPanel panel;
	private GridBagLayout gblayout;
	private GridBagConstraints gbc;

	/** 開始行定義 */
	protected static int LOW_HAD_INF = 0;
	protected static int LOW_PAT_INF = 4;
	private int LOW_CON_INF = 9;
	private int LOW_INT_INF = 13;
	private int LOW_DIS_NME = 16;
	private int LOW_CRT_LOC = 21;
	private int LOW_VST_PLC = 23;
	private int LOW_LEF_MCN = 25;
	private int LOW_REQ_CON = 27;
	private int LOW_CRT_ADL = 31;
	private int LOW_INT_LTR = 38;
	private int LOW_URG_REP = 40;
	private int LOW_MED_TTM = 42;
	private int LOW_NUR_CAR = 47;
	private int LOW_FAM_BKG = 51;
	private int LOW_SOC_CON = 56;
	private int LOW_PUB_BUR = 59;
	private int LOW_SER_USG = 62;
	private int LOW_ACC_TSF = 65;

	/** レイアウトサイズ  10 × 2  タイトル */
	static Dimension LAYOUT_10BY2 = new Dimension(1200, 60);
	/** レイアウトサイズ   1 × 1   ラベル、テキスト */
	static Dimension LAYOUT_1BY1 = new Dimension(120, 40);
	/** レイアウトサイズ   2 × 1   ボタン */
	static Dimension LAYOUT_2BY1 = new Dimension(240, 40);
	/** レイアウトサイズ   3 × 1   ラベル、テキスト */
	static Dimension LAYOUT_3BY1 = new Dimension(360, 40);
	/** レイアウトサイズ   5 × 1   テキスト */
	static Dimension LAYOUT_5BY1 = new Dimension(600, 40);
	/** レイアウトサイズ   8 × 1   コンボボックス */
	static Dimension LAYOUT_8BY1 = new Dimension(960, 40);
	/** レイアウトサイズ   1 × 0.5   ラベル、テキスト */
	static Dimension LAYOUT_1BY05 = new Dimension(120, 20);

	/** テキストフィールド */
	JTextField text_3_2;
	JTextFieldEx text_3_5;
	JTextFieldEx text_3_7;
	JTextFieldEx text_5_3;
	JFormattedTextField text_5_5;
	JTextFieldEx text_6_2;
	JFormattedTextField text_6_6;
	JTextField text_6_8;
	JFormattedTextField text_7_2;
	JTextField text_7_4;
	JFormattedTextField text_8_4;
	JFormattedTextField text_8_6;
	JTextField text_10_3;
	JTextField text_10_5;
	JTextFieldEx text_11_2;
	JTextField text_11_4;
	JTextField text_12_2;
	JTextField text_14_3;
	JTextField text_14_5;
	JTextField text_14_7;
	JTextField text_15_2;
	JTextField text_18_3;
	JTextField text_18_4;
	JTextField text_18_5;
	JTextField text_18_6;
	JTextField text_18_7;
	JTextField text_19_3;
	JTextField text_19_4;
	JTextField text_19_5;
	JTextField text_19_6;
	JTextField text_19_7;
	JTextField text_20_3;
	JTextField text_20_4;
	JTextField text_20_5;
	JTextField text_20_6;
	JTextField text_20_7;
	JTextField text_22_5;
	JTextField text_22_7;
	JTextField text_26_2;
	JTextField text_26_6;
	JTextField text_34_1;
	JTextField text_35_2;
	JTextField text_35_4;
	JTextField text_35_6;
	JTextField text_36_2;
	JTextField text_37_2;
	JTextField text_39_5;
	JTextField text_39_7;
	JTextField text_43_4;
	JTextField text_43_5;
	JTextField text_44_4;
	JTextField text_45_2;
	JTextField text_46_2;
	JTextField text_49_2;
	JTextField text_49_5;
	JTextField text_50_2;
	JTextField text_53_8;
	JTextField text_54_5;
	JTextField text_55_3;
	JTextField text_57_5;
	JTextField text_59_3;
	JTextField text_60_3;
	JTextField text_60_6;
	JTextField text_62_3;
	JTextField text_62_5;
	JTextField text_63_2;
	JTextField text_63_4;
	JTextField text_65_3;

	/** コンボボックス */
	JComboBox<?> combo_6_4;
	JComboBox<?> combo_8_2;
	JComboBox<?> combo_32_5;
	JComboBox<?> combo_44_2;
	JComboBox<?> combo_44_6;
	JComboBox<?> combo_48_3;

	/** コンボボックスのデータ */
//	String[] comb_6_4 = { "", "男", "女" };
//	String[] comb_8_2 = { "", "有り", "無し" };
	String[] comb_32_5 = { "", "自立", "見守り", "軽介助", "一部介助", "全介助" };
	String[] comb_44_2 = { "", "胃瘻", "経鼻" };
	String[] comb_44_6 = { "", "星医療酸器", "サイサン", "エアウォーター", "テイジン", "その他" };
	String[] comb_48_3 = { "", "要介護５", "要介護４", "要介護３", "要介護２", "要介護５" };

	/** チェックボックス */
	JCheckBox check_22_2;
	JCheckBox check_22_3;
	JCheckBox check_22_6;
	JCheckBox check_24_2;
	JCheckBox check_24_3;
	JCheckBox check_24_4;
	JCheckBox check_24_5;
	JCheckBox check_28_2;
	JCheckBox check_28_4;
	JCheckBox check_29_2;
	JCheckBox check_32_2;
	JCheckBox check_32_3;
	JCheckBox check_32_6;
	JCheckBox check_32_7;
	JCheckBox check_32_8;
	JCheckBox check_33_1;
	JCheckBox check_35_1;
	JCheckBox check_37_1;
	JCheckBox check_37_3;
	JCheckBox check_39_2;
	JCheckBox check_39_3;
	JCheckBox check_39_4;
	JCheckBox check_39_6;
	JCheckBox check_41_2;
	JCheckBox check_41_3;
	JCheckBox check_41_4;
	JCheckBox check_41_5;
	JCheckBox check_43_2;
	JCheckBox check_43_7;
	JCheckBox check_44_1;
	JCheckBox check_44_3;
	JCheckBox check_45_1;
	JCheckBox check_45_3;
	JCheckBox check_45_4;
	JCheckBox check_45_5;
	JCheckBox check_46_1;
	JCheckBox check_48_4;
	JCheckBox check_48_5;
	JCheckBox check_48_6;
	JCheckBox check_49_3;
	JCheckBox check_53_4;
	JCheckBox check_53_5;
	JCheckBox check_53_6;
	JCheckBox check_53_7;
	JCheckBox check_54_1;
	JCheckBox check_54_2;
	JCheckBox check_54_3;
	JCheckBox check_54_4;
	JCheckBox check_55_1;
	JCheckBox check_55_2;
	JCheckBox check_56_2;
	JCheckBox check_56_3;
	JCheckBox check_56_4;
	JCheckBox check_56_5;
	JCheckBox check_56_6;
	JCheckBox check_57_1;
	JCheckBox check_57_2;
	JCheckBox check_57_3;
	JCheckBox check_57_4;
	JCheckBox check_59_2;
	JCheckBox check_59_5;
	JCheckBox check_59_6;
	JCheckBox check_60_1;
	JCheckBox check_60_5;
	JCheckBox check_62_2;
	JCheckBox check_62_4;
	JCheckBox check_63_1;
	JCheckBox check_63_3;

	/** テキストエリア */
	JTextArea tArea_30_1;
	JTextArea tArea_30_2;
	JTextArea tArea_53_2;

	/** 登録ボタン */
	JButton button_1;
	/** 修正ボタン */
	JButton button_2;
	/** 削除ボタン */
	JButton button_3;

	/**
	 * <p>[概 要] </p>
	 * 　新患受付　実行メソッド<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	public static void exec() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MRE01V001Z00 fluFrame = new MRE01V001Z00();
				fluFrame.setVisible(true);
			}
		});
	}

	/**
	 * <p>[概 要] </p>
	 * 　汎用検索　コンストラクタ<BR>
	 * <p>[詳 細] </p>
	 * 　画面のレイアウトを作成する。
	 * <p>[備 考] </p>
	 */
	public MRE01V001Z00() {

		//画面設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 770);
		setTitle("新患受付(非がん)");

		//パネル,GBL,GBCを生成。
		panel = new JPanel();
		gblayout = new GridBagLayout();
		gbc = new GridBagConstraints();
		panel.setLayout(gblayout);

		//========================================================
		//====　ヘッダー部　===========================================
		//========================================================

		MRE01V002Z00 hadObj = new MRE01V002Z00();
		hadObj.execute(this,LOW_HAD_INF);
		text_3_5 = hadObj.getText_3_5();
		text_3_7 = hadObj.getText_3_7();

		//========================================================
		//====　患者情報　===========================================
		//========================================================

		MRE01V003Z00 pstObj = new MRE01V003Z00();
		pstObj.execute(this,LOW_PAT_INF);

		text_5_3 = pstObj.getText_5_3();
		text_5_5 = pstObj.getText_5_5();
		text_6_2 = pstObj.getText_6_2();
		combo_6_4 = pstObj.getCombo_6_4();
		text_6_6 = pstObj.getText_6_6();
		text_6_8 = pstObj.getText_6_8();
		text_7_2 = pstObj.getText_7_2();
		text_7_4 = pstObj.getText_7_4();
		combo_8_2 = pstObj.getCombo_8_2();
		text_8_4 = pstObj.getText_8_4();
		text_8_6 = pstObj.getText_8_6();

		//========================================================
		//====　相談者情報　=========================================
		//========================================================

		//１０行目
		JLabel label_10_1 = new JLabel("②相談者情報");
		label_10_1.setFont(new Font("メイリオ", Font.PLAIN, 20));
		label_10_1.setPreferredSize(LAYOUT_1BY1);
		label_10_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_10_1, 0, LOW_CON_INF, 1, 1);

		JLabel label_10_2 = new JLabel("氏名");
		label_10_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_10_2.setPreferredSize(LAYOUT_1BY1);
		label_10_2.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_10_2, 1, LOW_CON_INF, 1, 1);

		text_10_3 = new JTextField("");
		text_10_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_10_3.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_10_3, 2, LOW_CON_INF, 1, 1);

		JLabel label_10_4 = new JLabel("続柄");
		label_10_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_10_4.setPreferredSize(LAYOUT_1BY1);
		label_10_4.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_10_4, 3, LOW_CON_INF, 1, 1);

		text_10_5 = new JTextField("");
		text_10_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_10_5.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_10_5, 4, LOW_CON_INF, 1, 1);

		//１１行目
		JLabel label_11_1 = new JLabel("住所");
		label_11_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_11_1.setPreferredSize(LAYOUT_1BY1);
		label_11_1.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_11_1, 1, LOW_CON_INF + 1, 1, 1);

		//住所 テキスト
		text_11_2 = new JTextFieldEx(37,0,100,JTextFieldEx.IM_HIRAGANA);
		text_11_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_11_2.setPreferredSize(LAYOUT_5BY1);
		this.addComp(text_11_2, 2, LOW_CON_INF + 1, 5, 1);

		JLabel label_11_3 = new JLabel("電話番号");
		label_11_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_11_3.setPreferredSize(LAYOUT_1BY1);
		label_11_3.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_11_3, 7, LOW_CON_INF + 1, 1, 1);

		text_11_4 = new JTextField("");
		text_11_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_11_4.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_11_4, 8, LOW_CON_INF + 1, 2, 1);

		//１２行目
		JLabel label_12_1 = new JLabel("携帯番号");
		label_12_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_12_1.setPreferredSize(LAYOUT_1BY1);
		label_12_1.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_12_1, 7, LOW_CON_INF + 2, 1, 1);

		text_12_2 = new JTextField("");
		text_12_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_12_2.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_12_2, 8, LOW_CON_INF + 2, 2, 1);

		//１３行目(改行のための空白文字)
		JLabel label_13 = new JLabel("　");
		label_13.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_13, 0, LOW_CON_INF + 3, 11, 1);

		//========================================================
		//====　紹介者情報　=========================================
		//========================================================

		//１４行目
		JLabel label_14_1 = new JLabel("③紹介者情報");
		label_14_1.setFont(new Font("メイリオ", Font.PLAIN, 20));
		label_14_1.setPreferredSize(LAYOUT_1BY1);
		label_14_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_14_1, 0, LOW_INT_INF, 1, 1);

		JLabel label_14_2 = new JLabel("職種");
		label_14_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_14_2.setPreferredSize(LAYOUT_1BY1);
		label_14_2.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_14_2, 1, LOW_INT_INF, 1, 1);

		text_14_3 = new JTextField("");
		text_14_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_14_3.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_14_3, 2, LOW_INT_INF, 1, 1);

		JLabel label_14_4 = new JLabel("氏名");
		label_14_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_14_4.setPreferredSize(LAYOUT_1BY1);
		label_14_4.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_14_4, 3, LOW_INT_INF, 1, 1);

		text_14_5 = new JTextField("");
		text_14_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_14_5.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_14_5, 4, LOW_INT_INF, 1, 1);

		JLabel label_14_6 = new JLabel("電話番号");
		label_14_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_14_6.setPreferredSize(LAYOUT_1BY1);
		label_14_6.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_14_6, 5, LOW_INT_INF, 1, 1);

		text_14_7 = new JTextField("");
		text_14_7.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_14_7.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_14_7, 6, LOW_INT_INF, 2, 1);

		//１５行目
		JLabel label_15_1 = new JLabel("所属");
		label_15_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_15_1.setPreferredSize(LAYOUT_1BY1);
		label_15_1.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_15_1, 1, LOW_INT_INF + 1, 1, 1);

		text_15_2 = new JTextField("");
		text_15_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_15_2.setPreferredSize(LAYOUT_5BY1);
		this.addComp(text_15_2, 2, LOW_INT_INF + 1, 5, 1);

		//１６行目(改行のための空白文字)
		JLabel label_16 = new JLabel("　");
		label_16.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_16, 0, LOW_INT_INF + 2, 11, 1);

		//========================================================
		//====　病名　==============================================
		//========================================================

		//１７行目
		JLabel label_17_2 = new JLabel("病名");
		label_17_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_17_2.setPreferredSize(LAYOUT_1BY1);
		label_17_2.setHorizontalAlignment(JLabel.CENTER);
		this.addComp(label_17_2, 2, LOW_DIS_NME, 1, 1);

		JLabel label_17_3 = new JLabel("発症");
		label_17_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_17_3.setPreferredSize(LAYOUT_1BY1);
		label_17_3.setHorizontalAlignment(JLabel.CENTER);
		this.addComp(label_17_3, 3, LOW_DIS_NME, 1, 1);

		JLabel label_17_4 = new JLabel("かかりつけ病院");
		label_17_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_17_4.setPreferredSize(LAYOUT_2BY1);
		label_17_4.setHorizontalAlignment(JLabel.CENTER);
		this.addComp(label_17_4, 4, LOW_DIS_NME, 2, 1);

		JLabel label_17_5 = new JLabel("担当医");
		label_17_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_17_5.setPreferredSize(LAYOUT_1BY1);
		label_17_5.setHorizontalAlignment(JLabel.CENTER);
		this.addComp(label_17_5, 6, LOW_DIS_NME, 1, 1);

		JLabel label_17_6 = new JLabel("入院・外来、往診頻度、治療内容");
		label_17_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_17_6.setPreferredSize(LAYOUT_3BY1);
		label_17_6.setHorizontalAlignment(JLabel.CENTER);
		this.addComp(label_17_6, 7, LOW_DIS_NME, 3, 1);

		//１８行目
		JLabel label_18_1 = new JLabel("④病名");
		label_18_1.setFont(new Font("メイリオ", Font.PLAIN, 20));
		label_18_1.setPreferredSize(LAYOUT_1BY1);
		label_18_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_18_1, 0, LOW_DIS_NME + 1, 1, 1);

		JLabel label_18_2 = new JLabel("#1");
		label_18_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_18_2.setPreferredSize(LAYOUT_1BY1);
		label_18_2.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_18_2, 1, LOW_DIS_NME + 1, 1, 1);

		text_18_3 = new JTextField("");
		text_18_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_18_3.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_18_3, 2, LOW_DIS_NME + 1, 1, 1);

		text_18_4 = new JTextField("");
		text_18_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_18_4.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_18_4, 3, LOW_DIS_NME + 1, 1, 1);

		text_18_5 = new JTextField("");
		text_18_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_18_5.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_18_5, 4, LOW_DIS_NME + 1, 2, 1);

		text_18_6 = new JTextField("");
		text_18_6.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_18_6.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_18_6, 6, LOW_DIS_NME + 1, 1, 1);

		text_18_7 = new JTextField("");
		text_18_7.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_18_7.setPreferredSize(LAYOUT_3BY1);
		this.addComp(text_18_7, 7, LOW_DIS_NME + 1, 3, 1);

		//１９行目
		JLabel label_19_2 = new JLabel("#2");
		label_19_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_19_2.setPreferredSize(LAYOUT_1BY1);
		label_19_2.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_19_2, 1, LOW_DIS_NME + 2, 1, 1);

		text_19_3 = new JTextField("");
		text_19_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_19_3.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_19_3, 2, LOW_DIS_NME + 2, 1, 1);

		text_19_4 = new JTextField("");
		text_19_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_19_4.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_19_4, 3, LOW_DIS_NME + 2, 1, 1);

		text_19_5 = new JTextField("");
		text_19_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_19_5.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_19_5, 4, LOW_DIS_NME + 2, 2, 1);

		text_19_6 = new JTextField("");
		text_19_6.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_19_6.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_19_6, 6, LOW_DIS_NME + 2, 1, 1);

		text_19_7 = new JTextField("");
		text_19_7.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_19_7.setPreferredSize(LAYOUT_3BY1);
		this.addComp(text_19_7, 7, LOW_DIS_NME + 2, 3, 1);

		//２０行目
		JLabel label_20_2 = new JLabel("#3");
		label_20_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_20_2.setPreferredSize(LAYOUT_1BY1);
		label_20_2.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_20_2, 1, LOW_DIS_NME + 3, 1, 1);

		text_20_3 = new JTextField("");
		text_20_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_20_3.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_20_3, 2, LOW_DIS_NME + 3, 1, 1);

		text_20_4 = new JTextField("");
		text_20_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_20_4.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_20_4, 3, LOW_DIS_NME + 3, 1, 1);

		text_20_5 = new JTextField("");
		text_20_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_20_5.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_20_5, 4, LOW_DIS_NME + 3, 2, 1);

		text_20_6 = new JTextField("");
		text_20_6.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_20_6.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_20_6, 6, LOW_DIS_NME + 3, 1, 1);

		text_20_7 = new JTextField("");
		text_20_7.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_20_7.setPreferredSize(LAYOUT_3BY1);
		this.addComp(text_20_7, 7, LOW_DIS_NME + 3, 3, 1);

		//２１行目(改行のための空白文字)
		JLabel label_21 = new JLabel("　");
		label_21.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_21, 0, LOW_DIS_NME + 4, 11, 1);

		//========================================================
		//====　現在の居場所　========================================
		//========================================================

		//２２行目
		JLabel label_22_1 = new JLabel("⑤現在の居場所");
		label_22_1.setFont(new Font("メイリオ", Font.PLAIN, 17));
		label_22_1.setPreferredSize(LAYOUT_1BY1);
		label_22_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_22_1, 0, LOW_CRT_LOC, 1, 1);

		check_22_2 = new JCheckBox("自宅");
		check_22_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_22_2.setPreferredSize(LAYOUT_1BY1);
		check_22_2.setHorizontalAlignment(JLabel.LEFT);
		check_22_2.addActionListener(this);
		check_22_2.setActionCommand("crt_loc_hom");
		this.addComp(check_22_2, 2, LOW_CRT_LOC, 1, 1);

		check_22_3 = new JCheckBox("入院中");
		check_22_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_22_3.setPreferredSize(LAYOUT_1BY1);
		check_22_3.setHorizontalAlignment(JLabel.LEFT);
		check_22_3.addActionListener(this);
		check_22_3.setActionCommand("crt_loc_hsp");
		this.addComp(check_22_3, 3, LOW_CRT_LOC, 1, 1);

		JLabel label_22_4 = new JLabel("退院予定日");
		label_22_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_22_4.setPreferredSize(LAYOUT_1BY1);
		label_22_4.setHorizontalAlignment(JLabel.CENTER);
		this.addComp(label_22_4, 4, LOW_CRT_LOC, 1, 1);

		text_22_5 = new JTextField("");
		text_22_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_22_5.setPreferredSize(LAYOUT_1BY1);
		text_22_5.setEditable(false);
		this.addComp(text_22_5, 5, LOW_CRT_LOC, 1, 1);

		check_22_6 = new JCheckBox("入所中");
		check_22_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_22_6.setPreferredSize(LAYOUT_1BY1);
		check_22_6.setHorizontalAlignment(JLabel.RIGHT);
		check_22_6.addActionListener(this);
		check_22_6.setActionCommand("crt_loc_fcy");
		this.addComp(check_22_6, 6, LOW_CRT_LOC, 1, 1);

		text_22_7 = new JTextField("");
		text_22_7.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_22_7.setPreferredSize(LAYOUT_2BY1);
		text_22_7.setEditable(false);
		this.addComp(text_22_7, 7, LOW_CRT_LOC, 2, 1);

		//２３行目(改行のための空白文字)
		JLabel label_23 = new JLabel("　");
		label_23.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_23, 0, LOW_CRT_LOC + 1, 11, 1);

		//========================================================
		//====　訪問場所　===========================================
		//========================================================

		//２４行目
		JLabel label_24_1 = new JLabel("⑥訪問場所");
		label_24_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_24_1.setPreferredSize(LAYOUT_1BY1);
		label_24_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_24_1, 0, LOW_VST_PLC, 1, 1);

		check_24_2 = new JCheckBox("自宅");
		check_24_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_24_2.setPreferredSize(LAYOUT_1BY1);
		check_24_2.setHorizontalAlignment(JLabel.LEFT);
		check_24_2.addActionListener(this);
		check_24_2.setActionCommand("vst_plc_hom");
		this.addComp(check_24_2, 2, LOW_VST_PLC, 1, 1);

		check_24_3 = new JCheckBox("サ高住");
		check_24_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_24_3.setPreferredSize(LAYOUT_1BY1);
		check_24_3.setHorizontalAlignment(JLabel.LEFT);
		check_24_3.addActionListener(this);
		check_24_3.setActionCommand("vst_plc_skj");
		this.addComp(check_24_3, 3, LOW_VST_PLC, 1, 1);

		check_24_4 = new JCheckBox("特養");
		check_24_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_24_4.setPreferredSize(LAYOUT_1BY1);
		check_24_4.setHorizontalAlignment(JLabel.LEFT);
		check_24_4.addActionListener(this);
		check_24_4.setActionCommand("vst_plc_tyo");
		this.addComp(check_24_4, 4, LOW_VST_PLC, 1, 1);

		check_24_5 = new JCheckBox("看多機");
		check_24_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_24_5.setPreferredSize(LAYOUT_1BY1);
		check_24_5.setHorizontalAlignment(JLabel.LEFT);
		check_24_5.addActionListener(this);
		check_24_5.setActionCommand("vst_plc_ktk");
		this.addComp(check_24_5, 5, LOW_VST_PLC, 1, 1);

		//２５行目(改行のための空白文字)
		JLabel label_25 = new JLabel("　");
		label_25.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_25, 0, LOW_VST_PLC + 1, 11, 1);

		//========================================================
		//====　残薬　==============================================
		//========================================================

		//２６行目
		JLabel label_26_1 = new JLabel("⑦残薬");
		label_26_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_26_1.setPreferredSize(LAYOUT_1BY1);
		label_26_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_26_1, 0, LOW_LEF_MCN, 1, 1);

		text_26_2 = new JTextField("");
		text_26_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_26_2.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_26_2, 2, LOW_LEF_MCN, 1, 1);

		JLabel label_26_3 = new JLabel("まで有");
		label_26_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_26_3.setPreferredSize(LAYOUT_1BY1);
		label_26_3.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_26_3, 3, LOW_LEF_MCN, 1, 1);

		JLabel label_26_5 = new JLabel("次回通院予定");
		label_26_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		label_26_5.setPreferredSize(LAYOUT_1BY1);
		label_26_5.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_26_5, 5, LOW_LEF_MCN, 1, 1);

		text_26_6 = new JTextField("");
		text_26_6.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_26_6.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_26_6, 6, LOW_LEF_MCN, 1, 1);

		//２７行目(改行のための空白文字)
		JLabel label_27 = new JLabel("　");
		label_27.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_27, 0, LOW_LEF_MCN + 1, 11, 1);

		//========================================================
		//====　依頼内容　===========================================
		//========================================================

		//２８行目
		JLabel label_28_1 = new JLabel("⑧依頼内容");
		label_28_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_28_1.setPreferredSize(LAYOUT_1BY1);
		label_28_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_28_1, 0, LOW_REQ_CON, 1, 1);

		check_28_2 = new JCheckBox("定期往診");
		check_28_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_28_2.setPreferredSize(LAYOUT_1BY1);
		check_28_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_28_2, 2, LOW_REQ_CON, 1, 1);

		check_28_4 = new JCheckBox("訪問看護");
		check_28_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_28_4.setPreferredSize(LAYOUT_1BY1);
		check_28_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_28_4, 4, LOW_REQ_CON, 1, 1);

		//２９行目
		check_29_2 = new JCheckBox("その他");
		check_29_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_29_2.setPreferredSize(LAYOUT_1BY1);
		check_29_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_29_2, 2, LOW_REQ_CON + 1, 1, 1);

		JLabel label_29_6 = new JLabel("既往歴");
		label_29_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_29_6.setPreferredSize(LAYOUT_1BY1);
		label_29_6.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_29_6, 6, LOW_REQ_CON + 1, 1, 1);

		//３０行目
		tArea_30_1 = new JTextArea(6, 22);
		tArea_30_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(tArea_30_1, 2, LOW_REQ_CON + 2, 4, 1);

		tArea_30_2 = new JTextArea(6, 22);
		tArea_30_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(tArea_30_2, 6, LOW_REQ_CON + 2, 4, 1);

		//３１行目(改行のための空白文字)
		JLabel label_31 = new JLabel("　");
		label_31.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_31, 0, LOW_REQ_CON + 3, 11, 1);

		//========================================================
		//====　現在のADL　===========================================
		//========================================================

		//３２行目
		JLabel label_32_1 = new JLabel("⑨現在のADL");
		label_32_1.setFont(new Font("メイリオ", Font.PLAIN, 20));
		label_32_1.setPreferredSize(LAYOUT_1BY1);
		label_32_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_32_1, 0, LOW_CRT_ADL, 1, 1);

		check_32_2 = new JCheckBox("寝たきり");
		check_32_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_32_2.setPreferredSize(LAYOUT_1BY1);
		check_32_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_32_2, 2, LOW_CRT_ADL, 1, 1);

		check_32_3 = new JCheckBox("車いす");
		check_32_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_32_3.setPreferredSize(LAYOUT_1BY1);
		check_32_3.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_32_3, 3, LOW_CRT_ADL, 1, 1);

		JLabel label_32_4 = new JLabel("トランス");
		label_32_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_32_4.setPreferredSize(LAYOUT_1BY1);
		label_32_4.setHorizontalAlignment(JLabel.CENTER);
		this.addComp(label_32_4, 4, LOW_CRT_ADL, 1, 1);

		combo_32_5 = new JComboBox<>(comb_32_5);
		combo_32_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		combo_32_5.setPreferredSize(new Dimension(118, 38));
		combo_32_5.addActionListener(this);
		combo_32_5.setActionCommand("trance");
		this.addComp(combo_32_5, 5, LOW_CRT_ADL, 1, 1);

		check_32_6 = new JCheckBox("伝い歩き");
		check_32_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_32_6.setPreferredSize(LAYOUT_1BY1);
		check_32_6.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_32_6, 6, LOW_CRT_ADL, 1, 1);

		check_32_7 = new JCheckBox("独歩");
		check_32_7.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_32_7.setPreferredSize(LAYOUT_1BY1);
		check_32_7.setHorizontalAlignment(JLabel.CENTER);
		this.addComp(check_32_7, 7, LOW_CRT_ADL, 1, 1);

		check_32_8 = new JCheckBox("座位可能");
		check_32_8.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_32_8.setPreferredSize(LAYOUT_1BY1);
		check_32_8.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_32_8, 8, LOW_CRT_ADL, 1, 1);

		//３３行目
		check_33_1 = new JCheckBox("最近、具合が急に悪くなっているか？(ここ２～３日で食事が摂れなくなった、熱があるなど)");
		check_33_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_33_1.setPreferredSize(LAYOUT_8BY1);
		check_33_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_33_1, 2, LOW_CRT_ADL + 1, 11, 1);

		//３４行目
		text_34_1 = new JTextField("");
		text_34_1.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_34_1.setPreferredSize(LAYOUT_8BY1);
		this.addComp(text_34_1, 2, LOW_CRT_ADL + 2, 11, 1);

		//３５行目
		check_35_1 = new JCheckBox("食事量");
		check_35_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_35_1.setPreferredSize(LAYOUT_1BY1);
		check_35_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_35_1, 2, LOW_CRT_ADL + 3, 1, 1);

		text_35_2 = new JTextField("");
		text_35_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_35_2.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_35_2, 3, LOW_CRT_ADL + 3, 1, 1);

		JLabel label_35_3 = new JLabel("内容");
		label_35_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_35_3.setPreferredSize(LAYOUT_1BY1);
		label_35_3.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_35_3, 4, LOW_CRT_ADL + 3, 1, 1);

		text_35_4 = new JTextField("");
		text_35_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_35_4.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_35_4, 5, LOW_CRT_ADL + 3, 1, 1);

		JLabel label_35_5 = new JLabel("摂取方法");
		label_35_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_35_5.setPreferredSize(LAYOUT_1BY1);
		label_35_5.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_35_5, 6, LOW_CRT_ADL + 3, 1, 1);

		text_35_6 = new JTextField("");
		text_35_6.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_35_6.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_35_6, 7, LOW_CRT_ADL + 3, 1, 1);

		//３６行目
		JLabel label_36_1 = new JLabel("量が少量の時：水分量");
		label_36_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_36_1.setPreferredSize(LAYOUT_2BY1);
		label_36_1.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_36_1, 2, LOW_CRT_ADL + 4, 2, 1);

		text_36_2 = new JTextField("");
		text_36_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_36_2.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_36_2, 4, LOW_CRT_ADL + 4, 1, 1);

		//３７行目
		check_37_1 = new JCheckBox("本人の訴える苦痛がある");
		check_37_1.setFont(new Font("メイリオ", Font.PLAIN, 19));
		check_37_1.setPreferredSize(LAYOUT_2BY1);
		check_37_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_37_1, 2, LOW_CRT_ADL + 5, 2, 1);

		text_37_2 = new JTextField("");
		text_37_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_37_2.setPreferredSize(LAYOUT_3BY1);
		this.addComp(text_37_2, 4, LOW_CRT_ADL + 5, 3, 1);

		check_37_3 = new JCheckBox("無し");
		check_37_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		check_37_3.setPreferredSize(LAYOUT_1BY1);
		check_37_3.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_37_3, 7, LOW_CRT_ADL + 5, 1, 1);

		//３８行目(改行のための空白文字)
		JLabel label_38 = new JLabel("　");
		label_38.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_38, 0, LOW_CRT_ADL + 6, 11, 1);

		//========================================================
		//====　紹介状　=============================================
		//========================================================

		//３９行目
		JLabel label_39_1 = new JLabel("⑩紹介状");
		label_39_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_39_1.setPreferredSize(LAYOUT_1BY1);
		label_39_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_39_1, 0, LOW_INT_LTR, 1, 1);

		check_39_2 = new JCheckBox("有り");
		check_39_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_39_2.setPreferredSize(LAYOUT_1BY1);
		check_39_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_39_2, 2, LOW_INT_LTR, 1, 1);

		check_39_3 = new JCheckBox("無し");
		check_39_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_39_3.setPreferredSize(LAYOUT_1BY1);
		check_39_3.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_39_3, 3, LOW_INT_LTR, 1, 1);

		check_39_4 = new JCheckBox("手配済み");
		check_39_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_39_4.setPreferredSize(LAYOUT_1BY1);
		check_39_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_39_4, 4, LOW_INT_LTR, 1, 1);

		JLabel label_39_4 = new JLabel("入手予定日");
		label_39_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_39_4.setPreferredSize(LAYOUT_1BY1);
		label_39_4.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_39_4, 5, LOW_INT_LTR, 1, 1);

		text_39_5 = new JTextField("");
		text_39_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_39_5.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_39_5, 6, LOW_INT_LTR, 1, 1);

		check_39_6 = new JCheckBox("その他");
		check_39_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_39_6.setPreferredSize(LAYOUT_1BY1);
		check_39_6.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_39_6, 7, LOW_INT_LTR, 1, 1);

		text_39_7 = new JTextField("");
		text_39_7.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_39_7.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_39_7, 8, LOW_INT_LTR, 1, 1);

		//４０行目(改行のための空白文字)
		JLabel label_40 = new JLabel("　");
		label_40.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_40, 0, LOW_INT_LTR + 1, 11, 1);

		//========================================================
		//====　対応の緊急度　========================================
		//========================================================

		//４１行目
		JLabel label_41_1 = new JLabel("⑪対応の緊急度");
		label_41_1.setFont(new Font("メイリオ", Font.PLAIN, 16));
		label_41_1.setPreferredSize(LAYOUT_1BY1);
		label_41_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_41_1, 0, LOW_URG_REP, 1, 1);

		check_41_2 = new JCheckBox("24時間以内");
		check_41_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_41_2.setPreferredSize(LAYOUT_2BY1);
		check_41_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_41_2, 2, LOW_URG_REP, 2, 1);

		check_41_3 = new JCheckBox("2～3日以内");
		check_41_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_41_3.setPreferredSize(LAYOUT_2BY1);
		check_41_3.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_41_3, 4, LOW_URG_REP, 2, 1);

		check_41_4 = new JCheckBox("1週間以内");
		check_41_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_41_4.setPreferredSize(LAYOUT_2BY1);
		check_41_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_41_4, 6, LOW_URG_REP, 2, 1);

		check_41_5 = new JCheckBox("2週間以内");
		check_41_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_41_5.setPreferredSize(LAYOUT_2BY1);
		check_41_5.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_41_5, 8, LOW_URG_REP, 2, 1);

		//４２行目(改行のための空白文字)
		JLabel label_42 = new JLabel("　");
		label_42.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_42, 0, LOW_URG_REP + 1, 11, 1);

		//========================================================
		//====　医療処置　===========================================
		//========================================================

		//４３行目
		JLabel label_43_1 = new JLabel("⑫医療処置");
		label_43_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_43_1.setPreferredSize(LAYOUT_1BY1);
		label_43_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_43_1, 0, LOW_MED_TTM, 1, 1);

		check_43_2 = new JCheckBox("バルン");
		check_43_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_43_2.setPreferredSize(LAYOUT_1BY1);
		check_43_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_43_2, 2, LOW_MED_TTM, 1, 1);

		JLabel label_43_3 = new JLabel("最終交換日");
		label_43_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_43_3.setPreferredSize(LAYOUT_1BY1);
		label_43_3.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_43_3, 3, LOW_MED_TTM, 1, 1);

		text_43_4 = new JTextField("");
		text_43_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_43_4.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_43_4, 4, LOW_MED_TTM, 1, 1);

		text_43_5 = new JTextField("");
		text_43_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_43_5.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_43_5, 5, LOW_MED_TTM, 1, 1);

		JLabel label_43_6 = new JLabel("Fr");
		label_43_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_43_6.setPreferredSize(LAYOUT_1BY1);
		label_43_6.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_43_6, 6, LOW_MED_TTM, 1, 1);

		check_43_7 = new JCheckBox("気管切開");
		check_43_7.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_43_7.setPreferredSize(LAYOUT_1BY1);
		check_43_7.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_43_7, 7, LOW_MED_TTM, 1, 1);

		//４４行目
		check_44_1 = new JCheckBox("経管栄養");
		check_44_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_44_1.setPreferredSize(LAYOUT_1BY1);
		check_44_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_44_1, 2, LOW_MED_TTM + 1, 1, 1);

		combo_44_2 = new JComboBox<>(comb_44_2);
		combo_44_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		combo_44_2.setPreferredSize(new Dimension(118, 38));
		combo_44_2.addActionListener(this);
		combo_44_2.setActionCommand("tubefeeding");
		this.addComp(combo_44_2, 3, LOW_MED_TTM + 1, 1, 1);

		check_44_3 = new JCheckBox("HOT");
		check_44_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_44_3.setPreferredSize(LAYOUT_1BY1);
		check_44_3.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_44_3, 4, LOW_MED_TTM + 1, 1, 1);

		text_44_4 = new JTextField("");
		text_44_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_44_4.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_44_4, 5, LOW_MED_TTM + 1, 1, 1);

		JLabel label_44_5 = new JLabel("L");
		label_44_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_44_5.setPreferredSize(LAYOUT_1BY1);
		label_44_5.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_44_5, 6, LOW_MED_TTM + 1, 1, 1);

		combo_44_6 = new JComboBox<>(comb_44_6);
		combo_44_6.setFont(new Font("メイリオ", Font.PLAIN, 17));
		combo_44_6.setPreferredSize(new Dimension(236, 38));
		combo_44_6.addActionListener(this);
		combo_44_6.setActionCommand("tubefeeding");
		this.addComp(combo_44_6, 7, LOW_MED_TTM + 1, 2, 1);

		//４５行目
		check_45_1 = new JCheckBox("IVH");
		check_45_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_45_1.setPreferredSize(LAYOUT_1BY1);
		check_45_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_45_1, 2, LOW_MED_TTM + 2, 1, 1);

		text_45_2 = new JTextField("");
		text_45_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_45_2.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_45_2, 3, LOW_MED_TTM + 2, 1, 1);

		check_45_3 = new JCheckBox("人工呼吸器");
		check_45_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_45_3.setPreferredSize(LAYOUT_2BY1);
		check_45_3.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_45_3, 4, LOW_MED_TTM + 2, 2, 1);

		check_45_4 = new JCheckBox("創処置");
		check_45_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_45_4.setPreferredSize(LAYOUT_2BY1);
		check_45_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_45_4, 6, LOW_MED_TTM + 2, 2, 1);

		check_45_5 = new JCheckBox("吸引");
		check_45_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_45_5.setPreferredSize(LAYOUT_2BY1);
		check_45_5.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_45_5, 8, LOW_MED_TTM + 2, 2, 1);

		//４６行目
		check_46_1 = new JCheckBox("その他");
		check_46_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_46_1.setPreferredSize(LAYOUT_1BY1);
		check_46_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_46_1, 2, LOW_MED_TTM + 3, 1, 1);

		text_46_2 = new JTextField("");
		text_46_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_46_2.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_46_2, 3, LOW_MED_TTM + 3, 1, 1);

		//４７行目(改行のための空白文字)
		JLabel label_47 = new JLabel("　");
		label_47.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_47, 0, LOW_MED_TTM + 4, 11, 1);

		//========================================================
		//====　介護保険　===========================================
		//========================================================

		//４８行目
		JLabel label_48_1 = new JLabel("⑬介護保険");
		label_48_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_48_1.setPreferredSize(LAYOUT_1BY1);
		label_48_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_48_1, 0, LOW_NUR_CAR, 1, 1);

		JLabel label_48_2 = new JLabel("介護度");
		label_48_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_48_2.setPreferredSize(LAYOUT_1BY1);
		label_48_2.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_48_2, 1, LOW_NUR_CAR, 1, 1);

		combo_48_3 = new JComboBox<>(comb_48_3);
		combo_48_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		combo_48_3.setPreferredSize(new Dimension(118, 38));
		combo_48_3.addActionListener(this);
		combo_48_3.setActionCommand("tubefeeding");
		this.addComp(combo_48_3, 2, LOW_NUR_CAR, 1, 1);

		check_48_4 = new JCheckBox("未申請");
		check_48_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_48_4.setPreferredSize(LAYOUT_2BY1);
		check_48_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_48_4, 4, LOW_NUR_CAR, 2, 1);

		check_48_5 = new JCheckBox("申請中");
		check_48_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_48_5.setPreferredSize(LAYOUT_2BY1);
		check_48_5.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_48_5, 6, LOW_NUR_CAR, 2, 1);

		check_48_6 = new JCheckBox("更新・再申請中");
		check_48_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_48_6.setPreferredSize(LAYOUT_2BY1);
		check_48_6.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_48_6, 8, LOW_NUR_CAR, 2, 1);

		//４９行目
		JLabel label_49_1 = new JLabel("居宅事業所");
		label_49_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_49_1.setPreferredSize(LAYOUT_1BY1);
		label_49_1.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_49_1, 1, LOW_NUR_CAR + 1, 1, 1);

		text_49_2 = new JTextField("");
		text_49_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_49_2.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_49_2, 2, LOW_NUR_CAR + 1, 2, 1);

		check_49_3 = new JCheckBox("未定");
		check_49_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_49_3.setPreferredSize(LAYOUT_1BY1);
		check_49_3.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_49_3, 5, LOW_NUR_CAR + 1, 1, 1);

		JLabel label_49_4 = new JLabel("申請日");
		label_49_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_49_4.setPreferredSize(LAYOUT_1BY1);
		label_49_4.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_49_4, 6, LOW_NUR_CAR + 1, 1, 1);

		text_49_5 = new JTextField("");
		text_49_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_49_5.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_49_5, 7, LOW_NUR_CAR + 1, 1, 1);

		//５０行目
		JLabel label_50_1 = new JLabel("CM");
		label_50_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_50_1.setPreferredSize(LAYOUT_1BY1);
		label_50_1.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_50_1, 1, LOW_NUR_CAR + 2, 1, 1);

		text_50_2 = new JTextField("");
		text_50_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_50_2.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_50_2, 2, LOW_NUR_CAR + 2, 2, 1);

		//５１行目(改行のための空白文字)
		JLabel label_51 = new JLabel("　");
		label_51.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_51, 0, LOW_NUR_CAR + 3, 11, 1);

		//========================================================
		//====　家族背景　===========================================
		//========================================================

		//５２行目
		JLabel label_52_1 = new JLabel("主 ");
		label_52_1.setFont(new Font("メイリオ", Font.PLAIN, 12));
		label_52_1.setPreferredSize(LAYOUT_1BY05);
		label_52_1.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_52_1, 5, LOW_FAM_BKG, 1, 1);

		JLabel label_52_2 = new JLabel(" 協");
		label_52_2.setFont(new Font("メイリオ", Font.PLAIN, 12));
		label_52_2.setPreferredSize(LAYOUT_1BY05);
		label_52_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_52_2, 6, LOW_FAM_BKG, 1, 1);

		JLabel label_52_3 = new JLabel("主 ");
		label_52_3.setFont(new Font("メイリオ", Font.PLAIN, 12));
		label_52_3.setPreferredSize(LAYOUT_1BY05);
		label_52_3.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_52_3, 7, LOW_FAM_BKG, 1, 1);

		JLabel label_52_4 = new JLabel(" 協");
		label_52_4.setFont(new Font("メイリオ", Font.PLAIN, 12));
		label_52_4.setPreferredSize(LAYOUT_1BY05);
		label_52_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_52_4, 8, LOW_FAM_BKG, 1, 1);

		//５３行目
		JLabel label_53_1 = new JLabel("⑭家族背景");
		label_53_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_53_1.setPreferredSize(LAYOUT_1BY1);
		label_53_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_53_1, 0, LOW_FAM_BKG + 1, 1, 1);

		//※注意　このテキストエリアは３×３でグリッドバッグに追加しています。
		tArea_53_2 = new JTextArea(5, 17);
		tArea_53_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(tArea_53_2, 1, LOW_FAM_BKG + 1, 3, 3);

		JLabel label_53_3 = new JLabel("主介護者：");
		label_53_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_53_3.setPreferredSize(LAYOUT_1BY1);
		label_53_3.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_53_3, 4, LOW_FAM_BKG + 1, 1, 1);

		check_53_4 = new JCheckBox();
		check_53_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_53_4.setPreferredSize(LAYOUT_1BY1);
		check_53_4.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_53_4, 5, LOW_FAM_BKG + 1, 1, 1);

		check_53_5 = new JCheckBox("配偶者");
		check_53_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_53_5.setPreferredSize(LAYOUT_1BY1);
		check_53_5.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_53_5, 6, LOW_FAM_BKG + 1, 1, 1);

		check_53_6 = new JCheckBox();
		check_53_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_53_6.setPreferredSize(LAYOUT_1BY1);
		check_53_6.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_53_6, 7, LOW_FAM_BKG + 1, 1, 1);

		check_53_7 = new JCheckBox("娘");
		check_53_7.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_53_7.setPreferredSize(LAYOUT_1BY1);
		check_53_7.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_53_7, 8, LOW_FAM_BKG + 1, 1, 1);

		text_53_8 = new JTextField("");
		text_53_8.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_53_8.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_53_8, 9, LOW_FAM_BKG + 1, 1, 1);

		//５４行目
		check_54_1 = new JCheckBox();
		check_54_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_54_1.setPreferredSize(LAYOUT_1BY1);
		check_54_1.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_54_1, 5, LOW_FAM_BKG + 2, 1, 1);

		check_54_2 = new JCheckBox("息子");
		check_54_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_54_2.setPreferredSize(LAYOUT_1BY1);
		check_54_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_54_2, 6, LOW_FAM_BKG + 2, 1, 1);

		check_54_3 = new JCheckBox();
		check_54_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_54_3.setPreferredSize(LAYOUT_1BY1);
		check_54_3.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_54_3, 7, LOW_FAM_BKG + 2, 1, 1);

		check_54_4 = new JCheckBox("嫁");
		check_54_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_54_4.setPreferredSize(LAYOUT_1BY1);
		check_54_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_54_4, 8, LOW_FAM_BKG + 2, 1, 1);

		text_54_5 = new JTextField("");
		text_54_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_54_5.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_54_5, 9, LOW_FAM_BKG + 2, 1, 1);

		//５５行目
		check_55_1 = new JCheckBox();
		check_55_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_55_1.setPreferredSize(LAYOUT_1BY1);
		check_55_1.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(check_55_1, 5, LOW_FAM_BKG + 3, 1, 1);

		check_55_2 = new JCheckBox("その他");
		check_55_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_55_2.setPreferredSize(LAYOUT_1BY1);
		check_55_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_55_2, 6, LOW_FAM_BKG + 3, 1, 1);

		text_55_3 = new JTextField("");
		text_55_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_55_3.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_55_3, 7, LOW_FAM_BKG + 3, 2, 1);

		//５６行目(改行のための空白文字)
		JLabel label_56 = new JLabel("　");
		label_56.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_56, 0, LOW_FAM_BKG + 4, 11, 1);

		//========================================================
		//====　社会的留意点　=======================================
		//========================================================

		//５６行目
		JLabel label_56_1 = new JLabel("⑮社会的留意点");
		label_56_1.setFont(new Font("メイリオ", Font.PLAIN, 16));
		label_56_1.setPreferredSize(LAYOUT_1BY1);
		label_56_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_56_1, 0, LOW_SOC_CON, 1, 1);

		check_56_2 = new JCheckBox("独居");
		check_56_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_56_2.setPreferredSize(LAYOUT_1BY1);
		check_56_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_56_2, 2, LOW_SOC_CON, 1, 1);

		check_56_3 = new JCheckBox("日中独居");
		check_56_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_56_3.setPreferredSize(LAYOUT_1BY1);
		check_56_3.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_56_3, 4, LOW_SOC_CON, 1, 1);

		check_56_4 = new JCheckBox("老老介護");
		check_56_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_56_4.setPreferredSize(LAYOUT_1BY1);
		check_56_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_56_4, 6, LOW_SOC_CON, 1, 1);

		check_56_5 = new JCheckBox("認知症");
		check_56_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_56_5.setPreferredSize(LAYOUT_1BY1);
		check_56_5.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_56_5, 8, LOW_SOC_CON, 1, 1);

		//５７行目
		check_57_1 = new JCheckBox("虐待");
		check_57_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_57_1.setPreferredSize(LAYOUT_1BY1);
		check_57_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_57_1, 2, LOW_SOC_CON + 1, 1, 1);

		check_57_2 = new JCheckBox("障害");
		check_57_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_57_2.setPreferredSize(LAYOUT_1BY1);
		check_57_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_57_2, 4, LOW_SOC_CON + 1, 1, 1);

		check_57_3 = new JCheckBox("経済的問題");
		check_57_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		check_57_3.setPreferredSize(LAYOUT_1BY1);
		check_57_3.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_57_3, 6, LOW_SOC_CON + 1, 1, 1);

		check_57_4 = new JCheckBox("その他");
		check_57_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_57_4.setPreferredSize(LAYOUT_1BY1);
		check_57_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_57_4, 8, LOW_SOC_CON + 1, 1, 1);

		text_57_5 = new JTextField("");
		text_57_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_57_5.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_57_5, 9, LOW_SOC_CON + 1, 1, 1);

		//５８行目(改行のための空白文字)
		JLabel label_58 = new JLabel("　");
		label_58.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_58, 0, LOW_SOC_CON + 2, 11, 1);

		//========================================================
		//====　公費負担　===========================================
		//========================================================

		//５９行目
		JLabel label_59_1 = new JLabel("⑯公費負担");
		label_59_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_59_1.setPreferredSize(LAYOUT_1BY1);
		label_59_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_59_1, 0, LOW_PUB_BUR, 1, 1);

		check_59_2 = new JCheckBox("身障手帳");
		check_59_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_59_2.setPreferredSize(LAYOUT_1BY1);
		check_59_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_59_2, 2, LOW_PUB_BUR, 1, 1);

		text_59_3 = new JTextField("");
		text_59_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_59_3.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_59_3, 3, LOW_PUB_BUR, 1, 1);

		JLabel label_59_4 = new JLabel("級");
		label_59_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_59_4.setPreferredSize(LAYOUT_1BY1);
		label_59_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_59_4, 4, LOW_PUB_BUR, 1, 1);

		check_59_5 = new JCheckBox("特定疾患");
		check_59_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_59_5.setPreferredSize(LAYOUT_1BY1);
		check_59_5.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_59_5, 5, LOW_PUB_BUR, 1, 1);

		check_59_6 = new JCheckBox("自立支援");
		check_59_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_59_6.setPreferredSize(LAYOUT_1BY1);
		check_59_6.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_59_6, 7, LOW_PUB_BUR, 1, 1);

		//６０行目
		check_60_1 = new JCheckBox("生活保護");
		check_60_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_60_1.setPreferredSize(LAYOUT_1BY1);
		check_60_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_60_1, 2, LOW_PUB_BUR + 1, 1, 1);

		JLabel label_60_2 = new JLabel("担当");
		label_60_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_60_2.setPreferredSize(LAYOUT_1BY1);
		label_60_2.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_60_2, 3, LOW_PUB_BUR + 1, 1, 1);

		text_60_3 = new JTextField("");
		text_60_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_60_3.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_60_3, 4, LOW_PUB_BUR + 1, 2, 1);

		JLabel label_60_4 = new JLabel("様");
		label_60_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_60_4.setPreferredSize(LAYOUT_1BY1);
		label_60_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_60_4, 6, LOW_PUB_BUR + 1, 1, 1);

		check_60_5 = new JCheckBox("その他");
		check_60_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_60_5.setPreferredSize(LAYOUT_1BY1);
		check_60_5.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_60_5, 7, LOW_PUB_BUR + 1, 1, 1);

		text_60_6 = new JTextField("");
		text_60_6.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_60_6.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_60_6, 8, LOW_PUB_BUR + 1, 2, 1);

		//６１行目(改行のための空白文字)
		JLabel label_61 = new JLabel("　");
		label_61.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_61, 0, LOW_PUB_BUR + 2, 11, 1);

		//========================================================
		//====　サービス利用　=========================================
		//========================================================

		//６２行目
		JLabel label_62_1 = new JLabel("⑰サービス利用");
		label_62_1.setFont(new Font("メイリオ", Font.PLAIN, 17));
		label_62_1.setPreferredSize(LAYOUT_1BY1);
		label_62_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_62_1, 0, LOW_SER_USG, 1, 1);

		check_62_2 = new JCheckBox("デイ");
		check_62_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_62_2.setPreferredSize(LAYOUT_1BY1);
		check_62_2.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_62_2, 2, LOW_SER_USG, 1, 1);

		text_62_3 = new JTextField("");
		text_62_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_62_3.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_62_3, 3, LOW_SER_USG, 2, 1);

		check_62_4 = new JCheckBox("ヘルパー");
		check_62_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_62_4.setPreferredSize(LAYOUT_1BY1);
		check_62_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_62_4, 6, LOW_SER_USG, 1, 1);

		text_62_5 = new JTextField("");
		text_62_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_62_5.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_62_5, 7, LOW_SER_USG, 2, 1);

		//６３行目
		check_63_1 = new JCheckBox("訪問看護");
		check_63_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_63_1.setPreferredSize(LAYOUT_1BY1);
		check_63_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_63_1, 2, LOW_SER_USG + 1, 1, 1);

		text_63_2 = new JTextField("");
		text_63_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_63_2.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_63_2, 3, LOW_SER_USG + 1, 2, 1);

		check_63_3 = new JCheckBox("その他");
		check_63_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		check_63_3.setPreferredSize(LAYOUT_1BY1);
		check_63_3.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(check_63_3, 6, LOW_SER_USG + 1, 1, 1);

		text_63_4 = new JTextField("");
		text_63_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_63_4.setPreferredSize(LAYOUT_2BY1);
		this.addComp(text_63_4, 7, LOW_SER_USG + 1, 2, 1);

		//６４行目(改行のための空白文字)
		JLabel label_64 = new JLabel("　");
		label_64.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_64, 0, LOW_SER_USG + 2, 11, 1);

		//========================================================
		//====　口座振替用紙　========================================
		//========================================================

		//６５行目
		JLabel label_65_1 = new JLabel("⑱口座振替用紙");
		label_65_1.setFont(new Font("メイリオ", Font.PLAIN, 17));
		label_65_1.setPreferredSize(LAYOUT_1BY1);
		label_65_1.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_65_1, 0, LOW_ACC_TSF, 1, 1);

		JLabel label_65_2 = new JLabel("(");
		label_65_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_65_2.setPreferredSize(LAYOUT_1BY1);
		label_65_2.setHorizontalAlignment(JLabel.RIGHT);
		this.addComp(label_65_2, 1, LOW_ACC_TSF, 1, 1);

		text_65_3 = new JTextField("");
		text_65_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_65_3.setPreferredSize(LAYOUT_1BY1);
		this.addComp(text_65_3, 2, LOW_ACC_TSF, 1, 1);

		JLabel label_65_4 = new JLabel("受け取り済み)");
		label_65_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		label_65_4.setPreferredSize(LAYOUT_2BY1);
		label_65_4.setHorizontalAlignment(JLabel.LEFT);
		this.addComp(label_65_4, 3, LOW_ACC_TSF, 2, 1);

		//６６行目(改行のための空白文字)
		JLabel label_66 = new JLabel("　");
		label_66.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_66, 0, LOW_ACC_TSF + 1, 11, 1);

//TODO ここまで実装した。

		//６７行目(改行のための空白文字)
		JLabel label_67 = new JLabel("　");
		label_67.setFont(new Font("メイリオ", Font.PLAIN, 20));
		this.addComp(label_67, 0, 107, 11, 1);

		//６８行目(改行のための空白文字)
		JLabel label_68 = new JLabel("　");
		label_68.setFont(new Font("メイリオ", Font.PLAIN, 70));
		this.addComp(label_68, 0, 108, 11, 1);

		//６９行目(改行のための空白文字)
		JLabel label_69 = new JLabel("　");
		label_69.setFont(new Font("メイリオ", Font.PLAIN, 70));
		this.addComp(label_69, 0, 109, 11, 1);

		//７０行目
		button_1 = new JButton("登録");
		button_1.addActionListener(this);
		button_1.setFont(new Font("メイリオ", Font.PLAIN, 36));
		button_1.setPreferredSize(LAYOUT_2BY1);
		button_1.setActionCommand("reg_btn");
		this.addComp(button_1, 2, 150, 2, 1);

		button_2 = new JButton("修正");
		button_2.addActionListener(this);
		button_2.setFont(new Font("メイリオ", Font.PLAIN, 36));
		button_2.setPreferredSize(LAYOUT_2BY1);
		button_2.setActionCommand("mod_btn");
		this.addComp(button_2, 5, 150, 2, 1);

		button_3 = new JButton("削除");
		button_3.addActionListener(this);
		button_3.setFont(new Font("メイリオ", Font.PLAIN, 36));
		button_3.setPreferredSize(LAYOUT_2BY1);
		button_3.setActionCommand("del_btn");
		this.addComp(button_3, 8, 150, 2, 1);



	    JScrollPane scrollpane = new JScrollPane(panel);
	    scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//	    scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollpane.getVerticalScrollBar().setUnitIncrement(25);

		//パネルを設定。
		getContentPane().add(scrollpane, BorderLayout.WEST);
	}

	/**
	 * <p>[概 要] </p>
	 * 　ボタン押下後に呼ばれる処理<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		//ボタン毎にセットしたアクションコマンドを取得
		String cmd = e.getActionCommand();

		//患者情報　カルテID 入力
		if (cmd.endsWith("pat_inf_pid")) {

			System.out.println("キターーーーーー");

			try {
				Integer.parseInt(text_5_5.getText());
			} catch (NumberFormatException e2) {

				JLabel label = new JLabel("数字を入力して下さい");
				label.setForeground(Color.RED);
				JOptionPane.showMessageDialog(this, label);
				text_5_5.setText(MAAT00.CHAR.EMPTY_STRING);
			}
		}

		//患者情報　生年月日 入力
		if (cmd.endsWith("pat_inf_bth")) {

			//年齢計算
			int age = 0;
			age = calcAgeWareki(text_6_6.getText(), new Date());

			//年齢を出力
			text_6_8.setText(String.valueOf(age));
		}

		//現在の居場所
		if (cmd.endsWith("crt_loc_hom")) {

			check_22_3.setSelected(false);
			text_22_5.setText(MAAT00.CHAR.EMPTY_STRING);
			text_22_5.setEditable(false);
			check_22_6.setSelected(false);
			text_22_7.setText(MAAT00.CHAR.EMPTY_STRING);
			text_22_7.setEditable(false);

		} else if (cmd.endsWith("crt_loc_hsp")) {

			check_22_2.setSelected(false);
			text_22_5.setEditable(true);
			check_22_6.setSelected(false);
			text_22_7.setText(MAAT00.CHAR.EMPTY_STRING);
			text_22_7.setEditable(false);

		} else if (cmd.endsWith("crt_loc_fcy")) {

			check_22_2.setSelected(false);
			check_22_3.setSelected(false);
			text_22_5.setText(MAAT00.CHAR.EMPTY_STRING);
			text_22_5.setEditable(false);
			text_22_7.setEditable(true);

		}

		//訪問場所
		if (cmd.endsWith("vst_plc_hom")) {

			check_24_3.setSelected(false);
			check_24_4.setSelected(false);
			check_24_5.setSelected(false);

		} else if (cmd.endsWith("vst_plc_skj")) {

			check_24_2.setSelected(false);
			check_24_4.setSelected(false);
			check_24_5.setSelected(false);

		} else if (cmd.endsWith("vst_plc_tyo")) {

			check_24_2.setSelected(false);
			check_24_3.setSelected(false);
			check_24_5.setSelected(false);

		} else if (cmd.endsWith("vst_plc_ktk")) {

			check_24_2.setSelected(false);
			check_24_3.setSelected(false);
			check_24_4.setSelected(false);

		}

		//「登録」の場合
		if (cmd.endsWith("reg_btn")) {

//			//メインフレームを生成し実行。
//			MFM00V001Z00 frame = new MFM00V001Z00();
//			frame.setVisible(true);
//
//			//処理が終わったら画面終了
//			this.dispose();

			//「修正」の場合
		} else if (cmd.endsWith("mod_btn")) {

//			//ボタンを非活性
//			button_1.setEnabled(false);
//			button_2.setEnabled(false);
//
//			//業務処理スタート
//			bizTh = new BusinessThread();
//			bizTh.start();

			//「削除」の場合
		} else if (cmd.endsWith("del_btn")) {

			text_3_5.setText(MAAT00.CHAR.EMPTY_STRING);
			text_3_7.setText(MAAT00.CHAR.EMPTY_STRING);
			text_5_3.setText(MAAT00.CHAR.EMPTY_STRING);
			text_5_5.setText(MAAT00.CHAR.EMPTY_STRING);
			text_6_6.setText(MAAT00.CHAR.EMPTY_STRING);

		}
	}

	//画面でキーが押された場合に呼ばれる処理
	@Override
	public void keyTyped(KeyEvent e) {

		//入力された文字を取得
		int keychar = e.getKeyChar();
		if (keychar == KeyEvent.VK_TAB){

			//入力された拡張修飾子マスクを取得
			int mod = e.getModifiersEx();
			if ((mod & InputEvent.SHIFT_DOWN_MASK) != 0){

				//性別コンボボックスにフォーカスを移動
				combo_6_4.requestFocusInWindow();

			} else {

				//年齢計算
				int age = 0;
				age = calcAgeWareki(text_6_6.getText(), new Date());

				//年齢を出力
				text_6_8.setText(String.valueOf(age));

				//年齢テキストにフォーカスを移動
				text_6_8.requestFocusInWindow();
			}
		}
	}

//	//業務処理
//	class BusinessThread extends Thread {
//
//		public void run() {
//
//			label_6.setText("しばらくお待ちください。");
//
//			remComp(label_7, pgBar, 0, 9, 3, 1);
//
//			//appData作成
//			MAA00B003Z00 appData = new MAA00B003Z00();
//			appData.setMsgIn(MAAT00.DCP_SRT, text_1.getText());
//			appData.setMsgIn(MAAT00.DCP_END, text_2.getText());
//
//			appData.setMsgIn(MAAT00.ITM_NME_1, text_3.getText());
//			appData.setMsgIn(MAAT00.ITM_DLM_1, convComb(combo1));
//			appData.setMsgIn(MAAT00.ITM_END_1, convComb(combo2));
//
//			appData.setMsgIn(MAAT00.ITM_NME_2, text_4.getText());
//			appData.setMsgIn(MAAT00.ITM_DLM_2, convComb(combo3));
//			appData.setMsgIn(MAAT00.ITM_END_2, convComb(combo4));
//
//			appData.setMsgIn(MAAT00.ITM_NME_3, text_5.getText());
//			appData.setMsgIn(MAAT00.ITM_DLM_3, convComb(combo5));
//			appData.setMsgIn(MAAT00.ITM_END_3, convComb(combo6));
//
//			try {
//
//				//カルテ汎用検索クラスを実行
//				MAA00B001Z00 fluDsrObj = new MFD03B001Z00();
//				fluDsrObj.execute(appData, pgBar);
//
//				//業務エラーが発生していた場合は画面を閉じずに終了。
//				if (fluDsrObj.getAllInOneData().getCa().errOccurred()) {
//					label_6.setText("×ボタンで画面を閉じて、最初からやり直して下さい。");
//					return;
//				}
//
//				//エラー発生時
//			} catch (Exception ex) {
//
//				//標準出力
//				ex.printStackTrace();
//			}
//			label_6.setText("×ボタンで画面を閉じて下さい。");
//		}
//
//		private String convComb(JComboBox<?> combo) {
//
//			//選択内容を取得。
//			String sItem = (String) combo.getSelectedItem();
//			String result = MAAT00.CHAR.EMPTY_STRING;
//
//			//選択内容ごとに返却文字を変換。
//			if (sItem.equals("なし")) {
//				result = MAAT00.CHAR.EMPTY_STRING;
//			} else if(sItem.equals("改行")) {
//				result = MAAT00.CHAR.CRLF;
//			} else if(sItem.equals("。(句点)")) {
//				result = MAAT00.CHAR.KUTEN;
//			} else if(sItem.equals(",(カンマ)")) {
//				result = MAAT00.CHAR.COMMA;
//			} else if(sItem.equals(":(コロン)")) {
//				result = MAAT00.CHAR.COLON;
//			}
//			return result;
//		}
//
//	}

	//和暦入力された生年月日を元に、年齢(本日)を計算する処理
	private int calcAgeWareki(String gyymmdd, Date now) {

		int age = 0;
		Locale locale = new Locale("ja", "JP", "JP");
		SimpleDateFormat sdf = new SimpleDateFormat("Gyy/MM/dd",locale);

		try {
			Date birth = sdf.parse(gyymmdd);
			age = calcAge(birth ,now);
		} catch (ParseException  e2) {
			JLabel label = new JLabel("生年月日が不正です");
			label.setForeground(Color.RED);
			JOptionPane.showMessageDialog(this, label);
			age = 0;
		}

		return age;
	}

	//Date型の日付(生年月日、本日)から年齢を計算する処理
	private static int calcAge(Date birthday, Date now) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    return (Integer.parseInt(sdf.format(now)) - Integer.parseInt(sdf.format(birthday))) / 10000;
	}

	/**
	 * <p>[概 要] </p>
	 * 　コンポーネントを GridBagLayout に設定するメソッド<BR>
	 * <p>[詳 細] </p>
	 * 　コンポーネント(ラベル、テキストボックス、ボタン等)をレイアウト(GridBagLayout)に追加。<BR>
	 * @param comp (ラベル、テキストボックス、ボタン等)
	 * @param x 左から何番目のグリッドに設定するか。0～
	 * @param y 上から何番目のグリッドに設定するか。0～
	 * @param w 何個分のグリッド幅にするか。
	 * @param h 何個分のグリッド高さにするか。
	 * <p>[備 考] </p>
	 */
	void addComp(Component comp, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gblayout.setConstraints(comp, gbc);
		panel.add(comp);
	}

	void remComp(Component delComp, Component newComp, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gblayout.removeLayoutComponent(delComp);
		gblayout.setConstraints(newComp, gbc);
		panel.remove(delComp);
		panel.add(newComp);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
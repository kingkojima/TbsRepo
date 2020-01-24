package jp.ne.tbs.view.PA01;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.view.MFM00V001Z00;

/**
 * <p>[クラス名]</p>
 * 　　PaP/PPIスコア　入力画面
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 *  2019/12/06　小嶋純史　新規作成
 *  2020/01/21　小嶋純史　項目/選択肢を含めて出力するボタンを追加
 */
public class MPA01V001Z00 extends JFrame implements ActionListener {

	/** 部品群 */
	private JPanel panel_1;
	private JPanel panel_2;
	private GridBagLayout gblayout;
	private GridBagConstraints gbc;

	/** PaP */
	/** コンボボックス(臨床的な予後の予測) */
	JComboBox<?> combo1;
	/** コンボボックス(Karnofsky Performance Scale) */
	JComboBox<?> combo2;
	/** コンボボックス(食欲不振) */
	JComboBox<?> combo3;
	/** コンボボックス(呼吸困難) */
	JComboBox<?> combo4;
	/** コンボボックス(白血球数(/m㎥)) */
	JComboBox<?> combo5;
	/** コンボボックス(リンパ球 (%)) */
	JComboBox<?> combo6;

	/** PPI */
	/** コンボボックス(Palliative Performance Scale) */
	JComboBox<?> combo7;
	/** コンボボックス(経口摂取量) */
	JComboBox<?> combo8;
	/** コンボボックス(浮腫) */
	JComboBox<?> combo9;
	/** コンボボックス(安静時呼吸困難) */
	JComboBox<?> combo10;
	/** コンボボックス(せん妄) */
	JComboBox<?> combo11;

	/** クリップボードにコピーボタン */
	JButton button_1;
	/** クリアボタン */
	JButton button_2;
	/** 戻るボタン */
	JButton button_3;
	/** 項目名/選択肢を含めて出力ボタン */
	JButton button_4;

	/** 点数ラベル */

	/** PaP */
	JLabel label_3_3 = null;
	JLabel label_4_3 = null;
	JLabel label_5_3 = null;
	JLabel label_6_3 = null;
	JLabel label_7_3 = null;
	JLabel label_8_3 = null;
	JLabel label_10_3 = null;
	/** PPI */
	JLabel label_15_3 = null;
	JLabel label_16_3 = null;
	JLabel label_17_3 = null;
	JLabel label_18_3 = null;
	JLabel label_19_3 = null;
	JLabel label_21_3 = null;

	/** コンボリストのデータ */

	/** PaP */
	/** 臨床的な予後の予測 */
	String[] comb_1 = { "", "１～２週", "３～４週", "５～６週", "７～１０週", "１１～12週", "13週以上" };
	/** Karnofsky Performance Scale */
	String[] comb_2 = { "", "１０～２０", "３０以上" };
	/** 食欲不振*/
	String[] comb_3 = { "", " あり　　 ", " なし　　 " };
	/** 呼吸困難 */
	String[] comb_4 = { "", " あり　　 ", " なし　　 " };
	/** 白血球数(/m㎥) */
	String[] comb_5 = { "", ">11000", "8501～11000", "≦8500" };
	/** リンパ球 (%) */
	String[] comb_6 = { "", "0～11.9", "12～19.9", "≧20" };

	/** PPI */
	/** Palliative Performance Scale */
	String[] comb_7 = { "", "10～20", "30～50", "60以上" };
	/** 経口摂取量*/
	String[] comb_8 = { "", "著明に減少（数口以下）", "中程度減少（減少しているが数口よりは多い）", "正常" };
	/** 浮腫 */
	String[] comb_9 = { "", " あり　　 ", " なし　　 " };
	/** 安静時呼吸困難 */
	String[] comb_10 = { "", " あり　　 ", " なし　　 " };
	/** せん妄 */
	String[] comb_11 = { "", " あり（原因が薬物単独のものは含めない）", " なし　　 " };

	/** 項目ラベル */
	JLabel label_1 = new JLabel("PaPスコア");
	JLabel label_3_1 = new JLabel("臨床的な予後の予測");
	JLabel label_4_1 = new JLabel("Karnofsky Performance Scale　");
	JLabel label_5_1 = new JLabel("食欲不振");
	JLabel label_6_1 = new JLabel("呼吸困難");
	JLabel label_7_1 = new JLabel("白血球数(/m㎥)");
	JLabel label_8_1 = new JLabel("リンパ球 (%)");
	JLabel label_10_1 = new JLabel("PaP得点");
	JLabel label_13 = new JLabel("PPIスコア");
	JLabel label_15_1 = new JLabel("Palliative Performance Scale");
	JLabel label_16_1 = new JLabel("経口摂取量");
	JLabel label_17_1 = new JLabel("浮腫");
	JLabel label_18_1 = new JLabel("安静時呼吸困難");
	JLabel label_19_1 = new JLabel("せん妄");
	JLabel label_21_1 = new JLabel("PPI得点");

	//判定結果
	String result_PaP = null;
	String result_PPI = null;

	/**
	 * <p>[概 要] </p>
	 * 　汎用検索　実行メソッド<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	public static void exec() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MPA01V001Z00 fluFrame = new MPA01V001Z00();
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
	public MPA01V001Z00() {

		//画面設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 10, 650, 720);
		setTitle("予後予測ツール");

		//パネル,GBL,GBCを生成。
		panel_1 = new JPanel();
		gblayout = new GridBagLayout();
		gbc = new GridBagConstraints();
		panel_1.setLayout(gblayout);

		panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(1, 3));

		//=============
		//PaP==========
		//=============

		//１行目
		//PaPスコア タイトル
		label_1.setFont(new Font("メイリオ", Font.BOLD, 26));
		this.addComp(label_1, 0, 0, 3, 1);

		//２行目
		//項目名
		JLabel label_2_1 = new JLabel("項目　　　　　　　　　　　　　");
		label_2_1.setFont(new Font("メイリオ", Font.BOLD, 15));
		this.addComp(label_2_1, 0, 1, 1, 1);

		JLabel label_2_2 = new JLabel("選択肢　　　　　　　　");
		label_2_2.setFont(new Font("メイリオ", Font.BOLD, 15));
		this.addComp(label_2_2, 1, 1, 1, 1);

		JLabel label_2_3 = new JLabel("点数");
		label_2_3.setFont(new Font("メイリオ", Font.BOLD, 15));
		this.addComp(label_2_3, 2, 1, 1, 1);

		//３行目
		//臨床的な予後の予測
		label_3_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_3_1, 0, 2, 1, 1);

		combo1 = new JComboBox<>(comb_1);
		combo1.addActionListener(this);
		combo1.setActionCommand("yogoyosoku");
		this.addComp(combo1, 1, 2, 1, 1);

		label_3_3 = new JLabel("0.0");
		label_3_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_3_3, 2, 2, 1, 1);

		//４行目
		//Karnofsky Performance Scale
		label_4_1.setFont(new Font("メイリオ", Font.PLAIN, 16));
		this.addComp(label_4_1, 0, 3, 1, 1);

		combo2 = new JComboBox<>(comb_2);
		combo2.addActionListener(this);
		combo2.setActionCommand("kps");
		this.addComp(combo2, 1, 3, 1, 1);

		label_4_3 = new JLabel("0.0");
		label_4_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_4_3, 2, 3, 1, 1);

		//５行目
		//食欲不振
		label_5_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_5_1, 0, 4, 1, 1);

		combo3 = new JComboBox<>(comb_3);
		combo3.addActionListener(this);
		combo3.setActionCommand("shokuyoku");
		this.addComp(combo3, 1, 4, 1, 1);

		label_5_3 = new JLabel("0.0");
		label_5_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_5_3, 2, 4, 1, 1);

		//６行目
		//呼吸困難
		label_6_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_6_1, 0, 5, 1, 1);

		combo4 = new JComboBox<>(comb_4);
		combo4.addActionListener(this);
		combo4.setActionCommand("kokyu");
		this.addComp(combo4, 1, 5, 1, 1);

		label_6_3 = new JLabel("0.0");
		label_6_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_6_3, 2, 5, 1, 1);

		//７行目
		//白血球数(/m㎥)
		label_7_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_7_1, 0, 6, 1, 1);

		combo5 = new JComboBox<>(comb_5);
		combo5.addActionListener(this);
		combo5.setActionCommand("hakekyu");
		this.addComp(combo5, 1, 6, 1, 1);

		label_7_3 = new JLabel("0.0");
		label_7_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_7_3, 2, 6, 1, 1);

		//８行目
		//リンパ球 (%)
		label_8_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_8_1, 0, 7, 1, 1);

		combo6 = new JComboBox<>(comb_6);
		combo6.addActionListener(this);
		combo6.setActionCommand("linpa");
		this.addComp(combo6, 1, 7, 1, 1);

		label_8_3 = new JLabel("0.0");
		label_8_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_8_3, 2, 7, 1, 1);

		//９行目(改行のための空白文字)
		JLabel label_9 = new JLabel("　");
		label_9.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_9, 0, 8, 3, 1);

		//１０行目
		//PaP得点
		label_10_1.setFont(new Font("メイリオ", Font.BOLD, 15));
		this.addComp(label_10_1, 1, 9, 1, 1);

		label_10_3 = new JLabel("0.0");
		label_10_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_10_3, 2, 9, 1, 1);

		//１１行目(改行のための空白文字)
		JLabel label_11 = new JLabel("　");
		label_11.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_11, 0, 10, 3, 1);

		//１２行目(改行のための空白文字)
		JLabel label_12 = new JLabel("　");
		label_12.setFont(new Font("メイリオ", Font.PLAIN, 6));
		this.addComp(label_12, 0, 11, 3, 1);

		//=============
		//PPI==========
		//=============

		//１３行目
		//PPIスコア
		label_13.setFont(new Font("メイリオ", Font.BOLD, 26));
		this.addComp(label_13, 0, 12, 3, 1);

		//１４行目
		//項目名
		JLabel label_14_1 = new JLabel("項目　　　　　　　　　　　　　");
		label_14_1.setFont(new Font("メイリオ", Font.BOLD, 15));
		this.addComp(label_14_1, 0, 13, 1, 1);

		JLabel label_14_2 = new JLabel("選択肢　　　　　　　　");
		label_14_2.setFont(new Font("メイリオ", Font.BOLD, 15));
		this.addComp(label_14_2, 1, 13, 1, 1);

		JLabel label_14_3 = new JLabel("点数");
		label_14_3.setFont(new Font("メイリオ", Font.BOLD, 15));
		this.addComp(label_14_3, 2, 13, 1, 1);

		//１５行目
		//Palliative Performance Scale
		label_15_1.setFont(new Font("メイリオ", Font.PLAIN, 16));
		this.addComp(label_15_1, 0, 14, 1, 1);

		combo7 = new JComboBox<>(comb_7);
		combo7.addActionListener(this);
		combo7.setActionCommand("pps");
		this.addComp(combo7, 1, 14, 1, 1);

		label_15_3 = new JLabel("0.0");
		label_15_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_15_3, 2, 14, 1, 1);

		//１６行目
		//経口摂取量
		label_16_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_16_1, 0, 15, 1, 1);

		combo8 = new JComboBox<>(comb_8);
		combo8.setFont(new Font("メイリオ", Font.PLAIN, 10));
		combo8.addActionListener(this);
		combo8.setActionCommand("keikou");
		this.addComp(combo8, 1, 15, 1, 1);

		label_16_3 = new JLabel("0.0");
		label_16_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_16_3, 2, 15, 1, 1);

		//１７行目
		//浮腫
		label_17_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_17_1, 0, 16, 1, 1);

		combo9 = new JComboBox<>(comb_9);
		combo9.addActionListener(this);
		combo9.setActionCommand("fusyu");
		this.addComp(combo9, 1, 16, 1, 1);

		label_17_3 = new JLabel("0.0");
		label_17_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_17_3, 2, 16, 1, 1);

		//１８行目
		//安静時呼吸困難
		label_18_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_18_1, 0, 17, 1, 1);

		combo10 = new JComboBox<>(comb_10);
		combo10.addActionListener(this);
		combo10.setActionCommand("akokyu");
		this.addComp(combo10, 1, 17, 1, 1);

		label_18_3 = new JLabel("0.0");
		label_18_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_18_3, 2, 17, 1, 1);

		//１９行目
		//せん妄
		label_19_1.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_19_1, 0, 18, 1, 1);

		combo11 = new JComboBox<>(comb_11);
		combo11.setFont(new Font("メイリオ", Font.PLAIN, 10));
		combo11.addActionListener(this);
		combo11.setActionCommand("senmou");
		this.addComp(combo11, 1, 18, 1, 1);

		label_19_3 = new JLabel("0.0");
		label_19_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_19_3, 2, 18, 1, 1);

		//２０行目(改行のための空白文字)
		JLabel label_20 = new JLabel("　");
		label_20.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_20, 0, 19, 3, 1);

		//２１行目
		//PPI得点
		label_21_1.setFont(new Font("メイリオ", Font.BOLD, 15));
		this.addComp(label_21_1, 1, 20, 1, 1);

		label_21_3 = new JLabel("0.0");
		label_21_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_21_3, 2, 20, 1, 1);

		//２２行目(改行のための空白文字)
//		JLabel label_22 = new JLabel("　");
//		label_22.setFont(new Font("メイリオ", Font.PLAIN, 10));
//		this.addComp(label_22, 0, 21, 3, 1);

		//パネルを設定。
		getContentPane().add(panel_1, BorderLayout.NORTH);

		//ボタン群
		button_1 = new JButton("点数のみｺﾋﾟｰ");
		button_1.addActionListener(this);
		button_1.setFont(new Font("メイリオ", Font.BOLD, 18));
		button_1.setActionCommand("copy_btn");
		panel_2.add(button_1);

		button_4 = new JButton("すべてｺﾋﾟｰ");
		button_4.addActionListener(this);
		button_4.setFont(new Font("メイリオ", Font.BOLD, 18));
		button_4.setActionCommand("all_copy_btn");
		panel_2.add(button_4);

		button_2 = new JButton("ｸﾘｱ");
		button_2.addActionListener(this);
		button_2.setFont(new Font("メイリオ", Font.BOLD, 18));
		button_2.setActionCommand("clear_btn");
		panel_2.add(button_2);

		button_3 = new JButton("終了");
		button_3.addActionListener(this);
		button_3.setFont(new Font("メイリオ", Font.BOLD, 18));
		button_3.setActionCommand("back_btn");
		panel_2.add(button_3);

		//パネルを設定。
		getContentPane().add(panel_2, BorderLayout.SOUTH);

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

		//PaP=============================

		//「臨床的な予後の予測」の場合
		if (cmd.equals("yogoyosoku")) {

			//選択内容を取得。
			String sItem = (String) combo1.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals("１～２週")) {
				score = 8.5;
			} else if (sItem.equals("３～４週")) {
				score = 6.0;
			} else if (sItem.equals("５～６週")) {
				score = 4.5;
			} else if (sItem.equals("７～１０週")) {
				score = 2.5;
			} else if (sItem.equals("１１～12週")) {
				score = 2.5;
			} else if (sItem.equals("13週以上")) {
				score = 0;
			}

			label_3_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPaP();

			//「Karnofsky Performance Scale」の場合
		} else if (cmd.equals("kps")) {

			//選択内容を取得。
			String sItem = (String) combo2.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals("１０～２０")) {
				score = 2.5;
			} else if (sItem.equals("３０以上")) {
				score = 0;
			}

			label_4_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPaP();

			//「食欲不振」の場合
		} else if (cmd.equals("shokuyoku")) {

			//選択内容を取得。
			String sItem = (String) combo3.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals(" あり　　 ")) {
				score = 1.5;
			} else if (sItem.equals(" なし　　 ")) {
				score = 0;
			}

			label_5_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPaP();

			//「呼吸困難」の場合
		} else if (cmd.equals("kokyu")) {

			//選択内容を取得。
			String sItem = (String) combo4.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals(" あり　　 ")) {
				score = 1.0;
			} else if (sItem.equals(" なし　　 ")) {
				score = 0;
			}

			label_6_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPaP();

			//「白血球数(/m㎥)」の場合
		} else if (cmd.equals("hakekyu")) {

			//選択内容を取得。
			String sItem = (String) combo5.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals(">11000")) {
				score = 1.5;
			} else if (sItem.equals("8501～11000")) {
				score = 0.5;
			} else if (sItem.equals("≦8500")) {
				score = 0;
			}

			label_7_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPaP();

			//「リンパ球 (%)」の場合
		} else if (cmd.equals("linpa")) {

			//選択内容を取得。
			String sItem = (String) combo6.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals("0～11.9")) {
				score = 2.5;
			} else if (sItem.equals("12～19.9")) {
				score = 1.0;
			} else if (sItem.equals("≧20")) {
				score = 0;
			}

			label_8_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPaP();


			//PPI=============================

			//「Palliative Performance Scale」の場合
		} else if (cmd.equals("pps")) {

			//選択内容を取得。
			String sItem = (String) combo7.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals("10～20")) {
				score = 4.0;
			} else if (sItem.equals("30～50")) {
				score = 2.5;
			} else if (sItem.equals("60以上")) {
				score = 0;
			}

			label_15_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPPI();

			//「経口摂取量」の場合
		} else if (cmd.equals("keikou")) {

			//選択内容を取得。
			String sItem = (String) combo8.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals("著明に減少（数口以下）")) {
				score = 2.5;
			} else if (sItem.equals("中程度減少（減少しているが数口よりは多い）")) {
				score = 1.0;
			} else if (sItem.equals("正常")) {
				score = 0;
			}

			label_16_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPPI();

			//「浮腫」の場合
		} else if (cmd.equals("fusyu")) {

			//選択内容を取得。
			String sItem = (String) combo9.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals(" あり　　 ")) {
				score = 1.0;
			} else if (sItem.equals(" なし　　 ")) {
				score = 0;
			}

			label_17_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPPI();

			//「安静時呼吸困難」の場合
		} else if (cmd.equals("akokyu")) {

			//選択内容を取得。
			String sItem = (String) combo10.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals(" あり　　 ")) {
				score = 3.5;
			} else if (sItem.equals(" なし　　 ")) {
				score = 0;
			}

			label_18_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPPI();

			//「せん妄」の場合
		} else if (cmd.equals("senmou")) {

			//選択内容を取得。
			String sItem = (String) combo11.getSelectedItem();
			double score = 0;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("")) {
				score = 0;
			} else if (sItem.equals(" あり（原因が薬物単独のものは含めない）")) {
				score = 4.0;
			} else if (sItem.equals(" なし　　 ")) {
				score = 0;
			}

			label_19_3.setText(BigDecimal.valueOf(score).toPlainString());

			//得点計算
			this.calcPointPPI();

			//「点数のみコピー」の場合
		} else if (cmd.equals("copy_btn")) {

			this.clipboardCopy();

			//「すべてコピー」の場合
		} else if (cmd.equals("all_copy_btn")) {

			this.clipboardAllCopy();

			//「クリア」の場合
		} else if (cmd.equals("clear_btn")) {

			this.dataClear();

			//「戻る」の場合
		} else if (cmd.equals("back_btn")) {

			//メインフレームを生成し実行。
			MFM00V001Z00 frame = new MFM00V001Z00();
			frame.setVisible(true);

			//処理が終わったら画面終了
			this.dispose();

		}
	}

	/**
	 * <p>[概 要] </p>
	 * 　PaPスコア計算処理<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	private void calcPointPaP() {

		double total = 0;

		//臨床的な予後の予測
		if(!label_3_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_3_3.getText());
		}

		//Karnofsky Performance Scale
		if(!label_4_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_4_3.getText());
		}

		//食欲不振
		if(!label_5_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_5_3.getText());
		}

		//呼吸困難
		if(!label_6_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_6_3.getText());
		}

		//白血球数(/m㎥)
		if(!label_7_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_7_3.getText());
		}

		//白血球数(/m㎥)
		if(!label_8_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_8_3.getText());
		}

		//得点の出力
		label_10_3.setText(BigDecimal.valueOf(total).toPlainString());

		//判定結果
		if(total >= 9.0) {
			result_PaP = "21日以下(週単位)の可能性が高い";
		} else if(total <= 5.5) {
			result_PaP = "30日以上(月単位)の可能性が高い";
		} else {
			result_PaP = "なし※後で確認";
		}

	}

	/**
	 * <p>[概 要] </p>
	 * 　PPIスコア計算処理<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	private void calcPointPPI() {

		double total = 0;

		//Palliative Performance Scale
		if(!label_15_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_15_3.getText());
		}

		//経口摂取量
		if(!label_16_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_16_3.getText());
		}

		//浮腫
		if(!label_17_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_17_3.getText());
		}

		//安静時呼吸困難
		if(!label_18_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_18_3.getText());
		}

		//せん妄
		if(!label_19_3.getText().isEmpty()) {

			total = total + Double.parseDouble(label_19_3.getText());
		}

		//得点の出力
		label_21_3.setText(BigDecimal.valueOf(total).toPlainString());

		//判定結果
		if(total >= 6.5) {
			result_PPI = "21日以下(週単位)の可能性が高い";
		} else if(total <= 3.5) {
			result_PPI = "42日以上(月単位)の可能性が高い";
		} else {
			result_PPI = "なし※後で確認";
		}

	}

	/**
	 * <p>[概 要] </p>
	 * 　点数のみコピー処理<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	private void clipboardCopy() {

		//文字列作成
		String resultPaP = MAAT00.CHAR.EMPTY_STRING;
		resultPaP = "PaP: " + label_3_3.getText() + MAAT00.CHAR.PLUS
				+ label_4_3.getText() + MAAT00.CHAR.PLUS
				+ label_5_3.getText() + MAAT00.CHAR.PLUS
				+ label_6_3.getText() + MAAT00.CHAR.PLUS
				+ label_7_3.getText() + MAAT00.CHAR.PLUS
				+ label_8_3.getText() + MAAT00.CHAR.EQUAL
				+ label_10_3.getText();

		String resultPPI = MAAT00.CHAR.EMPTY_STRING;
		resultPPI = "PPI: " + label_15_3.getText() + MAAT00.CHAR.PLUS
				+ label_16_3.getText() + MAAT00.CHAR.PLUS
				+ label_17_3.getText() + MAAT00.CHAR.PLUS
				+ label_18_3.getText() + MAAT00.CHAR.PLUS
				+ label_19_3.getText() + MAAT00.CHAR.EQUAL
				+ label_21_3.getText();

		//クリップボードにコピー
		Toolkit kit = Toolkit.getDefaultToolkit();
		Clipboard clip = kit.getSystemClipboard();

		StringSelection ss = new StringSelection(resultPaP + MAAT00.CHAR.CRLF + resultPPI);
		clip.setContents(ss, ss);

	}

	/**
	 * <p>[概 要] </p>
	 * 　すべてコピー処理<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	private void clipboardAllCopy() {

		//文字列作成
		String resultPaP = MAAT00.CHAR.EMPTY_STRING;
		resultPaP = "＊＊＊＊＊" + label_1.getText() + "＊＊＊＊＊" + MAAT00.CHAR.CRLF
			+ label_3_1.getText() + "　　" + (String) combo1.getSelectedItem() + "　　" + label_3_3.getText() + MAAT00.CHAR.CRLF
			+ label_4_1.getText() + "　　" + (String) combo2.getSelectedItem() + "　　" + label_4_3.getText() + MAAT00.CHAR.CRLF
			+ label_5_1.getText() + "　　" + (String) combo3.getSelectedItem() + "　　" + label_5_3.getText() + MAAT00.CHAR.CRLF
			+ label_6_1.getText() + "　　" + (String) combo4.getSelectedItem() + "　　" + label_6_3.getText() + MAAT00.CHAR.CRLF
			+ label_7_1.getText() + "　　" + (String) combo5.getSelectedItem() + "　　" + label_7_3.getText() + MAAT00.CHAR.CRLF
			+ label_8_1.getText() + "　　" + (String) combo6.getSelectedItem() + "　　" + label_8_3.getText() + MAAT00.CHAR.CRLF
			+ "=====================================" + MAAT00.CHAR.CRLF
			+ "＜＜＜＜" + label_10_1.getText() + "　　" + label_10_3.getText() + "　＞＞＞＞" + MAAT00.CHAR.CRLF
			+ "＜" + result_PaP + "＞";

		String resultPPI = MAAT00.CHAR.EMPTY_STRING;
		resultPPI = "＊＊＊＊＊" + label_13.getText()+ "＊＊＊＊＊" + MAAT00.CHAR.CRLF
			+ label_15_1.getText() + "　　" + (String) combo7.getSelectedItem() + "　　" + label_15_3.getText() + MAAT00.CHAR.CRLF
			+ label_16_1.getText() + "　　" + (String) combo8.getSelectedItem() + "　　" + label_16_3.getText() + MAAT00.CHAR.CRLF
			+ label_17_1.getText() + "　　" + (String) combo9.getSelectedItem() + "　　" + label_17_3.getText() + MAAT00.CHAR.CRLF
			+ label_18_1.getText() + "　　" + (String) combo10.getSelectedItem() + "　　" + label_18_3.getText() + MAAT00.CHAR.CRLF
			+ label_19_1.getText() + "　　" + (String) combo11.getSelectedItem() + "　　" + label_19_3.getText() + MAAT00.CHAR.CRLF
			+ "=====================================" + MAAT00.CHAR.CRLF
			+ "＜＜＜＜" + label_21_1.getText() + "　　" + label_21_3.getText() + "　＞＞＞＞" + MAAT00.CHAR.CRLF
			+ "＜" + result_PPI + "＞";

		//クリップボードにコピー
		Toolkit kit = Toolkit.getDefaultToolkit();
		Clipboard clip = kit.getSystemClipboard();

		StringSelection ss = new StringSelection(resultPaP + MAAT00.CHAR.CRLF + MAAT00.CHAR.CRLF + resultPPI);
		clip.setContents(ss, ss);

	}

	/**
	 * <p>[概 要] </p>
	 * 　データクリア処理<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	private void dataClear() {

		//すべて初期値を選ぶ
		combo1.setSelectedIndex(0);
		combo2.setSelectedIndex(0);
		combo3.setSelectedIndex(0);
		combo4.setSelectedIndex(0);
		combo5.setSelectedIndex(0);
		combo6.setSelectedIndex(0);
		combo7.setSelectedIndex(0);
		combo8.setSelectedIndex(0);
		combo9.setSelectedIndex(0);
		combo10.setSelectedIndex(0);
		combo11.setSelectedIndex(0);

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
		gbc.anchor = GridBagConstraints.LINE_START;
		gblayout.setConstraints(comp, gbc);
		panel_1.add(comp);
	}

}
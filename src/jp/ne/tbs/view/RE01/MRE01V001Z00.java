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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import jp.ne.tbs.control.FD03.MFD03B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B003Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.view.MFM00V001Z00;
import jp.ne.tbs.view.FD03.MFD03V001Z00;

/**
 * <p>[クラス名]</p>
 * 　　報告書データ作成　メイン画面
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2019/12/27　小嶋純史　新規作成
 */
public class MRE01V001Z00 extends JFrame implements ActionListener {

	/** 部品群 */
	private JPanel panel;
	private GridBagLayout gblayout;
	private GridBagConstraints gbc;

	/** 集計開始日テキスト */
	JTextField text_1;
	/** 集計終了日テキスト */
	JTextField text_2;

	/** 検索文字１テキスト */
	JTextField text_3;
	/** 検索文字２テキスト */
	JTextField text_4;
	/** 検索文字３テキスト */
	JTextField text_5;

	/** 区切文字１(始) */
	JComboBox<?> combo1;
	/** 区切文字１(終) */
	JComboBox<?> combo2;
	/** 区切文字２(始) */
	JComboBox<?> combo3;
	/** 区切文字２(終) */
	JComboBox<?> combo4;
	/** 区切文字３(始) */
	JComboBox<?> combo5;
	/** 区切文字３(終) */
	JComboBox<?> combo6;

	/** 戻るボタン */
	JButton button_1;
	/** 集計ボタン */
	JButton button_2;

	/** 進捗バー */
	JProgressBar pgBar = null;
	/** 表示ラベル */
	JLabel label_6 = null;
	/** 表示ラベル(進捗バーにあたる場所) */
	JLabel label_7 = null;

	/** コンボリスト(区切り(始))のデータ */
	String[] comb_str  = {"なし", "改行", "。(句点)", ",(カンマ)", ":(コロン)"};

	/** コンボリスト(区切り(終))のデータ */
	String[] comb_end  = {"改行", "。(句点)", ",(カンマ)", ":(コロン)"};

	/** 業務処理スレッド */
	BusinessThread bizTh;


	/**
	 * <p>[概 要] </p>
	 * 　汎用検索　実行メソッド<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	public static void exec() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MFD03V001Z00 fluFrame = new MFD03V001Z00();
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
		setBounds(800, 100, 400, 480);
		setTitle("汎用検索君");

		//パネル,GBL,GBCを生成。
		panel = new JPanel();
		gblayout = new GridBagLayout();
		gbc = new GridBagConstraints();
		panel.setLayout(gblayout);

		//１行目
		JLabel label_1 = new JLabel("カルテ汎用検索君");
		label_1.setFont(new Font("メイリオ", Font.BOLD, 26));
		this.addComp(label_1, 0, 0, 3, 1);

		//２行目
		JLabel label_2 = new JLabel("集計開始日");
		label_2.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_2, 0, 1, 1, 1);

		JLabel label_4 = new JLabel("集計終了日");
		label_4.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_4, 2, 1, 1, 1);

		//３行目
		text_1 = new JTextField("2018/01/01");
		text_1.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_1.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_1, 0, 2, 1, 1);

		JLabel label_3 = new JLabel("　　～　　");
		label_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_3, 1, 2, 1, 1);

		text_2 = new JTextField("2018/12/31");
		text_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_2.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_2, 2, 2, 1, 1);

		//４行目(改行のための空白文字)
		JLabel label_5 = new JLabel("　");
		label_5.setFont(new Font("メイリオ", Font.PLAIN, 15));
		this.addComp(label_5, 0, 3, 3, 1);

		//５行目
		JLabel label_9 = new JLabel("検索文字");
		label_9.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_9, 0, 4, 1, 1);

		JLabel label_10 = new JLabel("区切り(始)");
		label_10.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_10, 1, 4, 1, 1);

		JLabel label_11 = new JLabel("区切り(終)");
		label_11.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_11, 2, 4, 1, 1);

		//６行目　検索文字１
		text_3 = new JTextField("検索文字１");
		text_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_3.setHorizontalAlignment(JTextField.CENTER);
		text_3.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_3, 0, 5, 1, 1);

		combo1 = new JComboBox<>(comb_str);
		this.addComp(combo1, 1, 5, 1, 1);

		combo2 = new JComboBox<>(comb_end);
		this.addComp(combo2, 2, 5, 1, 1);

		//７行目　検索文字２
		text_4 = new JTextField("検索文字２");
		text_4.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_4.setHorizontalAlignment(JTextField.CENTER);
		text_4.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_4, 0, 6, 1, 1);

		combo3 = new JComboBox<>(comb_str);
		this.addComp(combo3, 1, 6, 1, 1);

		combo4 = new JComboBox<>(comb_end);
		this.addComp(combo4, 2, 6, 1, 1);

		//8行目　検索文字3
		text_5 = new JTextField("検索文字３");
		text_5.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_5.setHorizontalAlignment(JTextField.CENTER);
		text_5.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_5, 0, 7, 1, 1);

		combo5 = new JComboBox<>(comb_str);
		this.addComp(combo5, 1, 7, 1, 1);

		combo6 = new JComboBox<>(comb_end);
		this.addComp(combo6, 2, 7, 1, 1);

		//９行目(進捗バーのための余白)
		label_9 = new JLabel("　");
		label_9.setFont(new Font("メイリオ", Font.PLAIN, 13));
		this.addComp(label_9, 0, 8, 3, 1);

		//１０行目(進捗バーのラベル)
		label_6 = new JLabel("開始日/終了日/検索文字列/を入力し集計ボタンを押してください");
		label_6.setFont(new Font("メイリオ", Font.PLAIN, 10));
		label_6.setForeground(Color.BLUE);
		this.addComp(label_6, 0, 9, 3, 1);

		//１１行目(進捗バーのための余白)
		label_7 = new JLabel("　");
		label_7.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_7, 0, 10, 3, 1);

		//進捗バーはここで生成しておく
		pgBar = new JProgressBar(0, 100);
		pgBar.setStringPainted(true);

		//１２行目(改行のための空白文字)
		JLabel label_8 = new JLabel("　");
		label_8.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_8, 0, 11, 3, 1);

		//１３行目
		button_1 = new JButton("戻る");
		button_1.addActionListener(this);
		button_1.setFont(new Font("メイリオ", Font.PLAIN, 18));
		button_1.setActionCommand("return_btn");
		this.addComp(button_1, 0, 12, 1, 1);

		button_2 = new JButton("検索");
		button_2.addActionListener(this);
		button_2.setFont(new Font("メイリオ", Font.PLAIN, 18));
		button_2.setActionCommand("calc_btn");
		this.addComp(button_2, 2, 12, 1, 1);

		//パネルを設定。
		getContentPane().add(panel, BorderLayout.CENTER);
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

		//「戻る」の場合
		if (cmd.endsWith("return_btn")) {

			//メインフレームを生成し実行。
			MFM00V001Z00 frame = new MFM00V001Z00();
			frame.setVisible(true);

			//処理が終わったら画面終了
			this.dispose();

			//「集計」の場合
		} else if (cmd.endsWith("calc_btn")) {

			//ボタンを非活性
			button_1.setEnabled(false);
			button_2.setEnabled(false);

			//業務処理スタート
			bizTh = new BusinessThread();
			bizTh.start();
		}
	}

	//業務処理
	class BusinessThread extends Thread {

		public void run() {

			label_6.setText("しばらくお待ちください。");

			remComp(label_7, pgBar, 0, 9, 3, 1);

			//appData作成
			MAA00B003Z00 appData = new MAA00B003Z00();
			appData.setMsgIn(MAAT00.DCP_SRT, text_1.getText());
			appData.setMsgIn(MAAT00.DCP_END, text_2.getText());

			appData.setMsgIn(MAAT00.ITM_NME_1, text_3.getText());
			appData.setMsgIn(MAAT00.ITM_DLM_1, convComb(combo1));
			appData.setMsgIn(MAAT00.ITM_END_1, convComb(combo2));

			appData.setMsgIn(MAAT00.ITM_NME_2, text_4.getText());
			appData.setMsgIn(MAAT00.ITM_DLM_2, convComb(combo3));
			appData.setMsgIn(MAAT00.ITM_END_2, convComb(combo4));

			appData.setMsgIn(MAAT00.ITM_NME_3, text_5.getText());
			appData.setMsgIn(MAAT00.ITM_DLM_3, convComb(combo5));
			appData.setMsgIn(MAAT00.ITM_END_3, convComb(combo6));

			try {

				//カルテ汎用検索クラスを実行
				MAA00B001Z00 fluDsrObj = new MFD03B001Z00();
				fluDsrObj.execute(appData, pgBar);

				//業務エラーが発生していた場合は画面を閉じずに終了。
				if (fluDsrObj.getAllInOneData().getCa().errOccurred()) {
					label_6.setText("×ボタンで画面を閉じて、最初からやり直して下さい。");
					return;
				}

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}
			label_6.setText("×ボタンで画面を閉じて下さい。");
		}

		private String convComb(JComboBox<?> combo) {

			//選択内容を取得。
			String sItem = (String) combo.getSelectedItem();
			String result = MAAT00.CHAR.EMPTY_STRING;

			//選択内容ごとに返却文字を変換。
			if (sItem.equals("なし")) {
				result = MAAT00.CHAR.EMPTY_STRING;
			} else if(sItem.equals("改行")) {
				result = MAAT00.CHAR.CRLF;
			} else if(sItem.equals("。(句点)")) {
				result = MAAT00.CHAR.KUTEN;
			} else if(sItem.equals(",(カンマ)")) {
				result = MAAT00.CHAR.COMMA;
			} else if(sItem.equals(":(コロン)")) {
				result = MAAT00.CHAR.COLON;
			}
			return result;
		}

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

}
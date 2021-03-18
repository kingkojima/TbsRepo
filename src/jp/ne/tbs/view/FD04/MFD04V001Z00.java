package jp.ne.tbs.view.FD04;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import jp.ne.tbs.control.FD04.MFD04B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B003Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.view.MFM00V001Z00;

/**
 * <p>[クラス名]</p>
 * 新型コロナワクチン接種希望集計　メイン画面
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 2021/03/08 小嶋純史 コピー新規作成
 */
public class MFD04V001Z00 extends JFrame implements ActionListener {

	/** 部品群 */
	private JPanel panel;
	private GridBagLayout gblayout;
	private GridBagConstraints gbc;

	/** 集計開始日テキスト */
	JTextField text_1;
	/** 集計終了日テキスト */
	JTextField text_2;

	/** 死亡・終了の除外チェックボックス */
	JCheckBox check_1;

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

	/** 業務処理スレッド */
	BusinessThread bizTh;

	/**
	 * <p>[概 要] </p>
	 * 　新型コロナワクチン接種希望集計　実行メソッド<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	public static void exec() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MFD04V001Z00 fluFrame = new MFD04V001Z00();
				fluFrame.setVisible(true);
			}
		});
	}

	/**
	 * <p>[概 要] </p>
	 * 　新型コロナワクチン接種希望集計　コンストラクタ<BR>
	 * <p>[詳 細] </p>
	 * 　画面のレイアウトを作成する。
	 * <p>[備 考] </p>
	 */
	public MFD04V001Z00() {

		//画面設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 400, 350);
		setTitle("新型コロナ希望集計君");

		//パネル,GBL,GBCを生成。
		panel = new JPanel();
		gblayout = new GridBagLayout();
		gbc = new GridBagConstraints();
		panel.setLayout(gblayout);

		//１行目
		JLabel label_1 = new JLabel("新型コロナワクチン希望集計");
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
		text_1 = new JTextField("2021/02/01");
		text_1.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_1.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_1, 0, 2, 1, 1);

		JLabel label_3 = new JLabel("　～　");
		label_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_3, 1, 2, 1, 1);

		text_2 = new JTextField("2021/04/30");
		text_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_2.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_2, 2, 2, 1, 1);

		//改行のための空白文字
		JLabel label_9 = new JLabel("　");
		label_9.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_9, 0, 3, 3, 1);

		check_1 = new JCheckBox("本日時点の死亡者・終了社を除く");
		check_1.setFont(new Font("メイリオ", Font.PLAIN, 10));
		check_1.setSelected(true);
		this.addComp(check_1, 0, 4, 3, 1);

		//４行目(改行のための空白文字)
		JLabel label_5 = new JLabel("　");
		label_5.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_5, 0, 5, 3, 1);

		//５行目(進捗バーのラベル)
		label_6 = new JLabel("開始日と終了日を入力し集計ボタンを押してください");
		label_6.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_6, 0, 6, 3, 1);

		//６行目(進捗バーのための余白)
		label_7 = new JLabel("　");
		label_7.setFont(new Font("メイリオ", Font.PLAIN, 13));
		this.addComp(label_7, 0, 7, 3, 1);

		//進捗バーはここで生成しておく
		pgBar = new JProgressBar(0, 100);
		pgBar.setStringPainted(true);

		//７行目(改行のための空白文字)
		JLabel label_8 = new JLabel("　");
		label_8.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_8, 0, 8, 3, 1);

		//８行目
		button_1 = new JButton("戻る");
		button_1.addActionListener(this);
		button_1.setFont(new Font("メイリオ", Font.PLAIN, 18));
		button_1.setActionCommand("return_btn");
		this.addComp(button_1, 0, 9, 1, 1);

		button_2 = new JButton("集計");
		button_2.addActionListener(this);
		button_2.setFont(new Font("メイリオ", Font.PLAIN, 18));
		button_2.setActionCommand("calc_btn");
		this.addComp(button_2, 2, 9, 1, 1);

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

			remComp(label_7, pgBar, 0, 5, 3, 1);

			//appData作成
			MAA00B003Z00 appData = new MAA00B003Z00();
			appData.setMsgIn(MAAT00.DCP_SRT, text_1.getText());
			appData.setMsgIn(MAAT00.DCP_END, text_2.getText());

			appData.setMsgIn(MAAT00.ITM_NME_1, "/*コロナワクチン希望");
			appData.setMsgIn(MAAT00.ITM_DLM_1, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_1, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_1, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_2, "■年齢");
			appData.setMsgIn(MAAT00.ITM_DLM_2, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_2, MAAT00.DROP.NUMBER);
			appData.setMsgIn(MAAT00.ITM_END_2, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_3, "■基礎疾患(64歳以下のみ)");
			appData.setMsgIn(MAAT00.ITM_DLM_3, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_3, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_3, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_4, "■医師の判断で接種");
			appData.setMsgIn(MAAT00.ITM_DLM_4, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_4, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_4, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_5, "■住まい");
			appData.setMsgIn(MAAT00.ITM_DLM_5, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_5, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_5, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_6, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_DLM_6, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_PTN_6, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_END_6, MAAT00.CHAR.EMPTY_STRING);

			appData.setMsgIn(MAAT00.ITM_NME_7, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_DLM_7, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_PTN_7, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_END_7, MAAT00.CHAR.EMPTY_STRING);

			appData.setMsgIn(MAAT00.ITM_NME_8, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_DLM_8, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_PTN_8, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_END_8, MAAT00.CHAR.EMPTY_STRING);

			appData.setMsgIn(MAAT00.ITM_NME_9, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_DLM_9, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_PTN_9, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_END_9, MAAT00.CHAR.EMPTY_STRING);

			appData.setMsgIn(MAAT00.ITM_NME_10, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_DLM_10, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_PTN_10, MAAT00.CHAR.EMPTY_STRING);
			appData.setMsgIn(MAAT00.ITM_END_10, MAAT00.CHAR.EMPTY_STRING);

			//死亡・終了の除外フラグ
			appData.setMsgIn(MAAT00.DEL_FLG, String.valueOf(check_1.isSelected()));

			try {

				//新型コロナ予防接種希望集計表作成クラスを実行
				MAA00B001Z00 fluDsrObj = new MFD04B001Z00();
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
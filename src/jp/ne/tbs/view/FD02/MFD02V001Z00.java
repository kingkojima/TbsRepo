package jp.ne.tbs.view.FD02;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import jp.ne.tbs.control.FD02.MFD02B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B003Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.view.MFM00V001Z00;

/**
 * <p>[クラス名]</p>
 * 　　往診列毎インフルエンザ予防接種希望集計　メイン画面
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2019/09/17　小嶋純史　新規作成
 */
public class MFD02V001Z00 extends JFrame implements ActionListener {

	//部品群
	private JPanel panel;
	private GridBagLayout gblayout;
	private GridBagConstraints gbc;

	//集計開始日テキスト
	JTextField text_1;
	//集計終了日テキスト
	JTextField text_2;
	//対象年月日テキスト
	JTextField text_3;

	/** 戻るボタン */
	JButton button_1;
	/** 集計ボタン */
	JButton button_2;

	/** 進捗バー */
	JProgressBar pgBar = null;

	/** 表示ラベル */
	JLabel label_8 = null;
	/** 表示ラベル(進捗バーにあたる場所) */
	JLabel label_9 = null;

	/** 業務処理スレッド */
	BusinessThread bizTh;

	public MFD02V001Z00() {

		//画面設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 400, 400);
		setTitle("インフルエンザ希望(往診列)君");

		//パネル,GBL,GBCを生成。
		panel = new JPanel();
		gblayout = new GridBagLayout();
		gbc = new GridBagConstraints();
		panel.setLayout(gblayout);

		//１行目
		JLabel label_1 = new JLabel("インフル希望(往診列毎)");
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
		text_1 = new JTextField("2020/09/01");
		text_1.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_1.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_1, 0, 2, 1, 1);

		JLabel label_3 = new JLabel("　～　");
		label_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_3, 1, 2, 1, 1);

		text_2 = new JTextField("2020/12/31");
		text_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_2.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_2, 2, 2, 1, 1);

		//4行目(改行のための空白文字)
		JLabel label_7 = new JLabel("　");
		label_7.setFont(new Font("メイリオ", Font.PLAIN, 11));
		this.addComp(label_7, 0, 3, 1, 1);

		//5行目
		JLabel label_6 = new JLabel("往診日");
		label_6.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_6, 2, 4, 1, 1);

		//翌日を取得
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);

		//6行目
		text_3 = new JTextField(sdf.format(cal.getTime()));
		text_3.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_3.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_3, 2, 5, 1, 1);

		//7行目(改行のための空白文字)
		JLabel label_5 = new JLabel("　");
		label_5.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_5, 0, 6, 1, 1);

		//8行目(進捗バーのラベル)
		label_8 = new JLabel("開始日と終了日を入力し集計ボタンを押してください");
		label_8.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_8, 0, 7, 3, 1);

		//9行目(進捗バーのための余白)
		label_9 = new JLabel("　");
		label_9.setFont(new Font("メイリオ", Font.PLAIN, 13));
		this.addComp(label_9, 0, 8, 3, 1);

		//進捗バーはここで生成しておく
		pgBar = new JProgressBar(0, 100);
		pgBar.setStringPainted(true);

		//10行目(改行のための空白文字)
		JLabel label_10 = new JLabel("　");
		label_10.setFont(new Font("メイリオ", Font.PLAIN, 10));
		this.addComp(label_10, 0, 9, 3, 1);

		//11行目
		button_1 = new JButton("戻る");
		button_1.addActionListener(this);
		button_1.setFont(new Font("メイリオ", Font.PLAIN, 18));
		button_1.setActionCommand("return_btn");
		this.addComp(button_1, 0, 10, 1, 1);

		button_2 = new JButton("作成");
		button_2.addActionListener(this);
		button_2.setFont(new Font("メイリオ", Font.PLAIN, 18));
		button_2.setActionCommand("calc_btn");
		this.addComp(button_2, 2, 10, 1, 1);

		//パネルを設定。
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	//ボタン押下後の処理
	public void actionPerformed(ActionEvent e) {

		//ボタン毎にセットしたアクションコマンドを取得
		String cmd = e.getActionCommand();

		//「戻る」の場合
		if (cmd.endsWith("return_btn")) {

			try {

				//メインフレームを生成し実行。
				MFM00V001Z00 frame = new MFM00V001Z00();
				frame.setVisible(true);

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

			//「作成」の場合
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

			label_8.setText("しばらくお待ちください。");
			remComp(label_9, pgBar, 0, 8, 3, 1);

			//appData作成
			MAA00B003Z00 appData = new MAA00B003Z00();
			appData.setMsgIn(MAAT00.DCP_SRT, text_1.getText());
			appData.setMsgIn(MAAT00.DCP_END, text_2.getText());
			appData.setMsgIn(MAAT00.TRG_YMD, text_3.getText());

			appData.setMsgIn(MAAT00.ITM_NME_1, "/*インフルエンザ希望");
			appData.setMsgIn(MAAT00.ITM_DLM_1, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_1, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_1, MAAT00.CHAR.CRLF);

//2020/09/25 Del Start J.Kojima
//			appData.setMsgIn(MAAT00.ITM_NME_2, "家族");
//2020/09/25 Del End J.Kojima
//2020/09/25 Add Start J.Kojima
			appData.setMsgIn(MAAT00.ITM_NME_2, "■本人以外の家族希望");
//2020/09/25 Add End J.Kojima
			appData.setMsgIn(MAAT00.ITM_DLM_2, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_2, MAAT00.DROP.NUMBER);
			appData.setMsgIn(MAAT00.ITM_END_2, MAAT00.CHAR.CRLF);

//2020/09/25 Del Start J.Kojima
//			appData.setMsgIn(MAAT00.ITM_NME_3, "続柄");
//2020/09/25 Del End J.Kojima
//2020/09/25 Del End J.Kojima
//2020/09/25 Add Start J.Kojima
			appData.setMsgIn(MAAT00.ITM_NME_3, "■続柄・読み仮名");
//2020/09/25 Add End J.Kojima
			appData.setMsgIn(MAAT00.ITM_DLM_3, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_3, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_3, MAAT00.CHAR.CRLF);

//2020/09/25 Del Start J.Kojima
//			appData.setMsgIn(MAAT00.ITM_NME_4, "保険証撮影");
//2020/09/25 Del End J.Kojima
//2020/09/25 Del End J.Kojima
//2020/09/25 Add Start J.Kojima
			appData.setMsgIn(MAAT00.ITM_NME_4, "■保険証撮影");
//2020/09/25 Add End J.Kojima
			appData.setMsgIn(MAAT00.ITM_DLM_4, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_4, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_4, MAAT00.CHAR.CRLF);

//2020/09/25 Del Start J.Kojima
//			appData.setMsgIn(MAAT00.ITM_NME_5, "助成");
//2020/09/25 Del End J.Kojima
//2020/09/25 Del End J.Kojima
//2020/09/25 Add Start J.Kojima
			appData.setMsgIn(MAAT00.ITM_NME_5, "■助成");
//2020/09/25 Add End J.Kojima
			appData.setMsgIn(MAAT00.ITM_DLM_5, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_5, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_5, MAAT00.CHAR.CRLF);

//2020/09/25 Del Start J.Kojima
//			appData.setMsgIn(MAAT00.ITM_NME_6, "予診票保管場所");
//2020/09/25 Del End J.Kojima
//2020/09/25 Del End J.Kojima
//2020/09/25 Add Start J.Kojima
			appData.setMsgIn(MAAT00.ITM_NME_6, "■予診票保管場所");
//2020/09/25 Add End J.Kojima
			appData.setMsgIn(MAAT00.ITM_DLM_6, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_6, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_6, MAAT00.CHAR.CRLF);

//2020/09/25 Del Start J.Kojima
//			appData.setMsgIn(MAAT00.ITM_NME_7, "■支払方法");
//2020/09/25 Del End J.Kojima
//2020/09/25 Del End J.Kojima
//2020/09/25 Add Start J.Kojima
			appData.setMsgIn(MAAT00.ITM_NME_7, "■支払方法");
//2020/09/25 Add End J.Kojima
			appData.setMsgIn(MAAT00.ITM_DLM_7, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_7, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_7, MAAT00.CHAR.CRLF);

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

			try {

				//インフルエンザ予防接種希望(往診列毎)作成クラスを実行
				MAA00B001Z00 fluDsrObj = new MFD02B001Z00();
				fluDsrObj.execute(appData, pgBar);

				if (fluDsrObj.getAllInOneData().getCa().errOccurred()) {
					label_8.setText("×ボタンで画面を閉じて、最初からやり直して下さい。");
					return;
				}

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}
			label_8.setText("×ボタンで画面を閉じて下さい。");
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

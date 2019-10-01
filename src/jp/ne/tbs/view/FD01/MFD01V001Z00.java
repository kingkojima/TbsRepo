package jp.ne.tbs.view.FD01;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jp.ne.tbs.control.FD01.MFD01B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B003Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.view.MFM00V001Z00;

public class MFD01V001Z00 extends JFrame implements ActionListener {

	//部品群
	private JPanel panel;
	private GridBagLayout gblayout;
	private GridBagConstraints gbc;

	//集計開始日テキスト
	JTextField text_1;
	//集計終了日テキスト
	JTextField text_2;

	public MFD01V001Z00() {

		//画面設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 400, 250);
		setTitle("インフルエンザ希望集計君");

		//パネル,GBL,GBCを生成。
		panel = new JPanel();
		gblayout = new GridBagLayout();
		gbc = new GridBagConstraints();
		panel.setLayout(gblayout);

		//１行目
		JLabel label_1 = new JLabel("インフルエンザ希望集計");
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
		text_1 = new JTextField("2019/09/01");
		text_1.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_1.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_1, 0, 2, 1, 1);

		JLabel label_3 = new JLabel("　～　");
		label_3.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_3, 1, 2, 1, 1);

		text_2 = new JTextField("2019/12/31");
		text_2.setFont(new Font("メイリオ", Font.PLAIN, 17));
		text_2.setPreferredSize(new Dimension(120, 40));
		this.addComp(text_2, 2, 2, 1, 1);

		//４行目(改行のための空白文字)
		JLabel label_5 = new JLabel("　");
		label_5.setFont(new Font("メイリオ", Font.PLAIN, 22));
		this.addComp(label_5, 0, 3, 1, 1);

		//５行目
		JButton button_1 = new JButton("戻る");
		button_1.addActionListener(this);
		button_1.setFont(new Font("メイリオ", Font.PLAIN, 18));
		button_1.setActionCommand("return_btn");
		this.addComp(button_1, 0, 4, 1, 1);

		JButton button_2 = new JButton("集計");
		button_2.addActionListener(this);
		button_2.setFont(new Font("メイリオ", Font.PLAIN, 18));
		button_2.setActionCommand("calc_btn");
		this.addComp(button_2, 2, 4, 1, 1);

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

		//「集計」の場合
		} else if(cmd.endsWith("calc_btn")) {

			//appData作成
			MAA00B003Z00 appData = new MAA00B003Z00();
			appData.setMsgIn(MAAT00.DCP_SRT, text_1.getText());
			appData.setMsgIn(MAAT00.DCP_END, text_2.getText());

			appData.setMsgIn(MAAT00.ITM_NME_1, "/*インフルエンザ希望");
			appData.setMsgIn(MAAT00.ITM_DLM_1, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_1, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_1, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_2, "家族");
			appData.setMsgIn(MAAT00.ITM_DLM_2, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_2, MAAT00.DROP.NUMBER);
			appData.setMsgIn(MAAT00.ITM_END_2, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_3, "続柄");
			appData.setMsgIn(MAAT00.ITM_DLM_3, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_3, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_3, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_4, "保険証撮影");
			appData.setMsgIn(MAAT00.ITM_DLM_4, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_4, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_4, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_5, "助成");
			appData.setMsgIn(MAAT00.ITM_DLM_5, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_5, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_5, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_6, "予診票保管場所");
			appData.setMsgIn(MAAT00.ITM_DLM_6, MAAT00.CHAR.CRLF);
			appData.setMsgIn(MAAT00.ITM_PTN_6, MAAT00.DROP.STRING);
			appData.setMsgIn(MAAT00.ITM_END_6, MAAT00.CHAR.CRLF);

			appData.setMsgIn(MAAT00.ITM_NME_7, "支払方法");
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

				//インフルエンザ予防接種希望集計表作成クラスを実行
				MAA00B001Z00 fluDsrObj = new MFD01B001Z00();
				fluDsrObj.execute(appData);
				if(fluDsrObj.getAllInOneData().getCa().errOccurred()) {
					return;
				}

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();
		}

	}

	//コンポーネントを設定するメソッド
	void addComp(Component comp, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gblayout.setConstraints(comp, gbc);
		panel.add(comp);
	}

}

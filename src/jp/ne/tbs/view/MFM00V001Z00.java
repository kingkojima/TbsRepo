package jp.ne.tbs.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import jp.ne.tbs.view.FD01.MFD01V001Z00;
import jp.ne.tbs.view.FD02.MFD02V001Z00;
import jp.ne.tbs.view.FD03.MFD03V001Z00;

/**
 * <p>[クラス名]</p>
 * 　　トーマス君デラックス　メイン画面
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2019/09/17　小嶋純史　新規作成
 */
public class MFM00V001Z00 extends JFrame implements ActionListener {

	//部品
	private JTabbedPane tabbedPane;

	private JPanel buttonPanel1;
	private JPanel buttonPanel2;

	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;

	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;

	//メイン処理
	public static void main(String[] args) {

		//メインフレームを生成し実行。
		MFM00V001Z00 frame = new MFM00V001Z00();
		frame.setVisible(true);
	}

	//コンストラクタ
	public MFM00V001Z00() {

		//画面設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(900, 100, 350, 400);
		setTitle("トーマス君デラックス");

		//タブ生成
		tabbedPane = new JTabbedPane();
		add(tabbedPane);

		//ボタンを生成。
		//ボタン１
		button_1 = new JButton("インフル希望集計");
		button_1.addActionListener(this);
		button_1.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_1.setActionCommand("flu_dsr_btn");
		button_1.setEnabled(true);

		//ボタン２
		button_2 = new JButton("インフル希望(往診列)");
		button_2.addActionListener(this);
		button_2.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_2.setActionCommand("flu_vst_btn");
		button_2.setEnabled(true);

		//ボタン３
		button_3 = new JButton("カルテ汎用検索");
		button_3.addActionListener(this);
		button_3.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_3.setActionCommand("gnl_src_btn");
		button_3.setEnabled(true);

		//ボタン４
		button_4 = new JButton("機能追加枠③");
		button_4.addActionListener(this);
		button_4.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_4.setActionCommand("tsuika_3");
		button_4.setEnabled(false);

		//パネル１を生成。
		buttonPanel1 = new JPanel();
		//パネル１にレイアウトを設定。
		//※ボタンを増やすにはここを変更する。
		buttonPanel1.setLayout(new GridLayout(4, 1));

		//ボタンを設定。
		buttonPanel1.add(button_1);
		buttonPanel1.add(button_2);
		buttonPanel1.add(button_3);
		buttonPanel1.add(button_4);

		//パネル１をタブに設定。
		tabbedPane.addTab("集計", buttonPanel1);

		//ボタン５
		button_5 = new JButton("機能追加枠④");
		button_5.addActionListener(this);
		button_5.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_5.setActionCommand("tsuika_4");
		button_5.setEnabled(false);

		//ボタン６
		button_6 = new JButton("機能追加枠⑤");
		button_6.addActionListener(this);
		button_6.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_6.setActionCommand("tsuika_5");
		button_6.setEnabled(false);

		//ボタン７
		button_7 = new JButton("機能追加枠⑥");
		button_7.addActionListener(this);
		button_7.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_7.setActionCommand("tsuika_6");
		button_7.setEnabled(false);

		//ボタン８
		button_8 = new JButton("機能追加枠⑦");
		button_8.addActionListener(this);
		button_8.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_8.setActionCommand("tsuika_7");
		button_8.setEnabled(false);


		//パネル２を生成。
		buttonPanel2 = new JPanel();
		//パネルにレイアウトを設定。
		//※ボタンを増やすにはここを変更する。
		buttonPanel2.setLayout(new GridLayout(4, 1));

		//ボタンを設定。
		buttonPanel2.add(button_5);
		buttonPanel2.add(button_6);
		buttonPanel2.add(button_7);
		buttonPanel2.add(button_8);

		//パネル２をタブに設定。
		tabbedPane.addTab("予定表", buttonPanel2);


	}

	//ボタン押下後の処理
	public void actionPerformed(ActionEvent e) {

		//ボタン毎にセットしたアクションコマンドを取得
		String cmd = e.getActionCommand();

		//インフル希望集計の場合
		if (cmd.equals("flu_dsr_btn")) {

			try {

				//インフルエンザ希望集計画面
				MFD01V001Z00.exec();

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

		//インフル希望(往診列)の場合
		} else if (cmd.equals("flu_vst_btn")) {

			try {

				//インフルエンザ希望集計画面
				MFD02V001Z00 fluFrame = new MFD02V001Z00();
				fluFrame.setVisible(true);

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

		//カルテ汎用修正の場合
		} else if (cmd.equals("gnl_src_btn")) {

			try {

				//インフルエンザ希望集計画面
				MFD03V001Z00 fluFrame = new MFD03V001Z00();
				fluFrame.setVisible(true);

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

		}

	}

}

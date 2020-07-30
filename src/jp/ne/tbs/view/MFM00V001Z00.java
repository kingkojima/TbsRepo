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
import jp.ne.tbs.view.PA01.MPA01V001Z00;
import jp.ne.tbs.view.PT01.MPT01V001Z00;
import jp.ne.tbs.view.RE01.MRE01V001Z00;

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
	private JPanel buttonPanel3;
	private JPanel buttonPanel4;

	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;

	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;

	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;

	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;

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

		//=================================================
		//====ツールタブ===================================
		//=================================================

		//ボタン１５
		button_15 = new JButton("予後予測ツール");
		button_15.addActionListener(this);
		button_15.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_15.setActionCommand("pap_scr_btn");
		button_15.setEnabled(true);

		//ボタン１３
		button_13 = new JButton("新患情報入力");
		button_13.addActionListener(this);
		button_13.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_13.setActionCommand("pte_inf_ipt");
		button_13.setEnabled(true);

		//ボタン１４
		button_14 = new JButton("レセ対象一覧作成");
		button_14.addActionListener(this);
		button_14.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_14.setActionCommand("rec_tar_lst");
		button_14.setEnabled(true);

		//ボタン１６
		button_16 = new JButton("報告書データ作成");
		button_16.addActionListener(this);
		button_16.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_16.setActionCommand("rep_dat_mke");
		button_16.setEnabled(false);

		//パネル４を生成。
		buttonPanel4 = new JPanel();
		//パネルにレイアウトを設定。
		//※ボタンを増やすにはここを変更する。
		buttonPanel4.setLayout(new GridLayout(4, 1));

		//ボタンを設定。
		buttonPanel4.add(button_15);
		buttonPanel4.add(button_13);
		buttonPanel4.add(button_14);
		buttonPanel4.add(button_16);

		//パネル４をタブに設定。
		tabbedPane.addTab("ツール", buttonPanel4);

		//=================================================
		//====集計タブ=====================================
		//=================================================

		//ボタンを生成。
		//ボタン１
		button_1 = new JButton("インフル希望集計");
		button_1.addActionListener(this);
		button_1.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_1.setActionCommand("flu_dsr_btn");
		button_1.setEnabled(false);

		//ボタン２
		button_2 = new JButton("インフル希望(往診列)");
		button_2.addActionListener(this);
		button_2.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_2.setActionCommand("flu_vst_btn");
		button_2.setEnabled(false);

		//ボタン３
		button_3 = new JButton("カルテ汎用検索");
		button_3.addActionListener(this);
		button_3.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_3.setActionCommand("gnl_src_btn");
		button_3.setEnabled(true);

		//ボタン４
		button_4 = new JButton("患者病名検索");
		button_4.addActionListener(this);
		button_4.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_4.setActionCommand("tsuika_4");
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

		//=================================================
		//====予定表タブ===================================
		//=================================================

		//ボタン５
		button_5 = new JButton("簡易版");
		button_5.addActionListener(this);
		button_5.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_5.setActionCommand("tsuika_5");
		button_5.setEnabled(false);

		//ボタン６
		button_6 = new JButton("施設別");
		button_6.addActionListener(this);
		button_6.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_6.setActionCommand("tsuika_6");
		button_6.setEnabled(false);

		//ボタン７
		button_7 = new JButton("町域表示");
		button_7.addActionListener(this);
		button_7.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_7.setActionCommand("tsuika_7");
		button_7.setEnabled(false);

		//ボタン８
		button_8 = new JButton("訪問予定チェック");
		button_8.addActionListener(this);
		button_8.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_8.setActionCommand("tsuika_8");
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

		//=================================================
		//====勤務表タブ===================================
		//=================================================

		//ボタン９
		button_9 = new JButton("おまかせ作成");
		button_9.addActionListener(this);
		button_9.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_9.setActionCommand("tsuika_9");
		button_9.setEnabled(false);

		//ボタン１０
		button_10 = new JButton("呼び出し");
		button_10.addActionListener(this);
		button_10.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_10.setActionCommand("tsuika_10");
		button_10.setEnabled(false);

		//ボタン１１
		button_11 = new JButton("一括登録");
		button_11.addActionListener(this);
		button_11.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_11.setActionCommand("tsuika_11");
		button_11.setEnabled(false);

		//ボタン１２
		button_12 = new JButton("過不足チェック");
		button_12.addActionListener(this);
		button_12.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_12.setActionCommand("tsuika_12");
		button_12.setEnabled(false);

		//パネル３を生成。
		buttonPanel3 = new JPanel();
		//パネルにレイアウトを設定。
		//※ボタンを増やすにはここを変更する。
		buttonPanel3.setLayout(new GridLayout(4, 1));

		//ボタンを設定。
		buttonPanel3.add(button_9);
		buttonPanel3.add(button_10);
		buttonPanel3.add(button_11);
		buttonPanel3.add(button_12);

		//パネル３をタブに設定。
		tabbedPane.addTab("勤務表", buttonPanel3);
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

			//予後予測指標の場合
		} else if (cmd.equals("pap_scr_btn")) {

			try {

				//予後予測指標入力画面
				MPA01V001Z00 papFrame = new MPA01V001Z00();
				papFrame.setVisible(true);

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

			//新患情報入力の場合
		} else if (cmd.equals("pte_inf_ipt")) {

			try {

				//新患受付（非がん患者様用）メイン画面
				MRE01V001Z00 papFrame = new MRE01V001Z00();
				papFrame.setVisible(true);

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

			//レセプト対象患者一覧作成
		} else if (cmd.equals("rec_tar_lst")) {

			try {

				//レセ対象一覧作成メイン画面
				MPT01V001Z00 pecFrame = new MPT01V001Z00();
				pecFrame.setVisible(true);

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

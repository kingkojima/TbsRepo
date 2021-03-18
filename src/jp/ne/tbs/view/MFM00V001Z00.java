package jp.ne.tbs.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import jp.ne.tbs.view.AM01.MAM01V001Z00;
import jp.ne.tbs.view.FD01.MFD01V001Z00;
import jp.ne.tbs.view.FD02.MFD02V001Z00;
import jp.ne.tbs.view.FD03.MFD03V001Z00;
import jp.ne.tbs.view.FD04.MFD04V001Z00;
import jp.ne.tbs.view.FD05.MFD05V001Z00;
import jp.ne.tbs.view.PA01.MPA01V001Z00;
import jp.ne.tbs.view.PT01.MPT01V001Z00;
import jp.ne.tbs.view.PT02.MPT02V001Z00;
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

	//パネル
	private JPanel buttonPanel1;
	private JPanel buttonPanel2;
	private JPanel buttonPanel3;
	private JPanel buttonPanel4;
	private JPanel buttonPanel5;

	//ボタン群(ツール)
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_24;
	private JButton button_29;

	//ボタン群(集計)
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_21;
	private JButton button_26;

	//ボタン群(予定表)
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_22;
	private JButton button_27;

	//ボタン群(勤務表)
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_23;
	private JButton button_28;

	//ボタン群(その他)
	private JButton button_17;
	private JButton button_18;
	private JButton button_19;
	private JButton button_20;
	private JButton button_25;
	private JButton button_30;

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
		setBounds(900, 100, 350, 600);
		setTitle("トーマス君デラックス");

		//タブ生成
		tabbedPane = new JTabbedPane();
		add(tabbedPane);

		//=================================================
		//====ツールタブ===================================
		//=================================================

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

		//ボタン１５
		button_15 = new JButton("予後予測ツール");
		button_15.addActionListener(this);
		button_15.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_15.setActionCommand("pap_scr_btn");
		button_15.setEnabled(true);

		//ボタン１６
		button_16 = new JButton("報告書データ作成");
		button_16.addActionListener(this);
		button_16.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_16.setActionCommand("rep_dat_mke");
		button_16.setEnabled(false);

		//ボタン２４
		button_24 = new JButton("");
		button_24.addActionListener(this);
		button_24.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_24.setActionCommand("xxx_xxx_btn");
		button_24.setEnabled(false);

		//ボタン２９
		button_29 = new JButton("");
		button_29.addActionListener(this);
		button_29.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_29.setActionCommand("xxx_xxx_btn");
		button_29.setEnabled(false);

		//パネル４を生成。
		buttonPanel4 = new JPanel();
		//パネルにレイアウトを設定。
		//※ボタンを増やすにはここを変更する。
		buttonPanel4.setLayout(new GridLayout(6, 1));

		//ボタンを設定。
		buttonPanel4.add(button_15);
		buttonPanel4.add(button_13);
		buttonPanel4.add(button_14);
		buttonPanel4.add(button_16);
		buttonPanel4.add(button_24);
		buttonPanel4.add(button_29);

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
		button_4 = new JButton("患者病名一覧");
		button_4.addActionListener(this);
		button_4.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_4.setActionCommand("pat_dsa_lst");
		button_4.setEnabled(false);

		//ボタン２１
		button_21 = new JButton("コロナワクチン希望集計");
		button_21.addActionListener(this);
		button_21.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_21.setActionCommand("cov_dsr_btn");
		button_21.setEnabled(true);

		//ボタン２６
		button_26 = new JButton("コロナワクチン希望(往診列)");
		button_26.addActionListener(this);
		button_26.setFont(new Font("メイリオ", Font.BOLD, 22));
		button_26.setActionCommand("cov_vst_btn");
		button_26.setEnabled(true);


		//パネル１を生成。
		buttonPanel1 = new JPanel();
		//パネル１にレイアウトを設定。
		//※ボタンを増やすにはここを変更する。
		buttonPanel1.setLayout(new GridLayout(6, 1));

		//ボタンを設定。
		buttonPanel1.add(button_1);
		buttonPanel1.add(button_2);
		buttonPanel1.add(button_3);
		buttonPanel1.add(button_4);
		buttonPanel1.add(button_21);
		buttonPanel1.add(button_26);

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

		//ボタン２２
		button_22 = new JButton("");
		button_22.addActionListener(this);
		button_22.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_22.setActionCommand("xxx_xxx_btn");
		button_22.setEnabled(false);

		//ボタン２７
		button_27 = new JButton("");
		button_27.addActionListener(this);
		button_27.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_27.setActionCommand("xxx_xxx_btn");
		button_27.setEnabled(false);

		//パネル２を生成。
		buttonPanel2 = new JPanel();
		//パネルにレイアウトを設定。
		//※ボタンを増やすにはここを変更する。
		buttonPanel2.setLayout(new GridLayout(6, 1));

		//ボタンを設定。
		buttonPanel2.add(button_5);
		buttonPanel2.add(button_6);
		buttonPanel2.add(button_7);
		buttonPanel2.add(button_8);
		buttonPanel2.add(button_22);
		buttonPanel2.add(button_27);

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

		//ボタン２３
		button_23 = new JButton("");
		button_23.addActionListener(this);
		button_23.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_23.setActionCommand("xxx_xxx_btn");
		button_23.setEnabled(false);

		//ボタン２８
		button_28 = new JButton("");
		button_28.addActionListener(this);
		button_28.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_28.setActionCommand("xxx_xxx_btn");
		button_28.setEnabled(false);

		//パネル３を生成。
		buttonPanel3 = new JPanel();
		//パネルにレイアウトを設定。
		//※ボタンを増やすにはここを変更する。
		buttonPanel3.setLayout(new GridLayout(6, 1));

		//ボタンを設定。
		buttonPanel3.add(button_9);
		buttonPanel3.add(button_10);
		buttonPanel3.add(button_11);
		buttonPanel3.add(button_12);
		buttonPanel3.add(button_23);
		buttonPanel3.add(button_28);

		//パネル３をタブに設定。
		tabbedPane.addTab("勤務表", buttonPanel3);

		//=================================================
		//====その他タブ======================================
		//=================================================

		//ボタン１７
		button_17 = new JButton("あみだくじ");
		button_17.addActionListener(this);
		button_17.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_17.setActionCommand("ami_daa_btn");
		button_17.setEnabled(true);

		//ボタン１８
		button_18 = new JButton("外来宛名印刷");
		button_18.addActionListener(this);
		button_18.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_18.setActionCommand("out_add_btn");
		button_18.setEnabled(false);

		//ボタン１９
		button_19 = new JButton("");
		button_19.addActionListener(this);
		button_19.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_19.setActionCommand("xxx_xxx_btn");
		button_19.setEnabled(false);

		//ボタン２０
		button_20 = new JButton("");
		button_20.addActionListener(this);
		button_20.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_20.setActionCommand("xxx_xxx_btn");
		button_20.setEnabled(false);

		//ボタン２５
		button_25 = new JButton("");
		button_25.addActionListener(this);
		button_25.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_25.setActionCommand("xxx_xxx_btn");
		button_25.setEnabled(false);

		//ボタン２６
		button_30 = new JButton("");
		button_30.addActionListener(this);
		button_30.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_30.setActionCommand("xxx_xxx_btn");
		button_30.setEnabled(false);

		//パネル５を生成。
		buttonPanel5 = new JPanel();
		//パネルにレイアウトを設定。
		//※ボタンを増やすにはここを変更する。
		buttonPanel5.setLayout(new GridLayout(6, 1));

		//ボタンを設定。
		buttonPanel5.add(button_17);
		buttonPanel5.add(button_18);
		buttonPanel5.add(button_19);
		buttonPanel5.add(button_20);
		buttonPanel5.add(button_25);
		buttonPanel5.add(button_30);

		//パネル５をタブに設定。
		tabbedPane.addTab("その他", buttonPanel5);

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

				//レセプト対象一覧作成メイン画面
				MPT01V001Z00 pecFrame = new MPT01V001Z00();
				pecFrame.setVisible(true);

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

			//患者病名一覧作成
		} else if (cmd.equals("pat_dsa_lst")) {

			try {

				//患者病名一覧作成メイン画面
				MPT02V001Z00 pecFrame = new MPT02V001Z00();
				pecFrame.setVisible(true);

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

			//あみだくじ作成
		} else if (cmd.equals("ami_daa_btn")) {

			try {

				//あみだくじ作成メイン画面
				MAM01V001Z00 pecFrame = new MAM01V001Z00();
				pecFrame.setVisible(true);

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

			//外来宛名印刷作成
		} else if (cmd.equals("out_add_btn")) {

			try {

				//外来宛名印刷作成メイン画面
//				MPT02V001Z00 pecFrame = new MPT02V001Z00();
//				pecFrame.setVisible(true);

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

			//新型コロナワクチン接種希望集計
		} else if (cmd.equals("cov_dsr_btn")) {

			try {

				//新型コロナワクチン接種希望集計画面
				MFD04V001Z00.exec();

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}

			//処理が終わったら終了
			this.dispose();

			//新型コロナワクチン希望(往診列)の場合
		} else if (cmd.equals("cov_vst_btn")) {

			try {

				//新型コロナワクチン希望集計画面
				MFD05V001Z00 fluFrame = new MFD05V001Z00();
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

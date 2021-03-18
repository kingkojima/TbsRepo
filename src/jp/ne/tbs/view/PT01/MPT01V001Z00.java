package jp.ne.tbs.view.PT01;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import jp.ne.tbs.control.PT01.MPT01B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B001Z00;
import jp.ne.tbs.frame.AA00.MAA00B003Z00;
import jp.ne.tbs.frame.AA00.MAAT00;
import jp.ne.tbs.frame.AA00.SwingCalendar;
import jp.ne.tbs.view.MFM00V001Z00;

/**
 * <p>[クラス名]</p>
 * 　　レセプト対象一覧作成　メイン画面
 * <p>[概要]</p>
 * <p>[変更履歴]</p>
 * 　　2020/04/10　小嶋純史　新規作成
 */
public class MPT01V001Z00 extends JFrame implements ActionListener {

	/** カレンダー作成 */
	SwingCalendar calendar1;
	SwingCalendar calendar2;

	/** 一覧作成ボタン */
	JButton buttonCreate;
	/** 戻るボタン */
	JButton buttonClose;

	/** 集計開始日テキスト */
	JLabel label_1;

	/** 業務処理スレッド */
	BusinessThread bizTh;

	/** 進捗バー */
	JProgressBar pgBar = null;

	/**
	 * <p>[概 要] </p>
	 * 　レセプト対象一覧作成　実行メソッド<BR>
	 * <p>[詳 細] </p>
	 * <p>[備 考] </p>
	 */
	public static void exec() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MPT01V001Z00 fluFrame = new MPT01V001Z00();
				fluFrame.setVisible(true);
			}
		});
	}

	/**
	 * <p>[概 要] </p>
	 * 　レセプト対象一覧作成　コンストラクタ<BR>
	 * <p>[詳 細] </p>
	 * 　画面のレイアウトを作成する。
	 * <p>[備 考] </p>
	 */
	public MPT01V001Z00() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 400, 350);
		setTitle("レセプト対象期間は？");

		// 親コンテナ
		Container container = super.getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		super.setContentPane(container);

		// 上部パネル（日付コントロール2個配置）
		JPanel panel1 = new JPanel(new GridLayout(1, 2, 5, 5));

		// 前月の月初日、月末日を取得
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int dayFirstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        int dayLastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		calendar1 = new SwingCalendar(year, month, dayFirstDay, "開始日");
		panel1.add(calendar1);

		calendar2 = new SwingCalendar(year, month, dayLastDay, "終了日");
		panel1.add(calendar2);

		//パネル1を設定
		getContentPane().add(panel1);

		// 下部パネル（ボタン2個配置）
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonCreate = new JButton("一覧作成");
		buttonCreate.addActionListener(this);
		buttonCreate.setActionCommand("crt_btn");
		panel2.add(buttonCreate);

		buttonClose = new JButton("戻る");
		buttonClose.addActionListener(this);
		buttonClose.setActionCommand("rtn_btn");
		panel2.add(buttonClose);

		//パネル2を設定
		getContentPane().add(panel2);

		// 最下部メッセージ
		JPanel panel3 = new JPanel();
		label_1 = new JLabel("");
		label_1.setFont(new Font("メイリオ", Font.PLAIN, 17));
		panel3.add(label_1);

		//パネル3を設定
		getContentPane().add(panel3);
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

		//「一覧作成」の場合
		if (cmd.endsWith("crt_btn")) {

			//ボタンを非活性
			buttonCreate.setEnabled(false);
			buttonClose.setEnabled(false);

			//業務処理スタート
			bizTh = new BusinessThread();
			bizTh.start();

			//「戻る」の場合
		} else if (cmd.endsWith("rtn_btn")) {

			//メインフレームを生成し実行。
			MFM00V001Z00 frame = new MFM00V001Z00();
			frame.setVisible(true);

			//処理が終わったら画面終了
			this.dispose();

		}
	}

	//業務処理
	class BusinessThread extends Thread {

		public void run() {

//			label_1.setText("しばらくお待ちください。");
			label_1.setText("※" + calendar1.getMonth() + "/" + calendar1.getDay() + "～" + calendar2.getMonth()
					+ "/" + calendar2.getDay() + "の期間で作成中です。");
			label_1.setForeground(Color.red);

			//appData作成
			MAA00B003Z00 appData = new MAA00B003Z00();
			appData.setMsgIn(MAAT00.DCP_SRT, "" + calendar1.getYear() + "/" + calendar1.getMonth() + "/" + calendar1.getDay());
			appData.setMsgIn(MAAT00.DCP_END, "" + calendar2.getYear() + "/" + calendar2.getMonth() + "/" + calendar2.getDay());

			try {

				//レセプト対象一覧作成　業務メインクラスを実行
				pgBar = new JProgressBar(0, 100);
				MAA00B001Z00 fluDsrObj = new MPT01B001Z00();
				fluDsrObj.execute(appData, pgBar);

				//業務エラーが発生していた場合は画面を閉じずに終了。
				if (fluDsrObj.getAllInOneData().getCa().errOccurred()) {
					return;
				}

				//エラー発生時
			} catch (Exception ex) {

				//標準出力
				ex.printStackTrace();
			}
			label_1.setText("×ボタンで画面を閉じて下さい。");
			label_1.setForeground(Color.red);
		}
	}

}

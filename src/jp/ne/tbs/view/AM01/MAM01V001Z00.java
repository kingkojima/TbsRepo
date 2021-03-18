package jp.ne.tbs.view.AM01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MAM01V001Z00 extends JFrame implements ActionListener {

	/**
	 * <p>
	 * [概 要]
	 * </p>
	 * あみだくじ 実行メソッド<BR>
	 * <p>
	 * [詳 細]
	 * </p>
	 * <p>
	 * [備 考]
	 * </p>
	 */
	public static void exec() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MAM01V001Z00 fluFrame = new MAM01V001Z00();
				fluFrame.setVisible(true);
			}
		});
	}

	/**
	 * <p>
	 * [概 要]
	 * </p>
	 * インフルエンザワクチン接種希望集計 コンストラクタ<BR>
	 * <p>
	 * [詳 細]
	 * </p>
	 * 画面のレイアウトを作成する。
	 * <p>
	 * [備 考]
	 * </p>
	 */
	public MAM01V001Z00() {

		Frame frameRunAmidakuji = new Frame("あみだくじ");
		frameRunAmidakuji.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}
		});

		/* メインパネルにボタンを張り付ける */
		Panel panelMain = new Panel();

		Button generalAmidakuji = new Button("汎用的なあみだくじ");
		generalAmidakuji.addActionListener(this);
		panelMain.add(generalAmidakuji);

		frameRunAmidakuji.add(panelMain, BorderLayout.CENTER);
		frameRunAmidakuji.setSize(250, 100);
		frameRunAmidakuji.setVisible(true);

	}

	/**
	 * <p>
	 * [概 要]
	 * </p>
	 * ボタン押下後に呼ばれる処理<BR>
	 * <p>
	 * [詳 細]
	 * </p>
	 * <p>
	 * [備 考]
	 * </p>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		/* ボタンが押されるとAmidakujiインスタンスが生成される */
		if(e.getActionCommand().equals("汎用的なあみだくじ")) {
			new MAM01V002Z00();
		}
	}

}

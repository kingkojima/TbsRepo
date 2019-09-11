package jp.ne.tbs.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jp.ne.tbs.control.FD.FD01C001Z00;

/*
 * @author Junji Kojima
 * @version 0.0.1
 */

/*
 * バッチメインクラス
 * スキャンした書類(PDF)のファイル名を変更する機能
 */
public class FM00V001Z00 extends JFrame implements ActionListener {

	//部品
	private JPanel buttonPanel;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;

	//メイン処理
	public static void main(String[] args) {

		//メインフレームを生成し実行。
		FM00V001Z00 frame = new FM00V001Z00();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(900, 100, 300, 400);
		frame.setTitle("トーマス君デラックス");
		frame.setVisible(true);
	}

	//コンストラクタ
	FM00V001Z00() {

		//ボタンを生成。
		//ボタン１
		button_1 = new JButton("インフル希望集計");
		button_1.addActionListener(this);
		button_1.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_1.setActionCommand("flu_dsr_btn");
		button_1.setEnabled(true);

		//ボタン２
		button_2 = new JButton("機能追加枠①");
		button_2.addActionListener(this);
		button_2.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_2.setActionCommand("tsuika_1");
		button_2.setEnabled(false);

		//ボタン３
		button_3 = new JButton("機能追加枠②");
		button_3.addActionListener(this);
		button_3.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_3.setActionCommand("tsuika_2");
		button_3.setEnabled(false);

		//ボタン4
		button_4 = new JButton("機能追加枠③");
		button_4.addActionListener(this);
		button_4.setFont(new Font("メイリオ", Font.BOLD, 26));
		button_4.setActionCommand("tsuika_3");
		button_4.setEnabled(false);

		//パネルを生成。
		buttonPanel = new JPanel();
		//パネルにレイアウトを設定。
		//※ボタンを増やすにはここを変更する。
		buttonPanel.setLayout(new GridLayout(4, 1));

		//ボタンを設定。
		buttonPanel.add(button_1);
		buttonPanel.add(button_2);
		buttonPanel.add(button_3);
		buttonPanel.add(button_4);

		//パネルを設定。
		getContentPane().add(buttonPanel);

	}

	//ボタン押下後の処理
	public void actionPerformed(ActionEvent e) {

//		JFileChooser filechooser = new JFileChooser();
//		int selected = filechooser.showOpenDialog(this);

		//ボタン毎にセットしたアクションコマンドを取得
		String cmd = e.getActionCommand();

		//インフル希望集計の場合
		if(cmd.endsWith("flu_dsr_btn")) {

			//インフルエンザ予防接種希望集計表作成クラスを実行
			FD01C001Z00 obj = new FD01C001Z00();
			obj.fluDsrCntCtlMain();

			//処理が終わったら終了
			 this.dispose();

		}
	}

}
//package jp.ne.tbs.view;
//
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.Font;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.SwingUtilities;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
//
//public class FrameMain extends JFrame {
//
////		private final String LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//		private final String LOOK_AND_FEEL = "com.sun.java.swing.plaf.mac.MacLookAndFeel";
//
//		/**
//		 * 起動メイン処理
//		 * @param args
//		 */
//		public static void main(String [] args) {
//
//				//メインメニュー実行
//				new FrameMain();
//		}
//
//		/**
//		 * メインメニュー実行
//		 *
//		 */
//		FrameMain() {
//
//				//ペインを取得
//				super.getContentPane().setLayout(new FlowLayout());
//
//				//ラベル設定	　ラベルを設定
//				JLabel label = new JLabel("つばさ在宅クリニック医療支援システム");
//				label.setFont(new Font("メイリオ", Font.BOLD, 32));
//				label.setForeground(Color.BLUE);
//				label.setBackground(Color.WHITE);
//				label.setOpaque(true);
//				super.getContentPane().add(label);
//
//				//終了処理を設定
//				super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//				//タイトル　タイトルを設定
//				super.setTitle("つばさ在宅クリニック医療支援システム　トップメニュー");
//
//				//サイズを設定
//				super.setSize(1000, 600);
//
//				//Look&Feelを実行
//				try {
//					UIManager.setLookAndFeel(LOOK_AND_FEEL);
//				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//						| UnsupportedLookAndFeelException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
//				SwingUtilities.updateComponentTreeUI(this);
//
//				//表示
//				super.setVisible(true);
//		}
//
//}

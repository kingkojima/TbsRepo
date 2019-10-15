package jp.ne.tbs.control.FD01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class TabTest1 extends JFrame {

	JTabbedPane tabbedPane;

	public TabTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);

		// JTabbedPane
		tabbedPane = new JTabbedPane();
		add(tabbedPane);

		// Tab 1
		JPanel tab1 = new Tab1();
		tabbedPane.addTab("Tab 1", tab1);

		// Tab 2
		JPanel tab2 = new Tab2();
		tabbedPane.addTab("Tab 2", tab2);

	}

	// Tab 1
	class Tab1 extends JPanel {
		public Tab1() {
			JLabel label1 = new JLabel("Hello, world!");
			add(label1);
		}
	}

	// Tab 2
	class Tab2 extends JPanel {
		public Tab2() {
			JLabel label1 = new JLabel("This is another tab.");
			add(label1);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				TabTest1 app = new TabTest1();
				app.setVisible(true);
			}
		});

	}
}

















//public class Test2 extends JFrame implements ActionListener {
//
//	JProgressBar progressBar = new JProgressBar(0, 100);
//	JButton button = new JButton("開始");
//	HeavyThread ht = null;
//
//	public static void main(final String[] args) throws Exception {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				Test2 t2 = new Test2();
//				t2.setVisible(true);
//			}
//		});
//	}
//
//	Test2() {
//		super("重いアクション");
//		getContentPane().setLayout(new BorderLayout());
//		getContentPane().add(progressBar, BorderLayout.SOUTH);
//		getContentPane().add(button, BorderLayout.CENTER);
//
//		progressBar.setStringPainted(true);
//		button.addActionListener(this);
//		button.setActionCommand("start");
//		//        button.addActionListener(new ActionListener() {
//		//            public void actionPerformed(ActionEvent e) {
//		//            	button.setEnabled(false);
//		//                new HeavyThread().start();
//		//            }
//		//        });
//		setSize(640, 480);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		button.setEnabled(false);
//		ht = new HeavyThread();
//		ht.start();
//
//	}
//
//
//	//重い処理
//	class HeavyThread extends Thread {
//		public void run() {
//			for (int i = 0; i < 100; i++) {
//				try {
//					Thread.sleep(100L);
//				} catch (InterruptedException e) {
//				}
//				final int pos = i + 1;
//				SwingUtilities.invokeLater(new Runnable() {
//					public void run() {
//						progressBar.setString(pos + "/100");
//						progressBar.setValue(pos);
//					}
//				});
//			}
//		}
//	}
//
//}

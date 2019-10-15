package jp.ne.tbs.control.FD01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Test extends JFrame {
    JProgressBar progressBar = new JProgressBar(0, 100);
    JButton button = new JButton("開始");
    Test() {
        super("重いアクション");
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(progressBar, BorderLayout.SOUTH);
        getContentPane().add(button, BorderLayout.CENTER);

        progressBar.setStringPainted(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	button.setEnabled(false);
                new HeavyThread().start();
            }
        });
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    class HeavyThread extends Thread {
        public void run() {
            for (int i=0; i<100; i++) {
                try { Thread.sleep(100L); } catch (InterruptedException e) {}
                final int pos = i+1;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        progressBar.setString(pos + "/100");
                        progressBar.setValue(pos);
                    }
                });
            }
        }
    }

    public static void main(final String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }
}




















//package jp.ne.tbs.control.FD01;
//
//import javax.swing.JFrame;
//import javax.swing.JProgressBar;
//
//
//public class Test extends JFrame {
//
//    private JProgressBar progressBar1 = null;
//
//    /**
//     * main メソッド
//     * @param args
//     */
//    public static void main(String[] args) {
//        try {
//        	Test example = new Test();
//            example.createGUI();
//            example.setVisible(true);
//
//            example.runProgress();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    /**
//     * GUIを作成
//     */
//    public void createGUI() {
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        int width = 640;
//        int height = 480;
//        this.setSize(width, height);
//        this.setTitle("JProgressBarExample");
//
//        progressBar1 = new JProgressBar();
//        progressBar1.setStringPainted(true);
//        progressBar1.setMinimum(0);
//        progressBar1.setMaximum(100);
//        progressBar1.setValue(0);
//        progressBar1.setVisible(true);
//        this.add(progressBar1);
//    }
//
//    /**
//     * プログレスの実行
//     */
//    public void runProgress() {
//        for (int i = progressBar1.getMinimum();
//                i <= progressBar1.getMaximum(); i++) {
//            progressBar1.setValue(i);
////          progressBar1.repaint();
//            execHeavyProcess();
//        }
//    }
//
//    /**
//     * 負荷を掛ける処理
//     */
//    public void execHeavyProcess() {
//        long start = System.currentTimeMillis();
//        long millis = 1000;
//        long now = 0;
//        for (;;) {
//            now = System.currentTimeMillis();
//            if ((start + millis < now) || (now < start)) {
//                break;
//            }
//        }
//    }
//
//}





















//package jp.ne.tbs.control.FD01;
//
//import java.net.InetAddress;
//import java.net.NetworkInterface;
//import java.net.SocketException;
//import java.util.Enumeration;
//
//public class Test {
//
//	public static void main(String[] args) throws SocketException {
//
//		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
//		while(e.hasMoreElements())
//		{
//		    NetworkInterface n = (NetworkInterface) e.nextElement();
//		    Enumeration<InetAddress> ee = n.getInetAddresses();
//		    while (ee.hasMoreElements())
//		    {
//		        InetAddress i = (InetAddress) ee.nextElement();
//		        String ipAddress = i.getHostAddress();
//		        if(ipAddress.startsWith("192.168.")) {
//			        System.out.println(i.getHostAddress());
//		        }
//		    }
//		}
//
//
//
//		String targetStr = "/*インフルエンザ希望\r\n"
//				+ "　あり\r\n"
//				+ "家族\r\n"
//				+ "　１人\r\n"
//				+ "続柄\r\n"
//				+ "　妻\r\n"
//				+ "保険証撮影\r\n"
//				+ "　済\r\n"
//				+ "助成\r\n"
//				+ "　あり\r\n"
//				+ "予診票保管場所\r\n"
//				+ "　たんすの上\r\n"
//				+ "支払方法\r\n"
//				+ "　本人口座から";

//		String targetStr = "/*インフルエンザ希望　あり\r\n"
//				+ "家族\r\n"
//				+ "　１人\r\n"
//				+ "続柄\r\n"
//				+ "　妻\r\n"
//				+ "保険証撮影\r\n"
//				+ "　済\r\n"
//				+ "助成\r\n"
//				+ "　あり\r\n"
//				+ "予診票保管場所\r\n"
//				+ "　たんすの上\r\n"
//				+ "支払方法\r\n"
//				+ "　本人口座から";
//
//		System.out.println("初期文字列⇒" + targetStr);
//
//		//項目１　項目名　取得
//		String nme1 = "/*インフルエンザ希望";
//
//		//項目名が対象文字列にある場合
//		if (targetStr.contains(nme1)) {
//
//			//格納用結果を定義
//			String result1 = MAAT00.CHAR.EMPTY_STRING;
//			//項目１　区切り文字　取得
////			String dlm1 = "\r\n";
//			String dlm1 = "";
//			//項目１　終了文字　取得
//			String end1 = "\r\n";
//			//終了文字のインデックスを定義
//			int indexEnd1 = 0;
//
//			//区切り文字が設定されている場合
//			if (!dlm1.equals(MAAT00.CHAR.EMPTY_STRING)) {
//
//				//区切り文字のインデックスを取得
//				int indexDlm1 = targetStr.indexOf(dlm1);
//				//区切り文字を含めた文字列長を算出
//				indexDlm1 += dlm1.length();
//				//区切り文字以降の文字列を取得
//				targetStr = targetStr.substring(indexDlm1);
//				//終了文字のインデックスを取得
//				indexEnd1 = targetStr.indexOf(end1);
//				//終了文字以前の文字列を取得
//				result1 = targetStr.substring(0, indexEnd1);
//
//			//区切り文字が設定されていない場合
//			} else {
//
//				//項目名のインデックスを取得
//				int indexNme1 = targetStr.indexOf(nme1);
//				//項目名を含めた文字列長を取得
//				indexNme1 += nme1.length();
//				//終了文字のインデックスを取得
//				indexEnd1 = targetStr.indexOf(end1);
//				//項目名以降、終了文字以前の文字列を取得
//				result1 = targetStr.substring(indexNme1, indexEnd1);
//
//			}
//
//			System.out.println("格納用結果①⇒" + result1.replaceFirst("^[\\h]+", "").replaceFirst("[\\h]+$", ""));
//
//			//終了文字を含めた文字列長を算出
//			indexEnd1 += end1.length();
//			//終了文字以降の文字列を取得し、次の処理に渡す
//			targetStr = targetStr.substring(indexEnd1);
//
//			System.out.println("ここから対象文字列①⇒" + targetStr);
//
//			//項目１　区切り文字　取得
//			//				String dlm1 = "\r\n";
//			//				int indexDlm1 = targetStr.indexOf(dlm1);
//			//				indexDlm1 += dlm1.length();
//			//				targetStr = targetStr.substring(indexDlm1);
//			//				System.out.println("ここから対象文字列②⇒" + targetStr);
//
//		}
//
//	}
//
//}

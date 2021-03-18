package jp.ne.tbs.view.AM01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

public class MAM01V002Z00 implements Runnable {

	/* 汎用的なあみだくじ */
	static final String GENERAL_AMIDAKUJI = "お昼のアミダ";

	//棒の数
	int verticalNumber = 5;
	//横棒の最大ボン数
	int horizontalMaxNumber = 9;
	int yh = 26;
	//横棒の密度
	int horizontalDensity = horizontalMaxNumber - 2;
	//左余白
	int x0 = 40;
	//上余白
	int y0 = 50;
	//横棒の長さ
	int horizontalLength = 210 / (verticalNumber - 1);
	//縦棒の長さ
	int verticalLength = yh * (horizontalMaxNumber + 1);
	//縦棒の下端座標
	int y1 = y0 + verticalLength;
	//隣の横棒をずらす量
	int yh2 = yh / 2;

	MAM01V002Z00 amidaKuji;
	Frame frameAmidakuji;
	AmidaCanvas amidaCanvas;
	Graphics graPhics;
	Random rnd = new Random();
	boolean [][] hb = new boolean[10][horizontalMaxNumber];
	boolean isGenerated = false;
	String[] gs = new String[10];

	Button initializeButton, generateButton;
	//棒数の初期値(５本)
	TextField textField = new TextField("5", 2);

	int animationSpeed =200;
	int gn;
	boolean up;
	boolean running = false;


	/**
	 * 汎用的なあみだくじのコンストラクタ
	 */
	public MAM01V002Z00() {

		amidaKuji = this;
		frameAmidakuji = new Frame(GENERAL_AMIDAKUJI);
		frameAmidakuji.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				frameAmidakuji.dispose();
			}
		});

		amidaCanvas = new AmidaCanvas(300, 350);
		graPhics = amidaCanvas.bufferedImage.getGraphics();
		frameAmidakuji.add(amidaCanvas, BorderLayout.CENTER);

		Panel panelNorth = new Panel();
		Panel panelSouth = new Panel();
		Panel panelWest = new Panel();
		Panel panelEast = new Panel();
		panelNorth.setLayout(new FlowLayout(FlowLayout.LEFT));

		initializeButton = new Button("初期化");
		initializeButton.addActionListener(new InitializeAmidaKuji());
		//textField.addActionListener(new InitializeAmidaKuji());

		generateButton = new Button("あみだくじ生成");
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isGenerated) {
					drawAmida(verticalNumber - 1);
					amidaCanvas.repaint();
				}
			}
		});

		panelNorth.add(new Label("人数:"));
		panelNorth.add(textField);
		panelNorth.add(initializeButton);
		panelNorth.add(generateButton);
		frameAmidakuji.add(panelNorth, BorderLayout.NORTH);
		frameAmidakuji.add(panelSouth, BorderLayout.SOUTH);
		frameAmidakuji.add(panelWest, BorderLayout.WEST);
		frameAmidakuji.add(panelEast, BorderLayout.EAST);
		frameAmidakuji.setSize(360, 440);
		frameAmidakuji.setVisible(true);
	}

	/**
	 * あみだくじを描画するメソッド
	 */
	//n = (縦棒の数 -1)
	void drawAmida(int n) {
		graPhics.setColor(Color.GRAY);
		graPhics.fillRect(0, 0, amidaCanvas.bufferedImage.getWidth(),
				amidaCanvas.bufferedImage.getHeight());
		graPhics.setColor(Color.BLACK);

		graPhics.drawString("文字の近辺をクリックしてください",5,20);
		//縦棒を描画
		for(int i = 0; i < verticalNumber; ++i) {
			int x = horizontalLength * i + x0;
			graPhics.drawLine(x, y0, x, y1);
			//棒の上のラベル
//TODO　ここ？
			graPhics.drawString(Character.toString((char)('A' + i)), x -3, y0 - 6);
			//棒の下ラベル
			graPhics.drawString(gs[i], x - 3, y1 + 16);
		}

		for(int i = 0; i < n; ++i) {
			for(int v = 0; v < horizontalMaxNumber; ++v) {
				if(hb[i][v]) {
					int x = horizontalLength * i + x0;
					int y2 = v * yh + y0 + yh2 + (i & 1) * yh2;
					graPhics.drawLine(x, y2, x + horizontalLength, y2);
				}
			}
		}
	}


	/**
	 * あみだをたどるアニメ描画スレッド
	 */
	@Override
	public void run() {
		if(running) {
			return;
		}
		running = true;
		int y2, x, yt, j, ye;
		int i = gn;
		if(i >= verticalNumber) {
			i = verticalNumber - 1;
		}
		y2 = x = 0;
		graPhics.setColor(Color.CYAN);
		yt = y0;
		ye = y1;
		if(up) {
			yt = y1;
			ye = y0;
			graPhics.setColor(Color.YELLOW);
		}
		for(int j2 = 0; j2 < horizontalMaxNumber * 2; ++j2){
			j = j2;
			if(up) {
				j = horizontalMaxNumber * 2 - j2 -1;
			}
			y2 = j * yh2 + y0 + yh2;
			x = i * horizontalLength + x0;
			if(up) {
				graPhics.fillRect(x - 1, y2, 3, yt - y2);
			} else {
				graPhics.fillRect(x - 1, yt, 3, yh2);
			}
			repaintwait(animationSpeed);
			yt = y2;
			//偶数上段 or 奇数下段
			if(((j ^ i) & 1) == 0) {
				//右を見る
				//右端でなければ
				if(i < (verticalNumber - 1)) {
					//右に横棒あり？
					if(hb[i][j / 2]) {
						graPhics.fillRect(x, yt -1, horizontalLength + 2, 3);
						repaintwait(animationSpeed);
						++i;
					}
				}
			//偶数下段 or 奇数上段
			} else {
				//左を見る
				//左端でなければ
				if(i > 0) {
					//左に棒あり？
					if(hb[i - 1][j / 2]) {
						graPhics.fillRect(x - horizontalLength, yt -1, horizontalLength + 2, 3);
						repaintwait(animationSpeed);
						--i;
					}
				}
			}
		}
		// for j
		x = i * horizontalLength + x0;
		if(up) {
			graPhics.fillRect(x - 1, ye, 3, yh2);
		} else {
			graPhics.fillRect(x - 1, yt, 3, ye - yt);
		}
		repaintwait(animationSpeed);
		running = false;
	}

	/**
	 * 再描画メソッド
	 */
	void repaintwait(int wt) {
		amidaCanvas.repaint();
		try{
			Thread.sleep(wt);
		} catch(InterruptedException e) {
			System.out.println("sleep Excepton!");
		}
	}

	/**
	 * 汎用的なあみだくじの初期化クラス
	 */
	class InitializeAmidaKuji implements ActionListener{

		public InitializeAmidaKuji() {
			subInitializeAmidaKuji();
		}

		public void subInitializeAmidaKuji() {
			if(running) {
				return;
			}

			try {
				verticalNumber = Integer.parseInt(textField.getText());
			} catch (NumberFormatException ex){
				verticalNumber = 6;
			}
			if(verticalNumber < 2) {
				verticalNumber = 2;
			}
			if(verticalNumber > 10) {
				verticalNumber = 10;
			}

			textField.setText(Integer.toString(verticalNumber));

			//横棒の長さ
			horizontalLength = 210 / (verticalNumber - 1);

			//ゴールの数値セット
			for (int i = 0; i < verticalNumber; ++i) {
//TODO ここ？
				gs[i] = Integer.toString(i);
			}

			//シャッフル
			for(int i = 0; i < verticalNumber; ++i) {
				int j = rnd.nextInt(verticalNumber);
				int k = rnd.nextInt(verticalNumber);
				String t = gs[j];
				gs[j] = gs[k];
				gs[k] = t;
			}

			//横棒の有無をクリア
			for (int rx = 0; rx < verticalNumber; ++rx) {
				Arrays.fill(hb[rx], false);
			}
			//乱数で横棒をセット
			for(int i = 0; i < (verticalNumber - 1); ++i) {
				for(int j = 0; j < horizontalDensity; ++j) {
					int r = rnd.nextInt(horizontalMaxNumber);
					hb[i][r] = true;
				}

			}

			//縦棒のみ描画
			graPhics.setColor(Color.GRAY);
			graPhics.fillRect(0, 0, amidaCanvas.bufferedImage.getWidth(),
					amidaCanvas.bufferedImage.getHeight());
			graPhics.setColor(Color.BLACK);
			//縦棒を描画
			for(int i = 0; i < verticalNumber; ++i) {
				int x = horizontalLength * i + x0;
				graPhics.drawLine(x, y0, x, y1);
				//棒の上のラベル
				graPhics.drawString(Character.toString((char)('A' + i)),
					x - 3, y0 - 6);
				//棒の下のラベル
				graPhics.drawString(gs[i], x - 3, y1 + 16);

			}
			amidaCanvas.repaint();
			isGenerated = true;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.subInitializeAmidaKuji();
		}
	}


	/**
	 * あみだくじのキャンバス
	 */
	 public class AmidaCanvas extends Canvas{
		 private static final long serialVersionUID = 1L;
		 public BufferedImage bufferedImage;

		 public AmidaCanvas(int width, int height) {
			 bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			 this.addMouseListener(new ClickHandler());
		 }

		 public void paint(Graphics graPhics) {
			 graPhics.drawImage(bufferedImage,0,0,null);
		 }

		 public void update(Graphics graPhics) {
			 paint(graPhics);
		 }

	 }

	/**
	 * マウスがクリックされたときにハンドラー
	 */
	 class ClickHandler extends MouseAdapter{
		 public void mouseClicked(MouseEvent me) {
			 if(!isGenerated) {
				 return;
			 }
			 if(running) {
				 return;
			 }
			 int cky = -1;
			 int ckx = -1;

			 int y = me.getY();
			 if ((y > (y0 -20)) && (y < y0)) {
				 //棒の上(アルファベット)
				 cky = 0;
			 } else if ((y > y1) && (y < (y1 + 20))) {
				 //棒の下(数字)
				 cky = 1;
			 }

			 if(cky >= 0) {
				 int x = me.getX();
				 int x2 = (x - x0 +8) / horizontalLength;
				 int x3 = x2 * horizontalLength + 8 + x0;
				 if((x > (x0 - 8)) && (x < x3)) {
					 ckx = x2;
				 }
				 if(ckx >= 0) {
					 gn = ckx;
					 up = (cky == 1);
					 drawAmida(verticalNumber - 1);
					 new Thread(amidaKuji).start();
				 }

			 }
		 }
	 }
}

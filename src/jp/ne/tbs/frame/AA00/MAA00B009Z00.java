package jp.ne.tbs.frame.AA00;

import java.awt.Component;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.swing.JOptionPane;

/**
 * <p>[クラス名]</p>
 * 　　CA クラス
 * <p>[概要]</p>
 * 　　共通領域(Common Aria)を保持するクラス
 * 　　エラー情報、IPアドレス、ユーザー情報を保持する。
 * <p>[変更履歴]</p>
 * 　　2019/09/30　小嶋純史　新規作成
 */
public class MAA00B009Z00 {

	/**
	 * 業務エラー
	 */
	private String bussnesErrCode = null;

	/**
	 * IPアドレス
	 */
	private String ipAddress = null;

	/**
	 *  データベースのURL
	 */
	private String dbUrl = null;

	/**
	 * コンストラクタ
	 */
	protected MAA00B009Z00() {

		//変数の初期化
		this.bussnesErrCode = MAAT00.CHAR.EMPTY_STRING;
		this.ipAddress = MAAT00.CHAR.EMPTY_STRING;
		this.dbUrl = MAAT00.CHAR.EMPTY_STRING;

		//初期化処理
		this.init();
	}

	/**
	 * <p>[概 要] 初期化を実行する。</p>
	 * <p>[詳 細] ①IPアドレス取得②DB_URL取得</p>
	 * <p>[備 考] </p>
	 */
	private void init() {

		//=================
		//① IPアドレスを取得
		//=================
		Enumeration<NetworkInterface> e;
		try {
			e = NetworkInterface.getNetworkInterfaces();
			while (e.hasMoreElements()) {
				NetworkInterface n = (NetworkInterface) e.nextElement();
				Enumeration<InetAddress> ee = n.getInetAddresses();
				while (ee.hasMoreElements()) {
					InetAddress i = (InetAddress) ee.nextElement();
					String ip = i.getHostAddress();
					if (ip.startsWith(MAAT00.SYS.IP_EAST)
							|| ip.startsWith(MAAT00.SYS.IP_WEST)) {
						ipAddress = ip;
					}
				}
			}
		} catch (SocketException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} finally {
			//IPアドレスが想定外の場合、エラーとする。
			if (ipAddress.equals(MAAT00.CHAR.EMPTY_STRING)) {
				this.bussnesErrCode = MAAE00.EAA00A001;
			}
		}

		//=================
		//② IPアドレスを取得
		//=================
		if (ipAddress.startsWith(MAAT00.SYS.IP_EAST)) {
			dbUrl = MAAT00.SYS.DB_URL_EAST;
		}else if(ipAddress.startsWith(MAAT00.SYS.IP_WEST)) {
			dbUrl = MAAT00.SYS.DB_URL_WEST;
		}
	}

	/**
	 * <p>[概 要] </p>
	 * 　業務エラー を設定する。
	 * <p>[詳 細] </p>
	 * 　業務エラーコード(MAAExx.Exxxxxxxx)を設定することにより、<BR>
	 * 　エラーメッセージを画面表示する。
	 * <p>[備 考] </p>
	 * @param bussnesErrCode セットする bussnesErrCode
	 */
	public void setBussnesErrCode(String bussnesErrCode) {
		JOptionPane.showConfirmDialog((Component) null, bussnesErrCode, "エラー", -1, 1);
		this.bussnesErrCode = bussnesErrCode;
	}

	/**
	 * <p>[概 要] </p>
	 * 　エラーが発生しているかを返却する。
	 * <p>[詳 細] </p>
	 * 　エラー発生あり＝true<BR>
	 * 　エラー発生なし＝false<BR>
	 * <p>[備 考] </p>
	 * @param bussnesErrCode セットする bussnesErrCode
	 */
	public Boolean errOccurred() {

		//エラーが発生していない場合
		if (bussnesErrCode.equals(MAAT00.CHAR.EMPTY_STRING)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * <p>[概 要] </p>
	 * 　IPアドレスを取得する。
	 * <p>[詳 細] </p>
	 * 　アプリケーションを実行したマシンのIPアドレスを返却。<BR>
	 * 　「192.168.XX.XXX」を返却する。
	 * <p>[備 考] </p>
	 * @return ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * <p>[概 要] </p>
	 * 　dbUrl を取得する。
	 * <p>[詳 細] </p>
	 * 　IPアドレスより事業所を判別し、その事業所のDBアドレスを返却する。<BR>
	 * <p>[備 考] </p>
	 * @return dbUrl
	 */
	public String getDbUrl() {
		return dbUrl;
	}

}

package jp.ne.tbs.control.FD03;

public class Test {

	public static void main(String[] args) {

		//入力項目　名前　配列
		String[] itmNmeList = new String[3];

		itmNmeList[0] = "ああ";
		itmNmeList[1] = "いい";
//		itmNmeList[2] = "うう";

		System.out.println(itmNmeList.length);

		for(String string :itmNmeList) {
			System.out.println(string);
		}

	}

}

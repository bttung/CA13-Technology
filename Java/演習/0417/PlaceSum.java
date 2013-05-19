import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlaceSum {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("3桁の数値を入力してください。");
			String line = reader.readLine();
			int sum = 0;

			/*
			// 方針1
			int n = Integer.parseInt(line);

			sum = sum + (n % 10);
			n = n / 10;

			sum = sum + (n % 10);
			n = n / 10;

			sum = sum + (n % 10);
			*/

			/*
			// 方針2
			// 数値かどうかのチェック
			Integer.parseInt(line);

			char c = line.charAt(0);
			sum = sum + Integer.parseInt("" + c);

			c = line.charAt(1);
			sum = sum + Integer.parseInt("" + c);

			c = line.charAt(2);
			sum = sum + Integer.parseInt("" + c);
			*/


			// 方針3
			// 数値かどうかのチェック
			Integer.parseInt(line);

			// 3桁の数値の総和を求める
			char c = line.charAt(0);
			sum = sum + (c - '0');

			c = line.charAt(1);
			sum = sum + (c - '0');

			c = line.charAt(2);
			sum = sum + (c - '0');


			System.out.println(sum);

			// 割り切れるかどうかの表示
			if (sum % 9 == 0) {
				System.out.println(line + "は9で割り切れますね。");
			} else if (sum % 3 == 0) {
				System.out.println(line + "は3で割り切れますね。");
			} else {
				System.out.println(line + "は3でも9でも割り切れませんね。");
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("数字の形式が正しくありません。");
		}

	}

}

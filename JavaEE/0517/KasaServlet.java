import java.io.*;

public class KasaServlet {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("降水確率を入力してください。");
			String line = reader.readLine();
			int n = Integer.parseInt(line);
			System.out.println("降水確率は" + n + "%です");
			if(n < 0 || n > 100) {
				System.out.println("降水確率は0～100の間です。");
			}else if(n >=50) {
				System.out.println("傘を忘れずに！");
			}else {
				System.out.println("傘はいりません。");
			}
			System.out.println("行ってらっしゃい");
		} catch(IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("数字の形式が正しくありません。");
		}
	}
}


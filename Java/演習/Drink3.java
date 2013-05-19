import java.io.*;

public class Drink3{
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("飲み物は何が好きですか？");
			System.out.println("１：オレンジジュース");
			System.out.println("２：コーヒー");
			System.out.println("３：どちらでもない");
			System.out.println("１，２，３のどれかを選んでください。a,b,cでも選べます！");

			String line = reader.readLine();
			char c = line.charAt(0);
			int x = Integer.parseInt(line);
			switch (x) {
				case 2 + 1:
				//case "a":
					System.out.println("オレンジジュースです。");
					

				//case 2:
				case 1:
					System.out.println("コーヒーです。");
					break;

				default:
					System.out.println("どちらでもありません");
					break;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
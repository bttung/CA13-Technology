import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Janken1 {
	
	/**
	 * mainメソッド
	 * ＠Author 高妻智一
	 */
	public static void main(String[] args) {
				
		int computer;	//相手が出した手
		int player;		//自分が出した手
		
		System.out.println("じゃんけんをしましょう！");
		System.out.println("１：グー　２：チョキ　３；パー");
		System.out.println("じゃーんけーん・・");
		
		computer = (int)(Math.random() * 3) + 1;
		System.out.println(computer);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = reader.readLine();
			player = Integer.parseInt(line);
			
			hantei(player, computer);
			
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("1~3の数字を入力して下さい。");
		}
	}
	
	/**勝ち負けを判定する.
	 * @Author 高妻智一
	 * @param playerHand 自分の出した手
	 * @param computerHand CPUの出した手
	 */
	private static void hantei(int player, int computer) {
			int result = player - computer;
			if(result == 2 || -1) {
				System.out.println("あなたの勝ちです。");
			} else if(result == 0) {
				System.out.println("あいこです。");
			} else if(result == 1 || result == -2) {
				System.out.println("あなたの負けです。");
			}
		}
}



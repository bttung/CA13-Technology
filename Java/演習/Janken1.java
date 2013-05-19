import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * じゃんけんを一回だけ行うプログラム.
 * @author 高妻智一
 */
public class Janken1 {

	/**
	 * 入力を受け取ったらplayerに代入.ランダム生成した1～3の数値をcomputerに代入.
	 * playerとcomputerに代入した値を引数に勝敗を計算し、勝敗を表示する.
	 * @author 高妻智一
	 */
	public static void main(String[] args) {
		
		System.out.println("じゃんけんをしましょう！");
		System.out.println("１：グー　２：チョキ　３；パー");
		System.out.println("じゃーんけーん・・");
		System.out.println("1,2,3の数字を入力してください。");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			//入力した数字をplayerに代入する。
			String line = reader.readLine();
			int player = Integer.parseInt(line); 

			 //ランダム生成した数字をcomputerに代入する。
			int computer = (int)(Math.random() * 3) + 1;

			if(player < 1 && 3 < player) {
				System.out.println("1,2,3の数字を入力してください。");
				System.exit(-1);
			}

			//勝ち負けの結果を代入する
			int result = judgeCalc(player, computer); 

			//勝ち負けを表示する
			judge(result); 
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("数字以外が入力されています。");
		}
	}
	
	/**
	 * 勝ち負けを計算する.自分の手 - 相手の手をの値をresultに代入.
	 * @author 高妻智一
	 * @param player 自分の出した手
	 * @param computer CPUの出した手
	 */
	private static int judgeCalc(int player, int computer) {
		return player - computer;
	}
	
	/**
	 * 勝ち負けを判定する.
	 * @author 高妻智一
	 * @param result 勝ちの場合は2, -1　引き分けの場合0 負けの場合は1, -1	 
	 */
	private static void judge(int result) {
			if(result == 2 || result == -1) {
				System.out.println("あなたの勝ちです。");
			} else if(result == 0) {
				System.out.println("あいこです。");
			} else if(result == 1 || result == -2) {
				System.out.println("あなたの負けです。");
			}
		}
}



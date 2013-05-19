import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 勝ち負けが決まるまでじゃんけんを行うプログラム.
 * @author 高妻智一
 */
public class Janken2 {
	
	private static boolean isEnd = false; //じゃんけんの勝ち負けが決まったらfalseを代入して終了する.
	
	/**
	 * 入力を受け取ったらplayerに代入。ランダム生成した1～3の数値をcomputerに代入.
	 * playerとcomputerに代入した値を引数に勝敗を計算し、勝敗を表示する.
	 * @author 高妻智一
	 */
	public static void main(String[] args) {
		
		System.out.println("じゃんけんをしましょう！");
		System.out.println("１：グー　２：チョキ　３；パー");
		System.out.println("じゃーんけーん・・");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int result; //勝ち負けの結果を代入する
		int player;
		int computer;
		boolean isFirstFlag = true; //一番最初のじゃんけんかどうか判定する

		while (!isEnd) {
			try {	
				System.out.println("出す手を入力->");
				String line = reader.readLine();
				player = Integer.parseInt(line); //入力した数字をplayerに代入する。
				computer = (int)(Math.random() * 3) + 1; //ランダム生成した数字をcomputerに代入する

				if (player < 0 || 4 < player) {
					System.out.println("1,2,3の数字を入力してください。");
					System.exit(-1);
				}
				judgeKakegoe(isFirstFlag); //掛け声の判定
				showHand(player, computer); //選んだ手を表示する
				printResult(player - computer); //勝ち負けを表示する
			} catch (IOException e) {
				System.out.println(e);
			} catch (NumberFormatException e) {
				System.out.println("数字以外が入力されています。");
				System.out.println("1,2,3の数字を入力して下さい。");
			}
			
		}
	}

	/**
	 * 1回目のじゃんけんなのかあいこで継続するのか判定する.
	 * @author 高妻智一
	 */
	private static void judgeKakegoe(boolean isFirstFlag) {
		if (isFirstFlag) {
			System.out.println("ぽん！");
			isFirstFlag = false;
		} else {
			System.out.println("しょっ！");
		}
	}

	/**
	 * playerとcomputerの出した手を表示する.
	 * @author 高妻智一
	 * @param player 自分の出した手
	 * @param computer CPUの出した手
	 */
	private static void showHand(int player, int computer) {
		String HAND[] = {"グー", "チョキ", "パー"};
		System.out.println("あなたの手は" + HAND[player - 1] +"、相手の手は" + HAND[computer - 1] + "です。");
	}
	
	/**
	 * 勝ち負けを判定して表示する.
	 * @author 高妻智一
	 */
	private static void printResult(int result) {
		if (result == 2 || result == -1) {
			System.out.println("あなたの勝ちです。");
			isEnd = true;
		} else if(result == 0) {
			System.out.println("あ-いこ-で・・・");
		} else if(result == 1 || result == -2) {
			System.out.println("あなたの負けです。");
			isEnd = true;
		}
	}
}



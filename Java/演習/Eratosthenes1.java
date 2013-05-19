import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**	
 *	素数を表示するプログラム.
 *	@author　高妻智一
 *	@param	boolean[] arrayNum
 */
public class Eratosthenes1 {

	/**	
	 *	標準入力の値までの範囲で、素数かどうか判断し、素数を表示させる.
	 *	@author　高妻智一
	 */
	public static void main(String[] args) {
		
		System.out.println("入力した数までの素数を出力するプログラムです。");
		String line = null;
		int maxNum = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			line = reader.readLine();
			
			//標準入力から値をmaxNumに代入
			maxNum = Integer.parseInt(line);
			if (maxNum < 0) {
				System.out.println("正の整数を入力してください。s");
				System.exit(-1);
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("入力が正しくありません。正の整数を入力してください");
		}

		//judgePrimsメソッドで素数かどうか判断し、arrayNumに代入する
		boolean[] arrayNum = judgePrims(maxNum);

		//arrayの中のture（素数）のみを表示
		printPrims(arrayNum);
	}

	/**	
	 *	入力された数値の範囲まででどれが素数かを判断する.
	 *	素数を表示する.
	 *	@author　高妻智一
	 *	@param	boolean[] arrayNum	trueが素数 falseは素数ではない
	 */
	private static boolean[] judgePrims(int maxNum) {

		//素数かどうかを代入 true:素数 false：素数じゃない
		boolean[] arrayNum = new boolean[maxNum + 1];
		Arrays.fill(arrayNum, true);
	 	final int ARRAY_NUM_LENGTH = arrayNum.length;

	 	//素数２から始める
	 	for (int i = 2; i * i < ARRAY_NUM_LENGTH; i++){
	        if(!arrayNum[i]){
	        	continue;
	        }
	        for (int j = i+i; j< ARRAY_NUM_LENGTH; j+=i ){
	            if (arrayNum[j]) {
	                arrayNum[j] =false;
	            }
	        }
	    }
	    return arrayNum;
	}

	/**	
	 *	素数を表示する.
	 *	@author　高妻智一
	 *	@param	boolean[] arrayNum
	 */
    private static void printPrims(boolean[] arrayNum) {
    	ArrayList<Integer> primeList = new ArrayList<Integer>();
    	for (int i = 2; i < arrayNum.length; i++) {
    		if (arrayNum[i]) {
    			primeList.add(i);
    		}
    	}
    	for (int i = 0; i < primeList.size(); i++) {
    		System.out.print(primeList.get(i));
    		System.out.print(" ");
    	}
    }
}
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
	 *	数値の入力をし、判断、表示させる.
	 *	@author　高妻智一
	 *	@param	boolean[] arrayNum
	 */
	public static void main(String[] args) {

		System.out.println("入力した数までの素数を出力するプログラムです。");
		System.out.println();
		String line = null;

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("自然数を入力してください。");
		}

		//入力値
		int maxNum = Integer.parseInt(line);

		//素数かどうかを判断 true:素数 false：素数じゃない
		boolean[] arrayNum = new boolean[maxNum + 1];
		Arrays.fill(arrayNum, true);

		//素数かどうか判断
		judgePrims(arrayNum);

		//素数を表示
		printPrims(arrayNum);
	}
	/**	入力された数値の範囲mまででどれが素数かを判断する.
	 *	素数を表示する.
	 *	@author　高妻智一
	 *	@param	boolean[] arrayNum
	 */
	public static void judgePrims(boolean[] arrayNum) {
	    for (int i = 2; i * i < arrayNum.length; i++){
	        if(arrayNum[i]){
	            for (int j = i+i; j< arrayNum.length; j+=i ){
	                if (arrayNum[j]) {
	                    arrayNum[j] =false;
	                }
	            }
	        }
	    }
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
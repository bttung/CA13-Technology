import java.io.IOException;

/** 
 *	ヒストグラムをするプログラムです.
 *	@author　高妻智一
 */
public class Histogram1 {

	/** 
 	*	標準入力からヒストグラムの高さを取得して表示する.
 	*	
 	*/
	public static void main(String[] args) {

		final int ARGS_LENGTH = args.length;
		int[] height = new int[ARGS_LENGTH];
		
		try {
			for (int i = 0; i < ARGS_LENGTH; i++) {
				height[i] = Integer.parseInt(args[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("正の整数を入力してください。");
		}

		int maxHeight = returnMaxValue(height);

		String[][] histogram = makeHistogram(maxHeight, height);

		printMatrix(histogram);
	}

	/** 
 	*	引数に渡した１次元配列の最大値を返す.
 	*	
 	*	@param array　１次元配列
 	*/
	private static int returnMaxValue(int[] array) {
		int maxValue = 0;
		for (int i = 0; i < array.length; i++) {
			if (maxValue < array[i]) {
				maxValue = array[i];
			}
		}
		return maxValue;
	}

	/** 
 	*	引数に渡した１次元配列の最大値を返す.
 	*	
 	*	@param int maxHeight
 	*	@param int[] height
 	*/
	private static String[][] makeHistogram(int maxHeight, int[] height) {
		String[][] histogram = new String[maxHeight][height.length];
		for (int i = 0; i < maxHeight; i++) {
			for (int j = 0; j < height.length; j++) {
				if (maxHeight - i  > height[j]) {
					histogram[i][j] = "  ";
				} else {
					histogram[i][j] = "■";
				}
			}
		}
		return histogram;
	}

	/** 
 	*	引数に渡した１次元配列を表示する.
 	*
 	*	@param 
 	*/
	private static void printMatrix(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println("");
		}
	} 

}





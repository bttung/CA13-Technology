public class Diamond {
	public static void main(String[] args) {

		final int SIZE = 3;
		final int HALF = SIZE / 2 + 1;
		
		for (int l = 0; l < HALF; l++) {
			for (int i = 1 + l; i <= HALF; i++ ) {
				System.out.print(" ");
			}
			for (int j = 1 + 2 * l; j >= 1; j-- ) {
				System.out.print("*");
			}
			for(int k = 1 + l; k <= HALF; k++) {
				System.out.print(" ");
			}
			System.out.println("");
		}

		for (int l = 1; l < HALF; l++) {
			for (int i = 1 + l; i >= 1; i-- ) {
				System.out.print(" ");
			}
			for (int j = 1 + 2 * l; j <= SIZE; j++ ) {
				System.out.print("*");
			}
			for(int k = 1 + l; k >= 1; k--) {
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
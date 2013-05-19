public class Triangle {
	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {
			System.out.println("");
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
		}
		for(int i = 1; i <= 9; i++) {
			System.out.println("");
			for(int j = 9; j >= i; j--) {
				System.out.print("*");
			}
		}
	}
}
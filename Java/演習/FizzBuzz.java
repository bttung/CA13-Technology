public class FizzBuzz {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
			if (i % 15 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0 && 1 % 5 != 0) {
				System.out.println("Fizz");
			} else if (i % 3 != 0 && i % 5 == 0) {
				System.out.println("Buzz");
			}
		}
	}
}
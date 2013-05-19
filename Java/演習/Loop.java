public class Loop {
	public static void main(String[] args) {
		loop1:
		for (int i = 0; i < 3; i++) {
			a111:
			for (int j = 0; j < 5; j++) {
				if (j ==3) {
					break loop1;
					//continue;
				}
				System.out.println("i="+i+"j="+j);
			}
		System.out.println("あ");
		}
		System.out.println("い");
	}
}
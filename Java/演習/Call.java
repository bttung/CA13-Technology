public class Call {
	public static void main(String[] args) {
		int a = 0, b = 10;
		System.out.println("a=" + a + ", b=" + b);
		testVar(a, b);
		System.out.println("a=" + a + ", b=" + b);
		
		int[] arr = {0, 10};
		System.out.println("arr[0]=" + arr[0] + ", arr[1]=" + arr[1]);
		testArr(arr);
		System.out.println("arr[0]=" + arr[0] + ", arr[1]=" + arr[1]);
	}
	
	public static void testVar(int a1, int a2) {
		a1 = 20;
	}
	
	public static void testArr(int[] arr) {
		arr[0] = 20;
	}
}
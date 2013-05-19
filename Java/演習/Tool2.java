public class Tool2 {
	public static int add(int a, int b) {
		return a + b;
	}

	public static int print(String str) {
		System.out.print(str);
		return 0;
	}

	public static void repeat(String str, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(str);
		}
		return;
	}

	public static void hello() {
		System.out.println("HelloWorld!!");
	}

	public static String changeString(double d) {
		String str = Double.toString(d);
		return str;
	}

	public static double division(int a, int b) {
		double d = (double)(a/b);
		return d;
	}

	public static String name() {
		return "高妻智一";
	}

	public static boolean judge(int a) {
		if (a == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static double square(double width, double height) {
		return width * height;
		
	}

	public static double triangle(int a, int b) {
		return a + b;
	}

	public static String sample(char c1, char c2) {
		String mojiretsu = "" + c1 + c2;
		return mojiretsu;
	}

	public static int judgeNum(int x) {
		if (x < 299) {
			return 5;
		} else if (300 < x && x < 999) {
			return 15;
		} else if (1000 < x && x < 4999) {
			return 30;
		} else {
			return 50;
		}
	}

	public static boolean leapYear(int year) {
		if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
			return true;
		} else {
			return false;
		}
	}


}
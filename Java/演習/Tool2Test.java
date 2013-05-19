public class Tool2Test {
	public static void main(String[] args) {
		Tool2.add(1, 2);

		Tool2.print("kouzuma");

		Tool2.repeat("あ", 5);

		Tool2.hello();

		String str = Tool2.changeString(1.222);
		System.out.println(str);

		double d = Tool2.division(5, 2);
		System.out.println(d);

		String name = Tool2.name();
		System.out.println(name);

		System.out.println(Tool2.judge(1));

		double area = Tool2.square(1.5, 2.5);
		System.out.println(area);

		String s = Tool2.sample('a', 'b');
		System.out.println(s);

		int g = Tool2.judgeNum(1000);
		System.out.println(g);

		boolean leap = Tool2.leapYear(2001);
		System.out.println(leap);
	}
}
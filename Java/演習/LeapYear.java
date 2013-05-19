import java.io.*;

public class LeapYear {
	public static void main (String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {	
			String line = reader.readLine();
			int year = Integer.parseInt(line);
			
			if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
				System.out.println("���邤�N�ł��B");
			} else {
				System.out.println("���邤�N�ł͂���܂���B");
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
				System.out.println("��������͂��Ă�������");
		}
	}
}
import java.io.*;

public class PlaceSum {
	public static void main (String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int sum = 0;
			String line = reader.readLine();
			ini 
			for (int i = 0; i < 3; i++) {
				int x = line.charAt(i);
				sum = sum + x; 
				System.out.println(sum);
			} 
		}catch(IOException e) {
				System.out.println(e);
		}
	}
}
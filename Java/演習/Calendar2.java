import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 標準入力から西暦と月を入力し、そのカレンダーを表示するクラス.
 * @author 高妻智一
 */
public class Calendar2 {
	
	/**
	 *	月初めの曜日、月の最終日をCalendarクラスから取得する.
	 * 取得した値から該当のカレンダーを表示する.
 	 * @author 高妻智一
 	 */
	public static void main(String[] args) {

		int year = 0;
		int month = 0;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
			//西暦の入力
			System.out.println("西暦を入力して下さい。");
			String line1 = reader.readLine();
			year = Integer.parseInt(line1); 
			
			//月の入力
			System.out.println("月を入力して下さい。");
			String line2 = reader.readLine();
			month = Integer.parseInt(line2) -1;

			if (year < 0 || month < -1) {
				System.out.println("負の値が入力されました。");
				System.out.println("0以上の整数を入力して下さい。");
				System.exit(-1);
			}

		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("入力が正しくありません。");
			System.out.println("0以上の整数を入力して下さい。");
		}	

		Calendar cal = Calendar.getInstance();
		int startDayOfWeek; //月初めの曜日を入れる変数.
		int lastDay;		//月の最終日を入れる変数.
		
		//月初めの曜日を取得
		cal.set(year, month, 1);
	    startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    	
    	//月の最終日を取得
    	cal.set(year, month + 1, 0);
    	lastDay = cal.get(Calendar.DATE);
		
		//引数に渡した情報おもとにカレンダーを表示する.
		printCal(startDayOfWeek, lastDay);
	}

	/**
	 * 引数で受け取ったyearとmonthに該当するカレンダーを表示する.
	 * 取得した値から該当のカレンダーを表示する.
 	 * @author 高妻智一
 	 * @method printCal
 	 */
	private static void printCal(int startDayOfWeek, int lastDay) {
		System.out.println(" 日 月 火 水 木 金 土");
		for (int i = 1; i < startDayOfWeek; i++) {
			System.out.print("   ");
		}
		
		for (int i = 1; i <= lastDay; i++) {
			if ((i + startDayOfWeek-1) % 7 == 1) {
				System.out.println();
			}
				System.out.printf("%3d", i);
		}
	}
}
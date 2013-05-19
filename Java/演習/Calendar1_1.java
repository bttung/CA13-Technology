import java.util.Calendar;

/**カレンダーを表示するクラス.
 * @author 高妻智一
 */
public class Calendar1{
	
	/**
 	 * 月の最終日を入れる変数.
 	 */
	private static int lastDay;
	
	/**
 	　* 月初めの曜日を入れる変数.
 	　*/
	private static int startWeek;
	
	/**月初めの曜日、月の最終日をCalendarクラスから取得する.
	 * 取得した値から該当のカレンダーを表示する.
 	 * @author 高妻智一
 	 * @method printCal
 	 */
	public static void main(String[] args) {
				
		int year; 
		int month;

		Calendar cal = Calendar.getInstance();
		
		//現在の西暦と月を取得
		year = cal.get(Calendar.YEAR);
    	month = cal.get(Calendar.MONTH);

		//月初めの曜日を取得
		cal.set(year, month, 1);
    	startWeek = cal.get(Calendar.DAY_OF_WEEK);

    	//月の最終日を取得
    	cal.set(year, month + 1, 0);
    	lastDay = cal.get(Calendar.DATE);
		
		//カレンダーの表示
		System.out.println("2013年4月のカレンダーを示します。");
		System.out.println("2013年4月");
		System.out.println(" 日 月 火 水 目 金 土");
		printCal(year, month);
	}

	private static void printCal(int year, int month) {
		for (int i = 1; i < startWeek; i++) {
			System.out.print("   ");
		}
		
		for (int i = 1; i <= lastDay; i++) {
			if ((i + startWeek-1) % 7 == 1) {
				System.out.println();
			}
				System.out.printf("%3d", i);
		}
	}
}



import java.util.Calendar;

/**
 * 2013年4月のカレンダーを表示するクラス.
 * @author 高妻智一
 */
public class Calendar1 {
	
	/**
	 * 月初めの曜日、月の最終日をCalendarクラスから取得する.
	 * 取得した値から該当のカレンダーを表示する.
 	 * @author 高妻智一
 	 * @method printCal
 	 */
	public static void main(String[] args) {
		
		//西暦2013年4月を代入	
		int year = 2013; 
		int month = 3;

		int startDayOfWeek; //月初めの曜日を入れる変数.
		int lastDay;		//月の最終日を入れる変数.

		Calendar cal = Calendar.getInstance();

		//月初めの曜日を取得
		cal.set(year, month, 1);
    	startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

    	//月の最終日を取得
    	cal.set(year, month + 1, 0);
    	lastDay = cal.get(Calendar.DATE);
		
		//カレンダーの表示
		System.out.println("2013年4月のカレンダーを示します。");
		System.out.println("2013年4月");
		System.out.println(" 日 月 火 水 目 金 土");
		printCal(startDayOfWeek, lastDay);
	}

	/**
	 * 引数で受け取ったyearとmonthに該当するカレンダーを表示する.
	 * 取得した値から該当のカレンダーを表示する.
 	 * @author 高妻智一
 	 * @method printCal
 	 */
	private static void printCal(int startDayOfWeek, int lastDay) {
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
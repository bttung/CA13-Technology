import java.util.Calendar;

/**
 * 2013�N4���̃J�����_�[��\������N���X.
 * @author ���Ȓq��
 */
public class Calendar1 {
	
	/**
	 * �����߂̗j���A���̍ŏI����Calendar�N���X����擾����.
	 * �擾�����l����Y���̃J�����_�[��\������.
 	 * @author ���Ȓq��
 	 * @method printCal
 	 */
	public static void main(String[] args) {
		
		//����2013�N4������	
		int year = 2013; 
		int month = 3;

		int startDayOfWeek; //�����߂̗j��������ϐ�.
		int lastDay;		//���̍ŏI��������ϐ�.

		Calendar cal = Calendar.getInstance();

		//�����߂̗j�����擾
		cal.set(year, month, 1);
    	startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

    	//���̍ŏI�����擾
    	cal.set(year, month + 1, 0);
    	lastDay = cal.get(Calendar.DATE);
		
		//�J�����_�[�̕\��
		System.out.println("2013�N4���̃J�����_�[�������܂��B");
		System.out.println("2013�N4��");
		System.out.println(" �� �� �� �� �� �� �y");
		printCal(startDayOfWeek, lastDay);
	}

	/**
	 * �����Ŏ󂯎����year��month�ɊY������J�����_�[��\������.
	 * �擾�����l����Y���̃J�����_�[��\������.
 	 * @author ���Ȓq��
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
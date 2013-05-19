import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * �������������܂�܂ł���񂯂���s���v���O����.
 * @author ���Ȓq��
 */
public class Janken2 {
	
	private static boolean isEnd = false; //����񂯂�̏������������܂�����false�������ďI������.
	
	/**
	 * ���͂��󂯎������player�ɑ���B�����_����������1�`3�̐��l��computer�ɑ��.
	 * player��computer�ɑ�������l�������ɏ��s���v�Z���A���s��\������.
	 * @author ���Ȓq��
	 */
	public static void main(String[] args) {
		
		System.out.println("����񂯂�����܂��傤�I");
		System.out.println("�P�F�O�[�@�Q�F�`���L�@�R�G�p�[");
		System.out.println("����[�񂯁[��E�E");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int result; //���������̌��ʂ�������
		int player;
		int computer;
		boolean isFirstFlag = true; //��ԍŏ��̂���񂯂񂩂ǂ������肷��

		while (!isEnd) {
			try {	
				System.out.println("�o��������->");
				String line = reader.readLine();
				player = Integer.parseInt(line); //���͂���������player�ɑ������B
				computer = (int)(Math.random() * 3) + 1; //�����_����������������computer�ɑ������

				if (player < 0 || 4 < player) {
					System.out.println("1,2,3�̐�������͂��Ă��������B");
					System.exit(-1);
				}
				judgeKakegoe(isFirstFlag); //�|�����̔���
				showHand(player, computer); //�I�񂾎��\������
				printResult(player - computer); //����������\������
			} catch (IOException e) {
				System.out.println(e);
			} catch (NumberFormatException e) {
				System.out.println("�����ȊO�����͂���Ă��܂��B");
				System.out.println("1,2,3�̐�������͂��ĉ������B");
			}
			
		}
	}

	/**
	 * 1��ڂ̂���񂯂�Ȃ̂��������Ōp������̂����肷��.
	 * @author ���Ȓq��
	 */
	private static void judgeKakegoe(boolean isFirstFlag) {
		if (isFirstFlag) {
			System.out.println("�ۂ�I");
			isFirstFlag = false;
		} else {
			System.out.println("������I");
		}
	}

	/**
	 * player��computer�̏o�������\������.
	 * @author ���Ȓq��
	 * @param player �����̏o������
	 * @param computer CPU�̏o������
	 */
	private static void showHand(int player, int computer) {
		String HAND[] = {"�O�[", "�`���L", "�p�["};
		System.out.println("���Ȃ��̎��" + HAND[player - 1] +"�A����̎��" + HAND[computer - 1] + "�ł��B");
	}
	
	/**
	 * ���������𔻒肵�ĕ\������.
	 * @author ���Ȓq��
	 */
	private static void printResult(int result) {
		if (result == 2 || result == -1) {
			System.out.println("���Ȃ��̏����ł��B");
			isEnd = true;
		} else if(result == 0) {
			System.out.println("��-����-�ŁE�E�E");
		} else if(result == 1 || result == -2) {
			System.out.println("���Ȃ��̕����ł��B");
			isEnd = true;
		}
	}
}



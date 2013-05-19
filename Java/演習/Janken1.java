import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * ����񂯂����񂾂��s���v���O����.
 * @author ���Ȓq��
 */
public class Janken1 {

	/**
	 * ���͂��󂯎������player�ɑ��.�����_����������1�`3�̐��l��computer�ɑ��.
	 * player��computer�ɑ�������l�������ɏ��s���v�Z���A���s��\������.
	 * @author ���Ȓq��
	 */
	public static void main(String[] args) {
		
		System.out.println("����񂯂�����܂��傤�I");
		System.out.println("�P�F�O�[�@�Q�F�`���L�@�R�G�p�[");
		System.out.println("����[�񂯁[��E�E");
		System.out.println("1,2,3�̐�������͂��Ă��������B");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			//���͂���������player�ɑ������B
			String line = reader.readLine();
			int player = Integer.parseInt(line); 

			 //�����_����������������computer�ɑ������B
			int computer = (int)(Math.random() * 3) + 1;

			if(player < 1 && 3 < player) {
				System.out.println("1,2,3�̐�������͂��Ă��������B");
				System.exit(-1);
			}

			//���������̌��ʂ�������
			int result = judgeCalc(player, computer); 

			//����������\������
			judge(result); 
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("�����ȊO�����͂���Ă��܂��B");
		}
	}
	
	/**
	 * �����������v�Z����.�����̎� - ����̎���̒l��result�ɑ��.
	 * @author ���Ȓq��
	 * @param player �����̏o������
	 * @param computer CPU�̏o������
	 */
	private static int judgeCalc(int player, int computer) {
		return player - computer;
	}
	
	/**
	 * ���������𔻒肷��.
	 * @author ���Ȓq��
	 * @param result �����̏ꍇ��2, -1�@���������̏ꍇ0 �����̏ꍇ��1, -1	 
	 */
	private static void judge(int result) {
			if(result == 2 || result == -1) {
				System.out.println("���Ȃ��̏����ł��B");
			} else if(result == 0) {
				System.out.println("�������ł��B");
			} else if(result == 1 || result == -2) {
				System.out.println("���Ȃ��̕����ł��B");
			}
		}
}



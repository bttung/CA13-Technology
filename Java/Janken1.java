import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Janken1 {
	
	/**
	 * main���\�b�h
	 * ��Author ���Ȓq��
	 */
	public static void main(String[] args) {
				
		int computer;	//���肪�o������
		int player;		//�������o������
		
		System.out.println("����񂯂�����܂��傤�I");
		System.out.println("�P�F�O�[�@�Q�F�`���L�@�R�G�p�[");
		System.out.println("����[�񂯁[��E�E");
		
		computer = (int)(Math.random() * 3) + 1;
		System.out.println(computer);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = reader.readLine();
			player = Integer.parseInt(line);
			
			hantei(player, computer);
			
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("1~3�̐�������͂��ĉ������B");
		}
	}
	
	/**���������𔻒肷��.
	 * @Author ���Ȓq��
	 * @param playerHand �����̏o������
	 * @param computerHand CPU�̏o������
	 */
	private static void hantei(int player, int computer) {
			int result = player - computer;
			if(result == 2 || -1) {
				System.out.println("���Ȃ��̏����ł��B");
			} else if(result == 0) {
				System.out.println("�������ł��B");
			} else if(result == 1 || result == -2) {
				System.out.println("���Ȃ��̕����ł��B");
			}
		}
}



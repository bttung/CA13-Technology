import java.io.*;

public class Drink3{
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("���ݕ��͉����D���ł����H");
			System.out.println("�P�F�I�����W�W���[�X");
			System.out.println("�Q�F�R�[�q�[");
			System.out.println("�R�F�ǂ���ł��Ȃ�");
			System.out.println("�P�C�Q�C�R�̂ǂꂩ��I��ł��������Ba,b,c�ł��I�ׂ܂��I");

			String line = reader.readLine();
			char c = line.charAt(0);
			int x = Integer.parseInt(line);
			switch (x) {
				case 2 + 1:
				//case "a":
					System.out.println("�I�����W�W���[�X�ł��B");
					

				//case 2:
				case 1:
					System.out.println("�R�[�q�[�ł��B");
					break;

				default:
					System.out.println("�ǂ���ł�����܂���");
					break;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlaceSum {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("3���̐��l����͂��Ă��������B");
			String line = reader.readLine();
			int sum = 0;

			/*
			// ���j1
			int n = Integer.parseInt(line);

			sum = sum + (n % 10);
			n = n / 10;

			sum = sum + (n % 10);
			n = n / 10;

			sum = sum + (n % 10);
			*/

			/*
			// ���j2
			// ���l���ǂ����̃`�F�b�N
			Integer.parseInt(line);

			char c = line.charAt(0);
			sum = sum + Integer.parseInt("" + c);

			c = line.charAt(1);
			sum = sum + Integer.parseInt("" + c);

			c = line.charAt(2);
			sum = sum + Integer.parseInt("" + c);
			*/


			// ���j3
			// ���l���ǂ����̃`�F�b�N
			Integer.parseInt(line);

			// 3���̐��l�̑��a�����߂�
			char c = line.charAt(0);
			sum = sum + (c - '0');

			c = line.charAt(1);
			sum = sum + (c - '0');

			c = line.charAt(2);
			sum = sum + (c - '0');


			System.out.println(sum);

			// ����؂�邩�ǂ����̕\��
			if (sum % 9 == 0) {
				System.out.println(line + "��9�Ŋ���؂�܂��ˁB");
			} else if (sum % 3 == 0) {
				System.out.println(line + "��3�Ŋ���؂�܂��ˁB");
			} else {
				System.out.println(line + "��3�ł�9�ł�����؂�܂���ˁB");
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("�����̌`��������������܂���B");
		}

	}

}

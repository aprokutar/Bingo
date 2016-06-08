package data;

import java.io.Serializable;

/**
 * ���� �������� ������ ������ ������ �ִ� Ŭ����
 * 
 * @author kita
 *
 */
public class GameInfo implements Serializable {
	private String keyword; // ������ �����ϰų�, ������ ������ ���� �ܾ�
	// private String bingoKeywords[][] = new String[5][5]; // �Է��� 25���� ���� �ܾ� ����
	private String bingoKeywords[][] = { 
			{ "2", "3", "4", "6", "7" }, 
			{ "10", "5", "30", "11", "12" },
			{ "58", "57", "56", "55", "54" }, 
			{ "111", "112", "113", "114", "115" }, 
			{ "21", "22", "23", "24", "25" } };
	// private String bingoKeywords[][] = new String[5][5];
	private int bingoResult[][] = new int[5][5]; // ���� ��Ȳ(���)�� ��� �迭, ���� �����ϰų�
													// ���¹��� ������ ���� �ܾ�� ��ġ�Ǵ� ��ġ��
													// ���� 1�� �ʱ�ȭ �Ѵ�.
	private int x, y; // ������ ������ ���� �ܾ ���� �Է��� ���� �ܾ�� ��ġ�ϴ� ���� �߰ߵ� ��� �ش� �ܾ���
						// �迭(5X5)���� ��ġ ��
	private User user; // �ڱ��ڽſ� ���� ������ ���� User

	public String[][] getBingoKeyword() {
		return bingoKeywords;
	}

	public void setBingoKeywords(String[][] bingoKeyword) {
		this.bingoKeywords = bingoKeyword;
	}

	/**
	 * ���ڷ� ���޵� ���� �ܾ ������ ���� ����� ��� �迭�� 1�� �ʱ�ȭ �Ѵ�. ����ڰ� �Է��� ���� �ܾ�� ��ġ�ϴ� �ܾ ������
	 * bingoResult �迭�� �ش� ��ġ���� 1�� �ʱ�ȭ �ϰ�, �ش� �迭�� ��ġ ������ x,y ������ �ʱ�ȭ �Ѵ�. �Ű�������
	 * ���޵� �ܾ�� ��ġ�ϴ� �ܾ ������ true��, �׷��� ������ false�� ��ȯ�Ѵ�.
	 */
	public boolean markBingoResult(String keyword) {
		boolean result = false;
		for (int i = 0; i < 5; i++) {//������
			for (int j = 0; j < 5; j++) {//������
				if (bingoKeywords[i][j].equals(keyword)) {
					bingoResult[i][j] = 1;
					result = true;
				}
			}//������ ��
		}//������ ��
		return result;
	}

	/**
	 * ���� ����� ��� �迭�κ��� ���� ����(����,����,�밢�� �����Ͽ� 5���� ����ܾ ���� ����) ����Ͽ� ��ȯ�Ѵ�.
	 */
	public int checkBingo() {
		// count = ��� ��, count2 = ��翭, count3 = �밢��\, count4 = �밢��/
		int bingoNum = 0, count = 0, count2 = 0, count3 = 0, count4 = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (this.bingoResult[i][j] == 1)
					count++;
				if (this.bingoResult[j][i] == 1)
					count2++;
			} // inner for
			if (this.bingoResult[i][i] == 1)
				count3++;
			if (this.bingoResult[4 - i][i] == 1)
				count4++;
			if (count == 5)
				bingoNum++;
			if (count2 == 5)
				bingoNum++;
			if (count3 == 5)
				bingoNum++;
			if (count4 == 5)
				bingoNum++;
			count = 0;
			count2 = 0;
		} // outer for
		return bingoNum;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getKeyword() {
		return keyword;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int[][] getBingoResult() {
		return bingoResult;
	}

}

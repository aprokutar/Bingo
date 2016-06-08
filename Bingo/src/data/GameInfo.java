package data;

import java.io.Serializable;

/**
 * 현재 진행중인 게임의 정보를 가지고 있는 클래스
 * 
 * @author kita
 *
 */
public class GameInfo implements Serializable {
	private String keyword; // 본인이 선택하거나, 상대방이 선택한 빙고 단어
	// private String bingoKeywords[][] = new String[5][5]; // 입력한 25개의 빙고 단어 저장
	private String bingoKeywords[][] = { 
			{ "2", "3", "4", "6", "7" }, 
			{ "10", "5", "30", "11", "12" },
			{ "58", "57", "56", "55", "54" }, 
			{ "111", "112", "113", "114", "115" }, 
			{ "21", "22", "23", "24", "25" } };
	// private String bingoKeywords[][] = new String[5][5];
	private int bingoResult[][] = new int[5][5]; // 빙고 현황(결과)를 담는 배열, 내가 선택하거나
													// 상태방이 선택한 빙고 단어와 일치되는 위치의
													// 값을 1로 초기화 한다.
	private int x, y; // 상대방이 선택한 빙고 단어가 내가 입력한 빙고 단어와 일치하는 것이 발견될 경우 해당 단어의
						// 배열(5X5)상의 위치 값
	private User user; // 자기자신에 대한 정보를 갖는 User

	public String[][] getBingoKeyword() {
		return bingoKeywords;
	}

	public void setBingoKeywords(String[][] bingoKeyword) {
		this.bingoKeywords = bingoKeyword;
	}

	/**
	 * 인자로 전달된 빙고 단어를 가지고 빙고 결과를 담는 배열을 1로 초기화 한다. 사용자가 입력한 빙고 단어와 일치하는 단어가 있으면
	 * bingoResult 배열의 해당 위치값을 1로 초기화 하고, 해당 배열의 위치 값으로 x,y 변수를 초기화 한다. 매개변수로
	 * 전달된 단어와 일치하는 단어가 있으면 true를, 그렇지 않으면 false를 반환한다.
	 */
	public boolean markBingoResult(String keyword) {
		boolean result = false;
		for (int i = 0; i < 5; i++) {//밖포문
			for (int j = 0; j < 5; j++) {//안포문
				if (bingoKeywords[i][j].equals(keyword)) {
					bingoResult[i][j] = 1;
					result = true;
				}
			}//안포문 끝
		}//밖포문 끝
		return result;
	}

	/**
	 * 빙고 결과를 담는 배열로부터 빙고 개수(가로,세로,대각선 연속하여 5개의 빙고단어를 맞춘 개수) 계산하여 반환한다.
	 */
	public int checkBingo() {
		// count = 모든 행, count2 = 모든열, count3 = 대각선\, count4 = 대각선/
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

package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GameRoom implements Serializable {
	private String roomID; // �� ID, ����ID+�ý��۽ð� �������� ����
	private String title; // ������
	private String theme; // ��������
	private int maxUserNum; // �ִ� �÷��̾� ��
	private int nowUserNum; // ���� �÷��̾� ��
	private HashMap<String, User> userList = new HashMap<>();   // �濡 �������� �÷��̾� ���
	private ArrayList<String> turnUserList = new ArrayList<>(); // �濡 ������ �÷��̾�
																// ������� ID�� ����,
																// ���� ������ ������
																// ������ ���ϱ� ����
																// ���(������ ������
																// ������ ������ ������
																// ��)
	private User turnUser; // ���� ��ư�� ���� ���ʰ� �� User
	private int pointer = 0; // �濡 ������ �÷��̾��� ���� ���� ������ �� User��ü�� ����ų ���ؽ��� ����� ��
								// ���� ��
	private HashMap<String, Integer> bingoNumList = new HashMap<>(); // userID :
																		// ���� ����

	public GameRoom(String roomId, String title, String theme, int maxUserNum) {
		this.roomID = roomId;
		this.title = title;
		this.theme = theme;
		this.maxUserNum = maxUserNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getMaxUserNum() {
		return maxUserNum;
	}

	public void setMaxUserNum(int maxUserNum) {
		this.maxUserNum = maxUserNum;
	}

	public int getNowUserNum() {
		return nowUserNum;
	}

	public void setNowUserNum(int nowUserNum) {
		this.nowUserNum = nowUserNum;
	}

	public HashMap<String, User> getUserList() {
		return userList;
	}

	public void addUser(User user) {
		userList.put(user.getId(), user);
		turnUserList.add(user.getId());
	}

	public void setUserList(HashMap<String, User> userList) {
		this.userList = userList;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public User getTurnUser() {
		return turnUser;
	}

	public void setTurnUser() {
		int index = pointer % nowUserNum;
		//0 , 1, 2, 0, 1, 2, 0, 1, 2
		pointer++;
		String userID = turnUserList.get(index);
		turnUser = userList.get(userID);
		System.out.println(index + " : " + userID);
	}

	public ArrayList<String> getTurnUserList() {
		return turnUserList;
	}

	public void updateBingoNum(String id, int num) {
		bingoNumList.put(id, num);
	}

	public HashMap<String, Integer> getBingoNumList() {
		return bingoNumList;
	}

	@Override
	public String toString() {
		return "GameRoom [roomID=" + roomID + ", title=" + title + ", theme=" + theme + ", maxUserNum=" + maxUserNum
				+ ", nowUserNum=" + nowUserNum + ", userList=" + userList + "]";
	}

}

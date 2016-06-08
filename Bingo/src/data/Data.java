package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Data implements Serializable {
	private String message; // ä�� ��ȭ����
	private int command; // ��û ��� ���
	private GameRoom gameRoom; // ���ӹ� ����
	private GameInfo gameInfo; // ���� ����
	private User user; // Data��ü�� �߼��ϴ� ����� ����
	private ArrayList<User> userList; // ������ ���ӵǾ��ִ� ����� ���
	private HashMap<String, GameRoom> roomList; // �Լ��� �� ���

	public static final int LOGIN = 10; // �α���
	public static final int MAKE_ROOM = 20; // ���ӹ� ����
	public static final int JOIN = 30; // ���ӹ� ����
	public static final int CHAT_MESSAGE = 40; // ���ӹ� �� ä��
	public static final int SEND_BINGO_DATA = 50; // ������ ���� �ܾ� ����
	public static final int SEND_WINNING_RESULT = 60; // 5���� ���� �ϼ����� �� �¸���� ����
	public static final int GAME_READY = 70; // 25�� ����ܾ� �Է� �Ϸ� �� �غ�
	public static final int GAME_START = 80; // �濡 ������ ��� ������ �غ���°� �Ǿ� ���ӽ����� �˸�
	public static final int EXIT = -10; // ���α׷� ����

	public Data(int command) {
		this.command = command;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	public GameRoom getGameRoom() {
		return gameRoom;
	}

	public void setGameRoom(GameRoom gameRoom) {
		this.gameRoom = gameRoom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public HashMap<String, GameRoom> getRoomList() {
		return roomList;
	}

	public void setRoomList(HashMap<String, GameRoom> roomList) {
		this.roomList = roomList;
	}

	public GameInfo getGameInfo() {
		return gameInfo;
	}

	public void setGameInfo(GameInfo gameInfo) {
		this.gameInfo = gameInfo;
	}

}

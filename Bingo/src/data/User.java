package data;

import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
	private String id; // ���̵�
	private int privilege; // ����
	private GameRoom room; // �÷��̾ �������� �� ����
	private transient ObjectOutputStream oos; // ������ ���� ���� ObjectOutputStream
												// ��ü, �������� �ش� �������� �޼���(Data��ü)��
												// ���� �� ���
												//transient = ����ȭ ���� Ű����
	private String state = "�غ���"; // ���ӹ濡���� ���� ��, �غ��� or �غ�Ϸ��� ���°��� ����

	public static final int HOST_PRIVILEGE = 10;
	public static final int NORMAL_PRIVILEGE = 20;
	public static final String READY = "�غ���";
	public static final String DONE = "�غ�Ϸ�";

	public User(String id, int privilege) {
		this.id = id;
		this.privilege = privilege;
	}

	public int getPrivilege() {
		return privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public GameRoom getRoom() {
		return room;
	}

	public void setRoom(GameRoom room) {
		this.room = room;
	}

	public String getId() {
		return id;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", privilege=" + privilege + ", room=" + room + "]";
	}

}

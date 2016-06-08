package client;

import java.util.ArrayList;
import java.util.HashMap;

import data.Data;
import data.GameRoom;
import data.User;

public class GameLobbyUI_TEST {
	public static void main(String[] args) {
		GameLobbyUI glui = GameLobbyUI.getInstance();
		Data d = new Data(10);
		GameRoom gr = new GameRoom("K01","배틀!", "먹는거",5);
		gr.setNowUserNum(4);
		GameRoom gr1 = new GameRoom("K02","나가면지상렬", "지상렬",6);
		gr1.setNowUserNum(1);
		GameRoom gr2 = new GameRoom("K03","이명박디펜스", "디펜스",7);
		gr2.setNowUserNum(2);
		GameRoom gr3 = new GameRoom("K04","박지호블러드", "음식",8);
		gr3.setNowUserNum(5);
		HashMap<String, GameRoom> roomList = new HashMap<>();
		d.setRoomList(roomList);
		d.getRoomList().put("배틀!", gr);
		d.getRoomList().put("나가면지상렬",gr1);
		d.getRoomList().put("이명박디펜스",gr2);
		d.getRoomList().put("박지호블러드",gr3);
		
		glui.setRoomList(d.getRoomList());
		glui.setCurrUserCnt(30);
		
		ArrayList<User> uList = new ArrayList<>();
		User u1 = new User("01", 1);
		User u2 = new User("02", 2);
		User u3 = new User("03", 3);
		uList.add(u1);
		uList.add(u2);
		uList.add(u3);
		d.setUserList(uList);
		glui.setUserList(d.getUserList());
	}
}

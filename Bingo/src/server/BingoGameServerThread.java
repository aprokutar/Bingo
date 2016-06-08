package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import data.Data;
import data.GameRoom;
import data.User;

public class BingoGameServerThread implements Runnable {
	
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private boolean exit;
	private BingoGameServer parent;
	//서버에 접속된 클라이언트, 각 클라이언트의 ObjectOutputStream이 저정되어 있음
	static ArrayList<User> connectedUserList = new ArrayList<>(); 
	//gameRoom 목록 (roomID, gameroom)
	static HashMap<String, GameRoom> gameRoomList = new HashMap<>();
	private Data data;
	
	public BingoGameServerThread(BingoGameServer parent, Socket client) {
		this.parent = parent;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(!exit){
			try {
				data = (Data)ois.readObject();
				switch(data.getCommand()){
					case Data.LOGIN: {
						data.getUser().setOos(oos);
						connectedUserList.add(data.getUser());
						data.setRoomList(gameRoomList);
						data.setUserList(connectedUserList);
						broadCasting();
						parent.updateConnectionList(this.data.getUserList());
						parent.printEventLog(data.getUser().getId()+" 접속!");
						break;						
					}
						
					case Data.MAKE_ROOM: {
						gameRoomList.put(data.getGameRoom().getRoomID(), data.getGameRoom());
						data.setRoomList(gameRoomList);
						parent.printEventLog(data.getUser().getId()+"가"+data.getGameRoom().getRoomID()+"생성!");
						broadCasting();
						break;
					}
						
					case Data.JOIN: {
						gameRoomList.replace(data.getGameRoom().getRoomID(), data.getGameRoom());
						broadCasting();
						break;
					}
						
					case Data.CHAT_MESSAGE:
					case Data.SEND_WINNING_RESULT:
					case Data.GAME_READY:
					case Data.GAME_START:
					case Data.SEND_BINGO_DATA: {
						sendDataRoommate(data.getGameRoom().getRoomID());
						break;
					}
						
					case Data.EXIT: {
							for(User u :connectedUserList){
								if(u.getId().equals(data.getUser().getId())){
									connectedUserList.remove(u);
									data.setUserList(connectedUserList);
								}
							}
							broadCasting();
							break;
					}
				}//switch
				
			} catch (IOException e) {
				exit = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}//while
	}//run
	
	/**
	 * 같은 방에 있는 유저에게 Data객체 전송
	 * */
	public void sendDataRoommate(String roomID){
		GameRoom gRoom = this.gameRoomList.get(roomID);
		HashMap<String,User> usersMap = gRoom.getUserList();
		for(Entry<String, User> entry : usersMap.entrySet()) {
		    try {
				entry.getValue().getOos().writeObject(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 모든 유저에게 Data객체 전송
	 * */
	public void broadCasting(){
		for(User u : connectedUserList){
			try {
				u.getOos().reset();
				u.getOos().writeObject(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}

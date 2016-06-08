package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketException;

import data.Data;

public class BingoGameListnerThread implements Runnable {
	private ObjectInputStream ois;
	private boolean exit = false;

	public BingoGameListnerThread(ObjectInputStream ois) {
		this.ois = ois;
	}

	@Override
	public void run() {
		while (!exit) {
			try {
				Data data = (Data) ois.readObject();
				switch (data.getCommand()) {
				case Data.LOGIN: {
					GameLobbyUI.setRoomList(data.getRoomList());
					GameLobbyUI.setUserList(data.getUserList());
					GameLobbyUI.setData(data);
					break;
				}
				case Data.MAKE_ROOM: {
					GameLobbyUI.setRoomList(data.getRoomList());
					GameLobbyUI.setData(data);
					break;
				}
				case Data.JOIN: {
					break;
				}
				case Data.CHAT_MESSAGE: {
					break;
				}
				case Data.SEND_WINNING_RESULT: {
					break;
				}
				case Data.GAME_READY: {
					break;
				}
				case Data.GAME_START: {
					break;
				}
				case Data.SEND_BINGO_DATA: {
					break;
				}
				case Data.EXIT: {
					exit = true;
					break;
				}
				default: {
					break;
				}
				}
			} catch (SocketException e) {
				
				System.exit(0);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}

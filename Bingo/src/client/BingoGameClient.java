package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import data.Data;
import data.User;

public class BingoGameClient {
	Socket sock;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public BingoGameClient(User user) {
		try {
			sock = new Socket("localhost", 7777);
			ois = new ObjectInputStream(sock.getInputStream());
			oos = new ObjectOutputStream(sock.getOutputStream());
			
			Data data = new Data(Data.LOGIN);
			data.setUser(user);
			BingoGameListnerThread listener = new BingoGameListnerThread(ois);
			GameLobbyUI.setOos(oos);
			Thread t = new Thread(listener);
			t.start();
			oos.writeObject(data);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

package server;
import java.util.ArrayList;

import data.*;
public class BingoGameServer_Test {
	public static void main(String[] args) {
		BingoGameServer bgs = new BingoGameServer();
		bgs.printEventLog("����ȣ¯¯��");
		ArrayList<User> users = new ArrayList<User>();
		User jake = new User("02", 3);
		users.add(jake);
		bgs.updateConnectionList(users);
		
	}
}

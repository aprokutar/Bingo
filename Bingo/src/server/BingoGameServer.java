package server;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

import data.User;

public class BingoGameServer implements Runnable{

	private JFrame frame;
	private JPanel panel_west;
	private JPanel panel_eventLogView;
	private JLabel lbl_logView;
	private JTextArea textArea_eventLog;
	private JScrollPane scrollPane_eventLog;
	private JPanel panel_center;
	private JPanel panel_ConnectionList;
	private JLabel lbl_connList;
	private JList list_connList;
	private JScrollPane scrollPane_connList;
	private JPanel panel_south;
	private JButton btn_serverQuit;

	/**
	 * Create the application.
	 */
	public BingoGameServer() {
		initialize();
		printEventLog("==========System Start!==========");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BingoGameServer window = new BingoGameServer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 로그를 출력하는 프로그램
	 * @param message
	 */
	public void printEventLog(String message) {
		String logMessage = String.format("[%tY-%<tm-%<td %<tH:%<tM:%<tS] %s%n", new Date(), message);
		textArea_eventLog.append(logMessage);
	}
	
	/**
	 * 서버에 접속된 사용자 목록을 보여준다
	 * @param userList
	 */
	public void updateConnectionList(ArrayList<User> userList){

		Object[] listData = userList.toArray();
		list_connList.setListData(listData);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Global frame part
		frame = new JFrame();
		frame.setBounds(100, 100, 733, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//westpane part
		panel_west = new JPanel();
		frame.getContentPane().add(panel_west, BorderLayout.WEST);
		
		panel_eventLogView = new JPanel();
		panel_west.add(panel_eventLogView);
		panel_eventLogView.setLayout(new BoxLayout(panel_eventLogView, BoxLayout.Y_AXIS));

		lbl_logView = new JLabel("\u25A0 Bingo Game Server Event Log View");
		panel_eventLogView.add(lbl_logView);
		textArea_eventLog = new JTextArea(16, 20);
		textArea_eventLog.setTabSize(15);
		textArea_eventLog.setForeground(Color.GREEN);
		textArea_eventLog.setBackground(Color.BLACK);
		scrollPane_eventLog = new JScrollPane(textArea_eventLog);
		scrollPane_eventLog.setPreferredSize(new Dimension(500, 326));
		panel_eventLogView.add(scrollPane_eventLog);

		//centerpane part
		panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);

		panel_ConnectionList = new JPanel();
		panel_center.add(panel_ConnectionList);
		panel_ConnectionList.setLayout(new BoxLayout(panel_ConnectionList, BoxLayout.Y_AXIS));

		lbl_connList = new JLabel("\u25A0ConnectionList");
		lbl_connList.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_connList.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_ConnectionList.add(lbl_connList);

		list_connList = new JList();
		list_connList.setVisibleRowCount(20);
		scrollPane_connList = new JScrollPane(list_connList);
		panel_ConnectionList.add(scrollPane_connList);

		//southpane part
		panel_south = new JPanel();
		frame.getContentPane().add(panel_south, BorderLayout.SOUTH);

		btn_serverQuit = new JButton("\uC11C\uBC84 \uC911\uC9C0");
		btn_serverQuit.setPreferredSize(new Dimension(frame.getWidth(), 30));
		panel_south.add(btn_serverQuit);
		
		frame.setVisible(true);
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		ServerSocket serversoc = null;
		try {
			serversoc = new ServerSocket(7777);
		while(true){
			Socket soc = serversoc.accept();
			BingoGameServerThread bgst = new BingoGameServerThread(this, soc);
			Thread t = new Thread(bgst);
			t.start();
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

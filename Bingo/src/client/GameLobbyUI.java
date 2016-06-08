package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.Data;
import data.GameRoom;
import data.User;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

//TODO SINGLETON 패턴 적용시켜야 함
public class GameLobbyUI {

	private static JFrame frame;
	private static JTable table;
	private static JPanel pane_top;
	private static JLabel lbl_Title;
	private static JPanel pane_west;
	private static JScrollPane scrollPane_roomList;
	private static JPanel pane_center;
	private static JPanel panel_label;
	private static JLabel lbl_connListTitle;
	private static JPanel pane_userList;
	private static JScrollPane scrollPane_1;
	private static JList list;
	private static JPanel panel_connCnt;
	private static JLabel lbl_connCnt;
	private static JPanel pane_buttons;
	private static JButton btn_makeRoom;
	private static JButton btn_quit;
	private static GameLobbyUI GLUI = new GameLobbyUI();
	private static User user;
	private static Data data;
	private static ObjectOutputStream oos;
	private GameLobbyUI() {
		initialize();
	};

	public static GameLobbyUI getInstance() {
		return GLUI;
	}

	public static void setUserList(ArrayList<User> arrayList) {
		list.setListData(arrayList.toArray());
	}

	public static void setRoomList(HashMap<String, GameRoom> rooms) {
		Object[][] contents = new Object[rooms.size()][3];
		int rowsCnt = 0;

		for (Entry<String, GameRoom> r : rooms.entrySet()) {
			r.getKey();
			r.getValue();
			contents[rowsCnt][0] = r.getValue().getTitle();
			contents[rowsCnt][1] = r.getValue().getTheme();
			contents[rowsCnt][2] = r.getValue().getNowUserNum() + "/" + r.getValue().getMaxUserNum();
			rowsCnt++;
		}

		String[] titles = new String[] { "방제목", "빙고주제", "인원" };
		DefaultTableModel tableModel = new DefaultTableModel(contents, titles);
		table.setModel(tableModel);
		table.setColumnSelectionAllowed(false);
	}
	
	public static void setData(Data data2){
		data=data2;
	}
	
	public static Data getData(){
		Data data2 = data;
		return data2;
	}
	
	public static void setOos(ObjectOutputStream oos2){
		oos = oos2;
	}
	
	public static ObjectOutputStream getOos(){
		return oos;
	}

	public void setCurrUserCnt(int userCnt) {
		lbl_connCnt.setText("접속인원:" + userCnt + "명");
	}
	
	public static void disposeLobby(){
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uBE59\uACE0\uAC8C\uC784 \uB300\uAE30\uC2E4");
		frame.setBounds(100, 100, 762, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pane_top = new JPanel();
		frame.getContentPane().add(pane_top, BorderLayout.NORTH);
		pane_top.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lbl_Title = new JLabel("B   I   N   G   O");
		pane_top.add(lbl_Title);

		pane_west = new JPanel();
		frame.getContentPane().add(pane_west, BorderLayout.WEST);
		pane_west.setLayout(new BoxLayout(pane_west, BoxLayout.Y_AXIS));

		scrollPane_roomList = new JScrollPane();
		pane_west.add(scrollPane_roomList);

		table = new JTable();
		scrollPane_roomList.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null } }, new String[] { "방제목", "빙고주제", "인원" }));

		table.getColumnModel().getColumn(0).setPreferredWidth(167);
		table.getColumnModel().getColumn(1).setPreferredWidth(179);
		table.setFillsViewportHeight(true);
		(table.getTableHeader()).setReorderingAllowed(false);
		table.setCellSelectionEnabled(true);

		pane_center = new JPanel();
		frame.getContentPane().add(pane_center, BorderLayout.CENTER);
		pane_center.setLayout(new BoxLayout(pane_center, BoxLayout.Y_AXIS));

		panel_label = new JPanel();
		pane_center.add(panel_label);

		lbl_connListTitle = new JLabel("\uC811\uC18D\uC790 \uBAA9\uB85D");
		panel_label.add(lbl_connListTitle);

		pane_userList = new JPanel();
		pane_center.add(pane_userList);

		scrollPane_1 = new JScrollPane();
		pane_userList.add(scrollPane_1);

		list = new JList();
		scrollPane_1.setViewportView(list);

		panel_connCnt = new JPanel();
		pane_center.add(panel_connCnt);

		lbl_connCnt = new JLabel("\uC811\uC18D\uC778\uC6D0 00\uBA85");
		panel_connCnt.add(lbl_connCnt);

		pane_buttons = new JPanel();
		frame.getContentPane().add(pane_buttons, BorderLayout.SOUTH);

		btn_makeRoom = new JButton("New button");
		btn_makeRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MAKEROOMUI
				MakeRoomUI mrUI = new MakeRoomUI(GameLobbyUI.getData());
			}
		});
		btn_makeRoom.setText("방만들기");
		pane_buttons.add(btn_makeRoom);

		btn_quit = new JButton("New button");
		btn_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btn_quit.setText("종료하기");
		pane_buttons.add(btn_quit);
		frame.setVisible(true);
	}

}

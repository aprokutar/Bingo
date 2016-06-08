package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import data.Data;
import data.GameRoom;
import data.User;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MakeRoomUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private User user;
	private JComboBox comboBox;
	private Data data;

	public void initAll() {
		textField.setText("");
		textField_1.setText("");
		comboBox.setSelectedIndex(0);
	}

	/**
	 * Create the application.
	 */
	public MakeRoomUI(Data data) {
		this.data = data;
		initialize();
		frame.setVisible(true);
	}

	public void sendGameRoomData() {
		GameRoom gameRoom = new GameRoom(
				textField.getText() + String.format("[%tY-%<tm-%<td %<tH:%<tM:%<tS]", new Date()), textField.getText(),
				textField_1.getText(), comboBox.getSelectedIndex() + 1);
		// 여기서 데이터가 없다.
		gameRoom.addUser(data.getUser());
		data.getUser().setRoom(gameRoom);
		data.setCommand(Data.MAKE_ROOM);
		data.setGameRoom(gameRoom);
		try {
			GameLobbyUI.getOos().writeObject(data);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uBC29 \uB9CC\uB4E4\uAE30");
		frame.setBounds(100, 100, 215, 178);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		JPanel pane_Title = new JPanel();
		frame.getContentPane().add(pane_Title);

		JLabel lblNewLabel = new JLabel("\uBC29\uC81C\uBAA9");
		pane_Title.add(lblNewLabel);

		textField = new JTextField();
		pane_Title.add(textField);
		textField.setColumns(10);

		JPanel pane_Subj = new JPanel();
		frame.getContentPane().add(pane_Subj);

		JLabel lblNewLabel_1 = new JLabel("\uBE59\uACE0\uC8FC\uC81C");
		pane_Subj.add(lblNewLabel_1);

		textField_1 = new JTextField();
		pane_Subj.add(textField_1);
		textField_1.setColumns(10);

		JPanel pane_playerCnt = new JPanel();
		frame.getContentPane().add(pane_playerCnt);

		JLabel lblNewLabel_2 = new JLabel("\uCC38\uAC00\uC778\uC6D0");
		pane_playerCnt.add(lblNewLabel_2);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "\uD63C\uC790", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		pane_playerCnt.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("\uBA85");
		pane_playerCnt.add(lblNewLabel_3);

		JPanel pane_btn = new JPanel();
		frame.getContentPane().add(pane_btn);

		JButton btnNewButton = new JButton("\uB9CC\uB4E4\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Please fill all fields");
				}
				sendGameRoomData();
				frame.dispose();
				//로비 dispose
				GameRoomUI grUI = new GameRoomUI();
				
			}
		});
		pane_btn.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		pane_btn.add(btnNewButton_1);
	}

}

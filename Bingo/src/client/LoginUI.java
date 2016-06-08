package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import data.User;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI {

	private JFrame frame;
	private JTextField textF_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uB85C\uADF8\uC778");
		frame.setBounds(100, 100, 244, 125);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel pane_title = new JPanel();
		frame.getContentPane().add(pane_title);
		pane_title.setLayout(new BoxLayout(pane_title, BoxLayout.X_AXIS));
		
		JLabel lbl_title = new JLabel("BingoGame Login");
		lbl_title.setFont(new Font("±¼¸²", Font.BOLD, 20));
		pane_title.add(lbl_title);
		
		JPanel pane_id = new JPanel();
		frame.getContentPane().add(pane_id);
		pane_id.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_id = new JLabel("\uC544\uC774\uB514");
		pane_id.add(lbl_id);
		
		textF_id = new JTextField();
		pane_id.add(textF_id);
		textF_id.setColumns(10);
		
		JPanel pane_btn = new JPanel();
		frame.getContentPane().add(pane_btn);
		
		JButton btn_enter = new JButton("\uC785\uC7A5");
		btn_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(textF_id.getText()==""){
				JOptionPane.showMessageDialog(frame, "Dont let the id part as nothing");
				return;
			}
			User user = new User(textF_id.getText(),0);
			BingoGameClient bgc = new BingoGameClient(user);
			frame.setVisible(false);
			}
		});
		pane_btn.add(btn_enter);
		
		JButton btn_close = new JButton("\uB2EB\uAE30");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		pane_btn.add(btn_close);
	}

}

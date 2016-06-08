package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class GameRoomUI {

	private JFrame frame;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameRoomUI window = new GameRoomUI();
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
	public GameRoomUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 584, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setMaximumSize(new Dimension(400, 32767));
		panel_3.add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane);
		scrollPane.setMaximumSize(new Dimension(400, 32767));
		
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(250, 400));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null}},new String[] {"\uCC28\uB840", "ID", "\uC0C1\uD0DC", "\uBE59\uACE0"}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setMaxWidth(80);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setMaxWidth(40);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JButton btnNewButton = new JButton("New button");
		panel_5.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_5.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		frame.getContentPane().add(panel_6, BorderLayout.CENTER);
		CardLayout card = new CardLayout(2,2);
		panel_6.setLayout(card);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, "name_425844137147783");
		panel_7.setLayout(new GridLayout(5, 5, 0, 0));
		
		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				JTextField jt = new JTextField();
				panel_7.add(jt);
			}
		}
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, "name_425844152668661");
		panel_8.setLayout(new GridLayout(5, 5, 0, 0));
		int k = 0;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				JButton jbt = new JButton("²ó");
				k++;
				panel_8.add(jbt);
			}
		}
		//card.next(panel_6);
	}

}

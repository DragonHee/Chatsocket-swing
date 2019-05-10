package chapter17_Problem3;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerView extends JFrame {
	private JTextField field;
	private JTextArea area;

	public ServerView() {
		super("채팅 서버");
		showView();
	}

	public void showView() {
		field = new JTextField(20);
		area = new JTextArea(10, 10);
		JScrollPane scroll = new JScrollPane(area);
		
		add(field, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		
		area.setEditable(false);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		new Server(field, area);
	}
}
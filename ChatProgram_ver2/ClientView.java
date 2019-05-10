package chapter17_Problem3_ver2;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientView extends JFrame{
	private JTextField field;
	private JTextArea area;

	
	public ClientView() {
		super("클라이언트");
		showView();
		new Client(field, area);
	}
	public void showView() {
		field = new JTextField(20);
		area = new JTextArea(10,10);
		JScrollPane scroll = new JScrollPane(area);

		area.setEditable(false);
		add(field, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
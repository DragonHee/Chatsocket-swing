package chapter17_Problem3_ver2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientHandler implements ActionListener{
	private PrintWriter pw;
	private JTextArea area;
	
	public ClientHandler(PrintWriter pw, JTextArea area) {
		this.pw = pw;
		this.area = area;
	}
	public void actionPerformed(ActionEvent e) {
		String s =((JTextField)e.getSource()).getText();
		pw.println(s);
		((JTextField)e.getSource()).setText("");
	}
}

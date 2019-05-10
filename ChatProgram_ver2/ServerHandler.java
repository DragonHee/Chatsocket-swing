package chapter17_Problem3_ver2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

class ServerHandler implements ActionListener {
	public ArrayList<PrintWriter> pwArr;
	private JTextArea area;
	
	public ServerHandler(ArrayList<PrintWriter> pwArr, JTextArea area) {
		this.area = area;
		this.pwArr = pwArr;
	}
	public void actionPerformed(ActionEvent e) {	
		String s = "[¼­¹ö]" + ((JTextField)e.getSource()).getText();
		for(PrintWriter p : pwArr) {
			p.println(s);			
		}
		((JTextField)e.getSource()).setText("");
		area.append(s + "\n");
	}
}
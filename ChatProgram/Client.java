package chapter17_Problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
	private JTextField field;
	private JTextArea area;
	private Socket client;
	private PrintWriter pw;
	private BufferedReader br;
	
	public Client(JTextField field, JTextArea area) {
		this.field = field;
		this.area = area;
		createSocket();
	}
	public void createSocket() {
		try {
			client = new Socket("localhost", 11000);
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(client.getOutputStream(), true);
			field.addActionListener(new ClientHandler(pw,area));
		} catch (IOException e) {
			System.err.println("서버와 연결을 실패하였습니다... 프로그램을 종료합니다...");
			try{
				Thread.sleep(1500);
			}catch(InterruptedException e1) {e.printStackTrace();}
			System.exit(1);
		}
		
		try {
			String s;
			while((s = br.readLine()) != null) {
				area.append(s + "\n");
				area.setCaretPosition(area.getDocument().getLength());
			}
		}catch(Exception e) {
			System.err.println("서버와의 연결이 종료되었습니다...");
		}finally {
			field.setEditable(false);
		}
		
	}
}

package chapter17_Problem3_ver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends Thread {
	private JTextField field;
	private JTextArea area;
	private static ArrayList<PrintWriter> pwList;
	private PrintWriter pw;
	private BufferedReader br;
	private ServerSocket server;
	private Socket connection;
	private static int ClientNum = 1;

	public Server(JTextField field, JTextArea area) {
		this.field = field;
		this.area = area;
		this.pwList = new ArrayList<PrintWriter>();
		field.addActionListener(new ServerHandler(pwList, area));
		createServer();
	}

	public Server(Socket client, JTextField field, JTextArea area) {
		this.field = field;
		this.area = area;

		connection = client;
		
		try {
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			pw = new PrintWriter(connection.getOutputStream(), true);
			pwList.add(pw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		start();
	}

	public void createServer() {
		try {
			server = new ServerSocket(11000);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				System.out.println("연결 대기중...");
				new Server(server.accept(), field, area);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		int num = ClientNum++;
		try {		
			System.out.println(num + "번 클라이언트와 연결이 성공하였습니다.");
			String s;
			while ((s = br.readLine()) != null) {
				if (s.equals("bye"))
					break;
				area.append("[" + num + "번 클라이언트]" + s + "\n");
				for(PrintWriter p : pwList) {
					p.println("[" + num + "번 클라이언트]"+ s);
				}
				area.setCaretPosition(area.getDocument().getLength());
			}
		} catch (IOException e) {
			System.err.println("클라이언트와 연결의 문제가 발생하여 클라이언트와 연결종료됩니다...");
		}
		area.append(num + "번 클라이언트와 연결이 종료되었습니다...\n");
		area.setCaretPosition(area.getDocument().getLength());
		pwList.remove(pw);
	}
}

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;

public class TcpIpMultiCharServer {
		
	HashMap clients; //k : ����ھ��̵� v : stream����

	public TcpIpMultiCharServer() {
		clients =new HashMap();
		Collections.synchronizedMap(clients);
	}
	
	public void start() {  //���� ���� 
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket =new ServerSocket(7777);
			System.out.println("���� ���۵�");
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() +"]"+"���� �����Ͽ����ϴ�.");
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	void sendToAll(String msg) {  //��� Ŭ���̾�Ʈ�� �޼��� ����
		
	}
	
	public static void main(String[] args) {
		new TcpIpMultiCharServer().start();

	}
}

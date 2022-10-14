import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;

public class TcpIpMultiCharServer {
		
	HashMap clients; //k : 사용자아이디 v : stream정보

	public TcpIpMultiCharServer() {
		clients =new HashMap();
		Collections.synchronizedMap(clients);
	}
	
	public void start() {  //서버 실행 
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket =new ServerSocket(7777);
			System.out.println("서버 시작됨");
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() +"]"+"에서 접속하였습니다.");
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	void sendToAll(String msg) {  //모든 클라이언트에 메세지 전달
		
	}
	
	public static void main(String[] args) {
		new TcpIpMultiCharServer().start();

	}
}

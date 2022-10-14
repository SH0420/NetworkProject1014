import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {

	public static void main(String[] args) {
		
		ServerSocket serverSocket =null;
		
		try {
			serverSocket = new ServerSocket(7777);
		} catch (IOException e) {
		   e.printStackTrace();
		}
		
		while(true) {
			
			try {
				System.out.println("연결요청을 기다립니다.");
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() +" 로 부터 연결 요청이 들어옴");
				
				OutputStream out =socket.getOutputStream();//클라이언트에 보낼수있는 길을 만듬
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice] 접속 성공 Message from Server");//문자를 보호하는형식 
				System.out.println("데이터를 전송했습니다.");
				dos.close();
			} catch (IOException e) {
			   e.printStackTrace();
			}
		}
	
	}

}

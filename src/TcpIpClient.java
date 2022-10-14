import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient {

	public static void main(String[] args) {
		
		System.out.println("서버에 연결 합니다.");
		try {
			Socket socket =new Socket("192.168.0.241",7777); //ip주소와 port번호세팅 
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("서버로 부터 받은 메세지" + dis.readUTF()); //값을 받아온다
			System.out.println("연결 종료");
			
			dis.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 

	}

}

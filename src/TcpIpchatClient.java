import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpchatClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("192.168.0.224",7777);
			System.out.println("서버에 연결 되었음");
			
			Sender sender =new Sender(socket);
			sender.start();
			
			Receiver receiver = new Receiver(socket);
			receiver.start();
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}

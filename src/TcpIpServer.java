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
				System.out.println("�����û�� ��ٸ��ϴ�.");
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() +" �� ���� ���� ��û�� ����");
				
				OutputStream out =socket.getOutputStream();//Ŭ���̾�Ʈ�� �������ִ� ���� ����
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice] ���� ���� Message from Server");//���ڸ� ��ȣ�ϴ����� 
				System.out.println("�����͸� �����߽��ϴ�.");
				dos.close();
			} catch (IOException e) {
			   e.printStackTrace();
			}
		}
	
	}

}

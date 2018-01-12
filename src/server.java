import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class server {
	public static void main(String[] args) throws IOException {
		DataParse dp = new DataParse();
		DatagramSocket socket = new DatagramSocket(2368);
		boolean listen = true;
		boolean check = true;
		while (listen && check!=false) {
			byte buffer[] = new byte[1200];
			
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			
			//System.out.println(socket.getRemoteSocketAddress().toString());
			
			InetAddress address = packet.getAddress();
			//int portNo = packet.getPort();
			//System.out.println("packet length : "+packet.getLength());
			dp.putData(buffer);
			dp.printData();
		}
		socket.close();
	}
}

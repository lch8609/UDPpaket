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
			byte buffer[] = new byte[1248];
			
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			
			InetAddress address = packet.getAddress();
			int portNo = packet.getPort();
			dp.putData(buffer);
			dp.printData();
		}
		socket.close();
	}
}

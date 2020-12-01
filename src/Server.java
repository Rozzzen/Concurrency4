import java.io.IOException;
import java.net.*;

import static java.lang.Thread.sleep;

public class Server implements Runnable{
    private final int clientPort;

    public Server(int clientPort) {
        this.clientPort = clientPort;
    }

    @Override
    public void run() {
        try (DatagramSocket serverSocket = new DatagramSocket(50000)) {
            for (int i = 0; i < 5; i++) {
                String message = "Message number " + i;
                DatagramPacket datagramPacket = new DatagramPacket(
                        message.getBytes(),
                        message.length(),
                        InetAddress.getLocalHost(),
                        clientPort
                );
                serverSocket.send(datagramPacket);
                sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

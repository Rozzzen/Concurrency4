public class Demo {
    public static void main(String[] args) {
        int port = 50001;
        Server server = new Server(port);
        Client client = new Client(port);

        new Thread(server).start();
        new Thread(client).start();
    }
}

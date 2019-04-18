import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

    /**
     * Class to listen for incoming server connections, if a connection is made a Client object is created and put in an ArrayList for future use.
     * For every connecting client object a thread is started.
     */
class Server {
    private ConnectedClients connectedClients = new ConnectedClients();

    /**
     * Constructor to get the ball rolling
     */
    Server() {
        try {
            letClientsConnect();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Infinite method for listening and accepting client connections
     * @throws IOException
     */
    private void letClientsConnect() throws IOException {

        final int SBAP_PORT = 8888;
        String client_id;
        Client client = null;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting for clients to connect...");

        while (true) {
            Socket socket = server.accept();
//            System.out.println("Client connected: " + socket.getRemoteSocketAddress() + "\n");
            Scanner scannerIn = new Scanner (socket.getInputStream());
            PrintWriter printWriterOut = new PrintWriter(socket.getOutputStream());

            // Handshake with connecting client
            printWriterOut.print("Who are you?\n");
            printWriterOut.flush();
            boolean response = true;
            while (response) {
                client_id = scannerIn.nextLine();
//                System.out.println("Client " + client_id + " connected: " + socket.getRemoteSocketAddress() + "\n");
                response = false;
                client = new Client(connectedClients, client_id, scannerIn, printWriterOut);
                connectedClients.addClient(client);
            }
            Thread t = new Thread(client);
            t.start();
        }
    }
}

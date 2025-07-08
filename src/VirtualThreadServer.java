import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class VirtualThreadServer {
    // we load one time on RAM and read one time the send direct
    static String fileContent;

    static {
        try {
            fileContent = Files.readString(Path.of("src/message.txt"));
        } catch (IOException e) {
            fileContent = "Error loading message";
        }
    }

    public static void main(String[] args) {
        int port = 8081;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started at port:" + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();

                Thread.startVirtualThread(() -> handleClient(clientSocket));
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        System.out.println("NEW Connetion:" + clientSocket.getInetAddress());
        try {
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);

            String response = fromClient.readLine();
            System.out.println("response from client:" + response);

            /*
            in this every single time we are doing io from a disk load read and send 
             * BufferedReader br = new BufferedReader(new FileReader("src/message.txt"));
             * 
             * String line;
             * while ((line =br.readLine()) != null){
             * toClient.println(line);
             * }
             * 
             */

            toClient.println(fileContent);
            toClient.flush();

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("file io issue");
        }
    }
}
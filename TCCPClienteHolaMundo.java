import java.io.*;
import java.net.*;

public class TCPClienteHolaMundo {
    public static void main(String[] args) {
        String servidor = "localhost";
        int puerto = 12345;

        try {
            Socket socket = new Socket(servidor, puerto);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Hola, servidor!");
            String respuesta = in.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
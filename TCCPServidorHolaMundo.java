import java.io.*;
import java.net.*;

public class TCPServidorHolaMundo {
    public static void main(String[] args) {
        int puerto = 12345;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando conexiones...");

            while (true) {
                Socket cliente = serverSocket.accept();
                PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

                String mensaje = in.readLine();
                System.out.println("Mensaje recibido: " + mensaje);
                out.println("Hola, cliente!");

                in.close();
                out.close();
                cliente.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
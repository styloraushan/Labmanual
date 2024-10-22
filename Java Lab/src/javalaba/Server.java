package javalaba;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(1234)){
            System.out.println("Server is listening at port no: 1234");
            try(Socket socket = serverSocket.accept()){
                System.out.println("new client connected");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream out = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(out,true);

                String text;

                do{
                    text= reader.readLine();
                    System.out.println("Received:"+ text);
                    writer.println("Server"+ text);
                }

                while (!text.equals("bye"));

                System.out.println("Client disconnected");
            }

        }
      catch (IOException e){
            e.printStackTrace();
      }
    }
}

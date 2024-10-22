package javalaba;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

            try(Socket socket = new Socket("localhost", 1234)){


                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream out = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(out,true);

                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

                String text;

                do{

                    System.out.println("Enter Message");
                    text= consoleReader.readLine();
                    writer.println("server:"+ text);
                    String response = reader.readLine();
                    System.out.println(response);
                }

                while (!text.equals("bye"));


            }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

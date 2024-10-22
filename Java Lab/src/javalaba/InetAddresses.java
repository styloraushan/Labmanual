package javalaba;
import  java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddresses {
    public static void main(String[] args) {
        try{
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println(localhost);
            System.out.println("Hotname: " + localhost.getHostName());
            System.out.println("Ip Address" + localhost.getHostAddress());

            String hostname = "www.example.com";
            InetAddress hostaddress = InetAddress.getByName(hostname);
            System.out.println("Host Information " + hostaddress);
            System.out.println("hostname: "+ hostaddress.getHostName());
            System.out.println("Ip address: "+ hostaddress.getHostAddress());

            String ipbyaddress = "128.125.123.1";
            InetAddress ipaddress = InetAddress.getByName(ipbyaddress);
            System.out.println("Host Information for ip" + ipaddress);
            System.out.println("hostname: "+ ipaddress.getHostName());
            System.out.println("Ip address: "+ ipaddress.getHostAddress());

        }
        catch (UnknownHostException e){
            System.out.println(e.getMessage());
        }
    }
}

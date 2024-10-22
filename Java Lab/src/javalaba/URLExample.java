package javalaba;
import java.net.MalformedURLException;
import  java.net.URL;
public class URLExample {



    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.javatpoint.com:8080/path/to/resources?query=example #references");
            System.out.println("Url:" + url.toString());
            System.out.println("protocol:" + url.getProtocol());
            System.out.println("port:" + url.getPort());
            System.out.println("path:" + url.getPath());
            System.out.println("query:" + url.getQuery());
            System.out.println("references: " +  url.getRef());

        }
        catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }
}

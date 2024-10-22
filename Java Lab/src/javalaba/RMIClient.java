package javalaba;

import java.rmi.Naming;

public class RMIClient {

    public static void main(String[] args) {
        try {
            Hello obj = (Hello) Naming.lookup("rmi://localhost:1099/Hello");
            String message = obj.sayHello();
            System.out.println("Message from server: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

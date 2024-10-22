package javalaba;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

    public static void main(String[] args) {
        try {
            HelloImpl obj = new HelloImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/Hello", obj);
            System.out.println("RMI Server is ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

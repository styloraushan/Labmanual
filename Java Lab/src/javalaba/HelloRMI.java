package javalaba;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloRMI extends Remote {
    String sayhello() throws RuntimeException, RemoteException;

}

package javalaba;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloRMIIMPL extends UnicastRemoteObject implements HelloRMI {
    public  HelloRMIIMPL(){
        super();
    }
    public String sayhello() throws RemoteException;
}

package rmiprogram;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class serverProcess {
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.createRegistry(8080);
            operationImplement T = new operationImplement();
            reg.rebind("app" , T);
            System.out.println("Waiting...");
        }catch(RemoteException e){
            System.out.println(e);
        }
    }
}


package OP;
import java.rmi.*;

public interface operationInterface extends Remote{
    public float Sum(float x,float y) throws RemoteException;
    public float Sub(float x,float y) throws RemoteException;
    public float mul(float x,float y) throws RemoteException;
    public float div(float x,float y) throws RemoteException;
}

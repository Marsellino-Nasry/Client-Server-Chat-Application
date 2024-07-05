package rmiprogram;
import java.rmi.*;
import java.rmi.server.*;
import OP.operationInterface;


public class operationImplement extends UnicastRemoteObject implements operationInterface{

    public operationImplement() throws RemoteException{}
    
    @Override
    public float Sum(float x, float y) throws RemoteException {
        return x+y;
    }

    @Override
    public float Sub(float x, float y) throws RemoteException {
        return x-y;
    }

    @Override
    public float mul(float x, float y) throws RemoteException {
        return x*y;
    }

    @Override
    public float div(float x, float y) throws RemoteException {
        return x/y;
    }
    
}

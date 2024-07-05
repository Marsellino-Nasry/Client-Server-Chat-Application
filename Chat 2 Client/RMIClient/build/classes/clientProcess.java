
import java.util.*;
import java.rmi.*;
import java.net.MalformedURLException;
import OP.operationInterface;

public class clientProcess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float num1 , num2;
        System.out.println("Enter two numbers : ");
        num1 = input.nextFloat();
        num2 = input.nextFloat();
        try{
            operationInterface I = (operationInterface)Naming.lookup("rmi://192.168.43.120:8080/app");
            System.out.println("Messege recived from the server \nThe sum of two numbers is : " + I.Sum(num1, num2));
            System.out.println("The sub of two numbers is : " + I.Sub(num1,num2));
            System.out.println("The multiply of two numbers is : " + I.mul(num1,num2));
            System.out.println("The divied of two numbers is : " + I.div(num1,num2));
        }catch(MalformedURLException | NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
}

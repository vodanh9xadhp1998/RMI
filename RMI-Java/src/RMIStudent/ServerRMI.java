package RMIStudent;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject; 

public class ServerRMI extends IMPL { 
   public ServerRMI() {} 
   public static void main(String args[]) { 
      try { 
         // Instantiating the implementation class 
         IMPL obj = new IMPL(); 
         Interface stub = (Interface) UnicastRemoteObject.exportObject(obj, 0);  
         Registry registry = LocateRegistry.getRegistry(); 
         registry.bind("Hello", stub);  
         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
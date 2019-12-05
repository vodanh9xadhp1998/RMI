package RMIStudent;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.*;  

public class ClientRMI {  
   private ClientRMI() {}  
   public static void main(String[] args)throws Exception {  
      try { 
         Registry registry = LocateRegistry.getRegistry(null); 
         Interface stub = (Interface) registry.lookup("Hello"); 
    
         List<Student> list = (List)stub.getStudents();
         for (Student s:list) { 
            System.out.println("ID: " + s.getID()); 
            System.out.println("Name: " + s.getName()); 
            System.out.println("Age: "+s.getAge()); 
            System.out.println("Mark: " + s.getMark()); 
         }
      } catch (Exception e) { 
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}

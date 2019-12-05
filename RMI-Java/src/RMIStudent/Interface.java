package RMIStudent;
import java.rmi.Remote; 
import java.util.*;

public interface Interface extends Remote {  
   public List<Student> getStudents() throws Exception;  
}

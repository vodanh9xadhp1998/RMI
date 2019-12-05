package RMIStudent;
import java.util.*;  

public class IMPL implements Interface {
   public List<Student> getStudents() throws Exception {  
      List<Student> list = new ArrayList<Student>();   
      ActionFile AF = new ActionFile();
      list = AF.LoadFileStudent("DataSudent.dat");
      return list;     
   }  
}

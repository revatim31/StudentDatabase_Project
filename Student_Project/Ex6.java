//6.	Display the information (no,name,age) of student  who made the project in java.
package Student_Project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex6 {
   static final String DB_URL = "jdbc:mysql://localhost/student_project";
   static final String USER = "root";
   static final String PASS = "password";
   static final String QUERY = "SELECT DISTINCT student.st_no,student.st_name, project.prj_platform,"
   		+ "TIMESTAMPDIFF(YEAR,student.st_dob, CURDATE()) AS age FROM Student \r\n"
   		+ "JOIN StudentProject\r\n"
   		+ "  ON Student.st_no = StudentProject.st_no \r\n"
   		+ "JOIN Project\r\n"
   		+ "  ON Project.prj_no = StudentProject.prj_no where prj_platform='JAVA' ; ";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
      ) {		      
         while(rs.next()){
            //Display values
        	 System.out.print("\n\nStudent No	: " + rs.getString("st_no"));
        	 System.out.print("\nName	: " + rs.getString("st_name"));
        	 System.out.println("\nage:' " + rs.getString("age"));
        	 System.out.println("\nPlatform	: " + rs.getString("prj_platform"));
        	 
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
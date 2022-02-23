//7.	Display the student information who is a programmer
package Student_Project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex7 {
   static final String DB_URL = "jdbc:mysql://localhost/student_project";
   static final String USER = "root";
   static final String PASS = "password";
   static final String QUERY = "SELECT * FROM Student \r\n"
   		+ "JOIN StudentProject\r\n"
   		+ "  ON Student.st_no = StudentProject.st_no \r\n"
   		+ " where designation='PROGRAMMER' ; ";

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
        	 System.out.print("\nDate of Birth	: " + rs.getString("st_dob"));
             System.out.println("\nDate of Join	:' " + rs.getString("st_doj"));
             System.out.print("\nProject No	: " + rs.getString("prj_no"));
             System.out.print("\ndesignation	: " + rs.getString("designation"));
        	 
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
//9.	Display details of the youngest student.
package Student_Project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex9 {
   static final String DB_URL = "jdbc:mysql://localhost/student_project";
   static final String USER = "root";
   static final String PASS = "password";
   static final String QUERY = "SELECT st_name, MIN(TIMESTAMPDIFF(YEAR,st_dob, CURDATE())) AS minage FROM Student where st_dob=(SELECT max(st_dob)from student) ; ";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
      ) {		      
         while(rs.next()){
            //Display values
        	 
        	 System.out.print("\nName	: " + rs.getString("st_name"));
        	 System.out.println("\nyoungest Student:" + rs.getString("minage"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
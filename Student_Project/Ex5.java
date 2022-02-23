//5.	Find number of students who did not participate in any project.
package Student_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex5 {
   static final String DB_URL = "jdbc:mysql://localhost/student_project";
   static final String USER = "root";
   static final String PASS = "password";
   static final String QUERY = "select * from Student where st_no not in(select st_no from StudentProject);";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
      ) {		      
         while(rs.next()){
            //Display values
        	 System.out.print("\n\nStudent No	: " + rs.getString("st_no"));
            
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
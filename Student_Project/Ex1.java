//1.	Display list of all student  
package Student_Project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1 {
   static final String DB_URL = "jdbc:mysql://localhost/student_project";
   static final String USER = "root";
   static final String PASS = "password";
   static final String QUERY = "SELECT *FROM Student";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
      ) {		      
         while(rs.next()){
            //Display values
            System.out.print("\n\nStudent RollNo	: " + rs.getString("st_no"));
            System.out.print("\nName	: " + rs.getString("st_name"));
            System.out.print("\nDate of Birth	: " + rs.getString("st_dob"));
            System.out.println("\nDate of Join	:' " + rs.getString("st_doj"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}


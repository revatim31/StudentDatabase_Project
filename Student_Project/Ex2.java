//2.	Display list of all projects
package Student_Project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2 {
   static final String DB_URL = "jdbc:mysql://localhost/student_project";
   static final String USER = "root";
   static final String PASS = "password";
   static final String QUERY = "SELECT *FROM Project";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
      ) {		      
         while(rs.next()){
            //Display values
            System.out.print("\n\nProject No	: " + rs.getString("prj_no"));
            System.out.print("\n  Project Name	: " + rs.getString("prj_name"));
            System.out.print("\n Project Duration	: " + rs.getInt("prj_dur"));
            System.out.println("\nPlatform	:' " + rs.getString("prj_platform"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
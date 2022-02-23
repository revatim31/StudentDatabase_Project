//3.	Display the number of students who are working on project “P01”.
package Student_Project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3 {
   static final String DB_URL = "jdbc:mysql://localhost/student_project";
   static final String USER = "root";
   static final String PASS = "password";
   static final String QUERY = "SELECT * from studentproject where prj_no='P01';";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
      ) {		      
         while(rs.next()){
            //Display values
        	 System.out.print("\n\nStudent No	: " + rs.getString("st_no"));
            System.out.print("\nProject No	: " + rs.getString("prj_no"));
            System.out.print("\nDesignation	: " + rs.getString("designation"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
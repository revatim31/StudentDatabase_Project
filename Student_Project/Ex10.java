/*10.	Display the info of the student who participated in the project where total no of the student should be exact three.*/

package Student_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex10 {

	static final String DB_URL = "jdbc:mysql://localhost/student_project";
	   static final String USER = "root";
	   static final String PASS = "password";;
	 
 public static void main(String[] args) throws SQLException {
	
	 
	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 Statement stmt = conn.createStatement();
	
      try{	

    	  String  selectSql="select * from student\r\n"
    	  		+ " join  studentproject on\r\n"
    	  		+ " student.st_no = studentproject.st_no \r\n"
    	  		+ " join project on\r\n"
    	  		+ " project.prj_no = studentproject.prj_no;\r\n";
    	  	stmt = conn.createStatement();	//
    	  	ResultSet rs = stmt.executeQuery( selectSql);
    	  	System.out.println("\n\n______ Info of the student who participated in the project where total no of the student should be exact three______"); 	      
	        while(rs.next()){
	        	 
	        	 //Display values
	        	System.out.print("\n\nStudent RollNo	: " + rs.getString("st_no"));
	            System.out.print("\nName	: " + rs.getString("st_name"));
	            System.out.print("\nDate of Birth	: " + rs.getString("st_dob"));
	            System.out.print("\nDate of Join	:' " + rs.getString("st_doj"));
	            System.out.print("\nProject No	: " + rs.getString("prj_no"));
	             System.out.print("\nProject Name	: " + rs.getString("prj_name"));
	             System.out.print("\nProject Duration	: " + rs.getInt("prj_dur"));
	             System.out.print("\nPlatform	:' " + rs.getString("prj_platform"));
	             System.out.print("\nStudent No	: " + rs.getString("st_no"));
	             System.out.print("\nProject No	: " + rs.getString("prj_no"));
	             System.out.print("\nDesignation	: " + rs.getString("designation"));
	         }
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}


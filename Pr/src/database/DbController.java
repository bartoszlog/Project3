package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbController {
    
        public Connection Connection() throws ClassNotFoundException, SQLException{       
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/pracownicy","root","bartek123b"); 
      }
 }

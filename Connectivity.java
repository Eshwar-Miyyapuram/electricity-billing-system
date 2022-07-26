import java.sql.*;

public class Connectivity {
    
    Connection c;
    Statement s;
    Connectivity(){
        try{
        
        c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "Eshwar@1999");
        s=c.createStatement(); 
         
        } catch(Exception e){
             e.printStackTrace();
        }
    }
} 

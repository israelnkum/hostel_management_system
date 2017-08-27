
package All_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class java_connection {

   
    public static Connection getConnection(){
        
         Connection conn = null;
         
         try{
             
             Class.forName("com.mysql.jdbc.Driver");
             
             conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12191764","sql12191764","bi2hZUJGKl");
             
         }
         catch (Exception e){
         
             JOptionPane.showMessageDialog(null, "Check your internet connection","No internet",JOptionPane.ERROR_MESSAGE);
         }
        return conn;
         
         
       
    
    }
    
    
}

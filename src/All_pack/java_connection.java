
package All_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class java_connection {


    public static Connection getConnection(){
        
         Connection conn = null;
         
         try{
             
             Class.forName("com.mysql.jdbc.Driver");
             
         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_management_system","root","");
           
         }
         catch (ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null,e);
     // JOptionPane.showMessageDialog(null, "Check your internet connection","No internet",JOptionPane.ERROR_MESSAGE);
         }
        return conn;
         
         
       
    
    }
    
    
}

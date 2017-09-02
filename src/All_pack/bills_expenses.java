/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package All_pack;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author oSikaNi iSraeL
 */
public class bills_expenses extends javax.swing.JFrame {
        int xMouse;
        int yMouse;
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;


    /**
     * Creates new form bills_expenses
     */
    public bills_expenses() {
        initComponents();
        
        conn = java_connection.getConnection();
        
        bill_date.setVisible(false);
        bill_time.setVisible(false);
        
          bill_des.setBackground(new Color(0,0,0,0));
       bill_amt.setBackground(new Color(0,0,0,0));
       


        
         currentDate();
    }
    
     public void currentDate(){
    
    
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
   //     date_.setText(year+"/"+(month+1)+"/"+day);
       bill_date.setText(year+"/"+(month+1)+"/"+day);
  //  others_date_update.setText(year+"/"+(month+1)+"/"+day);
        

         Date date = new Date();
         String strDateFormat = "HH:mm:ss a";
         SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
       //   time.setText(sdf.format(date));
         bill_time.setText(sdf.format(date));
     // others_time_update.setText(sdf.format(date));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        bill_des = new javax.swing.JTextField();
        bill_amt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        bill_time = new javax.swing.JTextField();
        bill_date = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 51));
        jLabel17.setText("Description");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 60));

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setText("Amount Used");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 192, -1, 60));

        bill_des.setBackground(new java.awt.Color(204, 228, 202));
        bill_des.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bill_des.setForeground(new java.awt.Color(0, 0, 0));
        bill_des.setBorder(null);
        bill_des.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bill_desKeyPressed(evt);
            }
        });
        getContentPane().add(bill_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 290, 50));

        bill_amt.setBackground(new java.awt.Color(204, 228, 202));
        bill_amt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bill_amt.setForeground(new java.awt.Color(0, 0, 0));
        bill_amt.setBorder(null);
        bill_amt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bill_amtMouseDragged(evt);
            }
        });
        bill_amt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bill_amtMousePressed(evt);
            }
        });
        bill_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bill_amtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bill_amtKeyTyped(evt);
            }
        });
        getContentPane().add(bill_amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 179, 170, 50));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 170, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 152, 290, 10));
        getContentPane().add(bill_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 329, 130, 40));
        getContentPane().add(bill_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 269, 130, 40));

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Go Back_20px.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Checked_20px_2.png"))); // NOI18N
        jButton2.setText("Enter");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 0), 1, true), "Bill Expenses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Light", 0, 24), new java.awt.Color(0, 51, 0))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 380));

        setSize(new java.awt.Dimension(491, 379));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(bill_des.getText().isEmpty() || bill_amt.getText().isEmpty())
        
        {
        
            JOptionPane.showMessageDialog(null, "Fill all Information","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
         try {

            String sql = "Insert into bills(description, amount_used,  date_used, time_) values (?,?,?,?)";

            pst=conn.prepareStatement(sql);
            pst.setString(1, bill_des.getText());
            pst.setString(2,  bill_amt.getText());
            pst.setString(3, bill_date.getText());
            pst.setString(4, bill_time.getText());

            pst.execute();

            bill_des.setText(null);
            bill_amt.setText(null);
            bill_date.setText(null);
            bill_time.setText(null);

            JOptionPane.showMessageDialog(null," Success");

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog( null,"Check your internet connection");
        }
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        setVisible(false);
        expenses ep = new expenses();
        ep.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bill_amtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bill_amtKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
            if(bill_des.getText().isEmpty() || bill_amt.getText().isEmpty())
        
        {
        
            JOptionPane.showMessageDialog(null, "Fill all Information","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
         try {

            String sql = "Insert into bills(description, amount_used,  date_used, time_) values (?,?,?,?)";

            pst=conn.prepareStatement(sql);
            pst.setString(1, bill_des.getText());
            pst.setString(2,  bill_amt.getText());
            pst.setString(3, bill_date.getText());
            pst.setString(4, bill_time.getText());

            pst.execute();

            bill_des.setText(null);
            bill_amt.setText(null);
            bill_date.setText(null);
            bill_time.setText(null);

            JOptionPane.showMessageDialog(null," Success");

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog( null,"Check your internet connection");
        }
        }
            
        }
    }//GEN-LAST:event_bill_amtKeyPressed

    private void bill_desKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bill_desKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
            if(bill_des.getText().isEmpty() || bill_amt.getText().isEmpty())
        
        {
        
            JOptionPane.showMessageDialog(null, "Fill all Information","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
         try {

            String sql = "Insert into bills(description, amount_used,  date_used, time_) values (?,?,?,?)";

            pst=conn.prepareStatement(sql);
            pst.setString(1, bill_des.getText());
            pst.setString(2,  bill_amt.getText());
            pst.setString(3, bill_date.getText());
            pst.setString(4, bill_time.getText());

            pst.execute();

            bill_des.setText(null);
            bill_amt.setText(null);
            bill_date.setText(null);
            bill_time.setText(null);

            JOptionPane.showMessageDialog(null," Success");

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog( null,"Check your internet connection");
        }
        }
            
        }
    }//GEN-LAST:event_bill_desKeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
            if(bill_des.getText().isEmpty() || bill_amt.getText().isEmpty())
        
        {
        
            JOptionPane.showMessageDialog(null, "Fill all Information","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
         try {

            String sql = "Insert into bills(description, amount_used,  date_used, time_) values (?,?,?,?)";

            pst=conn.prepareStatement(sql);
            pst.setString(1, bill_des.getText());
            pst.setString(2,  bill_amt.getText());
            pst.setString(3, bill_date.getText());
            pst.setString(4, bill_time.getText());

            pst.execute();

            bill_des.setText(null);
            bill_amt.setText(null);
            bill_date.setText(null);
            bill_time.setText(null);

            JOptionPane.showMessageDialog(null," Success");

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog( null,"Check your internet connection");
        }
        }
            
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
             setVisible(false);
        expenses ep = new expenses();
        ep.setVisible(true);
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void bill_amtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bill_amtKeyTyped
        // TODO add your handling code here:
         char check = evt.getKeyChar();
        
        if(!(Character.isDigit(check)
                || check ==KeyEvent.VK_ENTER 
                ||  check ==KeyEvent.VK_BACKSPACE
                ||  check ==KeyEvent.VK_DELETE  
                || check ==KeyEvent.VK_PERIOD))
        {
        
            evt.consume();
           // JOptionPane.showMessageDialog(null, "Figures Only");
        }
    }//GEN-LAST:event_bill_amtKeyTyped

    private void bill_amtMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bill_amtMouseDragged
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_bill_amtMouseDragged

    private void bill_amtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bill_amtMousePressed
        // TODO add your handling code here:
        
     
    }//GEN-LAST:event_bill_amtMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        
         int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        
           xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bills_expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bills_expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bills_expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bills_expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bills_expenses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bill_amt;
    private javax.swing.JTextField bill_date;
    private javax.swing.JTextField bill_des;
    private javax.swing.JTextField bill_time;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}

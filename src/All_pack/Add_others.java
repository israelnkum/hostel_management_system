/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package All_pack;

import java.awt.event.KeyEvent;
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
public class Add_others extends javax.swing.JFrame {
Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    /**
     * Creates new form othersUpdate
     */
    public Add_others() {
        initComponents();
         conn = java_connection.getConnection();
         
                
        othres_time.setVisible(false);
        others_date.setVisible(false);
         currentDate();
    }
    
      public void currentDate(){
    
    
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
    
 others_date.setText(year+"/"+(month+1)+"/"+day);
        

         Date date = new Date();
         String strDateFormat = "HH:mm:ss a";
         SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
   
 othres_time.setText(sdf.format(date));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        others_amt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        others_descr = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        others_date = new javax.swing.JTextField();
        othres_time = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        others_amt.setBackground(new java.awt.Color(204, 228, 202));
        others_amt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        others_amt.setForeground(new java.awt.Color(0, 0, 0));
        others_amt.setBorder(null);
        others_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                others_amtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                others_amtKeyTyped(evt);
            }
        });
        getContentPane().add(others_amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 170, 50));

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setText("Amount Used");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 192, -1, 50));

        others_descr.setBackground(new java.awt.Color(204, 228, 202));
        others_descr.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        others_descr.setForeground(new java.awt.Color(0, 0, 0));
        others_descr.setBorder(null);
        others_descr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                others_descrMouseClicked(evt);
            }
        });
        others_descr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                others_descrKeyPressed(evt);
            }
        });
        getContentPane().add(others_descr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 300, 50));

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 51));
        jLabel17.setText("Description");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 50));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 170, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 152, 290, 10));
        getContentPane().add(others_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 50, 30));
        getContentPane().add(othres_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 110, 30));

        jButton7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Checked_20px_2.png"))); // NOI18N
        jButton7.setText("Enter");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton7KeyPressed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 0), 1, true), "Other Expenses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Light", 0, 24), new java.awt.Color(0, 51, 0))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 380));

        setSize(new java.awt.Dimension(492, 381));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void others_amtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_others_amtKeyTyped
        // TODO add your handling code here:
        char check = evt.getKeyChar();

        if(!(Character.isDigit(check)
            || check ==KeyEvent.VK_ENTER
            ||  check ==KeyEvent.VK_BACK_SPACE
            ||  check ==KeyEvent.VK_DELETE  ))
    {

        evt.consume();
        JOptionPane.showMessageDialog(null, "Figures Only");
        }
    }//GEN-LAST:event_others_amtKeyTyped

    private void others_descrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_others_descrMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_others_descrMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
if(others_descr.getText().isEmpty() || others_amt.getText().isEmpty())
        
        {
        
            JOptionPane.showMessageDialog(null, "Fill all Information","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
        try {

            String sql = "Insert into others(description, amt_used,  date_used, time_) values (?,?,?,?)";

            pst=conn.prepareStatement(sql);
            pst.setString(1, others_descr.getText());
            pst.setString(2, others_amt.getText());
            pst.setString(3, others_date.getText());
            pst.setString(4, othres_time.getText());

            pst.execute();

            others_date.setText(null);
            othres_time.setText(null);
            others_descr.setText(null);
            others_amt.setText(null);

            JOptionPane.showMessageDialog(null," Success");

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog( null,"no");
        }
}

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        expenses ee = new expenses();
        ee.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void others_descrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_others_descrKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
            if(others_descr.getText().isEmpty() || others_amt.getText().isEmpty())
        
        {
        
            JOptionPane.showMessageDialog(null, "Fill all Information","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
        try {

            String sql = "Insert into others(description, amt_used,  date_used, time_) values (?,?,?,?)";

            pst=conn.prepareStatement(sql);
            pst.setString(1, others_descr.getText());
            pst.setString(2, others_amt.getText());
            pst.setString(3, others_date.getText());
            pst.setString(4, othres_time.getText());

            pst.execute();

            others_date.setText(null);
            othres_time.setText(null);
            others_descr.setText(null);
            others_amt.setText(null);

            JOptionPane.showMessageDialog(null," Success");

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog( null,"no");
        }
}
        }
    }//GEN-LAST:event_others_descrKeyPressed

    private void others_amtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_others_amtKeyPressed
        // TODO add your handling code here:
           if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
            if(others_descr.getText().isEmpty() || others_amt.getText().isEmpty())
        
        {
        
            JOptionPane.showMessageDialog(null, "Fill all Information","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
        try {

            String sql = "Insert into others(description, amt_used,  date_used, time_) values (?,?,?,?)";

            pst=conn.prepareStatement(sql);
            pst.setString(1, others_descr.getText());
            pst.setString(2, others_amt.getText());
            pst.setString(3, others_date.getText());
            pst.setString(4, othres_time.getText());

            pst.execute();

            others_date.setText(null);
            othres_time.setText(null);
            others_descr.setText(null);
            others_amt.setText(null);

            JOptionPane.showMessageDialog(null," Success");

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog( null,"no");
        }
}
        }
    }//GEN-LAST:event_others_amtKeyPressed

    private void jButton7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton7KeyPressed
        // TODO add your handling code here:
           if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
            if(others_descr.getText().isEmpty() || others_amt.getText().isEmpty())
        
        {
        
            JOptionPane.showMessageDialog(null, "Fill all Information","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
        try {

            String sql = "Insert into others(description, amt_used,  date_used, time_) values (?,?,?,?)";

            pst=conn.prepareStatement(sql);
            pst.setString(1, others_descr.getText());
            pst.setString(2, others_amt.getText());
            pst.setString(3, others_date.getText());
            pst.setString(4, othres_time.getText());

            pst.execute();

            others_date.setText(null);
            othres_time.setText(null);
            others_descr.setText(null);
            others_amt.setText(null);

            JOptionPane.showMessageDialog(null," Success");

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog( null,"no");
        }
}
        }
    }//GEN-LAST:event_jButton7KeyPressed

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
            java.util.logging.Logger.getLogger(Add_others.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_others.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_others.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_others.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_others().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField others_amt;
    private javax.swing.JTextField others_date;
    private javax.swing.JTextField others_descr;
    private javax.swing.JTextField othres_time;
    // End of variables declaration//GEN-END:variables
}

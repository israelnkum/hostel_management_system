/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package All_pack;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.swing.JLabel;


import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author oSikaNi iSraeL
 */
public class summary extends javax.swing.JFrame {
    
          DefaultTableModel model;
          DefaultTableModel model_1;
          DefaultTableModel model_2;
          DefaultTableModel model_3;
      Connection conn;
    ResultSet rs;
    PreparedStatement pst;

    /**
     * Creates new form summary
     */
    public summary() {
        initComponents();
         conn = java_connection.getConnection();
      
         model_1 =(DefaultTableModel) jTable3.getModel(); 
     model = (DefaultTableModel) jTable1.getModel();
        Update_table();
        Student();
        Update_Payment();
        total_Fees();
       total_arreas();
       total_amtPaid();
       total_student();
       
       
    }
    
    
    private void Update_table(){
    
        try {
           String sql="SELECT room_no as 'Room Number', bed_no as 'Bed Number'   FROM payment_1";
           
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
        finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
      }
    
    // pulling data from the new_info table to update the hostelers table
    
    private void Student(){
    
        try {
           String sql="SELECT  customer_id as 'ID', fname as 'First Name', lname as 'Last Name',program as 'Program', roo_no as 'Room Number', bed_no as 'Bed Number'   FROM new_info";
           
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
        finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
      }
    
    
    // pulling data from the payment database to update the payment_table
    private void Update_Payment(){
    
        try {
           String sql="SELECT fname as 'First Name', lname as 'Last Name', room_no as 'Room', bed_no as 'Bed', hostel_fee as 'Hostel Fee', amt_paid as 'Amount Paid', arreas as 'Arrears', date_ as 'Date Paid'  FROM payment_1";
           
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            payment_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
        finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
        
    }
      
    //calculating the total fees to be paid 
     public void total_Fees(){

             float sum =0;
  
            for (int i=0; i < payment_tbl.getRowCount(); i++){
            
            sum  = sum   + Float.parseFloat(payment_tbl.getValueAt(i, 4).toString());
        
            }
            
      total_fees.setText("GH¢ "+(Float.toString(sum)));
    
        }

    
           //calculating the total arrears
     public void total_arreas(){
        

             float sum =0;
  
            for (int i=0; i < payment_tbl.getRowCount(); i++){
            
            sum  = sum   + Float.parseFloat(payment_tbl.getValueAt(i, 6).toString());
        
            }
        arreas.setText("GH¢ "+(Float.toString(sum)));
    
        }
     
     
           // calculating the total amount paid
     public void total_amtPaid(){
        

             float sum =0;
  
            for (int i=0; i < payment_tbl.getRowCount(); i++){
            
            sum  = sum   + Float.parseFloat(payment_tbl.getValueAt(i, 5).toString());
        
            }
        feesPaid.setText("GH¢ "+(Float.toString(sum)));
    
        }
     
     
     
     //Filter payment table
     private void filter (String sql){
    
          model_2 =(DefaultTableModel) payment_tbl.getModel();
     
         TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model_2);
         payment_tbl.setRowSorter(tr);
         tr.setRowFilter(RowFilter.regexFilter(sql));
     }
     
       private void student_filter (String sql){
    
          model_3 =(DefaultTableModel) jTable3.getModel();
     
         TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model_3);
         jTable3.setRowSorter(tr);
         tr.setRowFilter(RowFilter.regexFilter(sql));
     }
     
      public void total_student(){
        

          try{
          
              String sql =" Select count(fname) from new_info";
              pst=conn.prepareStatement(sql);
              rs=pst.executeQuery();
              if(rs.next()){
              
                  String sum = rs.getString("count(fname)");
                  student.setText(sum);
                  
              }
          }
          catch (Exception e){
          
              
          }
          
    
    
        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        student = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        std_filt = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        total_fees = new javax.swing.JLabel();
        feesPaid = new javax.swing.JLabel();
        arreas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        payment_tbl = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        search_1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 0));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 400, 390));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 150));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 1, true), "Total Room's", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 24), new java.awt.Color(0, 51, 0))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 180, 60));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 1, true), "Total Bed's", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 24), new java.awt.Color(0, 51, 0))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 180, 60));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 160, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 0));
        jLabel2.setText("Search:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        jButton2.setText("Print");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 0));
        jLabel17.setText("JODOK  HOSTEL");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 620));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 690));

        jTabbedPane1.addTab("Hostel", jPanel1);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        student.setForeground(new java.awt.Color(0, 0, 0));
        student.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 1, true), "Total Student", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 24), new java.awt.Color(0, 51, 0))); // NOI18N
        jPanel4.add(student, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 250, 80));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 140, 130));

        jTable3.setBackground(new java.awt.Color(193, 223, 197));
        jTable3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable3.setForeground(new java.awt.Color(0, 0, 0));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.setRowHeight(25);
        jTable3.setRowMargin(2);
        jScrollPane3.setViewportView(jTable3);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 840, 340));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_20px_3.png"))); // NOI18N
        jLabel7.setText("Search:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        std_filt.setBackground(new java.awt.Color(218, 231, 214));
        std_filt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        std_filt.setForeground(new java.awt.Color(0, 0, 0));
        std_filt.setBorder(null);
        std_filt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                std_filtKeyReleased(evt);
            }
        });
        jPanel4.add(std_filt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 270, 40));

        jButton6.setBackground(new java.awt.Color(218, 231, 214));
        jButton6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print_20px_3.png"))); // NOI18N
        jButton6.setText("Print");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, -1, -1));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 270, 10));

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 0));
        jLabel23.setText("HOSTEL");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 0, 70)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 0));
        jLabel24.setText("JODOK ");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 0, 980, 680));

        jTabbedPane1.addTab("Student", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        total_fees.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        total_fees.setForeground(new java.awt.Color(0, 102, 51));
        total_fees.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 2, true));
        jPanel5.add(total_fees, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 230, 80));

        feesPaid.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        feesPaid.setForeground(new java.awt.Color(0, 102, 51));
        feesPaid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 2, true));
        jPanel5.add(feesPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, 220, 80));

        arreas.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        arreas.setForeground(new java.awt.Color(0, 102, 51));
        arreas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 2, true));
        jPanel5.add(arreas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 210, 80));

        payment_tbl.setBackground(new java.awt.Color(193, 223, 197));
        payment_tbl.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        payment_tbl.setForeground(new java.awt.Color(0, 0, 0));
        payment_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        payment_tbl.setRowHeight(25);
        payment_tbl.setRowMargin(2);
        jScrollPane2.setViewportView(payment_tbl);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 850, 320));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 150, 150));

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 0));
        jLabel13.setText("HOSTEL");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 0));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_20px_3.png"))); // NOI18N
        jLabel18.setText("Search:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        search_1.setBackground(new java.awt.Color(218, 231, 214));
        search_1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        search_1.setForeground(new java.awt.Color(0, 0, 0));
        search_1.setBorder(null);
        search_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_1KeyReleased(evt);
            }
        });
        jPanel5.add(search_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 270, 40));

        jButton5.setBackground(new java.awt.Color(218, 231, 214));
        jButton5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print_20px_3.png"))); // NOI18N
        jButton5.setText("Print");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, -1, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 51));
        jLabel19.setText("Total Fees Paid:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 51));
        jLabel20.setText("Total Arrears");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 51));
        jLabel21.setText("Total Fees:");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 270, 10));

        jLabel22.setFont(new java.awt.Font("Segoe UI Light", 0, 70)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 0));
        jLabel22.setText("JODOK ");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 630));

        jTabbedPane1.addTab("Payment", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        jMenu1.setText("File");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Go Back_20px.png"))); // NOI18N
        jMenuItem3.setText("Back");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Logout Rounded Left_20px.png"))); // NOI18N
        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Cancel_20px_2.png"))); // NOI18N
        jMenuItem2.setText("Close");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(875, 665));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        mainPage mp = new mainPage();
        mp.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        login_form mp = new login_form();
        mp.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void search_1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_1KeyReleased
        // TODO add your handling code here:
        String txt_1=search_1.getText();
        filter (txt_1);
        
    }//GEN-LAST:event_search_1KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         MessageFormat header = new MessageFormat("Payment Summary");
         MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try{
             
             payment_tbl.print(JTable.PrintMode.NORMAL, header, footer);


    }catch(Exception e)
    {
           System.err.format("Cannont print %s%n",e.getMessage());

    }
        
 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         MessageFormat header = new MessageFormat("Student Summary");
         MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try{
             
             jTable3.print(JTable.PrintMode.NORMAL, header, footer);


    }catch(Exception e)
    {
           System.err.format("Cannont print %s%n",e.getMessage());

    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void std_filtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_std_filtKeyReleased
        // TODO add your handling code here:
        String txt_1=std_filt.getText();
        student_filter (txt_1);
    }//GEN-LAST:event_std_filtKeyReleased

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
            java.util.logging.Logger.getLogger(summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new summary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arreas;
    private javax.swing.JLabel feesPaid;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable payment_tbl;
    private javax.swing.JTextField search_1;
    private javax.swing.JTextField std_filt;
    private javax.swing.JLabel student;
    private javax.swing.JLabel total_fees;
    // End of variables declaration//GEN-END:variables
}

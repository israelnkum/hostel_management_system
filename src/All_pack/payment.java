/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package All_pack;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.print.PrinterException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author oSikaNi iSraeL
 */
public class payment extends javax.swing.JFrame {

     DefaultTableModel model_1;
     DefaultTableModel model;
     Connection conn;
    ResultSet rs;
    PreparedStatement pst;

    
    int xMouse;
    int yMouse;
     public payment() {
        initComponents();
        conn = java_connection.getConnection();
        
        amt_left.setVisible(false);
        amt_paid.setVisible(false);
        new_ARREAS.setVisible(false);
        arears.setVisible(false);
        fname.setVisible(false);
        lname.setVisible(false);
        balance.setVisible(false);
         grand_toal.setVisible(false);
         amount_paid.setVisible(false);
           jLabel5.setVisible(false);
         jLabel10.setVisible(false);
           cust_id.setVisible(false);
             f_name.setVisible(false);  
             l_name.setVisible(false);
              grand_amt.setVisible(false);
             
              jTextField1.setBackground(new Color(0,0,0,0));
              search.setBackground(new Color(0,0,0,0));
              

      
     
        Update_table();
        Update_table_1();
          currentDate();
        
    }
     
     
     private void filter (String sql){
    
          model_1 =(DefaultTableModel) jTable2.getModel();
     
         TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model_1);
         jTable2.setRowSorter(tr);
         tr.setRowFilter(RowFilter.regexFilter(sql));
     }
     
      private void filter_1 (String sql_1){
    
         model =(DefaultTableModel) jTable4.getModel(); 
     
         TableRowSorter<DefaultTableModel> tt = new TableRowSorter<DefaultTableModel> (model);
         jTable4.setRowSorter(tt);
         tt.setRowFilter(RowFilter.regexFilter(sql_1));
     }
     
     
     
     public void arreas(){
     
         String old = String.valueOf(arreas_1.getText());
         
         double odl1 = Double.parseDouble(old);
         
         String new_1 = String.valueOf(new_amt.getText());
         
         double new_2 = Double.parseDouble(new_1);
         
         double bal = odl1 - new_2;
         balance.setText((Double.toString(bal)));
         
         
     }
     
      public void currentDate(){
    
    
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        date_txt.setText("  "+ year+"/"+(month+1)+"/"+day);
       
   
    }
      
      private void Update_table(){
    
        try {
          String sql ="SELECT  hosteler_id as 'ID', fname as 'First Name', lname as 'Last Name' FROM new_hosteler ";
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
        //    JOptionPane.showMessageDialog( null, e);
        }
        }
      
      private void Update_table_1(){
    
        try {
          String sql ="SELECT pay_id as 'ID', fname as 'First Name',lname as ' Last Name', room_no as 'Room No', bed_no as 'Bed No', hostel_fee as 'Hostel Fee', amt_paid as 'Amount Paid', arreas as 'Arrears', date_ as 'Date' FROM payment ";
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
         //   JOptionPane.showMessageDialog( null, e);
        }
        }
 
      public void arrears(){
      String old = String.valueOf(hostel.getText());
         
      float old_1 = Float.parseFloat(old);
      
      float amount = Float.parseFloat(amt.getText());
      
      float grand = old_1 -amount;
      arears.setText((Float.toString(grand)));
      
      
      
      

  
     
      }
      
      public void arrears_1(){
      String new_toal = String.valueOf(amount_paid.getText());
      float total = Float.parseFloat(new_toal);
      
      float amt = Float.parseFloat(new_amt.getText());
      
      float total_amt_paid = amt +total;
      
      grand_amt.setText((Float.toString(total_amt_paid)));
          
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bed = new javax.swing.JTextField();
        hostel = new javax.swing.JTextField();
        hostel_fee_1 = new javax.swing.JTextField();
        amt = new javax.swing.JTextField();
        date_txt = new javax.swing.JTextField();
        room = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        new_amt = new javax.swing.JTextField();
        bed_1 = new javax.swing.JTextField();
        room_1 = new javax.swing.JTextField();
        date_txt_1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        full_name = new javax.swing.JTextField();
        full_name_1 = new javax.swing.JTextField();
        arreas_1 = new javax.swing.JTextField();
        amount_paid = new javax.swing.JTextField();
        payment = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        Update_btn = new javax.swing.JButton();
        del_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        l_name = new javax.swing.JTextField();
        f_name = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        amt_paid = new javax.swing.JTextField();
        amt_left = new javax.swing.JTextField();
        new_ARREAS = new javax.swing.JTextField();
        pay = new javax.swing.JTextField();
        balance = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        grand_toal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        search = new javax.swing.JTextField();
        grand_amt = new javax.swing.JTextField();
        cust_id = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        arears = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        minimize = new javax.swing.JLabel();
        minus_fill = new javax.swing.JLabel();
        logout_fill = new javax.swing.JLabel();
        logout_lite = new javax.swing.JLabel();
        cancel_lite = new javax.swing.JLabel();
        cancel_fill = new javax.swing.JLabel();
        back_lite = new javax.swing.JLabel();
        back_fill = new javax.swing.JLabel();
        help_lite = new javax.swing.JLabel();
        help_fill = new javax.swing.JLabel();

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(219, 231, 217));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setBackground(new java.awt.Color(187, 224, 190));
        jTable2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setRowHeight(25);
        jTable2.setRowMargin(2);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 330, 280));

        jTextField1.setBackground(new java.awt.Color(219, 231, 217));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setBorder(null);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 220, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_20px_3.png"))); // NOI18N
        jLabel11.setText("Search");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 220, 10));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 360, 350));

        jPanel4.setBackground(new java.awt.Color(219, 231, 217));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Bed_20px.png"))); // NOI18N
        jLabel3.setText("Bed No:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Bill_20px.png"))); // NOI18N
        jLabel4.setText("Hostel Fee:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Calendar_20px_1.png"))); // NOI18N
        jLabel7.setText("Date:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Bed_20px.png"))); // NOI18N
        jLabel8.setText("Room No:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        bed.setEditable(false);
        bed.setBackground(new java.awt.Color(219, 231, 217));
        bed.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        bed.setBorder(null);
        bed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(bed, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 180, 40));

        hostel.setEditable(false);
        hostel.setBackground(new java.awt.Color(219, 231, 217));
        hostel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        hostel.setBorder(null);
        hostel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(hostel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 180, 40));

        hostel_fee_1.setEditable(false);
        hostel_fee_1.setBackground(new java.awt.Color(219, 231, 217));
        hostel_fee_1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        hostel_fee_1.setForeground(new java.awt.Color(0, 0, 0));
        hostel_fee_1.setBorder(null);
        hostel_fee_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(hostel_fee_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 180, 40));

        amt.setBackground(new java.awt.Color(219, 231, 217));
        amt.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        amt.setBorder(null);
        amt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amtKeyTyped(evt);
            }
        });
        jPanel4.add(amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 180, 40));

        date_txt.setEditable(false);
        date_txt.setBackground(new java.awt.Color(219, 231, 217));
        date_txt.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        date_txt.setBorder(null);
        date_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(date_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 120, 40));

        room.setEditable(false);
        room.setBackground(new java.awt.Color(219, 231, 217));
        room.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        room.setBorder(null);
        room.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(room, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 180, 40));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 180, 10));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 180, 10));
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 180, 10));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 140, 10));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Amount Paying:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 180, 10));

        new_amt.setBackground(new java.awt.Color(219, 231, 217));
        new_amt.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        new_amt.setBorder(null);
        new_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                new_amtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                new_amtKeyTyped(evt);
            }
        });
        jPanel4.add(new_amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 180, 40));

        bed_1.setEditable(false);
        bed_1.setBackground(new java.awt.Color(219, 231, 217));
        bed_1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        bed_1.setToolTipText("");
        bed_1.setBorder(null);
        bed_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(bed_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 180, 40));

        room_1.setEditable(false);
        room_1.setBackground(new java.awt.Color(219, 231, 217));
        room_1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        room_1.setBorder(null);
        room_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(room_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 180, 40));

        date_txt_1.setEditable(false);
        date_txt_1.setBackground(new java.awt.Color(219, 231, 217));
        date_txt_1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        date_txt_1.setBorder(null);
        date_txt_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(date_txt_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 180, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Money_20px.png"))); // NOI18N
        jLabel5.setText("Amount Paid");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Name_20px_1.png"))); // NOI18N
        jLabel6.setText("Full name:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 290, -1));

        full_name.setEditable(false);
        full_name.setBackground(new java.awt.Color(219, 231, 217));
        full_name.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        full_name.setBorder(null);
        full_name.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(full_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 290, 50));

        full_name_1.setEditable(false);
        full_name_1.setBackground(new java.awt.Color(219, 231, 217));
        full_name_1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        full_name_1.setBorder(null);
        full_name_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(full_name_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 29, 290, 50));

        arreas_1.setEditable(false);
        arreas_1.setBackground(new java.awt.Color(219, 231, 217));
        arreas_1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        arreas_1.setForeground(new java.awt.Color(0, 0, 0));
        arreas_1.setBorder(null);
        arreas_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(arreas_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 140, 40));

        amount_paid.setEditable(false);
        amount_paid.setBackground(new java.awt.Color(219, 231, 217));
        amount_paid.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        amount_paid.setBorder(null);
        amount_paid.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(amount_paid, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 140, 40));

        payment.setBackground(new java.awt.Color(219, 231, 217));
        payment.setForeground(new java.awt.Color(0, 102, 0));
        payment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Cash in Hand_20px_1.png"))); // NOI18N
        payment.setText("Pay");
        payment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });
        jPanel4.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 80, 60));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Money_20px.png"))); // NOI18N
        jLabel10.setText("Arrears");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        refresh.setBackground(new java.awt.Color(219, 231, 217));
        refresh.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        refresh.setForeground(new java.awt.Color(0, 102, 0));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Refresh_20px.png"))); // NOI18N
        refresh.setText("Refresh");
        refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel4.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 110, 40));

        Update_btn.setBackground(new java.awt.Color(219, 231, 217));
        Update_btn.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Update_btn.setForeground(new java.awt.Color(0, 102, 0));
        Update_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit Property_20px_2.png"))); // NOI18N
        Update_btn.setText("Update");
        Update_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_btnActionPerformed(evt);
            }
        });
        jPanel4.add(Update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 110, 40));

        del_btn.setBackground(new java.awt.Color(219, 231, 217));
        del_btn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        del_btn.setForeground(new java.awt.Color(0, 102, 0));
        del_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Trash_20px.png"))); // NOI18N
        del_btn.setText("Delete");
        del_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        del_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_btnActionPerformed(evt);
            }
        });
        jPanel4.add(del_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, 40));

        save_btn.setBackground(new java.awt.Color(219, 231, 217));
        save_btn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        save_btn.setForeground(new java.awt.Color(0, 102, 0));
        save_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_20px_1.png"))); // NOI18N
        save_btn.setText("Save");
        save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });
        jPanel4.add(save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 110, 40));
        jPanel4.add(l_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, -1, -1));
        jPanel4.add(f_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));
        jPanel4.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 180, 10));
        jPanel4.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 140, 10));
        jPanel4.add(amt_paid, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 110, 30));
        jPanel4.add(amt_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 130, 30));
        jPanel4.add(new_ARREAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 80, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 630, 350));

        pay.setEditable(false);
        jPanel1.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));
        jPanel1.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 370, 50, 30));

        jTable4.setBackground(new java.awt.Color(187, 224, 190));
        jTable4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable4.setForeground(new java.awt.Color(0, 0, 0));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.setRowHeight(25);
        jTable4.setRowMargin(2);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable4MouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 1010, 200));
        jPanel1.add(grand_toal, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 390, 80, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_20px_3.png"))); // NOI18N
        jLabel12.setText("Search");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 240, 10));

        search.setBackground(new java.awt.Color(187, 224, 190));
        search.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        search.setForeground(new java.awt.Color(0, 0, 0));
        search.setBorder(null);
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 240, 30));
        jPanel1.add(grand_amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 350, 70, 20));
        jPanel1.add(cust_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 360, 20, 40));
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 90, 20));

        fname.setBackground(new java.awt.Color(219, 231, 217));
        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 50, 10));
        jPanel1.add(arears, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1030, 620));

        jTabbedPane1.addTab("Payment", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 580, 540));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print_20px_3.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 140, 150));

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 0, 70)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 0));
        jLabel18.setText("JODOK ");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 0));
        jLabel17.setText("HOSTEL");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        jSeparator11.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator11.setForeground(new java.awt.Color(0, 102, 51));
        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 30, 180));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 630));

        jTabbedPane1.addTab("Reciept", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1040, 730));

        jPanel5.setBackground(new java.awt.Color(219, 231, 217));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Minus_15px_1.png"))); // NOI18N
        minimize.setToolTipText("Resize down");
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        jPanel5.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -10, -1, 40));

        minus_fill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minus_fill.png"))); // NOI18N
        minus_fill.setToolTipText("Resize down");
        minus_fill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minus_fill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus_fillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minus_fillMouseEntered(evt);
            }
        });
        jPanel5.add(minus_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 20));

        logout_fill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Logout Rounded Left_15px_3.png"))); // NOI18N
        logout_fill.setToolTipText("Logout");
        logout_fill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout_fill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_fillMouseClicked(evt);
            }
        });
        jPanel5.add(logout_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        logout_lite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Logout Rounded Left_15px_4.png"))); // NOI18N
        logout_lite.setToolTipText("Logout");
        logout_lite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout_lite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_liteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logout_liteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logout_liteMouseExited(evt);
            }
        });
        jPanel5.add(logout_lite, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        cancel_lite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Cancel_15px_4.png"))); // NOI18N
        cancel_lite.setToolTipText("Close");
        cancel_lite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel_lite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_liteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel_liteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel_liteMouseExited(evt);
            }
        });
        jPanel5.add(cancel_lite, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 20));

        cancel_fill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Cancel_15px_3.png"))); // NOI18N
        cancel_fill.setToolTipText("Close");
        cancel_fill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel_fill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_fillMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel_fillMouseEntered(evt);
            }
        });
        jPanel5.add(cancel_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 20));

        back_lite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Go Back_15px_2.png"))); // NOI18N
        back_lite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_liteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back_liteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back_liteMouseExited(evt);
            }
        });
        jPanel5.add(back_lite, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 20));

        back_fill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Go Back_15px_1.png"))); // NOI18N
        back_fill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_fillMouseClicked(evt);
            }
        });
        jPanel5.add(back_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 20));

        help_lite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Help_15px_1.png"))); // NOI18N
        help_lite.setToolTipText("");
        help_lite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                help_liteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                help_liteMouseExited(evt);
            }
        });
        jPanel5.add(help_lite, new org.netbeans.lib.awtextra.AbsoluteConstraints(1015, 0, 20, 20));

        help_fill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Help_15px.png"))); // NOI18N
        jPanel5.add(help_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1015, 0, 20, 20));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 20));

        setSize(new java.awt.Dimension(1034, 682));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    help_fill.setVisible(false);
        minus_fill.setVisible(false);
        cancel_fill.setVisible(false);
        logout_fill.setVisible(false);
        back_fill.setVisible(false);
        amt.setEnabled(false);
        save_btn.setEnabled(false);
        Update_btn.setEnabled(false);
  
    }//GEN-LAST:event_formWindowActivated

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        save_btn.setEnabled(false);
        amt.setEnabled(true);
         Update_btn.setEnabled(false);
        payment.setEnabled(true);
          jLabel5.setVisible(false);
         jLabel10.setVisible(false);
        amount_paid.setVisible(false);
        arreas_1.setVisible(false);
        full_name.setVisible(true);
        full_name_1.setVisible(false);
        date_txt.setVisible(true);
        date_txt_1.setVisible(false);
        room.setVisible(true);
        room_1.setVisible(false);
        bed_1.setVisible(false);
        bed.setVisible(true);
        new_amt.setVisible(false);
        amt.setVisible(true);
       
        hostel_fee_1.setVisible(false);
        hostel.setVisible(true);
          
        try{

            int row = jTable2.getSelectedRow();
            String Table_click=(jTable2.getModel().getValueAt(row,0).toString());

            String sql ="SELECT * FROM new_hosteler WHERE  hosteler_id = '"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){

                  String dead = rs.getString("hosteler_id");
                cust_id.setText(dead);
                
                String layer = rs.getString("roo_no");
                room.setText(layer);

                String pen = rs.getString("bed_no");
                bed.setText(pen);

                String cage = rs.getString("hostel_fee");
                hostel.setText(cage);

            String Birds= rs.getString("fname");
              fname.setText(Birds);
              
                String Bird= rs.getString("lname");
              lname.setText(Bird);
              
              full_name.setText(Birds +" "+Bird);

              

       
            }

        }
        catch (Exception e){
      //      JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed

 //     double amt_1 = Double.parseDouble(amt.getText());
      
      if(amt.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Enter The Amount");
      
          
      }
      else{
          arrears();
            try{

            String sql = "Insert into payment( fname, lname, room_no, bed_no, hostel_fee, amt_paid, arreas,date_) values (?,?,?,?,?,?,?,?)";

            pst=conn.prepareStatement(sql);
            pst.setString(1, fname.getText());
            pst.setString(2, lname.getText());
             pst.setString(3, room.getText());
            pst.setString(4, bed.getText());
            pst.setString(5, hostel.getText());             
            pst.setString(6, amt.getText());
              pst.setString(7, arears.getText());
            pst.setString(8, date_txt.getText());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Success");

            

            

        }
        catch(Exception e){

      //      JOptionPane.showMessageDialog(null, e);
        }
          
             jTextArea1.setText(null);
            
        int ref = 1254 + (int) (Math.random()*4158);

        Calendar timer = Calendar.getInstance();
        timer.getTime();
        SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
        tTime.format(timer.getTime());
        SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-yyyy");
        Tdate.format(timer.getTime());

        jTextArea1.append(
               "======================================\n"
            + "\t JODOK HOSTEL\n"
            + "-------------------------------------------------------------------\n"
            + "Reference Number\t"+ref+"\n"
            + "======================================\n"
            + "======================================\n"
            + "Name:\t\t"+String.valueOf(full_name.getText()) +"\n"
            +"Room No:\t\t"+room.getText()+"\n"
            + "Bed No:\t\t"+bed.getText()+"\n"
            + "Hostel Fee:\t\t"+hostel.getText()+"\n"
            + "Amount Paid:\t\t"+amt.getText()+"\n"
            + "======================================\n"
            + "Arreas:\t\t"+arears.getText()+"\n"
            + "======================================\n"
            + "Date:"+date_txt.getText()+"\t"+"Time:"+tTime.format(timer.getTime())+"\n"
            + "======================================\n\n"
            + "Signature:\t\t.....................\n\n"
            + "************************************************************\n"
            + "\t THANK YOU..."
        );
        
            full_name.setText(null);
            fname.setText(null);
             lname.setText(null);
            arears.setText(null);
            room.setText(null);
           
            bed.setText(null);
            amt.setText(null);
            hostel.setText(null);
        
        
          
      }
 
          
        
        
    

    }//GEN-LAST:event_paymentActionPerformed

    private void Update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_btnActionPerformed
        // TODO add your handling code here:
        
        int row=jTable4.getSelectedRow();

        if(row==-1){

            JOptionPane.showMessageDialog(null, " Please Select a Row and Click on Update ");

        }
        else{
        save_btn.setEnabled(true);
        double amt_1 = Double.parseDouble(arreas_1.getText());
              if(amt_1==0){
        save_btn.setEnabled(false);
       new_amt.setEnabled(false);
        }
        else {
        new_amt.setEnabled(true);
        }
        }
      

    }//GEN-LAST:event_Update_btnActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        Update_table_1();
        save_btn.setEnabled(false);
    }//GEN-LAST:event_refreshActionPerformed

    private void del_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_btnActionPerformed
        // TODO add your handling code here:
        
          int row=jTable4.getSelectedRow();
            
            if(row==-1){
                
                JOptionPane.showMessageDialog(null, "No Row Selected");
            
            }
            else{
                
                 int c = JOptionPane.showConfirmDialog(null, "Do you realy wanna Delete","Delete",JOptionPane.YES_NO_OPTION);
      
        if(c==0){
        String sql =" DELETE FROM payment WHERE pay_id =?";
        try{
        
            pst=conn.prepareStatement(sql);
            pst.setString(1,pay.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, " Deleted Successfully");
            
    
        }

        catch(Exception e){
         //   JOptionPane.showMessageDialog(null, e);
        
        }
        }
        
            }
    }//GEN-LAST:event_del_btnActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
         Update_btn.setEnabled(true);
        new_amt.setEnabled(false);
        payment.setEnabled(false);
          jLabel5.setVisible(true);
         jLabel10.setVisible(true);
        amount_paid.setVisible(true);
        arreas_1.setVisible(true);
         full_name.setVisible(false);
        full_name_1.setVisible(true);
          date_txt.setVisible(false);
        date_txt_1.setVisible(true);
          room.setVisible(false);
        room_1.setVisible(true);
        bed_1.setVisible(true);
        bed.setVisible(false);
        hostel.setVisible(false);
        hostel_fee_1.setVisible(true);
      new_amt.setVisible(true);
        amt.setVisible(false);
          try{

            int row = jTable4.getSelectedRow();
            String Table_click=(jTable4.getModel().getValueAt(row,0).toString());

            String sql ="SELECT * FROM payment WHERE  pay_id = '"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){

                String id = rs.getString("pay_id");
                pay.setText(id);
                
                String pen = rs.getString("arreas");
                arreas_1.setText(pen);
                
                String hoste = rs.getString("amt_paid");
                amount_paid.setText(hoste);
                String bed2 = rs.getString("bed_no");
                bed_1.setText(bed2);
                
                String room2 = rs.getString("room_no");
                room_1.setText(room2);
                
                String fee = rs.getString("hostel_fee");
                hostel_fee_1.setText(fee);
                
                String date = rs.getString("date_");
                date_txt_1.setText(date);
                
                String name = rs.getString("fname");
                f_name.setText(name);
                
                String name_1 = rs.getString("lname");
                l_name.setText(name_1);
                
                full_name_1.setText(name+ " "+name_1);
   
            }

        }
        catch (Exception e){
      //      JOptionPane.showMessageDialog(null, e);
        }
            finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
    }//GEN-LAST:event_jTable4MouseClicked

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        // TODO add your handling code here:
        
        
         arreas();
        
         arrears_1();
          amt_left.setText(String.valueOf(arreas_1.getText()));
         amt_paid.setText(String.valueOf(new_amt.getText()));
         
         String left = String.valueOf(amt_left.getText());
         
         float left_1 = Float.parseFloat(left);
         String paid = String.valueOf(amt_paid.getText());
         
          float paid_1 = Float.parseFloat(paid);
     double new_arrears = left_1-paid_1;
         new_ARREAS.setText((Double.toString(new_arrears)));
       try{
                String value1=pay.getText();
                String value2=String.valueOf(balance.getText());
                String value3=String.valueOf(grand_amt.getText());
               

                String sql ="update payment set pay_id='"+value1+"', arreas='"+value2+"', amt_paid='"+value3+"'  where pay_id='"+value1+"'";

                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Successful");
                
                new_amt.setText(null);
                amount_paid.setText(null);
                arreas_1.setText(null);
                
             
            }

            catch(Exception e){

      //          JOptionPane.showMessageDialog(null, e);
            }
       
       
              finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
       
       jTextArea1.setText(null);
       
       int ref = 1254 + (int) (Math.random()*4158);

        Calendar timer = Calendar.getInstance();
        timer.getTime();
        SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
        tTime.format(timer.getTime());
        SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-yyyy");
        Tdate.format(timer.getTime());

        jTextArea1.append(
               "======================================\n"
            + "\t JODOK HOSTEL\n"
            + "----------------------------------------------------------------------\n"
            + "Reference Number\t"+ref+"\n"
            + "======================================\n"
            + "======================================\n"
            + "Name:\t\t"+String.valueOf(full_name_1.getText()) +"\n"
            +"Room No:\t\t"+room_1.getText()+"\n"
            + "Bed No:\t\t"+bed_1.getText()+"\n"
            + "Hostel Fee:\t\t"+hostel_fee_1.getText()+"\n"
            
            + "Amount Left:\t\t"+amt_left.getText()+"\n"
            + "======================================\n"
            + "Amount Paid:\t\t"+amt_paid.getText()+"\n"
            + "======================================\n"
            + "Arreas:\t\t"+new_ARREAS.getText()+"\n"
            + "======================================\n"
            + "Date:"+date_txt.getText()+"\t"+"Time:"+tTime.format(timer.getTime())+"\n"
            + "======================================\n\n"
            + "Signature:\t\t.....................\n\n"
            + "************************************************************\n"
            + "\t THANK YOU...");
    }//GEN-LAST:event_save_btnActionPerformed

    private void jTable4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseEntered

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        
        String txt=jTextField1.getText();
        filter (txt);
        
        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void amtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amtKeyTyped
        // TODO add your handling code here:
        
        char check = evt.getKeyChar();
        
        if(!
                (Character.isDigit(check) 
                || check ==KeyEvent.VK_ENTER 
                 || check ==KeyEvent.VK_DELETE
                || check == KeyEvent.VK_BACKSPACE)
               )
        {
            
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Figures Only");
        
        }
        
    }//GEN-LAST:event_amtKeyTyped

    private void new_amtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_new_amtKeyTyped
        // TODO add your handling code here:
        char check = evt.getKeyChar();
        
        if(!
                (Character.isDigit(check) 
                || check ==KeyEvent.VK_ENTER 
                 || check ==KeyEvent.VK_DELETE
                || check == KeyEvent.VK_BACKSPACE)
               )
        {
            
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Figures Only");
        
        }
    }//GEN-LAST:event_new_amtKeyTyped

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        String txt_1=search.getText();
        filter_1 (txt_1);
    }//GEN-LAST:event_searchKeyReleased

    private void new_amtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_new_amtKeyPressed
        // TODO add your handling code here:
        
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
       
           arreas();
        
         arrears_1();
          amt_left.setText(String.valueOf(arreas_1.getText()));
         amt_paid.setText(String.valueOf(new_amt.getText()));
         
         String left = String.valueOf(amt_left.getText());
         
         float left_1 = Float.parseFloat(left);
         String paid = String.valueOf(amt_paid.getText());
         
          float paid_1 = Float.parseFloat(paid);
     double new_arrears = left_1-paid_1;
         new_ARREAS.setText(Double.toString(new_arrears));
       try{
                String value1=pay.getText();
                String value2=String.valueOf(balance.getText());
                String value3=String.valueOf(grand_amt.getText());
               

                String sql ="update payment set pay_id='"+value1+"', arreas='"+value2+"', amt_paid='"+value3+"'  where pay_id='"+value1+"'";

                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Successful");
                
                new_amt.setText(null);
                amount_paid.setText(null);
                arreas_1.setText(null);
                
             
            }

            catch(Exception e){

          //      JOptionPane.showMessageDialog(null, e);
            }
       
       
              finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
       
       jTextArea1.setText(null);
       
       int ref = 1254 + (int) (Math.random()*4158);

        Calendar timer = Calendar.getInstance();
        timer.getTime();
        SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
        tTime.format(timer.getTime());
        SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-yyyy");
        Tdate.format(timer.getTime());

        jTextArea1.append(
               "======================================\n"
            + "\t JODOK HOSTEL\n"
            + "----------------------------------------------------------------------\n"
            + "Reference Number\t"+ref+"\n"
            + "======================================\n"
            + "======================================\n"
            + "Name:\t\t"+String.valueOf(full_name_1.getText()) +"\n"
            +"Room No:\t\t"+room_1.getText()+"\n"
            + "Bed No:\t\t"+bed_1.getText()+"\n"
            + "Hostel Fee:\t\t"+hostel_fee_1.getText()+"\n"
            
            + "Amount Left:\t\t"+amt_left.getText()+"\n"
            + "======================================\n"
            + "Amount Paid:\t\t"+amt_paid.getText()+"\n"
            + "======================================\n"
            + "Arreas:\t\t"+new_ARREAS.getText()+"\n"
            + "======================================\n"
            + "Date:"+date_txt.getText()+"\t"+"Time:"+tTime.format(timer.getTime())+"\n"
            + "======================================\n\n"
            + "Signature:\t\t.....................\n\n"
            + "************************************************************\n"
            + "\t THANK YOU...");
      
       }
    }//GEN-LAST:event_new_amtKeyPressed

    private void amtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amtKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
        if(amt.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Enter The Amount");
      
          
      }
      else{
          arrears();
            try{

            String sql = "Insert into payment( fname, lname, room_no, bed_no, hostel_fee, amt_paid,arreas, date_) values (?,?,?,?,?,?,?,?)";

            pst=conn.prepareStatement(sql);
            pst.setString(1, fname.getText());
            pst.setString(2, lname.getText());
             pst.setString(3, room.getText());
            pst.setString(4, bed.getText());
            pst.setString(5, hostel.getText());             
            pst.setString(6, amt.getText());
              pst.setString(7, arears.getText());
            pst.setString(8, date_txt.getText());

            pst.execute();

            JOptionPane.showMessageDialog(null, "New Infomation Added");

            

            

        }
        catch(Exception e){

          //  JOptionPane.showMessageDialog(null, e);
        }
          
             jTextArea1.setText(null);
            
        int ref = 1254 + (int) (Math.random()*4158);

        Calendar timer = Calendar.getInstance();
        timer.getTime();
        SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
        tTime.format(timer.getTime());
        SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-yyyy");
        Tdate.format(timer.getTime());

        jTextArea1.append(
               "======================================\n"
            + "\t JODOK HOSTEL\n"
            + "----------------------------------------------------------------------\n"
            + "Reference Number\t"+ref+"\n"
            + "======================================\n"
            + "======================================\n"
            + "Name:\t\t"+String.valueOf(full_name.getText()) +"\n"
            +"Room No:\t\t"+room.getText()+"\n"
            + "Bed No:\t\t"+bed.getText()+"\n"
            + "Hostel Fee:\t\t"+hostel.getText()+"\n"
            + "Amount Paid:\t\t"+amt.getText()+"\n"
            + "======================================\n"
            + "Arreas:\t\t"+arears.getText()+"\n"
            + "======================================\n"
            + "Date:"+date_txt.getText()+"\t"+"Time:"+tTime.format(timer.getTime())+"\n"
            + "======================================\n\n"
            + "Signature:\t\t.....................\n\n"
            + "************************************************************\n"
            + "\t THANK YOU..."
        );
        
            full_name.setText(null);
            fname.setText(null);
             lname.setText(null);
            arears.setText(null);
            room.setText(null);
           
            bed.setText(null);
            amt.setText(null);
            hostel.setText(null);
        
        
          
      }
        }
    }//GEN-LAST:event_amtKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


        if(jTextArea1.getText().isEmpty())
                {
                
                JOptionPane.showMessageDialog(null, "Receipt is Blank");
                }
        else{
        try {
             Boolean complete = jTextArea1.print();
             if(complete){
             
                 JOptionPane.showMessageDialog(null, "Success");
             }
             else{
                 JOptionPane.showMessageDialog(null, "Printing...");
             }
         } catch (PrinterException ex) {
             Logger.getLogger(payment.class.getName()).log(Level.SEVERE, null, ex);
         }
            
        }
         
         
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        
        xMouse= evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        // TODO add your handling code here:
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
        // TODO add your handling code here:

        minus_fill.setVisible(true);
        minimize.setVisible(false);
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        // TODO add your handling code here:

        minus_fill.setVisible(false);
        minimize.setVisible(true);
    }//GEN-LAST:event_minimizeMouseExited

    private void minus_fillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus_fillMouseClicked
        // TODO add your handling code here:

        this.setState(ICONIFIED);
    }//GEN-LAST:event_minus_fillMouseClicked

    private void minus_fillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus_fillMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_minus_fillMouseEntered

    private void logout_fillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_fillMouseClicked
        // TODO add your handling code here:

        setVisible(false);
        login_form lf = new login_form();
        lf.setVisible(true);
    }//GEN-LAST:event_logout_fillMouseClicked

    private void logout_liteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_liteMouseClicked
        // TODO add your handling code here:

        setVisible(false);
        login_form lf = new login_form();
        lf.setVisible(true);
    }//GEN-LAST:event_logout_liteMouseClicked

    private void logout_liteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_liteMouseEntered
        // TODO add your handling code here:

        logout_fill.setVisible(true);
        logout_lite.setVisible(false);
    }//GEN-LAST:event_logout_liteMouseEntered

    private void logout_liteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_liteMouseExited
        // TODO add your handling code here:

        logout_fill.setVisible(false);
        logout_lite.setVisible(true);
    }//GEN-LAST:event_logout_liteMouseExited

    private void cancel_liteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_liteMouseClicked
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_cancel_liteMouseClicked

    private void cancel_liteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_liteMouseEntered
        // TODO add your handling code here:
        cancel_fill.setToolTipText("Close");
        cancel_fill.setVisible(true);

        cancel_lite.setVisible(false);
        cancel_lite.setToolTipText("Close");
    }//GEN-LAST:event_cancel_liteMouseEntered

    private void cancel_liteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_liteMouseExited
        // TODO add your handling code here:
        cancel_fill.setVisible(false);
        cancel_lite.setVisible(true);
    }//GEN-LAST:event_cancel_liteMouseExited

    private void cancel_fillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_fillMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_cancel_fillMouseClicked

    private void cancel_fillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_fillMouseEntered
        // TODO add your handling code here:
        cancel_fill.setToolTipText("Close");
    }//GEN-LAST:event_cancel_fillMouseEntered

    private void back_liteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_liteMouseClicked
        // TODO add your handling code here:

        setVisible(false);
        mainPage lf = new mainPage();
        lf.setVisible(true);
    }//GEN-LAST:event_back_liteMouseClicked

    private void back_liteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_liteMouseEntered
        // TODO add your handling code here:
        back_fill.setVisible(true);
        back_lite.setVisible(false);
    }//GEN-LAST:event_back_liteMouseEntered

    private void back_liteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_liteMouseExited
        // TODO add your handling code here:
        back_fill.setVisible(false);
        back_lite.setVisible(true);
    }//GEN-LAST:event_back_liteMouseExited

    private void back_fillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_fillMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        mainPage lf = new mainPage();
        lf.setVisible(true);
    }//GEN-LAST:event_back_fillMouseClicked

    private void help_liteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_help_liteMouseEntered
        // TODO add your handling code here:
        help_fill.setVisible(true);
        help_lite.setVisible(false);
    }//GEN-LAST:event_help_liteMouseEntered

    private void help_liteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_help_liteMouseExited
        // TODO add your handling code here:
        help_fill.setVisible(false);
        help_lite.setVisible(true);
    }//GEN-LAST:event_help_liteMouseExited

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
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new payment().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update_btn;
    private javax.swing.JTextField amount_paid;
    private javax.swing.JTextField amt;
    private javax.swing.JTextField amt_left;
    private javax.swing.JTextField amt_paid;
    private javax.swing.JTextField arears;
    private javax.swing.JTextField arreas_1;
    private javax.swing.JLabel back_fill;
    private javax.swing.JLabel back_lite;
    private javax.swing.JTextField balance;
    private javax.swing.JTextField bed;
    private javax.swing.JTextField bed_1;
    private javax.swing.JLabel cancel_fill;
    private javax.swing.JLabel cancel_lite;
    private javax.swing.JTextField cust_id;
    private javax.swing.JTextField date_txt;
    private javax.swing.JTextField date_txt_1;
    private javax.swing.JButton del_btn;
    private javax.swing.JTextField f_name;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField full_name;
    private javax.swing.JTextField full_name_1;
    private javax.swing.JTextField grand_amt;
    private javax.swing.JTextField grand_toal;
    private javax.swing.JLabel help_fill;
    private javax.swing.JLabel help_lite;
    private javax.swing.JTextField hostel;
    private javax.swing.JTextField hostel_fee_1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField l_name;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel logout_fill;
    private javax.swing.JLabel logout_lite;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel minus_fill;
    private javax.swing.JTextField new_ARREAS;
    private javax.swing.JTextField new_amt;
    private javax.swing.JTextField pay;
    private javax.swing.JButton payment;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField room;
    private javax.swing.JTextField room_1;
    private javax.swing.JButton save_btn;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}

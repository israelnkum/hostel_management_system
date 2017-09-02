/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package All_pack;

/**
 *
 * @author oSikaNi iSraeL
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
public class expenses extends javax.swing.JFrame {
     DefaultTableModel model_1;
     DefaultTableModel model_2;
     DefaultTableModel model_3;
     Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    
    int xMouse;
    int yMouse;

    /**
     * Creates new form expenses
     */
    public expenses() {
        
        conn = java_connection.getConnection();
        initComponents();
        biil_id.setVisible(false);
        time_bill.setVisible(false);
        bill_date.setVisible(false);
        maintani_id.setVisible(false);
        maint_date.setVisible(false);
        maint_time.setVisible(false);
        other_id.setVisible(false);
        others_date_update.setVisible(false);
        others_time_update.setVisible(false);
        
        bill_search.setBackground(new Color(0,0,0,0));
        maint_search.setBackground(new Color(0,0,0,0));    
        other_search.setBackground(new Color(0,0,0,0));    
    Update_bill_table();
    update_maintenace_table();
    update_othrs();
        currentDate();
       total_bills();
       total_others();
       total_maintenace();
       
    }
    
    //String sql ="SELECT bill_id as 'ID', description as 'Description ', amount_used as 'Amount Used', date_used as 'Date', time_ as 'Time'  FROM bills"
    
         private void filter_bill (String sql){
    
          model_1 =(DefaultTableModel) bill_table.getModel();
     
         TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model_1);
         bill_table.setRowSorter(tr);
         tr.setRowFilter(RowFilter.regexFilter(sql));
     }
         
          private void filter_maintenace (String sql){
    
          model_2 =(DefaultTableModel) maintenace_table.getModel();
     
         TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model_2);
         maintenace_table.setRowSorter(tr);
         tr.setRowFilter(RowFilter.regexFilter(sql));
     }
          
          
          private void filter_others (String sql){
    
          model_3 =(DefaultTableModel) othrs.getModel();
     
         TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model_3);
         othrs.setRowSorter(tr);
         tr.setRowFilter(RowFilter.regexFilter(sql));
     }
   private void Update_bill_table(){
    
        try {
          String sql ="SELECT bill_id as 'ID', description as 'Description', amount_used as 'Amount Used', date_used as 'Date', time_ as 'Time'  FROM bills";
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            bill_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
    //   JOptionPane.showMessageDialog(null, "Check your internet");
  
        }
        }
   
   private void update_maintenace_table(){
    
        try {
          String sql ="SELECT maintenance_id  as 'ID', description as 'Description', amt_used as 'Amount Used', date_used as 'Date', time_ as 'Time'  FROM maintenace";
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            maintenace_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
      //      JOptionPane.showMessageDialog(null, "Check your internet");
        }
        }
   
    private void update_othrs(){
    
        try {
          String sql ="SELECT others_id  as 'ID', description as 'Description', amt_used as 'Amount Used', date_used as 'Date', time_ as 'Time'  FROM others";
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            othrs.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
  //          JOptionPane.showMessageDialog(null, "Check your internet");
        }
        }
   
    
        
    public void currentDate(){
    
    
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        bill_date.setText(year+"/"+(month+1)+"/"+day);
        maint_date.setText(year+"/"+(month+1)+"/"+day);
    others_date_update.setText(year+"/"+(month+1)+"/"+day);
        

         Date date = new Date();
         String strDateFormat = "HH:mm:ss a";
         SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
          time_bill.setText(sdf.format(date));
          maint_time.setText(sdf.format(date));
      others_time_update.setText(sdf.format(date));
    }

     public void total_bills(){

             float sum =0;
  
            for (int i=0; i < bill_table.getRowCount(); i++){
            
            sum  = sum   + Float.parseFloat(bill_table.getValueAt(i, 2).toString());
        
            }
            
      jLabel30.setText("GH¢ "+(Float.toString(sum)));
    
        }
     
      public void total_maintenace(){

             float sum =0;
  
            for (int i=0; i < maintenace_table.getRowCount(); i++){
            
            sum  = sum   + Float.parseFloat(maintenace_table.getValueAt(i, 2).toString());
        
            }
            
      jLabel25.setText("GH¢ "+(Float.toString(sum)));
    
        }
      
      public void total_others(){

             float sum =0;
  
            for (int i=0; i < othrs.getRowCount(); i++){
            
            sum  = sum   + Float.parseFloat(othrs.getValueAt(i, 2).toString());
        
            }
            
      jLabel2.setText("GH¢ "+(Float.toString(sum)));
    
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        other_tbl = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bill_table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        bill_search = new javax.swing.JTextField();
        dis_update_bill = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        amt_update_bill = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        save_btn_bill = new javax.swing.JButton();
        update_btn_bill = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        time_bill = new javax.swing.JTextField();
        bill_date = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        biil_id = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        maintenace_table = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        amt_update_maint = new javax.swing.JTextField();
        dis_update_maint = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        maint_search = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        update_btn_maint = new javax.swing.JButton();
        save_btn_maint = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        maint_time = new javax.swing.JTextField();
        maint_date = new javax.swing.JTextField();
        maintani_id = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        othrs = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        other_search = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        other_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        amt_update = new javax.swing.JTextField();
        dis_update = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        others_time_update = new javax.swing.JLabel();
        others_date_update = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
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
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        other_tbl.setForeground(new java.awt.Color(0, 0, 0));
        other_tbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        other_tbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 150));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_20px_3.png"))); // NOI18N
        jLabel3.setText("Search:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 82, 12));
        jLabel5.setText("BILLS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 130, 50));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 200, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 50)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 82, 12));
        jLabel4.setText("J O D O K ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 320, 50));

        jButton5.setBackground(new java.awt.Color(218, 230, 216));
        jButton5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print_20px_3.png"))); // NOI18N
        jButton5.setText("Print");
        jButton5.setIconTextGap(0);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, -1));

        bill_table.setBackground(new java.awt.Color(218, 230, 216));
        bill_table.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bill_table.setForeground(new java.awt.Color(0, 0, 0));
        bill_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        bill_table.setRowHeight(25);
        bill_table.setRowMargin(2);
        bill_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bill_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bill_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 930, 250));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 82, 12));
        jLabel6.setText("H O S T E L");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 130, 70));

        bill_search.setBackground(new java.awt.Color(221, 231, 220));
        bill_search.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bill_search.setForeground(new java.awt.Color(0, 0, 0));
        bill_search.setBorder(null);
        bill_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bill_searchKeyReleased(evt);
            }
        });
        jPanel1.add(bill_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 200, 40));

        dis_update_bill.setBackground(new java.awt.Color(204, 228, 202));
        dis_update_bill.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dis_update_bill.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(dis_update_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 300, 50));

        jLabel22.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setText("Amount Used");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, -1, -1));

        jButton8.setBackground(new java.awt.Color(218, 230, 216));
        jButton8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 0));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add List_20px.png"))); // NOI18N
        jButton8.setText("Add");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        amt_update_bill.setBackground(new java.awt.Color(204, 228, 202));
        amt_update_bill.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        amt_update_bill.setForeground(new java.awt.Color(0, 0, 0));
        amt_update_bill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amt_update_billKeyTyped(evt);
            }
        });
        jPanel1.add(amt_update_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 170, 50));

        jButton1.setBackground(new java.awt.Color(218, 230, 216));
        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Refresh_20px.png"))); // NOI18N
        jButton1.setText("Refresh");
        jButton1.setIconTextGap(0);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 440, -1, 40));

        save_btn_bill.setBackground(new java.awt.Color(218, 230, 216));
        save_btn_bill.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        save_btn_bill.setForeground(new java.awt.Color(0, 0, 0));
        save_btn_bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_20px_1.png"))); // NOI18N
        save_btn_bill.setText("Save");
        save_btn_bill.setIconTextGap(0);
        save_btn_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn_billActionPerformed(evt);
            }
        });
        jPanel1.add(save_btn_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, -1, -1));

        update_btn_bill.setBackground(new java.awt.Color(218, 230, 216));
        update_btn_bill.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        update_btn_bill.setForeground(new java.awt.Color(0, 0, 0));
        update_btn_bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit Property_20px_2.png"))); // NOI18N
        update_btn_bill.setText("Update");
        update_btn_bill.setIconTextGap(0);
        update_btn_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btn_billActionPerformed(evt);
            }
        });
        jPanel1.add(update_btn_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, -1));

        jButton16.setBackground(new java.awt.Color(218, 230, 216));
        jButton16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(0, 0, 0));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Trash_20px.png"))); // NOI18N
        jButton16.setText("Delete");
        jButton16.setIconTextGap(0);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, -1, 40));
        jPanel1.add(time_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 110, 30));
        jPanel1.add(bill_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 110, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 51, 51));
        jLabel26.setText("Description");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 470, -1));
        jPanel1.add(biil_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 110, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 230, 50));

        jLabel31.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 51, 51));
        jLabel31.setText(" Total ");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 980, 1120));

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 51));
        jLabel23.setText("Amount Used");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        other_tbl.addTab("Bills", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 150));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Amount Used");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText("Description");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 82, 12));
        jLabel10.setText("MAINTENANCE");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 240, 40));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 470, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 50)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 82, 12));
        jLabel12.setText("J O D O K ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 250, 50));

        jButton6.setBackground(new java.awt.Color(218, 230, 216));
        jButton6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add List_20px.png"))); // NOI18N
        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, -1));

        maintenace_table.setBackground(new java.awt.Color(218, 230, 216));
        maintenace_table.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        maintenace_table.setForeground(new java.awt.Color(0, 0, 0));
        maintenace_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        maintenace_table.setRowHeight(25);
        maintenace_table.setRowMargin(2);
        maintenace_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintenace_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(maintenace_table);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 930, 250));

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 82, 12));
        jLabel13.setText("H O S T E L");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 130, 50));

        amt_update_maint.setBackground(new java.awt.Color(204, 228, 202));
        amt_update_maint.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        amt_update_maint.setForeground(new java.awt.Color(0, 0, 0));
        amt_update_maint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amt_update_maintKeyTyped(evt);
            }
        });
        jPanel2.add(amt_update_maint, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 170, 50));

        dis_update_maint.setBackground(new java.awt.Color(204, 228, 202));
        dis_update_maint.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dis_update_maint.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(dis_update_maint, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 290, 50));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 200, -1));

        maint_search.setBackground(new java.awt.Color(221, 231, 220));
        maint_search.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        maint_search.setForeground(new java.awt.Color(0, 0, 0));
        maint_search.setBorder(null);
        maint_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maint_searchKeyReleased(evt);
            }
        });
        jPanel2.add(maint_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 200, 40));

        jButton4.setBackground(new java.awt.Color(218, 230, 216));
        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Trash_20px.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.setIconTextGap(0);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 100, 40));

        update_btn_maint.setBackground(new java.awt.Color(218, 230, 216));
        update_btn_maint.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        update_btn_maint.setForeground(new java.awt.Color(0, 0, 0));
        update_btn_maint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit Property_20px_2.png"))); // NOI18N
        update_btn_maint.setText("Update");
        update_btn_maint.setIconTextGap(0);
        update_btn_maint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btn_maintActionPerformed(evt);
            }
        });
        jPanel2.add(update_btn_maint, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 100, -1));

        save_btn_maint.setBackground(new java.awt.Color(218, 230, 216));
        save_btn_maint.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        save_btn_maint.setForeground(new java.awt.Color(0, 0, 0));
        save_btn_maint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_20px_1.png"))); // NOI18N
        save_btn_maint.setText("Save");
        save_btn_maint.setIconTextGap(0);
        save_btn_maint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn_maintActionPerformed(evt);
            }
        });
        jPanel2.add(save_btn_maint, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        jButton9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print_20px_3.png"))); // NOI18N
        jButton9.setText("Print");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 51, 51));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_20px_3.png"))); // NOI18N
        jLabel27.setText("Search:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));
        jPanel2.add(maint_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 110, 30));
        jPanel2.add(maint_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 110, 30));
        jPanel2.add(maintani_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 80, -1));

        jButton17.setBackground(new java.awt.Color(218, 230, 216));
        jButton17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(0, 0, 0));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Refresh_20px.png"))); // NOI18N
        jButton17.setText("Refresh");
        jButton17.setIconTextGap(0);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, -1, 40));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 240, 50));

        jLabel29.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 51, 51));
        jLabel29.setText(" Total ");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 980, 1120));

        other_tbl.addTab("Maintenace", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 150));

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("Total");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 82, 12));
        jLabel18.setText("OTHERS");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 130, 50));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 570, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 50)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 82, 12));
        jLabel19.setText("J O D O K ");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 250, 70));

        othrs.setBackground(new java.awt.Color(218, 230, 216));
        othrs.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        othrs.setForeground(new java.awt.Color(0, 0, 0));
        othrs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        othrs.setRowHeight(25);
        othrs.setRowMargin(2);
        othrs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                othrsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(othrs);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 930, 250));

        jLabel20.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 82, 12));
        jLabel20.setText("H O S T E L");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 130, 70));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 240, -1));

        other_search.setBackground(new java.awt.Color(221, 231, 220));
        other_search.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        other_search.setForeground(new java.awt.Color(0, 0, 0));
        other_search.setBorder(null);
        other_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                other_searchKeyReleased(evt);
            }
        });
        jPanel3.add(other_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 240, 40));

        jButton10.setBackground(new java.awt.Color(218, 230, 216));
        jButton10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 0, 0));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print_20px_3.png"))); // NOI18N
        jButton10.setText("Print");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, 30));

        jButton13.setBackground(new java.awt.Color(218, 230, 216));
        jButton13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 0, 0));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Trash_20px.png"))); // NOI18N
        jButton13.setText("Delete");
        jButton13.setIconTextGap(0);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, -1, 40));

        update_btn.setBackground(new java.awt.Color(218, 230, 216));
        update_btn.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        update_btn.setForeground(new java.awt.Color(0, 0, 0));
        update_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit Property_20px_2.png"))); // NOI18N
        update_btn.setText("Update");
        update_btn.setIconTextGap(0);
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        jPanel3.add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

        save_btn.setBackground(new java.awt.Color(218, 230, 216));
        save_btn.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        save_btn.setForeground(new java.awt.Color(0, 0, 0));
        save_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_20px_1.png"))); // NOI18N
        save_btn.setText("Save");
        save_btn.setIconTextGap(0);
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });
        jPanel3.add(save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));
        jPanel3.add(other_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 100, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 220, 50));

        jLabel28.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 51, 51));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_20px_3.png"))); // NOI18N
        jLabel28.setText("Search:");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jButton18.setBackground(new java.awt.Color(218, 230, 216));
        jButton18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(0, 0, 0));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Refresh_20px.png"))); // NOI18N
        jButton18.setText("Refresh");
        jButton18.setIconTextGap(0);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(848, 440, 110, 40));

        jButton7.setBackground(new java.awt.Color(218, 230, 216));
        jButton7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add List_20px.png"))); // NOI18N
        jButton7.setText("Add");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        amt_update.setBackground(new java.awt.Color(218, 230, 216));
        amt_update.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        amt_update.setForeground(new java.awt.Color(0, 0, 0));
        amt_update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amt_updateKeyTyped(evt);
            }
        });
        jPanel3.add(amt_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 150, 50));

        dis_update.setBackground(new java.awt.Color(218, 230, 216));
        dis_update.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dis_update.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(dis_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 310, 50));

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setText("Amount Used");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 51));
        jLabel17.setText("Description");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 50));

        others_time_update.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        others_time_update.setForeground(new java.awt.Color(0, 0, 0));
        others_time_update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(others_time_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 100, 40));

        others_date_update.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        others_date_update.setForeground(new java.awt.Color(0, 0, 0));
        others_date_update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(others_date_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 100, 40));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 970, 1120));

        other_tbl.addTab("Others", jPanel3);

        getContentPane().add(other_tbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 980, 570));

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
        jPanel5.add(help_lite, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 20, 20));

        help_fill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Help_15px.png"))); // NOI18N
        jPanel5.add(help_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 20, 20));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 20));

        setSize(new java.awt.Dimension(970, 588));
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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         setVisible(false);
         bills_expenses be = new bills_expenses();
         be.setVisible(true);

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Update_bill_table();
          total_bills();
          dis_update_bill.setText(null);
        amt_update_bill.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        dis_update_maint.setText(null);
        amt_update_maint.setText(null);
        update_maintenace_table();
         total_maintenace();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        update_othrs();
        total_others();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        setVisible(false);
        Add_maintainace am = new Add_maintainace();
        am.setVisible(true);
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void bill_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bill_searchKeyReleased
        // TODO add your handling code here:
          String txt_1=bill_search.getText();
        filter_bill (txt_1);
    }//GEN-LAST:event_bill_searchKeyReleased

    private void maint_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maint_searchKeyReleased
        // TODO add your handling code here:
        
         String txt_1=maint_search.getText();
        filter_maintenace (txt_1);
    }//GEN-LAST:event_maint_searchKeyReleased

    private void other_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_other_searchKeyReleased
        // TODO add your handling code here:
          String txt_1=other_search.getText();
        filter_others (txt_1);
    }//GEN-LAST:event_other_searchKeyReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

         MessageFormat header = new MessageFormat("Maintenance");
         MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try{
             
             maintenace_table.print(JTable.PrintMode.NORMAL, header, footer);


    }catch(Exception e)
    {
           System.err.format("Cannont print %s%n",e.getMessage());

    }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Other Expenses");
         MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try{
             
             othrs.print(JTable.PrintMode.NORMAL, header, footer);


    }catch(Exception e)
    {
           System.err.format("Cannont print %s%n",e.getMessage());

    }
    
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         MessageFormat header = new MessageFormat("Bills");
         MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try{
             
             bill_table.print(JTable.PrintMode.NORMAL, header, footer);


    }catch(Exception e)
    {
           System.err.format("Cannont print %s%n",e.getMessage());

    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
         int row=bill_table.getSelectedRow();
            
            if(row==-1){
                
                JOptionPane.showMessageDialog(null, "No Row Selected");
            
            }
            else{
                
                 int c = JOptionPane.showConfirmDialog(null, "Do you realy wanna Delete","Delete",JOptionPane.YES_NO_OPTION);
      
        if(c==0){
        String sql =" DELETE FROM bills WHERE bill_id =?";
        try{
        
            pst=conn.prepareStatement(sql);
            pst.setString(1,biil_id.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, " Deleted Successfully");
            
    
        }

        catch(Exception e){
  //   JOptionPane.showMessageDialog(null, "Check your internet");
        
        }
        }
        
            }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row=maintenace_table.getSelectedRow();
            
            if(row==-1){
                
                JOptionPane.showMessageDialog(null, "No Row Selected");
            
            }
            else{
                
                 int c = JOptionPane.showConfirmDialog(null, "Do you realy wanna Delete","Delete",JOptionPane.YES_NO_OPTION);
      
        if(c==0){
        String sql =" DELETE FROM maintenace WHERE maintenance_id =?";
        try{
        
            pst=conn.prepareStatement(sql);
            pst.setString(1,maintani_id.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, " Deleted Successfully");
            
    
        }

        catch(Exception e){
   //JOptionPane.showMessageDialog(null, "Check your internet");
        
        }
        }
        
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
         int row=othrs.getSelectedRow();
            
            if(row==-1){
                
                JOptionPane.showMessageDialog(null, "No Row Selected");
            
            }
            else{
                
                 int c = JOptionPane.showConfirmDialog(null, "Do you realy wanna Delete","Delete",JOptionPane.YES_NO_OPTION);
      
        if(c==0){
        String sql =" DELETE FROM others WHERE others_id =?";
        try{
        
            pst=conn.prepareStatement(sql);
            pst.setString(1,other_id.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, " Deleted Successfully");
            
    
        }

        catch(Exception e){
        //    JOptionPane.showMessageDialog(null, "Check your internet");
        
        }
        }
        
            }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void othrsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_othrsMouseClicked
        // TODO add your handling code here:
       
        update_btn.setEnabled(true);
        dis_update.setEnabled(false);
        amt_update.setEnabled(false);
       
        
         try{

            int row = othrs.getSelectedRow();
            String Table_click=(othrs.getModel().getValueAt(row,0).toString());

            String sql ="SELECT * FROM others WHERE  others_id = '"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){

                  String dead = rs.getString("others_id");
                other_id.setText(dead);
                
                String layer = rs.getString("description");
              dis_update.setText(layer);

                String pen = rs.getString("amt_used");
          amt_update.setText(pen);

               

       
            }

        }
        catch (Exception e){
      //      JOptionPane.showMessageDialog(null, "Check your internet");
        }
       
    }//GEN-LAST:event_othrsMouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabel21MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
         help_fill.setVisible(false);
        minus_fill.setVisible(false);
        cancel_fill.setVisible(false);
        logout_fill.setVisible(false);
        back_fill.setVisible(false);
        //******************************************************************/*/*/*/*/*/*/*
        save_btn_maint.setEnabled(false);
        update_btn_maint.setEnabled(false);
        update_btn.setEnabled(false);
        save_btn.setEnabled(false);
          save_btn_bill.setEnabled(false);
        update_btn_bill.setEnabled(false);
        dis_update_bill.setEnabled(false);
        amt_update_bill.setEnabled(false);
        dis_update_maint.setEnabled(false);
          amt_update_maint.setEnabled(false);
            dis_update.setEnabled(false);
              amt_update.setEnabled(false);
        
        
    }//GEN-LAST:event_formWindowActivated

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // TODO add your handling code here:
         save_btn.setEnabled(true);
        update_btn.setEnabled(false);
         dis_update.setEnabled(true);
        amt_update.setEnabled(true);
    }//GEN-LAST:event_update_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        // TODO add your handling code here:
   
       update_btn.setEnabled(false);
        save_btn.setEnabled(false);
        
        try{
                String value1=other_id.getText();
                String value2=dis_update.getText();
                String value3=amt_update.getText();
                String value4=others_date_update.getText();
                String value5=others_time_update.getText();

               

                String sql ="update others set others_id='"+value1+"', description='"+value2+"', "
                        + "amt_used='"+value3+"', date_used='"+value4+"', time_='"+value5+"'  where others_id='"+value1+"'";

                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Successful");
                
               
                
             dis_update.setText(null);
        amt_update.setText(null);
        

            }

            catch(Exception e){

                JOptionPane.showMessageDialog(null, e);
            }
              finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
    
       
    }//GEN-LAST:event_save_btnActionPerformed

    private void amt_update_maintKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amt_update_maintKeyTyped
        // TODO add your handling code here:
         char check = evt.getKeyChar();
        
        if(!(Character.isDigit(check)
                || check ==KeyEvent.VK_ENTER 
                ||  check ==KeyEvent.VK_BACK_SPACE
                ||  check ==KeyEvent.VK_DELETE  ))
        {
        
            evt.consume();
           // JOptionPane.showMessageDialog(null, "Figures Only");
        }
    }//GEN-LAST:event_amt_update_maintKeyTyped

    private void amt_update_billKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amt_update_billKeyTyped
        // TODO add your handling code here:
         char check = evt.getKeyChar();
        
        if(!(Character.isDigit(check)
                || check ==KeyEvent.VK_ENTER 
                ||  check ==KeyEvent.VK_BACK_SPACE
                ||  check ==KeyEvent.VK_DELETE  ))
        {
        
            evt.consume();
            //JOptionPane.showMessageDialog(null, "Figures Only");
        }
    }//GEN-LAST:event_amt_update_billKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Add_others ad = new Add_others();
        ad.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void update_btn_maintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btn_maintActionPerformed
        // TODO add your handling code here:
        
         save_btn_maint.setEnabled(true);
        update_btn_maint.setEnabled(false);
         dis_update_maint.setEnabled(true);
        amt_update_maint.setEnabled(true);
    }//GEN-LAST:event_update_btn_maintActionPerformed

    private void save_btn_maintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn_maintActionPerformed
        // TODO add your handling code here:
        update_btn_maint.setEnabled(false);
        save_btn_maint.setEnabled(false);
        
        try{
                String value1=maintani_id.getText();
                String value2=dis_update_maint.getText();
                String value3=amt_update_maint.getText();
                String value4=maint_date.getText();
                String value5=maint_time.getText();

               

                String sql ="update maintenace set maintenance_id='"+value1+"', description='"+value2+"', "
                        + "amt_used='"+value3+"', date_used='"+value4+"', time_='"+value5+"'  where maintenance_id='"+value1+"'";

                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Successful");
                
               
                
             dis_update.setText(null);
        amt_update.setText(null);
        

            }

            catch(Exception e){

                JOptionPane.showMessageDialog(null, e);
            }
              finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
    }//GEN-LAST:event_save_btn_maintActionPerformed

    private void maintenace_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintenace_tableMouseClicked
        // TODO add your handling code here:
         update_btn_maint.setEnabled(true);
        dis_update_maint.setEnabled(false);
        amt_update_maint.setEnabled(false);
       
        
         try{

            int row = maintenace_table.getSelectedRow();
            String Table_click=(maintenace_table.getModel().getValueAt(row,0).toString());

            String sql ="SELECT * FROM maintenace WHERE  maintenance_id = '"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){

                  String dead = rs.getString("maintenance_id");
                maintani_id.setText(dead);
                
                String layer = rs.getString("description");
              dis_update_maint.setText(layer);

                String pen = rs.getString("amt_used");
          amt_update_maint.setText(pen);

               

       
            }

        }
        catch (Exception e){
       //     JOptionPane.showMessageDialog(null, "Check your internet");
        }
    }//GEN-LAST:event_maintenace_tableMouseClicked

    private void update_btn_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btn_billActionPerformed
        // TODO add your handling code here:
         save_btn_bill.setEnabled(true);
        update_btn_bill.setEnabled(false);
         dis_update_bill.setEnabled(true);
        amt_update_bill.setEnabled(true);
    }//GEN-LAST:event_update_btn_billActionPerformed

    private void save_btn_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn_billActionPerformed
        // TODO add your handling code here:
        update_btn_bill.setEnabled(false);
        save_btn_bill.setEnabled(false);
        
        try{
                String value1=biil_id.getText();
                String value2=dis_update_bill.getText();
                String value3=amt_update_bill.getText();
                String value4=bill_date.getText();
                String value5=time_bill.getText();

               

                String sql ="update bills set bill_id='"+value1+"', description='"+value2+"', "
                        + "amount_used='"+value3+"', date_used='"+value4+"', time_='"+value5+"'  where bill_id='"+value1+"'";

                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Successful");
                
               
                
             dis_update_bill.setText(null);
        amt_update_bill.setText(null);
        

            }

            catch(Exception e){

                JOptionPane.showMessageDialog(null, e);
            }
              finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
    }//GEN-LAST:event_save_btn_billActionPerformed

    private void bill_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bill_tableMouseClicked
        // TODO add your handling code here:.
        update_btn_bill.setEnabled(true);
        dis_update_bill.setEnabled(false);
        amt_update_bill.setEnabled(false);
       
        
         try{

            int row = bill_table.getSelectedRow();
            String Table_click=(bill_table.getModel().getValueAt(row,0).toString());

            String sql ="SELECT * FROM bills WHERE  bill_id = '"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){

                  String dead = rs.getString("bill_id");
                biil_id.setText(dead);
                
                String layer = rs.getString("description");
              dis_update_bill.setText(layer);

                String pen = rs.getString("amount_used");
          amt_update_bill.setText(pen);

               

       
            }

        }
        catch (Exception e){
     //       JOptionPane.showMessageDialog(null, "Check your internet");
        }
    }//GEN-LAST:event_bill_tableMouseClicked

    private void amt_updateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amt_updateKeyTyped
        // TODO add your handling code here:
         char check = evt.getKeyChar();
        
        if(!(Character.isDigit(check)
                || check ==KeyEvent.VK_ENTER 
                ||  check ==KeyEvent.VK_BACK_SPACE
                ||  check ==KeyEvent.VK_DELETE  ))
        {
        
            evt.consume();
           // JOptionPane.showMessageDialog(null, "Figures Only");
        }
    }//GEN-LAST:event_amt_updateKeyTyped

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
            java.util.logging.Logger.getLogger(expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new expenses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amt_update;
    private javax.swing.JTextField amt_update_bill;
    private javax.swing.JTextField amt_update_maint;
    private javax.swing.JLabel back_fill;
    private javax.swing.JLabel back_lite;
    private javax.swing.JTextField biil_id;
    private javax.swing.JTextField bill_date;
    private javax.swing.JTextField bill_search;
    private javax.swing.JTable bill_table;
    private javax.swing.JLabel cancel_fill;
    private javax.swing.JLabel cancel_lite;
    private javax.swing.JTextField dis_update;
    private javax.swing.JTextField dis_update_bill;
    private javax.swing.JTextField dis_update_maint;
    private javax.swing.JLabel help_fill;
    private javax.swing.JLabel help_lite;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel logout_fill;
    private javax.swing.JLabel logout_lite;
    private javax.swing.JTextField maint_date;
    private javax.swing.JTextField maint_search;
    private javax.swing.JTextField maint_time;
    private javax.swing.JTextField maintani_id;
    private javax.swing.JTable maintenace_table;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel minus_fill;
    private javax.swing.JTextField other_id;
    private javax.swing.JTextField other_search;
    private javax.swing.JTabbedPane other_tbl;
    private javax.swing.JLabel others_date_update;
    private javax.swing.JLabel others_time_update;
    private javax.swing.JTable othrs;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton save_btn_bill;
    private javax.swing.JButton save_btn_maint;
    private javax.swing.JTextField time_bill;
    private javax.swing.JButton update_btn;
    private javax.swing.JButton update_btn_bill;
    private javax.swing.JButton update_btn_maint;
    // End of variables declaration//GEN-END:variables
}

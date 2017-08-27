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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    /**
     * Creates new form expenses
     */
    public expenses() {
        
        conn = java_connection.getConnection();
        initComponents();
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
            JOptionPane.showMessageDialog( null, e);
        }
        }
   
   private void update_maintenace_table(){
    
        try {
          String sql ="SELECT maintenance_id  as 'ID', description as 'Description', amt_used as 'Amount Used', date_used as 'Date', time_ as 'Time'  FROM maintenace";
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            maintenace_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
        }
   
    private void update_othrs(){
    
        try {
          String sql ="SELECT others_id  as 'ID', description as 'Description', amt_used as 'Amount Used', date_used as 'Date', time_ as 'Time'  FROM others";
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            othrs.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
        }
   
    
        
    public void currentDate(){
    
    
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        date_.setText(year+"/"+(month+1)+"/"+day);
        maint_date.setText(year+"/"+(month+1)+"/"+day);
        others_date.setText(year+"/"+(month+1)+"/"+day);
        

   
     
         
         Date date = new Date();
         String strDateFormat = "HH:mm:ss a";
         SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
          time.setText(sdf.format(date));
          maint_time.setText(sdf.format(date));
         othres_time.setText(sdf.format(date));
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
        descript = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        amt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        time = new javax.swing.JTextField();
        date_ = new javax.swing.JTextField();
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
        amt_m = new javax.swing.JTextField();
        m_disc = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        maint_search = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
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
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        othrs = new javax.swing.JTable();
        des_2 = new javax.swing.JTextField();
        des_1 = new javax.swing.JTextField();
        others_amt = new javax.swing.JTextField();
        others_descr = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        other_search = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        othres_time = new javax.swing.JTextField();
        others_date = new javax.swing.JTextField();
        otherhs = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

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
        jButton5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
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

        descript.setBackground(new java.awt.Color(204, 228, 202));
        descript.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        descript.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(descript, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 260, 50));

        jLabel22.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setText("Amount Used");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        jButton8.setBackground(new java.awt.Color(218, 230, 216));
        jButton8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 0));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Ok_20px.png"))); // NOI18N
        jButton8.setText("Enter");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, -1, -1));

        amt.setBackground(new java.awt.Color(204, 228, 202));
        amt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        amt.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 170, 50));

        jButton1.setBackground(new java.awt.Color(218, 230, 216));
        jButton1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Refresh_20px.png"))); // NOI18N
        jButton1.setText("Refresh");
        jButton1.setIconTextGap(0);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, -1, 40));

        jButton2.setBackground(new java.awt.Color(218, 230, 216));
        jButton2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_20px_1.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.setIconTextGap(0);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));

        jButton3.setBackground(new java.awt.Color(218, 230, 216));
        jButton3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit Property_20px_2.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.setIconTextGap(0);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        jButton16.setBackground(new java.awt.Color(218, 230, 216));
        jButton16.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton16.setForeground(new java.awt.Color(0, 0, 0));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Trash_20px.png"))); // NOI18N
        jButton16.setText("Delete");
        jButton16.setIconTextGap(0);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 110, 30));
        jPanel1.add(date_, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 110, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 51, 51));
        jLabel26.setText("Description");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 470, -1));
        jPanel1.add(biil_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, -1, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 240, 50));

        jLabel31.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 51, 51));
        jLabel31.setText(" Total ");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, -1, -1));

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
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, -1));

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
        jButton6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("Enter");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, -1, -1));

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
        jScrollPane2.setViewportView(maintenace_table);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 930, 250));

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 82, 12));
        jLabel13.setText("H O S T E L");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 130, 50));

        amt_m.setBackground(new java.awt.Color(204, 228, 202));
        amt_m.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        amt_m.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(amt_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 170, 50));

        m_disc.setBackground(new java.awt.Color(204, 228, 202));
        m_disc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        m_disc.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(m_disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 270, 50));
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
        jButton4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Trash_20px.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.setIconTextGap(0);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        jButton11.setBackground(new java.awt.Color(218, 230, 216));
        jButton11.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 0, 0));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit Property_20px_2.png"))); // NOI18N
        jButton11.setText("Update");
        jButton11.setIconTextGap(0);
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        jButton12.setBackground(new java.awt.Color(218, 230, 216));
        jButton12.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 0, 0));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_20px_1.png"))); // NOI18N
        jButton12.setText("Save");
        jButton12.setIconTextGap(0);
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));

        jButton9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print_20px_3.png"))); // NOI18N
        jButton9.setText("Print");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 51, 51));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_20px_3.png"))); // NOI18N
        jLabel27.setText("Search:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));
        jPanel2.add(maint_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, 110, 30));
        jPanel2.add(maint_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 110, 30));
        jPanel2.add(maintani_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, -1));

        jButton17.setBackground(new java.awt.Color(218, 230, 216));
        jButton17.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton17.setForeground(new java.awt.Color(0, 0, 0));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Refresh_20px.png"))); // NOI18N
        jButton17.setText("Refresh");
        jButton17.setIconTextGap(0);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, -1, 40));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 240, 50));

        jLabel29.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 51, 51));
        jLabel29.setText(" Total ");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 980, 1120));

        other_tbl.addTab("Maintenace", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 150));

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("Total");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 51));
        jLabel17.setText("Description");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 82, 12));
        jLabel18.setText("OTHERS");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 130, 50));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 570, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 50)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 82, 12));
        jLabel19.setText("J O D O K ");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 250, 70));

        jButton7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton7.setText("Enter");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, -1, -1));

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

        des_2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        des_2.setForeground(new java.awt.Color(0, 0, 0));
        des_2.setText("jTextField1");
        jPanel3.add(des_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 130, 50));

        des_1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        des_1.setForeground(new java.awt.Color(0, 0, 0));
        des_1.setText("jTextField1");
        jPanel3.add(des_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 240, 50));

        others_amt.setBackground(new java.awt.Color(204, 228, 202));
        others_amt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        others_amt.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(others_amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 170, 50));

        others_descr.setBackground(new java.awt.Color(204, 228, 202));
        others_descr.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        others_descr.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(others_descr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 290, 50));

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

        jButton10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print_20px_3.png"))); // NOI18N
        jButton10.setText("Print");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, -1));

        jButton13.setBackground(new java.awt.Color(218, 230, 216));
        jButton13.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 0, 0));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Trash_20px.png"))); // NOI18N
        jButton13.setText("Delete");
        jButton13.setIconTextGap(0);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        jButton14.setBackground(new java.awt.Color(218, 230, 216));
        jButton14.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton14.setForeground(new java.awt.Color(0, 0, 0));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit Property_20px_2.png"))); // NOI18N
        jButton14.setText("Update");
        jButton14.setIconTextGap(0);
        jPanel3.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        jButton15.setBackground(new java.awt.Color(218, 230, 216));
        jButton15.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 0, 0));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_20px_1.png"))); // NOI18N
        jButton15.setText("Save");
        jButton15.setIconTextGap(0);
        jPanel3.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));
        jPanel3.add(othres_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 110, 30));
        jPanel3.add(others_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 110, 30));
        jPanel3.add(otherhs, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 220, 50));

        jLabel28.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 51, 51));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_20px_3.png"))); // NOI18N
        jLabel28.setText("Search:");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setText("Amount Used");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, -1));

        jButton18.setBackground(new java.awt.Color(218, 230, 216));
        jButton18.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton18.setForeground(new java.awt.Color(0, 0, 0));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Refresh_20px.png"))); // NOI18N
        jButton18.setText("Refresh");
        jButton18.setIconTextGap(0);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, -1, 40));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 970, 1120));

        other_tbl.addTab("Others", jPanel3);

        getContentPane().add(other_tbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 570));

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo_border.png"))); // NOI18N
        jMenu2.setText("File");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Go Back_20px.png"))); // NOI18N
        jMenuItem4.setText("Back");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Logout Rounded Left_20px.png"))); // NOI18N
        jMenuItem5.setText("Logout");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Cancel_20px_2.png"))); // NOI18N
        jMenuItem6.setText("Close");
        jMenuItem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        setSize(new java.awt.Dimension(972, 594));
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

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        mainPage mp = new mainPage();
        mp.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        login_form mp = new login_form();
        mp.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         try {
          
                
                    String sql = "Insert into bills(description, amount_used,  date_used, time_) values (?,?,?,?)";
                    
                    pst=conn.prepareStatement(sql);
                    pst.setString(1, descript.getText());
                    pst.setString(2, amt.getText());
                     pst.setString(3, date_.getText());
                     pst.setString(4, time.getText());
               
                    pst.execute();
                   
                    descript.setText(null);
                    amt.setText(null);
           
                    JOptionPane.showMessageDialog(null," Success");
        
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Update_bill_table();
          total_bills();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        
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
        
         try {
          
                
                    String sql = "Insert into maintenace(description, amt_used,  date_used, time_) values (?,?,?,?)";
                    
                    pst=conn.prepareStatement(sql);
                    pst.setString(1, m_disc.getText());
                    pst.setString(2, amt_m.getText());
                     pst.setString(3, maint_date.getText());
                     pst.setString(4, maint_time.getText());
               
                    pst.execute();
                   
                    maint_date.setText(null);
                    maint_time.setText(null);
                     m_disc.setText(null);
                    amt_m.setText(null);
           
                    JOptionPane.showMessageDialog(null," Success");
        
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
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
            JOptionPane.showMessageDialog( null, e);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

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
            JOptionPane.showMessageDialog(null, e);
        
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
        String sql =" DELETE FROM maintenance WHERE maintenance_id =?";
        try{
        
            pst=conn.prepareStatement(sql);
            pst.setString(1,maintani_id.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, " Deleted Successfully");
            
    
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
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
        String sql =" DELETE FROM maintenance WHERE maintenance_id =?";
        try{
        
            pst=conn.prepareStatement(sql);
            pst.setString(1,otherhs.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, " Deleted Successfully");
            
    
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
        }
        }
        
            }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void othrsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_othrsMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_othrsMouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabel21MouseClicked

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
    private javax.swing.JTextField amt;
    private javax.swing.JTextField amt_m;
    private javax.swing.JTextField biil_id;
    private javax.swing.JTextField bill_search;
    private javax.swing.JTable bill_table;
    private javax.swing.JTextField date_;
    private javax.swing.JTextField des_1;
    private javax.swing.JTextField des_2;
    private javax.swing.JTextField descript;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField m_disc;
    private javax.swing.JTextField maint_date;
    private javax.swing.JTextField maint_search;
    private javax.swing.JTextField maint_time;
    private javax.swing.JTextField maintani_id;
    private javax.swing.JTable maintenace_table;
    private javax.swing.JTextField other_search;
    private javax.swing.JTabbedPane other_tbl;
    private javax.swing.JTextField otherhs;
    private javax.swing.JTextField others_amt;
    private javax.swing.JTextField others_date;
    private javax.swing.JTextField others_descr;
    private javax.swing.JTextField othres_time;
    private javax.swing.JTable othrs;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}

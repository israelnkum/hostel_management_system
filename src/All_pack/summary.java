/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package All_pack;


import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.Set;
import java.util.TreeMap;



import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author oSikaNi iSraeL
 */
public class summary extends javax.swing.JFrame {
    
          DefaultTableModel model;
          DefaultTableModel model_1;
          DefaultTableModel model_2;
          DefaultTableModel model_3;
          DefaultTableModel model_4;
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
    //  model = (DefaultTableModel) jTable1.getModel();

        Update_table();
        Student();
        Update_Payment();
        total_Fees();
       total_arreas();
       total_amtPaid();
       total_student();
       
       
    }
    
 private String getCellValue( int x, int y)
    {
    
        return model_4.getValueAt(x, y).toString();
    }
    
    private void writeToExcel(){

    XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet ws = wb.createSheet();
        
        TreeMap<String,Object[]> data = new TreeMap();
        
        data.put("-1",new Object[]{model_4.getColumnName(0),model_4.getColumnName(1),model_4.getColumnName(2),model_4.getColumnName(3),model_4.getColumnName(4),model_4.getColumnName(5),model_4.getColumnName(6),model_4.getColumnName(7)});
        
        for(int i=0; i<model_4.getRowCount();i++){
        
            data.put(Integer.toString(i), new Object[]{getCellValue(i,0),getCellValue(i,1),getCellValue(i,2),getCellValue(i,3),getCellValue(i,4),getCellValue(i,5),getCellValue(i,6),getCellValue(i,7)});
        }
        
        Set<String> ids=data.keySet();
        XSSFRow row;
        int rowID=0;
        
        for(String key: ids){
        
            row = ws.createRow(rowID++);
            
            Object[] values=data.get(key);
            
            int cellid =0;
            
            for(Object o: values){
            
                Cell cell = row.createCell(cellid++);
                cell.setCellValue(o.toString());
            }
        }
        
        try{
        FileOutputStream fos = new FileOutputStream("C:/Users/oSikaNi iSraeL/Documents/payment.xls");
        wb.write(fos);
        fos.close();
        
        }
        
        catch (IOException e){
        
         //   JOptionPane.showMessageDialog(null, e);
        
    }
    }
    
    private void Update_table(){
    
        try {
           String sql="SELECT room_no as 'Room Number', bed_no as 'Bed Number'   FROM payment";
           
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
          //  jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
        //    JOptionPane.showMessageDialog( null, e);
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
           String sql="SELECT  hosteler_id as 'ID', fname as 'First Name', lname as 'Last Name',program as 'Program', roo_no as 'Room Number', bed_no as 'Bed Number'   FROM new_hosteler";
           
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
       //     JOptionPane.showMessageDialog( null, e);
        }
        finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
      }
    
    
    
    private void Update_Payment(){
    
        try {
           String sql="SELECT fname as 'First Name', lname as 'Last Name', room_no as 'Room', bed_no as 'Bed', hostel_fee as 'Hostel Fee', amt_paid as 'Amount Paid', arreas as 'Arrears', date_ as 'Date Paid'  FROM payment";
           
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            payment_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
        //    JOptionPane.showMessageDialog( null, e);
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
     
     //Filter Student Table
       private void student_filter (String sql){
    
          model_3 =(DefaultTableModel) jTable3.getModel();
     
         TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model_3);
         jTable3.setRowSorter(tr);
         tr.setRowFilter(RowFilter.regexFilter(sql));
     }
     
      public void total_student(){
        

          try{
          
              String sql =" Select count(fname) from new_hosteler";
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
        jPanel3 = new javax.swing.JPanel();
        minimize = new javax.swing.JLabel();
        logout_lite = new javax.swing.JLabel();
        minus_fill = new javax.swing.JLabel();
        logout_fill = new javax.swing.JLabel();
        cancel_lite = new javax.swing.JLabel();
        cancel_fill = new javax.swing.JLabel();
        back_lite = new javax.swing.JLabel();
        back_fill = new javax.swing.JLabel();
        help_lite = new javax.swing.JLabel();
        help_fill = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 0));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 880, 650));

        jPanel3.setBackground(new java.awt.Color(219, 231, 217));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -10, -1, 40));

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
        jPanel3.add(logout_lite, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

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
        jPanel3.add(minus_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 20));

        logout_fill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Logout Rounded Left_15px_3.png"))); // NOI18N
        logout_fill.setToolTipText("Logout");
        logout_fill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout_fill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_fillMouseClicked(evt);
            }
        });
        jPanel3.add(logout_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -300, 875, 621));

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
        jPanel3.add(cancel_lite, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 20));

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
        jPanel3.add(cancel_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 20));

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
        jPanel3.add(back_lite, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 20));

        back_fill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Go Back_15px_1.png"))); // NOI18N
        back_fill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_fillMouseClicked(evt);
            }
        });
        jPanel3.add(back_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 20));

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
        jPanel3.add(help_lite, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, 20));

        help_fill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Help_15px.png"))); // NOI18N
        jPanel3.add(help_fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 20));

        setSize(new java.awt.Dimension(877, 668));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void logout_liteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_liteMouseClicked
        // TODO add your handling code here:

        setVisible(false);
        login_form lf = new login_form();
        lf.setVisible(true);
    }//GEN-LAST:event_logout_liteMouseClicked

    private void logout_liteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_liteMouseEntered
        // TODO add your handling code here:

      //  logout_fill.setVisible(true);
        logout_lite.setVisible(false);
    }//GEN-LAST:event_logout_liteMouseEntered

    private void logout_liteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_liteMouseExited
        // TODO add your handling code here:

     //   logout_fill.setVisible(false);
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
             help_fill.setVisible(false);
        minus_fill.setVisible(false);
        cancel_fill.setVisible(false);
     //   logout_fill.setVisible(false);
        back_fill.setVisible(false);
    }//GEN-LAST:event_formWindowActivated

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

    private void search_1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_1KeyReleased
        // TODO add your handling code here:
        String txt_1=search_1.getText();
        filter (txt_1);

    }//GEN-LAST:event_search_1KeyReleased

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

    private void logout_fillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_fillMouseClicked
        // TODO add your handling code here:

        setVisible(false);
        login_form lf = new login_form();
        lf.setVisible(true);
    }//GEN-LAST:event_logout_fillMouseClicked

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
    private javax.swing.JLabel back_fill;
    private javax.swing.JLabel back_lite;
    private javax.swing.JLabel cancel_fill;
    private javax.swing.JLabel cancel_lite;
    private javax.swing.JLabel feesPaid;
    private javax.swing.JLabel help_fill;
    private javax.swing.JLabel help_lite;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel logout_fill;
    private javax.swing.JLabel logout_lite;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel minus_fill;
    private javax.swing.JTable payment_tbl;
    private javax.swing.JTextField search_1;
    private javax.swing.JTextField std_filt;
    private javax.swing.JLabel student;
    private javax.swing.JLabel total_fees;
    // End of variables declaration//GEN-END:variables
}

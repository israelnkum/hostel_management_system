/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package All_pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author oSikaNi iSraeL
 */
public class update_info extends javax.swing.JFrame {
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
     DefaultTableModel model_1;

    /**
     * Creates new form update_info
     */
    public update_info() {
        conn = java_connection.getConnection();
        initComponents();
       id.setVisible(false);
        
        Update_table();
    }
    
    private void filter (String sql){
    
          model_1 =(DefaultTableModel) jTable1.getModel();
     
         TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (model_1);
         jTable1.setRowSorter(tr);
         tr.setRowFilter(RowFilter.regexFilter(sql));
     }
    
     private void Update_table(){
    
        try {
          String sql ="SELECT customer_id as 'ID ',fname as 'First Name',lname as ' Last Name', program as 'Program', roo_no as 'Room No:',"
                  + " bed_no as 'Bird No:', hostel_fee as 'Hostel Fee', phone as 'Phone Number', date_reg as 'Date Registered' FROM new_info ";
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e);
        }
        }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        update_btn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        fname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        hostel_fee = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        room = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bed = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        prog = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        search_box = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        referesh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 150));

        jTable1.setBackground(new java.awt.Color(187, 224, 190));
        jTable1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(25);
        jTable1.setRowMargin(2);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 890, 460));

        update_btn.setBackground(new java.awt.Color(213, 229, 216));
        update_btn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        update_btn.setForeground(new java.awt.Color(0, 0, 0));
        update_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit Property_20px_2.png"))); // NOI18N
        update_btn.setText("Update");
        update_btn.setBorderPainted(false);
        update_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        getContentPane().add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 100, 30));

        jButton2.setBackground(new java.awt.Color(213, 229, 216));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Trash_20px.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 100, 30));

        jButton3.setBackground(new java.awt.Color(213, 229, 216));
        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print_20px_3.png"))); // NOI18N
        jButton3.setText("Print");
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, -1, 30));

        save_btn.setBackground(new java.awt.Color(202, 229, 203));
        save_btn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        save_btn.setForeground(new java.awt.Color(0, 0, 0));
        save_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_20px_1.png"))); // NOI18N
        save_btn.setText("Save");
        save_btn.setBorderPainted(false);
        save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });
        getContentPane().add(save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 570, 90, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 82, 12));
        jLabel5.setText("H O S T E L");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 210, 70));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 470, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 82, 12));
        jLabel4.setText("J O D O K ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 440, 70));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Last Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 230, 180, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Phone No:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 460, -1, -1));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, 180, -1));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 380, 180, -1));

        fname.setBackground(new java.awt.Color(202, 229, 203));
        fname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fname.setBorder(null);
        getContentPane().add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, 180, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Bed No:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 360, -1, -1));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 330, 180, -1));

        hostel_fee.setBackground(new java.awt.Color(205, 234, 211));
        hostel_fee.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        hostel_fee.setBorder(null);
        getContentPane().add(hostel_fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 400, 180, 30));

        phone.setBackground(new java.awt.Color(170, 223, 183));
        phone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        phone.setBorder(null);
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 450, 180, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Room No:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, -1, -1));

        lname.setBackground(new java.awt.Color(195, 230, 201));
        lname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lname.setBorder(null);
        getContentPane().add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 200, 180, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/More Info_100px.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 40, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Program:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, -1, -1));

        room.setBackground(new java.awt.Color(214, 239, 220));
        room.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        room.setBorder(null);
        getContentPane().add(room, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 300, 180, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Hostel Fee:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, -1, -1));

        bed.setBackground(new java.awt.Color(214, 239, 220));
        bed.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bed.setBorder(null);
        getContentPane().add(bed, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 350, 180, 30));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 280, 180, -1));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 480, 180, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Date:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 510, -1, -1));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 180, -1));

        prog.setBackground(new java.awt.Color(214, 239, 220));
        prog.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        prog.setBorder(null);
        getContentPane().add(prog, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 250, 180, 30));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 220, -1));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 180, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("First Name:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 0));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_20px_3.png"))); // NOI18N
        jLabel14.setText("Search:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 509, 180, 30));

        search_box.setBackground(new java.awt.Color(213, 229, 216));
        search_box.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        search_box.setForeground(new java.awt.Color(0, 0, 0));
        search_box.setBorder(null);
        search_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_boxKeyReleased(evt);
            }
        });
        getContentPane().add(search_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 220, 40));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, -1, -1));

        referesh.setBackground(new java.awt.Color(213, 229, 216));
        referesh.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        referesh.setForeground(new java.awt.Color(0, 0, 0));
        referesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Refresh_20px.png"))); // NOI18N
        referesh.setText("Refresh");
        referesh.setBorderPainted(false);
        referesh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        referesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refereshActionPerformed(evt);
            }
        });
        getContentPane().add(referesh, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/31.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 630));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Menu_20px_5.png"))); // NOI18N
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

        setSize(new java.awt.Dimension(1199, 652));
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

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

                jSeparator10.setVisible(false);
        jSeparator2.setEnabled(false);
        jSeparator3.setEnabled(false);
        jSeparator4.setEnabled(false);
        jSeparator5.setEnabled(false);
        jSeparator6.setEnabled(false);
        jSeparator8.setEnabled(false);
        jSeparator6.setEnabled(false);
        fname.setEnabled(false);
        lname.setEnabled(false);
        prog.setEnabled(false);
        room.setEnabled(false);
        bed.setEnabled(false);
        hostel_fee.setEnabled(false);
        phone.setEnabled(false);
        jDateChooser1.setEnabled(false);
        update_btn.setEnabled(false);
        jLabel13.setEnabled(false);
        jLabel3.setEnabled(false);
        jLabel10.setEnabled(false);
        jLabel6.setEnabled(false);
        jLabel7.setEnabled(false);
        jLabel11.setEnabled(false);
        jLabel8.setEnabled(false);
        jLabel12.setEnabled(false);
        jLabel9.setEnabled(false);
        save_btn.setEnabled(false);
        
    }//GEN-LAST:event_formWindowActivated

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // TODO add your handling code here:
        save_btn.setEnabled(true);
          jSeparator10.setEnabled(true);
        jSeparator2.setEnabled(true);
        jSeparator3.setEnabled(true);
        jSeparator4.setEnabled(true);
        jSeparator5.setEnabled(true);
        jSeparator6.setEnabled(true);
        jSeparator8.setEnabled(true);
        jSeparator6.setEnabled(true);
        fname.setEnabled(true);
        lname.setEnabled(true);
        prog.setEnabled(true);
        room.setEnabled(true);
        bed.setEnabled(true);
        hostel_fee.setEnabled(true);
        phone.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jLabel13.setEnabled(true);
        jLabel3.setEnabled(true);
        jLabel10.setEnabled(true);
        jLabel6.setEnabled(true);
        jLabel7.setEnabled(true);
        jLabel11.setEnabled(true);
        jLabel8.setEnabled(true);
        jLabel12.setEnabled(true);
        jLabel9.setEnabled(true);
    }//GEN-LAST:event_update_btnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        update_btn.setEnabled(true);
        
        try{

            int row = jTable1.getSelectedRow();
            String Table_click=(jTable1.getModel().getValueAt(row,0).toString());

            String sql ="SELECT * FROM new_info WHERE  customer_id = '"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()){

                String id_ = rs.getString("customer_id");
                id.setText(id_);
                
                String f_name = rs.getString("fname");
                fname.setText(f_name);
                
                String l_name = rs.getString("lname");
                lname.setText(l_name);
                String progra = rs.getString("program");
                prog.setText(progra);
                
                String room2 = rs.getString("roo_no");
                room.setText(room2);
                
                String berd = rs.getString("bed_no");
                bed.setText(berd);
                
                String hostel = rs.getString("hostel_fee");
                hostel_fee.setText(hostel);
                
                String phone_no = rs.getString("phone");
                phone.setText(phone_no);
                
                String date = rs.getString("date_reg");
              
                ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).setText(date);
                
               
   
            }

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
            finally{
        
        try{
         rs.close();
         pst.close();
        }
        catch(Exception e){
        
        
        }}
    }//GEN-LAST:event_jTable1MouseClicked

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        // TODO add your handling code here:
        try{
                String value1=id.getText();
                String value2=fname.getText();
                String value3=lname.getText();
                String value4=prog.getText();
                String value5=room.getText();
                String value6=bed.getText();
                String value7= hostel_fee.getText();
                String value8=phone.getText();
                String value9=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
               

                String sql ="update new_info set customer_id='"+value1+"', fname='"+value2+"', "
                        + "lname='"+value3+"', program='"+value4+"', roo_no='"+value5+"',"
                        + "bed_no='"+value6+"', hostel_fee='"+value7+"', phone='"+value8+"',"
                        + "date_reg='"+value9+"'  where customer_id='"+value1+"'";

                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Successful");
                
               
                
             fname.setText(null);
        lname.setText(null);
        prog.setText(null);
        room.setText(null);
        bed.setText(null);
        hostel_fee.setText(null);
        phone.setText(null);
        jDateChooser1.setDate(null);
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

    private void refereshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refereshActionPerformed
        // TODO add your handling code here:
        Update_table();
        fname.setText(null);
        lname.setText(null);
        prog.setText(null);
        room.setText(null);
        bed.setText(null);
        hostel_fee.setText(null);
        phone.setText(null);
        jDateChooser1.setDate(null);
        fname.setEnabled(false);
        lname.setEnabled(false);
        prog.setEnabled(false);
        room.setEnabled(false);
        bed.setEnabled(false);
        hostel_fee.setEnabled(false);
        phone.setEnabled(false);
        jDateChooser1.setEnabled(false);
        update_btn.setEnabled(false);
    }//GEN-LAST:event_refereshActionPerformed

    private void search_boxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_boxKeyReleased
        // TODO add your handling code here:
         
        String txt=search_box.getText();
        filter (txt);
    }//GEN-LAST:event_search_boxKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int row=jTable1.getSelectedRow();
            
            if(row==-1){
                
                JOptionPane.showMessageDialog(null, "No Row Selected");
            
            }
            else{
                
                 int c = JOptionPane.showConfirmDialog(null, "Do you realy wanna Delete","Delete",JOptionPane.YES_NO_OPTION);
      
        if(c==0){
        String sql =" DELETE FROM new_info WHERE customer_id =?";
        try{
        
            pst=conn.prepareStatement(sql);
            pst.setString(1,id.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, " Deleted Successfully");
            
    
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
        }
        }
        
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         MessageFormat header = new MessageFormat("All Student Summary");
         MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try{
             
             jTable1.print(JTable.PrintMode.NORMAL, header, footer);


    }catch(Exception e)
    {
           System.err.format("Cannont print %s%n",e.getMessage());

    }
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(update_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(update_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(update_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(update_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new update_info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bed;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField hostel_fee;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField prog;
    private javax.swing.JButton referesh;
    private javax.swing.JTextField room;
    private javax.swing.JButton save_btn;
    private javax.swing.JTextField search_box;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}

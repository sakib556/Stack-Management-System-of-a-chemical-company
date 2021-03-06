/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Information_add;
import Main.StartWindow;
import Cash.Cash_Amount;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sakib
 */
public class Customer_Information extends javax.swing.JFrame {
Connection con;
PreparedStatement pst=null;
ResultSet rs=null;
    /**
     * Creates new form Customer_Information
     */
    public Customer_Information() {
     initComponents();
     connect();  
     load();  
     txtName.requestFocus(); 
    }
    public void connect(){ 
    try {
        con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/chemical_company", "root", "");
    } catch (SQLException ex) {
        Logger.getLogger(Customer_Information.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
    public void current_date(){
    DateTimeFormatter cdt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime now = LocalDateTime.now();
    String cdate=cdt.format(now);
   datebox.setText(cdate);
}    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        datebox = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPhonenumber = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboDesignation = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDetails = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtReference = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Address", "Phone number", "Details", "Designation", "Reference", "Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 190, 1100, 260);

        datebox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        datebox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(datebox);
        datebox.setBounds(800, 40, 170, 30);

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1010, 110, 90, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Id : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 150, 130, 30);

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtId);
        txtId.setBounds(140, 150, 60, 30);

        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(750, 470, 110, 30);

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(390, 470, 110, 30);

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(510, 470, 110, 30);

        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(630, 470, 110, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Phone number :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(350, 110, 120, 30);

        txtPhonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhonenumberActionPerformed(evt);
            }
        });
        jPanel1.add(txtPhonenumber);
        txtPhonenumber.setBounds(470, 110, 200, 30);

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName);
        txtName.setBounds(140, 70, 190, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Customer Name :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 70, 130, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Designation :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(700, 110, 90, 30);

        comboDesignation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item", "Contructor", "Engineer", "Others" }));
        comboDesignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDesignationActionPerformed(evt);
            }
        });
        jPanel1.add(comboDesignation);
        comboDesignation.setBounds(800, 110, 170, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Address :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 110, 130, 30);

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel1.add(txtAddress);
        txtAddress.setBounds(140, 110, 190, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Details :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(350, 70, 120, 30);

        txtDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(txtDetails);
        txtDetails.setBounds(470, 70, 200, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Reference :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(700, 70, 90, 30);

        txtReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReferenceActionPerformed(evt);
            }
        });
        jPanel1.add(txtReference);
        txtReference.setBounds(800, 70, 170, 30);

        jLabel9.setBackground(new java.awt.Color(102, 255, 102));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel9.setText("*Customer Information :");
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 10, 270, 40);

        jButton8.setText("Back");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(1030, 20, 70, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1120, 580);

        setSize(new java.awt.Dimension(1136, 619));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void load(){
        String sid="0";
        DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
        dt.setRowCount(0);
        try {
            pst=con.prepareStatement("select *from customer_information");
            rs=pst.executeQuery(); 
        while(rs.next()){
            dt.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)
                    ,rs.getString(7),rs.getString(8)});
         sid=rs.getString(1);
        }
        int cid=Integer.parseInt(sid);
        cid=cid+1;
        sid=Integer.toString(cid);
        txtId.setText(sid);
        txtName.setText("");
         txtName.requestFocus();
         current_date();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_Information.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetailsActionPerformed

    private void txtReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReferenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReferenceActionPerformed
 public void add(){
        String name=txtName.getText();
        String address=txtAddress.getText();
        String sphoneNumber=txtPhonenumber.getText();
        String details=txtDetails.getText();
        String designation=comboDesignation.getSelectedItem().toString();
        String reference=txtReference.getText();
        long millis=System.currentTimeMillis();  
        java.sql.Date date2=new java.sql.Date(millis);  
         if(name.isEmpty()== true || address.isEmpty()==true||sphoneNumber.isEmpty()==true||details.isEmpty()==true||reference.isEmpty()==true){
            JOptionPane.showMessageDialog(this,"Please enter all records.");
        }
        else if(comboDesignation.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this,"Please select designation.");
        }
        else{ 
            try {
                pst=con.prepareStatement("insert into customer_information (name,address,phone_number,details,designation,reference,date) values(?,?,?,?,?,?,?)");
                pst.setString(1,name);
                pst.setString(2,address);
                int phoneNumber=Integer.parseInt(sphoneNumber);
                pst.setInt(3, phoneNumber);
                pst.setString(4,details);
                pst.setString(5,designation);
                pst.setString(6,reference);
                pst.setDate(7,date2);
                pst.executeUpdate(); 
                JOptionPane.showMessageDialog(this,"Data add success !!!!!");
                txtName.setText("");
                txtAddress.setText("");
                txtPhonenumber.setText("");
                txtDetails.setText("");
                comboDesignation.setSelectedIndex(0);
                txtReference.setText("");
              
            } catch (SQLException ex) {
                Logger.getLogger(Customer_Information.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   
        add();
        load();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtPhonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhonenumberActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed
public void update(){
        String id=txtId.getText();
         int i=Integer.parseInt(id);
       String name=txtName.getText();
        String address=txtAddress.getText();
        String sphoneNumber=txtPhonenumber.getText();
        String details=txtDetails.getText();
        String designation=comboDesignation.getSelectedItem().toString();
        String reference=txtReference.getText();
        long millis=System.currentTimeMillis();  
        java.sql.Date date2=new java.sql.Date(millis);  
         if(name.isEmpty()== true || address.isEmpty()==true||sphoneNumber.isEmpty()==true||details.isEmpty()==true||reference.isEmpty()==true){
            JOptionPane.showMessageDialog(this,"Please enter all records.");
        }
        else if(comboDesignation.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this,"Please select designation.");
        }
        else{
         try {
             pst=con.prepareStatement("update customer_information set name=?,address=?,phone_number=?,details=?,designation=?,reference=?,date=? where id=?");
            // pst.setInt(5,i);
             pst.setString(1,name);
             pst.setString(2, address);
             int phoneNumber=Integer.parseInt(sphoneNumber);
             pst.setInt(3,phoneNumber);
             pst.setString(4,details);
             pst.setString(5,designation);
             pst.setString(6,reference);
             pst.setDate(7,date2);
             pst.setInt(8,i);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(this,"Data update success !!!!!");
           //  clear();
                load();
             txtName.requestFocus();
         } catch (SQLException ex) {
             Logger.getLogger(Customer_Information.class.getName()).log(Level.SEVERE, null, ex);
         }
}}
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // update
        update();
        clear();
        load();
    }//GEN-LAST:event_jButton3ActionPerformed
 public void clear(){
         txtId.setText("");
         txtName.setText("");
                txtAddress.setText("");
                txtPhonenumber.setText("");
                txtDetails.setText("");
                comboDesignation.setSelectedIndex(0);
                txtReference.setText("");
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
          //selected 
         DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
         String tbid = dt.getValueAt(jTable1.getSelectedRow(),0).toString();
         String tbname = dt.getValueAt(jTable1.getSelectedRow(),1).toString();
         String tbaddress = dt.getValueAt(jTable1.getSelectedRow(),2).toString();
         String tbphone = dt.getValueAt(jTable1.getSelectedRow(),3).toString();
         String details= dt.getValueAt(jTable1.getSelectedRow(),4).toString();
         String designation = dt.getValueAt(jTable1.getSelectedRow(),5).toString();
         String reference = dt.getValueAt(jTable1.getSelectedRow(),6).toString();
         String date = dt.getValueAt(jTable1.getSelectedRow(),7).toString();
                txtId.setText(tbid);
                txtName.setText(tbname);
                txtAddress.setText(tbaddress);                            // Item Contructor Engineer Others
                txtPhonenumber.setText(tbphone);
                txtDetails.setText(details);
                txtReference.setText(reference);
                datebox.setText(date);
                int i=0;
                if(designation.equals("Contructor")){
                    i=1;
                }
                else if(designation.equals("Engineer")){
                    i=2;
                }
                else if(designation.equals("Others")){
                    i=3;
                }
                else{
                    i=0;
                }
                comboDesignation.setSelectedIndex(i);
                txtReference.setText(reference);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    try {
        // delete
        String id=txtId.getText();
        int i=Integer.parseInt(id);
        pst=con.prepareStatement("delete from customer_information where id=?");
        pst.setInt(1,i);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this,"Data delete success !!!!!");
        clear();
        load();
        txtName.requestFocus();
    } catch (SQLException ex) {
        Logger.getLogger(Customer_Information.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        clear();
        load();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        // show
        String id=txtId.getText();
        int i=Integer.parseInt(id);
        pst=con.prepareStatement("select *from customer_information where id=?");
        pst.setInt(1,i);
        rs=pst.executeQuery();
        while(rs.next()){
            txtName.setText(rs.getString(2));
            txtAddress.setText(rs.getString(3));
            txtPhonenumber.setText(rs.getString(4));
            txtDetails.setText(rs.getString(5));
            String designation= rs.getString(6);
            int j=0;
                if(designation.equals("Contructor")){
                    j=1;
                }
                else if(designation.equals("Engineer")){
                    j=2;
                }
                else if(designation.equals("Others")){
                    j=3;
                }
                else{
                    j=0;
                }
            comboDesignation.setSelectedIndex(j);
            txtReference.setText(rs.getString(7));
            datebox.setText(rs.getString(8));
        }     
    } catch (SQLException ex) {
        Logger.getLogger(Customer_Information.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void comboDesignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDesignationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDesignationActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new StartWindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Information().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDesignation;
    private javax.swing.JLabel datebox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDetails;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhonenumber;
    private javax.swing.JTextField txtReference;
    // End of variables declaration//GEN-END:variables

}

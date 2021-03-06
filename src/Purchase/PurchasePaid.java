/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Purchase;
import Main.StartWindow;
import Information_add.Supplier_information;
import com.mysql.jdbc.Connection;
import java.awt.event.KeyEvent;
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
public class PurchasePaid extends javax.swing.JFrame {

    /**
     * Creates new form PurchasePaid
     */
    public PurchasePaid() {
        initComponents();
        connect();    
        comboBox();        
    }
Connection con;    
PreparedStatement pst=null;
ResultSet rs=null,rs2=null,rs3=null; int oldAmounts=0;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        date = new javax.swing.JLabel();
        txtVoucharNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        companyNCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        oldAmount = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPaid = new javax.swing.JTextField();
        rbbkash = new javax.swing.JRadioButton();
        rbcash = new javax.swing.JRadioButton();
        rbcheck = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        due = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel2.setText("*Purchase Due Paid : ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 300, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Bill number", "Event", "Amount", "Discount", "Total", "Final amount", "Paid", "Due"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 1250, 220);
        jPanel1.add(date);
        date.setBounds(900, 10, 220, 30);

        txtVoucharNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVoucharNoActionPerformed(evt);
            }
        });
        jPanel1.add(txtVoucharNo);
        txtVoucharNo.setBounds(390, 50, 120, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Company Name :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 50, 120, 30);

        companyNCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item" }));
        companyNCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                companyNComboMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                companyNComboMouseEntered(evt);
            }
        });
        companyNCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyNComboActionPerformed(evt);
            }
        });
        jPanel1.add(companyNCombo);
        companyNCombo.setBounds(140, 50, 150, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Vouchar no. :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(300, 50, 90, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Old due :");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(10, 330, 150, 30);

        oldAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        oldAmount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        oldAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldAmountActionPerformed(evt);
            }
        });
        jPanel1.add(oldAmount);
        oldAmount.setBounds(10, 360, 150, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Paid :");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(170, 330, 140, 30);

        txtPaid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaidActionPerformed(evt);
            }
        });
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPaidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
        });
        jPanel1.add(txtPaid);
        txtPaid.setBounds(170, 360, 140, 30);

        buttonGroup1.add(rbbkash);
        rbbkash.setText("bKash");
        rbbkash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbbkashActionPerformed(evt);
            }
        });
        jPanel1.add(rbbkash);
        rbbkash.setBounds(660, 50, 60, 30);

        buttonGroup1.add(rbcash);
        rbcash.setText("Cash");
        rbcash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbcashActionPerformed(evt);
            }
        });
        jPanel1.add(rbcash);
        rbcash.setBounds(520, 50, 60, 30);

        buttonGroup1.add(rbcheck);
        rbcheck.setText("Check");
        rbcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbcheckActionPerformed(evt);
            }
        });
        jPanel1.add(rbcheck);
        rbcheck.setBounds(590, 50, 60, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(480, 360, 80, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Due :");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(320, 330, 140, 30);

        due.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        due.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        due.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueActionPerformed(evt);
            }
        });
        due.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dueKeyPressed(evt);
            }
        });
        jPanel1.add(due);
        due.setBounds(320, 360, 140, 30);

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(1165, 40, 90, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1286, 641));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void connect(){ 
        try {
            con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/chemical_company", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(PurchasePaid.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtVoucharNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVoucharNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVoucharNoActionPerformed

    private void oldAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldAmountActionPerformed

    private void txtPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidActionPerformed

    private void rbbkashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbbkashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbbkashActionPerformed

    private void rbcashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbcashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbcashActionPerformed

    private void rbcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbcheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbcheckActionPerformed
    public void comboBox(){
        try {
            pst=con.prepareStatement("SELECT company_name FROM supplier_information");
            rs3=pst.executeQuery();
             while(rs3.next()){
         companyNCombo.addItem(rs3.getString(1));
        }
        } catch (SQLException ex) {
            Logger.getLogger(PurchasePaid.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    public void calculate(){
        try {
            pst=con.prepareStatement("SELECT  SUM(total_price) FROM `product_purchase` WHERE `company_name`=? GROUP BY `company_name`");
            pst.setString(1,companyNCombo.getSelectedItem().toString());
            rs=pst.executeQuery();
            pst=con.prepareStatement("SELECT SUM(`paid`) FROM `purchase_due_paid` WHERE `company_name`=?\n" +
"GROUP BY `company_name`");
            pst.setString(1,companyNCombo.getSelectedItem().toString());
            rs2=pst.executeQuery();
             int paid=0;
             int totalPur=0;
            while(rs.next()){
                 totalPur=Integer.parseInt(rs.getString(1));}
            while(rs2.next()){
                 paid =Integer.parseInt(rs2.getString(1));
            }
            oldAmounts=totalPur-paid;
            String totalPurs=Integer.toString(oldAmounts);
            oldAmount.setText(totalPurs);
            
            }
           catch (SQLException ex) {
            Logger.getLogger(PurchasePaid.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        }    
    private void dueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dueActionPerformed
public void addAmount(){
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
        String voucharN=txtVoucharNo.getText();
        String events="";
        if(rbcash.isSelected()){
            events="Cash";
        }
        if(rbcheck.isSelected()){
            events="Check";
        }
        if(rbbkash.isSelected()){
            events="bKash";
        }
        String amounts="0";
        String discounts="0";
        String totals="0";
        String finalAmounts=oldAmount.getText();
        String paids=txtPaid.getText();
        String dues=due.getText();
        String companyn =companyNCombo.getSelectedItem().toString();
         if(voucharN.isEmpty()== true ||events.isEmpty()==true||
            finalAmounts.isEmpty()==true||paids.isEmpty()==true){
            JOptionPane.showMessageDialog(this,"Please enter all records.");
        }
         else if(companyNCombo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this,"Please select the items.");             
         } 
        else{ 
            try {
        int voucharni=Integer.parseInt(voucharN);
        int amounti=0;        
        int discounti=0;        
        int totali=0;        
        int finalAmounti=Integer.parseInt(finalAmounts);  
        int paidi=Integer.parseInt(paids);  
        int duei=Integer.parseInt(dues);  
                pst=con.prepareStatement("insert into purchase_due_paid(date,vouchar_number,event,amount,discount,total,final_amount,paid,due,company_name) values(?,?,?,?,?,?,?,?,?,?)");
                pst.setDate(1,date);
                pst.setInt(2,voucharni);
                pst.setString(3,events);
                pst.setInt(4,amounti);
                pst.setInt(5,discounti);
                pst.setInt(6,totali);
                pst.setInt(7,finalAmounti);
                pst.setInt(8,paidi);
                pst.setInt(9,duei);
                pst.setString(10,companyn);
                pst.executeUpdate(); 
                JOptionPane.showMessageDialog(this,"Data add success !!!!!");
                clear();
        calculate();
        showTable();
            } catch (SQLException ex) {
                Logger.getLogger(PurchasePaid.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    }
public void clear(){
    txtVoucharNo.setText("");
    txtPaid.setText("");
    due.setText("");
    buttonGroup1.clearSelection();
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addAmount();
        
    }//GEN-LAST:event_jButton1ActionPerformed
public void showTable(){
        try {
            DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
            dt.setRowCount(0);
            String scompany=companyNCombo.getSelectedItem().toString();
            pst=con.prepareStatement("select *from purchase_due_paid where company_name=?");
            pst.setString(1,scompany);
            rs=pst.executeQuery();
            while(rs.next()){
                dt.addRow(new Object[]{rs.getString(2),rs.getString(3),rs.getString(4)
                        ,rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchasePaid.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void select(){
      if(companyNCombo.getSelectedIndex()>=1){
             showTable();        
             calculate();
           
         }
      else{
           DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
            dt.setRowCount(0);
             clear();
             oldAmount.setText("");
             
      }
}
    private void companyNComboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyNComboMouseEntered
        // TODO add your handling code here:

                
    }//GEN-LAST:event_companyNComboMouseEntered

    private void companyNComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyNComboMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_companyNComboMouseClicked

    private void companyNComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyNComboActionPerformed
        // TODO add your handling code here:
        select();
    }//GEN-LAST:event_companyNComboActionPerformed

    private void dueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dueKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_dueKeyPressed

    private void txtPaidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){
             total();
    }
    }//GEN-LAST:event_txtPaidKeyPressed
 public void total(){
     if( txtPaid.getText().isEmpty()==false && oldAmount.getText().isEmpty()==false ){
         int total=Integer.parseInt(oldAmount.getText());
         int paid=Integer.parseInt(txtPaid.getText());
         total=total-paid;
         String dues=Integer.toString(total);
         due.setText(dues);
         }
     else{
         due.setText(oldAmount.getText());
     }
 }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new StartWindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
        // TODO add your handling code here:
        total();
    }//GEN-LAST:event_txtPaidKeyReleased

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
            java.util.logging.Logger.getLogger(PurchasePaid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchasePaid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchasePaid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchasePaid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchasePaid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> companyNCombo;
    private javax.swing.JLabel date;
    private javax.swing.JTextField due;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField oldAmount;
    private javax.swing.JRadioButton rbbkash;
    private javax.swing.JRadioButton rbcash;
    private javax.swing.JRadioButton rbcheck;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtVoucharNo;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;
import Main.StartWindow;
import com.mysql.jdbc.Connection;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sakib
 */
public class pSalesBillf extends javax.swing.JFrame {
    /**
     * Creates new form pSalesBillf
     */
    public pSalesBillf() {
       
        initComponents();
        connect();
        loadWindow();
        getData();
        setData();
        calculate();
        loadTable();
    }
Connection con;
PreparedStatement pst=null,pst2=null;
ResultSet rs=null,rs2=null,rs3=null,rs4=null,rs5=null,rs6=null,rs7=null,rs8=null,rs9=null,rs10=null,rs11=null;
int oldAmounts=0;
    public void connect(){ 
        try {
            con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/chemical_company", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(pSalesBillf.class.getName()).log(Level.SEVERE, null, ex);
        }
}
String date,productid,productname,purchaseprice,salesprice,quantity,totalprice,voucharnos,customername,employename,deliveryplace,quantitypack,letrkg;
String discount,final_amount,paid,due;
int voucharno=0;
public void loadWindow(){
     String sid="0";
        try {
            pst=con.prepareStatement("SELECT `vouchar_no` FROM `product_sales` WHERE id=(SELECT MAX(id) FROM `product_sales`);");
            rs=pst.executeQuery(); 
            while(rs.next()){
         voucharnos=rs.getString(1);
        }
            voucharno=Integer.parseInt(voucharnos);
        } catch (SQLException ex) {
            Logger.getLogger(pSalesBillf.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void getData(){
        try {
            pst=con.prepareStatement("SELECT *FROM product_sales WHERE `vouchar_no`= ?");
            pst.setInt(1, voucharno);
            rs=pst.executeQuery();
            while(rs.next()){
                 date=rs.getString(2);
                 productid=rs.getString(3);
                 productname=rs.getString(4);
                 purchaseprice=rs.getString(5);
                 salesprice=rs.getString(6);
                 quantity=rs.getString(7);
                 totalprice=rs.getString(8);
                 voucharnos=rs.getString(9); //,,,,;
                 customername=rs.getString(10);
                 employename=rs.getString(11);
                 deliveryplace=rs.getString(12);
                 quantitypack=rs.getString(13);
                 letrkg=rs.getString(14);
            }
            pst2=con.prepareStatement("SELECT *FROM product_sales_collection WHERE `vouchar_number`= ?");
            pst2.setInt(1, voucharno);
            rs2=pst2.executeQuery();
            while(rs2.next()){
                 discount=rs2.getString(6);
                 final_amount=rs2.getString(8);
                 paid=rs2.getString(9);
                 due=rs2.getString(10);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(pSalesBillf.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void calculate(){
        try {
            int vn=Integer.parseInt(voucharnos);
            pst=con.prepareStatement("SELECT SUM(total_price) FROM `product_sales` WHERE `vouchar_no`=? GROUP BY `vouchar_no`");
            pst.setInt(1,vn);
            rs=pst.executeQuery();
            pst=con.prepareStatement("SELECT  SUM(total_price) FROM `product_sales` WHERE (`customer_name`=? AND `vouchar_no`<>?)GROUP BY `customer_name`");
            pst.setString(1,customername);
            pst.setString(2,voucharnos);
            rs2=pst.executeQuery();
            pst=con.prepareStatement("SELECT SUM(`paid`) FROM `product_sales_collection` WHERE (`customer_name`=? AND `vouchar_number`<>?) GROUP BY `customer_name`");
            pst.setString(1,customername);
            pst.setString(2,voucharnos);
            rs3=pst.executeQuery();
             int paidtotal=0;
             int totalPur=0;
            while(rs.next()){
                totalAmountlbl.setText(rs.getString(1));
            }
            while(rs2.next()){
                 totalPur=Integer.parseInt(rs2.getString(1));}
            while(rs3.next()){
             paidtotal=Integer.parseInt(rs3.getString(1));
             // paid=paid+paidtotal;
            }
            oldAmounts=totalPur-paidtotal;
            String totalPurs=Integer.toString(oldAmounts);
            preAmount.setText(totalPurs);}
           catch (SQLException ex) {
            Logger.getLogger(pSalesBillf.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
public void loadTable(){
        try {
         DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
            dt.setRowCount(0);
            String svnumber="";
            svnumber=voucharnos;
            int vnumber=Integer.parseInt(svnumber);
            pst=con.prepareStatement("select *from product_sales where vouchar_no=?");
            pst.setInt(1,vnumber);
            rs4=pst.executeQuery();
             int serial=0;
        while(rs4.next()){
            serial=serial+1;
         dt.addRow(new Object[]{serial,rs4.getString(4),rs4.getString(7),rs4.getString(6)
                                ,rs4.getString(8)});
        }
        } catch (SQLException ex) {
            Logger.getLogger(pSalesBillf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void setData(){
      buyername.setText(customername);
      deliveryPlace.setText(deliveryplace);
      datelbl.setText(date);
      bnolbl.setText(voucharnos);
      discounttxt.setText(discount);   
      recAmounttxt.setText(paid);
      balancetxt.setText(due);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinField1 = new com.toedter.components.JSpinField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        printablePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        buyername = new javax.swing.JLabel();
        deliveryPlace = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        datelbl = new javax.swing.JLabel();
        totalAmountlbl = new javax.swing.JLabel();
        bnolbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        totalAmounttxt = new javax.swing.JTextField();
        discounttxt = new javax.swing.JTextField();
        recAmounttxt = new javax.swing.JTextField();
        preAmount = new javax.swing.JTextField();
        totalAmounttxt5 = new javax.swing.JTextField();
        totalAmounttxt6 = new javax.swing.JTextField();
        totalAmounttxt7 = new javax.swing.JTextField();
        balancetxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(470, 10, 100, 30);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(600, 10, 80, 30);

        printablePanel.setBackground(new java.awt.Color(255, 255, 255));
        printablePanel.setForeground(new java.awt.Color(255, 255, 255));
        printablePanel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("RMC");
        printablePanel.add(jLabel2);
        jLabel2.setBounds(30, 0, 80, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Chemical Company Limited");
        printablePanel.add(jLabel5);
        jLabel5.setBounds(30, 50, 250, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("All kinds of construction chemical & paints manufacturer");
        printablePanel.add(jLabel1);
        jLabel1.setBounds(110, 10, 350, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Challan/Invoice Bill");
        printablePanel.add(jLabel3);
        jLabel3.setBounds(540, 50, 150, 30);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText(" Name of the buyer :");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(12, 2, 150, 30);

        buyername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buyername.setText("buyername");
        jPanel4.add(buyername);
        buyername.setBounds(180, 0, 150, 35);

        deliveryPlace.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deliveryPlace.setText("deliveryPlace");
        jPanel4.add(deliveryPlace);
        deliveryPlace.setBounds(180, 30, 150, 35);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText(" Delivery place         : ");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(13, 30, 150, 37);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Bill No.        : ");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(360, 33, 100, 30);

        datelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        datelbl.setText("datebl");
        jPanel4.add(datelbl);
        datelbl.setBounds(480, 3, 150, 30);

        totalAmountlbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalAmountlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalAmountlbl.setText("total");
        jPanel4.add(totalAmountlbl);
        totalAmountlbl.setBounds(550, 300, 100, 30);

        bnolbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bnolbl.setText("bnolbl");
        jPanel4.add(bnolbl);
        bnolbl.setBounds(480, 33, 150, 30);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL", "Product", "Quantity/Packet", "Price", "Amount in Taka"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(153, 153, 255));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 640, 230);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText(" Date           : ");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(360, 3, 100, 30);

        totalAmounttxt.setText("      Recieved Amount  :");
        totalAmounttxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalAmounttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmounttxtActionPerformed(evt);
            }
        });
        jPanel4.add(totalAmounttxt);
        totalAmounttxt.setBounds(390, 420, 130, 30);

        discounttxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        discounttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discounttxtActionPerformed(evt);
            }
        });
        jPanel4.add(discounttxt);
        discounttxt.setBounds(520, 380, 130, 30);

        recAmounttxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        recAmounttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recAmounttxtActionPerformed(evt);
            }
        });
        jPanel4.add(recAmounttxt);
        recAmounttxt.setBounds(520, 420, 130, 30);

        preAmount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        preAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preAmountActionPerformed(evt);
            }
        });
        jPanel4.add(preAmount);
        preAmount.setBounds(520, 340, 130, 30);

        totalAmounttxt5.setText("       Previous Amount  :");
        totalAmounttxt5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalAmounttxt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmounttxt5ActionPerformed(evt);
            }
        });
        jPanel4.add(totalAmounttxt5);
        totalAmounttxt5.setBounds(390, 340, 130, 30);

        totalAmounttxt6.setText("       Discount               :");
        totalAmounttxt6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalAmounttxt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmounttxt6ActionPerformed(evt);
            }
        });
        jPanel4.add(totalAmounttxt6);
        totalAmounttxt6.setBounds(390, 380, 130, 30);

        totalAmounttxt7.setText("     Balance  :");
        totalAmounttxt7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalAmounttxt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmounttxt7ActionPerformed(evt);
            }
        });
        jPanel4.add(totalAmounttxt7);
        totalAmounttxt7.setBounds(390, 460, 130, 30);

        balancetxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        balancetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balancetxtActionPerformed(evt);
            }
        });
        jPanel4.add(balancetxt);
        balancetxt.setBounds(520, 460, 130, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jSeparator1);
        jSeparator1.setBounds(0, 334, 750, 10);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Total : ");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(490, 300, 70, 30);

        printablePanel.add(jPanel4);
        jPanel4.setBounds(30, 80, 660, 500);

        jLabel9.setText("...................................................");
        printablePanel.add(jLabel9);
        jLabel9.setBounds(470, 610, 220, 10);

        jLabel12.setText("............................................................");
        printablePanel.add(jLabel12);
        jLabel12.setBounds(30, 610, 230, 20);

        jLabel13.setText("For RMC Office");
        printablePanel.add(jLabel13);
        jLabel13.setBounds(510, 620, 120, 40);

        jLabel14.setText("Received By");
        printablePanel.add(jLabel14);
        jLabel14.setBounds(80, 620, 70, 40);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(printablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 217, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(-10, 50, 730, 690);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 720, 740);

        setSize(new java.awt.Dimension(736, 781));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        printRecord(printablePanel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new ProductSales().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void totalAmounttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmounttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmounttxtActionPerformed

    private void discounttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discounttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discounttxtActionPerformed

    private void recAmounttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recAmounttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recAmounttxtActionPerformed

    private void preAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preAmountActionPerformed

    private void totalAmounttxt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmounttxt5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmounttxt5ActionPerformed

    private void totalAmounttxt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmounttxt6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmounttxt6ActionPerformed

    private void totalAmounttxt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmounttxt7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmounttxt7ActionPerformed

    private void balancetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balancetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balancetxtActionPerformed
   private void printRecord(JPanel panel){
       PrinterJob printerJob= PrinterJob.getPrinterJob();
       printerJob.setJobName("Print record");
       printerJob.setPrintable(new Printable() {
           @Override
           public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
               if(pageIndex>0){
                   return Printable.NO_SUCH_PAGE;
               }
               Graphics2D graphics2d=(Graphics2D)graphics;
               graphics2d.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);
               graphics2d.scale(0.5,0.5);
               panel.paint(graphics2d);
               return Printable.PAGE_EXISTS;
           }
       });
       boolean returningResult = printerJob.printDialog();
       if(returningResult){
           try{
               printerJob.print();
           } catch (PrinterException ex) {
               JOptionPane.showMessageDialog(this, "Print Error "+ex.getMessage());
           }
           
       }
       
   }
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
            java.util.logging.Logger.getLogger(pSalesBillf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pSalesBillf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pSalesBillf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pSalesBillf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pSalesBillf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField balancetxt;
    private javax.swing.JLabel bnolbl;
    private javax.swing.JLabel buyername;
    private javax.swing.JLabel datelbl;
    private javax.swing.JLabel deliveryPlace;
    private javax.swing.JTextField discounttxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField preAmount;
    private javax.swing.JPanel printablePanel;
    private javax.swing.JTextField recAmounttxt;
    private javax.swing.JLabel totalAmountlbl;
    private javax.swing.JTextField totalAmounttxt;
    private javax.swing.JTextField totalAmounttxt5;
    private javax.swing.JTextField totalAmounttxt6;
    private javax.swing.JTextField totalAmounttxt7;
    // End of variables declaration//GEN-END:variables
}

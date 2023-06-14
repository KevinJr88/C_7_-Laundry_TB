/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import table.TableWorkOrder;

import control.CustomerControl;
import control.ServiceControl;
import control.WorkOrderControl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Customer;
import model.Employee;
import model.Service;
import model.WorkOrder;

/**
 *
 * @author Yeetman47
 */
public class riwayatBackUp extends javax.swing.JFrame {
private CustomerControl customerControl;
    private WorkOrderControl workOrderControl;
    private int menu = 0;
    private String action, id, jenisKelamin, temp;
    
    //WORK ORDER VIEW
    private CustomerControl cc;
    private ServiceControl sc;
    private WorkOrderControl wc;
    private  static Employee employee = null;
    List<Customer> listCustomer;
    List<Service> listService;
    int selectedId;
    private WorkOrder selectedWorkOrder = null;
    String action2;
    String diselesaikan;
    String diantarkan;
    
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    
    public riwayatBackUp(Employee employee) {
        initComponents();
        setEmployee(employee);
         wc = new WorkOrderControl();
        cc = new CustomerControl();
        sc = new ServiceControl();
        showDiambil();
        searchInput2.setText("");
    }
    public void showDiambil(){
        jTable2.setModel(wc.showWorkOrderDiambil());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTaiga = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        deleteBtn3 = new javax.swing.JButton();
        searchInput2 = new javax.swing.JTextField();
        searchBtn2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuTaiga.setBackground(new java.awt.Color(55, 121, 164));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        deleteBtn3.setText("Hapus");
        deleteBtn3.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn3.setForeground(new java.awt.Color(0, 0, 0));
        deleteBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn3ActionPerformed(evt);
            }
        });

        searchInput2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        searchInput2.setBackground(new java.awt.Color(255, 255, 255));
        searchInput2.setForeground(new java.awt.Color(0, 0, 0));
        searchInput2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInput2ActionPerformed(evt);
            }
        });

        searchBtn2.setText("Cari");
        searchBtn2.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn2.setForeground(new java.awt.Color(0, 0, 0));
        searchBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn2ActionPerformed(evt);
            }
        });

        jLabel11.setText("RIWAYAT");
        jLabel11.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        idInput.setBackground(new java.awt.Color(255, 255, 255));

        back.setText("BACK");
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuTaigaLayout = new javax.swing.GroupLayout(menuTaiga);
        menuTaiga.setLayout(menuTaigaLayout);
        menuTaigaLayout.setHorizontalGroup(
            menuTaigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTaigaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(menuTaigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuTaigaLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(menuTaigaLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back)
                        .addGap(76, 76, 76))
                    .addGroup(menuTaigaLayout.createSequentialGroup()
                        .addComponent(deleteBtn3)
                        .addContainerGap(815, Short.MAX_VALUE))
                    .addGroup(menuTaigaLayout.createSequentialGroup()
                        .addComponent(searchBtn2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(idInput)
        );
        menuTaigaLayout.setVerticalGroup(
            menuTaigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTaigaLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(menuTaigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuTaigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn2)
                    .addComponent(searchInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn3)
                .addGap(30, 30, 30)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(menuTaiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(menuTaiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        try{
            int clickedRow = jTable2.getSelectedRow();
            TableModel table = jTable2.getModel();

            idInput.setText(table.getValueAt(clickedRow, 0).toString());
        } catch(Exception e){
            System.out.println(e);
        }

    }//GEN-LAST:event_jTable2MouseClicked

    private void deleteBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn3ActionPerformed
        int getAnswer = JOptionPane.showConfirmDialog(rootPane,"Apakah yaking ingin menghapus data ? ", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        switch(getAnswer){
            case 0:
            try{
                workOrderControl.deleteDataWorkOrder(Integer.parseInt(idInput.getText()));
                searchInput2.setText("");
                showDiambil();
            }catch(Exception e){
                System.out.println("Error : "+e.getMessage());
            }
            break;
            case 1:
            break;
        }
    }//GEN-LAST:event_deleteBtn3ActionPerformed

    private void searchInput2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInput2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInput2ActionPerformed

    private void searchBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn2ActionPerformed
        try{
            TableWorkOrder wo = workOrderControl.showWorkOrder(searchInput2.getText());
            if(wo.getRowCount() == 0){
                searchInput2.setText("");
                JOptionPane.showConfirmDialog(rootPane, "Data tidak ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                jTable2.setModel(wo);
            }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }//GEN-LAST:event_searchBtn2ActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        MainMenuView mv = new MainMenuView(employee);
        this.dispose();
        mv.setVisible(true);
    }//GEN-LAST:event_backMouseClicked

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
            java.util.logging.Logger.getLogger(riwayatBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(riwayatBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(riwayatBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(riwayatBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new riwayatBackUp(employee).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton deleteBtn3;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel menuTaiga;
    private javax.swing.JButton searchBtn2;
    private javax.swing.JTextField searchInput2;
    // End of variables declaration//GEN-END:variables
}
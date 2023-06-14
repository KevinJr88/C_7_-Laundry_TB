/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.github.lgooddatepicker.components.DateTimePicker;
import control.CustomerControl;
import control.ServiceControl;
import control.WorkOrderControl;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Customer;
import model.Employee;
import model.Service;
import model.WorkOrder;
import table.TableWorkOrder;

/**
 *
 * @author Yeetman47
 */
public class prosesBackUp extends javax.swing.JFrame {
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
    /**
     * Creates new form antarBackUp
     */
    
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    public prosesBackUp(Employee employee) {
        try{
            initComponents();
            setEmployee(employee);
            wc = new WorkOrderControl();
            cc = new CustomerControl();
            sc = new ServiceControl();
            initDTInput(tglSelesai, LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(3));
            setComponentProses(false);
            clearTextProses();
            showProses();
        }catch(Exception E){
            System.out.println(E);
        }
        
    }
    
    
    public void setComponentProses(boolean value){
        customerDisplay1.setEnabled(value);
        bobotDisplay1.setEnabled(value);
        servisDisplay1.setEnabled(value);

        selesaiBtn3.setEnabled(value);
        tglSelesai.setEnabled(value);
        cancel.setEnabled(value);
        todayBtn.setEnabled(value);
    }
    
     public void  clearTextProses(){
        customerDisplay1.setText("");
        bobotDisplay1.setText("");
        servisDisplay1.setText("");
        tglSelesai.clear();
    }
    
    private void initDTInput(DateTimePicker input, LocalDate min, LocalDate max) {
         com.github.lgooddatepicker.components.DatePicker DP = input.getDatePicker();
        com.github.lgooddatepicker.components.TimePicker TP = input.getTimePicker();
        
        TP.setOpaque(false);
        DP.setOpaque(false);
        
        // Java passing by reference, jadi dengan melakukan ini, kita mendapatkan settings dari masing2 DatePicker dan TimePickernya, kemudian memodifikasinya kemudian.
        com.github.lgooddatepicker.components.DatePickerSettings thisDPs = DP.getSettings();
        com.github.lgooddatepicker.components.TimePickerSettings thisTPs = TP.getSettings();
        
        // Set settings:
        thisDPs.setLocale(new java.util.Locale("id"));
        thisDPs.setDateRangeLimits(min, max);
        thisTPs.use24HourClockFormat();
        
        // Set font:
        java.awt.Font elementFont = input.getFont();
        thisDPs.setFontVetoedDate(elementFont);
        thisDPs.setFontValidDate(elementFont);
        thisDPs.setFontInvalidDate(elementFont);
        thisTPs.fontValidTime = elementFont;
        thisTPs.fontInvalidTime = elementFont;
    }
    
    public void showProses(){
        prosesTable1.setModel(wc.showWorkOrderNotDone());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuEightnam = new javax.swing.JPanel();
        containerEightnam = new javax.swing.JPanel();
        searchInput5 = new javax.swing.JTextField();
        searchBtn5 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        prosesTable1 = new javax.swing.JTable();
        label2 = new java.awt.Label();
        donePanel = new javax.swing.JPanel();
        customerLabel3 = new javax.swing.JLabel();
        customerDisplay1 = new javax.swing.JTextField();
        bobotLabel3 = new javax.swing.JLabel();
        bobotDisplay1 = new javax.swing.JTextField();
        servisLabel3 = new javax.swing.JLabel();
        servisDisplay1 = new javax.swing.JTextField();
        selesaiBtn3 = new javax.swing.JButton();
        tglSelesai = new com.github.lgooddatepicker.components.DateTimePicker();
        todayBtn = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        containerEightnam.setBackground(new java.awt.Color(55, 121, 164));

        searchInput5.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        searchInput5.setBackground(new java.awt.Color(255, 255, 255));
        searchInput5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchInput5.setForeground(new java.awt.Color(0, 0, 0));

        searchBtn5.setText("Cari");
        searchBtn5.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn5.setForeground(new java.awt.Color(0, 0, 0));
        searchBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn5ActionPerformed(evt);
            }
        });

        prosesTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        prosesTable1.setBackground(new java.awt.Color(255, 255, 255));
        prosesTable1.setForeground(new java.awt.Color(0, 0, 0));
        prosesTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prosesTable1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(prosesTable1);

        label2.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("PROSES");

        donePanel.setBackground(new java.awt.Color(255, 255, 255));

        customerLabel3.setText("Customer");
        customerLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        customerLabel3.setForeground(new java.awt.Color(0, 0, 0));

        customerDisplay1.setEditable(false);
        customerDisplay1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        customerDisplay1.setBackground(new java.awt.Color(255, 255, 255));
        customerDisplay1.setForeground(new java.awt.Color(0, 0, 0));

        bobotLabel3.setText("Bobot");
        bobotLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        bobotLabel3.setForeground(new java.awt.Color(0, 0, 0));

        bobotDisplay1.setEditable(false);
        bobotDisplay1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        bobotDisplay1.setBackground(new java.awt.Color(255, 255, 255));
        bobotDisplay1.setForeground(new java.awt.Color(0, 0, 0));

        servisLabel3.setText("Jenis Servis");
        servisLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        servisLabel3.setForeground(new java.awt.Color(0, 0, 0));

        servisDisplay1.setEditable(false);
        servisDisplay1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        servisDisplay1.setBackground(new java.awt.Color(255, 255, 255));
        servisDisplay1.setForeground(new java.awt.Color(0, 0, 0));

        selesaiBtn3.setText("Selesai");
        selesaiBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesaiBtn3ActionPerformed(evt);
            }
        });

        todayBtn.setText("Today");
        todayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayBtnActionPerformed(evt);
            }
        });

        cancel.setText("cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout donePanelLayout = new javax.swing.GroupLayout(donePanel);
        donePanel.setLayout(donePanelLayout);
        donePanelLayout.setHorizontalGroup(
            donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(donePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(donePanelLayout.createSequentialGroup()
                        .addComponent(customerLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(todayBtn)
                        .addGap(18, 18, 18))
                    .addGroup(donePanelLayout.createSequentialGroup()
                        .addGroup(donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(donePanelLayout.createSequentialGroup()
                                .addComponent(servisLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(donePanelLayout.createSequentialGroup()
                                .addComponent(bobotLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                                .addComponent(tglSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(donePanelLayout.createSequentialGroup()
                        .addGroup(donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(servisDisplay1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                            .addComponent(customerDisplay1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bobotDisplay1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selesaiBtn3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel)
                        .addGap(16, 16, 16))))
        );
        donePanelLayout.setVerticalGroup(
            donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(donePanelLayout.createSequentialGroup()
                .addGroup(donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(donePanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(customerLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(customerDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(donePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(todayBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bobotLabel3)
                    .addComponent(tglSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bobotDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(servisLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servisDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selesaiBtn3)
                    .addComponent(cancel))
                .addGap(44, 44, 44))
        );

        back.setText("BACK");
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout containerEightnamLayout = new javax.swing.GroupLayout(containerEightnam);
        containerEightnam.setLayout(containerEightnamLayout);
        containerEightnamLayout.setHorizontalGroup(
            containerEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerEightnamLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(containerEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(containerEightnamLayout.createSequentialGroup()
                        .addGroup(containerEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(containerEightnamLayout.createSequentialGroup()
                                .addComponent(searchBtn5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchInput5, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(donePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(containerEightnamLayout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back)
                        .addGap(46, 46, 46))))
        );
        containerEightnamLayout.setVerticalGroup(
            containerEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerEightnamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(containerEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn5)
                    .addComponent(searchInput5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(donePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout menuEightnamLayout = new javax.swing.GroupLayout(menuEightnam);
        menuEightnam.setLayout(menuEightnamLayout);
        menuEightnamLayout.setHorizontalGroup(
            menuEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(menuEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuEightnamLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(containerEightnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        menuEightnamLayout.setVerticalGroup(
            menuEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
            .addGroup(menuEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuEightnamLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(containerEightnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(menuEightnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(menuEightnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn5ActionPerformed
        try{

            TableWorkOrder wo = workOrderControl.showWorkOrderNotDone();
            //TableCustomer customer = customerControl.showCustomer(searchInput.getText());
            if(wo.getRowCount() == 0){
                clearTextProses();
                JOptionPane.showConfirmDialog(rootPane, "Data tidak ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                prosesTable1.setModel(wo);
            }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }//GEN-LAST:event_searchBtn5ActionPerformed

    private void prosesTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prosesTable1MouseClicked
        selesaiBtn3.setEnabled(true);
        tglSelesai.setEnabled(true);
        cancel.setEnabled(true);
        todayBtn.setEnabled(true);

        int clickedRow = prosesTable1.getSelectedRow();
        TableModel table = prosesTable1.getModel();

        diselesaikan = table.getValueAt(clickedRow, 0).toString();
        customerDisplay1.setText(table.getValueAt(clickedRow, 1).toString());
        bobotDisplay1.setText(table.getValueAt(clickedRow, 3).toString());
        servisDisplay1.setText(table.getValueAt(clickedRow, 2).toString());
    }//GEN-LAST:event_prosesTable1MouseClicked

    private void selesaiBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiBtn3ActionPerformed

        String tglSelse  =   String.valueOf(tglSelesai.getDateTimeStrict());
        
        
        workOrderControl.updateWorkOrder(selectedWorkOrder, WIDTH);
        
    }//GEN-LAST:event_selesaiBtn3ActionPerformed

    private void todayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayBtnActionPerformed
        tglSelesai.datePicker.setDateToToday();
        tglSelesai.timePicker.setTimeToNow();
    }//GEN-LAST:event_todayBtnActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        clearTextProses();
    }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(prosesBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prosesBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prosesBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prosesBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prosesBackUp(employee).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JTextField bobotDisplay1;
    private javax.swing.JLabel bobotLabel3;
    private javax.swing.JButton cancel;
    private javax.swing.JPanel containerEightnam;
    private javax.swing.JTextField customerDisplay1;
    private javax.swing.JLabel customerLabel3;
    private javax.swing.JPanel donePanel;
    private javax.swing.JScrollPane jScrollPane7;
    private java.awt.Label label2;
    private javax.swing.JPanel menuEightnam;
    private javax.swing.JTable prosesTable1;
    private javax.swing.JButton searchBtn5;
    private javax.swing.JTextField searchInput5;
    private javax.swing.JButton selesaiBtn3;
    private javax.swing.JTextField servisDisplay1;
    private javax.swing.JLabel servisLabel3;
    private com.github.lgooddatepicker.components.DateTimePicker tglSelesai;
    private javax.swing.JButton todayBtn;
    // End of variables declaration//GEN-END:variables

    private void clearText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

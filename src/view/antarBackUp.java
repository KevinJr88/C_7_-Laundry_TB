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
public class antarBackUp extends javax.swing.JFrame {
    
    private int menu = 0;
    private double biaya;
    
    //WORK ORDER VIEW
 
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
    
    public antarBackUp(Employee employee) {
        initComponents();
        wc = new WorkOrderControl();
        setEmployee(employee);
        showAntar();
        setComponentAntar(false);
        clearTextAntar();
        initDTInput(tglDiambilAntar, LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(3));
    }
    public void showAntar(){
       prosesTable.setModel(wc.showWorkOrderDoneAntarYes());
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
    
    public void setComponentAntar(boolean value){
        customerDisplay.setEnabled(value);
        bobotDisplay.setEnabled(value);
        servisDisplay.setEnabled(value);
        selesaiBtn2.setEnabled(value);
        batalBtn.setEnabled(value);
        tglDiambilAntar.setEnabled(value);
        setDateNowAmbilBtn1.setEnabled(value);
        totalBiayaDisplay.setEnabled(value);
    }
    
    public void clearTextAntar(){
        searchInput3.setText("");
        customerDisplay.setText("");
        bobotDisplay.setText("");
        servisDisplay.setText("");
        tglDiambilAntar.clear();
        totalBiayaDisplay.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuAmpadt = new javax.swing.JPanel();
        searchInput3 = new javax.swing.JTextField();
        searchBtn3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        prosesTable = new javax.swing.JTable();
        label1 = new java.awt.Label();
        deliPanel = new javax.swing.JPanel();
        tglDiambilAntar = new com.github.lgooddatepicker.components.DateTimePicker();
        setDateNowAmbilBtn1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        customerLabel2 = new javax.swing.JLabel();
        customerDisplay = new javax.swing.JTextField();
        bobotLabel2 = new javax.swing.JLabel();
        bobotDisplay = new javax.swing.JTextField();
        servisLabel2 = new javax.swing.JLabel();
        servisDisplay = new javax.swing.JTextField();
        selesaiBtn2 = new javax.swing.JButton();
        batalBtn = new javax.swing.JButton();
        totalBiayaDisplay = new javax.swing.JTextField();
        servisLabel3 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuAmpadt.setBackground(new java.awt.Color(55, 121, 164));

        searchInput3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        searchInput3.setBackground(new java.awt.Color(255, 255, 255));
        searchInput3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchInput3.setForeground(new java.awt.Color(0, 0, 0));

        searchBtn3.setText("Cari");
        searchBtn3.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn3.setForeground(new java.awt.Color(0, 0, 0));
        searchBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn3ActionPerformed(evt);
            }
        });

        prosesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Tittle 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        prosesTable.setBackground(new java.awt.Color(255, 255, 255));
        prosesTable.setForeground(new java.awt.Color(0, 0, 0));
        prosesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prosesTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(prosesTable);

        label1.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("ANTAR LAUNDRY");

        deliPanel.setBackground(new java.awt.Color(255, 255, 255));

        setDateNowAmbilBtn1.setText("Sekarang");
        setDateNowAmbilBtn1.setBackground(new java.awt.Color(0, 255, 51));
        setDateNowAmbilBtn1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        setDateNowAmbilBtn1.setForeground(new java.awt.Color(255, 255, 255));
        setDateNowAmbilBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDateNowAmbilBtn1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Tanggal Antar");
        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));

        customerLabel2.setText("Customer");
        customerLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        customerLabel2.setForeground(new java.awt.Color(0, 0, 0));

        customerDisplay.setEditable(false);
        customerDisplay.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        customerDisplay.setBackground(new java.awt.Color(255, 255, 255));
        customerDisplay.setForeground(new java.awt.Color(0, 0, 0));

        bobotLabel2.setText("Bobot");
        bobotLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        bobotLabel2.setForeground(new java.awt.Color(0, 0, 0));

        bobotDisplay.setEditable(false);
        bobotDisplay.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        bobotDisplay.setBackground(new java.awt.Color(255, 255, 255));
        bobotDisplay.setForeground(new java.awt.Color(0, 0, 0));

        servisLabel2.setText("Jenis Servis");
        servisLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        servisLabel2.setForeground(new java.awt.Color(0, 0, 0));

        servisDisplay.setEditable(false);
        servisDisplay.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        servisDisplay.setBackground(new java.awt.Color(255, 255, 255));
        servisDisplay.setForeground(new java.awt.Color(0, 0, 0));

        selesaiBtn2.setText("Selesai");
        selesaiBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesaiBtn2ActionPerformed(evt);
            }
        });

        batalBtn.setText("Batal");
        batalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBtnActionPerformed(evt);
            }
        });

        totalBiayaDisplay.setEditable(false);
        totalBiayaDisplay.setBackground(new java.awt.Color(255, 255, 255));
        totalBiayaDisplay.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        totalBiayaDisplay.setForeground(new java.awt.Color(0, 0, 0));

        servisLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        servisLabel3.setForeground(new java.awt.Color(0, 0, 0));
        servisLabel3.setText("Total Biaya");

        javax.swing.GroupLayout deliPanelLayout = new javax.swing.GroupLayout(deliPanel);
        deliPanel.setLayout(deliPanelLayout);
        deliPanelLayout.setHorizontalGroup(
            deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deliPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deliPanelLayout.createSequentialGroup()
                        .addComponent(customerLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deliPanelLayout.createSequentialGroup()
                        .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(deliPanelLayout.createSequentialGroup()
                                .addComponent(totalBiayaDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selesaiBtn2)
                                .addGap(36, 36, 36)
                                .addComponent(batalBtn))
                            .addGroup(deliPanelLayout.createSequentialGroup()
                                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bobotLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(customerDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                        .addComponent(bobotDisplay))
                                    .addComponent(servisDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tglDiambilAntar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(setDateNowAmbilBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))
                    .addGroup(deliPanelLayout.createSequentialGroup()
                        .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servisLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servisLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        deliPanelLayout.setVerticalGroup(
            deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deliPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(customerLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(customerDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deliPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(setDateNowAmbilBtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tglDiambilAntar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selesaiBtn2)
                            .addComponent(batalBtn))
                        .addGap(44, 44, 44))
                    .addGroup(deliPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bobotLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bobotDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(servisLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(servisDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(servisLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalBiayaDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );

        back.setText("BACK");
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuAmpadtLayout = new javax.swing.GroupLayout(menuAmpadt);
        menuAmpadt.setLayout(menuAmpadtLayout);
        menuAmpadtLayout.setHorizontalGroup(
            menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAmpadtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAmpadtLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(menuAmpadtLayout.createSequentialGroup()
                                .addComponent(searchBtn3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(453, 453, 453))
                            .addGroup(menuAmpadtLayout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(back)
                                .addGap(82, 82, 82))))
                    .addGroup(menuAmpadtLayout.createSequentialGroup()
                        .addComponent(deliPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 226, Short.MAX_VALUE))
                    .addGroup(menuAmpadtLayout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addContainerGap())))
        );
        menuAmpadtLayout.setVerticalGroup(
            menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAmpadtLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn3)
                    .addComponent(searchInput3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deliPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(menuAmpadt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(menuAmpadt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn3ActionPerformed
         try{
            TableWorkOrder transaksi = wc.showWorkOrder(searchInput3.getText());

            if(transaksi.getRowCount() == 0){
                clearTextAntar();
                JOptionPane.showConfirmDialog(rootPane, "Data tidak ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                prosesTable.setModel(transaksi);
            }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }//GEN-LAST:event_searchBtn3ActionPerformed

    private void prosesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prosesTableMouseClicked
        selesaiBtn2.setEnabled(true);
        batalBtn.setEnabled(true);
        setDateNowAmbilBtn1.setEnabled(true);
        tglDiambilAntar.setEnabled(true);

        int clickedRow = prosesTable.getSelectedRow();
        TableModel table = prosesTable.getModel();
        int a = Integer.parseInt(table.getValueAt(clickedRow, 3).toString());
        double b = Double.parseDouble(table.getValueAt(clickedRow, 7).toString());
        biaya = a*b;
        totalBiayaDisplay.setText(String.valueOf(biaya));
        diantarkan = table.getValueAt(clickedRow, 0).toString();
        customerDisplay.setText(table.getValueAt(clickedRow, 1).toString());
        servisDisplay.setText(table.getValueAt(clickedRow, 2).toString());
        bobotDisplay.setText(table.getValueAt(clickedRow, 3).toString());
    }//GEN-LAST:event_prosesTableMouseClicked

    private void setDateNowAmbilBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDateNowAmbilBtn1ActionPerformed
        tglDiambilAntar.datePicker.setDateToToday();
        tglDiambilAntar.timePicker.setTimeToNow();
    }//GEN-LAST:event_setDateNowAmbilBtn1ActionPerformed

    private void selesaiBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiBtn2ActionPerformed
        String tglAmbil = String.valueOf(tglDiambilAntar.getDateTimeStrict());
        wc.updateStatusWorkOrder3(Integer.parseInt(diantarkan), "Diambil",tglAmbil, biaya);
        showAntar();
    }//GEN-LAST:event_selesaiBtn2ActionPerformed

    private void batalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBtnActionPerformed
        clearTextAntar();
    }//GEN-LAST:event_batalBtnActionPerformed

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
            java.util.logging.Logger.getLogger(antarBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(antarBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(antarBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(antarBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new antarBackUp(employee).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton batalBtn;
    private javax.swing.JTextField bobotDisplay;
    private javax.swing.JLabel bobotLabel2;
    private javax.swing.JTextField customerDisplay;
    private javax.swing.JLabel customerLabel2;
    private javax.swing.JPanel deliPanel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane5;
    private java.awt.Label label1;
    private javax.swing.JPanel menuAmpadt;
    private javax.swing.JTable prosesTable;
    private javax.swing.JButton searchBtn3;
    private javax.swing.JTextField searchInput3;
    private javax.swing.JButton selesaiBtn2;
    private javax.swing.JTextField servisDisplay;
    private javax.swing.JLabel servisLabel2;
    private javax.swing.JLabel servisLabel3;
    private javax.swing.JButton setDateNowAmbilBtn1;
    private com.github.lgooddatepicker.components.DateTimePicker tglDiambilAntar;
    private javax.swing.JTextField totalBiayaDisplay;
    // End of variables declaration//GEN-END:variables
}

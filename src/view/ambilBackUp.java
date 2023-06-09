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
public class ambilBackUp extends javax.swing.JFrame {

    private String action, id, jenisKelamin, temp;
    
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
    private double biaya;
    
    
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    
    public ambilBackUp(Employee employee) {
        initComponents();
        setEmployee(employee);
        wc = new WorkOrderControl();
        initDTInput(inputTglAmbil, LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(3));
        showSelesai();
        setComponentAmbil(false);
           
        clearTextAmbil();
    }
    
    public void setComponentAmbil(boolean value){
        totInput.setEnabled(value);
        cancelBtn2.setEnabled(value);
        selesaiBtn.setEnabled(value);
        setDateNowAmbilBtn.setEnabled(value);
        sCustomer.setEnabled(value);
        sTanggalJam.setEnabled(value);
        sLayanan.setEnabled(value);
        sBobot.setEnabled(value);
    }
    
   public void clearTextAmbil(){
        totInput.setText("");
        sCustomer.setText("");
        sLayanan.setText("");
        sBobot.setText("");
        sTanggalJam.setText("");
    }
    
    public void showSelesai(){
        rincianTable.setModel(wc.showWorkOrderDoneAntarNo());
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
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuDouea = new javax.swing.JPanel();
        pickupPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        sCustomer = new javax.swing.JTextField();
        cancelBtn2 = new javax.swing.JButton();
        selesaiBtn = new javax.swing.JButton();
        inputTglAmbil = new com.github.lgooddatepicker.components.DateTimePicker();
        setDateNowAmbilBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        totInput = new javax.swing.JTextField();
        sLayanan = new javax.swing.JTextField();
        sTanggalJam = new javax.swing.JTextField();
        sBobot = new javax.swing.JTextField();
        searchInput6 = new javax.swing.JTextField();
        searchBtn6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rincianTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuDouea.setBackground(new java.awt.Color(55, 121, 164));

        pickupPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Total Harga");
        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));

        sCustomer.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        sCustomer.setBackground(new java.awt.Color(255, 255, 255));
        sCustomer.setForeground(new java.awt.Color(0, 0, 0));
        sCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sCustomerActionPerformed(evt);
            }
        });

        cancelBtn2.setText("Cancel");
        cancelBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtn2ActionPerformed(evt);
            }
        });

        selesaiBtn.setText("Selesai");
        selesaiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesaiBtnActionPerformed(evt);
            }
        });

        setDateNowAmbilBtn.setText("Sekarang");
        setDateNowAmbilBtn.setBackground(new java.awt.Color(0, 255, 51));
        setDateNowAmbilBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        setDateNowAmbilBtn.setForeground(new java.awt.Color(255, 255, 255));
        setDateNowAmbilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDateNowAmbilBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Tanggal Ambil");
        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));

        totInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        totInput.setBackground(new java.awt.Color(255, 255, 255));
        totInput.setForeground(new java.awt.Color(0, 0, 0));
        totInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totInputActionPerformed(evt);
            }
        });

        sLayanan.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        sLayanan.setBackground(new java.awt.Color(255, 255, 255));
        sLayanan.setForeground(new java.awt.Color(0, 0, 0));
        sLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sLayananActionPerformed(evt);
            }
        });

        sTanggalJam.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        sTanggalJam.setBackground(new java.awt.Color(255, 255, 255));
        sTanggalJam.setForeground(new java.awt.Color(0, 0, 0));
        sTanggalJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sTanggalJamActionPerformed(evt);
            }
        });

        sBobot.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        sBobot.setBackground(new java.awt.Color(255, 255, 255));
        sBobot.setForeground(new java.awt.Color(0, 0, 0));
        sBobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sBobotActionPerformed(evt);
            }
        });

        searchInput6.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        searchInput6.setBackground(new java.awt.Color(255, 255, 255));
        searchInput6.setForeground(new java.awt.Color(0, 0, 0));
        searchInput6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInput6ActionPerformed(evt);
            }
        });

        searchBtn6.setText("Cari");
        searchBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn6ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nama");

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Bobot");

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Tanggal Masuk");

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Jenis Layanan");

        javax.swing.GroupLayout pickupPanelLayout = new javax.swing.GroupLayout(pickupPanel);
        pickupPanel.setLayout(pickupPanelLayout);
        pickupPanelLayout.setHorizontalGroup(
            pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pickupPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pickupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pickupPanelLayout.createSequentialGroup()
                        .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pickupPanelLayout.createSequentialGroup()
                        .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sBobot, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totInput, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sTanggalJam, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pickupPanelLayout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(selesaiBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelBtn2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputTglAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pickupPanelLayout.createSequentialGroup()
                                    .addComponent(searchInput6, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(searchBtn6))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(setDateNowAmbilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))))
        );
        pickupPanelLayout.setVerticalGroup(
            pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pickupPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchInput6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sBobot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pickupPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setDateNowAmbilBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTglAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(pickupPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sTanggalJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selesaiBtn)
                    .addComponent(cancelBtn2)
                    .addComponent(totInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        rincianTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        rincianTable.setBackground(new java.awt.Color(255, 255, 255));
        rincianTable.setForeground(new java.awt.Color(0, 0, 0));
        rincianTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rincianTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(rincianTable);

        jLabel1.setText("Rincian");
        jLabel1.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Ambil Laundry");
        jLabel10.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        back.setText("BACK");
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuDoueaLayout = new javax.swing.GroupLayout(menuDouea);
        menuDouea.setLayout(menuDoueaLayout);
        menuDoueaLayout.setHorizontalGroup(
            menuDoueaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuDoueaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(menuDoueaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuDoueaLayout.createSequentialGroup()
                        .addGroup(menuDoueaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(menuDoueaLayout.createSequentialGroup()
                        .addGroup(menuDoueaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(pickupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back)
                        .addGap(67, 67, 67))))
        );
        menuDoueaLayout.setVerticalGroup(
            menuDoueaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDoueaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuDoueaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pickupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(menuDouea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(menuDouea, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sCustomerActionPerformed

    private void cancelBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn2ActionPerformed

        clearTextAmbil();
    }//GEN-LAST:event_cancelBtn2ActionPerformed

    private void selesaiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiBtnActionPerformed
        String tglAmbil = String.valueOf(inputTglAmbil.getDateTimeStrict());
        wc.updateStatusWorkOrder2(Integer.parseInt(diselesaikan), "Diambil",tglAmbil,biaya);
        showSelesai();
    }//GEN-LAST:event_selesaiBtnActionPerformed

    private void setDateNowAmbilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDateNowAmbilBtnActionPerformed
        inputTglAmbil.datePicker.setDateToToday();
        inputTglAmbil.timePicker.setTimeToNow();
    }//GEN-LAST:event_setDateNowAmbilBtnActionPerformed

    private void totInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totInputActionPerformed

    private void sLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sLayananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sLayananActionPerformed

    private void sTanggalJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sTanggalJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sTanggalJamActionPerformed

    private void sBobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sBobotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sBobotActionPerformed

    private void searchInput6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInput6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInput6ActionPerformed

    private void searchBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn6ActionPerformed

        try{
            TableWorkOrder transaksi = wc.showWorkOrder(searchInput6.getText());

            if(transaksi.getRowCount() == 0){
                clearTextAmbil();
                JOptionPane.showConfirmDialog(rootPane, "Data tidak ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                rincianTable.setModel(transaksi);
            }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }//GEN-LAST:event_searchBtn6ActionPerformed

    private void rincianTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rincianTableMouseClicked
        setDateNowAmbilBtn.setEnabled(true);
        inputTglAmbil.setEnabled(true);
        selesaiBtn.setEnabled(true);
        cancelBtn2.setEnabled(true);
        int clickedRow = rincianTable.getSelectedRow();
        TableModel table = rincianTable.getModel();
        int a = Integer.parseInt(table.getValueAt(clickedRow, 3).toString());
        double b = Double.parseDouble(table.getValueAt(clickedRow, 7).toString());
        biaya = a*b;
        diselesaikan = table.getValueAt(clickedRow, 0).toString();
        totInput.setText(String.valueOf(biaya));
        sCustomer.setText(table.getValueAt(clickedRow, 1).toString());
        sTanggalJam.setText(table.getValueAt(clickedRow, 5).toString());
        sLayanan.setText(table.getValueAt(clickedRow, 2).toString());
        sBobot.setText(table.getValueAt(clickedRow, 3).toString());
        cancelBtn2.setSelected(true);
        selesaiBtn.setSelected(true);
    }//GEN-LAST:event_rincianTableMouseClicked

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
            java.util.logging.Logger.getLogger(ambilBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ambilBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ambilBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ambilBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ambilBackUp(employee).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton cancelBtn2;
    private com.github.lgooddatepicker.components.DateTimePicker inputTglAmbil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel menuDouea;
    private javax.swing.JPanel pickupPanel;
    private javax.swing.JTable rincianTable;
    private javax.swing.JTextField sBobot;
    private javax.swing.JTextField sCustomer;
    private javax.swing.JTextField sLayanan;
    private javax.swing.JTextField sTanggalJam;
    private javax.swing.JButton searchBtn6;
    private javax.swing.JTextField searchInput6;
    private javax.swing.JButton selesaiBtn;
    private javax.swing.JButton setDateNowAmbilBtn;
    private javax.swing.JTextField totInput;
    // End of variables declaration//GEN-END:variables
}

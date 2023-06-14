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
import model.Customer;
import model.Employee;
import model.Service;
import model.WorkOrder;
import table.TableWorkOrder;

/**
 *
 * @author Yeetman47
 */
public class transaksiBackUp extends javax.swing.JFrame {
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
    
    public transaksiBackUp(Employee employee) {
        initComponents();
        setEmployee(employee);
        cc = new CustomerControl();
            sc = new ServiceControl();
            wc = new WorkOrderControl();
            setComponentWorkOrder(false);
            setCustomerToDropDown();
            setServiceToDropDown();
            initDTInput(inputTglMasuk, LocalDate.now().minusYears(1), LocalDate.now().plusMonths(1));
            initDTInput(inputTglSelesai, LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(2));
            
            inputTglMasuk.addDateTimeChangeListener((com.github.lgooddatepicker.zinternaltools.DateTimeChangeEvent event) -> {
                setTglSelesai();
            });
            inputTglSelesai.setEnabled(false);
            clearTextWorkOrder();
           
           
                showWorkOrder();
    }
    
    public void setComponentWorkOrder(boolean value){
        
        editBtn2.setEnabled(value);
        deleteBtn2.setEnabled(value);
        
        saveBtn2.setEnabled(value);
        cancelBtn3.setEnabled(value);

        layananDd.setEnabled(value);
        customerDd2.setEnabled(value);
        bobotInput.setEnabled(value);
        inputTglMasuk.setEnabled(value);

        btnSetDTMasukNow.setEnabled(value);
  
    }
    
    public void setCustomerToDropDown(){
        listCustomer = cc.showListCustomer();
        for(int i=0; i<listCustomer.size(); i++){
            customerDd2.addItem(String.valueOf(listCustomer.get(i)));
        }
    }
    
    public void showWorkOrder(){
        jTable3.setModel(wc.showWorkOrderNotDone());
    }
    
    public void clearTextWorkOrder(){
        layananDd.setSelectedIndex(-1);
        customerDd2.setSelectedIndex(-1);
        bobotInput.setText("");
        inputTglMasuk.clear();
        inputTglSelesai.clear();
        searchInput4.setText("");
    }
    
    public void setServiceToDropDown(){
        listService = sc.showListService();
        for(int i=0; i<listService.size(); i++){
            layananDd.addItem(String.valueOf(listService.get(i)));
        }
    } 
    
    private void setTglSelesai() {
        if(layananDd.getSelectedIndex() == -1 || getFullDateTime(inputTglMasuk) == null) {

        } else {   
            int selectedIndex2 =  layananDd.getSelectedIndex();
            Service s = listService.get(selectedIndex2);
            inputTglSelesai.setDateTimeStrict(inputTglMasuk.getDateTimeStrict().plusDays(s.getKecepatan()));
        }
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
     
     private String getFullDateTime(DateTimePicker input) {
        try {
            // getDateTimeStrinct() kemudian ubah ke format "yyyy-MM-dd HH:mm:ss"
            return input.getDateTimeStrict().format(WorkOrder.DEFAULT_DTF);
        } catch (Exception e) {
            // Input date atau time belum diisi lengkap
            return null;
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

        menuLiejma = new javax.swing.JPanel();
        transPanel = new javax.swing.JPanel();
        customerDd2 = new javax.swing.JComboBox<>();
        layananDd = new javax.swing.JComboBox<>();
        bobotInput = new javax.swing.JTextField();
        inputTglMasuk = new com.github.lgooddatepicker.components.DateTimePicker();
        customerLabel = new javax.swing.JLabel();
        bobotLabel = new javax.swing.JLabel();
        jenisLayananLabel = new javax.swing.JLabel();
        tanggalMasuk = new javax.swing.JLabel();
        addBtn2 = new javax.swing.JButton();
        editBtn2 = new javax.swing.JButton();
        deleteBtn2 = new javax.swing.JButton();
        inputTglSelesai = new com.github.lgooddatepicker.components.DateTimePicker();
        tanggalSelesai = new javax.swing.JLabel();
        btnSetDTMasukNow = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        saveBtn2 = new javax.swing.JButton();
        cancelBtn3 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        searchInput4 = new javax.swing.JTextField();
        searchBtn4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuLiejma.setBackground(new java.awt.Color(55, 121, 164));

        transPanel.setBackground(new java.awt.Color(255, 255, 255));

        customerDd2.setBackground(new java.awt.Color(255, 255, 255));
        customerDd2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        customerDd2.setForeground(new java.awt.Color(0, 0, 0));
        customerDd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerDd2ActionPerformed(evt);
            }
        });

        layananDd.setBackground(new java.awt.Color(255, 255, 255));
        layananDd.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        layananDd.setForeground(new java.awt.Color(0, 0, 0));

        bobotInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        bobotInput.setBackground(new java.awt.Color(255, 255, 255));
        bobotInput.setForeground(new java.awt.Color(0, 0, 0));

        customerLabel.setText("Customer");
        customerLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        customerLabel.setForeground(new java.awt.Color(0, 0, 0));

        bobotLabel.setText("Bobot");
        bobotLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        bobotLabel.setForeground(new java.awt.Color(0, 0, 0));

        jenisLayananLabel.setText("Jenis Layanan");
        jenisLayananLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jenisLayananLabel.setForeground(new java.awt.Color(0, 0, 0));

        tanggalMasuk.setText("Tanggal Masuk");
        tanggalMasuk.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tanggalMasuk.setForeground(new java.awt.Color(0, 0, 0));

        addBtn2.setText("Tambah");
        addBtn2.setBackground(new java.awt.Color(255, 255, 255));
        addBtn2.setForeground(new java.awt.Color(0, 0, 0));
        addBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn2ActionPerformed(evt);
            }
        });

        editBtn2.setText("Ubah");
        editBtn2.setBackground(new java.awt.Color(255, 255, 255));
        editBtn2.setForeground(new java.awt.Color(0, 0, 0));
        editBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn2ActionPerformed(evt);
            }
        });

        deleteBtn2.setText("Hapus");
        deleteBtn2.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn2.setForeground(new java.awt.Color(0, 0, 0));
        deleteBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn2ActionPerformed(evt);
            }
        });

        tanggalSelesai.setText("Tanggal Selesai");
        tanggalSelesai.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tanggalSelesai.setForeground(new java.awt.Color(0, 0, 0));

        btnSetDTMasukNow.setText("Today");
        btnSetDTMasukNow.setBackground(new java.awt.Color(0, 255, 0));
        btnSetDTMasukNow.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnSetDTMasukNow.setForeground(new java.awt.Color(255, 255, 255));
        btnSetDTMasukNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetDTMasukNowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout transPanelLayout = new javax.swing.GroupLayout(transPanel);
        transPanel.setLayout(transPanelLayout);
        transPanelLayout.setHorizontalGroup(
            transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggalSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(transPanelLayout.createSequentialGroup()
                        .addComponent(addBtn2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBtn2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn2))
                    .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(layananDd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jenisLayananLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bobotLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(transPanelLayout.createSequentialGroup()
                            .addComponent(tanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSetDTMasukNow))
                        .addComponent(inputTglMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bobotInput)
                        .addComponent(customerDd2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputTglSelesai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        transPanelLayout.setVerticalGroup(
            transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn2)
                    .addComponent(editBtn2)
                    .addComponent(deleteBtn2))
                .addGap(18, 18, 18)
                .addComponent(customerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerDd2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bobotLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bobotInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tanggalMasuk)
                    .addComponent(btnSetDTMasukNow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTglMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tanggalSelesai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTglSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jenisLayananLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(layananDd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setBackground(new java.awt.Color(255, 255, 255));
        jTable3.setForeground(new java.awt.Color(0, 0, 0));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable3);

        saveBtn2.setText("Simpan");
        saveBtn2.setBackground(new java.awt.Color(255, 255, 255));
        saveBtn2.setForeground(new java.awt.Color(0, 0, 0));
        saveBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtn2ActionPerformed(evt);
            }
        });

        cancelBtn3.setText("Batal");
        cancelBtn3.setBackground(new java.awt.Color(255, 255, 255));
        cancelBtn3.setForeground(new java.awt.Color(0, 0, 0));
        cancelBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtn3ActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(55, 121, 164));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        searchInput4.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        searchInput4.setBackground(new java.awt.Color(255, 255, 255));
        searchInput4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchInput4.setForeground(new java.awt.Color(0, 0, 0));

        searchBtn4.setText("Cari");
        searchBtn4.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn4.setForeground(new java.awt.Color(0, 0, 0));
        searchBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn4ActionPerformed(evt);
            }
        });

        jLabel8.setText("TRANSAKSI");
        jLabel8.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        back.setText("BACK");
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuLiejmaLayout = new javax.swing.GroupLayout(menuLiejma);
        menuLiejma.setLayout(menuLiejmaLayout);
        menuLiejmaLayout.setHorizontalGroup(
            menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLiejmaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLiejmaLayout.createSequentialGroup()
                        .addGroup(menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuLiejmaLayout.createSequentialGroup()
                                .addComponent(searchBtn4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(menuLiejmaLayout.createSequentialGroup()
                                .addComponent(transPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(menuLiejmaLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back)
                        .addGap(59, 59, 59))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLiejmaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelBtn3)
                .addGap(62, 62, 62))
        );
        menuLiejmaLayout.setVerticalGroup(
            menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLiejmaLayout.createSequentialGroup()
                .addGroup(menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(menuLiejmaLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(back))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchInput4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(transPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn2)
                    .addComponent(cancelBtn3))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 932, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuLiejma, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuLiejma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerDd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerDd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerDd2ActionPerformed

    private void addBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn2ActionPerformed
        setComponentWorkOrder(true);
        saveBtn2.setEnabled(true);
        editBtn2.setEnabled(false);
        deleteBtn2.setEnabled(false);
        clearTextWorkOrder();
        searchInput4.setText("");
        action = "Tambah";
    }//GEN-LAST:event_addBtn2ActionPerformed

    private void editBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn2ActionPerformed
        setComponentWorkOrder(true);
        action = "Ubah";
    }//GEN-LAST:event_editBtn2ActionPerformed

    private void deleteBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn2ActionPerformed
        int getAnswer = JOptionPane.showConfirmDialog(rootPane,"Apakah yaking ingin menghapus data ? ", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        int clickedRow = jTable3.getSelectedRow();
        switch(getAnswer){
            case 0:
            try{
                wc.deleteDataWorkOrder(Integer.parseInt(jTable3.getValueAt(clickedRow, 0).toString()));
                clearTextWorkOrder();
                showWorkOrder();
                setComponentWorkOrder(false);
            }catch(Exception e){
                System.out.println("Error : "+e.getMessage());
            }
            break;
            case 1:
            break;
        }
    }//GEN-LAST:event_deleteBtn2ActionPerformed

    private void btnSetDTMasukNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetDTMasukNowActionPerformed
        inputTglMasuk.datePicker.setDateToToday();
        inputTglMasuk.timePicker.setTimeToNow();
    }//GEN-LAST:event_btnSetDTMasukNowActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        int indexCustomer = -1;
        int indexService = -1;

        setComponentWorkOrder(false);
        editBtn2.setEnabled(true);
        deleteBtn2.setEnabled(true);
        try{
            int clickedRow = jTable3.getSelectedRow();
            selectedId = Integer.parseInt(jTable3.getValueAt(clickedRow, 0).toString());
            String nama = jTable3.getValueAt(clickedRow, 1).toString();
            for(Customer customer : listCustomer){
                if(customer.getNama_customer().equals(nama)){
                    indexCustomer = listCustomer.indexOf(customer);
                }
            }
            customerDd2.setSelectedIndex(indexCustomer);

            String nama2 = jTable3.getValueAt(clickedRow, 2).toString();
            for(Service service : listService){
                if(String.valueOf(service.getNama_layanan()).equals(nama2)){
                    indexService = listService.indexOf(service);
                }
            }
            layananDd.setSelectedIndex(indexService);

            bobotInput.setText(jTable3.getValueAt(clickedRow, 3).toString());

            // Display to input:
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void saveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn2ActionPerformed
        try{

            int selectedIndex = customerDd2.getSelectedIndex();
            Customer c = listCustomer.get(selectedIndex);

            int selectedIndex2 =  layananDd.getSelectedIndex();
            Service s = listService.get(selectedIndex2);

            double biaya = s.getBiaya() * Integer.parseInt(bobotInput.getText());

            WorkOrder wo = new WorkOrder(String.valueOf(inputTglMasuk.getDateTimeStrict()),
                String.valueOf(inputTglSelesai.getDateTimeStrict()),
                "-",
                Integer.parseInt(bobotInput.getText()),
                "Proses",
                c,
                employee,
                s,
                biaya
            );

            if(action.equalsIgnoreCase("Tambah")){
                wc.insertDataWorkOrder(wo);
            }else{
                wc.updateWorkOrder(wo,selectedId);
                selectedId = -1;
            }

            clearTextWorkOrder();
            showWorkOrder();
            setComponentWorkOrder(false);
        }catch(Exception e){
            System.out.println("Gagal save data");
            System.out.println(e);
            clearTextWorkOrder();
            showWorkOrder();
            setComponentWorkOrder(false);
        }
    }//GEN-LAST:event_saveBtn2ActionPerformed

    private void cancelBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn3ActionPerformed
        setComponentWorkOrder(false);
        clearTextWorkOrder();
    }//GEN-LAST:event_cancelBtn3ActionPerformed

    private void searchBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn4ActionPerformed
        setComponentWorkOrder(false);

        try{
            TableWorkOrder transaksi = wc.showWorkOrder(searchInput4.getText());

            if(transaksi.getRowCount() == 0){
                clearTextWorkOrder();
                editBtn2.setEnabled(false);
                deleteBtn2.setEnabled(false);
                JOptionPane.showConfirmDialog(rootPane, "Data tidak ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                jTable3.setModel(transaksi);
            }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }//GEN-LAST:event_searchBtn4ActionPerformed

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
            java.util.logging.Logger.getLogger(transaksiBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksiBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksiBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksiBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksiBackUp(employee).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn2;
    private javax.swing.JLabel back;
    private javax.swing.JTextField bobotInput;
    private javax.swing.JLabel bobotLabel;
    private javax.swing.JButton btnSetDTMasukNow;
    private javax.swing.JButton cancelBtn3;
    private javax.swing.JComboBox<String> customerDd2;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JButton deleteBtn2;
    private javax.swing.JButton editBtn2;
    private com.github.lgooddatepicker.components.DateTimePicker inputTglMasuk;
    private com.github.lgooddatepicker.components.DateTimePicker inputTglSelesai;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel jenisLayananLabel;
    private javax.swing.JComboBox<String> layananDd;
    private javax.swing.JPanel menuLiejma;
    private javax.swing.JButton saveBtn2;
    private javax.swing.JButton searchBtn4;
    private javax.swing.JTextField searchInput4;
    private javax.swing.JLabel tanggalMasuk;
    private javax.swing.JLabel tanggalSelesai;
    private javax.swing.JPanel transPanel;
    // End of variables declaration//GEN-END:variables
}

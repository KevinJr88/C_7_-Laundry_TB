/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.github.lgooddatepicker.components.DateTimePicker;
import control.CustomerControl;
import control.WorkOrderControl;
import control.ServiceControl;
import control.EmployeeControl;
import java.time.LocalDate;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


import model.Employee;
import model.Customer;
import model.Service;
import model.WorkOrder;

import table.TableWorkOrder;


public class workorderView extends javax.swing.JFrame {
    private CustomerControl cc;
    private ServiceControl sc;
    private WorkOrderControl wc;
    private  static Employee employee;
    List<Customer> listCustomer;
    List<Service> listService;
    int selectedId;
    private WorkOrder selectedWorkOrder = null;
    String action;

   
    
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    
    public workorderView(Employee employee) {
        initComponents();
        initDTInput(inputTglMasuk, LocalDate.now().minusYears(1), LocalDate.now().plusMonths(1));
        initDTInput(inputTglSelesai, LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(2));
        inputTglMasuk.addDateTimeChangeListener((com.github.lgooddatepicker.zinternaltools.DateTimeChangeEvent event) -> {
            // tgl masuk berubah, recheck tgl ambil
            //this.setTglSelesai();
        });
        
        setEmployee(employee);
        setComponent(false);
        cc = new CustomerControl();
        sc = new ServiceControl();
        wc = new WorkOrderControl();
        showWorkOrder();
        setCustomerToDropDown();
        setServiceToDropDown();
        clearText();
        
    }
    
    public void setComponent(boolean value){
       editBtn.setEnabled(value);
       deleteBtn.setEnabled(value);
       saveBtn.setEnabled(value);
       cancelBtn.setEnabled(value);
       
    }
    
    public void clearText(){
        bobotInput.setText("");
        customerDd.setSelectedItem(ABORT);
        layananDd.setSelectedItem(ABORT);
        inputTglMasuk.clear();
        inputTglSelesai.clear();
        
            
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
    
    private Object getTableSelectedObject(javax.swing.JTable table) {
        if (table.getSelectedRow() != -1) {
            return table.getModel().getValueAt(table.getSelectedRow(), 99);
        } else {
            return null;
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
    
    
    public void showWorkOrder(){
        workOrderTable.setModel(wc.showWorkOrderNotDone(""));
    }
    
    public void setCustomerToDropDown(){
        listCustomer = cc.showListCustomer();
        for(int i=0; i<listCustomer.size(); i++){
            customerDd.addItem(String.valueOf(listCustomer.get(i)));
        }
    }
    
    public void setServiceToDropDown(){
        listService = sc.showListService();
        for(int i=0; i<listService.size(); i++){
            layananDd.addItem(String.valueOf(listService.get(i)));
        }
    }
    
     private void btnResetTglMasukActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        inputTglMasuk.setDateTimeStrict(null);
    }   
    
    
//    private void setTglSelesai() {
//        if(ddKecepatan.getSelectedIndex() == -1 || getFullDateTime(inputTglMasuk) == null) {
//            // Kecepatan belum dipilih ATAU (checkbox cuci dan checkbox setrika belum ada yang dicentang): belum bisa dihitung tanggal ambil
//            outTotalHarga.setText("-");
//        } else {
//            // Dapatkan dulu kecepatannya express atau reguler?
//            String kec = (String) ddKecepatan.getSelectedItem();
//            if(kec.equalsIgnoreCase("EXPRESS")) {
//                // 6 jam
//                inputTglSelesai.setDateTimeStrict(inputTglMasuk.getDateTimeStrict().plusHours(6));
//            } else {
//                // 2 hari
//                inputTglSelesai.setDateTimeStrict(inputTglMasuk.getDateTimeStrict().plusDays(2));
//            }
//            // cek tgl ambil < tgl selesai pas mau simpan saja
//        }
//    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarPan = new javax.swing.JPanel();
        headerPan = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();
        opPanel = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        customerLabel = new javax.swing.JLabel();
        customerDd = new javax.swing.JComboBox<>();
        namaLabel = new javax.swing.JLabel();
        bobotInput = new javax.swing.JTextField();
        layananLabel = new javax.swing.JLabel();
        layananDd = new javax.swing.JComboBox<>();
        tanggalLabel = new javax.swing.JLabel();
        inputTglMasuk = new com.github.lgooddatepicker.components.DateTimePicker();
        inputTglSelesai = new com.github.lgooddatepicker.components.DateTimePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        workOrderTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidebarPan.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout sidebarPanLayout = new javax.swing.GroupLayout(sidebarPan);
        sidebarPan.setLayout(sidebarPanLayout);
        sidebarPanLayout.setHorizontalGroup(
            sidebarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );
        sidebarPanLayout.setVerticalGroup(
            sidebarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        headerPan.setBackground(new java.awt.Color(51, 255, 255));

        titleLabel.setText("Work Order");
        titleLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout headerPanLayout = new javax.swing.GroupLayout(headerPan);
        headerPan.setLayout(headerPanLayout);
        headerPanLayout.setHorizontalGroup(
            headerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanLayout.setVerticalGroup(
            headerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        containerPanel.setBackground(new java.awt.Color(255, 255, 255));

        opPanel.setBackground(new java.awt.Color(255, 255, 153));

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opPanelLayout = new javax.swing.GroupLayout(opPanel);
        opPanel.setLayout(opPanelLayout);
        opPanelLayout.setHorizontalGroup(
            opPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opPanelLayout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn)
                .addContainerGap())
        );
        opPanelLayout.setVerticalGroup(
            opPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opPanelLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(opPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(deleteBtn)
                    .addComponent(editBtn))
                .addContainerGap())
        );

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        searchInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        searchInput.setBackground(new java.awt.Color(255, 255, 255));
        searchInput.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchInput.setForeground(new java.awt.Color(0, 0, 0));

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel6.setText("Transaksi");
        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        customerLabel.setText("Pilih Customer");
        customerLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        customerLabel.setForeground(new java.awt.Color(0, 0, 0));

        customerDd.setBackground(new java.awt.Color(255, 255, 255));
        customerDd.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        customerDd.setForeground(new java.awt.Color(0, 0, 0));
        customerDd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerDdActionPerformed(evt);
            }
        });

        namaLabel.setText("Bobot");
        namaLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(0, 0, 0));

        bobotInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        bobotInput.setText("jTextField1");
        bobotInput.setBackground(new java.awt.Color(255, 255, 255));
        bobotInput.setForeground(new java.awt.Color(0, 0, 0));
        bobotInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bobotInputActionPerformed(evt);
            }
        });

        layananLabel.setText("Jenis Layanan");
        layananLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        layananLabel.setForeground(new java.awt.Color(0, 0, 0));

        layananDd.setBackground(new java.awt.Color(255, 255, 255));
        layananDd.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        layananDd.setForeground(new java.awt.Color(0, 0, 0));
        layananDd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layananDdActionPerformed(evt);
            }
        });

        tanggalLabel.setText("Tanggal");
        tanggalLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tanggalLabel.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerDd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bobotInput, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(layananLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(layananDd, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inputTglMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerDd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaLabel)
                    .addComponent(layananLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bobotInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(layananDd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tanggalLabel)
                .addGap(12, 12, 12)
                .addComponent(inputTglMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        workOrderTable.setModel(new javax.swing.table.DefaultTableModel(
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
        workOrderTable.setBackground(new java.awt.Color(255, 255, 255));
        workOrderTable.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        workOrderTable.setForeground(new java.awt.Color(0, 0, 0));
        workOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workOrderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(workOrderTable);

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerPanelLayout.createSequentialGroup()
                        .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(containerPanelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(254, 254, 254)
                                .addComponent(saveBtn)
                                .addGap(39, 39, 39)
                                .addComponent(cancelBtn))
                            .addGroup(containerPanelLayout.createSequentialGroup()
                                .addComponent(opPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(searchBtn))
                            .addGroup(containerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(inputTglSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(containerPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerPanelLayout.createSequentialGroup()
                        .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(opPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, containerPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchBtn)
                                    .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveBtn)
                        .addComponent(cancelBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTglSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        setComponent(true);
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        clearText();
        searchInput.setText("");
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        setComponent(true);
        action = "Ubah";
    }//GEN-LAST:event_editBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
         setComponent(false);
        
        try{
            TableWorkOrder transaksi = wc.showWorkOrder(searchInput.getText());
      
            if(transaksi.getRowCount() == 0){
                clearText();
                editBtn.setEnabled(false);
                deleteBtn.setEnabled(false);
                JOptionPane.showConfirmDialog(rootPane, "Data tidak ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                workOrderTable.setModel(transaksi);
            }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }

    }//GEN-LAST:event_searchBtnActionPerformed

    private void workOrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workOrderTableMouseClicked
        int indexCustomer = -1;
        int indexService = -1;
        
        WorkOrder selectedW = (WorkOrder) getTableSelectedObject(workOrderTable);
        
         int clickedRow = workOrderTable.getSelectedRow();
        // Set the selected id --> having `0` means that we will be adding new data, not updating
        selectedId = selectedW.getId_transaksi();
        
        inputTglMasuk.setDateTimeStrict(selectedW.getTanggal_masuk());
        inputTglSelesai.setDateTimeStrict(selectedW.getTanggal_selesai());
        
        String nama = workOrderTable.getValueAt(clickedRow, 1).toString();
        for(Customer customer : listCustomer){
               if(customer.getNama_customer().equals(nama)){
                   indexCustomer = listCustomer.indexOf(customer);
               }
           }
        customerDd.setSelectedIndex(indexCustomer);

        String nama2 = workOrderTable.getValueAt(clickedRow, 2).toString();
        for(Service service : listService){
               if(String.valueOf(service.getNama_layanan()).equals(nama2)){
                   indexService = listService.indexOf(service);
               }
           }
        layananDd.setSelectedIndex(indexService);    
        
        bobotInput.setText(workOrderTable.getValueAt(clickedRow, 3).toString());
        
        // Display to input:
      
    }//GEN-LAST:event_workOrderTableMouseClicked

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        setComponent(false);
        clearText();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        Customer c = (Customer) customerDd.getSelectedItem();
        Service s = (Service) layananDd.getSelectedItem();
        
        if(action.equalsIgnoreCase("Tambah")){
            Penyewaan py = new Penyewaan(inputLamaSewa.getText(), Float.parseFloat(inputTotalHarga.getText()) , snack+", "+masker+ ", "+tissue, selectedKendaraan, selectedCustomer );
            penyewaanControl.insertPenyewaan(py);
        } else if(action.equalsIgnoreCase("Ubah")){
            Penyewaan py = new Penyewaan(selectedId, inputLamaSewa.getText(), Float.parseFloat(inputTotalHarga.getText()) , snack+", "+masker+ ", "+tissue, selectedKendaraan, selectedCustomer );
            penyewaanControl.updateDataPenyewaan(py);
        }
           
            clearText();
            showWorkOrder();
            setComponent(false);
        
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void customerDdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerDdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerDdActionPerformed

    private void bobotInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bobotInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bobotInputActionPerformed

    private void layananDdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layananDdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_layananDdActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int getAnswer = JOptionPane.showConfirmDialog(rootPane,"Apakah yaking ingin menghapus data ? ", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    
        int clickedRow = workOrderTable.getSelectedRow();
        switch(getAnswer){
            case 0:
                try{
                    wc.deleteDataWorkOrder(Integer.parseInt(workOrderTable.getValueAt(clickedRow, 0).toString()));
                    clearText();
                    showWorkOrder();
                    setComponent(false);
                }catch(Exception e){
                    System.out.println("Error : "+e.getMessage());
                }
                break;
            case 1:
                break;
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(workorderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(workorderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(workorderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(workorderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Employee Employee = null;
                new workorderView(employee).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField bobotInput;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JComboBox<String> customerDd;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JPanel headerPan;
    private com.github.lgooddatepicker.components.DateTimePicker inputTglMasuk;
    private com.github.lgooddatepicker.components.DateTimePicker inputTglSelesai;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> layananDd;
    private javax.swing.JLabel layananLabel;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JPanel opPanel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JPanel sidebarPan;
    private javax.swing.JLabel tanggalLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTable workOrderTable;
    // End of variables declaration//GEN-END:variables
}

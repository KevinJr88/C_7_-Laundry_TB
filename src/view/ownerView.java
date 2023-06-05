/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.CustomerControl;
import control.EmployeeControl;


import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Employee;


import table.TableEmployee;
public class ownerView extends javax.swing.JFrame {
    
    
    private EmployeeControl employeeControl;
    private String action;
    private String id, status, posisi, temp1;
    private int temp;
    /**
     * Creates new form ownerView
     */
    public ownerView() {
        initComponents();
          setComponent(false);
          idInput.setEnabled(false);
          employeeControl = new EmployeeControl();
          showCustomer();
          clearText();
    }
    
    public void setComponent(boolean value){
       editBtn.setEnabled(value);
       deleteBtn.setEnabled(value);
      
       namaInput.setEnabled(value);
       telpInput.setEnabled(value);
       passInput.setEnabled(value);
       statDd.setEnabled(value);
       jabDd.setEnabled(value);
       
       saveBtn.setEnabled(value);
       cancelBtn.setEnabled(value);
    }
    
     public void clearText(){
        namaInput.setText("");
        telpInput.setText("");
        passInput.setText("");
        idInput.setText("");
        searchInput.setText("");
    }
     
     public void showCustomer(){
        employeeTable.setModel(employeeControl.showDataEmployee());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarPan = new javax.swing.JPanel();
        Laundry_logo = new javax.swing.JLabel();
        headerPan = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        containerPan = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        opPan = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        namaInput = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passInput = new javax.swing.JTextField();
        telpLabel = new javax.swing.JLabel();
        telpInput = new javax.swing.JTextField();
        statLabel = new javax.swing.JLabel();
        statDd = new javax.swing.JComboBox<>();
        jabLabel = new javax.swing.JLabel();
        jabDd = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidebarPan.setBackground(new java.awt.Color(51, 204, 255));

        Laundry_logo.setForeground(new java.awt.Color(0, 0, 0));
        Laundry_logo.setText("Label");

        javax.swing.GroupLayout sidebarPanLayout = new javax.swing.GroupLayout(sidebarPan);
        sidebarPan.setLayout(sidebarPanLayout);
        sidebarPanLayout.setHorizontalGroup(
            sidebarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Laundry_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        sidebarPanLayout.setVerticalGroup(
            sidebarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Laundry_logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        headerPan.setBackground(new java.awt.Color(255, 255, 153));

        titleLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 255, 255));
        titleLabel.setText("Owner Operation Page");

        javax.swing.GroupLayout headerPanLayout = new javax.swing.GroupLayout(headerPan);
        headerPan.setLayout(headerPanLayout);
        headerPanLayout.setHorizontalGroup(
            headerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanLayout.setVerticalGroup(
            headerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        containerPan.setBackground(new java.awt.Color(255, 255, 255));
        containerPan.setForeground(new java.awt.Color(0, 0, 0));

        idLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("ID");

        idInput.setBackground(new java.awt.Color(255, 255, 255));
        idInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        idInput.setForeground(new java.awt.Color(0, 0, 0));
        idInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idInputActionPerformed(evt);
            }
        });

        opPan.setBackground(new java.awt.Color(51, 204, 255));

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

        javax.swing.GroupLayout opPanLayout = new javax.swing.GroupLayout(opPan);
        opPan.setLayout(opPanLayout);
        opPanLayout.setHorizontalGroup(
            opPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opPanLayout.createSequentialGroup()
                .addContainerGap(317, Short.MAX_VALUE)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn)
                .addGap(12, 12, 12)
                .addComponent(editBtn)
                .addGap(25, 25, 25))
        );
        opPanLayout.setVerticalGroup(
            opPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opPanLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(opPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn))
                .addContainerGap())
        );

        searchBtn.setBackground(new java.awt.Color(153, 255, 255));
        searchBtn.setForeground(new java.awt.Color(0, 0, 0));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        searchInput.setBackground(new java.awt.Color(255, 255, 255));
        searchInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        searchInput.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nama");

        namaInput.setBackground(new java.awt.Color(255, 255, 255));
        namaInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        namaInput.setForeground(new java.awt.Color(0, 0, 0));

        passLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        passLabel.setForeground(new java.awt.Color(0, 0, 0));
        passLabel.setText("Password");

        passInput.setBackground(new java.awt.Color(255, 255, 255));
        passInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        passInput.setForeground(new java.awt.Color(0, 0, 0));

        telpLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        telpLabel.setForeground(new java.awt.Color(0, 0, 0));
        telpLabel.setText("Nomor Telepon");

        telpInput.setBackground(new java.awt.Color(255, 255, 255));
        telpInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        telpInput.setForeground(new java.awt.Color(0, 0, 0));

        statLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        statLabel.setForeground(new java.awt.Color(0, 0, 0));
        statLabel.setText("Status");

        statDd.setBackground(new java.awt.Color(255, 255, 255));
        statDd.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        statDd.setForeground(new java.awt.Color(0, 0, 0));
        statDd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Tidak Aktif", " " }));
        statDd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statDdActionPerformed(evt);
            }
        });

        jabLabel.setForeground(new java.awt.Color(0, 0, 0));
        jabLabel.setText("Jabatan");

        jabDd.setBackground(new java.awt.Color(255, 255, 255));
        jabDd.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jabDd.setForeground(new java.awt.Color(0, 0, 0));
        jabDd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Petugas Kasir", "Kurir" }));
        jabDd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabDdActionPerformed(evt);
            }
        });

        employeeTable.setBackground(new java.awt.Color(255, 255, 255));
        employeeTable.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        employeeTable.setForeground(new java.awt.Color(0, 0, 0));
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(employeeTable);

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerPanLayout = new javax.swing.GroupLayout(containerPan);
        containerPan.setLayout(containerPanLayout);
        containerPanLayout.setHorizontalGroup(
            containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanLayout.createSequentialGroup()
                .addComponent(opPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn)
                .addGap(34, 34, 34))
            .addGroup(containerPanLayout.createSequentialGroup()
                .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerPanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(telpInput, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerPanLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passInput, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idInput)
                                .addComponent(namaInput, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addComponent(telpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(232, 232, 232)
                .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jabDd, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statDd, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jabLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(458, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerPanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addGap(18, 18, 18)
                .addComponent(cancelBtn)
                .addGap(89, 89, 89))
        );
        containerPanLayout.setVerticalGroup(
            containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanLayout.createSequentialGroup()
                .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerPanLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBtn)
                            .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(idLabel)
                .addGap(13, 13, 13)
                .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statLabel)
                    .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statDd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jabLabel)
                    .addComponent(namaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jabDd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telpInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(containerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(containerPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(headerPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(containerPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
         int getAnswer = JOptionPane.showConfirmDialog(rootPane,"Apakah yaking ingin menghapus data ? ", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        switch(getAnswer){
            case 0:
                try{
                    
                    employeeControl.deleteDataEmployee(idInput.getText());
                    clearText();
                    showCustomer();
                    setComponent(false);
                }catch(Exception e){
                    System.out.println("Error : "+e.getMessage());
                }
                break;
            case 1:
                break;
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInputActionPerformed

    private void statDdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statDdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statDdActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        setComponent(true);
        action = "Ubah";
    }//GEN-LAST:event_editBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        setComponent(true);
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        clearText();
        searchInput.setText("");
        id = employeeControl.generateIDKaryawan();
        idInput.setText(id);
        action = "Tambah";
    }//GEN-LAST:event_addBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try{
           temp = statDd.getSelectedIndex();
           switch(temp){
               case 0:
                   status = "Aktif";
                   break;
               case 1:
                   status = "Tidak Aktif";
                   break;
           }
           temp = jabDd.getSelectedIndex();
           switch(temp){
               case 0:
                   posisi = "Petugas Kasir";
                   break;
               case 1:
                   posisi = "Kurir";
                   break;
           }
            Employee e = new Employee(idInput.getText(), namaInput.getText(), passInput.getText(), Integer.parseInt(telpInput.getText()), status, posisi);
           
            if(action.equals("Tambah")){
                employeeControl.insertDataEmployee(e);
            }else{
                employeeControl.updateDataEmployee(e, idInput.getText());
            }
            clearText();
            showCustomer();
            setComponent(false);
        }catch (Exception e){
            System.out.println("Gagal menyimpan data");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void jabDdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabDdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jabDdActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        setComponent(false);
        clearText();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        setComponent(false);
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        
        int clickedRow = employeeTable.getSelectedRow();
        TableModel table = employeeTable.getModel();
        
        
        idInput.setText(table.getValueAt(clickedRow, 0).toString());
        namaInput.setText(table.getValueAt(clickedRow, 1).toString());
        passInput.setText(table.getValueAt(clickedRow, 2).toString());
        telpInput.setText(table.getValueAt(clickedRow, 3).toString());
        temp1 = table.getValueAt(clickedRow, 4).toString();
        
        if(temp1.equalsIgnoreCase("Aktif")){
            statDd.setSelectedIndex(0);
        }else{
            statDd.setSelectedIndex(1);
        }
        
        temp1 = table.getValueAt(clickedRow, 5).toString();
        
        if(temp1.equalsIgnoreCase("Kurir")){
            jabDd.setSelectedIndex(1);
        }else{
            jabDd.setSelectedIndex(0);
        }
    }//GEN-LAST:event_employeeTableMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        setComponent(false);
        
        try{
           TableEmployee employee = employeeControl.showDataBySearch(searchInput.getText());
            if(employee.getRowCount() == 0){
                clearText();
                editBtn.setEnabled(false);
                deleteBtn.setEnabled(false);
                JOptionPane.showConfirmDialog(rootPane, "Data tidak ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                employeeTable.setModel(employee);
            }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }//GEN-LAST:event_searchBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ownerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ownerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ownerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ownerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ownerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Laundry_logo;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel containerPan;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTable employeeTable;
    private javax.swing.JPanel headerPan;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jabDd;
    private javax.swing.JLabel jabLabel;
    private javax.swing.JTextField namaInput;
    private javax.swing.JPanel opPan;
    private javax.swing.JTextField passInput;
    private javax.swing.JLabel passLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JPanel sidebarPan;
    private javax.swing.JComboBox<String> statDd;
    private javax.swing.JLabel statLabel;
    private javax.swing.JTextField telpInput;
    private javax.swing.JLabel telpLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.CustomerControl;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Customer;


import table.TableCustomer;

public class customerView extends javax.swing.JFrame {

    private CustomerControl customerControl;
    private String action;
    private String id;
    private String jenisKelamin, temp;
    
    
    
    public customerView() {
        try{
          initComponents();
          setComponent(false);
          idInput.setEnabled(false);
          customerControl = new CustomerControl();
          showCustomer();
          clearText();
        }catch(Exception e){
            System.out.println("error CustomerView");
        }    
      
     }
    
    public void setComponent(boolean value){
       editBtn.setEnabled(value);
       deleteBtn.setEnabled(value);
       namaInput.setEnabled(value);
       telpInput.setEnabled(value);
       alamatInput.setEnabled(value);
       jenisKelamin1RBtn.setEnabled(value);
       jenisKelamin2RBtn.setEnabled(value);
       jenisKelamin1RBtn.setSelected(value);
       jenisKelamin2RBtn.setSelected(value);
       saveBtn.setEnabled(value);
       cancelBtn.setEnabled(value);
    }
    
    public void clearText(){
        namaInput.setText("");
        telpInput.setText("");
        alamatInput.setText("");
        idInput.setText("");
    }
    
    public void showCustomer(){
        customerTable.setModel(customerControl.showDataCustomer());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenKelGroup = new javax.swing.ButtonGroup();
        sidebarPan = new javax.swing.JPanel();
        headerPan = new javax.swing.JPanel();
        containerPanel4 = new javax.swing.JPanel();
        opPanel4 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        namaLabel = new javax.swing.JLabel();
        namaInput = new javax.swing.JTextField();
        alamatLabel = new javax.swing.JLabel();
        alamatInput = new javax.swing.JTextField();
        telpLabel = new javax.swing.JLabel();
        telpInput = new javax.swing.JTextField();
        jenisKelamin1RBtn = new javax.swing.JRadioButton();
        jenisKelamin2RBtn = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidebarPan.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout sidebarPanLayout = new javax.swing.GroupLayout(sidebarPan);
        sidebarPan.setLayout(sidebarPanLayout);
        sidebarPanLayout.setHorizontalGroup(
            sidebarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );
        sidebarPanLayout.setVerticalGroup(
            sidebarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        headerPan.setBackground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout headerPanLayout = new javax.swing.GroupLayout(headerPan);
        headerPan.setLayout(headerPanLayout);
        headerPanLayout.setHorizontalGroup(
            headerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        headerPanLayout.setVerticalGroup(
            headerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        containerPanel4.setBackground(new java.awt.Color(255, 255, 255));

        opPanel4.setBackground(new java.awt.Color(255, 255, 153));

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

        javax.swing.GroupLayout opPanel4Layout = new javax.swing.GroupLayout(opPanel4);
        opPanel4.setLayout(opPanel4Layout);
        opPanel4Layout.setHorizontalGroup(
            opPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opPanel4Layout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn)
                .addContainerGap())
        );
        opPanel4Layout.setVerticalGroup(
            opPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opPanel4Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(opPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(deleteBtn)
                    .addComponent(editBtn))
                .addContainerGap())
        );

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

        namaLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaLabel.setText("Nama");

        namaInput.setBackground(new java.awt.Color(255, 255, 255));
        namaInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        namaInput.setForeground(new java.awt.Color(0, 0, 0));
        namaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaInputActionPerformed(evt);
            }
        });

        alamatLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        alamatLabel.setForeground(new java.awt.Color(0, 0, 0));
        alamatLabel.setText("Alamat");

        alamatInput.setBackground(new java.awt.Color(255, 255, 255));
        alamatInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        alamatInput.setForeground(new java.awt.Color(0, 0, 0));

        telpLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        telpLabel.setForeground(new java.awt.Color(0, 0, 0));
        telpLabel.setText("Nomor Telepon");

        telpInput.setBackground(new java.awt.Color(255, 255, 255));
        telpInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        telpInput.setForeground(new java.awt.Color(0, 0, 0));

        jenisKelamin1RBtn.setBackground(new java.awt.Color(255, 255, 255));
        jenKelGroup.add(jenisKelamin1RBtn);
        jenisKelamin1RBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jenisKelamin1RBtn.setForeground(new java.awt.Color(0, 0, 0));
        jenisKelamin1RBtn.setText("Laki-laki");
        jenisKelamin1RBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisKelamin1RBtnActionPerformed(evt);
            }
        });

        jenisKelamin2RBtn.setBackground(new java.awt.Color(255, 255, 255));
        jenKelGroup.add(jenisKelamin2RBtn);
        jenisKelamin2RBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jenisKelamin2RBtn.setForeground(new java.awt.Color(0, 0, 0));
        jenisKelamin2RBtn.setText("Perempuan");
        jenisKelamin2RBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisKelamin2RBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Jenis Kelamin");

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        searchInput.setBackground(new java.awt.Color(255, 255, 255));
        searchInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        searchInput.setForeground(new java.awt.Color(0, 0, 0));
        searchInput.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputActionPerformed(evt);
            }
        });

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

        customerTable.setBackground(new java.awt.Color(255, 255, 255));
        customerTable.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        customerTable.setForeground(new java.awt.Color(0, 0, 0));
        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(customerTable);

        javax.swing.GroupLayout containerPanel4Layout = new javax.swing.GroupLayout(containerPanel4);
        containerPanel4.setLayout(containerPanel4Layout);
        containerPanel4Layout.setHorizontalGroup(
            containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerPanel4Layout.createSequentialGroup()
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alamatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(containerPanel4Layout.createSequentialGroup()
                                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(telpInput, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(alamatInput, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(idLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(idInput, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(namaLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(namaInput, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(telpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(253, 253, 253)
                                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jenisKelamin1RBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jenisKelamin2RBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveBtn)
                    .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelBtn)
                    .addComponent(searchBtn))
                .addGap(33, 33, 33))
        );
        containerPanel4Layout.setVerticalGroup(
            containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanel4Layout.createSequentialGroup()
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBtn)
                            .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(70, 70, 70)
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idLabel)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namaLabel))
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addComponent(jenisKelamin1RBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jenisKelamin2RBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alamatLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alamatInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(telpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addComponent(telpInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerPanel4Layout.createSequentialGroup()
                        .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelBtn)
                            .addComponent(saveBtn))
                        .addGap(30, 30, 30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(containerPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containerPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        setComponent(true);
        action = "Ubah";
    }//GEN-LAST:event_editBtnActionPerformed

    private void idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInputActionPerformed

    private void namaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaInputActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        setComponent(true);
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        clearText();
        searchInput.setText("");
        id = customerControl.generateIDCustomer();
        idInput.setText(id);
        action = "Tambah";
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
         int getAnswer = JOptionPane.showConfirmDialog(rootPane,"Apakah yaking ingin menghapus data ? ", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        switch(getAnswer){
            case 0:
                try{
                    customerControl.deleteDataCustomer(idInput.getText());
                    //customerControl.deleteCustomer(selectedId);
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

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
       
    }//GEN-LAST:event_searchInputActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
         try{
           
            Customer c = new Customer(idInput.getText(), namaInput.getText(), Integer.parseInt(telpInput.getText()) , alamatInput.getText(), jenisKelamin );               
            if(action.equals("Tambah")){
                customerControl.insertDataCustomer(c);
            }else{
                customerControl.updateDataCustomer(c, idInput.getText());
            }
            clearText();
            showCustomer();
            setComponent(false);
        }catch (Exception e){
            System.out.println("Gagal menyimpan data");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void jenisKelamin1RBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisKelamin1RBtnActionPerformed
        jenisKelamin = "Laki-laki";
    }//GEN-LAST:event_jenisKelamin1RBtnActionPerformed

    private void jenisKelamin2RBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisKelamin2RBtnActionPerformed
        jenisKelamin = "Perempuan";
    }//GEN-LAST:event_jenisKelamin2RBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        setComponent(false);
        clearText();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        setComponent(false);
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        
        int clickedRow = customerTable.getSelectedRow();
        TableModel table = customerTable.getModel();
        
        
        idInput.setText(table.getValueAt(clickedRow, 0).toString());
        namaInput.setText(table.getValueAt(clickedRow, 1).toString());
        telpInput.setText(table.getValueAt(clickedRow, 2).toString());
        alamatInput.setText(table.getValueAt(clickedRow, 3).toString());
        
        temp = table.getValueAt(clickedRow, 4).toString();
        if(temp.equalsIgnoreCase("Laki-laki")){
            jenisKelamin1RBtn.setEnabled(false);
            jenisKelamin2RBtn.setEnabled(false);
            jenisKelamin1RBtn.setSelected(true);
            jenisKelamin2RBtn.setSelected(false);
        }else{
            jenisKelamin1RBtn.setEnabled(false);
            jenisKelamin2RBtn.setEnabled(false);
            jenisKelamin1RBtn.setSelected(false);
            jenisKelamin2RBtn.setSelected(true);
        }
    }//GEN-LAST:event_customerTableMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
         setComponent(false);
        
        try{
           TableCustomer customer = customerControl.showDataBySearch(searchInput.getText());
            if(customer.getRowCount() == 0){
                clearText();
                editBtn.setEnabled(false);
                deleteBtn.setEnabled(false);
                JOptionPane.showConfirmDialog(rootPane, "Data tidak ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                customerTable.setModel(customer);
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
            java.util.logging.Logger.getLogger(customerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField alamatInput;
    private javax.swing.JLabel alamatLabel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel containerPanel4;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JPanel headerPan;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup jenKelGroup;
    private javax.swing.JRadioButton jenisKelamin1RBtn;
    private javax.swing.JRadioButton jenisKelamin2RBtn;
    private javax.swing.JTextField namaInput;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JPanel opPanel4;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JPanel sidebarPan;
    private javax.swing.JTextField telpInput;
    private javax.swing.JLabel telpLabel;
    // End of variables declaration//GEN-END:variables
}

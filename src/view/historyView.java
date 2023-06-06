/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Yeetman47
 */
public class historyView extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    public historyView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenLayabuttonGroup = new javax.swing.ButtonGroup();
        sidebarPan = new javax.swing.JPanel();
        historyPanel = new javax.swing.JPanel();
        historyIcon = new javax.swing.JLabel();
        historyLabel = new javax.swing.JLabel();
        headerPan = new javax.swing.JPanel();
        judulLabel = new javax.swing.JLabel();
        storeLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        storeLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        containerPanel4 = new javax.swing.JPanel();
        NamaKaryLabel = new javax.swing.JLabel();
        NamaKaryInput = new javax.swing.JTextField();
        namaCustLabel = new javax.swing.JLabel();
        namaCustInput = new javax.swing.JTextField();
        bobotLabel = new javax.swing.JLabel();
        bobotInput = new javax.swing.JTextField();
        tglMasukLabel = new javax.swing.JLabel();
        tglMasukInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tglSelesaiLabel = new javax.swing.JLabel();
        tglSelesaiInput = new javax.swing.JTextField();
        tglAmbilLabel = new javax.swing.JLabel();
        tglAmbilInput = new javax.swing.JTextField();
        jRadioButtonReg = new javax.swing.JRadioButton();
        jRadioButtonKilat = new javax.swing.JRadioButton();
        jRadioButtonRegDev = new javax.swing.JRadioButton();
        editBtn4 = new javax.swing.JButton();
        deleteBtn4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidebarPan.setBackground(new java.awt.Color(0, 88, 171));

        historyPanel.setBackground(new java.awt.Color(251, 217, 20));
        historyPanel.setForeground(new java.awt.Color(204, 204, 204));

        historyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-history-48.png"))); // NOI18N

        historyLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        historyLabel.setForeground(new java.awt.Color(0, 0, 0));
        historyLabel.setText("Riwayat");

        javax.swing.GroupLayout historyPanelLayout = new javax.swing.GroupLayout(historyPanel);
        historyPanel.setLayout(historyPanelLayout);
        historyPanelLayout.setHorizontalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(historyIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyLabel)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        historyPanelLayout.setVerticalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyPanelLayout.createSequentialGroup()
                .addGroup(historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(historyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(historyIcon))
                    .addGroup(historyPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(historyLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidebarPanLayout = new javax.swing.GroupLayout(sidebarPan);
        sidebarPan.setLayout(sidebarPanLayout);
        sidebarPanLayout.setHorizontalGroup(
            sidebarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(historyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidebarPanLayout.setVerticalGroup(
            sidebarPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(historyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        headerPan.setBackground(new java.awt.Color(0, 88, 171));
        headerPan.setToolTipText("");

        judulLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        judulLabel.setForeground(new java.awt.Color(251, 217, 20));
        judulLabel.setText("RIWAYAT TRANSAKSI");

        storeLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        storeLabel.setForeground(new java.awt.Color(255, 255, 255));
        storeLabel.setText("CLEAN FRESH LAUNDRY");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-laundry-50.png"))); // NOI18N

        storeLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        storeLabel1.setForeground(new java.awt.Color(255, 255, 255));
        storeLabel1.setText("CLEAN FRESH LAUNDRY");

        javax.swing.GroupLayout headerPanLayout = new javax.swing.GroupLayout(headerPan);
        headerPan.setLayout(headerPanLayout);
        headerPanLayout.setHorizontalGroup(
            headerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storeLabel)
                .addGap(279, 279, 279)
                .addComponent(judulLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(storeLabel1)
                .addGap(485, 485, 485))
        );
        headerPanLayout.setVerticalGroup(
            headerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(headerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(headerPanLayout.createSequentialGroup()
                        .addGroup(headerPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(judulLabel)
                            .addComponent(storeLabel))
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storeLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        containerPanel4.setBackground(new java.awt.Color(255, 255, 255));

        NamaKaryLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        NamaKaryLabel.setForeground(new java.awt.Color(0, 0, 0));
        NamaKaryLabel.setText("Nama Karyawan");

        NamaKaryInput.setBackground(new java.awt.Color(255, 255, 255));
        NamaKaryInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        NamaKaryInput.setForeground(new java.awt.Color(0, 0, 0));

        namaCustLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        namaCustLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaCustLabel.setText("Nama Customer");

        namaCustInput.setBackground(new java.awt.Color(255, 255, 255));
        namaCustInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        namaCustInput.setForeground(new java.awt.Color(0, 0, 0));

        bobotLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        bobotLabel.setForeground(new java.awt.Color(0, 0, 0));
        bobotLabel.setText("Bobot");

        bobotInput.setBackground(new java.awt.Color(255, 255, 255));
        bobotInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        bobotInput.setForeground(new java.awt.Color(0, 0, 0));

        tglMasukLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tglMasukLabel.setForeground(new java.awt.Color(0, 0, 0));
        tglMasukLabel.setText("Tanggal Masuk");

        tglMasukInput.setBackground(new java.awt.Color(255, 255, 255));
        tglMasukInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tglMasukInput.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Jenis Layanan");

        searchBtn.setBackground(new java.awt.Color(255, 255, 204));
        searchBtn.setForeground(new java.awt.Color(0, 0, 0));
        searchBtn.setText("Search");

        searchInput.setBackground(new java.awt.Color(255, 255, 255));
        searchInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        searchInput.setForeground(new java.awt.Color(0, 0, 0));
        searchInput.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        tglSelesaiLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tglSelesaiLabel.setForeground(new java.awt.Color(0, 0, 0));
        tglSelesaiLabel.setText("Tanggal Selesai");

        tglSelesaiInput.setBackground(new java.awt.Color(255, 255, 255));
        tglSelesaiInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tglSelesaiInput.setForeground(new java.awt.Color(0, 0, 0));

        tglAmbilLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tglAmbilLabel.setForeground(new java.awt.Color(0, 0, 0));
        tglAmbilLabel.setText("Tanggal Ambil");

        tglAmbilInput.setBackground(new java.awt.Color(255, 255, 255));
        tglAmbilInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tglAmbilInput.setForeground(new java.awt.Color(0, 0, 0));

        jenLayabuttonGroup.add(jRadioButtonReg);
        jRadioButtonReg.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jRadioButtonReg.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonReg.setText("Reguler");
        jRadioButtonReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRegActionPerformed(evt);
            }
        });

        jenLayabuttonGroup.add(jRadioButtonKilat);
        jRadioButtonKilat.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jRadioButtonKilat.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonKilat.setText("Kilat");

        jenLayabuttonGroup.add(jRadioButtonRegDev);
        jRadioButtonRegDev.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jRadioButtonRegDev.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonRegDev.setText("Reguler (w/ delivery)");
        jRadioButtonRegDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRegDevActionPerformed(evt);
            }
        });

        editBtn4.setBackground(new java.awt.Color(255, 255, 204));
        editBtn4.setForeground(new java.awt.Color(0, 0, 0));
        editBtn4.setText("Edit");

        deleteBtn4.setBackground(new java.awt.Color(255, 255, 204));
        deleteBtn4.setForeground(new java.awt.Color(0, 0, 0));
        deleteBtn4.setText("Delete");

        javax.swing.GroupLayout containerPanel4Layout = new javax.swing.GroupLayout(containerPanel4);
        containerPanel4.setLayout(containerPanel4Layout);
        containerPanel4Layout.setHorizontalGroup(
            containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(containerPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonReg)
                            .addComponent(jRadioButtonKilat)
                            .addComponent(jRadioButtonRegDev)
                            .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(containerPanel4Layout.createSequentialGroup()
                                    .addComponent(deleteBtn4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(editBtn4))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, containerPanel4Layout.createSequentialGroup()
                                    .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(bobotInput)
                                            .addComponent(NamaKaryInput, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(namaCustInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NamaKaryLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(namaCustLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(bobotLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(215, 215, 215)
                                    .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tglSelesaiInput, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tglSelesaiLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tglMasukLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tglAmbilLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tglAmbilInput, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tglMasukInput, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 371, Short.MAX_VALUE))))
        );
        containerPanel4Layout.setVerticalGroup(
            containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addGap(29, 29, 29)
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addComponent(NamaKaryLabel)
                        .addGap(19, 19, 19)
                        .addComponent(NamaKaryInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namaCustLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaCustInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addComponent(tglMasukLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tglMasukInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tglSelesaiLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tglSelesaiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addComponent(bobotLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bobotInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerPanel4Layout.createSequentialGroup()
                        .addComponent(tglAmbilLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tglAmbilInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonKilat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonRegDev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(containerPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn4)
                    .addComponent(deleteBtn4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(containerPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonRegActionPerformed

    private void jRadioButtonRegDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRegDevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonRegDevActionPerformed

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
            java.util.logging.Logger.getLogger(historyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(historyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(historyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(historyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new historyView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NamaKaryInput;
    private javax.swing.JLabel NamaKaryLabel;
    private javax.swing.JTextField bobotInput;
    private javax.swing.JLabel bobotLabel;
    private javax.swing.JPanel containerPanel4;
    private javax.swing.JButton deleteBtn4;
    private javax.swing.JButton editBtn4;
    private javax.swing.JPanel headerPan;
    private javax.swing.JLabel historyIcon;
    private javax.swing.JLabel historyLabel;
    private javax.swing.JPanel historyPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButtonKilat;
    private javax.swing.JRadioButton jRadioButtonReg;
    private javax.swing.JRadioButton jRadioButtonRegDev;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.ButtonGroup jenLayabuttonGroup;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JTextField namaCustInput;
    private javax.swing.JLabel namaCustLabel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JPanel sidebarPan;
    private javax.swing.JLabel storeLabel;
    private javax.swing.JLabel storeLabel1;
    private javax.swing.JTextField tglAmbilInput;
    private javax.swing.JLabel tglAmbilLabel;
    private javax.swing.JTextField tglMasukInput;
    private javax.swing.JLabel tglMasukLabel;
    private javax.swing.JTextField tglSelesaiInput;
    private javax.swing.JLabel tglSelesaiLabel;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.*;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.*;
import table.*;
/**
 *
 * @author Yeetman47
 */
public class employeeMainView extends javax.swing.JFrame {
    private CustomerControl customerControl;
    private WorkOrderControl workOrderControl;
    private String menu;
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
    /**
     * Creates new form employeeMainView
     */
    
    
    public employeeMainView(Employee employee) {
        
        try{
            
        //TAB 1 Tambah Pelanggan
            initComponents();
            setComponent(false);
            idInput.setEnabled(false);
            customerControl = new CustomerControl();
            showCustomer();
            clearText();
            
        //TAB 2 AMBIL
            initDTInput(inputTglAmbil, LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(3));
            showSelesai();
            setComponentAmbil(false);
            clearTextAmbil();
            
        //TAB 3 RIWAYAT
            showDiambil();
            searchInput2.setText("");
            
        //TAB 4 ANTAR
             showAntar();
             setComponentAntar(false);
             clearTextAntar();

        //TAB 5 WORK ORDER
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
           
            
       //TAB 6 PROSES
            initDTInput(tglSelesai, LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(3));
            showProses();
            //setComponentProses();
        } catch(Exception e){
            System.out.println("Error customerView");
        }
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
    
    
    public void setComponentAntar(boolean value){
        customerDisplay.setEnabled(value);
        bobotDisplay.setEnabled(value);
        servisDisplay.setEnabled(value);
        selesaiBtn2.setEnabled(value);
        batalBtn.setEnabled(value);
        tglDiambilAntar.setEnabled(value);
        setDateNowAmbilBtn1.setEnabled(value);
    }
    
    public void clearTextAntar(){
        searchInput3.setText("");
        customerDisplay.setText("");
        bobotDisplay.setText("");
        servisDisplay.setText("");
        tglDiambilAntar.clear();
    }
    
   public void showAntar(){
       prosesTable.setModel(wc.showWorkOrderDiantar());
   }
    
    public void showProses(){
        prosesTable1.setModel(wc.showWorkOrderNotDone());
    }
    
    public void showWorkOrder(){
        jTable3.setModel(wc.showWorkOrderNotDone());
    }
    
    public void showDiambil(){
        jTable2.setModel(wc.showWorkOrderDiambil());
    }
    
    public void showSelesai(){
        rincianTable.setModel(wc.showWorkOrderDone());
    }
     
    public void clearTextAmbil(){
        totInput.setText("");
        sCustomer.setText("");
        sLayanan.setText("");
        sBobot.setText("");
        sTanggalJam.setText("");
    }
    
    public void setCustomerToDropDown(){
        listCustomer = cc.showListCustomer();
        for(int i=0; i<listCustomer.size(); i++){
            customerDd2.addItem(String.valueOf(listCustomer.get(i)));
        }
    }
    
    public void setServiceToDropDown(){
        listService = sc.showListService();
        for(int i=0; i<listService.size(); i++){
            layananDd.addItem(String.valueOf(listService.get(i)));
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
    
    private void setTglSelesai() {
        if(layananDd.getSelectedIndex() == -1 || getFullDateTime(inputTglMasuk) == null) {

        } else {   
            int selectedIndex2 =  layananDd.getSelectedIndex();
            Service s = listService.get(selectedIndex2);
            inputTglSelesai.setDateTimeStrict(inputTglMasuk.getDateTimeStrict().plusDays(s.getKecepatan()));
        }
    }
    
    public void setComponent(boolean value){
       editBtn.setEnabled(value);
       deleteBtn.setEnabled(value);
       namaInput.setEnabled(value);
       telpInput.setEnabled(value);
       alamatInput.setEnabled(value);
       lakiBtn.setEnabled(value);
       perempuanBtn.setEnabled(value);
       lakiBtn.setSelected(value);
       perempuanBtn.setSelected(value);
       saveBtn.setEnabled(value);
       cancelBtn.setEnabled(value);
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
    
    public void clearTextWorkOrder(){
        layananDd.setSelectedIndex(-1);
        customerDd2.setSelectedIndex(-1);
        bobotInput.setText("");
        inputTglMasuk.clear();
        inputTglSelesai.clear();
        searchInput4.setText("");
    }
    
    public void clearText(){
        namaInput.setText("");
        telpInput.setText("");
        alamatInput.setText("");
        idInput.setText("");
        searchInput.setText("");
    }
    
    public void showCustomer(){
        jTable1.setModel(customerControl.showDataCustomer());
    }
    
    public void showRiwayat(){
        jTable2.setModel(workOrderControl.showWorkOrderDiambil());
    }

    public void showRincian(){
        rincianTable.setModel(workOrderControl.showWorkOrderDoneAntarNo());
    }
    
    public void showAntarLaundry(){
        prosesTable.setModel(workOrderControl.showWorkOrderDoneAntarYes());
    }
    
    public void showTransaksi(){
        jTable3.setModel(workOrderControl.showWorkOrder("Proses"));
    }
    
    public void showProses(){
        prosesTable1.setModel(workOrderControl.showWorkOrderNotDone());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenisKelaminBtnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        judulLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        menu1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        menu6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        menu7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        menu8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        menu9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        menu10 = new javax.swing.JLabel();
        tabpeepee = new javax.swing.JTabbedPane();
        menuSaetu = new javax.swing.JPanel();
        registerPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        namaLabel = new javax.swing.JLabel();
        namaInput = new javax.swing.JTextField();
        alamatLabel = new javax.swing.JLabel();
        alamatInput = new javax.swing.JTextField();
        telpLabel = new javax.swing.JLabel();
        telpInput = new javax.swing.JTextField();
        lakiBtn = new javax.swing.JRadioButton();
        perempuanBtn = new javax.swing.JRadioButton();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        rincianTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        menuTaiga = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        deleteBtn3 = new javax.swing.JButton();
        searchInput2 = new javax.swing.JTextField();
        searchBtn2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        judulLabel.setText("Karyawan");
        judulLabel.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        judulLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulLabel)
                .addContainerGap(850, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(judulLabel)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 70));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        menu1.setText("Tambah Pelanggan");
        menu1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        menu1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(menu1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        menu6.setText("Ambil Laundry");
        menu6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        menu6.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(menu6)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        menu7.setText("Riwayat");
        menu7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        menu7.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(menu7)
                .addGap(14, 14, 14))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 204));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        menu8.setText("Antar");
        menu8.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        menu8.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(menu8)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        menu9.setText("Work Order");
        menu9.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        menu9.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(menu9)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        menu10.setText("Proses");
        menu10.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        menu10.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(menu10)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 140, 680));

        tabpeepee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabpeepeeMouseClicked(evt);
            }
        });

        menuSaetu.setBackground(new java.awt.Color(55, 121, 164));

        registerPanel.setBackground(new java.awt.Color(255, 255, 255));
        registerPanel.setForeground(new java.awt.Color(255, 255, 255));

        idLabel.setText("ID");
        idLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(0, 0, 0));

        idInput.setText("jTextField1");

        namaLabel.setText("Nama");
        namaLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(0, 0, 0));

        namaInput.setText("jTextField1");

        alamatLabel.setText("Alamat");
        alamatLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        alamatLabel.setForeground(new java.awt.Color(0, 0, 0));

        alamatInput.setText("jTextField1");

        telpLabel.setText("Nomor Telepon");
        telpLabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        telpLabel.setForeground(new java.awt.Color(0, 0, 0));

        telpInput.setText("jTextField1");

        jenisKelaminBtnGroup.add(lakiBtn);
        lakiBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lakiBtn.setForeground(new java.awt.Color(0, 0, 0));
        lakiBtn.setText("Laki-laki");
        lakiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lakiBtnActionPerformed(evt);
            }
        });

        jenisKelaminBtnGroup.add(perempuanBtn);
        perempuanBtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        perempuanBtn.setForeground(new java.awt.Color(0, 0, 0));
        perempuanBtn.setText("Perempuan");
        perempuanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perempuanBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Batal");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Simpan");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Jenis Kelamin");
        jLabel9.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBtn)
                .addGap(19, 19, 19))
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(perempuanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lakiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telpInput, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alamatInput, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alamatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(namaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(namaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(namaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alamatLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alamatInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telpInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lakiBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(perempuanBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(saveBtn))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(55, 121, 164));

        addBtn.setText("Tambah");
        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setForeground(new java.awt.Color(0, 0, 0));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Hapus");
        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setForeground(new java.awt.Color(0, 0, 0));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Ubah");
        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.setForeground(new java.awt.Color(0, 0, 0));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn)
                .addGap(12, 12, 12)
                .addComponent(editBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(deleteBtn)
                    .addComponent(editBtn))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        searchInput.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        searchInput.setBackground(new java.awt.Color(255, 255, 255));
        searchInput.setForeground(new java.awt.Color(0, 0, 0));

        searchBtn.setText("Cari");
        searchBtn.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn.setForeground(new java.awt.Color(0, 0, 0));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Tambah Pelanggan");
        jLabel2.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout menuSaetuLayout = new javax.swing.GroupLayout(menuSaetu);
        menuSaetu.setLayout(menuSaetuLayout);
        menuSaetuLayout.setHorizontalGroup(
            menuSaetuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuSaetuLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(menuSaetuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuSaetuLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(menuSaetuLayout.createSequentialGroup()
                        .addGroup(menuSaetuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(menuSaetuLayout.createSequentialGroup()
                                .addComponent(searchBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchInput))
                            .addComponent(registerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        menuSaetuLayout.setVerticalGroup(
            menuSaetuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuSaetuLayout.createSequentialGroup()
                .addGroup(menuSaetuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuSaetuLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, menuSaetuLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(menuSaetuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBtn)
                            .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );

        tabpeepee.addTab("tab1", menuSaetu);

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

        searchInput6.setBackground(new java.awt.Color(255, 255, 255));
        searchInput6.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout pickupPanelLayout = new javax.swing.GroupLayout(pickupPanel);
        pickupPanel.setLayout(pickupPanelLayout);
        pickupPanelLayout.setHorizontalGroup(
            pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pickupPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pickupPanelLayout.createSequentialGroup()
                        .addComponent(sBobot, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pickupPanelLayout.createSequentialGroup()
                        .addComponent(sTanggalJam, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pickupPanelLayout.createSequentialGroup()
                        .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pickupPanelLayout.createSequentialGroup()
                                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputTglAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(setDateNowAmbilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pickupPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(selesaiBtn)))
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn2)
                        .addGap(9, 9, 9))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pickupPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchInput6, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn6)
                .addGap(74, 74, 74))
            .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pickupPanelLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(totInput, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(492, Short.MAX_VALUE)))
            .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pickupPanelLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(sLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(483, Short.MAX_VALUE)))
        );
        pickupPanelLayout.setVerticalGroup(
            pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pickupPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(sCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchInput6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sBobot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sTanggalJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setDateNowAmbilBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTglAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selesaiBtn)
                    .addComponent(cancelBtn2))
                .addGap(9, 9, 9))
            .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pickupPanelLayout.createSequentialGroup()
                    .addContainerGap(120, Short.MAX_VALUE)
                    .addComponent(totInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
            .addGroup(pickupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pickupPanelLayout.createSequentialGroup()
                    .addContainerGap(75, Short.MAX_VALUE)
                    .addComponent(sLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(72, 72, 72)))
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

        javax.swing.GroupLayout menuDoueaLayout = new javax.swing.GroupLayout(menuDouea);
        menuDouea.setLayout(menuDoueaLayout);
        menuDoueaLayout.setHorizontalGroup(
            menuDoueaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuDoueaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(menuDoueaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pickupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        menuDoueaLayout.setVerticalGroup(
            menuDoueaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDoueaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pickupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        tabpeepee.addTab("tab2", menuDouea);

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

        javax.swing.GroupLayout menuTaigaLayout = new javax.swing.GroupLayout(menuTaiga);
        menuTaiga.setLayout(menuTaigaLayout);
        menuTaigaLayout.setHorizontalGroup(
            menuTaigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTaigaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(menuTaigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(deleteBtn3)
                    .addGroup(menuTaigaLayout.createSequentialGroup()
                        .addComponent(searchBtn2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        menuTaigaLayout.setVerticalGroup(
            menuTaigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTaigaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuTaigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn2)
                    .addComponent(searchInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn3)
                .addContainerGap())
        );

        tabpeepee.addTab("tab3", menuTaiga);

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
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

        batalBtn.setText("jButton1");
        batalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deliPanelLayout = new javax.swing.GroupLayout(deliPanel);
        deliPanel.setLayout(deliPanelLayout);
        deliPanelLayout.setHorizontalGroup(
            deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deliPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deliPanelLayout.createSequentialGroup()
                        .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servisLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deliPanelLayout.createSequentialGroup()
                        .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(deliPanelLayout.createSequentialGroup()
                                .addComponent(servisDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selesaiBtn2)
                                .addGap(36, 36, 36)
                                .addComponent(batalBtn))
                            .addGroup(deliPanelLayout.createSequentialGroup()
                                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bobotLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customerDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(bobotDisplay))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tglDiambilAntar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(setDateNowAmbilBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))))
        );
        deliPanelLayout.setVerticalGroup(
            deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deliPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(customerLabel2)
                .addGap(18, 18, 18)
                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setDateNowAmbilBtn1)
                    .addComponent(bobotLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tglDiambilAntar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bobotDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(servisLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servisDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selesaiBtn2)
                    .addComponent(batalBtn))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout menuAmpadtLayout = new javax.swing.GroupLayout(menuAmpadt);
        menuAmpadt.setLayout(menuAmpadtLayout);
        menuAmpadtLayout.setHorizontalGroup(
            menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAmpadtLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuAmpadtLayout.createSequentialGroup()
                        .addGroup(menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(menuAmpadtLayout.createSequentialGroup()
                                .addComponent(searchBtn3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(453, 453, 453))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, menuAmpadtLayout.createSequentialGroup()
                        .addGroup(menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deliPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        menuAmpadtLayout.setVerticalGroup(
            menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAmpadtLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuAmpadtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn3)
                    .addComponent(searchInput3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(deliPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabpeepee.addTab("tab4", menuAmpadt);

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

        javax.swing.GroupLayout menuLiejmaLayout = new javax.swing.GroupLayout(menuLiejma);
        menuLiejma.setLayout(menuLiejmaLayout);
        menuLiejmaLayout.setHorizontalGroup(
            menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLiejmaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(menuLiejmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLiejmaLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(30, 30, 30))))
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
                    .addGroup(menuLiejmaLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLiejmaLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
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
                .addContainerGap(110, Short.MAX_VALUE))
        );

        tabpeepee.addTab("tab5", menuLiejma);

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

        javax.swing.GroupLayout containerEightnamLayout = new javax.swing.GroupLayout(containerEightnam);
        containerEightnam.setLayout(containerEightnamLayout);
        containerEightnamLayout.setHorizontalGroup(
            containerEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerEightnamLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(containerEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerEightnamLayout.createSequentialGroup()
                        .addComponent(searchBtn5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchInput5, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(donePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        containerEightnamLayout.setVerticalGroup(
            containerEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerEightnamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerEightnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn5)
                    .addComponent(searchInput5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(donePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
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

        tabpeepee.addTab("tab6", menuEightnam);

        jPanel1.add(tabpeepee, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 920, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabpeepeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabpeepeeMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tabpeepeeMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        tabpeepee.setSelectedIndex(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        tabpeepee.setSelectedIndex(1);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        tabpeepee.setSelectedIndex(2);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        tabpeepee.setSelectedIndex(3);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        tabpeepee.setSelectedIndex(4);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void lakiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lakiBtnActionPerformed
        jenisKelamin = "Laki-laki";
    }//GEN-LAST:event_lakiBtnActionPerformed

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

    private void editBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn2ActionPerformed
        setComponentWorkOrder(true);
        action = "Ubah";
    }//GEN-LAST:event_editBtn2ActionPerformed

    private void cancelBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn3ActionPerformed
        setComponentWorkOrder(false);
        clearTextWorkOrder();
    }//GEN-LAST:event_cancelBtn3ActionPerformed

    private void searchBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtn3ActionPerformed

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

    private void perempuanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perempuanBtnActionPerformed
        jenisKelamin = "Perempuan";
    }//GEN-LAST:event_perempuanBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        setComponent(false);
        clearText();
    }//GEN-LAST:event_cancelBtnActionPerformed

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
                jTable1.setModel(customer);
            }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        setComponent(false);
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);

        int clickedRow = jTable1.getSelectedRow();
        TableModel table = jTable1.getModel();

        idInput.setText(table.getValueAt(clickedRow, 0).toString());
        namaInput.setText(table.getValueAt(clickedRow, 1).toString());
        telpInput.setText(table.getValueAt(clickedRow, 2).toString());
        alamatInput.setText(table.getValueAt(clickedRow, 3).toString());

        temp = table.getValueAt(clickedRow, 4).toString();
        if(temp.equalsIgnoreCase("Laki-laki")){
            lakiBtn.setSelected(true);
            perempuanBtn.setSelected(false);
        }else{
            lakiBtn.setSelected(false);
            perempuanBtn.setSelected(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

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

    private void deleteBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn3ActionPerformed
        int getAnswer = JOptionPane.showConfirmDialog(rootPane,"Apakah yaking ingin menghapus data ? ", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        switch(getAnswer){
            case 0:
                try{
                    workOrderControl.deleteDataWorkOrder(Integer.parseInt(idInput.getText()));
                    searchInput2.setText("");
                    showRiwayat();
                }catch(Exception e){
                    System.out.println("Error : "+e.getMessage());
                }
                break;
            case 1:
                break;
        }
    }//GEN-LAST:event_deleteBtn3ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
        try{
            int clickedRow = jTable2.getSelectedRow();
            TableModel table = jTable2.getModel();

            idInput.setText(table.getValueAt(clickedRow, 0).toString());     
        } catch(Exception e){
            System.out.println(e);
        }
       
    }//GEN-LAST:event_jTable2MouseClicked

    private void customerDd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerDd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerDd2ActionPerformed


    private void selesaiBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiBtn2ActionPerformed
        String tglAmbil = String.valueOf(inputTglAmbil.getDateTimeStrict());
        workOrderControl.updateStatusWorkOrder(Integer.parseInt(diantarkan), "Diambil",tglAmbil);
    }//GEN-LAST:event_selesaiBtn2ActionPerformed

    private void searchBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtn5ActionPerformed

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        tabpeepee.setSelectedIndex(5);
    }//GEN-LAST:event_jPanel11MouseClicked


    private void btnSetDTMasukNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetDTMasukNowActionPerformed
        inputTglMasuk.datePicker.setDateToToday();
        inputTglMasuk.timePicker.setTimeToNow();
    }//GEN-LAST:event_btnSetDTMasukNowActionPerformed

    private void rincianTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rincianTableMouseClicked
        
        int clickedRow = rincianTable.getSelectedRow();
        TableModel table = rincianTable.getModel();
        int a = Integer.parseInt(table.getValueAt(clickedRow, 3).toString());
        int b = Integer.parseInt(table.getValueAt(clickedRow, 7).toString());
        int c = a*b;
        diselesaikan = table.getValueAt(clickedRow, 0).toString();
        totInput.setText(table.getValueAt(clickedRow, 7).toString());
        sCustomer.setText(table.getValueAt(clickedRow, 1).toString());
        sTanggalJam.setText(table.getValueAt(clickedRow, 5).toString());
        sLayanan.setText(table.getValueAt(clickedRow, 2).toString());
        sBobot.setText(table.getValueAt(clickedRow, 3).toString());
        cancelBtn2.setSelected(true);
        selesaiBtn.setSelected(true);
    }//GEN-LAST:event_rincianTableMouseClicked

    private void setDateNowAmbilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDateNowAmbilBtnActionPerformed
        inputTglAmbil.datePicker.setDateToToday();
        inputTglAmbil.timePicker.setTimeToNow();
    }//GEN-LAST:event_setDateNowAmbilBtnActionPerformed

    private void sCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sCustomerActionPerformed

    private void selesaiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiBtnActionPerformed
        String tglAmbil = String.valueOf(inputTglAmbil.getDateTimeStrict());
        workOrderControl.updateStatusWorkOrder(Integer.parseInt(diselesaikan), "Diambil",tglAmbil);
    }//GEN-LAST:event_selesaiBtnActionPerformed

    private void prosesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prosesTableMouseClicked
        selesaiBtn2.setEnabled(true);
        batalBtn.setEnabled(true);
        
        int clickedRow = prosesTable.getSelectedRow();
        TableModel table = prosesTable.getModel();
       
        diantarkan = table.getValueAt(clickedRow, 0).toString();
        customerDisplay.setText(table.getValueAt(clickedRow, 1).toString());
        bobotDisplay.setText(table.getValueAt(clickedRow, 3).toString());
        servisDisplay.setText(table.getValueAt(clickedRow, 2).toString());
    }//GEN-LAST:event_prosesTableMouseClicked

    private void addBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn2ActionPerformed
        setComponentWorkOrder(true);
        saveBtn2.setEnabled(true);
        editBtn2.setEnabled(false);
        deleteBtn2.setEnabled(false);
        clearTextWorkOrder();
        searchInput4.setText("");
        action = "Tambah";
    }//GEN-LAST:event_addBtn2ActionPerformed

    private void prosesTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prosesTable1MouseClicked
        int clickedRow = prosesTable1.getSelectedRow();
        TableModel table = prosesTable1.getModel();
        
        diselesaikan = table.getValueAt(clickedRow, 0).toString();
        customerDisplay1.setText(table.getValueAt(clickedRow, 1).toString());
        bobotDisplay1.setText(table.getValueAt(clickedRow, 3).toString());
        servisDisplay1.setText(table.getValueAt(clickedRow, 2).toString());
    }//GEN-LAST:event_prosesTable1MouseClicked

    private void selesaiBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiBtn3ActionPerformed
     
        String tglSelse  =   String.valueOf(tglSelesai.getDateTimeStrict());
        workOrderControl.updateStatusWorkOrder(Integer.parseInt(diselesaikan), "Selesai", tglSelse);
    }//GEN-LAST:event_selesaiBtn3ActionPerformed

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
            clearText();
            showWorkOrder();
            setComponentWorkOrder(false);
        }
    }//GEN-LAST:event_saveBtn2ActionPerformed

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

    private void cancelBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn2ActionPerformed

        clearTextAmbil();
    }//GEN-LAST:event_cancelBtn2ActionPerformed

    private void searchInput2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInput2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInput2ActionPerformed

    private void setDateNowAmbilBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDateNowAmbilBtn1ActionPerformed
        tglDiambilAntar.datePicker.setDateToToday();
        tglDiambilAntar.timePicker.setTimeToNow();
    }//GEN-LAST:event_setDateNowAmbilBtn1ActionPerformed

    private void batalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBtnActionPerformed
        clearTextAntar();
    }//GEN-LAST:event_batalBtnActionPerformed

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

    private void todayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayBtnActionPerformed
        tglSelesai.datePicker.setDateToToday();
        tglSelesai.timePicker.setTimeToNow();
    }//GEN-LAST:event_todayBtnActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
    }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(employeeMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employeeMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employeeMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employeeMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employeeMainView(employee).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addBtn2;
    private javax.swing.JTextField alamatInput;
    private javax.swing.JLabel alamatLabel;
    private javax.swing.JButton batalBtn;
    private javax.swing.JTextField bobotDisplay;
    private javax.swing.JTextField bobotDisplay1;
    private javax.swing.JTextField bobotInput;
    private javax.swing.JLabel bobotLabel;
    private javax.swing.JLabel bobotLabel2;
    private javax.swing.JLabel bobotLabel3;
    private javax.swing.JButton btnSetDTMasukNow;
    private javax.swing.JButton cancel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton cancelBtn2;
    private javax.swing.JButton cancelBtn3;
    private javax.swing.JPanel containerEightnam;
    private javax.swing.JComboBox<String> customerDd2;
    private javax.swing.JTextField customerDisplay;
    private javax.swing.JTextField customerDisplay1;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JLabel customerLabel2;
    private javax.swing.JLabel customerLabel3;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn2;
    private javax.swing.JButton deleteBtn3;
    private javax.swing.JPanel deliPanel;
    private javax.swing.JPanel donePanel;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton editBtn2;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel idLabel;
    private com.github.lgooddatepicker.components.DateTimePicker inputTglAmbil;
    private com.github.lgooddatepicker.components.DateTimePicker inputTglMasuk;
    private com.github.lgooddatepicker.components.DateTimePicker inputTglSelesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.ButtonGroup jenisKelaminBtnGroup;
    private javax.swing.JLabel jenisLayananLabel;
    private javax.swing.JLabel judulLabel;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JRadioButton lakiBtn;
    private javax.swing.JComboBox<String> layananDd;
    private javax.swing.JLabel menu1;
    private javax.swing.JLabel menu10;
    private javax.swing.JLabel menu6;
    private javax.swing.JLabel menu7;
    private javax.swing.JLabel menu8;
    private javax.swing.JLabel menu9;
    private javax.swing.JPanel menuAmpadt;
    private javax.swing.JPanel menuDouea;
    private javax.swing.JPanel menuEightnam;
    private javax.swing.JPanel menuLiejma;
    private javax.swing.JPanel menuSaetu;
    private javax.swing.JPanel menuTaiga;
    private javax.swing.JTextField namaInput;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JRadioButton perempuanBtn;
    private javax.swing.JPanel pickupPanel;
    private javax.swing.JTable prosesTable;
    private javax.swing.JTable prosesTable1;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JTable rincianTable;
    private javax.swing.JTextField sBobot;
    private javax.swing.JTextField sCustomer;
    private javax.swing.JTextField sLayanan;
    private javax.swing.JTextField sTanggalJam;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton saveBtn2;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton searchBtn2;
    private javax.swing.JButton searchBtn3;
    private javax.swing.JButton searchBtn4;
    private javax.swing.JButton searchBtn5;
    private javax.swing.JButton searchBtn6;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTextField searchInput2;
    private javax.swing.JTextField searchInput3;
    private javax.swing.JTextField searchInput4;
    private javax.swing.JTextField searchInput5;
    private javax.swing.JTextField searchInput6;
    private javax.swing.JButton selesaiBtn;
    private javax.swing.JButton selesaiBtn2;
    private javax.swing.JButton selesaiBtn3;
    private javax.swing.JTextField servisDisplay;
    private javax.swing.JTextField servisDisplay1;
    private javax.swing.JLabel servisLabel2;
    private javax.swing.JLabel servisLabel3;
    private javax.swing.JButton setDateNowAmbilBtn;
    private javax.swing.JButton setDateNowAmbilBtn1;
    private javax.swing.JTabbedPane tabpeepee;
    private javax.swing.JLabel tanggalMasuk;
    private javax.swing.JLabel tanggalSelesai;
    private javax.swing.JTextField telpInput;
    private javax.swing.JLabel telpLabel;
    private com.github.lgooddatepicker.components.DateTimePicker tglDiambilAntar;
    private com.github.lgooddatepicker.components.DateTimePicker tglSelesai;
    private javax.swing.JButton todayBtn;
    private javax.swing.JTextField totInput;
    private javax.swing.JPanel transPanel;
    // End of variables declaration//GEN-END:variables
}

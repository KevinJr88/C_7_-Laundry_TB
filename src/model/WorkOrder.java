/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Customer;
import model.Employee;
import model.Service;
/**
 *
 * @author julia
 */
public class WorkOrder {
    public static final DateTimeFormatter DEFAULT_DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter LOCAL_DTF = DateTimeFormatter.ofPattern("E, d MMM yyyy, HH.mm", new java.util.Locale("id"));
    private int id_transaksi;
    private String tanggal_masuk;
    private String tanggal_selesai;
    private String tanggal_ambil;
    private int bobot;
    private String status;
    private Customer customer;
    private Employee karyawan;
    private Service layanan;
    private double biaya;

    
    
    
//    public WorkOrder(int id_transaksi, String tanggal_masuk, String tanggal_selesai, String tanggal_ambil, int bobot, String status, Customer customer, Employee karyawan, Service layanan, double biaya) {
//        this.id_transaksi = id_transaksi;
//        this.tanggal_masuk = LocalDateTime.parse(tanggal_masuk, WorkOrder.DEFAULT_DTF);
//        this.tanggal_selesai = LocalDateTime.parse(tanggal_selesai, WorkOrder.DEFAULT_DTF);
//        this.tanggal_ambil = LocalDateTime.parse(tanggal_ambil, WorkOrder.DEFAULT_DTF);
//        this.bobot = bobot;
//        this.status = status;
//        this.customer = customer;
//        this.karyawan = karyawan;
//        this.layanan = layanan;
//        this.biaya = biaya;
//    }
//
//
//    
//        public WorkOrder(String tanggal_masuk, String tanggal_selesai,String tanggal_ambil, int bobot, String status, Customer customer, Employee karyawan, Service layanan, double biaya) {
//        this.tanggal_masuk = LocalDateTime.parse(tanggal_masuk, WorkOrder.DEFAULT_DTF);
//        this.tanggal_selesai = LocalDateTime.parse(tanggal_selesai, WorkOrder.DEFAULT_DTF);
//        this.bobot = bobot;
//        this.status = status;
//        this.customer = customer;
//        this.karyawan = karyawan;
//        this.layanan = layanan;
//        this.biaya = biaya;
//    }
//
//    public WorkOrder(LocalDateTime tanggal_masuk, LocalDateTime tanggal_selesai, LocalDateTime tanggal_ambil, int bobot, String status, Customer customer, Employee karyawan, Service layanan, double biaya) {
//        this.tanggal_masuk = tanggal_masuk;
//        this.tanggal_selesai = tanggal_selesai;
//        this.tanggal_ambil = tanggal_ambil;
//        this.bobot = bobot;
//        this.status = status;
//        this.customer = customer;
//        this.karyawan = karyawan;
//        this.layanan = layanan;
//        this.biaya = biaya;
//    }

    
    
    
    
    public WorkOrder(String tanggal_masuk, String tanggal_selesai, String tanggal_ambil, int bobot, String status, Customer customer, Employee karyawan, Service layanan, double biaya) {
        this.tanggal_masuk = tanggal_masuk;
        this.tanggal_selesai = tanggal_selesai;
        this.tanggal_ambil = tanggal_ambil;
        this.bobot = bobot;
        this.status = status;
        this.customer = customer;
        this.karyawan = karyawan;
        this.layanan = layanan;
        this.biaya = biaya;
    }

    public WorkOrder(int id_transaksi, String tanggal_masuk, String tanggal_selesai, String tanggal_ambil, int bobot, String status, Customer customer, Employee karyawan, Service layanan, double biaya) {
        this.id_transaksi = id_transaksi;
        this.tanggal_masuk = tanggal_masuk;
        this.tanggal_selesai = tanggal_selesai;
        this.tanggal_ambil = tanggal_ambil;
        this.bobot = bobot;
        this.status = status;
        this.customer = customer;
        this.karyawan = karyawan;
        this.layanan = layanan;
        this.biaya = biaya;
    }

   
  
        
    

    public int getId_transaksi() {
        return id_transaksi;
    }

//    public LocalDateTime getTanggal_masuk() {
//        return tanggal_masuk;
//    }
//
//    public LocalDateTime getTanggal_selesai() {
//        return tanggal_selesai;
//    }
//
//    public LocalDateTime getTanggal_ambil() {
//        return tanggal_ambil;
//    }
//
//    public void setTanggal_ambil(LocalDateTime tanggal_ambil) {
//        this.tanggal_ambil = tanggal_ambil;
//    }

    public String getTanggal_masuk() {
        return tanggal_masuk;
    }

    public void setTanggal_masuk(String tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public String getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(String tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }

    public String getTanggal_ambil() {
        return tanggal_ambil;
    }

    public void setTanggal_ambil(String tanggal_ambil) {
        this.tanggal_ambil = tanggal_ambil;
    }
    
    
    

    public int getBobot() {
        return bobot;
    }
    
    public String getStatus(){
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getKaryawan() {
        return karyawan;
    }

    public Service getLayanan() {
        return layanan;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

//    public void setTanggal_masuk(LocalDateTime tanggal_masuk) {
//        this.tanggal_masuk = tanggal_masuk;
//    }
//
//    public void setTanggal_selesai(LocalDateTime tanggal_selesai) {
//        this.tanggal_selesai = tanggal_selesai;
//    }

    public void setBobot(int bobot) {
        this.bobot = bobot;
    }
    
    public void setStatus(String status){
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setKaryawan(Employee karyawan) {
        this.karyawan = karyawan;
    }

    public void setLayanan(Service layanan) {
        this.layanan = layanan;
    }
    
    @Override
    public String toString(){
        if(status.equalsIgnoreCase("Proses")){
            return customer.getNama_customer();
        }
        return null;
    }
}

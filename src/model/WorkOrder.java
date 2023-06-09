/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.Customer;
import model.Employee;
import model.Service;
/**
 *
 * @author julia
 */
public class WorkOrder {
    private int id_transaksi;
    private String tanggal_masuk;
    private String tanggal_selesai;
    private int bobot;
    private String status;
    private Customer customer;
    private Employee karyawan;
    private Service layanan;

    public WorkOrder(int id_transaksi, String tanggal_masuk, String tanggal_selesai, int bobot, String status,  Customer customer, Employee karyawan, Service layanan) {
        this.id_transaksi = id_transaksi;
        this.tanggal_masuk = tanggal_masuk;
        this.tanggal_selesai = tanggal_selesai;
        this.bobot = bobot;
        this.status = status;
        this.customer = customer;
        this.karyawan = karyawan;
        this.layanan = layanan;
    }

    public WorkOrder(String tanggal_masuk, String tanggal_selesai, int bobot, String status, Customer customer, Employee karyawan, Service layanan) {
        this.tanggal_masuk = tanggal_masuk;
        this.tanggal_selesai = tanggal_selesai;
        this.bobot = bobot;
        this.status = status;
        this.customer = customer;
        this.karyawan = karyawan;
        this.layanan = layanan;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public String getTanggal_masuk() {
        return tanggal_masuk;
    }

    public String getTanggal_selesai() {
        return tanggal_selesai;
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

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public void setTanggal_masuk(String tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public void setTanggal_selesai(String tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }

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

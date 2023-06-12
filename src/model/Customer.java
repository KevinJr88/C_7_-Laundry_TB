/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author julia
 */
public class Customer {
    private String id_customer;
    private String nama_customer;
    private int no_telp;
    private String alamat;
    private String jenis_kelamin;

    public Customer(String id_customer, String nama_customer, int no_telp, String alamat, String jenis_kelamin) {
        this.id_customer = id_customer;
        this.nama_customer = nama_customer;
        this.no_telp = no_telp;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
    }

    public Customer(String nama_customer, int no_telp, String alamat, String jenis_kelamin) {
        this.nama_customer = nama_customer;
        this.no_telp = no_telp;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getId_customer() {
        return id_customer;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public int getNo_telp() {
        return no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public void setNo_telp(int no_telp) {
        this.no_telp = no_telp;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    } 
    
    @Override
    public String toString(){
        return nama_customer;   
    }
}

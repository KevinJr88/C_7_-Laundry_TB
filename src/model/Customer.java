/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import exeption.*;
/**
 *
 * @author julia
 */
public class Customer {
    private String id_customer;
    private String nama_customer;
    private String no_telp;
    private String alamat;
    private String jenis_kelamin;

    public Customer(String id_customer, String nama_customer, String no_telp, String alamat, String jenis_kelamin) throws inputKosongException, TidakBoleh0{
        if(nama_customer.isEmpty() == true || alamat.isEmpty() == true || no_telp.isEmpty() == true){
            throw new inputKosongException();
        } 
        this.id_customer = id_customer;
        this.nama_customer = nama_customer;
        this.no_telp = no_telp;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
    }

    public Customer(String nama_customer, String no_telp, String alamat, String jenis_kelamin) {
        this.nama_customer = nama_customer;
        this.no_telp = no_telp;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getId_customer() {
        return id_customer;
    }

    public String getNama_customer() {
        return nama_customer;
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

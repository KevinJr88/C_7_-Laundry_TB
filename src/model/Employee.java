/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author julia
 */
public class Employee {
    private String id_karyawan;
    private String nama_karyawan;
    private String password;
    private int no_telepon;
    private String status;
    private String posisi;

    public Employee(String id_karyawan, String nama_karyawan, String password, int no_telepon, String status, String posisi) {
        this.id_karyawan = id_karyawan;
        this.nama_karyawan = nama_karyawan;
        this.password = password;
        this.no_telepon = no_telepon;
        this.status = status;
        this.posisi = posisi;
    }

    public Employee(String nama_karyawan, String password, int no_telepon, String status) {
        this.nama_karyawan = nama_karyawan;
        this.password = password;
        this.no_telepon = no_telepon;
        this.status = status;
    }

    public String getId_karyawan() {
        return id_karyawan;
    }

    public void setId_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(int no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }
    
    
    
}

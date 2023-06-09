/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author julia
 */
public class Service {
    private String id_layanan;
    private String nama_layanan;
    private int kecepatan;
    private String jasa_antar;
    private double biaya;

    public Service(String id_layanan, String nama_layanan, int kecepatan, String jasa_antar, double biaya) {
        this.id_layanan = id_layanan;
        this.nama_layanan = nama_layanan;
        this.kecepatan = kecepatan;
        this.jasa_antar = jasa_antar;
        this.biaya = biaya;
    }

    public Service(String nama_layanan, int kecepatan, String jasa_antar, double biaya) {
        this.nama_layanan = nama_layanan;
        this.kecepatan = kecepatan;
        this.jasa_antar = jasa_antar;
        this.biaya = biaya;
    }

    public String getId_layanan() {
        return id_layanan;
    }

    public String getNama_layanan() {
        return nama_layanan;
    }

    public int getKecepatan() {
        return kecepatan;
    }

    public String getJasa_antar() {
        return jasa_antar;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setId_layanan(String id_layanan) {
        this.id_layanan = id_layanan;
    }

    public void setNama_layanan(String nama_layanan) {
        this.nama_layanan = nama_layanan;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }

    public void setJasa_antar(String jasa_antar) {
        this.jasa_antar = jasa_antar;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }
    
    
}

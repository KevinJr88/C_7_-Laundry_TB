/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.WorkOrder;
import model.Service;
import model.Employee;
import model.Customer;
/**
 *
 * @author julia
 */
public class WorkOrderDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertWorkOrder(WorkOrder wo){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO WorkOrder(id_transaksi, tanggal_masuk, tanggal_selesai, bobot, status, customer, karyawan, layanan) values ('"
              + wo.getId_transaksi() + "','" + wo.getTanggal_masuk() + "','" + wo.getTanggal_selesai() + "','" 
              + wo.getBobot() + "','" + wo.getStatus() + "','" + wo.getCustomer().getId_customer() + "','" + wo.getKaryawan().getId_karyawan() + "','"
              + wo.getLayanan() + "')";
        
        System.out.println("Adding Work Order...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Work Order");
            statement.close();
        } catch(Exception e){
            System.out.println("Erorr adding Work order...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public List<WorkOrder> showWorkOrder(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT wo.*, c.*, e.*, s.* FROM WorkOrder as wo JOIN Customer as c on c.id_customer = wo.id_customer "
                + "JOIN Employee as e ON e.id_karyawan = wo.id_karyawan"
                + "JOIN Service as s ON s.id_layanan = wo.id_layanan WHERE (wo.tanggal_masuk LIKE "
                + "'%" + query + "%'"
                + "OR wo.tanggal_selesai LIKE '%" + query + "%'"
                + "OR wo.bobot LIKE '%" + query + "%'"
                + "OR wo.status LIKE '%" + query + "%'"
                + "OR s.nama_layanan LIKE '%" + query + "%'"
                + "OR c.nama_customer LIKE '%" + query + "%)";
                // TAMBAH APA LAGI YANG BISA JADIIN KATA KUNCI
                
        System.out.println("Mengambil data work order...");
        List<WorkOrder> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Customer c = new Customer(rs.getString("c.id_customer"),
                        rs.getString("c.nama.customer"), Integer.parseInt(rs.getString("c.no_telp")),
                        rs.getString("c.alamat"), rs.getString("c.jenis_kelamin"));
                    
                    Employee e = new Employee(rs.getString("e.id_karyawan"),
                        rs.getString("e.nama_karyawan"), rs.getString("e.password"),
                        Integer.parseInt(rs.getString("e.no_telepon")), rs.getString("e.status"),
                        rs.getString("e.posisi"));
                    
                    Service s = new Service(rs.getString("s.id_layanan"),
                        rs.getString("s.nama_layanan"), Integer.parseInt(rs.getString("s.kecepatan")),
                        rs.getString("s.jasa_antar"), Integer.parseInt(rs.getString("s.biaya")));
                    
                    WorkOrder wo = new WorkOrder(Integer.parseInt(rs.getString("wo.id_transaksi")), 
                        rs.getString("wo.tanggal_masuk"), rs.getString("wo.tanggal_selesai"),
                        Integer.parseInt(rs.getString("wo.bobot")), rs.getString("wo.status"), c, e, s);
                    
                    list.add(wo);
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e){
            System.out.println("Erorr reading database...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        return list;           
    }
    
    public List<WorkOrder> showWorkOrderCondition(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT wo.*, c.*, e.*, s.* FROM WorkOrder as wo JOIN Customer as c on c.id_customer = wo.id_customer "
                + "JOIN Employee as e ON e.id_karyawan = wo.id_karyawan"
                + "JOIN Service as s ON s.id_layanan = wo.id_layanan WHERE (wo.status LIKE "
                + "'%" + query + "%)";
        
        System.out.println("Mengambil data work order...");
        List<WorkOrder> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Customer c = new Customer(rs.getString("c.id_customer"),
                        rs.getString("c.nama.customer"), Integer.parseInt(rs.getString("c.no_telp")),
                        rs.getString("c.alamat"), rs.getString("c.jenis_kelamin"));
                    
                    Employee e = new Employee(rs.getString("e.id_karyawan"),
                        rs.getString("e.nama_karyawan"), rs.getString("e.password"),
                        Integer.parseInt(rs.getString("e.no_telepon")), rs.getString("e.status"),
                        rs.getString("e.posisi"));
                    
                    Service s = new Service(rs.getString("s.id_layanan"),
                        rs.getString("s.nama_layanan"), Integer.parseInt(rs.getString("s.kecepatan")),
                        rs.getString("s.jasa_antar"), Integer.parseInt(rs.getString("s.biaya")));
                    
                    WorkOrder wo = new WorkOrder(Integer.parseInt(rs.getString("wo.id_transaksi")), 
                        rs.getString("wo.tanggal_masuk"), rs.getString("wo.tanggal_selesai"),
                        Integer.parseInt(rs.getString("wo.bobot")), rs.getString("wo.status"), c, e, s);
                    
                    list.add(wo);
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e){
            System.out.println("Erorr reading database...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        return list;           
    }
    
    public void deleteWorkOrder(int id){ // BERDASARKAN ID
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM WorkOrder WHERE id_transaksi = " + id + "";
        System.out.println("Deleting work order ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Work Order " + id);
            statement.close();
        } catch(Exception e){
            System.out.println("Error deleting work order ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
}

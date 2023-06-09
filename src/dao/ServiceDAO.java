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
import model.Service;
/**
 *
 * @author julia
 */
public class ServiceDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertService(Service s){
        
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO service(id_layanan, nama_layanan, kecepatan, jasa_antar, biaya) VALUES ('"
                + s.getId_layanan() + "', '" + s.getNama_layanan() + "', '" + s.getKecepatan() + "', '"
                + s.getJasa_antar() + "', '" + s.getBiaya() + "')";
        
        System.out.println("Adding Service ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result+ " Service");
            statement.close();
        } catch(Exception e){
            System.out.println("Error adding service ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public List<Service> showService(){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM service";
        System.out.println("Picking Data Service ...");
        
        List<Service> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Service s = new Service(
                            rs.getString("id_layanan"),
                            rs.getString("nama_layanan"),
                            Integer.parseInt(rs.getString("kecepatan")),
                            rs.getString("jasa_antar"),
                            Double.parseDouble(rs.getString("biaya"))
                    );
                    list.add(s);
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e){
            System.out.println("Error reading database");
            System.out.println(e);
        }
        dbcon.closeConnection();
        return list;
    }
    
    public List<Service> showServiceBySearch(String x){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM Service as s WHERE(s.id_layanan LIKE "
                + "'%" + x + "%'"
                + "OR s.nama_layanan LIKE '%" + x + "%'"
                + "OR s.kecepatan LIKE '%" + x + "%'"
                + "OR s.jasa_antar LIKE '%" + x + "%'"
                + "OR s.biaya LIKE '%" + x + "%')";
        System.out.println("Mengambil data Service...");        
        List<Service> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql);
             
             if(rs!=null){
                 while(rs.next()){
                     Service s = new Service(rs.getString("s.id_layanan"), rs.getString("s.nama_layanan"),
                        Integer.parseInt(rs.getString("s.kecepatan")), rs.getString("s.jasa_antar"),
                        Double.parseDouble(rs.getString("s.biaya")));
                    list.add(s);
                 }
             }
             rs.close();
             statement.close();
        } catch(Exception e1){
            System.out.println("Error reading employee...");
            System.out.println(e1);
        }
        dbcon.closeConnection();
        return list;
    }
    
    public void updateService(Service s, String id){
        con = dbcon.makeConnection();
        
        String sql = "UPDATE service SET nama_layanan = '" + s.getNama_layanan() + "', "
                + "kecepatan = '" + s.getKecepatan() + "', "
                + "jasa_antar = '" + s.getJasa_antar() + "', "
                + "biaya = '" + s.getBiaya() + "'"
                + "WHERE id_layanan = '" + id + "'";
        System.out.println("Editing Service...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited "+result+" Servce " + id);
            statement.close();
        } catch(Exception e){
            System.out.println("Error editing service...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public Service searchService(String id){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM service WHERE id_layanan = '" + id + "'";
        System.out.println("Searching service ...");
        Service s = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    s = new Service(
                            rs.getString("id_layanan"),
                            rs.getString("nama_layanan"),
                            rs.getInt("kecepatan"),
                            rs.getString("jasa_antar"),
                            rs.getDouble("biaya")
                    );
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e){
            System.out.println("Erorr reading database...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        return s;
    }
    
    public void deleteService(String id){
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM service WHERE id_layanan = '" + id + "'";
        System.out.println("Deleting Service...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Service " + id);
            statement.close();
        } catch(Exception e){
            System.out.println("Error deleting service....");
            System.out.println(e);
        }
         dbcon.closeConnection();
    }
    
}

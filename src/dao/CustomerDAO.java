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
import model.Customer;
/**
 *
 * @author julia
 */
public class CustomerDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertCustomer(Customer c){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO Customer(id_customer, nama_customer, no_telp, alamat, jenis_kelamin)"
                + "VALUES ('" + c.getId_customer() + "', '" + c.getNama_customer() + "', '"
                + c.getNo_telp() + "', '" + c.getAlamat() + "', '" + c.getJenis_kelamin() + "')";
        
        System.out.println("Adding Customer...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " customer");
            statement.close();
        } catch(Exception e){
            System.out.println("Error adding Customer...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public List<Customer> showCustomer(){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM Customer";
        System.out.println("Mengambil data Customer...");
        
        List<Customer> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Customer c = new Customer(
                            rs.getString("id_customer"),
                            rs.getString("nama_customer"),
                            rs.getString("no_telp"),
                            rs.getString("alamat"),
                            rs.getString("jenis_kelamin")
                    );
                    list.add(c);
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        
        return list;
    } 
    
    public Customer searchCustomer(String id){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM Customer WHERE id_customer = '" + id + "'";
        System.out.println("Searching customer...");
        Customer c = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    c = new Customer(
                        rs.getString("id_customer"),
                        rs.getString("nama_customer"),
                        rs.getString("no_telp"),
                        rs.getString("alamat"),
                        rs.getString("jenis_kelamin")
                    );
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        return c;
    }
    
    public List<Customer> searchCustomerAll(String x){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM Customer as c WHERE(c.id_customer LIKE "
                + "'%" + x + "%' "
                + "OR c.nama_customer LIKE '%" + x + "%' "
                + "OR c.no_telp LIKE '%" + x + "%' "
                + "OR c.alamat LIKE '%" + x + "%' "
                + "OR c.jenis_kelamin LIKE '%" + x + "%')";
        
        System.out.println("Mengambil data customer...");
        List<Customer> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql);
             
             if(rs!=null){
                 while(rs.next()){
                     Customer c = new Customer(rs.getString("c.id_customer"),
                        rs.getString("c.nama_customer"), rs.getString("c.no_telp"),
                        rs.getString("c.alamat"), rs.getString("c.jenis_kelamin"));
                    list.add(c);
                 }
             }
             rs.close();
             statement.close();
        } catch(Exception e){
            System.out.println("Error reading customer...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        return list;
    }
    
    public void updateCustomer(Customer c, String id){
        con = dbcon.makeConnection();
        
        String sql = "UPDATE Customer SET nama_customer = '" + c.getNama_customer() + "', "
                + "no_telp = '" + c.getNo_telp() + "', "
                + "alamat = '" + c.getAlamat() + "', "
                + "jenis_kelamin = '" + c.getJenis_kelamin() + "' "
                + "WHERE id_customer = '" + id + "'";
        System.out.println("Editing customer...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " customer " + id);
            statement.close();
        } catch(Exception e){
            System.out.println("Error editing Customer...");
            System.out.println(e);
        }
    }
    
    public void deleteCustomer(String id){
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM Customer WHERE id_customer = '" + id + "'";
        System.out.println("Deleting Customer...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Customer " + id);
            statement.close();
        } catch(Exception e){
            System.out.println("Error deleting customer...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public String generateIDCustomer(){
       con = dbcon.makeConnection();
       
       String sql = "SELECT id_customer FROM customer ORDER BY id_customer DESC LIMIT 1";
       System.out.println("Mencari customer ...");
       int id = 0;
       String temp,temp2=null;
       
       try{
           Statement statement = con.createStatement();
           ResultSet rs = statement.executeQuery(sql);
           
           if(rs.next()){
                temp = rs.getString("id_customer");
                id = Integer.parseInt(temp.split("-")[1]);
                id++;
                temp2 = "CST-"+ id;
               
           }else{
               temp2 = "CST-1";
           }
           
           System.out.println("CEK " + temp2);
           
           rs.close();
           statement.close();
       } catch(Exception e){
           System.out.println("Error membaca database ...");
           System.out.println(e);
       }
       dbcon.closeConnection();
       return temp2;
   }
}

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
import model.Employee;
/**
 *
 * @author julia
 */
public class EmployeeDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertEmployee(Employee e){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO Employee(id_karyawan, nama_karyawan, password, no_telepon, status, posisi)"
                + "VALUES ('" + e.getId_karyawan() + "', '" + e.getNama_karyawan() + "', '"
                + e.getPassword() + "', '" + e.getStatus() + "', '" + e.getPosisi() + "')";
        
        System.out.println("Adding Employee...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Employee");
            statement.close();
        } catch(Exception e1){
            System.out.println("Error adding employee...");
            System.out.println(e1);    
        }
    }
    
    public List<Employee> showEmployee(){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM Employee";
        System.out.println("Mengambil data Employee...");
        
        List<Employee> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Employee e = new Employee(
                            rs.getString("id_karyawan"),
                            rs.getString("nama_karyawan"),
                            rs.getString("password"),
                            Integer.parseInt(rs.getString("no_telepon")),
                            rs.getString("status"),
                            rs.getString("posisi")
                    );
                    list.add(e);
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e1){
            System.out.println("Error reading database...");
            System.out.println(e1);
        }
        dbcon.closeConnection();
        
        return list;
    } 
    
    public Employee searchEmployee(String id){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM Employee WHERE id_karyawan = '" + id + "'";
        System.out.println("Searching employee...");
        Employee e = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    e = new Employee(
                        rs.getString("id_karyawan"),
                        rs.getString("nama_karyawan"),
                        rs.getString("password"),
                        Integer.parseInt(rs.getString("no_telepon")),
                        rs.getString("status"),
                        rs.getString("posisi")
                    );
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e1){
            System.out.println("Error reading database...");
            System.out.println(e1);
        }
        dbcon.closeConnection();
        return e;
    }
    
    public void updateEmployee(Employee e, String id){
        con = dbcon.makeConnection();
        
        String sql = "UPDATE Employee SET nama_karyawan = '" + e.getNama_karyawan() + "', "
                + "password = '" + e.getPassword() + "', "
                + "no_telepon = '" + e.getNo_telepon() + "', "
                + "status = '" + e.getStatus() + "', "
                + "posisi = '" + e.getPosisi() + "' "
                + "WHERE id_karyawan = '" + id + "'";
        System.out.println("Editing karyawan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " karyawan " + id);
            statement.close();
        } catch(Exception e1){
            System.out.println("Error editing employee...");
            System.out.println(e1);
        }
    }
    
    public void deleteEmployee(String id){
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM Employee WHERE id_karyawan = '" + id + "'";
        System.out.println("Deleting Employee...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Employee " + id);
            statement.close();
        } catch(Exception e1){
            System.out.println("Error deleting employee...");
            System.out.println(e1);
        }
        dbcon.closeConnection();
    }
}

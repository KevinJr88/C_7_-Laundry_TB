/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
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
    
    
//     public int insertTransaksi(Transaksi T, Pegawai P){
//        con = DbConnection.getDBCon();
//        int rowCount = 0;
//        
//        String sql = "INSERT INTO transaksi (idCustomer, tglMasuk, tglSelesai, tglAmbil, tipeLayanan, beratPakaian, beratSelimut, beratBoneka) "
//                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        
//        try{
//            PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            st.setInt(1, T.getCustomer().getId());
//            st.setString(2, T.getTglMasuk().format(Transaksi.DEFAULT_DTF));
//            st.setString(3, T.getTglSelesai().format(Transaksi.DEFAULT_DTF));
//            st.setString(4, T.getTglAmbil().format(Transaksi.DEFAULT_DTF));
//            st.setString(5, T.getTipeLayanan().toString());
//            st.setFloat(6, T.getBeratPakaian());
//            st.setFloat(7, T.getBeratSelimut());
//            st.setFloat(8, T.getBeratBoneka());
//            
//            rowCount = st.executeUpdate();
//            
//            int lastInsertId = 0;
//            ResultSet rs = st.getGeneratedKeys();
//            if(rs.next()) {
//                // https://stackoverflow.com/questions/5513180/java-preparedstatement-retrieving-last-inserted-id
//                lastInsertId = rs.getInt(1);
//            }
//
//            System.out.println(DbConnection.ANSI_GREEN + "[OK] [TransaksiPreparedDAO/insertTransaksi] Added " + rowCount + " row(s), with the last inserted id of " + lastInsertId + ".");
//            st.close();
//            
//            // Kemudian tambahkan juga job history pertamanya
//            JobHistoryPreparedDAO jhDAO = new JobHistoryPreparedDAO();
//            JobHistory JH = new JobHistory(
//                    0,
//                    lastInsertId,
//                    P,
//                    LocalDateTime.now().format(Transaksi.DEFAULT_DTF),
//                    "Menerima dan mencatat transaksi dari customer ke dalam sistem."
//            );
//            jhDAO.insertJobHistory(JH);
//        }catch(SQLException e){
//            System.out.println(DbConnection.ANSI_RED + "[E] [TransaksiPreparedDAO/insertTransaksi] Error: " + e.toString());
//        }
////        DBC.closeConnection();
//        return rowCount;
//    }
    
    
    
    public void insertWorkOrder(WorkOrder wo){
        con = dbcon.makeConnection();
      
        try{
            String sql = "INSERT INTO work_order(tanggal_masuk, tanggal_selesai, bobot, status, id_customer, id_karyawan, id_layanan, biaya) values ('"
              + String.valueOf(wo.getTanggal_masuk()) + "','" + String.valueOf(wo.getTanggal_selesai())  + "','"
              + wo.getBobot() + "','" + wo.getStatus() + "','" + wo.getCustomer().getId_customer() + "','" + wo.getKaryawan().getId_karyawan() + "','"
              + wo.getLayanan().getId_layanan() + "','" + wo.getBiaya() + "')";
        
            System.out.println("Adding Work Order...");
        }catch(Exception e){
            System.out.println("Gagal Adding WO...");
            System.out.println(e);
        }
        
        
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
        
        String sql = "SELECT wo.*, c.*, e.*, s.* FROM work_order as wo JOIN Customer as c on c.id_customer = wo.id_customer "
                + "JOIN Employee as e ON e.id_karyawan = wo.id_karyawan"
                + "JOIN Service as s ON s.id_layanan = wo.id_layanan WHERE (wo.tanggal_masuk LIKE "
                + "'%" + query + "%'"
                + "OR wo.tanggal_selesai LIKE '%" + query + "%'"
                + "OR wo.bobot LIKE '%" + query + "%'"
                + "OR wo.status LIKE '%" + query + "%'"
                + "OR s.nama_layanan LIKE '%" + query + "%'"
                + "OR wo.biaya LIKE '%" + query + "%'" 
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
                        rs.getString("c.nama_customer"), Integer.parseInt(rs.getString("c.no_telp")),
                        rs.getString("c.alamat"), rs.getString("c.jenis_kelamin"));
                    
                    Employee e = new Employee(rs.getString("e.id_karyawan"),
                        rs.getString("e.nama_karyawan"), rs.getString("e.password"),
                        Integer.parseInt(rs.getString("e.no_telepon")), rs.getString("e.status"),
                        rs.getString("e.posisi"));
                    
                    Service s = new Service(rs.getString("s.id_layanan"),
                        rs.getString("s.nama_layanan"), Integer.parseInt(rs.getString("s.kecepatan")),
                        rs.getString("s.jasa_antar"), Double.parseDouble(rs.getString("s.biaya")));
                    
                    WorkOrder wo = new WorkOrder(Integer.parseInt(rs.getString("wo.id_transaksi")), 
                        rs.getString("wo.tanggal_masuk"), rs.getString("wo.tanggal_selesai"), rs.getString("wo.tanggal_ambil"),
                        Integer.parseInt(rs.getString("wo.bobot")), rs.getString("wo.status"), c, e, s, Double.parseDouble(rs.getString("wo.biaya")));
                    
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
        
        String sql = "SELECT wo.*, c.*, e.*, s.* FROM work_order as wo "
                + "JOIN Customer as c on c.id_customer = wo.id_customer "
                + "JOIN employee as e ON e.id_karyawan = wo.id_karyawan "
                + "JOIN service as s ON s.id_layanan = wo.id_layanan WHERE (wo.status LIKE "
                + "'%" + query + "%')";
        
        System.out.println("Mengambil data work order...");
        List<WorkOrder> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Customer c = new Customer(rs.getString("c.id_customer"),
                        rs.getString("c.nama_customer"), Integer.parseInt(rs.getString("c.no_telp")),
                        rs.getString("c.alamat"), rs.getString("c.jenis_kelamin"));
                    
                    Employee e = new Employee(rs.getString("e.id_karyawan"),
                        rs.getString("e.nama_karyawan"), rs.getString("e.password"),
                        Integer.parseInt(rs.getString("e.no_telepon")), rs.getString("e.status"),
                        rs.getString("e.posisi"));
                    
                    Service s = new Service(rs.getString("s.id_layanan"),
                        rs.getString("s.nama_layanan"), Integer.parseInt(rs.getString("s.kecepatan")),
                        rs.getString("s.jasa_antar"), Double.parseDouble(rs.getString("s.biaya")));
                    
                    WorkOrder wo = new WorkOrder(Integer.parseInt(rs.getString("wo.id_transaksi")), 
                        rs.getString("wo.tanggal_masuk"), rs.getString("wo.tanggal_selesai"), rs.getString("wo.tanggal_ambil"),
                        Integer.parseInt(rs.getString("wo.bobot")), rs.getString("wo.status"), c, e, s, Double.parseDouble(rs.getString("wo.biaya")));
                    
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
    
    public List<WorkOrder> showWorkOrderCondition2(){
        con = dbcon.makeConnection();
        
        String sql = "SELECT wo.*, c.*, e.*, s.* FROM work_order as wo JOIN Customer as c on c.id_customer = wo.id_customer "
                + "JOIN Employee as e ON e.id_karyawan = wo.id_karyawan"
                + "JOIN Service as s ON s.id_layanan = wo.id_layanan WHERE (wo.status LIKE "
                + "'%" + "selesai" + "%'"
                + "AND s.jasa_antar LIKE '%" + "ya" + "%)";
        
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
                        rs.getString("s.jasa_antar"), Double.parseDouble(rs.getString("s.biaya")));
                    
                    WorkOrder wo = new WorkOrder(Integer.parseInt(rs.getString("wo.id_transaksi")), 
                        rs.getString("wo.tanggal_masuk"), rs.getString("wo.tanggal_selesai"), rs.getString("wo.tanggal_ambil"),
                        Integer.parseInt(rs.getString("wo.bobot")), rs.getString("wo.status"), c, e, s, Double.parseDouble(rs.getString("wo.biaya")));
                    
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
        
        String sql = "DELETE FROM work_order WHERE id_transaksi = " + id + "";
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

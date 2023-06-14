/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.WorkOrder;
/**
 *
 * @author Gaming
 */
public class TableWorkOrder extends AbstractTableModel{
    private List<WorkOrder> list;
    
    public TableWorkOrder(List<WorkOrder> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 7;
    }
    
    //MASIH BISA BERUBAH TERGANTUNG TAMPIL VIEW
    public String getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return String.valueOf(list.get(rowIndex).getId_transaksi());
            case 1:
                return list.get(rowIndex).getCustomer().getNama_customer();
            case 2:
                return list.get(rowIndex).getLayanan().getNama_layanan();
            case 3:
                return String.valueOf(list.get(rowIndex).getBobot());
            case 4:
                return list.get(rowIndex).getStatus();
            case 5:
                return list.get(rowIndex).getTanggal_masuk();
            case 6:
                return list.get(rowIndex).getTanggal_selesai();
            default:
                return null;
        }
    }
    
    //MASIH BISA BERUBAH TERGANTUNG SOURCE VIEW
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Transaksi";
                
            case 1:
                return "Nama Customer";
                
            case 2:
                return "Jenis Layanan";
                
            case 3:
                return "Berat Laundry (Kg)";
                
            case 4:
                return "Status";
                
            case 5:
                return "Tanggal Masuk";
                
            case 6:
                return "Tanggal Selesai";
            default:
                return null;
                   
        }
    }
    
}

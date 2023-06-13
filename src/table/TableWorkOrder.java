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
                return list.get(rowIndex).getCustomer().getNama_customer();
            case 1:
                return list.get(rowIndex).getLayanan().getNama_layanan();
            case 2:
                return String.valueOf(list.get(rowIndex).getBobot());
            case 3:
                return list.get(rowIndex).getStatus();
            case 4:
                return list.get(rowIndex).getTanggal_masuk();
            case 5:
                return list.get(rowIndex).getTanggal_selesai();
            case 6:
                return String.valueOf(list.get(rowIndex).getId_transaksi());
            default:
                return null;
        }
    }
    
    //MASIH BISA BERUBAH TERGANTUNG SOURCE VIEW
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id_transaksi";
            case 1:
                return "Tanggal_masuk";
            case 2:
                return "Tanggal_selesai";
            case 3:
                return "Bobot";
            case 4:
                return "Id_customer";
            case 5:
                return "Id_karyawan";
            case 6:
                return "Id_layanan";
            default:
                return null;
                   
        }
    }
    
}

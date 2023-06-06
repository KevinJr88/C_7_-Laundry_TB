/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Customer;
/**
 *
 * @author Gaming
 */
public class TableCustomer extends AbstractTableModel{
    private List<Customer> list;
    
    public TableCustomer(List<Customer> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 5;
    }
    
    //MASIH BISA BERUBAH TERGANTUNG TAMPIL VIEW
    public String getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_customer();
            case 1:
                return list.get(rowIndex).getNama_customer();
            case 2:
                return String.valueOf(list.get(rowIndex).getNo_telp());
            case 3:
                return list.get(rowIndex).getAlamat();
            case 4:
                return list.get(rowIndex).getJenis_kelamin();
            default:
                return null;
        }
    }
    
    //MASIH BISA BERUBAH TERGANTUNG SOURCE VIEW
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id_customer";
            case 1:
                return "Nama_customer";
            case 2:
                return "No_telp";
            case 3:
                return "Alamat";
            case 4:
                return "Jenis_kelamin";
            default:
                return null;
                   
        }
    }
}

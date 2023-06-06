/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Employee;
/**
 *
 * @author Gaming
 */
public class TableEmployee extends AbstractTableModel{
    private List<Employee> list;
    
    public TableEmployee(List<Employee> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 6;
    }
    
    //MASIH BISA BERUBAH TERGANTUNG TAMPIL VIEW
    public String getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_karyawan();
            case 1:
                return list.get(rowIndex).getNama_karyawan();
            case 2:
                return list.get(rowIndex).getPassword();
            case 3:
                return String.valueOf(list.get(rowIndex).getNo_telepon());
            case 4:
                return list.get(rowIndex).getStatus();
            case 5:
                return list.get(rowIndex).getPosisi();
            default:
                return null;
        }
    }
    
    //MASIH BISA BERUBAH TERGANTUNG SOURCE VIEW
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id_karyawan";
            case 1:
                return "Nama_karyawan";
            case 2:
                return "Password";
            case 3:
                return "No_telepon";
            case 4:
                return "Status";
            case 5:
                return "Posisi";
            default:
                return null;
                   
        }
    }
}

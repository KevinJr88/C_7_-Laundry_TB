/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Service;
/**
 *
 * @author Gaming
 */
public class TableService extends AbstractTableModel{
    private List<Service> list;
    
    public TableService(List<Service> list){
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
                return list.get(rowIndex).getId_layanan();
            case 1:
                return list.get(rowIndex).getNama_layanan();
            case 2:
                return String.valueOf(list.get(rowIndex).getKecepatan());
            case 3:
                return list.get(rowIndex).getJasa_antar();
            case 4:
                return String.valueOf(list.get(rowIndex).getBiaya());
            default:
                return null;
        }
    }
    
    //MASIH BISA BERUBAH TERGANTUNG SOURCE VIEW
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id_layanan";
            case 1:
                return "Nama_layanan";
            case 2:
                return "Kecepatan";
            case 3:
                return "Jasa_antar";
            case 4:
                return "Biaya";
            default:
                return null;
                   
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import dao.WorkOrderDAO;
import java.util.List;
import model.WorkOrder;
import table.TableWorkOrder;
/**
 *
 * @author julia
 */
public class WorkOrderControl {
    private WorkOrderDAO woDao = new WorkOrderDAO();
    
    public void insertDataWorkOrder(WorkOrder wo){
        woDao.insertWorkOrder(wo);
    }
    
    public TableWorkOrder showWorkOrder(String query){
        List<WorkOrder> dataWorkOrder = woDao.showWorkOrder(query);
        TableWorkOrder tableWorkOrder = new TableWorkOrder(dataWorkOrder);
        
        return tableWorkOrder;
    }
    
    public TableWorkOrder showWorkOrderNotDone(){
        List<WorkOrder> dataWorkOrder = woDao.showWorkOrderCondition("Proses");
        TableWorkOrder tableWorkOrder = new TableWorkOrder(dataWorkOrder);
        
        return tableWorkOrder;
    }
    
    public TableWorkOrder showWorkOrderDone(){
        List<WorkOrder> dataWorkOrder = woDao.showWorkOrderCondition("Selesai");
        TableWorkOrder tableWorkOrder = new TableWorkOrder(dataWorkOrder);
        
        return tableWorkOrder;
    }
    
    public TableWorkOrder showWorkOrderDiambil(){
        List<WorkOrder> dataWorkOrder = woDao.showWorkOrderCondition("Diambil");
        TableWorkOrder tableWorkOrder = new TableWorkOrder(dataWorkOrder);
        
        return tableWorkOrder;
    }
    
    public TableWorkOrder showWorkOrderDiantar(){
        List<WorkOrder> dataWorkOrder = woDao.showWorkOrderCondition2();
        TableWorkOrder tableWorkOrder = new TableWorkOrder(dataWorkOrder);
        
        return tableWorkOrder;
    }
    
    public void deleteDataWorkOrder(int id){
        woDao.deleteWorkOrder(id);
    }
}

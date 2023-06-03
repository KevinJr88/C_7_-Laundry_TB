/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import dao.ServiceDAO;
import java.util.List;
import model.Service;
import table.TableService;
/**
 *
 * @author julia
 */
public class ServiceControl {
    private ServiceDAO sDao = new ServiceDAO();
    
    public void insertDataService(Service s){
        sDao.insertService(s);
    }
    
    public TableService showDataService(){
        List<Service> dataService = sDao.showService();
        TableService tableService = new TableService(dataService);
        
        return tableService;
    }
    
    public void updateDataService(Service s){
        sDao.updateService(s);
    }
    
    public void deleteDataService(String id){
        sDao.deleteService(id);
    }
}

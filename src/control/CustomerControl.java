/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import dao.CustomerDAO;
import java.util.List;
import model.Customer;
import table.TableCustomer;
/**
 *
 * @author julia
 */
public class CustomerControl {
    private CustomerDAO cDao = new CustomerDAO();
    
    public void insertDataCustomer(Customer c){
        cDao.insertCustomer(c);
    }
    
    public TableCustomer showDataCustomer(){
        List<Customer> dataCustomer = cDao.showCustomer();
        TableCustomer tableCustomer = new TableCustomer(dataCustomer);
        
        return tableCustomer;
    }
    
    public TableCustomer showDataBySearch(String query){
        List<Customer> dataCustomer = cDao.searchCustomerAll(query);
        TableCustomer tableCustomer = new TableCustomer(dataCustomer);
        
        return tableCustomer;
    }
    
    public void updateDataCustomer(Customer c, String id){
        cDao.updateCustomer(c, id);
    }
    
    public void deleteDataCustomer(String id){
        cDao.deleteCustomer(id);
    }
    
     public String generateIDCustomer(){
        String temp = null;
        temp = cDao.generateIDCustomer();
        return temp;
    }
    
}

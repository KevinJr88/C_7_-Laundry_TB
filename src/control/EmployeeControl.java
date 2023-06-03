/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import dao.EmployeeDAO;
import java.util.List;
import model.Employee;
import table.TableEmployee;
/**
 *
 * @author julia
 */
public class EmployeeControl {
    private EmployeeDAO eDao = new EmployeeDAO();
    
    public void insertDataEmployee(Employee e){
        eDao.insertEmployee(e);
    }
    
    public TableEmployee showDataEmployee(){
        List<Employee> dataEmployee = eDao.showEmployee();
        TableEmployee tableEmployee = new TableEmployee(dataEmployee);
        
        return tableEmployee;
    }
    
    public void updateDataEmployee(Employee e, String id){
        eDao.updateEmployee(e, id);
    }
    
    public void deleteDataEmployee(String id){
        eDao.deleteEmployee(id);
    }
}

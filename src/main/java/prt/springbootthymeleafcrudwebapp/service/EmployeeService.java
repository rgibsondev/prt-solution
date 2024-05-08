
package prt.springbootthymeleafcrudwebapp.service;

import java.util.List;
import prt.springbootthymeleafcrudwebapp.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    
    //Save employ by passing the Employee object into the method
    void saveEmployee(Employee employee);
    
    //get Employee by ID
    Employee getEmployeeById(long id);
    
    void deleteEmployeeById(long id);
}


package prt.springbootthymeleafcrudwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import prt.springbootthymeleafcrudwebapp.model.Employee;
import prt.springbootthymeleafcrudwebapp.service.EmployeeService;


@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    //Create method handler which will display a list of employees for home page index.html to display
    @GetMapping("/index")
    public String viewHomePage (Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }
    
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //Create a model to bind new employee data
       Employee employee = new Employee();
       model.addAttribute("employee", employee);
       return "new_employee";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee")Employee employee){
    //save employee tp database
    employeeService.saveEmployee(employee);
    return "redirect:/index";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model){
    //Get the employee from the service
    Employee employee = employeeService.getEmployeeById(id);
    
    //set employee as a model attribute to pre-populate th form
    model.addAttribute("employee", employee);
    return "update_employee";
    }
    
    //delete employee by id
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable( value = "id") long id){
    
    //Call delete method from the service
    this.employeeService.deleteEmployeeById(id);
        return "redirect:/index";
    }
}



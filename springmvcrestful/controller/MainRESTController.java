package org.o7planning.springmvcrestful.controller;
 
import java.util.List;
 
import org.o7planning.springmvcrestful.dao.EmployeeDAO;
import org.o7planning.springmvcrestful.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class MainRESTController {
 
    @Autowired
    private EmployeeDAO employeeDAO;
 
    @RequestMapping("/")
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employees
    // http://localhost:8080/SpringMVCRESTful/employees.xml
    // http://localhost:8080/SpringMVCRESTful/employees.json
    @RequestMapping(value = "/employees", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Employee> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }
  
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employees/{empNo}
    // http://localhost:8080/SpringMVCRESTful/employees/{empNo}.xml
    // http://localhost:8080/SpringMVCRESTful/employees/{empNo}.json
    @RequestMapping(value = "/employees/{empNo}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
 
    public Employee getEmployee(@PathVariable("empNo") String empNo) {
        return employeeDAO.getEmployee(empNo);
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employees
    // http://localhost:8080/SpringMVCRESTful/employees.xml
    // http://localhost:8080/SpringMVCRESTful/employees.json
    @RequestMapping(value = "/employees", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
 
    public Employee addEmployee(Employee emp) {
        return employeeDAO.addEmployee(emp);
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employees
    // http://localhost:8080/SpringMVCRESTful/employees.xml
    // http://localhost:8080/SpringMVCRESTful/employees.json
    @RequestMapping(value = "/employees", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Employee updateEmployee(Employee emp) {
        return employeeDAO.updateEmployee(emp);
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employees/{empNo}
    @RequestMapping(value = "/employees/{empNo}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteEmployee(@PathVariable("empNo") String empNo) {
        employeeDAO.deleteEmployee(empNo);
    }
  
}
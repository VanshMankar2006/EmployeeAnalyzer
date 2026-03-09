package Projects.EmployeeAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManager {
    // store emp by id
    Map<String,Employee> empDataList;

    // constructor
    public EmployeeManager() {
        this.empDataList = new HashMap<>();
    }

    // to add employee
    public void addEmp(Employee emp){
        empDataList.put(emp.getEmpId(), emp);
    }
    // fectch emp by id
    public Optional<Employee> findEmpById(String id){
        return Optional.ofNullable(empDataList.get(id));
    }
    // get all employees
    public List<Employee> getAllEmp(){
        return new ArrayList<>(empDataList.values());
    }
    // get employee by filter salary
    public List<Employee> filterEmpBySalary(double minsalary){
        return empDataList.values().stream()
        .filter(emp->emp.getEmpSalary().orElse(0.0)>=minsalary)
        .collect(Collectors.toList());

    }
    // sort employee by salary
    public List<Employee> sortEmpBySalary(){
        return empDataList.values().stream()
        .sorted(Comparator.comparingDouble(e->e.getEmpSalary().orElse(0.0)))
        .toList();
    }
    // sort employee by dept
    public List<Employee> filterEmpByDept(String dept){
        return empDataList.values().stream()
        .filter(emp->emp.getEmpDept().equalsIgnoreCase(dept))
        .toList();
    }
    // sort emp by dept
    public List<Employee> sortEmpByDept(){
        return empDataList.values().stream()
        .sorted(Comparator.comparing(Employee::getEmpDept))
        .toList();
    }

}

package Projects.EmployeeAnalyzer;
import java.util.Optional;

public class Employee {

    private String empId;
    private String empName;
    private String empDept;
    private double empSalary;

    public Employee(String empId, String empName, String empDept, double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empDept = empDept;
        this.empSalary = empSalary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpDept() {
        return empDept;
    }

    public Optional<Double> getEmpSalary() {
        return Optional.ofNullable(empSalary);
    }

    @Override
    public String toString() {
        return String.format("ID: %-5s | Name: %-15s | Department: %-10s | Salary: %2f" , 
                empId,empName,empDept,empSalary );

    }
       

}

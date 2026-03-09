package Projects.EmployeeAnalyzer;

import java.util.Optional;

public class EmployeeProcessor extends Thread{
    private EmployeeManager empManager;
    private String empId;

    public EmployeeProcessor(EmployeeManager empManager,String empId){
        this.empManager = empManager;
        this.empId = empId;
    }

    @Override
    public void run() {
        try {
            Optional<Employee> emp = empManager.findEmpById(empId);
            emp.ifPresentOrElse(em ->System.out.println("Processing employee : "+em),
            ()-> System.out.println("Employee with "+empId+" not found"));

        } catch (Exception e) {
            System.out.println("Processing error.... "+e.getMessage());
        }
    }
}

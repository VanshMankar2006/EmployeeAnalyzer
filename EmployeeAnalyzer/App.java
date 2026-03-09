package Projects.EmployeeAnalyzer;

import java.util.*;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeManager manager = new EmployeeManager();

    public static void main(String[] args) {
        // Pre-populate with some data so the list isn't empty at start
        seedInitialData();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> findEmployee();
                case "3" -> {
                    System.out.println("\n--- Employees Details ---");
                    List<Employee> all = manager.getAllEmp();
                    printList(all);
                }
                case "4" -> filterBySalary();
                case "5" -> filterByDept();
                case "6" -> {
                    System.out.println("\n--- Employee By Salary ---");
                    printList(manager.sortEmpBySalary());
                }
                case "7" -> {
                    System.out.println("\n--- Employee By Department ---");
                    printList(manager.sortEmpByDept());
                }
                case "0" -> {
                    System.out.println("Exiting System...");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please enter 0-7.");
            }
        }
    }

    //  Prints any list of employees or a message if empty
    private static void printList(List<Employee> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No employees found in the system.");
        } else {
            list.forEach(emp -> System.out.println(emp.toString()));
            System.out.println("Total Records: " + list.size());
        }
    }

    private static void addEmployee() {
        try {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Dept: ");
            String dept = scanner.nextLine();
            System.out.print("Enter Salary: ");
            double sal = Double.parseDouble(scanner.nextLine());
            
            manager.addEmp(new Employee(id, name, dept, sal));
            System.out.println("Success: Employee added.");
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Employee not added.");
        }
    }

    private static void findEmployee() {
        System.out.print("Enter ID to search: ");
        String id = scanner.nextLine();
        manager.findEmpById(id).ifPresentOrElse(
            System.out::println,
            () -> System.out.println("Employee not found with ID: " + id)
        );
    }

    private static void filterBySalary() {
        System.out.print("Enter Minimum Salary: ");
        double min = Double.parseDouble(scanner.nextLine());
        printList(manager.filterEmpBySalary(min));
    }

    private static void filterByDept() {
        System.out.print("Enter Dept Name: ");
        String dept = scanner.nextLine();
        printList(manager.filterEmpByDept(dept));
    }

    private static void printMenu() {
        System.out.println("\n================================");
        System.out.println("1. Add    2. Find    3. Show All");
        System.out.println("4. Filter Salary     5. Filter Dept");
        System.out.println("6. Sort Salary       7. Sort Dept");
        System.out.println("0. Exit");
        System.out.print("Selection: ");
    }

    private static void seedInitialData() {
        manager.addEmp(new Employee("Emp101", "Sandy", "Engineering", 75000));
        manager.addEmp(new Employee("Emp103", "Panu", "Marketing", 58000));
        manager.addEmp(new Employee("Emp104", "Bunny", "HR", 60000));
    }
}
// Abstract class Employee representing a general employee
abstract class Employee {
    protected String name;
    protected int employeeID;

    public Employee(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + calculateSalary());
    }
}

// Full-time employee subclass
class FullTimeEmployee extends Employee {
    private final double monthlySalary;

    public FullTimeEmployee(String name, int employeeID, double monthlySalary) {
        super(name, employeeID);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary * 12; // Annual salary
    }
}

// Part-time employee subclass
class PartTimeEmployee extends Employee {
    private final double hourlyWage;
    private final int hoursWorked;

    public PartTimeEmployee(String name, int employeeID, double hourlyWage, int hoursWorked) {
        super(name, employeeID);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyWage * hoursWorked;
    }
}

// Contract employee subclass
class ContractEmployee extends Employee {
    private final double projectFee;

    public ContractEmployee(String name, int employeeID, int projectDuration, double projectFee) {
        super(name, employeeID);
        // in months
        this.projectFee = projectFee;
    }

    @Override
    public double calculateSalary() {
        return projectFee;
    }
}

// Manager class to manage employees
import java.util.ArrayList;

class EmployeeManager {
    private final ArrayList<Employee> employees = new ArrayList<>();

    // Method to add an employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Method to remove an employee by employee ID
    public void removeEmployee(int employeeID) {
        employees.removeIf(employee -> employee.employeeID == employeeID);
    }

    // Method to display all employee details
    public void displayAllEmployees() {
        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println("-----------------------");
        }
    }

    // Method to calculate the total salary of all employees
    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }
}

// Main class to test the system
public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        // Creating employees
        FullTimeEmployee fte = new FullTimeEmployee("Alice", 1, 5000);
        PartTimeEmployee pte = new PartTimeEmployee("Bob", 2, 20, 100);
        ContractEmployee ce = new ContractEmployee("Charlie", 3, 6, 3000);

        // Adding employees
        manager.addEmployee(fte);
        manager.addEmployee(pte);
        manager.addEmployee(ce);

        // Displaying all employees
        System.out.println("Employee Details:");
        manager.displayAllEmployees();

        // Calculating total salary
        System.out.println("Total Salary of all employees: $" + manager.calculateTotalSalary());
    }
}

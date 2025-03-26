import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

abstract class Employee {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract double getIncome();

    @Override
    public abstract String toString();
}

class FullTimeEmployee extends Employee {
    private double salary;
    private double bonus;

    public FullTimeEmployee(int id, String name, double salary, double bonus) {
        super(id, name);
        this.salary = salary;
        this.bonus = bonus;
    }

    @Override
    public double getIncome() {
        return salary + bonus;
    }

    @Override
    public String toString() {
        return String.format("Full-Time Employee: %s (ID: %d) - Salary: $%.1f, Bonus: $%.1f, Income: $%.1f", name, id, salary, bonus, this.getIncome());
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getIncome() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part-Time Employee: %s (ID: %d) - Hourly Rate: $%.1f, Hours Worked: %d, Income: $%.1f", name, id, hourlyRate, hoursWorked, this.getIncome());
    }
}


class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void initialize() {
        try {
            File employeesFile = new File("employees.txt");
            Scanner scanner = new Scanner(employeesFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(", ");
                int id = Integer.parseInt(data[1]);
                String name = data[2];
                if (data[0].equals("F")) {
                    double salary = Double.parseDouble(data[3]);
                    double bonus = Double.parseDouble(data[4]);
                    employees.add(new FullTimeEmployee(id, name, salary, bonus));
                } else if (data[0].equals("P")) {
                    double hourlyRate = Double.parseDouble(data[3]);
                    int hoursWorked = Integer.parseInt(data[4]);
                    employees.add(new PartTimeEmployee(id, name, hourlyRate, hoursWorked));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void sortIncome() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.getIncome(), e1.getIncome());
            }
        });
    }

    public void display() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.initialize();
        manager.sortIncome();
        manager.display();
    }
}
public class EmployeeManagerTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.initialize();
        manager.sortIncome();
        manager.display();
    }
}

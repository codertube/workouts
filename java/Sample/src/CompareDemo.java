import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    private int id;
    String name;
    int salary;

    Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, id);
    }

//    @Override
//    public int compareTo(Employee emp) {
//        return this.name.compareTo(emp.name);
//    }
}

class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int ret = e1.getName().compareTo(e2.getName());
        if (ret == 0) {
            ret = Integer.compare(e1.getSalary(), e2.getSalary());
        }
        return ret;
    }
}

public class CompareDemo {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Adam Noe", 10000);
        Employee employee2 = new Employee(2, "John Joe", 5000);
        Employee employee3 = new Employee(3, "Ricky Martin", 7000);
        //List<Employee> employees = Arrays.asList(employee1, employee2, employee3); //cannot use add(),remove(), but set() works
        //List<Employee> employees = List.of(employee1, employee2, employee3); //immutable list
        List<Employee> employees = Stream.of(employee1, employee2, employee3).collect(Collectors.toList()); //mutable list
        //employees.set(1,employee3);
        employees.add(new Employee(4, "David Crawley", 6000));
        employees.add(new Employee(5, "John Joe", 7000));
        //Collections.sort(employees);
        //employees.sort(new EmployeeSalaryComparator());
        employees.sort(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()).thenComparing(Employee::getName));
        for (Employee employee : employees) {
            System.out.println(employee.name + " :: "+ employee.salary);
        }

        int sumSal = employees.stream()
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println("Salary sum :: "+ sumSal);

        List<String> names = employees.stream().map(Employee::getName).toList();
        for (String name : names) {
            System.out.println(name);
        }
        String joinedStr = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println( joinedStr);
        Map<String, Integer> nameLength = employees.stream()
                .map(Employee::getName)
                .distinct()
                .collect(Collectors.toMap(name -> name, String::length));
        nameLength.forEach((k,v) -> System.out.println(k + " :: "+ v));
    }
}

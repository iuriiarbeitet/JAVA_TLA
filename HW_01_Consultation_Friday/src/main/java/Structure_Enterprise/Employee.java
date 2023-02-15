package Structure_Enterprise;

public class Employee {
    private String name;
    private String surname;
    private String fatherSurname;
    private double salaryYear;
    private String department;

    public Employee(String name, String surname, String fatherSurname, double salary, String department) {
        this.name = name;
        this.surname = surname;
        this.fatherSurname = fatherSurname;
        salaryYear = salary;
        this.department = department;
    }
    public Employee() {

    }
    public void info(){
        System.out.println("Сотрудник общего отдела");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherSurname() {
        return fatherSurname;
    }

    public double getSalaryYear() {
        return salaryYear;
    }

    public String getDepartment() {
        return department;
    }
}

package Structure_Enterprise;

public class Employee_Contract extends Employee {

    public Employee_Contract(String name, String surname, String fatherSurname, double salary, String department) {
        super(name, surname, fatherSurname, salary, department);
    }
    public Employee_Contract() {

    }

    @Override
    public void info() {
        System.out.println("Сотрудник по контракту.");
    }
}

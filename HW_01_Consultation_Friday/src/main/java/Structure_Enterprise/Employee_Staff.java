package Structure_Enterprise;

public class Employee_Staff extends Employee{

    public Employee_Staff(){
    }

    public Employee_Staff(String name, String surname, String fatherSurname, double salary, String department) {
        super(name, surname, fatherSurname, salary, department);
    }

    @Override
    public void info() {
        System.out.println("Штатный сотрудник");
    }
}

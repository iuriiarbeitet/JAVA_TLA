package Structure_Enterprise;

public class main {

        public static void main(String[] args) {
            Firma firma = new Firma("\"Endava\" - Java Development");
            Departament departament = new Departament("\"Software\" Java Development", 105, "remoteKontract");
            Employee employee = new Employee("Rotari", "Iurii", "Vasile", 150_000, departament.getName());
                employee.info();
            Employee_Staff employee_staff = new Employee_Staff();
                employee_staff.info();
            Employee_Contract employee_contract = new Employee_Contract();
                employee_contract.info();
    }
}

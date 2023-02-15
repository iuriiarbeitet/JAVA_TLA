package Structure_Enterprise;

public class Departament {
    private String name;
    private int numberEmplyees;
    private String nameFirm;

    public Departament(String name, int numberEmplyees, String getDepartName) {
        this.name = name;
        this.numberEmplyees = numberEmplyees;
        this.nameFirm = getDepartName;
    }
    public void info(){
        System.out.println("General Department");
    }

    public String getName() {
        return name;
    }

    public int getNumberEmplyees() {
        return numberEmplyees;
    }

    public String getNameFirm() {
        return nameFirm;
    }
}

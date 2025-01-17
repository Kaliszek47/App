package App;

public class Employee extends Person {

    private Departament departament;
    private final int age;
    private final String pesel;

    // Konstruktor przyjmujący wszystkie dane
    public Employee(String name, String surname, int age, String pesel, Departament departament) {
        super(name, surname, age, pesel); // przekazujemy wiek i pesel do konstruktora klasy Person
        this.departament = departament;
        this.age = age;
        this.pesel = pesel;
    }

    // Gettery
    public int getAge() {
        return age;
    }

    public String getPesel() {
        return pesel;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
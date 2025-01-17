package App;

import java.util.List;

public class Company {
    private String name;
    private Address address;
    private List<Employee> employees;

    public Company(String name) {
        this.name = name;
    }

    // Getter i setter dla nazwy firmy
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter i setter dla adresu firmy
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Getter i setter dla listy pracowników
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // Metoda do dodawania nowego pracownika
    public void addEmployee(String name, String surname, int age, String pesel) {
        Departament.printDepartments();
        int departmentId = Utils.inputInt("Podaj ID działu dla nowego pracownika: ");

        if (departmentId >= 0 && departmentId < Departament.values().length) {
            Employee employee = new Employee(name, surname, age, pesel, Departament.values()[departmentId]);
            employees.add(employee);
            Utils.printAnswer("Dodano pracownika: " + employee.getFullName() + " do działu " + employee.getDepartament().getName());
        } else {
            Utils.printAnswer("Nieprawidłowy ID działu, pracownik nie został dodany.");
        }
    }

    // Metoda do wyświetlania wszystkich pracowników
    public void printEmployees() {
        System.out.println();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            // Wyświetlanie pełnych danych pracownika (w tym wiek, pesel i dział)
            System.out.println(i + " - " + employee.getFullName() + " - Wiek: " + employee.getAge() + " - PESEL: " + employee.getPesel() + " - Dział: " + employee.getDepartament().getName());
        }
        System.out.println();
    }

    // Metoda do usuwania pracownika
    public void removeEmployee(int index) {
        if (invalidIndex(index)) return;

        Employee employee = employees.get(index);
        employees.remove(index);
        Utils.printAnswer("Pomyślnie zwolniono pracownika: %s %s".formatted(employee.getName(), employee.getSurname()));
    }

    // Metoda do edytowania danych pracownika
    public void editEmployee(int index) {
        if (invalidIndex(index)) return;

        Employee employee = employees.get(index);

        System.out.println("Edytujesz dane pracownika: " + employee.getName() + " " + employee.getSurname());

        String oldName = employee.getName();
        String oldSurname = employee.getSurname();

        // Zmiana imienia i nazwiska
        employee.setName(Utils.inputString("Podaj nowe imię (lub zostaw puste, aby nie zmieniać): "));
        employee.setSurname(Utils.inputString("Podaj nowe nazwisko (lub zostaw puste, aby nie zmieniać): "));

        // Wyświetlenie i edycja działu
        System.out.println("Obecny dział: " + employee.getDepartament().getName());
        Departament.printDepartments();
        int departmentId = Utils.inputInt("Podaj nowy ID działu (lub -1, aby nie zmieniać): ");

        if (departmentId >= 0 && departmentId < Departament.values().length) {
            employee.setDepartament(Departament.values()[departmentId]);
            Utils.printAnswer("Zmieniono dział na: " + employee.getDepartament().getName());
        } else if (departmentId == -1) {
            Utils.printAnswer("Dział nie został zmieniony.");
        } else {
            Utils.printAnswer("Nieprawidłowy ID działu.");
        }

        Utils.printAnswer("Zmieniono dane pracownika: %s %s na %s %s".formatted(oldName, oldSurname, employee.getName(), employee.getSurname()));
    }

    // Pomocnicza metoda do sprawdzania poprawności indeksu
    private boolean invalidIndex(int index) {
        if (index < 0 || index >= employees.size()) {
            Utils.printAnswer("Nie ma pracownika o podanym id");
            return true;
        }
        return false;
    }
}
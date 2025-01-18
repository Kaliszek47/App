package App;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utils {

    // Metoda do inicjowania danych
    static Company initData() {
        Person firstPerson = new Person("Michael", "Jackson", 0, "12345678901");
        Person secondPerson = new Person("Natalia", "Kaliszek", 19, "23456789012");
        Person thirdPerson = new Person("Donald", "Trump", 1, "34567890123");
        Person fourthPerson = new Person("Albert", "Einstein", 1000, "45678901234");
        Person fifthPerson = new Person("Święty", "Mikołaj", 99, "56789012345");
        Person sixthPerson = new Person("Super", "Man", 30, "67890123456");

        Employee firstEmployee = new Employee(firstPerson.getName(), firstPerson.getSurname(), firstPerson.getAge(), firstPerson.getPesel(), Departament.SALES);
        Employee secondEmployee = new Employee(secondPerson.getName(), secondPerson.getSurname(), secondPerson.getAge(), secondPerson.getPesel(), Departament.FINANCE);
        Employee thirdEmployee = new Employee(thirdPerson.getName(), thirdPerson.getSurname(), thirdPerson.getAge(), thirdPerson.getPesel(), Departament.ADMINISTRATION);
        Employee fourthEmployee = new Employee(fourthPerson.getName(), fourthPerson.getSurname(), fourthPerson.getAge(), fourthPerson.getPesel(), Departament.FINANCE);
        Employee fifthEmployee = new Employee(fifthPerson.getName(), fifthPerson.getSurname(), fifthPerson.getAge(), fifthPerson.getPesel(), Departament.FINANCE);
        Employee sixthEmployee = new Employee(sixthPerson.getName(), sixthPerson.getSurname(), sixthPerson.getAge(), sixthPerson.getPesel(), Departament.SALES);

        List<Employee> employees = new ArrayList<>();
        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(thirdEmployee);
        employees.add(fourthEmployee);
        employees.add(fifthEmployee);
        employees.add(sixthEmployee);

        Company company = new Company("Moja firma");
        company.setEmployees(employees);

        return company;
    }

    static int inputInt(String message) {
        try {
            System.out.print(message);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Podano błędną wartość");
            return inputInt(message);
        }
    }

    static String inputString(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static void printBanner(String title) {
        String border = "+" + "-".repeat(title.length() + 2) + "+";

        System.out.println("\n" + border);
        System.out.println("| " + title.toUpperCase() + " |");
        System.out.println(border + "\n");
    }

    static void printAnswer(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    static void printOptions() {
        System.out.println("Dostępne operacje:");
        System.out.println("1. Wyświetl pracowników");
        System.out.println("2. Dodaj pracownika");
        System.out.println("3. Zwolnij pracownika");
        System.out.println("4. Edytuj dane pracownika");
        System.out.println("5. Wyświetl pracowników wg działu");
        System.out.println("0. Zakończ program");
        System.out.println();
    }
}

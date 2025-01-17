package App;

public class Main {
    public static void main(String[] args) {
        Company company = Utils.initData();
        Utils.printBanner("Panel administracyjny firmy " + company.getName());

        boolean done = false;
        while (!done) {
            Utils.printOptions();
            int choice = Utils.inputInt("wybierz operację: ");

            switch (choice) {
                case 1:
                    company.printEmployees();
                    break;
                case 2:
                    company.addEmployee(
                            Utils.inputString("Podaj imię: "),
                            Utils.inputString("Podaj nazwisko: "),
                            Utils.inputInt("Podaj wiek: "),
                            Utils.inputString("Podaj PESEL: ")
                    );
                    break;
                case 3:
                    company.printEmployees();
                    company.removeEmployee(Utils.inputInt("Podaj id pracownika: "));
                    break;
                case 4:
                    company.printEmployees();
                    company.editEmployee(Utils.inputInt("Podaj id pracownika: "));
                    break;
                case 5:
                    Departament.printDepartments();
                    Departament departament = Departament.values()[Utils.inputInt("Podaj id działu: ")];
                    System.out.println("Pracownicy działu " + departament.getName() + ":");
                    for (int i = 0; i < company.getEmployees().size(); i++) {
                        if (company.getEmployees().get(i).getDepartament() == departament) {
                            System.out.println(i + " - " + company.getEmployees().get(i));
                        }
                    }
                    System.out.println();

                    break;
                case 0:
                    Utils.printAnswer("Do zobaczenia!");
                    done = true;
                    break;
                default:
                    Utils.printAnswer("Podano błędną wartość, spróbuj jeszcze raz");
            }
        }
    }

}

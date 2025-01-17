package App;

import java.util.Arrays;

public enum Departament {
    SALES("Sprzedaż"),
    FINANCE("Finanse"),
    ADMINISTRATION("Administracja");

    private final String name;

    private Departament(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void printDepartments() {
        System.out.println();
        for (int i = 0; i < Departament.values().length; i++) {
            System.out.println(i + " - " + Departament.values()[i].getName());
        }
        System.out.println();
    }
}

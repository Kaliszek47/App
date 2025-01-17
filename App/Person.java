package App;

class Person {
    private String name;
    private String surname;
    private final int age;
    private final String pesel;
    private Address address;

    // Konstruktor przyjmujący wszystkie potrzebne dane
    public Person(String name, String surname, int age, String pesel) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.pesel = pesel;
    }

    // Getter dla adresu
    public Address getAddress() {
        return address;
    }

    public void setAddress(String city, String street) {
        this.address = new Address(street, city);
    }

    // Gettery i settery dla imienia i nazwiska
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Gettery dla wieku i peselu
    public int getAge() {
        return age;
    }

    public String getPesel() {
        return pesel;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return this.getFullName();
    }
}
package e1;

// CONSTANTES (enum)
// Asignaturas
public enum Subject {
    HISTORY(200),
    TRANSFIGURATION(400),
    DEFENCE(500),
    HERBOLOGY(250),
    POTIONS(350);

    private final int salary;

    Subject(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
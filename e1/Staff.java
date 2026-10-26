package e1;

public abstract class Staff extends HogwartsMember {

    public Staff(String firstName, String lastName, int age, int horcruxesDestroyed) {
        super(firstName, lastName, age, horcruxesDestroyed);
    }

    // Definir salario de empleados
    public abstract int getSalary();

    // Definir categoría de empleados
    public abstract String getStaffCategory();
}

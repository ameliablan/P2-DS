package e1;

public abstract class Staff extends HogwartsMember {

    public Staff(String firstName, String lastName, int age, int horcruxesDestroyed) {
        super(firstName, lastName, age, horcruxesDestroyed);
    }

    // Obliga a todos los empleados a definir su salario
    public abstract int getSalary();

    // Obliga a todos los empleados a definir su categoría
    public abstract String getStaffCategory();
}

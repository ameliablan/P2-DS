package e1;

// Caretaker (Conserje) hereda de Staff, por lo que es un empleado de la escuela
public class Caretaker extends Staff {

    // El constructor pasa los datos básicos al Staff.
    // A diferencia de los residentes, el conserje no pertenece a una Casa (al igual que el gamekeeper)
    public Caretaker(String firstName, String lastName, int age, int horcruxesDestroyed) {
        super(firstName, lastName, age, horcruxesDestroyed);
    }

    // Definir la recompensa específica del conserje por destruir un horrocrux
    @Override
    public double getGalleonsPerHorcrux() {
        return 65.0;
    }

    // Calcular el salario del conserje (150 de base + 10 plus noche)
    @Override
    public int getSalary() {
        return 150 + 10;
    }

    // Usa el nombre del cargo como descripción para los reportes de recompensas
    @Override
    public String getRewardDescription() {
        return getStaffCategory();
    }

    // Definir categoría de este empleado específico
    @Override
    public String getStaffCategory() {
        return "Caretaker";
    }
}

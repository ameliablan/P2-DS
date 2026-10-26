package e1;

// Guardabosques: hereda de Staff (Personal)
public class Gamekeeper extends Staff {

    // El constructor pasa los datos básicos al padre (Staff)
    // Al igual que el conserje (caretaker), no pertenece a ninguna Casa de estudiantes
    public Gamekeeper(String firstName, String lastName, int age, int horcruxesDestroyed) {
        super(firstName, lastName, age, horcruxesDestroyed);
    }

    // Define la recompensa específica del guardabosques por destruir un horrocrux
    @Override
    public double getGalleonsPerHorcrux() {
        return 75.0; // 75 galeones por horrocrux
    }

    // Calcula el salario del guardabosques (170 de base + 10 bono noche)
    @Override
    public int getSalary() {
        return 170 + 10;
    }

    // Al igual que el conserje, usa su cargo como descripción para las recompensas
    @Override
    public String getRewardDescription() {
        return getStaffCategory();
    }

    // Define el título o cargo oficial de este empleado
    @Override
    public String getStaffCategory() {
        return "Gamekeeper";
    }
}
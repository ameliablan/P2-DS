package e1;

import java.util.ArrayList;
import java.util.List;

public class School {
    // Almacena a todos los miembros de la escuela (tanto estudiantes como personal)
    private final List<HogwartsMember> members;

    public School() {
        this.members = new ArrayList<>();
    }

    // Añade un nuevo miembro, asegurándose de no incluir valores nulos (para evitar errores)
    public void addMember(HogwartsMember member) {
        if (member != null) {
            this.members.add(member);
        }
    }

    // Genera un texto con las recompensas por destruir horrocruxes de todos los miembros
    public String printRewards() {
        StringBuilder sb = new StringBuilder();
        double totalRewards = 0.0;

        for (HogwartsMember member : members) {
            double reward = member.getReward();
            totalRewards += reward;

            // Construye la línea de texto para cada miembro con sus datos y recompensa
            sb.append(String.format("%s %s (%s, %d horcruxes): %.1f galleons\n",
                    member.getFirstName(),
                    member.getLastName(),
                    member.getRewardDescription(),
                    member.getHorcruxesDestroyed(),
                    reward));
        }

        sb.append(String.format("The total reward for Hogwarts School is %.1f galleons", totalRewards));
        return sb.toString();
    }

    // Genera un texto con las nóminas, aplicable únicamente a los empleados
    public String printSalaries() {
        StringBuilder sb = new StringBuilder();
        int totalSalaries = 0;

        for (HogwartsMember member : members) {
            // Verifica si el miembro es un empleado (Staff) y lo convierte automáticamente
            if (member instanceof Staff staff) {
                int salary = staff.getSalary();
                totalSalaries += salary;

                sb.append(String.format("%s %s (%s): %d galleons\n",
                        staff.getFirstName(),
                        staff.getLastName(),
                        staff.getStaffCategory(),
                        salary));
            }
        }

        sb.append(String.format("The total payroll for Hogwarts School is %d galleons", totalSalaries));
        return sb.toString();
    }
}
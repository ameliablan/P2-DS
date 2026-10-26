package e1;

// Teacher (Profesor) hereda de Staff e introduce la asignatura (Subject) que imparte
public class Teacher extends Staff {
    private final Subject subject; // Almacena la materia que enseña el profesor

    // El constructor pasa los datos básicos al padre (Staff) y guarda la asignatura
    public Teacher(String firstName, String lastName, int age, int horcruxesDestroyed, Subject subject) {
        super(firstName, lastName, age, horcruxesDestroyed);
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    // Define la recompensa base para los profesores: 50 galeones por horrocrux
    @Override
    public double getGalleonsPerHorcrux() {
        return 50.0;
    }

/**
 * Representa a un profesor de Hogwarts.
 * Su recompensa sufre una penalización del 25% si imparte Defensa.
 */
public class Teacher extends Staff { ...

    @Override
    public double getReward() {
        double baseReward = super.getReward();
        return (subject == Subject.DEFENCE) ? baseReward * 0.75 : baseReward;
    }
        return baseReward; // Los demás profesores cobran el 100%
    }

    // El salario está fijado en la asignatura
    @Override
    public int getSalary() {
        return subject.getSalary();
    }

    // Usa su categoría como descripción en los reportes de recompensas
    @Override
    public String getRewardDescription() {
        return getStaffCategory();
    }

    // Define el cargo formateando el nombre de la asignatura (Teacher of... (subject))
    @Override
    public String getStaffCategory() {
        return "Teacher of " + subject.name().charAt(0) + subject.name().substring(1).toLowerCase();
    }
}
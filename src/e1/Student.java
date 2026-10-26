package e1;

// Representa a un estudiante en Hogwarts
public class Student extends Resident {

    // Envía los datos a la clase padre (Resident)
    public Student(String firstName, String lastName, int age, int horcruxesDestroyed, House house) {
        super(firstName, lastName, age, horcruxesDestroyed, house);
    }

    // Paga 90 galeones por cada horrocrux
    @Override
    public double getGalleonsPerHorcrux() {
        return 90.0;
    }

    // Devuelve el texto: "Student of ..."
    public String getRewardDescription() {
        return "Student of " + getFormattedHouse();
    }
}

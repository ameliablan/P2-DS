package e1;

// Ghost hereda de Resident (y por extensión, de HogwartsMember)
public class Ghost extends Resident {

    // El constructor simplemente pasa los datos a Resident mediante super()
    public Ghost(String firstName, String lastName, int age, int horcruxesDestroyed, House house) {
        super(firstName, lastName, age, horcruxesDestroyed, house);
    }

    // Definir la tarifa específica de los fantasmas
    @Override
    public double getGalleonsPerHorcrux() {
        return 80.0; // 80 galeones por cada horrocrux destruido
    }

    // Define el fantasma formateando el nombre de la asignatura (Ghost of... (house))
    @Override
    public String getRewardDescription() {
        return "Ghost of " + getFormattedHouse();
    }
}
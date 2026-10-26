package e1;

// Ghost hereda de Resident (y por extensión, de HogwartsMember)
public class Ghost extends Resident {

    // El constructor simplemente pasa los datos a la clase padre (Resident) mediante super()
    public Ghost(String firstName, String lastName, int age, int horcruxesDestroyed, House house) {
        super(firstName, lastName, age, horcruxesDestroyed, house);
    }

    // Sobreescribe el método para definir la tarifa específica de los fantasmas
    @Override
    public double getGalleonsPerHorcrux() {
        return 80.0; // 80 galeones por cada horrocrux destruido
    }

    // Sobreescribe la descripción para que indique que es el fantasma de su respectiva casa
    @Override
    public String getRewardDescription() {
        // Usa un método de la clase padre (getFormattedHouse) para construir el texto
        return "Ghost of " + getFormattedHouse();
    }
}
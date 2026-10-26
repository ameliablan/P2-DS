package e1;

public abstract class Resident extends HogwartsMember {
    private final House house;

    public Resident(String firstName, String lastName, int age, int horcruxesDestroyed, House house) {
        super(firstName, lastName, age, horcruxesDestroyed);
        this.house = house;
    }

    public House getHouse() {
        return house;
    }

    @Override
    public double getReward() {
        // Recompensa base fijada por Hogwartsmember
        double baseReward = super.getReward();

        // Si pertenece a Slytherin, la recompensa se duplica
        if (house == House.SLYTHERIN) {
            return baseReward * 2.0;
        }
        return baseReward;
    }

    protected String getFormattedHouse() { // Cambiar formato de los enums HOUSE
        // Mantiene la primera letra en mayúscula y pasa el resto a minúsculas
        return house.name().charAt(0) + house.name().substring(1).toLowerCase();
    }
}

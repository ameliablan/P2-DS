package e1;
// Identificación de los miembros
public abstract class HogwartsMember {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final int horcruxesDestroyed;

    public HogwartsMember(String firstName, String lastName, int age, int horcruxesDestroyed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.horcruxesDestroyed = horcruxesDestroyed;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getHorcruxesDestroyed() {
        return horcruxesDestroyed;
    }

    public abstract double getGalleonsPerHorcrux();

    public double getReward() {
        return getHorcruxesDestroyed() * getGalleonsPerHorcrux();
    }

    public abstract String getRewardDescription();
}

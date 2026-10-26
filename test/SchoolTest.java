package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SchoolTest {
    // Declaramos la variable school a nivel de clase para que todos los tests puedan usarla
    private School school;

    // @BeforeEach le dice a JUnit: "Ejecuta este método antes de cada @Test".
    // Esto asegura que cada prueba comience con una escuela "limpia" y exactamente con estos datos,
    // evitando que un test modifique los datos del siguiente.
    @BeforeEach
    void setUp() {
        school = new School();
        school.addMember(new Student("Hermione", "Granger", 17, 3, House.GRYFFINDOR));
        school.addMember(new Ghost("Bloody", "Baron", 100, 1, House.SLYTHERIN));
        school.addMember(new Gamekeeper("Rubeus", "Hagrid", 60, 2));
        school.addMember(new Teacher("Minerva", "McGonagall", 65, 1, Subject.TRANSFIGURATION));
        school.addMember(new Teacher("Severus", "Snape", 45, 2, Subject.DEFENCE));
        school.addMember(new Caretaker("Argus", "Filch", 60, 0));
    }

    // @Test indica que este método es una prueba automatizada.
    @Test
    void testPrintRewards() {
        // 1. Definimos el resultado EXACTO que esperamos obtener (nuestro modelo a seguir)
        String expectedRewards =
                "Hermione Granger (Student of Gryffindor, 3 horcruxes): 270.0 galleons\n" +
                        "Bloody Baron (Ghost of Slytherin, 1 horcruxes): 160.0 galleons\n" +
                        "Rubeus Hagrid (Gamekeeper, 2 horcruxes): 150.0 galleons\n" +
                        "Minerva McGonagall (Teacher of Transfiguration, 1 horcruxes): 50.0 galleons\n" +
                        "Severus Snape (Teacher of Defence, 2 horcruxes): 75.0 galleons\n" +
                        "Argus Filch (Caretaker, 0 horcruxes): 0.0 galleons\n" +
                        "The total reward for Hogwarts School is 705.0 galleons";

        // 2. Comparamos el resultado esperado con el resultado real generado por nuestro código.
        // Si no son idénticos letra por letra (incluyendo mayúsculas y espacios), el test fallará en rojo.
        assertEquals(expectedRewards, school.printRewards());
    }

    @Test
    void testPrintSalaries() {
        // Al igual que antes, definimos el texto esperado para los salarios.
        String expectedSalaries =
                "Rubeus Hagrid (Gamekeeper): 180 galleons\n" +
                        "Minerva McGonagall (Teacher of Transfiguration): 400 galleons\n" +
                        "Severus Snape (Teacher of Defence): 500 galleons\n" +
                        "Argus Filch (Caretaker): 160 galleons\n" +
                        "The total payroll for Hogwarts School is 1240 galleons";

        // Verificamos que el método printSalaries() devuelva exactamente ese texto.
        assertEquals(expectedSalaries, school.printSalaries());
    }

    // TEST EXTRA para aumentar la cobertura (Coverage)
    @Test
    void testRecompensasIndividuales() {
        // Comprobamos la lógica de un estudiante de una casa normal (Gryffindor)
        // 3 horrocruxes * 90 = 270.0 (No se multiplica por 2 porque no es Slytherin)
        Student hermione = new Student("Hermione", "Granger", 17, 3, House.GRYFFINDOR);
        assertEquals(270.0, hermione.getReward());

        // Comprobamos la lógica del multiplicador x2 de Slytherin
        // 1 horrocrux * 80 (Fantasma) = 80. Como es Slytherin, 80 * 2 = 160.0
        Ghost baron = new Ghost("Bloody", "Baron", 100, 1, House.SLYTHERIN);
        assertEquals(160.0, baron.getReward());

        // Comprobamos que un profesor normal cobra el 100% de la recompensa
        // 1 horrocrux * 50 = 50.0
        Teacher minerva = new Teacher("Minerva", "McGonagall", 65, 1, Subject.TRANSFIGURATION);
        assertEquals(50.0, minerva.getReward());

        // Comprobamos que al profesor de Defensa se le aplica el castigo del 25% menos (cobra el 75%)
        // 2 horrocruxes * 50 = 100. El 75% de 100 es 75.0
        Teacher snape = new Teacher("Severus", "Snape", 45, 2, Subject.DEFENCE);
        assertEquals(75.0, snape.getReward());
    }
}
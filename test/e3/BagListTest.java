package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BagListTest {

    private Bag<Integer> bag;

    @BeforeEach
    void setUp() {
        bag = new BagList<>();
    }

    @Test
    void testAddAndSize() {
        assertTrue(bag.isEmpty());
        bag.add(10);
        bag.add(20);
        assertEquals(2, bag.size());
        assertFalse(bag.isEmpty());
        assertTrue(bag.contains(10));
    }

    @Test
    void testAddAllAndClear() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        bag.addAll(list);
        assertEquals(3, bag.size());
        assertTrue(bag.contains(2));

        bag.clear();
        assertEquals(0, bag.size());
        assertTrue(bag.isEmpty());
    }

    @Test
    void testExtract() {
        bag.add(100);
        bag.add(200);

        // Al extraer, el tamaño debe reducirse y el elemento devuelto no debe ser nulo
        Integer extracted = bag.extract();
        assertNotNull(extracted);
        assertEquals(1, bag.size());

        // Comprobamos que el elemento extraído era uno de los introducidos
        assertTrue(extracted == 100 || extracted == 200);
    }

    // Test extra añadido para comprobar el caso de extraer de una bolsa vacía (eleva el Branch a 100%)
    @Test
    void testExtractEmptyBag() {
        // Como la bolsa está vacía al inicializarla, extract() debe devolver null
        assertNull(bag.extract());
    }

    @Test
    void testEmptyIn() {
        bag.add(1);
        bag.add(2);

        Bag<Integer> newBag = new BagList<>();
        newBag.add(3);

        // Volcamos la primera bolsa en la segunda
        bag.emptyIn(newBag);

        // La bolsa original debe estar vacía
        assertTrue(bag.isEmpty());
        assertEquals(0, bag.size());

        // La nueva bolsa debe contener los elementos de ambas
        assertEquals(3, newBag.size());
        assertTrue(newBag.contains(1));
        assertTrue(newBag.contains(2));
        assertTrue(newBag.contains(3));
    }

    @Test
    void testIterator() {
        bag.add(5);
        Iterator<Integer> it = bag.iterator();
        assertTrue(it.hasNext());
        assertEquals(5, it.next());
    }

    @Test
    void testJavaCollectionsAPIIntegration() {
        // Comprobamos que la colección funciona con métodos de la API estándar de Java
        bag.add(15);
        bag.add(45);
        bag.add(30);

        // Collections.max acepta una Collection genérica y devuelve el valor máximo
        Integer max = Collections.max(bag);
        assertEquals(45, max);
    }
}
package e3;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// La clase BagList implementa la interfaz Bag y hereda de AbstractCollection
// de toArray(), remove(), removeAll()... -> así no nos bajan el porcentaje de cobertura
public class BagList<E> extends AbstractCollection<E> implements Bag<E> {

    // Lista interna para almacenar los elementos de la bolsa
    private final List<E> elements;
    // Objeto para generar números aleatorios al extraer elementos
    private final Random random;

    // Constructor que inicializa la lista y el generador aleatorio
    public BagList() {
        this.elements = new ArrayList<>();
        this.random = new Random();
    }

    // Añade un elemento a la bolsa
    @Override
    public boolean add(E e) {
        return elements.add(e);
    }

    // Añade una colección entera de elementos a la bolsa
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return elements.addAll(c);
    }

    // Vacía por completo la bolsa
    @Override
    public void clear() {
        elements.clear();
    }

    // Comprueba si la bolsa contiene un elemento específico
    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    // Comprueba si la bolsa está vacía
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Devuelve un iterador para recorrer los elementos de la bolsa
    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    // Devuelve el número total de elementos en la bolsa
    @Override
    public int size() {
        return elements.size();
    }

    // Extrae un elemento aleatorio de la bolsa y lo elimina de ella
    @Override
    public E extract() {
        if (elements.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(elements.size());
        return elements.remove(randomIndex);
    }

    // Vuelca todo el contenido de esta bolsa en otra y vacía la actual
    @Override
    public void emptyIn(Bag<? super E> b) {
        if (b != null) {
            b.addAll(this.elements);
            this.clear();
        }
    }
}
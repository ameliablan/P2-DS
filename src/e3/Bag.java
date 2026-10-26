package e3;

import java.util.Collection;

// La interfaz usa el genérico <E> y extiende Collection<E>
public interface Bag<E> extends Collection<E> {

    @Override
    boolean add(E e);

    @Override
    boolean addAll(Collection<? extends E> c);

    @Override
    void clear();

    @Override
    boolean contains(Object o);

    @Override
    boolean isEmpty();

    @Override
    java.util.Iterator<E> iterator();

    @Override
    int size();

    /**
     * Extrae un elemento de la bolsa de forma aleatoria.
     * @return El elemento extraído.
     */
    E extract();

    /**
     * Vuelca el contenido de esta bolsa en la bolsa pasada como argumento.
     * La bolsa actual queda vacía.
     * Uso de <? super E> para aceptar bolsas de tipos genéricos compatibles.
     */
    void emptyIn(Bag<? super E> b);
}
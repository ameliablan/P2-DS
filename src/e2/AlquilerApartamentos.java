package e2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlquilerApartamentos {

    private List<Apartamento> apartamentos;
    private Comparator<Apartamento> comparador;

    public AlquilerApartamentos() {
        apartamentos = new ArrayList<>();
        comparador = null;
    }

    public void agregarApartamento(Apartamento a) {
        apartamentos.add(a);
    }

    public void setComparador(Comparator<Apartamento> c) {
        comparador = c;
    }

    public void ordenar() {
        if (comparador == null) {
            Collections.sort(apartamentos);
        } else {
            Collections.sort(apartamentos, comparador);
        }
    }

    public void mostrarApartamentos() {
        for (Apartamento a : apartamentos) {
            System.out.println(a);
        }
    }
}


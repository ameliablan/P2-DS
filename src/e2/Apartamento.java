package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Apartamento implements Comparable<Apartamento> {

    private int referencia;
    private double precioBase;
    private List<Double> preciosGaraje;  //tipo array con los precios de los garages
    private double superficie;
    private String codigoPostal;

    public Apartamento(int referencia, double precioBase, List<Double> preciosGaraje, double superficie, String codigoPostal) {  //define apartamento con las caracteristicas
        this.referencia = referencia;
        this.precioBase = precioBase;
        this.preciosGaraje = new ArrayList<>(preciosGaraje);
        this.superficie = superficie;
        this.codigoPostal = codigoPostal;
    }

    public int getReferencia() {
        return referencia;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getSuperficie() {
        return superficie;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public double getPrecioTotal() {
        double total = precioBase;

        for (double precio : preciosGaraje) {  //si hay garaje se le añade al precio base
            total = total + precio;
        }

        return total;
    }

    @Override
    public int compareTo(Apartamento a) {
        return Integer.compare(referencia, a.referencia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Apartamento)) {
            return false;
        }

        Apartamento a = (Apartamento) o;

        return Double.compare(precioBase, a.precioBase) == 0 && Double.compare(superficie, a.superficie) == 0 && Objects.equals(preciosGaraje, a.preciosGaraje) && Objects.equals(codigoPostal, a.codigoPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precioBase, preciosGaraje,
                superficie, codigoPostal);
    }

    @Override
    public String toString() {
        return "Referencia: " + referencia
                + ", Precio base: " + precioBase
                + ", Precio total: " + getPrecioTotal()
                + ", Superficie: " + superficie
                + ", Codigo postal: " + codigoPostal;
    }
}

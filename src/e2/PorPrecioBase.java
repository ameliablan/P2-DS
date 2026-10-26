package e2;
import java.util.Comparator;

public class PorPrecioBase implements Comparator <Apartamento> {
    @Override
    public int compare(Apartamento ap1, Apartamento ap2) {
        return Double.compare(ap1.getPrecioBase(), ap2.getPrecioBase());
    }
}

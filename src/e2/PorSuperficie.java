package e2;

import java.util.Comparator;

public class PorSuperficie implements Comparator<Apartamento> {
    @Override
    public int compare(Apartamento ap1, Apartamento ap2) {
        return Double.compare(ap1.getSuperficie(), ap2.getSuperficie());
    }
}

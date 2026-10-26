package e2;

import java.util.Comparator;

public class PorCodigoPostal implements Comparator<Apartamento> {
    @Override
    public int compare(Apartamento ap1, Apartamento ap2) {
        return ap1.getCodigoPostal().compareTo(ap2.getCodigoPostal());
    }
}

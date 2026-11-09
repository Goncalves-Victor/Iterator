package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CadastroTransportadoras implements Iterable<Transportadora> {
    private final List<Transportadora> transportadoras;

    public CadastroTransportadoras(Transportadora... transportadoras) {
        this.transportadoras = Arrays.asList(transportadoras);
    }


    @Override
    public Iterator<Transportadora> iterator() {
        return transportadoras.iterator();
    }
}

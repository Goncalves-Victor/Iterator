package org.example;

import java.util.Iterator;

public class RelatorioTransportadoras {
    public static int contarTransportadorasAtivas(CadastroTransportadoras cadastro) {
        int quantidade = 0;
        for (Transportadora transportadora : cadastro) {
            if (transportadora.isAtiva()) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public static int contarTotalTransportadoras(CadastroTransportadoras cadastro) {
        int quantidade = 0;
        Iterator<Transportadora> iterator = cadastro.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            quantidade++;
        }
        return quantidade;
    }
}

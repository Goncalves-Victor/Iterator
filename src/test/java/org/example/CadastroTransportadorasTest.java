package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CadastroTransportadorasTest {
    @Test
    void devePercorrerTodasNaOrdemDoCadastro() {
        CadastroTransportadoras cadastro = new CadastroTransportadoras(
                new Transportadora("Correios", true),
                new Transportadora("DHL", false),
                new Transportadora("FedEx", true)
        );
        List<String> nomes = new ArrayList<>();
        for (Transportadora transportadora : cadastro) {
            nomes.add(transportadora.getNome());
        }
        assertEquals(List.of("Correios", "DHL", "FedEx"), nomes);
    }

    @Test
    void deveCriarIteradoresIndependentes() {
        Transportadora correios = new Transportadora("Correios", true);
        CadastroTransportadoras cadastro = new CadastroTransportadoras(correios);
        Iterator<Transportadora> primeiro = cadastro.iterator();
        Iterator<Transportadora> segundo = cadastro.iterator();
        assertSame(correios, primeiro.next());
        assertFalse(primeiro.hasNext());
        assertTrue(segundo.hasNext());
        assertSame(correios, segundo.next());
    }

    @Test
    void naoDeveAvancarAoConsultarHasNext() {
        Transportadora correios = new Transportadora("Correios", true);
        Iterator<Transportadora> iterator = new CadastroTransportadoras(correios).iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertSame(correios, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}

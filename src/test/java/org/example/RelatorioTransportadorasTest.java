package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RelatorioTransportadorasTest {
    private CadastroTransportadoras criarCadastro() {
        return new CadastroTransportadoras(
                new Transportadora("Correios", true),
                new Transportadora("DHL", false),
                new Transportadora("FedEx", true)
        );
    }

    @Test
    void deveContarTransportadorasAtivas() {
        assertEquals(2, RelatorioTransportadoras.contarTransportadorasAtivas(criarCadastro()));
    }

    @Test
    void deveContarTotalTransportadoras() {
        assertEquals(3, RelatorioTransportadoras.contarTotalTransportadoras(criarCadastro()));
    }

    @Test
    void deveContarZeroEmCadastroVazio() {
        CadastroTransportadoras cadastro = new CadastroTransportadoras();
        assertEquals(0, RelatorioTransportadoras.contarTotalTransportadoras(cadastro));
        assertEquals(0, RelatorioTransportadoras.contarTransportadorasAtivas(cadastro));
    }

    @Test
    void deveContarZeroQuandoTodasEstaoInativas() {
        CadastroTransportadoras cadastro = new CadastroTransportadoras(
                new Transportadora("Correios", false),
                new Transportadora("DHL", false)
        );
        assertEquals(0, RelatorioTransportadoras.contarTransportadorasAtivas(cadastro));
        assertEquals(2, RelatorioTransportadoras.contarTotalTransportadoras(cadastro));
    }

    @Test
    void deveConsiderarAlteracaoDeAtividade() {
        Transportadora dhl = new Transportadora("DHL", false);
        CadastroTransportadoras cadastro = new CadastroTransportadoras(dhl);
        assertEquals(0, RelatorioTransportadoras.contarTransportadorasAtivas(cadastro));
        dhl.setAtiva(true);
        assertEquals(1, RelatorioTransportadoras.contarTransportadorasAtivas(cadastro));
    }
}

package org.example;

public class Transportadora {
    private String nome;
    private boolean ativa;

    public Transportadora(String nome, boolean ativa) {
        this.nome = nome;
        this.ativa = ativa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}

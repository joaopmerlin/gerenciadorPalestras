package br.com.joaopaulomerlin.gerenciadorpalestras;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoTempo {

    MINUTES(1, "min"),
    LIGHTNING(5, "lightning");

    private Integer tempo;
    private String tipo;

    @Override
    public String toString() {
        return tipo;
    }
}

package br.com.joaopaulomerlin.gerenciadorpalestras;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Palestra implements Serializable {

    private String nome;

    private Integer tempo;

    private TipoTempo tipoTempo;

    public Integer getTempo() {
        return tipoTempo.getTempo() * tempo;
    }

    @Override
    public String toString() {
        return nome + " - " + tempo + " " + tipoTempo;
    }
}

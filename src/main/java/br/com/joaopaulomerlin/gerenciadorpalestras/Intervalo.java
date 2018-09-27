package br.com.joaopaulomerlin.gerenciadorpalestras;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Intervalo implements Serializable {

    private List<Palestra> palestras;

    private Integer duracaoRestante;

    private Integer horaInicio;

    private Intervalo intervaloNetworking;

    public Intervalo(int duracao, int horaInicio) {
        this.duracaoRestante = duracao;
        this.horaInicio = horaInicio;
    }

    public void addPalestra(Palestra palestra) {
        if (duracaoRestante < palestra.getTempo()) {
            throw new RuntimeException();
        }

        if (palestras == null) {
            palestras = new ArrayList<>();
        }

        palestras.add(palestra);
        duracaoRestante -= palestra.getTempo();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Integer proximaPalestraHora = toStringPalestras(palestras, horaInicio, str);

        if (intervaloNetworking != null) {
            Integer complementoHora = intervaloNetworking.getHoraInicio();

            if (proximaPalestraHora > intervaloNetworking.getHoraInicio()) {
                complementoHora = proximaPalestraHora;
            }

            toStringPalestras(intervaloNetworking.getPalestras(), complementoHora, str);
        }
        return str.toString();
    }

    private int toStringPalestras(List<Palestra> palestras, Integer horaInicio, StringBuilder str) {
        Integer proximaPalestraHora = horaInicio;

        for (Palestra palestra : palestras) {
            str.append(Util.formatHora(proximaPalestraHora))
                    .append(" ")
                    .append(palestra)
                    .append("\n");

            proximaPalestraHora += palestra.getTempo();
        }

        return proximaPalestraHora;
    }

}

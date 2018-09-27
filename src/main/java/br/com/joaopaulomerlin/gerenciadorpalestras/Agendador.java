package br.com.joaopaulomerlin.gerenciadorpalestras;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agendador {

    public Conferencia agenda(BufferedReader input) throws IOException {
        List<Palestra> palestras = new ArrayList<>();

        for (String linha; (linha = input.readLine()) != null; ) {
            linha = linha.trim();
            Palestra palestra = parsePalestra(linha);
            if (palestra == null) {
                continue;
            }

            palestras.add(palestra);
        }

        Conferencia conferencia = new Conferencia();

        while (palestras.size() != 0) {
            Intervalo intervaloManha = new Intervalo(180, 9 * 60);
            organizarPalestras(intervaloManha, palestras);

            Palestra almoco = new Palestra("Almoço", 60, TipoTempo.MINUTES);
            Intervalo intervaloAlmoco = new Intervalo(60, 12 * 60);
            intervaloAlmoco.addPalestra(almoco);

            Intervalo intervaloTarde = new Intervalo(240, 13 * 60);
            organizarPalestras(intervaloTarde, palestras);

            Palestra networking = new Palestra("Networking", 60, TipoTempo.MINUTES);
            Intervalo intervaloNetworking = new Intervalo(networking.getTempo(), (12 * 60) + (4 * 60));
            intervaloNetworking.addPalestra(networking);

            intervaloTarde.setIntervaloNetworking(intervaloNetworking);

            Trilha trilha = new Trilha();
            trilha.addIntervalo(intervaloManha);
            trilha.addIntervalo(intervaloAlmoco);
            trilha.addIntervalo(intervaloTarde);

            conferencia.addTrilha(trilha);
        }

        return conferencia;
    }

    private static void organizarPalestras(Intervalo intervalo, List<Palestra> palestras) {
        for (Iterator<Palestra> iter = palestras.iterator(); iter.hasNext(); ) {
            Palestra palestra = iter.next();
            if (intervalo.getDuracaoRestante() >= palestra.getTempo()) {
                intervalo.addPalestra(palestra);
                iter.remove();
            }
        }
    }

    private Palestra parsePalestra(String linha) {
        if (linha.length() == 0) {
            return null;
        }

        Pattern pattern = Pattern.compile("^(.+)\\s(\\d+)?\\s?((min)|(lightning))$");
        Matcher match = pattern.matcher(linha);
        if (!match.find()) {
            System.out.println("Erro na linha: " + linha);
            return null;
        }

        TipoTempo tipoTempo;
        if (match.group(3).equalsIgnoreCase("min")) {
            tipoTempo = TipoTempo.MINUTES;
        } else {
            tipoTempo = TipoTempo.LIGHTNING;
        }

        String nome = match.group(1);
        String tempoString = match.group(2);
        if (tempoString == null) {
            tempoString = "1";
        }

        Integer tempo = Integer.parseInt(tempoString);

        return new Palestra(nome, tempo, tipoTempo);
    }

}

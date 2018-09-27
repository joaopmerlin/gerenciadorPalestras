package br.com.joaopaulomerlin.gerenciadorpalestras;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try {
            InputStream inputStream = Main.class.getResourceAsStream("/input.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Conferencia conferencia = new Agendador().agenda(reader);

            System.out.println(conferencia);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package br.com.joaopaulomerlin.gerenciadorpalestras;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Conferencia implements Serializable {

    private List<Trilha> trilhas;

    public void addTrilha(Trilha trilha) {
        if (trilhas == null) {
            trilhas = new ArrayList<>();
        }

        trilhas.add(trilha);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Conferência\n\n");

        for (int i = 0; i < trilhas.size(); i++) {
            str.append("Trilha ")
                    .append(i + 1)
                    .append(":\n")
                    .append(trilhas.get(i))
                    .append("\n");
        }

        return str.toString();
    }

}

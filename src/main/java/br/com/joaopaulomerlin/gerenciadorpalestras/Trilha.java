package br.com.joaopaulomerlin.gerenciadorpalestras;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trilha implements Serializable {

    private List<Intervalo> intervalos;

    public void addIntervalo(Intervalo intervalo) {
        if (intervalos == null) {
            intervalos = new ArrayList<>();
        }

        intervalos.add(intervalo);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        intervalos.forEach(str::append);
        return str.toString();
    }

}

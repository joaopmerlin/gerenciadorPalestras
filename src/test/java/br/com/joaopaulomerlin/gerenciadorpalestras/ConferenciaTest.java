package br.com.joaopaulomerlin.gerenciadorpalestras;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ConferenciaTest {

    @Test
    public void test() throws IOException {
        Conferencia conferencia = new Agendador().agenda(FileUtil.getBufferedReaderForResourceFile("/input.txt", this));
        System.out.println(conferencia);
        assertTrue(FileUtil.contentEquals("/inputTest.txt", conferencia.toString(), this));
    }

}

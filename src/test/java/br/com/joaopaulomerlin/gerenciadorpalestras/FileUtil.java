package br.com.joaopaulomerlin.gerenciadorpalestras;

import java.io.*;

public class FileUtil {

    public static BufferedReader getBufferedReaderForResourceFile(String resourceFile, Object context) {
        InputStream inputStream = context.getClass().getResourceAsStream(resourceFile);
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public static boolean contentEquals(String resourceFile, String string, Object context) throws IOException {
        BufferedReader fileReader = getBufferedReaderForResourceFile(resourceFile, context);
        BufferedReader stringReader = new BufferedReader(new StringReader(string));
        while (true) {
            String fileLine = getNextLine(fileReader);
            String stringLine = getNextLine(stringReader);
            if (fileLine == null && stringLine == null) {
                break;
            }

            if (fileLine == null || stringLine == null) {
                return false;
            }

            if (!fileLine.equals(stringLine)) {
                return false;
            }
        }
        return true;
    }

    private static String getNextLine(BufferedReader reader) throws IOException {
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                return null;
            }

            if (line.trim().length() != 0) {
                return line;
            }
        }
    }
}

package br.com.joaopaulomerlin.gerenciadorpalestras;

public class Util {

    public static String formatHora(int minutes) {
        int hours = minutes / 60;
        String hoursToDisplay = Integer.toString(hours);
        if (hours > 12) {
            hoursToDisplay = Integer.toString(hours - 12);
        }
        if (hoursToDisplay.length() == 1) {
            hoursToDisplay = "0" + hoursToDisplay;
        }

        minutes = minutes - (hours * 60);
        String minutesToDisplay;
        if (minutes == 0) {
            minutesToDisplay = "00";
        } else if (minutes < 10) {
            minutesToDisplay = "0" + minutes;
        } else {
            minutesToDisplay = "" + minutes;
        }

        String displayValue;
        if (hours < 12) {
            displayValue = " AM";
            if (hoursToDisplay.equals("00")) {
                hoursToDisplay = "12";
            }
        } else {
            displayValue = " PM";
        }
        displayValue = hoursToDisplay + ":" + minutesToDisplay + displayValue;

        return displayValue;
    }

}

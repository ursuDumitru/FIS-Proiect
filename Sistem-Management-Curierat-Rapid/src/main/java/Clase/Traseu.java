package Clase;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Traseu {
    private int idTraseu;
    private int idRuta;
    private int distanta;
    private String oraPlecare;
    private String oraSosire;

    public void setOraPlecare(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalTime parsedTime = LocalTime.parse(time, formatter);
            this.oraPlecare = parsedTime.toString();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid time format. Please enter time in HH:MM format.");
        }
    }

    public void setOraSosire(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalTime parsedTime = LocalTime.parse(time, formatter);
            this.oraSosire = parsedTime.toString();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid time format. Please enter time in HH:MM format.");
        }
    }
}

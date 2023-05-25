package Clase;

public class Sofer {
    private int idSofer;
    private String numeSofer;
    private String pozitieActuala;
    private String oraActualizare;

    public Sofer() {}

    public Sofer(int idSofer, String numeSofer, String pozitieActuala, String oraActualizare) {
        this.idSofer = idSofer;
        this.numeSofer = numeSofer;
        this.pozitieActuala = pozitieActuala;
        this.oraActualizare = oraActualizare;
    }

    public int getIdSofer() {
        return idSofer;
    }

    public void setIdSofer(int idSofer) {
        this.idSofer = idSofer;
    }

    public String getNumeSofer() {
        return numeSofer;
    }

    public void setNumeSofer(String numeSofer) {
        this.numeSofer = numeSofer;
    }

    public String getPozitieActuala() {
        return pozitieActuala;
    }

    public void setPozitieActuala(String pozitieActuala) {
        this.pozitieActuala = pozitieActuala;
    }

    public String getOraActualizare() {
        return oraActualizare;
    }

    public void setOraActualizare(String oraActualizare) {
        this.oraActualizare = oraActualizare;
    }

    @Override
    public String toString() {
        return "Sofer{" +
                "idSofer=" + idSofer +
                ", numeSofer='" + numeSofer + '\'' +
                ", pozitieActuala='" + pozitieActuala + '\'' +
                ", oraActualizare='" + oraActualizare + '\'' +
                '}';
    }
    public enum Status {
        Asteptare,
        Drum,
        Ajuns
    }
}

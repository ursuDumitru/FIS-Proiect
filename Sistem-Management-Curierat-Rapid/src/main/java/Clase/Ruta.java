package Clase;

public class Ruta {
    private int idRuta;
    private String orasPlecare;
    private String orasDestinatie;
    private TipColet tipTransport;

    public Ruta() {}

    public Ruta(int idRuta, String orasPlecare, String orasDestinatie, TipColet tipTransport) {
        this.idRuta = idRuta;
        this.orasPlecare = orasPlecare;
        this.orasDestinatie = orasDestinatie;
        this.tipTransport = tipTransport;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getOrasPlecare() {
        return orasPlecare;
    }

    public void setOrasPlecare(String orasPlecare) {
        this.orasPlecare = orasPlecare;
    }

    public String getOrasDestinatie() {
        return orasDestinatie;
    }

    public void setOrasDestinatie(String orasDestinatie) {
        this.orasDestinatie = orasDestinatie;
    }

    public TipColet getTipTransport() {
        return tipTransport;
    }

    public void setTipTransport(TipColet tipTransport) {
        this.tipTransport = tipTransport;
    }

    public enum TipColet {
        FRAGIL,
        PRETIOS,
        PERICULOS
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "idRuta=" + idRuta +
                ", orasPlecare='" + orasPlecare + '\'' +
                ", orasDestinatie='" + orasDestinatie + '\'' +
                ", tipTransport=" + tipTransport +
                '}';
    }
}

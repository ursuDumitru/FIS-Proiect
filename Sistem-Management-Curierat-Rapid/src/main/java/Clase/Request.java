package Clase;

public class Request {

    int idClient;
    int idRuta;
    String numeExpediator;
    String prenumeExpediator;
    String cnpExpediator;
    String orasExpediere;
    String numeDestinatar;
    String prenumeDestinatar;
    String cnpDestinatar;
    String orasDestinatie;
    Ruta tipColet;
    double greutateColet;
    String status;

    public Request() {
    }

    public Request(int idClient, int idRuta, String numeExpediator, String prenumeExpediator, String cnpExpediator, String orasExpediere, String numeDestinatar, String prenumeDestinatar, String cnpDestinatar, String orasDestinatie, Ruta tipColet, double greutateColet, String status) {
        this.idClient = idClient;
        this.idRuta = idRuta;
        this.numeExpediator = numeExpediator;
        this.prenumeExpediator = prenumeExpediator;
        this.cnpExpediator = cnpExpediator;
        this.orasExpediere = orasExpediere;
        this.numeDestinatar = numeDestinatar;
        this.prenumeDestinatar = prenumeDestinatar;
        this.cnpDestinatar = cnpDestinatar;
        this.orasDestinatie = orasDestinatie;
        this.tipColet = tipColet;
        this.greutateColet = greutateColet;
        this.status = status;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getNumeExpediator() {
        return numeExpediator;
    }

    public void setNumeExpediator(String numeExpediator) {
        this.numeExpediator = numeExpediator;
    }

    public String getPrenumeExpediator() {
        return prenumeExpediator;
    }

    public void setPrenumeExpediator(String prenumeExpediator) {
        this.prenumeExpediator = prenumeExpediator;
    }

    public String getCnpExpediator() {
        return cnpExpediator;
    }

    public void setCnpExpediator(String cnpExpediator) {
        this.cnpExpediator = cnpExpediator;
    }

    public String getOrasExpediere() {
        return orasExpediere;
    }

    public void setOrasExpediere(String orasExpediere) {
        this.orasExpediere = orasExpediere;
    }

    public String getNumeDestinatar() {
        return numeDestinatar;
    }

    public void setNumeDestinatar(String numeDestinatar) {
        this.numeDestinatar = numeDestinatar;
    }

    public String getPrenumeDestinatar() {
        return prenumeDestinatar;
    }

    public void setPrenumeDestinatar(String prenumeDestinatar) {
        this.prenumeDestinatar = prenumeDestinatar;
    }

    public String getCnpDestinatar() {
        return cnpDestinatar;
    }

    public void setCnpDestinatar(String cnpDestinatar) {
        this.cnpDestinatar = cnpDestinatar;
    }

    public String getOrasDestinatie() {
        return orasDestinatie;
    }

    public void setOrasDestinatie(String orasDestinatie) {
        this.orasDestinatie = orasDestinatie;
    }

    public Ruta getTipColet() {
        return tipColet;
    }

    public void setTipColet(Ruta tipColet) {
        this.tipColet = tipColet;
    }

    public double getGreutateColet() {
        return greutateColet;
    }

    public void setGreutateColet(double greutateColet) {
        this.greutateColet = greutateColet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request{" +
                "idClient=" + idClient +
                ", idRuta=" + idRuta +
                ", numeExpediator='" + numeExpediator + '\'' +
                ", prenumeExpediator='" + prenumeExpediator + '\'' +
                ", cnpExpediator='" + cnpExpediator + '\'' +
                ", orasExpediere='" + orasExpediere + '\'' +
                ", numeDestinatar='" + numeDestinatar + '\'' +
                ", prenumeDestinatar='" + prenumeDestinatar + '\'' +
                ", cnpDestinatar='" + cnpDestinatar + '\'' +
                ", orasDestinatie='" + orasDestinatie + '\'' +
                ", tipColet=" + tipColet +
                ", greutateColet=" + greutateColet +
                ", status='" + status + '\'' +
                '}';
    }
}

package MainApp;

public class FormularClient {
    /*
        Un client se prezintă la un sediu al firmei având pachetul pe care dorește sa-l trimită
        și completează un formular în care sunt trecute datele lui de contact, orașul de destinație
        și datele de contact ale destinatarului. La cestea funcționarul mai adaugă greutatea
        coletului, dacă coletul face parte din una din următoarele categorii speciale:
        fragil/prețios/periculos. Pentru coletele prețioase și pentru cele periculoase se va face
        transportul doar dacă se găsesc condiții corespunzătoare de transport
    */

    String numeExpediator;
    String prenumeExpediator;
    String cnpExpediator;
    Oras orasExpediere;

    String numeDestinatar;
    String prenumeDestinatar;
    String cnpDestinatar;
    Oras orasDestinatie;

    TipColet tipColet;
    double greutateColet;

    public FormularClient() {}

    public FormularClient(String numeExpediator, String prenumeExpediator,
                          String cnpExpediator, Oras orasExpediere,
                          String numeDestinatar, String prenumeDestinatar,
                          String cnpDestinatar, Oras orasDestinatie,
                          TipColet tipColet, double greutateColet) {
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

    public Oras getOrasExpediere() {
        return orasExpediere;
    }

    public void setOrasExpediere(Oras orasExpediere) {
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

    public Oras getOrasDestinatie() {
        return orasDestinatie;
    }

    public void setOrasDestinatie(Oras orasDestinatie) {
        this.orasDestinatie = orasDestinatie;
    }

    public TipColet getTipColet() {
        return tipColet;
    }

    public void setTipColet(TipColet tipColet) {
        this.tipColet = tipColet;
    }

    public double getGreutateColet() {
        return greutateColet;
    }

    public void setGreutateColet(double greutateColet) {
        this.greutateColet = greutateColet;
    }

    public enum TipColet {
        FRAGIL,
        PRETIOS,
        PERICULOS
    }
}

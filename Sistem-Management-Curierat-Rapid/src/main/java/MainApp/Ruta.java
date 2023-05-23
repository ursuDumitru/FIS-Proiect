package MainApp;

import java.util.List;

public class Ruta {
    Oras oras1;
    Oras oras2;
    Double distanta;
    List<Transport> transporturiDisponibile;
//    ORAR ???????????????????????


    public Ruta() {}

    public Ruta(Oras oras1, Oras oras2, Double distanta,
                List<Transport> transporturiDisponibile) {
        this.oras1 = oras1;
        this.oras2 = oras2;
        this.distanta = calculateDistance();
        this.transporturiDisponibile = transporturiDisponibile;
    }

    public Oras getOras1() {
        return oras1;
    }

    public void setOras1(Oras oras1) {
        this.oras1 = oras1;
    }

    public Oras getOras2() {
        return oras2;
    }

    public void setOras2(Oras oras2) {
        this.oras2 = oras2;
    }

    public Double getDistanta() {
        return distanta;
    }

    public void setDistanta(Double distanta) {
        this.distanta = distanta;
    }

    public double calculateDistance() {
        double deltaX = oras1.coordinate.getX() - oras2.coordinate.getX();
        double deltaY = oras1.coordinate.getY() - oras2.coordinate.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}

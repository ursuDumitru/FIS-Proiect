package MainApp;

public class Oras {
    String denumire;
    Coordinate coordinate;

    public Oras() {}

    public Oras(String denumire, Coordinate coordinate) {
        this.denumire = denumire;
        this.coordinate = coordinate;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}

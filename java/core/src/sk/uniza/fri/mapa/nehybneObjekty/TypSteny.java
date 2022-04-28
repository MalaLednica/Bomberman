package sk.uniza.fri.mapa.nehybneObjekty;

public enum TypSteny {
    OHRANICENIE("stena3.png"),
    NEZNICITELNA("stena2.png"),
    OBYCAJNA("stena1.png");



    private final String nazovSuboru;

    TypSteny(String nazovSuboru) {
        this.nazovSuboru = nazovSuboru;
    }
    public String getNazovSuboru() {
        return nazovSuboru;
    }
}

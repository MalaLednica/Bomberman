package sk.uniza.fri;


public enum Smer {
    HORE(0, 1),
    DOLE(0, -1),
    DOLAVA(-1, 0),
    DOPRAVA(1, 0);
    private final int x;
    private final int y;

    Smer(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return this.x;
    }

    public int getY() {

        return this.y;
    }

    public Smer getOpacnySmer(Smer smer) {
        switch (smer) {
            case HORE:
                return DOLE;
            case DOLE:
                return HORE;
            case DOLAVA:
                return DOPRAVA;
            case DOPRAVA:
                return DOLAVA;

        }
        return null;



    }
}


package sk.uniza.fri.mapa.nehybneObjekty.steny;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.mapa.ObjektNaMape;

public class Stena extends ObjektNaMape {
    private TypSteny typSteny;

    public Stena(int x, int y, SpriteBatch batch, TypSteny typSteny) {
        super(x, y, typSteny.getNazovSuboru(), batch);
        this.typSteny = typSteny;
    }

    public TypSteny getTypSteny() {
        return this.typSteny;
    }
}

package sk.uniza.fri.mapa.nehybneObjekty.bomby;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.mapa.ObjektNaMape;

public class Bomba extends ObjektNaMape {
    private int cas;
    private final int dosah;

    public Bomba(int x, int y, SpriteBatch batch, int dosah) {
        super(x, y, "bomba.png", batch);
        this.cas = 0;
        this.dosah = dosah;
    }

    public int getCas() {
        return this.cas;
    }

    public void pridajCas() {
        this.cas++;
    }

    public int getDosah() {
        return this.dosah;
    }
}

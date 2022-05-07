package sk.uniza.fri.mapa.nehybneObjekty.bomby;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.mapa.ObjektNaMape;

public class Vybuch extends ObjektNaMape {
    private int cas;
    public Vybuch(int x, int y, SpriteBatch batch) {
        super(x, y, "vybuch.png", batch);
        this.cas = 0;
    }

    public int getCas() {
        return this.cas;
    }

    public void pridajCas() {
        this.cas++;
    }
}

package sk.uniza.fri.mapa.nehybneObjekty.upgrades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.hra.Hrac;
import sk.uniza.fri.mapa.ObjektNaMape;

public abstract class Upgrade extends ObjektNaMape {
    public Upgrade(int x, int y, String nazovSuboru, SpriteBatch batch) {
        super(x, y, nazovSuboru, batch);
    }

    public abstract void zober(Hrac hrac);
}

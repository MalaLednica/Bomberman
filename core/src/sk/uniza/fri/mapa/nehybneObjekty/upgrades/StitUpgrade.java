package sk.uniza.fri.mapa.nehybneObjekty.upgrades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.hra.Hrac;

public class StitUpgrade extends Upgrade {
    public StitUpgrade(int x, int y, SpriteBatch batch) {
        super(x, y, "stit.png", batch);
    }


    public void zober(Hrac hrac) {
        hrac.nastavStit(true);

    }
}

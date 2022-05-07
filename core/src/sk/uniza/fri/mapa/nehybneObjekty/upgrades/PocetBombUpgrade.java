package sk.uniza.fri.mapa.nehybneObjekty.upgrades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.hra.Hrac;

public class PocetBombUpgrade extends Upgrade {
    public PocetBombUpgrade(int x, int y, SpriteBatch batch) {
        super(x, y, "pocet.png", batch);
    }


    public void zober(Hrac hrac) {
        hrac.pridajPocetBomb();

    }
}

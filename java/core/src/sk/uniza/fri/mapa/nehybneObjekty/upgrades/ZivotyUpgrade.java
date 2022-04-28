package sk.uniza.fri.mapa.nehybneObjekty.upgrades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.hra.Hrac;

public class ZivotyUpgrade extends Upgrade {
    public ZivotyUpgrade(int x, int y, SpriteBatch batch) {
        super(x, y, "zivoty.png", batch);
    }


    public void zober(Hrac hrac) {
        hrac.pridajZivot();

    }
}

package sk.uniza.fri.mapa.nehybneObjekty.upgrades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.hra.Hrac;

public class DosahBombyUpgrade extends Upgrade {
    public DosahBombyUpgrade(int x, int y, SpriteBatch batch) {
        super(x, y, "dosah.png", batch);
    }


    public void zober(Hrac hrac) {
        hrac.pridajDosah();

    }
}

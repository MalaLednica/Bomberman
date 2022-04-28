package sk.uniza.fri.mapa.nehybneObjekty;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.mapa.ObjektNaMape;

public class Stena extends ObjektNaMape {
    public Stena(int x, int y, SpriteBatch batch, TypSteny typSteny) {
        super(x, y, typSteny.getNazovSuboru(), batch);
    }
    //TODO znicenie steny
    //TODO sanca po zničení vytvoriť upgrade
}

package sk.uniza.fri.mapa.ziveObjekty;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import sk.uniza.fri.Smer;
import sk.uniza.fri.mapa.ObjektNaMape;
import sk.uniza.fri.mapa.nehybneObjekty.steny.ManazerStien;


public abstract class Postava extends ObjektNaMape {


    private float rychlost;

    public Postava(int x, int y, String nazovSuboru, SpriteBatch batch, float rychlost) {
        super(x, y, nazovSuboru, batch);
        this.rychlost = rychlost;


    }

    public void pohniSa(Smer smer) {

        this.setX(this.getX() + smer.getX() * this.rychlost);
        this.setY(this.getY() + smer.getY() * this.rychlost);



    }

    public boolean mozemSaPohnut(Smer smer, ManazerStien manazerStien) {
        Rectangle pomocny = this.getOblastNaMape();
        pomocny.x += smer.getX() * this.rychlost;
        pomocny.y += smer.getY() * this.rychlost;


        if (!manazerStien.kontrolaKolizie(pomocny)) {
            return true;
        }
        return false;

    }


}

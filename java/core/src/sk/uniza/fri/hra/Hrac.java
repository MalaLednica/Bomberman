package sk.uniza.fri.hra;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.Smer;
import sk.uniza.fri.mapa.nehybneObjekty.ManazerStien;
import sk.uniza.fri.mapa.ziveObjekty.Bomberman;

public class Hrac {

    private final SpriteBatch batch;
    private Bomberman bomberman;

    public Hrac(SpriteBatch batch) {
        this.batch = batch;
        this.bomberman = new Bomberman(10, 10, this.batch);

    }

    public boolean pohyb(Smer smer, ManazerStien manazerStien) {
        if(this.bomberman.mozemSaPohnut(smer, manazerStien)) {
            this.bomberman.pohniSa(smer);
        }

        return true;
    }


    public void vykresli() {
        this.bomberman.vykresliSa();
    }
}

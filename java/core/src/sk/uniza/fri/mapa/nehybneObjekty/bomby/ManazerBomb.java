package sk.uniza.fri.mapa.nehybneObjekty.bomby;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import sk.uniza.fri.hra.Hrac;
import sk.uniza.fri.mapa.Mapa;

import java.util.ArrayList;

public class ManazerBomb {

    private ArrayList<Vybuch> vybuchy;
    private ArrayList<Bomba> bomby;
    private SpriteBatch batch;

    public ManazerBomb(SpriteBatch batch) {
        this.bomby = new ArrayList<>();
        this.vybuchy = new ArrayList<>();
        this.batch = batch;
    }


    public void pridajBombu(int x, int y, int dosah) {
        this.bomby.add(new Bomba(x, y, this.batch, dosah));

    }


    public boolean kontrolaKolizie(Rectangle objekt) {
        for (Bomba bomba : this.bomby) {
            if (bomba.getOblastNaMape().overlaps(objekt)) {

                return true;
            }
        }


        return false;
    }


    public void vykresliVsetko() {

        for (Bomba bomba : this.bomby) {
            bomba.vykresliSa();
            bomba.pridajCas();

        }
        for (Vybuch vybuch : this.vybuchy) {
            vybuch.vykresliSa();
            vybuch.pridajCas();

        }

    }

    public void pridajVybuch(int x, int y) {
        this.vybuchy.add(new Vybuch(x, y, this.batch));
    }

    public void kontrolaVyprsaniaCasov(Mapa mapa, Hrac hrac) {
        int i = 0;
        while (i < this.vybuchy.size()) {
            if (this.vybuchy.get(i).getCas() == 100) {
                this.vybuchy.remove(i);
            } else {
                i++;
            }


        }
        i = 0;
        while (i < this.bomby.size()) {
            if (this.bomby.get(i).getCas() == 100) {

                mapa.vybuchBomby(this.bomby.get(i).getX() / 64, this.bomby.get(i).getY() / 64, this.bomby.get(i).getDosah());
                hrac.odoberPocetPolozenychBomb();
                this.bomby.remove(i);



            } else {
                i++;
            }


        }


    }
}




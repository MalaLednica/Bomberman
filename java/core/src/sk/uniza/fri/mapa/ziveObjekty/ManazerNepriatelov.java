package sk.uniza.fri.mapa.ziveObjekty;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import sk.uniza.fri.hra.obrazovky.BombermanObrazovka;
import sk.uniza.fri.mapa.nehybneObjekty.steny.ManazerStien;

import java.util.ArrayList;
import java.util.Random;


public class ManazerNepriatelov {
    private ArrayList<Nepriatel> nepriatelia;
    private SpriteBatch batch;

    public ManazerNepriatelov(SpriteBatch batch) {
        this.batch = batch;
        this.nepriatelia = new ArrayList<>();
    }


    public void pridajNepriatela(int x, int y) {
        this.nepriatelia.add(new Nepriatel(x, y, this.batch));

    }

    public boolean kontrolaKolizie(Rectangle objekt) {

        for (Nepriatel nepriatel : this.nepriatelia) {
            if (nepriatel.getOblastNaMape().overlaps(objekt)) {
                return true;
            }
        }


        return false;
    }

    public void vykresliVsetko() {
        for (Nepriatel nepriatel : this.nepriatelia) {
            nepriatel.vykresliSa();

        }

    }

    public void pohniVsetko(ManazerStien manazerStien) {

        for (Nepriatel nepriatel : this.nepriatelia) {
            nepriatel.hlupyPohyb2(manazerStien);

        }
    }


    public void pridajNahodne(int kolko) {
        Random rnd = new Random();
        for (int i = 0; i < kolko; i++) {
            int a = rnd.nextInt((BombermanObrazovka.SIRKA_PLOCHY / 64) - 2) + 1;
            int b = rnd.nextInt((BombermanObrazovka.VYSKA_PLOCHY / 64) - 2) + 1;
            if (a % 2 == 0 && b % 2 == 0) {
                a--;
            }

            this.nepriatelia.add(new Nepriatel(a, b, this.batch));
        }


    }


}

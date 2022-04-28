package sk.uniza.fri.mapa.nehybneObjekty;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;


public class ManazerStien {
    private Stena[][] steny;
    private SpriteBatch batch;

    public ManazerStien(SpriteBatch batch, int sirka, int vyska) {
        this.batch = batch;
        this.steny = new Stena[sirka][vyska];
    }

    public boolean pridajStenu(Stena stena, int x, int y) {
        if (this.steny[x][y] != null) {
            return false;
        }
        this.steny[x][y] = stena;
        return true;
    }

    public boolean kontrolaKolizie(Rectangle objekt) {

        for (int i = 0; i < this.steny.length; i++) {
            for (int j = 0; j < this.steny[0].length; j++) {
                if (this.steny[i][j] != null) {
                    if (this.steny[i][j].getOblastNaMape().overlaps(objekt)) {
                        return true;
                    }
                }
            }
        }


        return false;
    }

    public void vykresliVsetko() {
        for (int i = 0; i < this.steny.length; i++) {
            for (int j = 0; j < this.steny[0].length; j++) {
                if (this.steny[i][j] != null) {
                    this.steny[i][j].vykresliSa();
                }
            }
        }
    }

    public void vytvorOkraje() {
        for (int i = 0; i < this.steny.length; i++) {
            for (int j = 0; j < this.steny[0].length; j++) {
                if (i == 0 || i == this.steny.length - 1 || j == 0 || j == this.steny[0].length - 1) {
                    this.steny[i][j] = new Stena(i, j, this.batch, TypSteny.OHRANICENIE);
                }
            }
        }


    }

    public void vytvorStredoveSteny() {
        for (int i = 2; i < this.steny.length-2; i++) {
            for (int j = 2; j < this.steny[0].length-2; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    this.steny[i][j] = new Stena(i, j, this.batch, TypSteny.NEZNICITELNA);
                }
            }
        }
    }


    // TODO vymyslieť lepšie generovanie
    public void pridajNahodne(int kolko) {
        Random rnd = new Random();
        for (int i = 0; i < kolko; i++) {
            int a = rnd.nextInt(this.steny.length - 2) + 1;
            int b = rnd.nextInt(this.steny[0].length - 2 ) + 1;
            while(a % 2 == 0 && b % 2 == 0) {
                a = rnd.nextInt(this.steny.length - 2) + 1;
                b = rnd.nextInt(this.steny[0].length - 2 ) + 1;
            }

            this.steny[a][b] = new Stena(a, b, this.batch, TypSteny.OBYCAJNA);
        }


    }


}

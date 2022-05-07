package sk.uniza.fri.mapa.ziveObjekty;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.Smer;
import sk.uniza.fri.mapa.nehybneObjekty.steny.ManazerStien;

import java.util.Random;

public class Nepriatel extends Postava {
    private Smer aktualnySmer;

    public Nepriatel(int x, int y, SpriteBatch batch) {
        super(x, y, "nepriatel1.png", batch, 2);
        Random rnd = new Random();
        switch (rnd.nextInt(2)) {
            case 0:
                this.aktualnySmer = Smer.DOLE;
                break;
            case 1:
                this.aktualnySmer = Smer.DOLAVA;

        }

    }

    public void hlupyPohyb(ManazerStien manazerStien) {
        if (this.mozemSaPohnut(this.aktualnySmer, manazerStien)) {
            this.pohniSa(this.aktualnySmer);
        } else {
            this.aktualnySmer = this.aktualnySmer.getOpacnySmer(this.aktualnySmer);

        }
    }

    public void hlupyPohyb2(ManazerStien manazerStien) {
        if (this.mozemSaPohnut(this.aktualnySmer, manazerStien)) {
            this.pohniSa(this.aktualnySmer);
        } else {
            Random rnd = new Random();
            switch (rnd.nextInt(4)) {
                case 0:
                    this.aktualnySmer = Smer.DOLAVA;
                    break;
                case 1:
                    this.aktualnySmer = Smer.HORE;
                    break;
                case 2:
                    this.aktualnySmer = Smer.DOPRAVA;
                    break;
                case 3:
                    this.aktualnySmer = Smer.DOLE;
                    break;
            }
            this.aktualnySmer = this.aktualnySmer.getOpacnySmer(this.aktualnySmer);

        }
    }

}

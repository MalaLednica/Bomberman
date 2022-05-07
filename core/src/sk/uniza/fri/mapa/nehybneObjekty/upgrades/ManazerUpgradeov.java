package sk.uniza.fri.mapa.nehybneObjekty.upgrades;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class ManazerUpgradeov {

    private ArrayList<Upgrade> zoznam;
    private SpriteBatch batch;

    public ManazerUpgradeov(SpriteBatch batch) {
        this.zoznam = new ArrayList<>();
        this.batch = batch;
    }


    public void pridajUpgrade(Upgrade upgrade) {
        this.zoznam.add(upgrade);

    }

    public Upgrade vytvorNahodnyUpgrade(int x, int y) {
        Random rnd = new Random();
        int vyber = rnd.nextInt(4);
        switch (vyber) {
            case 0:
                return new StitUpgrade(x, y, this.batch);
            case 1:
                return new DosahBombyUpgrade(x, y, this.batch);
            case 2:
                return new PocetBombUpgrade(x, y, this.batch);
            case 3:
                return new ZivotyUpgrade(x, y, this.batch);

        }
        return null;
    }


    public Upgrade kontrolaKolizie(Rectangle objekt) {

        for (Upgrade upgrade : this.zoznam) {
            if (upgrade.getOblastNaMape().overlaps(objekt)) {

                return this.zoznam.remove(this.zoznam.indexOf(upgrade));
            }
        }


        return null;
    }

    public void vykresliVsetko() {
        for (Upgrade upgrade : this.zoznam) {
            upgrade.vykresliSa();

        }

    }


    public void pridajNahodne() {
        Random rnd = new Random();
        int a = rnd.nextInt(8) + 1;
        int b = rnd.nextInt(8) + 1;

        this.zoznam.add(this.vytvorNahodnyUpgrade(a, b));


    }


}

package sk.uniza.fri.mapa;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.Smer;
import sk.uniza.fri.hra.Hrac;
import sk.uniza.fri.mapa.nehybneObjekty.bomby.ManazerBomb;
import sk.uniza.fri.mapa.nehybneObjekty.steny.ManazerStien;
import sk.uniza.fri.mapa.nehybneObjekty.steny.TypSteny;
import sk.uniza.fri.mapa.nehybneObjekty.upgrades.ManazerUpgradeov;
import sk.uniza.fri.mapa.nehybneObjekty.upgrades.Upgrade;
import sk.uniza.fri.mapa.ziveObjekty.ManazerNepriatelov;

import java.util.Random;

public class Mapa {
    private ManazerStien manazerStien;
    private ManazerNepriatelov manazerNepriatelov;
    private ManazerUpgradeov manazerUpgradeov;
    private ManazerBomb manazerBomb;


    public Mapa(SpriteBatch batch, int sirka, int vyska) {
        this.manazerStien = new ManazerStien(batch, sirka, vyska);
        this.manazerNepriatelov = new ManazerNepriatelov(batch);
        this.manazerUpgradeov = new ManazerUpgradeov(batch);
        this.manazerBomb = new ManazerBomb(batch);

    }

    public void vytvor() {
        this.manazerStien.vytvorOkraje();
        this.manazerStien.vytvorStredoveSteny();
        this.manazerStien.pridajNahodne(30);
        this.manazerNepriatelov.pridajNahodne(20);
        this.manazerUpgradeov.pridajNahodne();


    }


    public void vykresli() {
        this.manazerStien.vykresliVsetko();
        this.manazerNepriatelov.pohniVsetko(this.manazerStien);
        this.manazerNepriatelov.vykresliVsetko();
        this.manazerUpgradeov.vykresliVsetko();
        this.manazerBomb.vykresliVsetko();

    }

    public ManazerStien getManazerStien() {
        return this.manazerStien;
    }

    public ManazerNepriatelov getManazerNepriatelov() {
        return this.manazerNepriatelov;
    }

    public boolean hracZraneny(Hrac hrac) {
        if (this.manazerNepriatelov.kontrolaKolizie(hrac.getBombermanOblastNaMape())) {
            hrac.odoberZivot();
            if (hrac.getZivoty() == 0) {
                return true;
            }
            hrac.respawnBombermana();


        }
        return false;
    }

    public void hracZobralUpgrade(Hrac hrac) {
        Upgrade upgrade = this.manazerUpgradeov.kontrolaKolizie(hrac.getBombermanOblastNaMape());
        if (upgrade != null) {
            upgrade.zober(hrac);
            System.out.println("abc");
        }


    }

    public void vybuchBomby(int x, int y, int dosahBomby) {
        Smer[] smery = {Smer.DOPRAVA, Smer.DOLE, Smer.HORE, Smer.DOLAVA};

        for (Smer smer : smery) {
            int i = 0;
            boolean pom = true;
            while (i < dosahBomby && pom) {
                TypSteny typ = this.manazerStien.typSteny((x + smer.getX() * i), (y + smer.getY() * i));
                if (typ == TypSteny.OHRANICENIE || typ == TypSteny.NEZNICITELNA) {
                    pom = false;
                } else {
                    this.manazerBomb.pridajVybuch(x + smer.getX() * i, y + smer.getY() * i);

                    if (this.manazerStien.znicStenu(x + smer.getX() * i,  y + smer.getY() * i)) {
                        pom = false;
                        Random rnd = new Random();
                        if (rnd.nextInt(5) == 0) {
                            this.manazerUpgradeov.pridajUpgrade(this.manazerUpgradeov.vytvorNahodnyUpgrade(x + smer.getX() * i, y + smer.getY() * i));
                        }

                    }
                }
                i++;

            }


        }


    }

    public void polozBombu(Hrac hrac) {
        if (hrac.mozePolozitBombu() && !this.manazerBomb.kontrolaKolizie(hrac.getBombermanOblastNaMape())) {
            hrac.pridajPocetPolozenychBomb();
            int x = (int) hrac.getBombermanOblastNaMape().getX() / 64;
            int y = (int) hrac.getBombermanOblastNaMape().getY() / 64;
            this.manazerBomb.pridajBombu(x, y, hrac.getDosah());

        }


    }


    public void kontrolaVyprsaniaCasov(Hrac hrac) {
        this.manazerBomb.kontrolaVyprsaniaCasov(this, hrac);
    }


}

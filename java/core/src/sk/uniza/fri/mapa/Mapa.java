package sk.uniza.fri.mapa;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.hra.Hrac;
import sk.uniza.fri.mapa.nehybneObjekty.ManazerStien;
import sk.uniza.fri.mapa.nehybneObjekty.upgrades.ManazerUpgradeov;
import sk.uniza.fri.mapa.nehybneObjekty.upgrades.Upgrade;
import sk.uniza.fri.mapa.ziveObjekty.ManazerNepriatelov;

public class Mapa {
    private ManazerStien manazerStien;
    private ManazerNepriatelov manazerNepriatelov;
    private ManazerUpgradeov manazerUpgradeov;

    public Mapa(SpriteBatch batch, int sirka, int vyska) {
        this.manazerStien = new ManazerStien(batch, sirka, vyska);
        this.manazerNepriatelov = new ManazerNepriatelov(batch);
        this.manazerUpgradeov = new ManazerUpgradeov(batch);
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

    }

    public ManazerStien getManazerStien() {
        return manazerStien;
    }

    public ManazerNepriatelov getManazerNepriatelov() {
        return this.manazerNepriatelov;
    }

    public void hracZraneny(Hrac hrac) {
        if (this.manazerNepriatelov.kontrolaKolizie(hrac.getBomberman().getOblastNaMape())) {

            hrac.respawnBombermana();
        }
    }

    public void hracZobralUpgrade(Hrac hrac) {
        Upgrade upgrade = this.manazerUpgradeov.kontrolaKolizie(hrac.getBomberman().getOblastNaMape());
        if(upgrade != null) {
            upgrade.zober(hrac);
            System.out.println("abc");
        }


    }




}

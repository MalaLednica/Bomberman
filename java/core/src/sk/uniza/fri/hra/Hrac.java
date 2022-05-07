package sk.uniza.fri.hra;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import sk.uniza.fri.Smer;
import sk.uniza.fri.hra.obrazovky.BombermanObrazovka;
import sk.uniza.fri.mapa.Mapa;
import sk.uniza.fri.mapa.ziveObjekty.Bomberman;

public class Hrac {

    private final SpriteBatch batch;
    private final Mapa mapa;
    private Bomberman bomberman;

    private int dosah;
    private boolean maStit;
    private int maxPocetBomb;
    private int pocetPolozenychBomb;
    private int zivoty;



    public Hrac(SpriteBatch batch, Mapa mapa) {
        this.batch = batch;
        this.bomberman = new Bomberman(1, (BombermanObrazovka.VYSKA_PLOCHY / 64) - 2, this.batch);
        this.mapa = mapa;
        this.dosah = 2;
        this.maxPocetBomb = 3;
        this.pocetPolozenychBomb = 0;
        this.zivoty = 3;



    }

    public boolean pohyb(Smer smer) {

        if (this.bomberman.mozemSaPohnut(smer, this.mapa.getManazerStien())) {
            this.bomberman.pohniSa(smer);
            return true;
        }


        return false;
    }


    public void vykresli() {
        this.bomberman.vykresliSa();

    }

    public Rectangle getBombermanOblastNaMape() {
        return this.bomberman.getOblastNaMape();
    }

    public void respawnBombermana() {
        this.bomberman.setX(64);
        this.bomberman.setY(BombermanObrazovka.VYSKA_PLOCHY - 128);
    }

    public void pridajDosah() {
        this.dosah++;
    }

    public int getDosah() {
        return this.dosah;
    }

    public void pridajPocetBomb() {
        this.maxPocetBomb++;
    }

    public void odoberPocetPolozenychBomb() {
        this.pocetPolozenychBomb--;
    }


    public void pridajPocetPolozenychBomb() {
        this.pocetPolozenychBomb++;
    }

    //TODO zobrazenie štítu
    public void nastavStit(boolean nastav) {
        this.maStit = nastav;
    }

    public boolean mozePolozitBombu() {
        if (this.pocetPolozenychBomb < this.maxPocetBomb) {
            return true;
        }
        return false;


    }

    public void pridajZivot() {
        this.zivoty++;
    }

    public void odoberZivot() {
        this.zivoty--;
    }


    public int getZivoty() {
        return zivoty;
    }
}

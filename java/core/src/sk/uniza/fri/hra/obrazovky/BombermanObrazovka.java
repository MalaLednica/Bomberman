package sk.uniza.fri.hra.obrazovky;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import sk.uniza.fri.Smer;
import sk.uniza.fri.hra.BombermanHra;
import sk.uniza.fri.hra.Hrac;
import sk.uniza.fri.mapa.Mapa;
import sk.uniza.fri.mapa.nehybneObjekty.ManazerStien;
import sk.uniza.fri.mapa.ziveObjekty.ManazerNepriatelov;
import sk.uniza.fri.mapa.ziveObjekty.Nepriatel;

import java.util.Random;

public class BombermanObrazovka extends ScreenAdapter {


    public static final int SIRKA_PLOCHY = 1600;
    public static final int VYSKA_PLOCHY = 960;


    private final BombermanHra bombermanHra;
    private final SpriteBatch batch;

    private final Camera kamera;
    private final Viewport viewport;


    private Hrac hrac;
    private Mapa mapa;


    public BombermanObrazovka(BombermanHra bombermanHra) {

        this.bombermanHra = bombermanHra;
        this.batch = new SpriteBatch();


        this.kamera = new OrthographicCamera();
        this.viewport = new FitViewport(SIRKA_PLOCHY, VYSKA_PLOCHY, this.kamera);



        this.mapa = new Mapa(this.batch, SIRKA_PLOCHY/64, VYSKA_PLOCHY/64);
        this.mapa.vytvor();
        this.hrac = new Hrac(this.batch, this.mapa);





    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);


        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.hrac.pohyb(Smer.HORE);

        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.hrac.pohyb(Smer.DOLE);

        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.hrac.pohyb(Smer.DOLAVA);

        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.hrac.pohyb(Smer.DOPRAVA);

        }
        //TODO trieda bomba

        //TODO polozenie bomby
        //TODO vybuch bomby
        //TODO nicenie stien
        //TODO zabijanie nepriatelov a hraca
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            this.hrac.polozBombu();
        }


        this.hrac.vykresli();

        this.mapa.hracZobralUpgrade(this.hrac);
        this.mapa.hracZraneny(this.hrac);
        this.mapa.vykresli();



    }


    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height, true);
        this.batch.setProjectionMatrix(this.kamera.combined);
    }

    @Override
    public void dispose() {
        this.batch.dispose();

    }
}

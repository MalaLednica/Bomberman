package sk.uniza.fri.hra.obrazovky;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import sk.uniza.fri.Smer;
import sk.uniza.fri.hra.BombermanHra;
import sk.uniza.fri.hra.Hrac;
import sk.uniza.fri.hra.obrazovky.ikony.IIkona;
import sk.uniza.fri.hra.obrazovky.ikony.MenuIkona;
import sk.uniza.fri.hra.obrazovky.ikony.ZvukIkona;
import sk.uniza.fri.mapa.Mapa;

import java.util.ArrayList;

public class BombermanObrazovka extends ScreenAdapter {


    public static final int SIRKA_PLOCHY = 1600;
    public static final int VYSKA_PLOCHY = 960;


    private final BombermanHra bombermanHra;
    private final SpriteBatch batch;


    private final Camera kamera;
    private final Viewport viewport;


    private Hrac hrac;
    private Mapa mapa;

    private ArrayList<IIkona> ikony;

    public BombermanObrazovka(BombermanHra bombermanHra) {

        this.bombermanHra = bombermanHra;
        this.batch = new SpriteBatch();


        this.kamera = new OrthographicCamera();
        this.viewport = new FitViewport(SIRKA_PLOCHY, VYSKA_PLOCHY, this.kamera);


        this.mapa = new Mapa(this.batch, SIRKA_PLOCHY / 64, VYSKA_PLOCHY / 64);
        this.mapa.vytvor();
        this.hrac = new Hrac(this.batch, this.mapa);

        this.ikony = new ArrayList<>();
        this.ikony.add(new MenuIkona(this.bombermanHra, 1430, 900, this.batch));
        this.ikony.add(new ZvukIkona(this.bombermanHra, 1530, 900, this.batch));



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

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            this.mapa.polozBombu(this.hrac);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            this.mapa.vybuchBomby(10,9,5);
        }







        //TODO vybuch bomby vizualne
        //TODO zabijanie nepriatelov a hraca




        this.hrac.vykresli();

        this.mapa.hracZobralUpgrade(this.hrac);



        if (this.mapa.hracZraneny(this.hrac)) {
            this.bombermanHra.setScreen(new MenuObrazovka(this.bombermanHra));
        }

        this.mapa.kontrolaVyprsaniaCasov(this.hrac);
        this.mapa.vykresli();


        for (IIkona iIkona : this.ikony) {
            iIkona.vykresliSa();
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                Vector3 vector = this.viewport.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
                iIkona.skontrolujKliknutie((int)vector.x, (int)vector.y);
            }

        }


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

package sk.uniza.fri.hra.obrazovky.ikony;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.hra.BombermanHra;

public class ZvukIkona implements IIkona {
    private final BombermanHra bombermanHra;
    private Sprite ikona;
    private SpriteBatch batch;

    public ZvukIkona(BombermanHra bombermanHra, int x, int y, SpriteBatch batch) {
        this.bombermanHra = bombermanHra;
        this.ikona = new Sprite(new Texture("zvuk.png"));
        this.batch = batch;
        this.ikona.setX(x);
        this.ikona.setY(y);


    }

    @Override
    public void vykonaj() {
        //TODO dorobiť metódu
        System.out.println("bzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");

    }

    @Override
    public void vykresliSa() {
        this.batch.begin();
        this.ikona.draw(this.batch);
        this.batch.end();
    }

    @Override
    public void skontrolujKliknutie(int x, int y) {
        if (this.ikona.getBoundingRectangle().contains(x, y)) {
            this.vykonaj();
        }
    }
}
//TODO doplniť zvuky



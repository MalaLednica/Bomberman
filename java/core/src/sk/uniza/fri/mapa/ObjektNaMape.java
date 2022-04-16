package sk.uniza.fri.mapa;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class ObjektNaMape {


    public static final int STRANA_STVORCA = 64;



    private final SpriteBatch batch;
    private Sprite sprite;

    public ObjektNaMape(int x, int y, String nazovSuboru, SpriteBatch batch) {

        this.sprite = new Sprite(new Texture(nazovSuboru));
        this.sprite.setX(x * STRANA_STVORCA);
        this.sprite.setY(y * STRANA_STVORCA);
        this.batch = batch;


    }

    public float getX() {
        return (int) sprite.getX();
    }

    public void setX(float x) {

        this.sprite.setX(x);
    }

    public float getY() {
        return (int) this.sprite.getY();
    }

    public void setY(float y) {

        this.sprite.setY(y);
    }

    public Rectangle getOblastNaMape() {

        return this.sprite.getBoundingRectangle();
    }

    public void vykresliSa() {
        this.batch.begin();
        this.sprite.draw(this.batch);
        this.batch.end();

    }

    public void dispose() {
        this.sprite.getTexture().dispose();
    }


}

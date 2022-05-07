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
import sk.uniza.fri.hra.BombermanHra;
import sk.uniza.fri.hra.obrazovky.ikony.IIkona;
import sk.uniza.fri.hra.obrazovky.ikony.NovaHraIkona;


public class MenuObrazovka extends ScreenAdapter {
    private final BombermanHra bombermanHra;
    private IIkona novaHra;
    private SpriteBatch batch;

    private final Camera kamera;
    private final Viewport viewport;

    public MenuObrazovka(BombermanHra bombermanHra) {
        this.bombermanHra = bombermanHra;
        this.batch = new SpriteBatch();
        this.novaHra = new NovaHraIkona(this.bombermanHra, 500, 450, this.batch);
        this.kamera = new OrthographicCamera();
        this.viewport = new FitViewport(BombermanObrazovka.SIRKA_PLOCHY, BombermanObrazovka.VYSKA_PLOCHY, this.kamera);

    }

    // https://stackoverflow.com/questions/44347674/libgdx-mouse-position-in-world-deviation
    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        this.novaHra.vykresliSa();
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            Vector3 vector = this.viewport.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            this.novaHra.skontrolujKliknutie((int)vector.x, (int)vector.y);
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

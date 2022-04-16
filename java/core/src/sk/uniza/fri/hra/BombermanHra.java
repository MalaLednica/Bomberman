package sk.uniza.fri.hra;

import com.badlogic.gdx.Game;
import sk.uniza.fri.hra.obrazovky.BombermanObrazovka;

public class BombermanHra extends Game {

    @Override
    public void create() {
        setScreen(new BombermanObrazovka(this));
    }
}

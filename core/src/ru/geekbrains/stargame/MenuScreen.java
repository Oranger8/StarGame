package ru.geekbrains.stargame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.geekbrains.stargame.engine.Base2DScreen;

/**
 * Created by Oranger on 27.01.2018.
 */

public class MenuScreen extends Base2DScreen {

    private SpriteBatch batch;
    private Texture img1;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img1 = new Texture("forest.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setColor(0.5f, 0.5f, 0.5f, 1);
        batch.draw(img1, 0, 0);
        batch.setColor(1, 1, 1, 1);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img1.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenX + " " + screenY);
        return true;
    }
}

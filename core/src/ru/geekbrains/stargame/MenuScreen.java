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
    private Texture bkg, img1;
    private int x, y;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        bkg = new Texture("forest.jpg");
        img1 = new Texture("x-wing.png");
        x = 0; y = 0;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setColor(0.5f, 0.5f, 0.5f, 1);
        batch.draw(bkg, 0, 0);
        batch.setColor(1, 1, 1, 1);
        batch.draw(img1, x, y, 92, 92);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bkg.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        x = screenX - 46; y = Gdx.graphics.getHeight() - screenY - 46;
        return true;
    }
}

package ru.geekbrains.stargame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.engine.Background;
import ru.geekbrains.stargame.engine.Base2DScreen;
import ru.geekbrains.stargame.engine.Button;
import ru.geekbrains.stargame.engine.math.Rect;

/**
 * Created by Oranger on 27.01.2018.
 */

public class MenuScreen extends Base2DScreen {

    private SpriteBatch batch;
    private Texture bkg, srt, ext;
    private Background background;
    private Button start, exit;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        batch.getProjectionMatrix().idt();
        bkg = new Texture("forest.jpg");
        srt = new Texture("play-button-overlay.png");
        ext = new Texture("turn_off-512.png");
        background = new Background(new TextureRegion(bkg));
        start = new Button(new TextureRegion(srt), new Vector2(-0.8f, -0.8f));
        exit = new Button(new TextureRegion(ext), new Vector2(0.8f, -0.8f));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        start.draw(batch);
        exit.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        bkg.dispose();
        srt.dispose();
        ext.dispose();
        super.dispose();
    }

    @Override
    protected void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        start.resize(worldBounds);
        exit.resize(worldBounds);
    }

    @Override
    protected void touchUp(Vector2 touch, int pointer) {
        super.touchUp(touch, pointer);
    }
}

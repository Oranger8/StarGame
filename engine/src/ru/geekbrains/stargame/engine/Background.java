package ru.geekbrains.stargame.engine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.stargame.engine.math.Rect;

/**
 * Created by Oranger on 01.02.2018.
 */

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
        scale = 2f;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.setColor(0.5f, 0.5f, 0.5f, 1f);
        super.draw(batch);
        batch.setColor(1f, 1f, 1f, 1f);
    }
}

package ru.geekbrains.stargame.engine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.engine.math.Rect;

/**
 * Created by Oranger on 01.02.2018.
 */

public class Button extends Sprite {

    public Button(TextureRegion region, Vector2 position) {
        super(region);
        pos.set(position);
        scale = 0.2f;
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
    }
}

package ru.geekbrains.stargame.ship;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.stargame.engine.math.Rect;
import ru.geekbrains.stargame.engine.pool.SpritesPool;

public class EnemyPool extends SpritesPool<EnemyShip> {

    private TextureAtlas atlas;

    public EnemyPool(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(atlas);
    }

    public void resizeAllActiveObjects(Rect worldBounds) {
        for (int i = 0; i < activeObjects.size(); i++) {
            activeObjects.get(i).resize(worldBounds);
        }
    }

    @Override
    protected void debugLog() {
        System.out.println("EnemyPool change active/free:" + activeObjects.size() + "/" + freeObjects.size());
    }
}

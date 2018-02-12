package ru.geekbrains.stargame.ship;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.bullet.BulletPool;
import ru.geekbrains.stargame.engine.math.Rect;

public class EnemyShip extends Ship {

    private static final float SHIP_HEIGHT = 0.15f;

    public EnemyShip(TextureAtlas atlas) {
        super(atlas.findRegion("enemy0"), 1, 2, 2);
        setHeightProportion(SHIP_HEIGHT);
        /*this.bulletPool = bulletPool;
        this.bulletRegion = atlas.findRegion("bulletEnemy");
        this.bulletHeight = 0.01f;
        this.bulletV.set(0, 0.5f);
        this.bulletDamage = 1;
        this.reloadInterval = 0.5f;*/
    }

    public void set(Vector2 pos0, Vector2 v0, Rect worldBounds) {
        this.pos.set(pos0);
        this.v.set(v0);
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        reloadTimer += delta;
        if (reloadTimer >= reloadInterval) {
            reloadTimer = 0f;
            shoot();
        }
        if (getTop() < worldBounds.getBottom()) {
            setDestroyed(true);
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setTop(worldBounds.getTop());
    }

    @Override
    protected void shoot() {

    }
}

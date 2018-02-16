package ru.geekbrains.stargame.ship;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.bullet.Bullet;
import ru.geekbrains.stargame.bullet.BulletPool;
import ru.geekbrains.stargame.engine.Sprite;
import ru.geekbrains.stargame.engine.math.Rect;
import ru.geekbrains.stargame.explosion.Explosion;
import ru.geekbrains.stargame.explosion.ExplosionPool;

public abstract class Ship extends Sprite {

    private static final float DAMAGE_ANIMATE_INTERVAL = 0.1f;
    private float damageAnimateTimer = DAMAGE_ANIMATE_INTERVAL;

    protected final Vector2 v = new Vector2();
    protected Rect worldBounds;

    protected int hp;

    protected BulletPool bulletPool;
    protected ExplosionPool explosionPool;

    protected TextureRegion bulletRegion;

    protected Sound shootSound;

    protected final Vector2 bulletV = new Vector2();
    protected float bulletHeight;
    protected int bulletDamage;

    protected float reloadInterval, reloadTimer;

    public Ship(TextureRegion region, int rows, int cols, int frames, BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, Sound shootSound) {
        super(region, rows, cols, frames);
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
        this.shootSound = shootSound;
    }

    public Ship(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, Sound shootSound) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
        this.shootSound = shootSound;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        damageAnimateTimer += delta;
        if (damageAnimateTimer >= DAMAGE_ANIMATE_INTERVAL) {
            frame = 0;
        }
    }

    public int getBulletDamage() {
        return bulletDamage;
    }

    public void damage(int damage) {
        frame = 1;
        damageAnimateTimer = 0;

    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    protected void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, bulletDamage);
        shootSound.play();
    }

    public void boom() {
        Explosion explosion = explosionPool.obtain();
        explosion.set(getHeight(), pos);
    }
}

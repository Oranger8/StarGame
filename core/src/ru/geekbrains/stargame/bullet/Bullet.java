package ru.geekbrains.stargame.bullet;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.engine.Sprite;
import ru.geekbrains.stargame.engine.math.Rect;

public class Bullet extends Sprite {

    private Rect worldBounds;

    private final Vector2 v = new Vector2();

    private int damage;

    private Object owner;

    private Sound sound;

    public Bullet(Sound sound) {
        regions = new TextureRegion[1];
        this.sound = sound;
    }

    public void set(Object owner, TextureRegion region, Vector2 pos0, Vector2 v0, float height, Rect worldBounds, int damage) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(pos0);
        this.v.set(v0);
        setHeightProportion(height);
        this.worldBounds = worldBounds;
        this.damage = damage;
        sound.play(0.1f);
    }

    @Override
    public void update(float delta) {
        this.pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            setDestroyed(true);
        }
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public int getDamage() {
        return damage;
    }

    public Object getOwner() {
        return owner;
    }
}

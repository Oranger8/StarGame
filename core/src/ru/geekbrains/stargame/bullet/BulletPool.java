package ru.geekbrains.stargame.bullet;

import com.badlogic.gdx.audio.Sound;

import ru.geekbrains.stargame.engine.pool.SpritesPool;

public class BulletPool extends SpritesPool<Bullet> {

    private Sound sound;

    public BulletPool(Sound sound) {
        this.sound = sound;
    }

    @Override
    protected Bullet newObject() {
        return new Bullet(sound);
    }

    @Override
    protected void debugLog() {
        System.out.println("BulletPool change active/free:" + activeObjects.size() + "/" + freeObjects.size());
    }
}

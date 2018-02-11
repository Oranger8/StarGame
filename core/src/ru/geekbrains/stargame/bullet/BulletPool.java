package ru.geekbrains.stargame.bullet;

import ru.geekbrains.stargame.engine.pool.SpritesPool;

/**
 * Created by Oranger on 11.02.2018.
 */

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

    @Override
    protected void debugLog() {
        System.out.println("BulletPool change active/free:" + activeObjects.size() + "/" + freeObjects.size());
    }
}

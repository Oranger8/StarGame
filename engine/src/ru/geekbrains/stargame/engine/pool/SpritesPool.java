package ru.geekbrains.stargame.engine.pool;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ru.geekbrains.stargame.engine.Sprite;

public abstract class SpritesPool<T extends Sprite> {

    protected final List<T> activeObjects = new LinkedList<T>();
    protected final List<T> freeObjects = new ArrayList<T>();

    protected abstract T newObject();

    public T obtain() {
        T object;
        if (freeObjects.isEmpty()) {
            object = newObject();
        } else {
            object = freeObjects.remove(freeObjects.size() - 1);
        }
        activeObjects.add(object);
        return object;
    }

    public void drawActiveObjects(SpriteBatch batch) {
        for (int i = 0; i < activeObjects.size(); i++) {
            activeObjects.get(i).draw(batch);
        }
    }

    public void updateActiveObjects(float delta) {
        for (int i = 0; i < activeObjects.size(); i++) {
            activeObjects.get(i).update(delta);
        }
    }

    protected void dispose() {
        activeObjects.clear();
        freeObjects.clear();
    }

    private void free(T object) {
        if (!activeObjects.remove(object)) {
            throw new RuntimeException("Trying to delete not existing object");
        }
        freeObjects.add(object);
    }

    public void freeAllDestroyedActiveObjects() {
        for (int i = 0; i < activeObjects.size(); i++) {
            T sprite = activeObjects.get(i);
            if (sprite.isDestroyed()) {
                free(sprite);
                i--;
                sprite.setDestroyed(false);
            }
        }
    }
}
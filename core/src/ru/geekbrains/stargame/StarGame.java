package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img1, img2, wing;
	TextureRegion tie;
	int stateTime, point1, point2;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img1 = new Texture("forest.jpg");
        img2 = new Texture("forest.jpg");
        wing = new Texture("X-Wing_Top_View.png");
        tie = new TextureRegion(new Texture("8rlMkn-TopView.png"));
		stateTime = 1024;
		point1 = 0;
		point2 = 1024;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setColor(0.5f, 0.5f, 0.5f, 1);
		batch.draw(img1, 0, point1);
		batch.draw(img2, 0, point2);
		batch.setColor(1, 1, 1, 1);
		batch.draw(wing, 300, 10, 92, 100);
		batch.draw(tie, 300, 400, 0, 0, 92, 92, 1, 1, 180);
		batch.end();
		if (point1 == -1024) point1 = 1024;
		if (point2 == -1024) point2 = 1024;
		point1--;
		point2--;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img1.dispose();
        img2.dispose();
	}
}

package com.jamesfulop.LD27;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LD27 implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private Timer timer;
	private TimeSignature timeSignature;
	private Instruments instruments;
	private Metronome met;
	private SongPlayer songPlayer;
	String timeSig = "4/4";
	int bars = 4;
	@Override
	public void create() {				
		camera = new OrthographicCamera(800, 600);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		//sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		timer = new Timer();
		timeSignature = new TimeSignature(timeSig, bars);
		instruments = new Instruments();
		met = new Metronome(timeSig, bars);
		songPlayer = new SongPlayer(timeSig, bars, timer);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
		met.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor( .6f, .6f, .6f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//sprite.draw(batch);
		timeSignature.draw(batch);
		instruments.draw(batch);
		songPlayer.draw(batch, timer);
		timer.draw(batch);
		met.play(timer);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	public String getTimeSig() {
		return timeSig;
	}

	public void setTimeSig(String timeSig) {
		this.timeSig = timeSig;
	}

	public int getBars() {
		return bars;
	}

	public void setBars(int bars) {
		this.bars = bars;
	}
}

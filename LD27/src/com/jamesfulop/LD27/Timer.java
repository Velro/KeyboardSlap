package com.jamesfulop.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Timer {
	BitmapFont font;
	double startTime = (double) System.currentTimeMillis();
	double currentTime;
	String currentTimeString;
	
	private Texture redBoxTex;
	private static Sprite redLine;
	Timer (){
		font = new BitmapFont();
		redBoxTex = new Texture(Gdx.files.internal("data/redbox.png"));
		redBoxTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		redLine = new Sprite(redBoxTex);
		redLine.setSize(4, 600);
		redLine.setPosition(-400,-300);
		redLine.setColor(1,0,0,1);
	}

	public void draw (SpriteBatch batch) {
		font.setColor(0,0,0,1);
		font.setOwnsTexture(true);
		font.setScale(1.5f);
		currentTime = (double) ((System.currentTimeMillis() - startTime)/1000)+1;
		if(currentTime >= 10.99)startTime += 10000; //looping
		currentTimeString = Double.toString(currentTime).substring(0, 3);
		if(currentTime >=10)currentTimeString = Double.toString(currentTime).substring(0, 4);
		font.draw(batch, currentTimeString, 355,300);
		redLine.setX((float) (-400 + (currentTime - 1)*80));
		redLine.draw(batch);
	}
	
	public Sprite getRedLine() {
		return redLine;
	}
}

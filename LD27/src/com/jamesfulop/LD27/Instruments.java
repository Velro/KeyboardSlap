package com.jamesfulop.LD27;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Instruments {
	Texture blackBoxTex;
	Sprite line;
	int instruments = 7;
	
	Instruments () {
		blackBoxTex = new Texture(Gdx.files.internal("data/blackbox.png"));
		blackBoxTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		line = new Sprite(blackBoxTex);
		line.setColor(0f,0f,1f, 0.75f);
		line.setSize(800, 1);
		line.setX(-400f);
	}
	public void draw (SpriteBatch batch){ 
		int spacing = 600 / instruments;
		for (int i = 0; i < instruments; i++){
			line.setY(-300 + (i * spacing));
			line.draw(batch);
		}
	}
}

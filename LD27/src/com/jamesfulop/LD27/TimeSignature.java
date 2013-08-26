package com.jamesfulop.LD27;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class TimeSignature {
	
	String timeSignature = "4/4";
	int bars;
	int BPM;
	int beats;
	int time;
	public static int spacing;
	
	private Texture blackBoxTex;
	private Sprite thinLine;
	private Sprite thickLine;
	BitmapFont font;
	ArrayList<Vector2> beatPos;
	
	TimeSignature(String timeSignature, int bars){
		this.timeSignature = timeSignature;
		this.bars = bars;
		beats = Integer.parseInt(timeSignature.substring(0,1));
		time = Integer.parseInt(timeSignature.substring(2,3));
		BPM = beats * bars * 6;
		beatPos = populateList();
		
		font = new BitmapFont();
		font.setColor(0,0,0,1);
		font.setOwnsTexture(true);
		font.setScale(1.5f);
		
		blackBoxTex = new Texture(Gdx.files.internal("data/blackbox.png"));
		blackBoxTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		thinLine = new Sprite(blackBoxTex);
		thinLine.setColor( 1, 1, 1, 0.75f);
		thinLine.setSize(1, 510);
		thickLine = new Sprite(blackBoxTex);
		thickLine.setColor(1,1,1,(float) 0.75);
		thickLine.setSize(2, 510);
	}
	public void draw (SpriteBatch batch){
		font.draw(batch, timeSignature+"   "+BPM, -380, 300);
		for (int i = 0; i < beats*bars; i++){
			Vector2 currentPos = beatPos.get(i);
			if (currentPos.x == 0){
				thickLine.setPosition(currentPos.y, -300); //lol wat
				thickLine.draw(batch);
			} else {
				thinLine.setPosition(currentPos.y, -300);
				thinLine.draw(batch);
			}
		}
	}
	
	public ArrayList<Vector2> populateList (){
		spacing = 800 / (beats * bars);
		ArrayList<Vector2> pos = new ArrayList<Vector2>();
		for (int i = 0; i < beats * bars; i++){
			if (i % beats == 0){
				pos.add(new Vector2(0,-400 + (spacing * i)));
			} else {
				pos.add(new Vector2(1,-400 + (spacing * i)));
			}
		}
		
		return pos;
	}
	
	public int getSpacing() {
		spacing = 800 / (beats * bars);
		return spacing;
	}
	public int getTime() {
		return time;
	}
	public int getBPM() {
		return BPM;
	}
}

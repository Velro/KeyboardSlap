package com.jamesfulop.LD27;

import java.util.ArrayList;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class SongPlayer extends TimeSignature {
	int timerPos;
	int lastHitBass = 0;
	int lastHitSnare = 0;
	int lastHitRide = 0;
	int lastHitCrash = 0;

	int totalPossible;
	int currentLevel = 1;
	ArrayList<Vector2> song1Bass;
	ArrayList<Vector2> song1Snare;
	ArrayList<Vector2> song1Ride;
	ArrayList<Vector2> song1Crash;
	ArrayList<Vector2> slapCrash;
	
	Texture purpleTex;
	Sprite purple;
	Color purpleC;
	Texture darkRedTex;
	Sprite darkRed;
	Color darkRedC;
	Texture blueTex;
	Sprite blue;
	Color blueC;
	Texture yellowTex;
	Sprite yellow;
	Color yellowC;
	
	Audio audio;
	Sound ride;  //Credit to britishpirate93
	Sound crash; //Credit to djxm4c
	Sound bass;  //Credit to ev3nifitkillsme
	Sound snare; //Credit to minorr

	BitmapFont font;
	int score;
	public SongPlayer(String timeSignature, int bars, Timer timer){
		super(timeSignature, bars);
		this.timerPos = (int) timer.getRedLine().getX();
		this.song1Bass = Song1.generateSong1Bass();
		this.song1Snare = Song1.generateSong1Snare();
		this.song1Ride = Song1.generateSong1Ride();
		this.song1Crash = Song1.generateSong1Crash();
		this.slapCrash = Song1.generateSlapCrash();
		
		totalPossible = song1Bass.size();
		
		purpleTex = new Texture(Gdx.files.internal("data/purplebox.png"));
		purpleTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		purple = new Sprite(purpleTex);
		purple.setSize(10,85);
		purple.setY(-300);
		purpleC = Color.valueOf("fffffffe");
		
		darkRedTex = new Texture(Gdx.files.internal("data/darkredbox.png"));
		darkRedTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		darkRed = new Sprite(darkRedTex);
		darkRed.setSize(10,85);
		darkRed.setY(-45);
		darkRedC = Color.valueOf("fffffffe");
		
		blueTex = new Texture(Gdx.files.internal("data/bluebox.png"));
		blueTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		blue = new Sprite(blueTex);
		blue.setSize(10,85);
		blue.setY(40);
		blueC = Color.valueOf("fffffffe");
		
		yellowTex = new Texture(Gdx.files.internal("data/yellowbox.png"));
		yellowTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		yellow = new Sprite(yellowTex);
		yellow.setSize(10,85);
		yellow.setY(125);
		yellowC = Color.valueOf("fffffffe");
		
		audio = Gdx.audio;
		ride = Gdx.audio.newSound(Gdx.files.internal("data/ride.wav"));
		bass = Gdx.audio.newSound(Gdx.files.internal("data/bass.wav"));
		snare = Gdx.audio.newSound(Gdx.files.internal("data/snare.wav"));
		crash = Gdx.audio.newSound(Gdx.files.internal("data/crash.wav"));
		
		font = new BitmapFont();
		font.setColor(0,0,0,1);
		font.setOwnsTexture(true);
		font.setScale(1.5f);
	}
	
	public void draw (SpriteBatch batch, Timer timer){
		if (timerPos >= 398){
			if (levelSwitcher(score, totalPossible)>currentLevel)currentLevel++;
			if (currentLevel==2)totalPossible = song1Bass.size()+song1Snare.size();
			if (currentLevel==3)totalPossible = song1Bass.size()+song1Snare.size()+song1Ride.size();
			if (currentLevel==4)totalPossible = song1Bass.size()+song1Snare.size()+song1Ride.size()+song1Crash.size();
			score = 0;
			purple.setColor(purpleC);
			darkRed.setColor(darkRedC);
			blue.setColor(blueC);
			yellow.setColor(yellowC);
		}
		
		timerPos = (int) timer.getRedLine().getX();
		//draw bass
		if (currentLevel == 1 || currentLevel == 2 || currentLevel == 3|| currentLevel == 4){
			for (int i = 0; i<song1Bass.size(); i++){
				purple.setX(song1Bass.get(i).y);
				purple.draw(batch);
			}
		}
		//draw snare
		if (currentLevel == 2 || currentLevel == 3|| currentLevel == 4)
		for (int i = 0; i<song1Snare.size(); i++){
			darkRed.setX(song1Snare.get(i).y);
			darkRed.draw(batch);
		}
		//draw ride
		if (currentLevel == 3 || currentLevel == 4)
		for (int i = 0; i<song1Ride.size(); i++){
			blue.setX(song1Ride.get(i).y);
			blue.draw(batch);
		}
		//draw crash
				if (currentLevel == 4)
				for (int i = 0; i<song1Crash.size(); i++){
					yellow.setX(song1Crash.get(i).y);
					yellow.draw(batch);
				}
				if (currentLevel == 5){
					for (int i = 0; i<slapCrash.size(); i++){
						yellow.setX(slapCrash.get(i).y);
						blue.setX(slapCrash.get(i).y);
						darkRed.setX(slapCrash.get(i).y);
						purple.setX(slapCrash.get(i).y);
						yellow.draw(batch);
						blue.draw(batch);
						darkRed.draw(batch);
						purple.draw(batch);
					}
				}
		if (Gdx.input.isKeyPressed(Keys.SPACE) && Gdx.input.isKeyPressed(Keys.ENTER))System.out.println("ya");
		//check bass collision
		if (Gdx.input.isKeyPressed(Keys.Q) && (timerPos - lastHitBass > 25 || timerPos - lastHitBass < -25)){
			boolean flag = false;
			long id = bass.play(1.0f);
			lastHitBass = timerPos;
			for (int i = 0; i < song1Bass.size(); i++){
				if (lastHitBass > (song1Bass.get(i).y+5) - 10 && lastHitBass < (song1Bass.get(i).y+5) + 10){
					purple.setColor(0,0,0,1);
					score++;
					flag = true;
				} else if (flag == false){
					
					purple.setColor(purpleC);
				}
			}	
		}
		//check snare collision
		if (Gdx.input.isKeyPressed(Keys.SPACE) && (timerPos - lastHitSnare > 25 || timerPos - lastHitSnare < -25)){
			boolean flag = false;
			long id = snare.play(0.5f);
			lastHitSnare = timerPos;
			for (int i = 0; i < song1Snare.size(); i++){
				if (lastHitSnare > (song1Snare.get(i).y+5) - 10 && lastHitSnare < (song1Snare.get(i).y+5) + 10){
					darkRed.setColor(0,0,0,1);
					score++;
					flag = true;
				} else if (flag == false){
					darkRed.setColor(darkRedC);
				}
			}	
		}
		//check ride collision
		if (Gdx.input.isKeyPressed(Keys.ENTER) && (timerPos - lastHitRide > 25 || timerPos - lastHitRide < -25)){
			boolean flag = false;
			long id = ride.play(1.0f);
			lastHitRide = timerPos;
			for (int i = 0; i < song1Ride.size(); i++){
				if (lastHitRide > (song1Ride.get(i).y+5) - 10 && lastHitRide < (song1Ride.get(i).y+5) + 10){
					blue.setColor(0,0,0,1);
					score++;
					flag = true;
				} else if (flag == false){
					blue.setColor(blueC);
				}
			}	
		}
		if (Gdx.input.isKeyPressed(Keys.F1) && (timerPos - lastHitCrash > 25 || timerPos - lastHitCrash < -25)){
			boolean flag = false;
			long id = crash.play(1.0f);
			lastHitCrash = timerPos;
			for (int i = 0; i < song1Crash.size(); i++){
				if (lastHitCrash > (song1Crash.get(i).y+5) - 10 && lastHitCrash < (song1Crash.get(i).y+5) + 10){
					yellow.setColor(0,0,0,1);
					score++;
					flag = true;
				} else if (flag == false){
					yellow.setColor(yellowC);
				}
			}	
		}
		font.setScale(1.5f);
		font.draw(batch, String.valueOf(score+"  "+totalPossible), 0f, 300f);
		font.draw(batch, "Level: "+currentLevel, -400f, 250f);
		if (currentLevel==1)font.draw(batch, "Q for Bass", -200f, 250f);
		if (currentLevel==2)font.draw(batch, "Space for Snare", -200f, 250f);
		if (currentLevel==3)font.draw(batch, "Enter for Ride", -200f, 250f);
		if (currentLevel==4)font.draw(batch, "Now...SLAP F1 FOR CRASH", - 200F, 250F);
		if (currentLevel==5)font.draw(batch, "STATUS: SLAPMASTER STEVE", - 200F, 250F);
	}
	public int levelSwitcher (int currentScore, int totalPossible){
		int level=currentLevel;
		double cScore = currentScore;
		double tPos = totalPossible;
		double percent = cScore/tPos;
		if (percent >= 0.5)level++;		
		
		
		return level;
	}


}

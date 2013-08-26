package com.jamesfulop.LD27;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

public class Metronome extends TimeSignature {
	Audio audio;
	Sound tap;
	Sound click;
	int timerPos;
	int currentTime = 0;
	Metronome(String timeSignature, int bars) {
		super(timeSignature, bars);
		audio = Gdx.audio;
		tap = Gdx.audio.newSound(Gdx.files.internal("data/tap.wav"));	//Credit to KorgMS2000B
		click = Gdx.audio.newSound(Gdx.files.internal("data/click.wav")); //Credit to KorgMS2000B
		
	}
	public void play (Timer timer){
		timerPos = (int) timer.getRedLine().getX();
		if (timerPos <= -398){long id = click.play(.2f);};
		for (int i = 0; i < beats * bars; i++){
			if (timerPos - beatPos.get(i).y <= 1 && timerPos - beatPos.get(i).y >= -1 
					&& (timerPos - currentTime > 2 || timerPos - currentTime < -2)){
				if (beatPos.get(i).x == 0){
					long id = click.play(.1f);
					currentTime = timerPos;
				}else {
					long id = tap.play(.1f);
					currentTime = timerPos;
				}
			}
		}	
	}
	
	public void dispose() {
		click.dispose();
		tap.dispose();
	}
	
}

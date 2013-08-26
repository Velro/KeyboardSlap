package com.jamesfulop.LD27;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class Song1 {
	static int spacing = TimeSignature.spacing;
	public static ArrayList<ArrayList<Vector2>> Level1 (){
		ArrayList<ArrayList<Vector2>> level1 = new ArrayList<ArrayList<Vector2>>(7);
		level1.add(generateSong1Bass());
		return level1;
	}
	public static ArrayList<ArrayList<Vector2>> Level2 (){
		ArrayList<ArrayList<Vector2>> level1 = new ArrayList<ArrayList<Vector2>>(7);
		level1.add(generateSong1Bass());
		level1.add(generateSong1Snare());
		return level1;
	}
	public static ArrayList<Vector2> generateSong1Bass (){
		ArrayList<Vector2> song1 = new ArrayList<Vector2>();
		song1.add(new Vector2(9f,(1 -1)*spacing-405));
		song1.add(new Vector2(9f,(3 -1)*spacing-405));
		song1.add(new Vector2(9f,(5 -1)*spacing-405));
		song1.add(new Vector2(9f,(6.5f -1)*spacing-405));
		song1.add(new Vector2(9f,(7 -1)*spacing-405));
		song1.add(new Vector2(9f,(9 -1)*spacing-405));
		song1.add(new Vector2(9f,(10.5f-1)*spacing-405));
		song1.add(new Vector2(9f,(11-1)*spacing-405));
		song1.add(new Vector2(9f,(11.5f-1)*spacing-405));
		song1.add(new Vector2(9f,(13f-1)*spacing-405));
		song1.add(new Vector2(9f,(15f-1)*spacing-405));
		song1.add(new Vector2(9f,(15.5f-1)*spacing-405));
		return song1;		
	}
	public static ArrayList<Vector2> generateSong1Snare (){
		ArrayList<Vector2> song1 = new ArrayList<Vector2>();
		song1.add(new Vector2(5f,(2-1)*spacing-405));
		//song1.add(new Vector2(5f,(2.75f-1)*spacing-405));
		song1.add(new Vector2(5f,(4-1)*spacing-405));
		song1.add(new Vector2(5f,(6-1)*spacing-405));
		song1.add(new Vector2(5f,(8-1)*spacing-405));
		song1.add(new Vector2(5f,(10-1)*spacing-405));
		song1.add(new Vector2(5f,(12-1)*spacing-405));
		song1.add(new Vector2(5f,(14-1)*spacing-405));
		song1.add(new Vector2(5f,(14.75f-1)*spacing-405));
		song1.add(new Vector2(5f,(16-1)*spacing-405));;
		return song1;
	}
	public static ArrayList<Vector2> generateSong1Ride (){
		ArrayList<Vector2> song1 = new ArrayList<Vector2>();
		song1.add(new Vector2(6f,(1-1)*spacing-405));
//		song1.add(new Vector2(6f,(1.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(2-1)*spacing-405));
//		song1.add(new Vector2(6f,(2.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(3-1)*spacing-405));
//		song1.add(new Vector2(6f,(3.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(4-1)*spacing-405));
//		song1.add(new Vector2(6f,(4.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(5-1)*spacing-405));
//		song1.add(new Vector2(6f,(5.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(6-1)*spacing-405));
//		song1.add(new Vector2(6f,(6.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(7-1)*spacing-405));
//		song1.add(new Vector2(6f,(7.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(8-1)*spacing-405));
//		song1.add(new Vector2(6f,(8.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(9-1)*spacing-405));
//		song1.add(new Vector2(6f,(9.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(10-1)*spacing-405));
//		song1.add(new Vector2(6f,(10.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(11-1)*spacing-405));
//		song1.add(new Vector2(6f,(11.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(12-1)*spacing-405));
//		song1.add(new Vector2(6f,(12.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(13-1)*spacing-405));
//		song1.add(new Vector2(6f,(13.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(14-1)*spacing-405));
//		song1.add(new Vector2(6f,(14.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(15-1)*spacing-405));
//		song1.add(new Vector2(6f,(15.5f-1)*spacing-405));
		song1.add(new Vector2(6f,(16-1)*spacing-405));
//		song1.add(new Vector2(6f,(16.5f-1)*spacing-405));
		return song1;
	}
	public static ArrayList<Vector2> generateSong1Crash (){
		ArrayList<Vector2> song1 = new ArrayList<Vector2>();
		song1.add(new Vector2(7f,(1f-1)*spacing-405));
		song1.add(new Vector2(7f,(9f-1)*spacing-405));
		song1.add(new Vector2(7f,(5f-1)*spacing-405));
		song1.add(new Vector2(7f,(13f-1)*spacing-405));
		return song1;
	}
	public static ArrayList<Vector2> generateSlapBass(){
		ArrayList<Vector2> song1 = new ArrayList<Vector2>();
		song1.add(new Vector2(7f,(1f-1)*spacing-405));
		song1.add(new Vector2(7f,(2f-1)*spacing-405));
		song1.add(new Vector2(7f,(3f-1)*spacing-405));
		song1.add(new Vector2(7f,(4f-1)*spacing-405));
		song1.add(new Vector2(7f,(5f-1)*spacing-405));
		song1.add(new Vector2(7f,(6f-1)*spacing-405));
		song1.add(new Vector2(7f,(7f-1)*spacing-405));
		song1.add(new Vector2(7f,(8f-1)*spacing-405));
		song1.add(new Vector2(7f,(9f-1)*spacing-405));
		song1.add(new Vector2(7f,(10f-1)*spacing-405));
		song1.add(new Vector2(7f,(11f-1)*spacing-405));
		song1.add(new Vector2(7f,(12f-1)*spacing-405));
		song1.add(new Vector2(7f,(13f-1)*spacing-405));
		song1.add(new Vector2(7f,(14f-1)*spacing-405));
		song1.add(new Vector2(7f,(15f-1)*spacing-405));
		song1.add(new Vector2(7f,(16f-1)*spacing-405));
		return song1;
	}
	public static ArrayList<Vector2> generateSlapSnare(){
		ArrayList<Vector2> song1 = new ArrayList<Vector2>();
		song1.add(new Vector2(7f,(1f-1)*spacing-405));
		song1.add(new Vector2(7f,(2f-1)*spacing-405));
		song1.add(new Vector2(7f,(3f-1)*spacing-405));
		song1.add(new Vector2(7f,(4f-1)*spacing-405));
		song1.add(new Vector2(7f,(5f-1)*spacing-405));
		song1.add(new Vector2(7f,(6f-1)*spacing-405));
		song1.add(new Vector2(7f,(7f-1)*spacing-405));
		song1.add(new Vector2(7f,(8f-1)*spacing-405));
		song1.add(new Vector2(7f,(9f-1)*spacing-405));
		song1.add(new Vector2(7f,(10f-1)*spacing-405));
		song1.add(new Vector2(7f,(11f-1)*spacing-405));
		song1.add(new Vector2(7f,(12f-1)*spacing-405));
		song1.add(new Vector2(7f,(13f-1)*spacing-405));
		song1.add(new Vector2(7f,(14f-1)*spacing-405));
		song1.add(new Vector2(7f,(15f-1)*spacing-405));
		song1.add(new Vector2(7f,(16f-1)*spacing-405));
		return song1;
	}
	public static ArrayList<Vector2> generateSlapRide(){
		ArrayList<Vector2> song1 = new ArrayList<Vector2>();
		song1.add(new Vector2(7f,(1f-1)*spacing-405));
		song1.add(new Vector2(7f,(2f-1)*spacing-405));
		song1.add(new Vector2(7f,(3f-1)*spacing-405));
		song1.add(new Vector2(7f,(4f-1)*spacing-405));
		song1.add(new Vector2(7f,(5f-1)*spacing-405));
		song1.add(new Vector2(7f,(6f-1)*spacing-405));
		song1.add(new Vector2(7f,(7f-1)*spacing-405));
		song1.add(new Vector2(7f,(8f-1)*spacing-405));
		song1.add(new Vector2(7f,(9f-1)*spacing-405));
		song1.add(new Vector2(7f,(10f-1)*spacing-405));
		song1.add(new Vector2(7f,(11f-1)*spacing-405));
		song1.add(new Vector2(7f,(12f-1)*spacing-405));
		song1.add(new Vector2(7f,(13f-1)*spacing-405));
		song1.add(new Vector2(7f,(14f-1)*spacing-405));
		song1.add(new Vector2(7f,(15f-1)*spacing-405));
		song1.add(new Vector2(7f,(16f-1)*spacing-405));
		return song1;
	}
	public static ArrayList<Vector2> generateSlapCrash(){
		ArrayList<Vector2> song1 = new ArrayList<Vector2>();
		song1.add(new Vector2(7f,(1f-1)*spacing-405));
		song1.add(new Vector2(7f,(2f-1)*spacing-405));
		song1.add(new Vector2(7f,(3f-1)*spacing-405));
		song1.add(new Vector2(7f,(4f-1)*spacing-405));
		song1.add(new Vector2(7f,(5f-1)*spacing-405));
		song1.add(new Vector2(7f,(6f-1)*spacing-405));
		song1.add(new Vector2(7f,(7f-1)*spacing-405));
		song1.add(new Vector2(7f,(8f-1)*spacing-405));
		song1.add(new Vector2(7f,(9f-1)*spacing-405));
		song1.add(new Vector2(7f,(10f-1)*spacing-405));
		song1.add(new Vector2(7f,(11f-1)*spacing-405));
		song1.add(new Vector2(7f,(12f-1)*spacing-405));
		song1.add(new Vector2(7f,(13f-1)*spacing-405));
		song1.add(new Vector2(7f,(14f-1)*spacing-405));
		song1.add(new Vector2(7f,(15f-1)*spacing-405));
		song1.add(new Vector2(7f,(16f-1)*spacing-405));
		return song1;
	}
}

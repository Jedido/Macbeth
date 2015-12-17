package GameState;

import java.awt.event.MouseEvent;

import GameState.Part1.*;
import GameState.Part3.*;

public class GameStateManager {

	private GameState[] gameStates;
	private int currentState;
	private int beforeState;
	private int part;
//	private boolean keyboardOnly;
//	private boolean keyboardMouse;
	
	public static final int NUMGAMESTATES = 32;
	public static final int MENUSTATE = 0;
	public static final int PAUSESTATE = 1;
	public static final int HELPSTATE = 2;
	
	//PART 1
	public static final int SCENE1STATE = 3;
	public static final int LEVEL1STATE = 4;
	public static final int SCENE2STATE = 5;
	public static final int SCENE3STATE = 6;
	public static final int LEVEL2STATE = 7;
	public static final int LEVEL3STATE = 8;
	public static final int SCENE4STATE = 9;
	public static final int LEVEL4STATE = 10;
	public static final int SCENE5STATE = 11;
	
	//PART 2
	public static final int SCENE6STATE = 12;
	public static final int LEVEL5STATE = 13;
	public static final int SCENE7STATE = 14;
	public static final int SCENE8STATE = 15;
	public static final int LEVEL6STATE = 16;
	public static final int SCENE9STATE = 17;
	public static final int SCENE10STATE = 18;
	public static final int LEVEL7STATE = 19;
	public static final int LEVEL8STATE = 20;
	public static final int LEVEL9STATE = 21;
	
	//PART 3
	public static final int SCENE11STATE = 22;
	public static final int SCENE12STATE = 23;
	public static final int LEVEL10STATE = 24;
	public static final int SCENE13STATE = 25;
	public static final int LEVEL11STATE = 26;
	public static final int SCENE14STATE = 27;
	public static final int LEVEL12STATE = 28;
	public static final int SCENE15STATE = 29;
	public static final int LEVEL13STATE = 30;
	public static final int EPILOGUESTATE = 31;
	
	public GameStateManager() {
		gameStates = new GameState[NUMGAMESTATES];
		part = 1;
		currentState = MENUSTATE;
		loadState(currentState);
		gameStates[currentState].playMusic();
	}
	
	private void loadState(int state) {
		if(state == 11 && part == 1)
			part = 2;
		if(state == 31 && part == 2)
			part = 3;
		gameStates[state] = getCorrespondingState(state);
	}
	
	private void unloadState(int state) {
		gameStates[state] = null;
	}
	
	public void setState(int state) {
		loadState(state);
		gameStates[currentState].stopMusic();
		unloadState(currentState);
		currentState = state;
		gameStates[currentState].playMusic();
	}
	
	public void setState(int state, int before) {
		beforeState = before;
		gameStates[currentState].stopMusic();
		loadState(state);
		currentState = state;
	}

	
	public int getBefore() {
		return beforeState;
	}
	
	public void setStateRestart(int state) {
		gameStates[currentState] = getCorrespondingState(state);
	}
	
	public void update() {
		try {
			gameStates[currentState].update();
		} catch(Exception e) {}
	}
	
	public void draw(java.awt.Graphics2D g) {
		gameStates[currentState].draw(g);
	}
	
	public void keyPressed(int k) {
		gameStates[currentState].keyPressed(k);
	}
	
	public void keyReleased(int k) {
		gameStates[currentState].keyReleased(k);
	}
	
	public void mouseMoved(MouseEvent e) {
		gameStates[currentState].mouseMoved(e);
	}
	
	public void mouseClicked(MouseEvent e) {
		gameStates[currentState].mouseClicked(e);
	}
	
	public void newGame() {
		currentState = MENUSTATE;
	}
	
	public GameState getCorrespondingState(int state) {
		if(state == MENUSTATE)
			return new MenuState(this);
		
		if(state == PAUSESTATE)
			return new PauseState(this);
		
		if(state == HELPSTATE)
			return new HelpState(this);
		
		if(state == SCENE1STATE)
			return new Scene1State(this);
		
		if(state == LEVEL1STATE)
			return new Level1State(this);
		
		if(state == SCENE2STATE)
			return new Scene2State(this);
		
		if(state == SCENE3STATE)
			return new Scene3State(this);

		if(state == LEVEL2STATE)
			return new Level2State(this);
		
		if(state == LEVEL3STATE)
			return new Level3State(this);
		
		if (state == SCENE4STATE)
			return new Scene4State(this);
		
		if(state == LEVEL4STATE)
			return new Level4State(this);
		
		if(state == SCENE5STATE)
			return new Scene5State(this);
		
		if (state == SCENE6STATE)
			return new MenuState(this);

		if(state == SCENE11STATE)
			return new Scene11State(this);
		
		if(state == SCENE12STATE)
			return new Scene12State(this);
		
		if(state == LEVEL10STATE)
			return new Level10State(this);
		
		if(state == SCENE13STATE)
			return new Scene13State(this);
		
		if(state == LEVEL11STATE)
			return new Level11State(this);
		
		if(state == SCENE14STATE)
			return new Scene14State(this);
		
		if(state == LEVEL12STATE)
			return new Level12State(this);
		
		if(state == SCENE15STATE)
			return new Scene15State(this);
		
		if(state == LEVEL13STATE)
			return new Level13State(this); 
			
		if(state == EPILOGUESTATE)
			return new PrologueState(this);
		
		//IF NONE (Shouldn't happen)
		System.out.println("ERROR: Could not find state");
		return new MenuState(this);
	}
	
	public int getPart() {
		return part;
	}
}

package GameState.Part1;

import GameState.*;

public class Scene1State extends SceneState {
	
	public Scene1State(GameStateManager gsm) {
		super(gsm);
		titlex = 55;
		setIntro("The Prophecy's Motivation", 120, 1);
	}

	public int getIndex() {
		return GameStateManager.SCENE1STATE;
	}
	
	public int nextState() {
		return GameStateManager.LEVEL1STATE;
	}
	
	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Scene 1", "\"Witches\"", "", "", "", "", "", "", 
				"It all began with the witches.\n"
				+ "\"All hail, Macbeth! Hail to thee, Thane of Glamis!\"", 
				"", 
				"I did not believe them at first.\n" 
				+ "\"All hail, Macbeth! Hail to thee, Thane of Cawdor!\"", 
				"",
				"But I dearly wished it to be true.\n"
				+ "\"All hail, Macbeth, that shalt be king hereafter!\"", 
				"",
				"So what could possibly be better...",
				"\"Banquo shalt get kings, though thou be none.\n"
				+ "So all hail, Macbeth and Banquo!\"", 
				"",
				"...than making that wish a reality?"
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/witches.mp3";
	}
}

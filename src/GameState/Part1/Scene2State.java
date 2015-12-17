package GameState.Part1;

import GameState.*;

public class Scene2State extends SceneState{
	
	public Scene2State(GameStateManager gsm) {
		super(gsm);
		titlex = 80;
	}
	
	public int getIndex() {
		return GameStateManager.SCENE2STATE;
	}

	public int nextState() {
		return GameStateManager.SCENE3STATE;
	}
	
	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Scene 2", "\"King Duncan\"", "", "", "", "", "", "", 
				"When I returned from the battlefield, my king greeted\n"
				+ "Banquo and me with open arms. He thanked us for our work.", 
				"", 
				"\"Today is a joyous day.\"" ,
				"\"What is it, your Highness?\"", 
				"\"I have named my successor.\"",
				"\"Who has been chosen?\" I asked excitedly.",
				"\"Ma-\" I shook with anticipation. Were the witches correct?",
				"\"-lcom, Malcolm!\"",
				"It was not I, the Prince of Cumberland. Of course it was not.",
				"But I would not give up.",
				"Stars, hide your fires;\n"
				+ "Let not light see my black and deep desires.",
				"",
				"The eye wink at the hand, yet let that be\n"
				+ "which the eye fears, when it is done, to see."
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/kingdom.mp3";
	}
}

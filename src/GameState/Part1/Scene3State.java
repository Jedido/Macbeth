package GameState.Part1;

import GameState.*;

public class Scene3State extends SceneState {

	public Scene3State(GameStateManager gsm) {
		super(gsm);
		titlex = 65;
	}

	public int getIndex() {
		return GameStateManager.SCENE3STATE;
	}
	
	public int nextState() {
		return GameStateManager.LEVEL2STATE;
	}

	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Scene 3", "\"The Lady\"", "", "", "", "", "", "", 
				"After that, I returned home to my wife, who had already\n"
				+ "received notice of my decision. It was the perfect time\n"
				+ "to carry out the plan, for Duncan was going to visit my\n"
				+ "residence that night.", 
				"", 
				"",
				"", 
				"The Lady told me:",
				"\"Look like th'innocent flower,\n "
				+ "but be the serpent under't.\"", 
				"",
				"But I was not capable of carrying out such a plan.",
				"\"How can I accomplish that?\" I asked.",
				"\"There is something you must obtain...\"",
				"\"What is it?\"",
				"\"Factor M. It makes it possible to do what seems impossible.\"\n"
				+ "M...like Macbeth.",
				"",
				"\"Where is it?\"",
				"\"Over there.\" She points to another room."
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/night2.mp3";
	}
}

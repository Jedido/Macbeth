package GameState.Part3;

import GameState.*;

public class Scene14State extends SceneState {

	public Scene14State(GameStateManager gsm) {
		super(gsm);
		titlex = 105;
	}

	public int getIndex() {
		return GameStateManager.SCENE14STATE;
	}
	
	public int nextState() {
		return GameStateManager.LEVEL12STATE;
	}
	
	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Scene 4", "\"Young Siward\"", "", "", "", "", "", "", 
				"I advance quickly to the battlefield. All of woman born\n"
				+ "cannot harm me. I have nothing to fear.",
				"",
				"\"Who are you?\" I turn at the sound of a voice.",
				"\"You'll be afraid to hear my name.\"",
				"\"There is no such name.\"",
				"\"My name's Macbeth.\" He draws his sword.",
				"\"The devil himself could not pronounce a title\n"
				+ "More hateful to mine ear.\" The young man charges,",
				"",
				"\"I challenge you!\""
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/battle3.mp3";
	}
}

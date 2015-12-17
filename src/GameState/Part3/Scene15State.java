package GameState.Part3;

import GameState.*;

public class Scene15State extends SceneState {

	public Scene15State(GameStateManager gsm) {
		super(gsm);
		titlex = 65;
		bgMusic.play();
	}

	public int getIndex() {
		return GameStateManager.SCENE15STATE;
	}
	
	public int nextState() {
		return GameStateManager.LEVEL13STATE;
	}
	
	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Scene 5", "\"Macduff\"", "", "", "", "", "", "", 
				"I sheathe my sword.",
				"\"Thou wast born of woman.\n"
				+ "But swords I smile at, weapons laugh  to scorn,\n"
				+ "Brandished by man that's of woman born.\n"
				+ "cannot harm me. I have nothing to fear.\"",
				"",
				"",
				"",
				"I leave the man whose name I know not.",
				"I crave for more battle.",
				"",
				"",
				"And here Macduff is before me.",
				"\"Macbeth! You will die here!\" I laugh.",
				"\"I bear a charmed life, which must not yield\n"
				+ "To one of woman born.\"",
				"",
				"\"Despair thy charm.\n"
				+ "I was untimely ripped from the womb, my mother\n"
				+ "dead.\" How is that possible?",
				"",
				"",
				"\"You lie!\" I snarl.",
				"\"Then I shall show you with my sword!\"",
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/final.mp3";
	}
}

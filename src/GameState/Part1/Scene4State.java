package GameState.Part1;

import GameState.*;

public class Scene4State extends SceneState {

	public Scene4State(GameStateManager gsm) {
		super(gsm);
		titlex = 75;
	}

	public int getIndex() {
		return GameStateManager.SCENE4STATE;
	}
	
	public int nextState() {
		return GameStateManager.LEVEL4STATE;
	}

	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Scene 4", "\"Preparation\"", "", "", "", "", "", "", 
				"It was time. The moon’s weak light did not reach the\n"
				+ "dark hallways.",
				"",
				"The Lady was right. I could feel the power flowing in me.",
				"Factor M proved to bolster my courage and power.",
				"Dagger at my side, I steeled myself.", 
				"The Lady was going to give me an opening-",
				"Someone was here.",
				"He called out before me.",
				"\"Who’s there?\" Banquo appeared with a torch.", 
				"\"A friend.\" I lowered my guard. There was no reason\n"
				+ "to fight him. In fact...",
				"",
				"\"What, sir, not yet at rest? The king is pleased with\n"
				+ "your hospitality.\" He handed me a diamond. \"Take it.\n"
				+ "It’s from the king.\"",
				"",
				"",
				"\"Why, thank you. So, how are you?\"",
				"\"All’s well. I dreamt of the witches last night.\"",
				"\"I think not of them. Say, there is a matter I would\n"
				+ "like to talk about, but it is not for now. If you had\n"
				+ "the time, I would like to discuss it with you.\"", 
				"",
				"",
				"Banquo would have made a great ally. ",
				"\"Understood. If it will not break my loyalty nor break\n"
				+ "my conscience, I will listen.\"",
				"",
				"But he wasn't my ally.",
				"\"Good repose the while.\"",
				"\"Thanks, sir. The like to you.\" Banquo left.",
				"The bell rang. I urged my servant to attend my wife. I\n"
				+ "was now alone, and it was time I began."
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/mystery.mp3";
	}
}

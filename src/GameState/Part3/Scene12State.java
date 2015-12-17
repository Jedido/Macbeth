package GameState.Part3;

import GameState.*;

public class Scene12State extends SceneState {

	public Scene12State(GameStateManager gsm) {
		super(gsm);
		titlex = 65;
	}

	public int getIndex() {
		return GameStateManager.SCENE12STATE;
	}
	
	public int nextState() {
		return GameStateManager.LEVEL11STATE;
	}
	
	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Scene 2", "\"Mad Lady\"", "", "", "", "", "", "", 
				"The prophecies protect me. Fate decrees that I will not\n"
				+ "die so easily. Even if Malcolm attacks, I will not fall.",
				"",
				"I do not fear them. I have the power of Factor M in addition\n"
				+ "to the witches' prophecies.",
				"",
				"I will rule until the wood come to Dunsinane. ",
				"And that will not happen.",
				"On the other hand, the Lady's condition is deteriorating.\n",
				"\"How does your patient, doctor?\"",
				"\"It is not a sickness. It is something else.\"",
				"\"Cure her of that. You are a doctor, no?\"",
				"\"She must find the remedy herself.\"",
				"\"I have no time for this. Search for it! I must prepare\n"
				+ "for battle. As long as I protect this place, Dunsinane,\n"
				+ "I will not fall.\""
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/kingdom.mp3";
	}
}

package GameState.Part3;

import GameState.*;

public class Scene11State extends SceneState {

	public Scene11State(GameStateManager gsm) {
		super(gsm);
		titlex = 85;
		setIntro("Prophecy Fulfilled", 70, 3);
	}

	public int getIndex() {
		return GameStateManager.SCENE11STATE;
	}
	
	public int nextState() {
		return GameStateManager.SCENE12STATE;
	}
	
	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Scene 1", "\"King's Return\"", "", "", "", "", "", "", 
				"\"I cannot do it.\" Malcom hangs his head.",
				"\"You must. Macbeth has yet to target you,\" Macduff \n"
				+ "replies.",
				"",
				"\"I am not fit for such a role.\"",
				"\"Compared to Macbeth, you are pure. No one is more evil.\"",
				"\"I grant him bloody, \n"
				+ "Luxurious, avaricious, false, deceitful,\n"
				+ "Sudden, malicious, smacking of every sin. But I,\"",
				"",
				"",
				"Malcolm turns to face Macduff, \"My sins are boundless.\"",
				"\"That is mere speculation. There are great virtues in you.\"",
				"\"But I have none. The king-becoming graces,",
				"As justice, verity, temp'rance, stableness,",
				"Bounty, perseverance, mercy, lowliness,",
				"Devotion, patience, courage, fortitude,",
				"I have no relish of them.\"",
				"\"O Scotland, Scotland! -Thy royal father\n"
				+ "Was a most sainted king. The Queen that bore thee,\n"
				+ "Oft'ner upon her knees than on her feet,",
				"",
				"",
				"Died every day she lived.",
				"Fare thee well! Thy hope ends here!\"",
				"\"No, it is not true. There is a plan-I have a plan.\""
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/sorrow.mp3";
	}
}

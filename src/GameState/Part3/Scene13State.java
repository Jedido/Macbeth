package GameState.Part3;

import GameState.*;

public class Scene13State extends SceneState {

	public Scene13State(GameStateManager gsm) {
		super(gsm);
		titlex = 105;
	}

	public int getIndex() {
		return GameStateManager.SCENE13STATE;
	}
	
	public int nextState() {
		return GameStateManager.LEVEL11STATE;
	}
	
	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Scene 3", "\"Birnam Wood\"", "", "", "", "", "", "", 
				"Malcolm and the soldiers arrive at the edge of the forest.",
				"\"What wood is this before us?\" Siward asks.",
				"Mentieth answers, \"The wood of Birnam.\"",
				"\"Let us all take some wood to disguise our numbers to\n"
				+ "catch them off guard.\"",
				"",
				"\"It shall be done.\"",
				"",
				"~",
				"",
				"A cry sounds out. \"What is happening?\"",
				"\"It is the cry of women, my good lord.\"",
				"\"Go check it out.\" Seyton leaves the room and returns\n"
				+ "promptly.",
				"",
				"\"The Queen, my lord, is dead.\" Seyton bows his head.",
				"There is no time for mourning. I have to prepare-",
				"A messenger comes in.",
				"\"What is it now!?\n",
				"",
				"\"I looked toward Birnam and anon methought\n"
				+ "The wood began to move.\"",
				"",
				"\"Liar and slave!\"",
				"\"It is what I saw. The grove was moving.\"",
				"Miracles have begun.",
				"The prophecy dictates me to give up my throne, but I will\n"
				+ "not concede.",
				"",
				"I shall fight."
		};
		return a;
	}

	@Override
	public String getMusic() {
		return "/Music/scene13.mp3";
	}
}

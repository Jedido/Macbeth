package GameState.Part2;

import GameState.*;

public class Scene6State extends SceneState {

	public Scene6State(GameStateManager gsm) {
		super(gsm);
		titlex = 125;
		setIntro("Fear of the Prophecy", 155, 2);
		bgMusic.play();
	}

	public int getIndex() {
		return GameStateManager.SCENE5STATE;
	}
	
	public int nextState() {
		return GameStateManager.LEVEL5STATE;
	}

	
	@Override
	public String[] getStory() {
		String[] a =  {
				"", "Scene 1", "\"title here\"", "", "", "", "", "", "", 
				"start text here",
		};
		return a;
	}

	@Override
	public String getMusic() {
		// TODO Auto-generated method stub
		return null;
	}
}

package GameState;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Audio.AudioPlayer;

public abstract class GameState{

	protected int currentChoice = 4;
	protected AudioPlayer bgMusic = new AudioPlayer(getMusic());
	
	protected GameStateManager gsm;
	public static final Font TITLEFONT = new Font("Trebuchet MS", Font.ITALIC, 40);
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(java.awt.Graphics2D g);
	public void keyPressed(int k) {
//		if(k == KeyEvent.VK_P)
//			gsm.setState(GameStateManager.PAUSESTATE, getIndex());
		if(k == KeyEvent.VK_ESCAPE)
			gsm.setState(GameStateManager.MENUSTATE);
	}
	public abstract void keyReleased(int k);
	public abstract int getIndex();	
	public abstract String getMusic();

	
	public void stopMusic() {
		if(bgMusic != null)
			bgMusic.close();
	}
	public void playMusic() {
		if(bgMusic != null)
			bgMusic.play();
	}
	
	public abstract void mouseMoved(MouseEvent e);
	
	public abstract void mouseClicked(MouseEvent e);
	
}

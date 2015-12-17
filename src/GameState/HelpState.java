package GameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class HelpState extends GameState {

	private GameStateManager gsm;
	
	public HelpState(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ESCAPE)
			gsm.setState(gsm.getBefore());
	}
	
	@Override
	public void keyReleased(int k) {
		
	}

	@Override
	public int getIndex() {	return GameStateManager.HELPSTATE; }

	public void select() {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	public String getMusic() {
		return null;
	}
}

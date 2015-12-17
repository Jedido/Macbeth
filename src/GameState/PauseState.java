package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Main.GamePanel;

public class PauseState extends GameState{

	private GameStateManager gsm;

	private boolean onOption;
	private boolean once;
	private int currentChoice = 0;
	private Font font;
	private String[] options = {"Resume", "Restart", "Help", "Back To Menu"};
	
	public PauseState(GameStateManager gsm)
	{
		this.gsm = gsm;
		font = new Font("Trebuchet", Font.BOLD, 24);
	}
	
	@Override
	public void init() {
		once = true;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics2D g) {
		// clear bg
		if(once)
			g.setColor(new Color(0, 0, 0, 200));
		else
			g.setColor(new Color(0, 0, 0, 0));
		once = false;
		
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		
		// draw menu options
		g.setFont(font);
		for(int i  = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.WHITE);;
			}
			else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 240, 220 + i * 30);
		}
	}

	public void select() {
		if(currentChoice == 0) {
			gsm.setState(gsm.getBefore());
		}
		if(currentChoice == 1) {
			gsm.setStateRestart(gsm.getBefore());
		}
		if(currentChoice == 2) {
			//
		}
		if(currentChoice == 3) {
			gsm.newGame();
		}
	}
	
	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER) {
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
		if(k == KeyEvent.VK_ESCAPE) {
			gsm.newGame();
		}
	}

	@Override
	public void keyReleased(int k) {
		
	}
	
	public int getIndex() {
		return GameStateManager.PAUSESTATE;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int y = e.getY();
		int x = e.getX();
		if(y > 210 && y < 240 && x > 240 && x < 360) {
			currentChoice = 0;
			onOption = true;
		}
		else if(y >= 240 && y < 270 && x > 240 && x < 360) {
			currentChoice = 1;
			onOption = true;
		}
		else if(y >= 270 && y < 300 && x > 240 && x < 360) {
			currentChoice = 2;
			onOption = true;
		}
		else if(y >= 300 && y < 330 && x > 240 && x < 360) {
			currentChoice = 3;
			onOption = true;
		}
		else
			onOption = false;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(onOption)
			select();
		e.consume();
	}

	public String getMusic() {
		return null;
	}
}

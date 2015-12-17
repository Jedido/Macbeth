package GameState;

import TileMap.Background;

import java.awt.*;
import java.awt.event.*;

public class MenuState extends GameState{
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {"Start/Continue", "Stage Select", "Help", "Quit"};
	private boolean onOption = false;
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Backgrounds/menubg" + gsm.getPart() + ".gif", 1);
			bg.setVector(0, 0);
			
			font = new Font("Kristen ITC", Font.BOLD, 20);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		bg.update();
	}

	@Override
	public void draw(Graphics2D g) {
		
		//draw bg
		bg.draw(g);
		
		// draw menu options
		g.setFont(font);
		for(int i  = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.GRAY);
			}
			else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 20, 365 + i * 30);
		}
		
		// draw name
		g.setColor(Color.BLACK);
		g.setFont(new Font("Impact", Font.PLAIN, 15));
		g.drawString("Jed Chen", 570, 470);
	}

	public void select() {
		if(currentChoice == 0) {
			if(gsm.getPart() == 1)
				gsm.setState(GameStateManager.SCENE1STATE);
			else if(gsm.getPart() == 2)
				gsm.setState(GameStateManager.SCENE11STATE);
			else
				gsm.setState(GameStateManager.SCENE11STATE);
		}
		if(currentChoice == 1) {
			//
		}
		if(currentChoice == 2) {
			
		}
		if(currentChoice == 3) {
			System.exit(0);
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
		if(k == KeyEvent.VK_K){
			gsm.setState(GameStateManager.LEVEL13STATE);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		int y = e.getY();
		int x = e.getX();
		if(y > 345 && y < 375 && x < 180) {
			currentChoice = 0;
			onOption = true;
		}
		else if(y >= 375 && y < 405 && x < 160) {
			currentChoice = 1;
			onOption = true;
		}
		else if(y >= 405 && y < 430 && x < 70) {
			currentChoice = 2;
			onOption = true;
		}
		else if(y >= 430 && y < 455 && x < 70) {
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
	
	@Override
	public void keyReleased(int k) {
	}

	public int getIndex() {
		return GameStateManager.MENUSTATE;
	}
	
	public String getMusic() {
		return "/Music/menu.mp3";
	}
	
	public void setBG(String s) {
		bg = new Background(s, 1);
	}
}

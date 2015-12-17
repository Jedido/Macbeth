package GameState.Part1;

import java.awt.event.KeyEvent;

import Entity.Enemies.*;
import Entity.Objects.*;
import GameState.*;
import Main.GamePanel;

public class Level1State extends LevelState {
	
	private Crate crate;
	private HumanEnemy enemy;
	private int[][] p = {{700, 100}, {1200, 200}};
	
	public Level1State(GameStateManager gsm) {
		super(gsm);
		xcheck = xstart = 200;
		ycheck = ystart = 200;
		titlex = GamePanel.WIDTH/2 - 104;

		init();
	}

	@Override
	public void init() {
		super.init();
		
		// factor m
		player.setM(0);
		
		// enemies
		if(enemy == null || !enemy.isDead())
			enemy = new Male(tileMap);
		enemy.setPosition(p[0][0], p[0][1]);
		enemies.add(enemy);
		
		// crates
		crate = new Crate(tileMap, player);
		crate.setPosition(p[1][0], p[1][1]);
		crates.add(crate);
		
		// objects
		objects.add(crate);
		updateCheckpoint();
	}
	
	@Override
	public void update() {
		super.update();
		
		p[0][0] = enemy.getx();
		p[0][1] = enemy.gety();
		p[1][0] = crate.getx();
		p[1][1] = crate.gety();
		
		if(player.getx() >= 2725 && player.getx() <= 2735 && player.gety() == 390) {
			gsm.setState(GameStateManager.SCENE2STATE);
			return;
		}
	}

	public int getIndex() {
		return GameStateManager.LEVEL1STATE;
	}

	@Override
	public String getTitle() {
		return "Tutorial 1";
	}
	
	public String getMap() {
		return "/Maps/level1-1.map";
	}
	
	public String getMMap() {
		return "/Maps/level1-1.map";
	}
	
	public String getTileMap() {
		return "/Tilesets/tutorial1.gif";
	}
	
	public String getMTileMap() {
		return "/Tilesets/tutorial1.gif";
	}

	@Override
	public void keyPressed(int k) {
//		if(k == KeyEvent.VK_P)
//			gsm.setState(GameStateManager.PAUSESTATE, getIndex());
//		if(k == KeyEvent.VK_ESCAPE)
//			gsm.setState(GameStateManager.PAUSESTATE, getIndex());
		if(k == KeyEvent.VK_LEFT) player.setLeft(true);
		if(k == KeyEvent.VK_RIGHT) player.setRight(true); 
		if(k == KeyEvent.VK_UP) player.setUp(true);
		if(k == KeyEvent.VK_DOWN) player.setDown(true);
		if(k == KeyEvent.VK_SPACE) player.setJumping(true);
		if(k == KeyEvent.VK_S) player.setScratching();
	}

	@Override
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) player.setRight(false); 
		if(k == KeyEvent.VK_UP) player.setUp(false);
		if(k == KeyEvent.VK_DOWN) player.setDown(false);
		if(k == KeyEvent.VK_SPACE) player.setJumping(false);
	}

	@Override
	public String getMusic() {
		return "/Music/battle.mp3";
	}
}

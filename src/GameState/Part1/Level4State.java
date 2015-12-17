package GameState.Part1;

import Entity.Enemies.*;
import Entity.Objects.*;
import GameState.*;
import Main.GamePanel;

public class Level4State extends LevelState {

	private HumanEnemy enemy1;
	private HumanEnemy enemy2;
	private HumanEnemy enemy3;
	private HumanEnemy enemy4;
	
	private int[][] p = {{900, 840}, {1000, 840}, {900, 840}, {600, 330}};
	
	public Level4State(GameStateManager gsm) {
		super(gsm);
		xcheck = xstart = 150;
		ycheck = ystart = 840;
		titlex = GamePanel.WIDTH/2 - 104;
		init();
	}

	@Override
	public void init() {
		super.init();
		
		// factor m
		player.setM(0);
		
		// enemies
		if(enemy1 == null || !enemy1.isDead())
			enemy1 = new Male(tileMap);
		enemy1.setPosition(p[0][0], p[0][1]);
		enemies.add(enemy1);
		
		if(enemy2 == null || !enemy2.isDead())
			enemy2 = new Male(tileMap);
		enemy2.setSpeed(2);
		enemy2.setPosition(p[1][0], p[1][1]);
		enemies.add(enemy2);
		
		if(enemy3 == null || !enemy3.isDead())
			enemy3 = new Male(tileMap);
		enemy3.setSpeed(0);
		enemy3.setPosition(p[2][0], p[2][1]);
		enemies.add(enemy3);
		
		if(enemy4 == null || !enemy4.isDead())
			enemy4 = new Male(tileMap);
		enemy4.setSpeed(0);
		enemy4.setPosition(p[3][0], p[3][1]);
		enemies.add(enemy4);
		
		// objects
		Door d1 = new Door(tileMap, player);
		d1.setPosition(940, 390);
		d1.setClosed();
		objects.add(d1);
		
		Key k1 = new Key(tileMap, player);
		k1.setPosition(1410, 870);
		keys.add(k1);
		
		for(int i = 0; i < 16; i++) {
			spikes.add(new Spikes(tileMap, player, 2));
			spikes.get(i).setPosition(90 + 60 * i, 570);
		}
		
		for(int i = 0; i < spikes.size(); i++)
			objects.add(spikes.get(i));
		for(int i = 0; i < ladders.size(); i++)
			objects.add(ladders.get(i));
		
	}
	
	public void update() {
		super.update();

		p[0][0] = enemy1.getx();
		p[0][1] = enemy1.gety();
		p[1][0] = enemy2.getx();
		p[1][1] = enemy2.gety();
		p[2][0] = enemy3.getx();
		p[2][1] = enemy3.gety();
		p[3][0] = enemy4.getx();
		p[3][1] = enemy4.gety();
		
		if(player.getx() < 300 && player.gety() < 480)
			gsm.setState(GameStateManager.SCENE5STATE);
	}

	public int getIndex() {
		return GameStateManager.LEVEL4STATE;
	}

	@Override
	public String getTitle() {
		return "Assassination";
	}
	
	public String getMap() {
		return "/Maps/level1-4.map";
	}
	public String getMMap() {
		return "/Maps/level1-4m.map";
	}
	public String getTileMap() {
		return "/Tilesets/default.gif";
	}
	
	public String getMTileMap() {
		return "/Tilesets/defaultm.gif";
	}

	@Override
	public String getMusic() {
		return "/Music/battle2.mp3";
	}
}

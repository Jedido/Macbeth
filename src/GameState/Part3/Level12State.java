package GameState.Part3;

import Entity.Enemies.*;
import Entity.Objects.*;
import GameState.*;
import Main.GamePanel;

public class Level12State extends LevelState {

	private HumanEnemy enemy1;
	private HumanEnemy enemy2;
	private HumanEnemy enemy3;
	private HumanEnemy enemy4;
	private HumanEnemy siward;
	private Crate crate;
	private int[][] p = {{600, 390}, {580, 390}, {1230, 390}, {2900, 390}, {2900, 100}, {1350, 30}};
	
	public Level12State(GameStateManager gsm) {
		super(gsm);
		xcheck = xstart = 90;
		ycheck = ystart = 360;
		titlex = GamePanel.WIDTH/2 - 104;
		init();
	}

	@Override
	public void init() {
		super.init();
		
		// enemies
		if(enemy1 == null || !enemy1.isDead())
			enemy1 = new Male(tileMap);
		enemy1.setPosition(p[0][0], p[0][1]);
		enemies.add(enemy1);
		
		if(enemy2 == null || !enemy2.isDead())
			enemy2 = new Male(tileMap);
		enemy2.setSpeed(3);
		enemy2.setPosition(p[1][0], p[1][1]);
		enemies.add(enemy2);
		
		if(enemy3 == null || !enemy3.isDead())
			enemy3 = new Male(tileMap);
		enemy3.setSpeed(2);
		enemy3.setPosition(p[2][0], p[2][1]);
		enemies.add(enemy3);

		if(enemy4 == null || !enemy4.isDead())
			enemy4 = new Male(tileMap);
		enemy4.setSpeed(2);
		enemy4.setPosition(p[3][0], p[3][1]);
		enemies.add(enemy4);
		
		if(siward == null || !siward.isDead())
			siward = new Siward(tileMap);
		siward.setSpeed(0);
		siward.setPosition(p[4][0], p[4][1]);
		enemies.add(siward);
		
		crate = new Crate(tileMap, player);
		crate.setPosition(p[5][0], p[5][1]);
		crates.add(crate);
		objects.add(crate);
		
		Checkpoint check1 = new Checkpoint(tileMap, player);
		check1.setPosition(810, 210);
		checkpoints.add(check1);
		Checkpoint check2 = new Checkpoint(tileMap, player);
		check2.setPosition(1530, 390);
		checkpoints.add(check2);
		
		Door d1 = new Door(tileMap, player);
		d1.setPosition(2430, 270);
		d1.setClosed();
		objects.add(d1);

		Door d2 = new Door(tileMap, player);
		d2.setPosition(2430, 390);
		d2.setClosed();
		objects.add(d2);
		
		Key k1 = new Key(tileMap, player);
		k1.setPosition(210, 150);
		keys.add(k1);
		
		for(int i = 0; i < 8; i+=2)
		{
			ladders.add(new Ladder(tileMap, player));
			ladders.get(i).setPosition(1650, 210 + (i/2) * 60);
			ladders.add(new Ladder(tileMap, player));
			ladders.get(i + 1).setPosition(2370, 210 + (i/2) * 60);
		}
		
		Spikes s1 = new Spikes(tileMap, player, 0);
		s1.setPosition(390, 330);
		spikes.add(s1);
		Spikes s2 = new Spikes(tileMap, player, 0);
		s2.setPosition(1770, 390);
		spikes.add(s2);
		
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
		p[4][0] = siward.getx();
		p[4][1] = siward.gety();
		
		if(siward.isDead()) {
			gsm.setState(GameStateManager.SCENE15STATE);
		}
	}

	public int getIndex() {
		return GameStateManager.LEVEL12STATE;
	}

	@Override
	public String getTitle() {
		return "Kill Siward";
	}
	
	public String getMap() {
		return "/Maps/level3-3.map";
	}
	public String getMMap() {
		return "/Maps/level3-3m.map";
	}
	public String getTileMap() {
		return "/Tilesets/default.gif";
	}
	
	public String getMTileMap() {
		return "/Tilesets/defaultm.gif";
	}

	@Override
	public String getMusic() {
		return "/Music/battle4.mp3";
	}
}

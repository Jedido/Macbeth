package GameState.Part3;

import Entity.Enemies.*;
import Entity.Objects.*;
import GameState.*;
import Main.GamePanel;

public class Level10State extends LevelState {

	private HumanEnemy enemy1;
	private HumanEnemy enemy2;
	private HumanEnemy enemy3;
	private Crate crate;
	private int[][] p = {{270, 450}, {270, 210}, {1050, 210}, {450, 30}};
	
	public Level10State(GameStateManager gsm) {
		super(gsm);
		xcheck = xstart = 210;
		ycheck = ystart = 440;
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
		enemy2.setSpeed(0);
		enemy2.setPosition(p[1][0], p[1][1]);
		enemies.add(enemy2);
		
		if(enemy3 == null || !enemy3.isDead())
			enemy3 = new Male(tileMap);
		enemy3.setSpeed(0);
		enemy3.setPosition(p[2][0], p[2][1]);
		enemies.add(enemy3);
		
		crate = new Crate(tileMap, player);
		crate.setPosition(p[3][0], p[3][1]);
		crates.add(crate);
		objects.add(crate);
		
		Checkpoint check1 = new Checkpoint(tileMap, player);
		check1.setPosition(810, 150);
		checkpoints.add(check1);
		Checkpoint check2 = new Checkpoint(tileMap, player);
		check2.setPosition(1770, 210);
		checkpoints.add(check2);
		
		Door d1 = new Door(tileMap, player);
		d1.setPosition(2370, 450);
		d1.setClosed();
		objects.add(d1);
		
		Key k1 = new Key(tileMap, player);
		k1.setPosition(2580, 150);
		keys.add(k1);
		
		for(int i = 0; i < 11; i++)
		{
			spikes.add(new Spikes(tileMap, player, 0));
			spikes.get(i).setPosition(1110 + i * 60, 510);
		}

		spikeBox(33, 6);
		spikeBox(37, 6);
		
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
		
		if(player.getx() > 2580 && player.gety() >= 320)
			gsm.setState(GameStateManager.SCENE13STATE);
	}

	public int getIndex() {
		return GameStateManager.LEVEL10STATE;
	}

	@Override
	public String getTitle() {
		return "Dunsinane";
	}
	
	public String getMap() {
		return "/Maps/level3-1.map";
	}
	public String getMMap() {
		return "/Maps/level3-1m.map";
	}
	public String getTileMap() {
		return "/Tilesets/default.gif";
	}
	
	public String getMTileMap() {
		return "/Tilesets/defaultm.gif";
	}

	@Override
	public String getMusic() {
		return "/Music/uprising.mp3";
	}
}

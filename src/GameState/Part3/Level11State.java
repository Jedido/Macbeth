package GameState.Part3;

import Entity.Enemies.*;
import Entity.Objects.*;
import GameState.*;
import Main.GamePanel;

public class Level11State extends LevelState {

	private HumanEnemy enemy1;
	private HumanEnemy enemy2;
	private HumanEnemy enemy3;
	private HumanEnemy enemy4;
	private int[][] p = {{600, 510}, {580, 510}, {630, 510}, {150, 150}};
	
	public Level11State(GameStateManager gsm) {
		super(gsm);
		xcheck = xstart = 550;
		ycheck = ystart = 200;
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
		
		Checkpoint check1 = new Checkpoint(tileMap, player);
		check1.setPosition(750, 450);
		checkpoints.add(check1);
		Checkpoint check2 = new Checkpoint(tileMap, player);
		check2.setPosition(150, 1290);
		checkpoints.add(check2);
		
		Door d1 = new Door(tileMap, player);
		d1.setPosition(40, 1110);
		d1.setClosed();
		objects.add(d1);
		
		Key k1 = new Key(tileMap, player);
		k1.setPosition(810, 1170);
		keys.add(k1);
		
		for(int i = 0; i < 5; i++)
		{
			ladders.add(new Ladder(tileMap, player));
			ladders.get(i).setPosition(330, 510 + i * 60);
		}

		for(int i = 0; i < 7; i++)
		{
			spikes.add(new Spikes(tileMap, player, 0));
			spikes.get(i).setPosition(450 + i * 60, 990);
		}
		for(int i = 7; i < 20; i++)
		{
			spikes.add(new Spikes(tileMap, player, 0));
			spikes.get(i).setPosition(90 + (i - 7) * 60, 1530);
		}

		Spikes s1 = new Spikes(tileMap, player, 0);
		s1.setPosition(210, 930);
		spikes.add(s1);
		Spikes s2 = new Spikes(tileMap, player, 3);
		s2.setPosition(330, 210);
		spikes.add(s2);
		Spikes s3 = new Spikes(tileMap, player, 3);
		s3.setPosition(330, 270);
		spikes.add(s3);
		
		spikeBox(9, 21);
		spikeBox(13, 24);
		
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
		
		if(player.getx() < 40 && player.gety() >= 1000)
			gsm.setState(GameStateManager.SCENE14STATE);
	}

	public int getIndex() {
		return GameStateManager.LEVEL11STATE;
	}

	@Override
	public String getTitle() {
		return "Birnam Wood";
	}
	
	public String getMap() {
		return "/Maps/level3-2.map";
	}
	public String getMMap() {
		return "/Maps/level3-2m.map";
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

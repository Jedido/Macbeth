package GameState.Part3;

import Entity.Enemies.*;
import Entity.Objects.*;
import GameState.*;
import Main.GamePanel;

public class Level13State extends LevelState {

	private HumanEnemy enemy1;
	private HumanEnemy enemy2;
	private HumanEnemy macduff;
	private Crate crate;
	private int[][] p = {{440, 1050}, {390, 1050}, {1050, 300}, {270, 870}};
	
	public Level13State(GameStateManager gsm) {
		super(gsm);
		xcheck = xstart = 150;
		ycheck = ystart = 1590;
		titlex = GamePanel.WIDTH/2 - 54;
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
		
		if(macduff == null || !macduff.isDead())
			macduff = new Macduff(tileMap);
		macduff.setSpeed(0);
		macduff.setPosition(p[2][0], p[2][1]);
		enemies.add(macduff);
		
		crate = new Crate(tileMap, player);
		crate.setPosition(p[3][0], p[3][1]);
		crates.add(crate);
		objects.add(crate);
		
		Checkpoint check1 = new Checkpoint(tileMap, player);
		check1.setPosition(330, 1290);
		checkpoints.add(check1);
		Checkpoint check2 = new Checkpoint(tileMap, player);
		check2.setPosition(450, 690);
		checkpoints.add(check2);
		
		Door d1 = new Door(tileMap, player);
		d1.setPosition(570, 330);
		d1.setClosed();
		objects.add(d1);

		Door d2 = new Door(tileMap, player);
		d2.setPosition(90, 1050);
		d2.setClosed();
		objects.add(d2);

		Key k1 = new Key(tileMap, player);
		k1.setPosition(210, 210);
		keys.add(k1);
		
		Key k2 = new Key(tileMap, player);
		k2.setPosition(390, 1590);
		keys.add(k2);
		
		for(int i = 0; i < 10; i+=2)
		{
			ladders.add(new Ladder(tileMap, player));
			ladders.get(i).setPosition(90, 630 + (i/2) * 60);
			ladders.add(new Ladder(tileMap, player));
			ladders.get(i + 1).setPosition(90, 1110 + (i/2) * 60);
		}
		Ladder l1 = new Ladder(tileMap, player);
		l1.setPosition(210, 150);
		ladders.add(l1);
		Ladder l2 = new Ladder(tileMap, player);
		l2.setPosition(210, 210);
		ladders.add(l2);
		Ladder l3 = new Ladder(tileMap, player);
		l3.setPosition(210, 270);
		ladders.add(l3);
		
		for(int i = 0; i < 12; i++)
		{
			spikes.add(new Spikes(tileMap, player, 0));
			spikes.get(i).setPosition(510 + 60 * i, 1590);
		}
		
		Spikes s1 = new Spikes(tileMap, player, 1);
		s1.setPosition(90, 90);
		spikes.add(s1);
		Spikes s2 = new Spikes(tileMap, player, 3);
		s2.setPosition(510, 990);
		spikes.add(s2);
		Spikes s3 = new Spikes(tileMap, player, 3);
		s3.setPosition(510, 1050);
		spikes.add(s3);
		
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
		p[2][0] = macduff.getx();
		p[2][1] = macduff.gety();
		
		if(player.getx() > 600 && player.gety() > 1500) {
			gsm.setState(GameStateManager.EPILOGUESTATE);
		}
	}

	public int getIndex() {
		return GameStateManager.LEVEL13STATE;
	}

	@Override
	public String getTitle() {
		return "Macduff";
	}
	
	public String getMap() {
		return "/Maps/level3-4.map";
	}
	public String getMMap() {
		return "/Maps/level3-4m.map";
	}
	public String getTileMap() {
		return "/Tilesets/default.gif";
	}
	
	public String getMTileMap() {
		return "/Tilesets/defaultm.gif";
	}

	@Override
	public String getMusic() {
		return "/Music/final.mp3";
	}
}

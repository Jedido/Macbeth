package GameState.Part1;

import Entity.Enemies.*;
import Entity.Objects.*;
import GameState.*;
import Main.GamePanel;

public class Level3State extends LevelState {

	private HumanEnemy enemy1;
	private HumanEnemy enemy2;
	private HumanEnemy enemy3;
	private int[][] p = {{2470, 390}, {1560, 390}, {630, 390}};
	
	public Level3State(GameStateManager gsm) {
		super(gsm);
		xcheck = xstart = 2900;
		ycheck = ystart = 330;
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
		
		// objects		
		Ladder l1 = new Ladder(tileMap, player);
		l1.setPosition(210, 210);
		ladders.add(l1);
		Ladder l2 = new Ladder(tileMap, player);
		l2.setPosition(210, 270);
		ladders.add(l2);
		Ladder l3 = new Ladder(tileMap, player);
		l3.setPosition(210, 330);
		ladders.add(l3);
		Ladder l4 = new Ladder(tileMap, player);
		l4.setPosition(210, 390);
		ladders.add(l4);

		Ladder l5 = new Ladder(tileMap, player);
		l5.setPosition(1230, 210);
		ladders.add(l5);
		Ladder l6 = new Ladder(tileMap, player);
		l6.setPosition(1230, 270);
		ladders.add(l6);
		Ladder l7 = new Ladder(tileMap, player);
		l7.setPosition(1230, 330);
		ladders.add(l7);
		Ladder l8 = new Ladder(tileMap, player);
		l8.setPosition(1230, 390);
		ladders.add(l8);

		Ladder l9 = new Ladder(tileMap, player);
		l9.setPosition(1350, 210);
		ladders.add(l9);
		Ladder l10 = new Ladder(tileMap, player);
		l10.setPosition(1350, 270);
		ladders.add(l10);
		Ladder l11 = new Ladder(tileMap, player);
		l11.setPosition(1350, 330);
		ladders.add(l11);

		Ladder l12 = new Ladder(tileMap, player);
		l12.setPosition(1830, 330);
		ladders.add(l12);
		Ladder l13 = new Ladder(tileMap, player);
		l13.setPosition(1830, 390);
		ladders.add(l13);

		Ladder l16 = new Ladder(tileMap, player);
		l16.setPosition(2190, 150);
		ladders.add(l16);
		Ladder l17 = new Ladder(tileMap, player);
		l17.setPosition(2190, 210);
		ladders.add(l17);
		Ladder l18 = new Ladder(tileMap, player);
		l18.setPosition(2190, 270);
		ladders.add(l18);
		Ladder l19 = new Ladder(tileMap, player);
		l19.setPosition(2190, 330);
		ladders.add(l19);
		Ladder l20 = new Ladder(tileMap, player);
		l20.setPosition(2190, 390);
		ladders.add(l20);
		
		Checkpoint check1 = new Checkpoint(tileMap, player);
		check1.setPosition(570, 390);
		checkpoints.add(check1);
		Checkpoint check2 = new Checkpoint(tileMap, player);
		check2.setPosition(1530, 150);
		checkpoints.add(check2);
		Checkpoint check3 = new Checkpoint(tileMap, player);
		check3.setPosition(2310, 90);
		checkpoints.add(check3);
		
		Spikes spikes1 = new Spikes(tileMap, player, 0);
		spikes1.setPosition(810, 450);
		spikes.add(spikes1);
		Spikes spikes2 = new Spikes(tileMap, player, 0);
		spikes2.setPosition(870, 450);
		spikes.add(spikes2);
		Spikes spikes3 = new Spikes(tileMap, player, 0);
		spikes3.setPosition(930, 450);
		spikes.add(spikes3);
		Spikes spikes4 = new Spikes(tileMap, player, 0);
		spikes4.setPosition(990, 450);
		spikes.add(spikes4);
		Spikes spikes5 = new Spikes(tileMap, player, 0);
		spikes5.setPosition(1050, 450);
		spikes.add(spikes5);
		Spikes spikes6 = new Spikes(tileMap, player, 0);
		spikes6.setPosition(1110, 450);
		spikes.add(spikes6);
		Spikes spikes7 = new Spikes(tileMap, player, 0);
		spikes7.setPosition(1170, 450);
		spikes.add(spikes7);
		
		Spikes spikes8 = new Spikes(tileMap, player, 0);
		spikes8.setPosition(2250, 450);
		spikes.add(spikes8);
		Spikes spikes9 = new Spikes(tileMap, player, 0);
		spikes9.setPosition(1890, 450);
		spikes.add(spikes9);
		Spikes spikes10 = new Spikes(tileMap, player, 0);
		spikes10.setPosition(1950, 450);
		spikes.add(spikes10);
		Spikes spikes11 = new Spikes(tileMap, player, 0);
		spikes11.setPosition(2010, 450);
		spikes.add(spikes11);
		Spikes spikes12 = new Spikes(tileMap, player, 0);
		spikes12.setPosition(2070, 450);
		spikes.add(spikes12);
		Spikes spikes13 = new Spikes(tileMap, player, 0);
		spikes13.setPosition(2130, 450);
		spikes.add(spikes13);
		Spikes spikes14 = new Spikes(tileMap, player, 0);
		spikes14.setPosition(2190, 450);
		spikes.add(spikes14);
		
		Spikes spikes15 = new Spikes(tileMap, player, 3);
		spikes15.setPosition(1650, 90);
		spikes.add(spikes15);
		Spikes spikes16 = new Spikes(tileMap, player, 3);
		spikes16.setPosition(1650, 150);
		spikes.add(spikes16);
		Spikes spikes17 = new Spikes(tileMap, player, 2);
		spikes17.setPosition(2610, 210);
		spikes.add(spikes17);
		Spikes spikes18 = new Spikes(tileMap, player, 2);
		spikes18.setPosition(2670, 210);
		spikes.add(spikes18);
		Spikes spikes19 = new Spikes(tileMap, player, 2);
		spikes19.setPosition(2730, 210);
		spikes.add(spikes19);

		Door d1 = new Door(tileMap, player);
		d1.setPosition(450, 150);
		d1.setClosed();
		objects.add(d1);
		
		Key k1 = new Key(tileMap, player);
		k1.setPosition(870, 90);
		keys.add(k1);
		
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
		
		if(player.getx() > 140 && player.getx() < 160 && player.gety() >= 320)
			gsm.setState(GameStateManager.SCENE4STATE);
	}

	public int getIndex() {
		return GameStateManager.LEVEL3STATE;
	}

	@Override
	public String getTitle() {
		return "Tutorial 3";
	}
	
	public String getMap() {
		return "/Maps/level1-3.map";
	}
	public String getMMap() {
		return "/Maps/level1-3m.map";
	}
	public String getTileMap() {
		return "/Tilesets/tutorial3.gif";
	}
	
	public String getMTileMap() {
		return "/Tilesets/tutorial3m.gif";
	}

	@Override
	public String getMusic() {
		return "/Music/transformation.mp3";
	}
}

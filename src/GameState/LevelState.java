package GameState;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Audio.AudioPlayer;
import Entity.*;
import Entity.Objects.*;
import Main.GamePanel;
import TileMap.*;

public abstract class LevelState extends GameState{

	protected int transparency;
	protected int delay;
	protected TileMap tileMap;
	protected Color bgColor;
	protected Color opColor;
	protected Color selColor;
	protected int titlex;
	protected boolean loaded;
	protected boolean mloaded;
	
	protected Macbeth player;
	protected int mCountdown;
	
	protected ArrayList<Enemy> enemies;
	protected ArrayList<Inanimate> objects;
	protected ArrayList<Crate> crates;
	protected ArrayList<Ladder> ladders;
	protected ArrayList<Spikes> spikes;
	protected ArrayList<Checkpoint> checkpoints;
	protected ArrayList<Key> keys;
	
	protected HUD hud;
	protected int xcheck;
	protected int ycheck;
	protected int xstart;
	protected int ystart;
	protected int hit;
	
	protected AudioPlayer meffect = new AudioPlayer("/SFX/gong.mp3");
	protected boolean mvision;
	
	protected int currentChoice = 4;
	protected String[] choices = {"P", "R", "M", " H"};
	
	public LevelState(GameStateManager gsm) {
		this.gsm = gsm;
		opColor = Color.WHITE;
		selColor = Color.BLUE;
		transparency = 254;
		loaded = true;
		mloaded = false;
		mvision = false;
		hit = 230;
	}

	@Override
	public void init() {
		
		bgColor = Color.WHITE;
		
		tileMap = new TileMap(60);
		tileMap.loadTiles(getTileMap());
		tileMap.loadMap(getMap());
		tileMap.setPosition(0, 0);
		
		player = new Macbeth(tileMap);
		player.setPosition(xstart, ystart);
		
		enemies = new ArrayList<Enemy>();
		objects = new ArrayList<Inanimate>();
		ladders = new ArrayList<Ladder>();
		spikes = new ArrayList<Spikes>();
		crates = new ArrayList<Crate>();
		checkpoints = new ArrayList<Checkpoint>();
		keys = new ArrayList<Key>();
		
		hud = new HUD(player, this);
	}

	@Override
	public void update() {
		
		// attack enemies
		player.checkAttack(enemies);
		
		// update enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();
			if(enemies.get(i).isDead()) {
				enemies.remove(i);
				i--;
			}
		}

		// update player
		player.update();
		tileMap.setPosition(GamePanel.WIDTH / 2 - player.getx(), GamePanel.HEIGHT / 2 - player.gety());
		xstart = player.getx();
		ystart = player.gety();	
		
		hit += 15;
		if(player.isDead()) {
			hit = 0;
			returnToCheckpoint();
			player.loseLife();
			player.setDead(false);
			if(player.getHealth() == 0)
				gsm.setStateRestart(getIndex());
		}

		if(mCountdown > 0) mCountdown--;
		if(transparency > 2 && delay > 40) transparency -= 3;
		else delay ++;
		
		// update objects
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).update();
		}
		
		// check ladder
		checkOnLadder();
		
		// check spikes
		for(Spikes s : spikes) {
			s.hitSpikes();
		}
		
		// check flags
		for(Checkpoint cp : checkpoints) {
			cp.update();
			if(cp.isRaising())
				updateCheckpoint();
		}
		
		// check keys
		for(int i = 0; i < keys.size(); i++) {
			if(Math.abs(player.getx() - keys.get(i).getx()) < 20 && Math.abs(player.gety() - keys.get(i).gety()) < 20) {
				keys.remove(i);
				i--;
				player.setNumKeys(player.getNumKeys() + 1);
			}
		}
		
		if(mCountdown == 0 && !loaded && !mvision) {
			player.normalMode();
			tileMap.loadTiles(getTileMap());
			tileMap.loadMap(getMap());
			for(int i = 0; i < enemies.size(); i++)
				enemies.get(i).normalMode();
			for(int i = 0; i < objects.size(); i++)
				objects.get(i).normalMode();
			for(int i =0; i < keys.size(); i++)
				keys.get(i).normalMode();
			for(int i = 0; i < checkpoints.size(); i++)
				checkpoints.get(i).normalMode();
			hud.normalMode();
			bgColor = Color.WHITE;
			loaded = true;
		}
		else if(mloaded || mvision){
			player.MMode();
			tileMap.loadTiles(getMTileMap());
			tileMap.loadMap(getMMap());
			for(int i = 0; i < enemies.size(); i++)
				enemies.get(i).MMode();
			for(int i = 0; i < objects.size(); i++)
				objects.get(i).MMode();
			for(int i =0; i < keys.size(); i++)
				keys.get(i).MMode();
			for(int i = 0; i < checkpoints.size(); i++)
				checkpoints.get(i).MMode();
			hud.MMode();
			bgColor = Color.BLACK;
			mloaded = false;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(bgColor);
		g.fillRect(0,  0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		
		// draw enemies
		for(int i = 0; i < enemies.size(); i++)
			enemies.get(i).draw(g);
		
		// draw objects
		for(int i = 0; i < objects.size(); i++)
			objects.get(i).draw(g);
		
		// draw keys
		for(int i = 0; i < keys.size(); i++)
			keys.get(i).draw(g);
			
		// draw flags
		for(Checkpoint cp : checkpoints)
			cp.draw(g);

		// draw tilemap
		tileMap.draw(g);

		// draw player
		player.draw(g);
		
		// draw hud
		hud.draw(g);
		
		// draw quick options
		g.setColor(Color.BLACK);
		g.fillRect(520, 0, 200, 30);
		if(mCountdown == 0) {
			selColor = Color.BLUE;
		}
		else {
			selColor = Color.RED;
		}
		g.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		for(int i = 0; i < choices.length; i++) {
			if(i != currentChoice)
				g.setColor(opColor);
			else 
				g.setColor(selColor);
			g.drawString(choices[i], 530 + 25 * i, 20);
		}

		// draw hit effect
		if(hit < 230)
		{
			g.setColor(new Color(181, 0, 0, 230 - hit));
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		}
		
		// draw intro
		if(transparency > 0) {
			g.setColor(new Color(0, 0, 0, transparency));
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
			g.setColor(new Color(255, 255, 255, transparency));
			g.setFont(GameState.TITLEFONT);
			g.drawString(getTitle(), titlex, GamePanel.HEIGHT / 2);
		}
		if(mvision) {
			tileMap.loadTiles(getTileMap());
			tileMap.loadMap(getMap());
		}
	}

	@Override
	public void keyPressed(int k) {
		super.keyPressed(k);
		if(k == KeyEvent.VK_R) player.setDead(true);
		if(k == KeyEvent.VK_V && mCountdown == 0) { 
			mvision = true;
			player.setLeft(false);
			player.setRight(false); 
			player.setUp(false);
			player.setDown(false);
			player.setJumping(false);
		}
		if(!mvision) {
			if(k == KeyEvent.VK_LEFT) player.setLeft(true);
			if(k == KeyEvent.VK_RIGHT) player.setRight(true); 
			if(k == KeyEvent.VK_UP) player.setUp(true);
			if(k == KeyEvent.VK_DOWN) player.setDown(true);
			if(k == KeyEvent.VK_SPACE) player.setJumping(true);
			if(k == KeyEvent.VK_S) player.setScratching();
			if(k == KeyEvent.VK_M && player.getM() != 0 && mCountdown == 0) {
				meffect.play();
				mCountdown = 300;
				tileMap.loadMap(getMMap());
				loaded = false;
				mloaded = true;
				player.setM(player.getM() - 1);
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) player.setRight(false); 
		if(k == KeyEvent.VK_UP) player.setUp(false);
		if(k == KeyEvent.VK_DOWN) player.setDown(false);
		if(k == KeyEvent.VK_SPACE) player.setJumping(false);
		if(k == KeyEvent.VK_V) { mvision = false; loaded = false; }
	}
	
	public abstract int getIndex();
	public abstract String getTitle();
	public abstract String getMap();
	public abstract String getMMap();
	public abstract String getTileMap();
	public abstract String getMTileMap();
	public int getCountdown() {
		return mCountdown;
	}
	
	public void select() {
		if(currentChoice == 0) {}
//			gsm.setState(GameStateManager.PAUSESTATE, getIndex());
		if(currentChoice == 1) {
			gsm.setStateRestart(getIndex());
		}
		if(currentChoice == 2) {}
			//mute
		if(currentChoice == 3) {}
			//gsm.setState(GameStateManager.HELPSTATE);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		int y = e.getY();
		int x = e.getX();
		if(y < 20) {
			if(x > 530 && x < 555)
				currentChoice = 0;
			else if(x >= 555 && x < 580)
				currentChoice = 1;
			else if(x >= 580 && x < 605)
				currentChoice = 2;
			else if(x >= 605 && x < 630)
				currentChoice = 3;
			else
				currentChoice = 4;
		}
		else
			currentChoice = 4;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		select();
		e.consume();
	}
	
	public void checkOnLadder() {
		for(Ladder l : ladders) {
			if(l.onBottom()) {
				player.setLadder(true);
				player.setBottom(true);
				return;
			}
			if(l.onLadder()) {
				player.setBottom(false);
				player.setLadder(true);
				return;
			}
		}
		player.setBottom(false);
		player.setLadder(false);
	}
	
	public void returnToCheckpoint() {
		player.setPosition(xcheck, ycheck);
	}
	
	public void updateCheckpoint() {
		xcheck = player.getx();
		ycheck = player.gety();
	}
	
	public void spikeBox(int x, int y) {
		Spikes s1 = new Spikes(tileMap, player, 0);
		s1.setPosition(x * 60 - 30, y * 60 - 90);
		spikes.add(s1);
		Spikes s2 = new Spikes(tileMap, player, 1);
		s2.setPosition(x * 60 + 30, y * 60 - 30);
		spikes.add(s2);
		Spikes s3 = new Spikes(tileMap, player, 2);
		s3.setPosition(x * 60 - 30, y * 60 + 30);
		spikes.add(s3);
		Spikes s4 = new Spikes(tileMap, player, 3);
		s4.setPosition(x * 60 - 90, y * 60 - 30);
		spikes.add(s4);
	}
}

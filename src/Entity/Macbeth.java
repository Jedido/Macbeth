package Entity;

import Audio.AudioPlayer;
import TileMap.*;

import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Macbeth extends MapObject {

	// player stuff
	private int health;
	private int maxHealth;
	private int factorm;
	private int keys;
	private boolean dead;
	private boolean onCrate;
	private boolean onLadder;
	private boolean onBottom;
	
	// scratch
	private boolean slashing;
	private int slashDamage;
	private int slashRange;
	
	// animations
	private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames = {1, 8, 1, 8};
	private final int numOfAnimations = 2;
	
	// animation actions
	private int IDLE = 0;
	private int SLASHING = 1;
	
	private HashMap<String, AudioPlayer> sfx;
	
	public Macbeth(TileMap tm) {
		
		super(tm);
		
		width = 60;
		height = 60;
		cwidth = 39;
		cheight = 60;
		
		moveSpeed = 0.6;
		maxSpeed = 3.2;
		stopSpeed = 0.17;
		fallSpeed = 0.3;
		maxFallSpeed = 8.0;
		jumpStart = -9.6;
		stopJumpSpeed = 0.6;
		
		facingRight = true;
		onCrate = false;
		onLadder = false;
		dead = false;
		
		health = maxHealth = 3;
		factorm = 0;
		keys = 0;
		
		slashDamage = 1;
		slashRange = 50;
		
		// load sprites
		try {
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/finalmacbeth.gif"));
			
			sprites = new ArrayList<BufferedImage[]>();
			for(int i  = 0; i < numOfAnimations * 2; i++) {
				BufferedImage[] bi = new BufferedImage[numFrames[i]];
				for(int j = 0; j < numFrames[i]; j++) {
					if(i != 1 && i != 3)
						bi[j] = spritesheet.getSubimage(j * width, i * height, width, height);
					else
					 	bi[j] = spritesheet.getSubimage(j * (width + 30), i * height, width + 30, height);
				}
				sprites.add(bi);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		animation = new Animation();
		currentAction = IDLE;
		animation.setFrames(sprites.get(IDLE));
		animation.setDelay(400);
		
		sfx = new HashMap<String, AudioPlayer>();
		sfx.put("jump", new AudioPlayer("/SFX/jump.mp3"));
		sfx.put("scratch", new AudioPlayer("/SFX/scratch.mp3"));
		
	}
	
	public int getHealth() { return health; }
	public int getMaxHealth() { return maxHealth; }
	public int getM() { return factorm; }
	
	public void setScratching() {
		slashing = true;
	}
	
	public void checkAttack(ArrayList<Enemy> enemies) {
		
		for(int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			if(slashing) {
				if(facingRight && e.getx() > x && e.getx() < x + slashRange && e.gety() > y - height / 2 && e.gety() < y + height / 2) {
					e.hit(slashDamage);
					if(e.addM()) {
						e.minusM();
						factorm++;
					}
				}
				if(!facingRight && e.getx() < x && e.getx() > x - slashRange && e.gety() > y - height / 2 && e.gety() < y + height / 2) {
					e.hit(slashDamage);
					if(e.addM()) {
						e.minusM();
						factorm++;
					}
				}
			}
		}
	}
	
	private void getNextPosition() {
		
		// movement
		if(left) {
			dx -= moveSpeed;
			if(dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		}
		else if(right) {
			dx += moveSpeed;
			if(dx > maxSpeed) {
				dx = maxSpeed;
			}
		}
		else {
			if(dx > 0) {
				dx -= stopSpeed;
				if(dx < 0) {
					dx = 0;
				}
			}
			else if(dx < 0) {
				dx += stopSpeed;
				if(dx > 0) {
					dx = 0;
				}
			}
		}
		
		// cannot attack while attacking, except in air
		if(currentAction == SLASHING && !(jumping || falling)) {
			dx = 0;
		}
		
		// jumping
		if(jumping && !falling || (onCrate && jumping) || (jumping && onLadder && dy > -1)) {
			sfx.get("jump").play();
			dy = jumpStart;
			falling = true;
		}
		if(onLadder && !jumping) {
			falling = false;
			if(dy < 0) {
				dy += fallSpeed * 2;
				if(dy > 0) dy = 0;
			}
			else dy = 0;
			if(!onBottom)
				dx /= 1.5;
			if(up) dy = -3;
			else if(down) dy = 3;
		}
		
		if(onCrate) {
			falling = false;
			if(dy > 1) dy = 1;
		}
		
		// falling
		if(falling) {
			dy += fallSpeed;
			if(dy > 0) jumping = false;
			if(dy < 0 && !jumping) dy += stopJumpSpeed;
			
			if(dy > maxFallSpeed) dy = maxFallSpeed;
		}
	}
	
	
	public void update() {
		
		
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
 		// check attack has stopped
		if(currentAction == SLASHING) {
			if(animation.hasPlayedOnce()) slashing = false;
		}	
		
		// set animation
		if(slashing) {
			if(currentAction != SLASHING) {
				sfx.get("scratch").play();
				currentAction = SLASHING;
				animation.setFrames(sprites.get(SLASHING));
				animation.setDelay(8);
				width = 90;
			}
		}
		else {
			if(currentAction != IDLE) {
				currentAction = IDLE;
				animation.setFrames(sprites.get(IDLE));;
				animation.setDelay(400);
				width = 60;
			}
		}
		
		animation.update();
		
		// set direction
		if(currentAction != SLASHING) {
			if(right) facingRight = true;
			if(left) facingRight = false;
		}
	}
	
	public void draw(Graphics2D g) {
		
		setMapPosition();

		super.draw(g);
	}
	
	public void setCrate(boolean b) {
		onCrate = b;
	}
	public void setLadder(boolean b) {
		onLadder = b;
	}
	public void setBottom(boolean b) {
		onBottom = b;
	}
	public double getdx() {
		return dx;
	}
	public double getdy() {
		return dy;
	}
	public void setDead(boolean b) {
		dead = b;
	}
	public int getNumKeys() {
		return keys;
	}
	public void setNumKeys(int k) {
		keys = k;
	}
	public boolean isDead() {
		return dead;
	}
	public void loseLife() {
		health--;
	}
	public void setM(int m) {
		factorm = m;
	}
	public void MMode() {
		IDLE = 2;
		SLASHING = 3;
	}
	public void normalMode() {
		IDLE = 0;
		SLASHING = 1;
	}
}

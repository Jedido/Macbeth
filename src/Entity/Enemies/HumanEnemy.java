package Entity.Enemies;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Entity.*;
import TileMap.TileMap;

public abstract class HumanEnemy extends Enemy{

	private ArrayList<BufferedImage[]> sprites;
	
	public HumanEnemy(TileMap tm) {
		super(tm);
		
		moveSpeed = 1;
		maxSpeed = 1.2;
		fallSpeed = 0.2;
		maxFallSpeed = 10.0;
		
		width = getWidth();
		height = getHeight();
		cwidth = getCWidth();
		cheight = getCHeight();
		
		int[] numFrames = {1, 1};
		
		health = maxHealth = 1;
		
		// load sprites
		try {
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/" + getName() + ".gif"));
			sprites = new ArrayList<BufferedImage[]>();
			for(int i  = 0; i < 2; i++) {
				BufferedImage[] bi = new BufferedImage[numFrames[i]];
				for(int j = 0; j < numFrames[i]; j++) {
					bi[j] = spritesheet.getSubimage(j * width, i * height, width, height);
				}
				sprites.add(bi);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		animation = new Animation();
		animation.setFrames(sprites.get(0));
		animation.setDelay(300);
		
		right = true;
		facingRight = true;
	}
	
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract int getCWidth();
	public abstract int getCHeight();
	public abstract String getName();
	
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
		// falling
		if(falling) {
			dy += fallSpeed;
			if(dy > maxFallSpeed) dy = maxFallSpeed;
		}
	}
	
	public void update() {
		
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		// check flinching
		if(flinching) {
			long elapsed =
				(System.nanoTime() - flinchTimer) / 1000000;
			if(elapsed > 50) {
				flinching = false;
			}
		}
		
		// if it hits a wall, go other direction
		if(right && dx == 0) {
			right = false;
			left = true;
			facingRight = false;
		}
		else if(left && dx == 0) {
			right = true;
			left = false;
			facingRight = true;
		}
		// update animation
		animation.update();
	}
	
	public void draw(java.awt.Graphics2D g) {
		setMapPosition();
		super.draw(g);
	}
	
	public void MMode() {
		animation.setFrames(sprites.get(1));
	}
	public void normalMode() {
		animation.setFrames(sprites.get(0));
	}
	public void setSpeed(int speed) {
		maxSpeed = speed;
	}
}

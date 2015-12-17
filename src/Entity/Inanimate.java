package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import TileMap.TileMap;

public abstract class Inanimate extends MapObject{

	protected ArrayList<BufferedImage[]> sprites;
	protected int[] numFrames;
	protected Macbeth macbeth;
	
	public Inanimate(TileMap tm, Macbeth m) {
		super(tm);
		width = 60;
		height = 60;
		macbeth = m;
		numFrames = getNumFrames();
	}
	
	protected void loadSpritesheet() {
		try {
			
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Objects/" + getName() + ".gif"));
			
			sprites = new ArrayList<BufferedImage[]>();
			for(int i  = 0; i < numFrames.length; i++) {
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
		currentAction = 0;
		animation.setFrames(sprites.get(0));
		animation.setDelay(400);
	}
	
	public void update() {
		
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		animation.update();
	}
	
	public void draw(Graphics2D g) {
		setMapPosition();
		
		g.drawImage(animation.getImage(), (int) (x + xmap - width / 2), (int) (y + ymap - height / 2), null);
	}
	
	public void getNextPosition() {}

	public abstract String getName();
	
	public int[] getNumFrames() {
		int[] a = {1, 1};
		return a;
	}
	
	public void MMode() {
		animation.setFrames(sprites.get(1));
	}

	public void normalMode() {
		animation.setFrames(sprites.get(0));
	}
}

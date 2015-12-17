package Entity.Objects;

import Entity.*;
import TileMap.*;

public class Spikes extends Inanimate {
	
	private int DEFAULT;
	private int direction;
	private int directionm;
	
	public Spikes(TileMap tm, Macbeth m, int d) {
		super(tm, m);

		cwidth = 80;
		cheight = 60;
		DEFAULT = direction = d;
		directionm = d + 4;
		loadSpritesheet();
	}
	
	@Override
	public String getName() {
		return "spikes";
	}
	
	public void update() {
		animation.setFrames(sprites.get(DEFAULT));
		animation.update();
	}
	
	public void hitSpikes() {
		if(!macbeth.isDead() && macbeth.intersects(this)) {
			if(macbeth.getx() < getx() + 39 && macbeth.getx() > getx() - 39 && macbeth.gety() > gety() - 59 && macbeth.gety() < gety() + 59)
				macbeth.setDead(true);
		}
	}

	@Override
	public int[] getNumFrames() {
		int[] a = {1, 1, 1, 1, 1, 1, 1, 1};
		return a;
	}
	
	public void MMode() {
		DEFAULT = directionm;
	}
	
	public void normalMode() {
		DEFAULT = direction;
	}
}

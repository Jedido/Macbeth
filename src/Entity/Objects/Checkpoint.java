package Entity.Objects;

import java.awt.Graphics2D;

import Entity.*;
import TileMap.TileMap;

public class Checkpoint extends Inanimate {
	
	private int BOTTOM = 0;
	private int TOP = 1;
	private int RAISING = 2;
	private boolean raisedOnce;
	
	public Checkpoint(TileMap tm, Macbeth m) {
		super(tm, m);
		cheight = 60;
		width = 30;
		cwidth = 30;
		
		raisedOnce = false;
		loadSpritesheet();
	}
	
	public void update() {
		animation.update();
		if(currentAction == 1 || currentAction == 4) {
			animation.setFrames(sprites.get(TOP));
		}
		else if(currentAction == RAISING) {
			if(animation.hasPlayedOnce()) {
				currentAction = TOP;
				raisedOnce = true;
				animation.setFrames(sprites.get(TOP));
				animation.setDelay(-1);
			}
		}	
		else if(intersects(macbeth) && !raisedOnce) {
			currentAction = RAISING;
			animation.setFrames(sprites.get(RAISING));
			animation.setDelay(20);
		}
		else
			animation.setFrames(sprites.get(BOTTOM));
	}
	
	public void draw(Graphics2D g) {
		setMapPosition();
		
		g.drawImage(animation.getImage(), (int) (x + xmap - width / 2), (int) (y + ymap - height / 2), null);
	}
	public void MMode() {
		BOTTOM = 3;
		TOP = 4;
		RAISING = 5;
	}

	public void normalMode() {
		BOTTOM = 0;
		TOP = 1;
		RAISING = 2;
	}
	
	public boolean isRaising() {
		return currentAction == RAISING;
	}

	@Override
	public String getName() {
		return "checkpoint";
	}
	
	public int[] getNumFrames() {
		int[] a = {1, 1, 4, 1, 1, 4};
		return a;
	}
}

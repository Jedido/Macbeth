package Entity.Objects;

import Entity.*;
import TileMap.*;

public class Ladder extends Inanimate {

	
	public Ladder(TileMap tm, Macbeth m) {
		super(tm, m);
		cwidth = 30;
		cheight = 60;
		stopSpeed = 100;
		fallSpeed = 0;
		loadSpritesheet();
	}
	

	public void getNextPosition() { }
	
	public boolean onLadder() {
		return (macbeth.getx() < getx() + 25 && macbeth.getx() > getx() - 25 && macbeth.gety() > gety() - 60 && macbeth.gety() <= gety());
	}
	
	public boolean onBottom() {
		return (macbeth.getx() < getx() + 25 && macbeth.getx() > getx() - 25 && macbeth.gety() == gety());
	}
	
	public void update() {
		
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		animation.update();
	}

	@Override
	public String getName() {
		return "ladder";
	}
}

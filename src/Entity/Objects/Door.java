package Entity.Objects;

import TileMap.TileMap;
import Entity.*;

public class Door extends Inanimate {

	private int OPEN = 0;
	private int CLOSED = 1;
	
	public Door(TileMap tm, Macbeth m) {
		super(tm, m);
		loadSpritesheet();
	}

	@Override
	public String getName() {
		return "door";
	}
	public void update() {
		if(currentAction == 1 || currentAction == 3)
			animation.setFrames(sprites.get(CLOSED));
		else
			animation.setFrames(sprites.get(OPEN));
		if((currentAction == 1 || currentAction == 3) && macbeth.getx() > getx() + width / 2 - 20 && macbeth.getx() < getx() + width / 2 + 9 && macbeth.gety() > gety() - 30 && macbeth.gety() < gety() + 30) {
			if(macbeth.getNumKeys() == 0) {
				if(macbeth.getdx() > 0)
					macbeth.setPosition(getx() + width / 2 - 20 + macbeth.getdx(), macbeth.gety());
				if(macbeth.getdx() < 0)
					macbeth.setPosition(getx() + width / 2 + 10 + macbeth.getdx(), macbeth.gety());
			}
			if(macbeth.getNumKeys() > 0) {
				macbeth.setNumKeys(macbeth.getNumKeys() - 1);
				setOpen();
			}
		}
	}
	
	public void setOpen() {
		currentAction = OPEN;
		animation.setFrames(sprites.get(OPEN));
	}
	
	public void setClosed() {
		currentAction = CLOSED;
		animation.setFrames(sprites.get(CLOSED));
	}
	
	public int[] getNumFrames() {
		int[] a = {1, 1, 1, 1};
		return a;
	}
	
	public void MMode() {
		OPEN = 2;
		CLOSED = 3;
	}

	public void normalMode() {
		OPEN = 0;
		CLOSED = 1;
	}
}

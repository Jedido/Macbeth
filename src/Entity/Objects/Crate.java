package Entity.Objects;

import Entity.*;
import TileMap.*;

public class Crate extends Inanimate{
	
	public Crate(TileMap tm, Macbeth m) {
		super(tm, m);
		width = 40;
		height = 40;
		cwidth = 60;
		cheight = 40;
		
		stopSpeed = 0.2;
		fallSpeed = 0.3;
		loadSpritesheet();
	}
	

	public void getNextPosition() {
		// top
		if((macbeth.getx() > getx() - width / 2 - 10 && macbeth.getx() < getx() + width / 2 + 9) && macbeth.gety() < gety() - 28 && macbeth.gety() > gety() - 51 && macbeth.getdy() >= 0) {
			macbeth.setPosition(macbeth.getx(), y - 50);
		if(macbeth.getdy() >= 0)
			macbeth.setCrate(true);
		}
		else
			macbeth.setCrate(false);
		if(this.intersects(macbeth))
		{	
			double mdx = macbeth.getdx();

			// left or right
			if((macbeth.getx() > getx() - width / 2 - 9 && macbeth.getx() < getx() + width / 2 + 9) && macbeth.gety() > gety() - width / 2 && macbeth.gety() < gety() + width / 2) {
				dx = mdx;
				if(mdx > 0)
					macbeth.setPosition(getx() - width / 2 - 9 + mdx, macbeth.gety());
				if(mdx < 0)
					macbeth.setPosition(getx() + width / 2 + 10 + mdx, macbeth.gety());
			}
		}
		
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
		
		// falling
		if(falling) {
			dy += fallSpeed;
		}
	}

	@Override
	public String getName() {
		return "boxsprite";
	}
}

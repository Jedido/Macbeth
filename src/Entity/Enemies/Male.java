package Entity.Enemies;

import TileMap.TileMap;

public class Male extends HumanEnemy {

	public Male(TileMap tm) {
		super(tm);
	}

	@Override
	public int getWidth() {
		return 20;
	}

	@Override
	public int getHeight() {
		return 60;
	}

	@Override
	public int getCWidth() {
		return 40;
	}

	@Override
	public int getCHeight() {
		return 60;
	}

	@Override
	public String getName() {
		return "male";
	}
	
	public void setSpeed(double speed) {
		maxSpeed = speed;
	}

}

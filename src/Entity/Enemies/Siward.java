package Entity.Enemies;

import TileMap.TileMap;

public class Siward extends Male{

	public Siward(TileMap tm) {
		super(tm);
	}

	@Override
	public String getName() {
		return "siward";
	}
}

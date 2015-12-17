package Entity.Enemies;

import TileMap.TileMap;

public class Macduff extends Male{

	public Macduff(TileMap tm) {
		super(tm);
	}

	@Override
	public String getName() {
		return "macduff";
	}
}

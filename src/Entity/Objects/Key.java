package Entity.Objects;

import TileMap.TileMap;
import Entity.Inanimate;
import Entity.Macbeth;

public class Key extends Inanimate {

	public Key(TileMap tm, Macbeth m) {
		super(tm, m);
		width = 20;
		height = 27;
		cwidth = 20;
		cheight = 27;
		loadSpritesheet();
	}

	@Override
	public String getName() {
		return "key";
	}

}

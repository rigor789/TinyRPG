package com.arcticflamegames.tinyrpg.Tile;

import com.arcticflamegames.tinyrpg.Screen;
import com.arcticflamegames.tinyrpg.Sprites;

public class AsphaltTile extends Tile {

	public AsphaltTile(int id) {
		super(id);
		tile = Sprites.terrain[3][0];
	}

	public void render(int x, int y, Screen screen) {
		screen.renderSprite(x * tile.w, y * tile.h, tile);
	}

}

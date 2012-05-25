package com.arcticflamegames.tinyrpg.Tile;

import com.arcticflamegames.tinyrpg.Screen;
import com.arcticflamegames.tinyrpg.Sprites;

public class FlowersTile extends Tile {

	public FlowersTile(int id, int col) {
		super(id);

		tile = Sprites.terrain[col][0];
	}

	public void render(int x, int y, Screen screen) {
		screen.renderSprite(x * tile.w, y * tile.h, tile);
	}

}

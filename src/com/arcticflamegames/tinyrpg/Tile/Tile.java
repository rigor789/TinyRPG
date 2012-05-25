package com.arcticflamegames.tinyrpg.Tile;

import com.arcticflamegames.tinyrpg.Screen;
import com.arcticflamegames.tinyrpg.Sprite;

public class Tile {
	public final int id;
	public Sprite tile;

	public static Tile[] tiles = new Tile[25000];
	public static Tile grassTile = new GrassTile(0);
	public static Tile rockTile = new RockTile(1);
	public static Tile dirtTile = new DirtTile(2);
	public static Tile asphaltTile = new AsphaltTile(3);
	public static Tile flowersTile1 = new FlowersTile(4, 4);
	public static Tile flowersTile2 = new FlowersTile(5, 5);
	public static Tile flowersTile3 = new FlowersTile(6, 6);

	public Tile(int id) {
		this.id = id;
		tiles[id] = this;
	}

	public void render(int x, int y, Screen screen) {
	}

}

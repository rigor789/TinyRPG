package com.arcticflamegames.tinyrpg;

import java.awt.image.BufferedImage;
import java.util.Random;

import com.arcticflamegames.tinyrpg.Tile.Tile;

public class Level {

	BufferedImage image;
	Screen screen;
	Resource resource;

	public int w;
	public int h;
	public int[] tiles;

	public Level(Resource resource, Levels level, Screen screen) {
		this.resource = resource;
		this.image = this.resource.loadImage(level.getPath());
		this.screen = screen;

		this.w = image.getWidth();
		this.h = image.getHeight();
		tiles = new int[w * h];
	}

	public void loadLevel() {
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				if (resource.getColor(x, y) == 0xA0A0A0) {
					tiles[x + y * h] = Tile.rockTile.id;
					// Sprite stone = Sprites.terrain[1][0];
					// screen.renderSprite(x * stone.w, y * stone.h, stone);
				} else if (resource.getColor(x, y) == 0x303030) {
					tiles[x + y * h] = Tile.asphaltTile.id;
					// Sprite asphalt = Sprites.terrain[3][0];
					// screen.renderSprite(x * asphalt.w, y * asphalt.h,
					// asphalt);
				} else if (resource.getColor(x, y) == 0x7F3300) {
					tiles[x + y * h] = Tile.dirtTile.id;
					// Sprite road = Sprites.terrain[2][0];
					// screen.renderSprite(x * road.w, y * road.h, road);
				} else if (resource.getColor(x, y) == 0xFF0000) {
					Random random = new Random();
					int variation = random.nextInt(3);
					switch (variation) {
					case 0:
						tiles[x + y * h] = Tile.flowersTile1.id;
						break;
					case 1:
						tiles[x + y * h] = Tile.flowersTile2.id;
						break;
					case 2:
						tiles[x + y * h] = Tile.flowersTile3.id;
						break;
					}
					// Sprite road = Sprites.terrain[2][0];
					// screen.renderSprite(x * road.w, y * road.h, road);
				} else {
					tiles[x + y * h] = Tile.grassTile.id;
					// Sprite grass = Sprites.terrain[0][0];
					// screen.renderSprite(x * grass.w, y * grass.h, grass);
				}
			}
		}
	}

	public void renderBackground(int xScroll, int yScroll, Screen screen) {
		int xo = xScroll >> 4;
		int yo = yScroll >> 4;

		int w = (screen.w + 15) >> 4;
		int h = (screen.h + 15) >> 4;

		screen.setxOffset(xScroll, yScroll);
		for (int y = yo; y <= h + yo; y++) {
			for (int x = xo; x <= w + xo; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		screen.setxOffset(0, 0);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= w || y >= h)
			return Tile.rockTile;
		return Tile.tiles[tiles[x + y * w]];
	}

}

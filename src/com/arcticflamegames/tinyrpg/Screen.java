package com.arcticflamegames.tinyrpg;

public class Screen {
	public int w, h;
	int xOffset = 0, yOffset = 0;
	public int[] pixels;

	public Screen(int w, int h) {
		this.w = w;
		this.h = h;

		pixels = new int[w * h];
	}

	public void renderSprite(int xPos, int yPos, Sprite sprite) {
		int width = sprite.w;
		int height = sprite.h;
		xPos -= xOffset;
		yPos -= yOffset;
		for (int y = 0; y < height; y++) {
			if (yPos + y < 0 || yPos + y >= h)
				continue;
			for (int x = 0; x < width; x++) {
				if (xPos + x < 0 || xPos + x >= w)
					continue;

				int col = sprite.pixels[x + (y * height)];
				if (col != -65281 && col < 0)
					pixels[(x + xPos) + (y + yPos) * w] = col;
			}
		}
	}

	public void setxOffset(int xOffs, int yOffs) {
		xOffset = xOffs;
		yOffset = yOffs;
	}

}

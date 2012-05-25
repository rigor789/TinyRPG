package com.arcticflamegames.tinyrpg;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resource {
	
	int w, h;

	BufferedImage image = null;
	
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(Resource.class.getResource(path));
			this.w = image.getWidth();
			this.h = image.getHeight();
			return image;
		} catch (IOException e) {
			System.out.println("Cannot load image!");
			return null;
		}
	}
	
	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}
	
	public int getColor(int x, int y) {
		if (image == null) {
			return 0;
		}
		if (x < 0)
			x = 0;
		if (x > getWidth() - 1)
			x = getWidth() - 1;
		if (y < 0)
			y = 0;
		if (y > getHeight() - 1)
			y = getHeight() - 1;
		int col = image.getRGB(x, y);

		int r = (col & 0xFF0000) >> 16;
		int g = (col & 0x00FF00) >> 8;
		int b = (col & 0x0000FF);
		int color = r << 16 | g << 8 | b;

		return color;
	}

}

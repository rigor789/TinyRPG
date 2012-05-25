package com.arcticflamegames.tinyrpg;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	private int WIDTH = 300;
	private int HEIGHT = 200;
	private int SCALE = 2;
	private Thread thread = new Thread(this, "TinyRPG");
	public boolean running = false;
	public static String TITLE = "TinyRPG";
	public static String VERSION = "Development Build";
	private Screen screen;
	private InputHandler input;
	static Level level;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.BITMASK);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();
	public static int bgX = 0;
	public static int bgY = 0;
	private Player player;

	// private Sound sound ;

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setLocationRelativeTo(null);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		frame.add(game);
		frame.pack();
		game.init();
		game.start();
	}

	public Game() {
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);

		input = new InputHandler();
		addKeyListener(input);
	}

	public void init() {
		screen = new Screen(WIDTH, HEIGHT);
		level = new Level(new Resource(), Levels.LEVEL4, screen);
		level.loadLevel();
		player = new Player(screen, true);
		// sound = new Sound("/test.wav");
	}

	public void start() {
		thread.start();
		running = true;
	}

	public void run() {
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerUpdate = 1 / 60.0;
		int updateCount = 0;
		boolean updated = false;

		while (running) {
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;

			while (unprocessedSeconds > secondsPerUpdate) {
				update();
				unprocessedSeconds -= secondsPerUpdate;
				updated = true;
				updateCount++;
				if (updateCount % 60 == 0) {
					System.out.println(frames + " fps");
					previousTime += 1000;
					frames = 0;
				}
			}
			if (updated) {
				render();
				frames++;
			}
			render();
			frames++;
			try {
				Thread.sleep(2);
			} catch (Exception e) {
			}
		}
	}

	public void update() {
		player.handlePlayer(input);
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			requestFocus();
			return;
		}

		// level.renderBackground(bgX, bgY, screen);

		player.renderPlayer(true);

		/** RENDERING THE PIXELS **/
		for (int y = 0; y < screen.h; y++) {
			for (int x = 0; x < screen.w; x++) {
				pixels[x + (y * WIDTH)] = screen.pixels[x + (y * screen.w)];
			}

		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setFont(new Font("Arial", 0, 15));
		g.drawString(TITLE + " " + VERSION, 5, 15);
		g.dispose();
		bs.show();
	}

	public void stop() {
		running = false;
	}

}

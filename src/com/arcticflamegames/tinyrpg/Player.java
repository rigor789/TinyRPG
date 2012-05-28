package com.arcticflamegames.tinyrpg;


public class Player {

	public int playerX, playerY;
	private Screen screen;
	private Sprite tile;
	//private boolean follow;
	//private Level level;
	//private int backX, backY;

	public Player(Screen screen, Sprite sprite) {
		this.screen = screen;
		this.tile = sprite;
	}

	/*
	 * public void handlePlayer(InputHandler input) { if
	 * (input.keys[KeyEvent.VK_RIGHT]) { //if (playerX < level.w * 16) { // 0 0
	 * 0 1 playerX = (playerX) + 1; // backX = backX + 1; // 200 200 0 1 // 201
	 * 201 1 1
	 * 
	 * //} 201 200 if (playerX > screen.w - 100) {
	 * 
	 * // playerX = backX + playerX + 1; backX = -(playerX - (screen.w - 100));
	 * // playerX = -(backX - (screen.w - 100));
	 * 
	 * } } if (input.keys[KeyEvent.VK_LEFT]) { if (playerX > 0) { playerX =
	 * backX + playerX - 1; } if (playerX + backX < 100) {
	 * 
	 * // playerX = backX + playerX + 1; // backX = playerX - 200; } } if
	 * (input.keys[KeyEvent.VK_UP]) { if (playerY > 0) playerY = backY + playerY
	 * - 1; } if (input.keys[KeyEvent.VK_DOWN]) { if (playerY < level.h * 16)
	 * playerY = backY + playerY + 1; } }
	 */

	public void renderPlayer() {
		// this.playerX = x;
		// this.playerY = y;

		/*
		 * if (follow) { moveBackground(); } if (handleBG) {
		 * level.renderBackground(backX, backY, screen); }
		 */
		screen.renderSprite(playerX, playerY, tile);
	}

	public int getPlayerX() {
		return playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerPosition(int x, int y) {
		this.playerX = x;
		this.playerY = y;
	}

	public void setPlayerX(int x) {
		this.playerX = x;
	}

	public void setPlayerY(int y) {
		this.playerY = y;
	}

	/*
	 * public void moveBackground() { System.out.println("Player x: " + playerX
	 * + " y: " + playerY); // System.out.println("Level w: " + level.w * 16 +
	 * " h: " + level.h * // 16); System.out.println("Backgorund x: " + backX +
	 * " y: " + backY); if (playerX + backX > screen.w - 100) {
	 * System.out.println("PLAYER IS OVER 200 px "); // backX++; } if (playerX <
	 * 100) { // System.out.println("true");
	 * 
	 * } }
	 */

}

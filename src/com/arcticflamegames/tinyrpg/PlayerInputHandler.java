package com.arcticflamegames.tinyrpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class PlayerInputHandler implements KeyListener, MouseInputListener {

	private Player player;
	private int right, left, up, down;
	public boolean[] keys = new boolean[65536];
	public boolean[] mouseButtons = new boolean[3];
	public boolean mouseDrag = false;
	public int mouseX = 0, mouseY = 0;

	public PlayerInputHandler(Player player) {
		this.player = player;
		this.right = KeyEvent.VK_RIGHT;
		this.left = KeyEvent.VK_LEFT;
		this.up = KeyEvent.VK_UP;
		this.down = KeyEvent.VK_DOWN;
	}

	public PlayerInputHandler(Player player, int right, int left, int up,
			int down) {
		this.player = player;
		this.right = right;
		this.left = left;
		this.up = up;
		this.down = down;
	}

	public void handleInput() {
		if (keys[right]) {
			if (canMove())
				player.setPlayerX(player.getPlayerX() + 1);
		}
		if (keys[left]) {
			if (canMove())
				player.setPlayerX(player.getPlayerX() - 1);
		}
		if (keys[up]) {
			if (canMove())
				player.setPlayerY(player.getPlayerY() - 1);
		}
		if (keys[down]) {
			if (canMove())
				player.setPlayerY(player.getPlayerY() + 1);
		}
	}

	public boolean canMove() {
		if (player.getPlayerX() > -1 && player.getPlayerY() > -1)
			return true;
		if (player.getPlayerX() >= 0 && player.getPlayerY() >= 0 && (keys[right]  || keys[down]))
			return true;

		return false;
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void mousePressed(java.awt.event.MouseEvent e) {
		int ButtonCode = e.getButton();
		mouseButtons[ButtonCode] = true;
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
		int ButtonCode = e.getButton();
		mouseButtons[ButtonCode] = false;
	}

	public void mouseDragged(java.awt.event.MouseEvent e) {
		mouseDrag = true;
	}

	public void mouseMoved(java.awt.event.MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		keys[keyCode] = true;
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		keys[keyCode] = false;
	}

}

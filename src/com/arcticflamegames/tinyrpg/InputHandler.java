package com.arcticflamegames.tinyrpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.event.MouseInputListener;


public class InputHandler implements KeyListener, MouseInputListener, MouseMotionListener, MouseWheelListener{

	public boolean[] keys = new boolean[65536];
	public boolean[] mouseButtons = new boolean [3]; 
	public boolean mouseDrag = false;
	public int mouseX = 0, mouseY = 0;
	
	public void mouseClicked(java.awt.event.MouseEvent e) {}

	public void mouseEntered(java.awt.event.MouseEvent e) {}

	public void mouseExited(java.awt.event.MouseEvent e) {}

	public void mousePressed(java.awt.event.MouseEvent e) {
		int ButtonCode = e.getButton();
		mouseButtons[ButtonCode] = true;
	}

	public void mouseReleased(java.awt.event.MouseEvent e) {
		int ButtonCode = e.getButton();
		mouseButtons[ButtonCode] = false;
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		//TODO
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

	public void keyTyped(KeyEvent e) {}


}

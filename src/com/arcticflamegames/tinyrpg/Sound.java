package com.arcticflamegames.tinyrpg;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound extends Thread {

	private Clip clip;
	private AudioInputStream audioIn;
	private URL url;

	public Sound(String path) {
		url = Game.class.getResource(path);
		this.start();
	}

	public void play() {

		try {
			audioIn = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		clip.start();

	}

}

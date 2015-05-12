package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

public enum ElementoSonoro {

	FUNDO("/fundo.wav"), 
	MORREU("/morreu.wav"), 
	MACA("/moeda.wav");

	private Clip clip;
	private int position;

	ElementoSonoro(String caminhoSom) {
		try {
			// Use URL (instead of File) to read from disk and JAR.
			URL url = this.getClass().getClassLoader().getResource(caminhoSom);
			// Set up an audio input stream piped from the sound file.
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(url);
			// Get a clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	// Play or Re-play the sound effect from the beginning, by rewinding.
	public void play() {
		if (clip.isRunning()) {
			clip.stop(); // Stop the player if it is still running
		}
		clip.setFramePosition(0); // rewind to the beginning
		clip.start(); // Start playing
	}
	
	public void resume(){
		if (clip.isRunning()) {
			this.position = clip.getFramePosition();
			clip.stop(); 
		} else {
			clip.setFramePosition(position);
			clip.start();
		}
	}

	// Optional static method to pre-load all the sound files.
	static void init() {
		values(); // calls the constructor for all the elements
	}

}
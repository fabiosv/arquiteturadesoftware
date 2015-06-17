package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo;

import java.io.IOException;

import javax.sound.sampled.*;

public enum ElementoSonoro {

	FUNDO("/fundo.wav"), 
	MORREU("/morreu.wav"), 
	MACA("/moeda.wav"), 
	GANHOU("/ganhou.wav"),
	RELOGIO("/relogio.wav"),
	;

	private Clip clip;
	private int position;

	ElementoSonoro(String caminhoSom) {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(getClass().getResourceAsStream(
							caminhoSom));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void play() {
		if (clip.isRunning()) {
			clip.stop();
		}
		clip.setFramePosition(0);
		clip.start();
	}

	public void pause(){
		if (clip.isRunning()) {
			this.position = clip.getFramePosition();
			clip.stop();
		}
	}
	
	public void resume() {
		if(!clip.isRunning()){
			clip.setFramePosition(position);
			clip.start();
		}		
	}
	
	public void stop(){
		if (clip.isRunning()) {
			this.position = clip.getFramePosition();
			clip.stop();
		}
	}
}

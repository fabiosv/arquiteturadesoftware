package com.github.awvalenti.arquiteturadesoftware.rpg1.versao3.telainicialoo;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum Elemento {

	AGUA("/agua.png"),
	MACA("/maca.png"),
	PERSONAGEM("/personagem.png"),
	GRAMA("/grama.png"),
	;

	private final String caminhoImagem;
	private final Icon icone;

	Elemento(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
		
		try {
			this.icone = new ImageIcon(ImageIO.read(MainOO.class.getResourceAsStream(caminhoImagem)));//Main
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	
	public Icon getIcone(){
		return icone;
	}

}

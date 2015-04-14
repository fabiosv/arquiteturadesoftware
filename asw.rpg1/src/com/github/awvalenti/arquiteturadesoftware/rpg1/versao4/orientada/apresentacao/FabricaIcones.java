package com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.orientada.apresentacao;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.orientada.logica.Elemento;

public class FabricaIcones {

	public static Icon carregar(Elemento novoElemento){
		try {
			return new ImageIcon(ImageIO.read(new File(novoElemento.getCaminhoImagem())));
		} catch (IOException e) {
			return null;
		}
	}

}

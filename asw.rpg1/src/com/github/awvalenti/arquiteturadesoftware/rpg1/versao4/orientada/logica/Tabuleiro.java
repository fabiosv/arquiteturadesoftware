package com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.orientada.logica;
import com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.orientada.*;
import com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.passagem.Elemento;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Tabuleiro {

	private Posicao passagem;
	private List<Posicao> macas = new ArrayList<Posicao>();
	private List<Posicao> agua = new ArrayList<Posicao>();
	private Elemento[][] disposicaoInicial;
	private Elemento[][] tabuleiro;

	public Tabuleiro(Elemento[][] disposicaoInicial) {
		this.disposicaoInicial = disposicaoInicial;
		Posicao dimensao = this.dimensaoTabuleiro();
		
		for (int i = 0; i < dimensao.getLinha(); i++) {
			for (int j = 0; j < dimensao.getColuna(); j++) {
				Elemento elemento = disposicaoInicial[i][j];
				if (elemento == Elemento.MACA______) {
					macas.add(new Posicao(i,j));

				} else if (elemento == Elemento.PASSAGEM__) {
					passagem = new Posicao(i,j);
					this.setElemento(new Posicao(i,j), Elemento.GRAMA_____);
				}
			}
		}
	}

	public boolean pegouMaca(Posicao posicaoPersonagem) {
		for (Posicao maca : macas) {
			if(posicaoPersonagem.equals(maca)){
				macas.remove(maca);
				return true;
			}
		}
		return false;
	}

	public boolean caiuNaAgua(Posicao personagem) {
		return false;
	}

	public Elemento getElemento(Posicao campo) {
		return tabuleiro[campo.getLinha()][campo.getColuna()];
	}

	public Posicao dimensaoTabuleiro(){
		return new Posicao(this.disposicaoInicial.length,disposicaoInicial[0].length);
	}
	public void setElemento(Posicao campo, Elemento elemento) {
		
	}

}

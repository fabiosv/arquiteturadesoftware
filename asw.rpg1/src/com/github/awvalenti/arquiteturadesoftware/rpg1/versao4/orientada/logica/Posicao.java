package com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.orientada.logica;

public class Posicao {

	private final int linha;
	private final int coluna;

	public Posicao() {
		this.linha = 0;
		this.coluna = 0;
	}
	
	public Posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	public Posicao setColuna(int coluna){
		return new Posicao(this.linha, coluna);
	}
	
	public Posicao setLinha(int linha){
		return new Posicao(linha, this.coluna);
	}
}

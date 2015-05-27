package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo;

import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.apresentacao.FabricaSom;

public class Tabuleiro implements SaidaTemporizador{

	private Elemento[][] matriz;
	private SaidaJogo saida;
	private Posicao posicaoDoPortalOculto;
	
	private Temporizador temporizador;
	private FabricaSom fabricaSom;

	public Tabuleiro(Elemento[][] matriz, int tempoFase) {
		this.matriz = matriz;
		this.temporizador = new Temporizador(this, tempoFase);
	}

	public void setSaida(SaidaJogo saida) {
		this.saida = saida;
		//this.fabricaSom;
	}

	public void iniciarJogo() {
		ocultarPortal();
		saida.iniciarJogo();
		temporizador.iniciarRegressao();
	}

	public int getNumeroLinhas() {
		return matriz.length;
	}

	public int getNumeroColunas() {
		return matriz[0].length;
	}

	public Elemento elementoEm(Posicao posicao) {
		return matriz[posicao.getLinha()][posicao.getColuna()];
	}

	public void fazerMovimento(Direcao d) {
		Posicao posicaoAntiga = acharPosicaoDe(Elemento.PERSONAGEM);
		Posicao posicaoNova = posicaoAntiga.somar(d);

		if (posicaoEhInvalida(posicaoNova)) return;

		Elemento elementoAlcancado = elementoEm(posicaoNova);

		alterarElemento(posicaoAntiga, Elemento.GRAMA);
		alterarElemento(posicaoNova, Elemento.PERSONAGEM);

		switch (elementoAlcancado) {
		case AGUA:
			saida.perderJogo();
			break;

		case MACA:
			FabricaSom.pegouMaca();
			if (quantidadeMacasRestantes() == 0) reexibirPortal();
			break;

		case PORTAL:
			saida.passarDeFase();
			break;

		default:
			break;
		}

	}

	private void ocultarPortal() {
		posicaoDoPortalOculto = acharPosicaoDe(Elemento.PORTAL);
		alterarElemento(posicaoDoPortalOculto, Elemento.GRAMA);
	}

	private void reexibirPortal() {
		alterarElemento(posicaoDoPortalOculto, Elemento.PORTAL);
	}

	private void alterarElemento(Posicao posicao, Elemento e) {
		matriz[posicao.getLinha()][posicao.getColuna()] = e;
		saida.alterarElemento(posicao, e);
	}

	private int quantidadeMacasRestantes() {
		int ret = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == Elemento.MACA) ++ret;
			}
		}

		return ret;
	}

	private Posicao acharPosicaoDe(Elemento elemento) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == elemento) {
					return new Posicao(i, j);
				}
			}
		}

		return null;
	}

	private boolean posicaoEhInvalida(Posicao p) {
		return p.getLinha() < 0 || p.getLinha() >= getNumeroLinhas()
				|| p.getColuna() < 0 || p.getColuna() >= getNumeroColunas();
	}

	@Override
	public void tique(int tempoRestante) {
		if(tempoRestante>0){
			saida.alterarRelogio(tempoRestante);
		} else {
			saida.alterarRelogio(tempoRestante);
			saida.perderJogo();
		}
	}

}

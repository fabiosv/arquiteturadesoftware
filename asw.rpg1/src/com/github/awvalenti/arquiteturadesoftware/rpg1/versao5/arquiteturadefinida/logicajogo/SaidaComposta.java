package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaidaComposta implements SaidaJogo {

	List<SaidaJogo> saidas = new ArrayList<SaidaJogo>();
	
	public SaidaComposta(SaidaJogo... saidas){
		this.saidas = Arrays.asList(saidas);
		
	}
	
	@Override
	public void iniciarJogo() {
		for (SaidaJogo saidaJogo : saidas) {
			saidaJogo.iniciarJogo();
		}
	}

	@Override
	public void alterarElemento(Posicao posicao, Elemento novo) {
		for (SaidaJogo saidaJogo : saidas) {
			saidaJogo.alterarElemento(posicao, novo);
		}

	}

	@Override
	public void passarDeFase() {
		for (SaidaJogo saidaJogo : saidas) {
			saidaJogo.passarDeFase();
		}

	}

	@Override
	public void perderJogo() {
		for (SaidaJogo saidaJogo : saidas) {
			saidaJogo.perderJogo();
		}

	}

	@Override
	public void alterarRelogio(int tempo) {
		for (SaidaJogo saidaJogo : saidas) {
			saidaJogo.alterarRelogio(tempo);
		}
	}

	@Override
	public void pegouMaca() {
		for (SaidaJogo saidaJogo : saidas) {
			saidaJogo.pegouMaca();
		}

	}

}

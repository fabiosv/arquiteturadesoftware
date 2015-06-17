package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.apresentacao;

import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.Elemento;
import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.ElementoSonoro;
import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.Posicao;
import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.SaidaJogo;

public class SaidaSonora implements SaidaJogo{
	
	public SaidaSonora() {}
	
	@Override
	public void pegouMaca(){
		ElementoSonoro.MACA.play();
	}

	@Override
	public void iniciarJogo() {
		ElementoSonoro.FUNDO.play();		
	}

	@Override
	public void passarDeFase() {
		ElementoSonoro.FUNDO.pause();
		ElementoSonoro.RELOGIO.stop();
		ElementoSonoro.GANHOU.play();		
	}

	@Override
	public void perderJogo() {
		ElementoSonoro.FUNDO.pause();
		ElementoSonoro.RELOGIO.stop();
		ElementoSonoro.MORREU.play();
	}

	@Override
	public void alterarRelogio(int tempo) {
		if(tempo<=5){
			ElementoSonoro.RELOGIO.play();
		}
	}
	
	@Override
	public void alterarElemento(Posicao posicao, Elemento novo) {}

}

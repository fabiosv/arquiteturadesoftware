package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.apresentacao;

import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.ElementoSonoro;

public class FabricaSom {
	
	public FabricaSom() {
	}
	
	public void comecarJogo(){
		ElementoSonoro.FUNDO.play();
	}
	
	public static void pegouMaca(){
		ElementoSonoro.MACA.play();
	}
	
	public void perdeu(){
		ElementoSonoro.FUNDO.resume();
		ElementoSonoro.MORREU.play();
	}
	
	public void acabouFase(){
		ElementoSonoro.FUNDO.resume();
		ElementoSonoro.GANHOU.play();
	}
}

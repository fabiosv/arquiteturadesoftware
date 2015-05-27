package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo;

import java.util.Timer;
import java.util.TimerTask;

public class Temporizador{
	
	private Timer timer;
	private SaidaTemporizador saidaTemporizador;
	private int tempoInicial;
	
	public Temporizador(SaidaTemporizador saidaTemporizador, int tempoInicial){
		this.timer = new Timer();
		this.saidaTemporizador = saidaTemporizador;
		this.tempoInicial = tempoInicial;
	}
	
	public void iniciarContador(){
		timer.scheduleAtFixedRate(new CountDown(), 0, 1000);
	}
	
	public void pararContador(){
		timer.cancel();
	}

	private class CountDown extends TimerTask{
		private int tempoRestante;
		
		public CountDown() {
			this.tempoRestante = tempoInicial;
		}

		@Override
		public void run() {
			if(tempoRestante>=0){
				saidaTemporizador.tique(tempoRestante);
				tempoRestante--;
			} else {
				timer.cancel();
			}
		}		
	}
}

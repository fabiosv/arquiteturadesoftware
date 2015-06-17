package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hud extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Font fonteNormal  = new Font("Serif",0,24);
	private final Font fonteNegrito = new Font("Serif",1,24);

	private JLabel relogio;

	public Hud(int colunas) {
		this.setLayout(new GridLayout());
		this.setBackground(Color.WHITE);
		gerarHud();
	}

	private void gerarHud() {
		criarRelogio();
	}

	private void criarRelogio() {
		relogio = new JLabel();
		relogio.setText("00:00");
		relogio.setFont(fonteNormal);
		this.add(relogio);
	}

	public void alterarRelogio(int tempo) {
		relogio.setForeground(tempo <= 10 ? Color.RED : Color.BLACK);
		
		if(tempo <= 10){
			relogio.setFont(tempo%2 == 0 ? fonteNormal : fonteNegrito);
		}

		String relogioTexto = String.format("%02d:%02d", tempo / 60, tempo % 60);
		relogio.setText(relogioTexto);
		// System.out.println(relogioTexto);
	}
}

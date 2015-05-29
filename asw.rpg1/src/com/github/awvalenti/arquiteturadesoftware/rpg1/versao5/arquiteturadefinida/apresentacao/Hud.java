package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hud {

	private JPanel hud;

	private JLabel relogio;

	public Hud(int colunas) {
		this.hud = new JPanel(new GridLayout());
		hud.setSize(colunas, 0);
		System.out.printf("altura:%d,largura:%d\n", hud.getSize().height, hud.getSize().width);
		hud.setBackground(Color.WHITE);
		gerarHud();
	}

	private void gerarHud() {
		criarRelogio();
	}

	private void criarRelogio() {
		relogio = new JLabel();
		relogio.setText("00:00");
		relogio.setFont(new Font("Serif",0,24));
		hud.add(relogio);
	}

	public JPanel getHud() {
		return hud;
	}

	public void alterarRelogio(int tempo) {
		relogio.setForeground(tempo <= 10 ? Color.RED : Color.BLACK);
		
		if(tempo <= 10){
			relogio.setFont(tempo%2 == 0 ? new Font("Serif",0,24) : new Font("Serif",1,24));
		}

		String relogioTexto = String.format("%02d:%02d", tempo / 60, tempo % 60);
		relogio.setText(relogioTexto);
		// System.out.println(relogioTexto);
	}
}

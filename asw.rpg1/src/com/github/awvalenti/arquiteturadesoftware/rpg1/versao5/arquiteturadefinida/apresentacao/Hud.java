package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.apresentacao;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.*;

public class Hud {

	private JPanel hud;
	private FabricaIcones fabricaIcones;

	private int colunas;

	private JLabel relogio;

	private int quantidadeDeVidaInicial = 5;

	public Hud(int colunas) {
		this.hud = new JPanel(new GridLayout());
		hud.setSize(colunas, 0);
		System.out.printf("altura:%d,largura:%d\n", hud.getSize().height, hud.getSize().width);
		hud.setBackground(Color.WHITE);
		this.colunas = colunas;
		this.fabricaIcones = new FabricaIcones();
		gerarHud();
	}

	private void gerarHud() {
		criarRelogio();
		preencherEspacosVazios();
	}

	private void criarRelogio() {
		relogio = new JLabel();
		relogio.setText("00:00");
		hud.add(relogio);
	}

	private void preencherEspacosVazios() {
		int total = quantidadeDeVidaInicial + 4;
		for (; total < colunas; ++total) {
			hud.add(new JLabel(fabricaIcones.obterIcone(Elemento.NADA)));
		}
	}

	public JPanel getHud() {
		return hud;
	}

	public void alterarRelogio(int tempo) {
		if (tempo <= 10) {
			relogio.setForeground(Color.RED);
		} else {
			relogio.setForeground(Color.black);
		}
		String relogioTexto = String.format("%02d:%02d", tempo / 60, tempo % 60);
		relogio.setText(relogioTexto);
		// System.out.println(relogioTexto);
	}
}

package com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.orientada.apresentacao;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Robot;

import com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.orientada.logica.*;
import com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.passagem.Elemento;

public class TelaJogo {

	private Tabuleiro tabuleiro;
	private Posicao personagem;
	private JFrame frame = new JFrame();

	public TelaJogo(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.carregarTela();
	}

	private void carregarTela() {
		Posicao dimensaoTabuleiro = tabuleiro.dimensaoTabuleiro();
		frame.setLayout(new GridLayout(dimensaoTabuleiro.getLinha(), dimensaoTabuleiro.getColuna()));

		for (int i = 0; i < dimensaoTabuleiro.getLinha(); i++) {
			for (int j = 0; j < dimensaoTabuleiro.getColuna(); j++) {
				frame.add(new JLabel());
				this.alterarElementoNaTela(new Posicao(i,j), tabuleiro.getElemento(new Posicao(i,j)));
				if (tabuleiro.getElemento(new Posicao(i,j)) == Elemento.PERSONAGEM) {
					personagem = new Posicao(i,j);
				}
			}
		}

		frame.addKeyListener(new TecladoListener());

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void alterarElementoNaTela(Posicao campo, Elemento novoElemento) {
		try {
			((JLabel) frame.getContentPane().getComponent(campo.getLinha() *  tabuleiro.dimensaoTabuleiro().getColuna() + campo.getColuna())).setIcon(FabricaIcones.carregar(novoElemento));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void ganhou() {
			JOptionPane.showMessageDialog(frame, "Ganhou!", "Ganhou!",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
	}

	public void morreu() {
		JOptionPane.showMessageDialog(frame, "Perdeu!", "Perdeu!", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	

	private class TecladoListener implements KeyListener {

		private Posicao antigo = personagem;
		private Posicao novo = new Posicao();

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

			novo = novo.setLinha(antigo.getLinha());
			novo = novo.setColuna(antigo.getColuna());

			final int ESQUERDA = 37, CIMA = 38, DIREITA = 39, BAIXO = 40;

			switch (e.getKeyCode()) {
			case ESQUERDA:
				novo = novo.setColuna(antigo.getColuna() - 1);
				break;
			case CIMA:
				novo = novo.setLinha(antigo.getLinha() - 1);
				break;
			case DIREITA:
				novo = novo.setColuna(antigo.getColuna() + 1);
				break;
			case BAIXO:
				novo = novo.setLinha(antigo.getLinha() + 1);
				break;
			default:
				return;
			}
			
			alterarElementoNaTela(novo, tabuleiro.getElemento(novo));
			
			alterarElementoNaTela(novo, tabuleiro.getElemento(novo));
			alterarElemento(antigaLinha, antigaColuna, Elemento.GRAMA_____);
			alterarElemento(novaLinha, novaColuna, Elemento.PERSONAGEM);

			personagem = personagem.setLinha(novo.getLinha());
			personagem = personagem.setColuna(novo.getColuna());
		}

	}

}

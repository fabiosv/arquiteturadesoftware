package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.apresentacao;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.Direcao;
import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.Elemento;
import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.Posicao;
import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.SaidaJogo;
import com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo.Tabuleiro;

public class TelaJogo implements SaidaJogo {

	private Tabuleiro tabuleiro;
	private FabricaIcones fabricaIcones;
	private FabricaSom fabricaSom;
	private JFrame frame;

	private Hud hud;
	private JPanel jogo;
	private JPanel container;

	public TelaJogo(Tabuleiro tabuleiro, FabricaIcones fabricaIcones, FabricaSom fabricaSom) {
		this.tabuleiro = tabuleiro;
		this.fabricaIcones = fabricaIcones;
		this.fabricaSom = fabricaSom;

		frame = new JFrame();

		jogo = new JPanel();
		jogo.setLayout(new GridLayout(tabuleiro.getNumeroLinhas(), tabuleiro.getNumeroColunas()));
		
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		hud = new Hud(tabuleiro.getNumeroColunas());

		// frame.setLayout(new GridLayout(tabuleiro.getNumeroLinhas(),
		// tabuleiro.getNumeroColunas()));
		frame.addKeyListener(new TecladoListener());

		container.add(hud.getHud());
		container.add(jogo);

		frame.add(container);
		// frame.add(gerarTelaJogo());

		preencherTela();

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JPanel gerarTelaJogo() {
		jogo.setLayout(new GridLayout(tabuleiro.getNumeroLinhas(), tabuleiro
				.getNumeroColunas()));
		
		// preencherTela(jogo);
		return container;
	}
	
	@Override
	public void alterarRelogio(int tempo) {
		hud.alterarRelogio(tempo);		
	}
	
	private void preencherTela() {
		for (int i = 0; i < tabuleiro.getNumeroLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getNumeroColunas(); j++) {
				 jogo.add(new JLabel(fabricaIcones.obterIcone(tabuleiro.elementoEm(new Posicao(i, j)))));
			}
		}
	}
	
	public FabricaSom getFabricaSom() {
		return fabricaSom;
	}

	@Override
	public void iniciarJogo() {
		frame.setVisible(true);
		fabricaSom.comecarJogo();
	}

	@Override
	public void alterarElemento(Posicao posicao, Elemento elemento) {
		int indice = tabuleiro.getNumeroColunas() * posicao.getLinha()
				+ posicao.getColuna();
		//((JLabel) frame.getContentPane().getComponent(indice)).setIcon(fabricaIcones.obterIcone(elemento));
		((JLabel) jogo.getComponent(indice)).setIcon(fabricaIcones.obterIcone(elemento));
	}

	@Override
	public void passarDeFase() {
		fabricaSom.acabouFase();
		JOptionPane.showMessageDialog(frame, "Ganhou!", "Ganhou!",
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	@Override
	public void perderJogo() {
		fabricaSom.perdeu();
		JOptionPane.showMessageDialog(frame, "Perdeu!", "Perdeu!",
				JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}

	private class TecladoListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			Direcao direcao = Direcao.comCodigo(e.getKeyCode());
			if (direcao != null)
				tabuleiro.fazerMovimento(direcao);
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

	}



}

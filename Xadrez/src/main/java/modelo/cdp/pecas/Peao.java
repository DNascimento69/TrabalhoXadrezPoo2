package modelo.cdp.pecas;

import java.util.ArrayList;
import modelo.cdp.Posicao;
import modelo.cdp.Tabuleiro;
import modelo.cdp.Enum.ECorPeca;

public class Peao extends Peca {
	private boolean mexeu;
	
//	public Peao(int x, int y, ECorPeca c, String n) {
//		this.setPosicao(new Posicao(x, y));
//		this.setCor(c);
//		this.setNome(n);
//		this.mexeu = false;
//	}

	public ArrayList<Posicao> criaListaDestinosPossiveis(Tabuleiro tabuleiro) { // vai retornar todos os pontos que o Peao pode ir
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		Peca pecaPos = null;
		
		if (this.getCor().compareTo(ECorPeca.BRANCO) == 0) {
			pecaPos = Tabuleiro.temPeca(tabuleiro, new Posicao(this.getPosicao().getX(), this.getPosicao().getY() + 1));
			if (pecaPos == null) { // verifica se tem alguma pe�a na posicao de destino
				posicoes.add(new Posicao(this.getPosicao().getX(), this.getPosicao().getY() + 1)); // adiciona a posi��o padr�o que o peao pode ir, que � uma a frente
				if (!this.mexeu) { // o pe�o pode andar duas casa se ele ainda n�o foi movido
					pecaPos = Tabuleiro.temPeca(tabuleiro, new Posicao(this.getPosicao().getX(), this.getPosicao().getY() + 2));
					if(pecaPos == null) { // verifica se tem alguma pe�a na posicao de destino
						posicoes.add(new Posicao(this.getPosicao().getX(), this.getPosicao().getY() + 2)); // o peao pode se mover duas casas, se ainda nao se moveu
					}
				}
			}

			// considerando que o peao pode comer apenas nas diagonais

			// direita
			int buscaX = this.getPosicao().getX() + 1;
			int buscaY = this.getPosicao().getY() + 1;
			if ((buscaX <= 7) && (buscaY <= 7)) {
				Posicao novaPos = new Posicao(buscaX, buscaY);
				pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
				if ((pecaPos != null) && (this.getCor() != pecaPos.getCor())) { // verifica se tem alguma pe�a na posicao de destino
					posicoes.add(novaPos);
				}
			}
			
			//esquerda
			buscaX = this.getPosicao().getX() - 1;
			if ((buscaX >= 0) && (buscaY <= 7)) {
				Posicao novaPos = new Posicao(buscaX, buscaY);
				pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
				if ((pecaPos != null) && (this.getCor() != pecaPos.getCor())) { // verifica se tem alguma pe�a na posicao de destino
					posicoes.add(novaPos);
				}
			}
		} else {
			pecaPos = Tabuleiro.temPeca(tabuleiro, new Posicao(this.getPosicao().getX(), this.getPosicao().getY() - 1));
			if (pecaPos == null) { // verifica se tem alguma pe�a na posicao de destino
				posicoes.add(new Posicao(this.getPosicao().getX(), this.getPosicao().getY() - 1)); // adiciona a posi��o padr�o que o peao pode ir, que � uma a frente
				
				if (!this.mexeu) { // o pe�o pode andar duas casa se ele ainda n�o foi movido
					pecaPos = Tabuleiro.temPeca(tabuleiro, new Posicao(this.getPosicao().getX(), this.getPosicao().getY() - 2));
					if(pecaPos == null) { // verifica se tem alguma pe�a na posicao de destino
						posicoes.add(new Posicao(this.getPosicao().getX(), this.getPosicao().getY() - 2)); // o peao pode se mover duas casas, se ainda nao se moveu
					}
				}
			}

			// considerando que o peao pode comer apenas nas diagonais

			// direita
			int buscaX = this.getPosicao().getX() + 1;
			int buscaY = this.getPosicao().getY() - 1;
			if ((buscaX <= 7) && (buscaY <= 7)) {
				Posicao novaPos = new Posicao(buscaX, buscaY);
				pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
				if ((pecaPos != null) && (this.getCor() != pecaPos.getCor())) { // verifica se tem alguma pe�a na posicao de destino
					posicoes.add(novaPos);
				}
			}
			
			//esquerda
			buscaX = this.getPosicao().getX() - 1;
			if ((buscaX >= 0) && (buscaY <= 7)) {
				Posicao novaPos = new Posicao(buscaX, buscaY);
				pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
				if ((pecaPos != null) && (this.getCor() != pecaPos.getCor())) { // verifica se tem alguma pe�a na posicao de destino
					posicoes.add(novaPos);
				}
			}
		}
		return posicoes;
	}
	
	public void setMexeu(boolean m) {
		this.mexeu = m;
	}
	
	public void setPosicao(Posicao posicao, Tabuleiro tabuleiro) {
		super.setPosicao(posicao);
		if ((posicao.getY() == 7) || (posicao.getY() == 0)) {
			int x = 0;
			boolean achou = false;
			while ((x < tabuleiro.getPecas().size()) && (!achou)) { // verificando em toda lista de posi�oes possiveis para aquela pe�a que sera movida
				if ((tabuleiro.getPecas().get(x).getPosicao().getX() == posicao.getX()) 
						&& (tabuleiro.getPecas().get(x).getPosicao().getY() == posicao.getY())) { // se for uma das posi�oes validas, ele retorna true
					tabuleiro.getPecas().remove(x);
					tabuleiro.getPecas().add(new Rainha(posicao.getX(), posicao.getY(), this.getCor(), "RAINHA"));
				}
				x++;
			}
		}
	}
}

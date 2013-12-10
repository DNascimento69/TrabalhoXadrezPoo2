package modelo.cdp.pecas;

import java.util.ArrayList;
import modelo.cdp.Posicao;
import modelo.cdp.Tabuleiro;

public class Bispo extends Peca {
	
//	public Bispo(int x, int y, ECorPeca c, String n) {
//		this.setPosicao(new Posicao(x, y));
//		this.setCor(c);
//		this.setNome(n);
//	}
	
	// esta função retorna TODAS as possibilidades de destinos do Bispo, incluindo as que ele pode comer alguma peça
	public ArrayList<Posicao> criaListaDestinosPossiveis(Tabuleiro tabuleiro) {
		// o bispo pode andar em tres direçoes --  direita ou esquerda, para cima ou para baixo
		
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		// esquerda - para cima
		int buscaX = this.getPosicao().getX() - 1;
		int buscaY = this.getPosicao().getY() + 1;
		while ((buscaX >= 0) && (buscaY <= 7)) {
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) { // verifica se tem alguma peça na posicao de destino
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a peça nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaX--;
			buscaY++;
		}
		
		// esquerda - para baixo
		buscaX = this.getPosicao().getX() - 1;
		buscaY = this.getPosicao().getY() - 1;
		while((buscaX >= 0) && (buscaY >= 0)) {
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) { // verifica se tem alguma peça na posicao de destino
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a peça nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaX--;
			buscaY--;
		}
		
		// direita - para cima
		buscaX = this.getPosicao().getX() + 1;
		buscaY = this.getPosicao().getY() + 1;
		while((buscaX <= 7) && (buscaY <= 7)) {
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) { // verifica se tem alguma peça na posicao de destino
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a peça nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaX++;
			buscaY++;
		}
		
		// direita - para baixo
		buscaX = this.getPosicao().getX() + 1;
		buscaY = this.getPosicao().getY() - 1;
		while((buscaX <= 7) && (buscaY >= 0)) {
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) { // verifica se tem alguma peça na posicao de destino
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a peça nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaX++;
			buscaY--;
		}
		
		return posicoes;
	}
}

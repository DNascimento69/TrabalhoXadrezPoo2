package modelo.cdp.pecas;

import java.util.ArrayList;
import modelo.cdp.Posicao;
import modelo.cdp.Tabuleiro;

public class Torre extends Peca {
	
//	public Torre(int x, int y, ECorPeca c, String n) {
//		this.setPosicao(new Posicao(x, y));
//		this.setCor(c);
//		this.setNome(n);
//	}

	// esta fun��o retorna TODAS as possibilidades de destinos da Torre, incluindo as que ela pode comer alguma pe�a
	public ArrayList<Posicao> criaListaDestinosPossiveis(Tabuleiro tabuleiro)
	{
		// a Torre pode andar para Norte, Sul, Leste e Oeste ateh o fim do tabuleiro ou ateh encontrar uma pe�a
		
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		// Norte
		int buscaY = this.getPosicao().getY() + 1;
		while (buscaY <= 7)
		{
			Posicao novaPos = new Posicao(this.getPosicao().getX(), buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma pe�a na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a pe�a da posi�ao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a pe�a nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaY++;
		}
		
		// Sul
		buscaY = this.getPosicao().getY() - 1;
		while (buscaY >= 0)
		{
			Posicao novaPos = new Posicao(this.getPosicao().getX(), buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma pe�a na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a pe�a da posi�ao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a pe�a nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaY--;
		}
		
		// Leste
		int buscaX = this.getPosicao().getX() + 1;
		while (buscaX <= 7)
		{
			Posicao novaPos = new Posicao(buscaX, this.getPosicao().getY());
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma pe�a na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a pe�a da posi�ao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a pe�a nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaX++;
		}
		
		// Oeste
		buscaX = this.getPosicao().getX() - 1;
		while (buscaX >= 0)
		{
			Posicao novaPos = new Posicao(buscaX, this.getPosicao().getY());
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma pe�a na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a pe�a da posi�ao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a pe�a nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaX--;
		}
		
		return posicoes;
	}
}

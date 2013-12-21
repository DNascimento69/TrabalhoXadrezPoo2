package modelo.cdp.pecas;

import java.util.ArrayList;

import modelo.cdp.Posicao;
import modelo.cdp.Tabuleiro;
import modelo.cdp.Enum.EPeca;

public class Torre extends Peca {
	
	public Torre() {
		setPontos(5);
		setTipo(EPeca.BISPO);
	}

	// esta função retorna TODAS as possibilidades de destinos da Torre, incluindo as que ela pode comer alguma peça
	public ArrayList<Posicao> criaListaDestinosPossiveis(Tabuleiro tabuleiro)
	{
		// a Torre pode andar para Norte, Sul, Leste e Oeste ateh o fim do tabuleiro ou ateh encontrar uma peça
		
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		// Leste
		int buscaY = this.getPosicao().getY() + 1;
		while (buscaY <= 7)
		{
			Posicao novaPos = new Posicao(this.getPosicao().getX(), buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a peça nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaY++;
		}
		
		// Oeste
		buscaY = this.getPosicao().getY() - 1;
		while (buscaY >= 0)
		{
			Posicao novaPos = new Posicao(this.getPosicao().getX(), buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a peça nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaY--;
		}
		
		// Norte
		int buscaX = this.getPosicao().getX() + 1;
		while (buscaX <= 7)
		{
			Posicao novaPos = new Posicao(buscaX, this.getPosicao().getY());
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a peça nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaX++;
		}
		
		// Sul
		buscaX = this.getPosicao().getX() - 1;
		while (buscaX >= 0)
		{
			Posicao novaPos = new Posicao(buscaX, this.getPosicao().getY());
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
				break; // sai do loop pois a peça nao pode andar mais que este ponto
			} else {
				posicoes.add(novaPos);
			}
			
			buscaX--;
		}
		
		return posicoes;
	}
}

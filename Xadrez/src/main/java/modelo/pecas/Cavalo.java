package modelo.pecas;

import java.util.ArrayList;

import modelo.Posicao;
import modelo.Tabuleiro;
import modelo.Enum.ECorPeca;

public class Cavalo extends Peca
{
	public Cavalo(int x, int y, ECorPeca c, String n)
	{
		this.setPosicao(new Posicao(x, y));
		this.setCor(c);
		this.setNome(n);
	}
	
	// esta função retorna TODAS as possibilidades de destinos do Cavalo, incluindo as que ele pode comer alguma peça
	public ArrayList<Posicao> criaListaDestinosPossiveis(Tabuleiro tabuleiro)
	{
		/* o Cavalo pode ir para Norte, Sul, Leste e Oeste
			escolhendo um desses sentidos ele pode seguir a direita ou esquerda de cada ponto que ele para
		*/
		
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();

		// caso 1: Norte
		if (this.getPosicao().getY() + 2 <= 7)
		{
			if (this.getPosicao().getX() + 1 <= 7)
			{
				Posicao norteDireita = new Posicao(this.getPosicao().getX() + 1, this.getPosicao().getY() + 2);
				Peca pecaPos = Tabuleiro.temPeca(tabuleiro, norteDireita);
				
				if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
				{
					if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
						posicoes.add(norteDireita);
				} else {
					posicoes.add(norteDireita);
				}
			}
			
			if (this.getPosicao().getX() - 1 >= 0)
			{
				Posicao norteEsquerda = new Posicao(this.getPosicao().getX() - 1, this.getPosicao().getY() + 2);
				Peca pecaPos = Tabuleiro.temPeca(tabuleiro, norteEsquerda);
				
				if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
				{
					if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
						posicoes.add(norteEsquerda);
				} else {
					posicoes.add(norteEsquerda);
				}
			}
		}
		
		// caso 2: Sul
		if (this.getPosicao().getY() - 2 >= 0)
		{
			if (this.getPosicao().getX() + 1 <= 7)
			{
				Posicao sulDireita = new Posicao(this.getPosicao().getX() + 1, this.getPosicao().getY() - 2);
				Peca pecaPos = Tabuleiro.temPeca(tabuleiro, sulDireita);
				
				if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
				{
					if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
						posicoes.add(sulDireita);
						System.out.print("ENTROU");
				} else {
					posicoes.add(sulDireita);
				}
			}
			
			if (this.getPosicao().getX() - 1 >= 0)
			{
				Posicao sulEsquerda = new Posicao(this.getPosicao().getX() - 1, this.getPosicao().getY() - 2);
				Peca pecaPos = Tabuleiro.temPeca(tabuleiro, sulEsquerda);
				
				if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
				{
					if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
						posicoes.add(sulEsquerda);
				} else {
					posicoes.add(sulEsquerda);
				}
			}
		}
		
		// caso 3: Leste
		if (this.getPosicao().getX() + 2 <= 7)
		{
			if (this.getPosicao().getY() - 1 >= 0)
			{
				Posicao lesteDireita = new Posicao(this.getPosicao().getX() + 2, this.getPosicao().getY() - 1);
				Peca pecaPos = Tabuleiro.temPeca(tabuleiro, lesteDireita);
				
				if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
				{
					if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
						posicoes.add(lesteDireita);
				} else {
					posicoes.add(lesteDireita);
				}
			}
			
			if (this.getPosicao().getY() + 1 <= 7)
			{
				Posicao lesteEsquerda = new Posicao(this.getPosicao().getX() + 2, this.getPosicao().getY() + 1);
				Peca pecaPos = Tabuleiro.temPeca(tabuleiro, lesteEsquerda);
				
				if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
				{
					if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
						posicoes.add(lesteEsquerda);
				} else {
					posicoes.add(lesteEsquerda);
				}
			}
		}

		// caso 4: Oeste
		if (this.getPosicao().getX() - 2 >= 0)
		{
			if (this.getPosicao().getY() + 1 <= 7)
			{
				Posicao oesteDireita = new Posicao(this.getPosicao().getX() - 2, this.getPosicao().getY() + 1);
				Peca pecaPos = Tabuleiro.temPeca(tabuleiro, oesteDireita);
				
				if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
				{
					if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
						posicoes.add(oesteDireita);
				} else {
					posicoes.add(oesteDireita);
				}
			}
			if (this.getPosicao().getY() - 1 >= 0)
			{
				Posicao oesteEsquerda = new Posicao(this.getPosicao().getX() - 2, this.getPosicao().getY() - 1);
				Peca pecaPos = Tabuleiro.temPeca(tabuleiro, oesteEsquerda);
				
				if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
				{
					if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
						posicoes.add(oesteEsquerda);
				} else {
					posicoes.add(oesteEsquerda);
				}
			}
		}
		
		return posicoes;
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

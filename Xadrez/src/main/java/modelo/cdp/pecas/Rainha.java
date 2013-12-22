package modelo.cdp.pecas;

import java.util.ArrayList;

import modelo.cdp.Posicao;
import modelo.cdp.Tabuleiro;
import modelo.cdp.Enum.EPeca;

public class Rainha extends Peca {
	
	private static final long serialVersionUID = 1L;

	public Rainha() {
		setPontos(9);
		setTipo(EPeca.RAINHA);
	}

	// esta função retorna TODAS as possibilidades de destinos da Rainha, incluindo as que ela pode comer alguma peça
	public ArrayList<Posicao> criaListaDestinosPossiveis(Tabuleiro tabuleiro) 
	{
		// A rainha pode se movimentar como o Bispo e a Torre
		
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();

		// Estilo Bispo
		
			// esquerda - para cima
			int buscaX = this.getPosicao().getX() - 1;
			int buscaY = this.getPosicao().getY() + 1;
			while ((buscaX >= 0) && (buscaY <= 7))
			{
				Posicao novaPos = new Posicao(buscaX, buscaY);
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
				buscaY++;
			}
			
			// esquerda - para baixo
			buscaX = this.getPosicao().getX() - 1;
			buscaY = this.getPosicao().getY() - 1;
			while((buscaX >= 0) && (buscaY >= 0))
			{
				Posicao novaPos = new Posicao(buscaX, buscaY);
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
				buscaY--;
			}
			
			// direita - para cima
			buscaX = this.getPosicao().getX() + 1;
			buscaY = this.getPosicao().getY() + 1;
			while((buscaX <= 7) && (buscaY <= 7))
			{
				Posicao novaPos = new Posicao(buscaX, buscaY);
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
				buscaY++;
			}
			
			// direita - para baixo
			buscaX = this.getPosicao().getX() + 1;
			buscaY = this.getPosicao().getY() - 1;
			while((buscaX <= 7) && (buscaY >= 0))
			{
				Posicao novaPos = new Posicao(buscaX, buscaY);
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
				buscaY--;
			}
		
		// Fim do estilo Bispo

		// Estilo Torre
			// Norte
			buscaY = this.getPosicao().getY() + 1;
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
			
			// Sul
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
			
			// Leste
			buscaX = this.getPosicao().getX() + 1;
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
			
			// Oeste
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
		// Fim do estilo Torre
		
		return posicoes;
	}
}

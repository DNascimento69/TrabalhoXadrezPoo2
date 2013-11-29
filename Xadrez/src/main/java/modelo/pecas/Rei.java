package modelo.pecas;

import java.util.ArrayList;

import modelo.Posicao;
import modelo.Tabuleiro;
import modelo.Enum.ECorPeca;

public class Rei extends Peca
{
	boolean emXeque;
	
	public Rei(int x, int y, ECorPeca c, String n)
	{
		this.setPosicao(new Posicao(x, y));
		this.setCor(c);
		this.setNome(n);
		this.emXeque = false;
	}
	
	public String verificaXeque(Tabuleiro tabuleiro) // pega todas as jogadas possiveis para o exercito inimigo e verifica se o rei esta em uma delas
	{
		int i = 0;
		boolean xeque = false;
		
		ArrayList<Posicao> todasPossibilidades = null;
		if (this.getCor().compareTo(ECorPeca.BRANCO) == 0)
		{
			todasPossibilidades = tabuleiro.getPosicoesPossiveisPecasPretas(); // o rei branco precisa saber onde as peças pretas pode ir
		} else {
			todasPossibilidades = tabuleiro.getPosicoesPossiveisPecasBrancas(); // o rei preto precisa saber onde as peças brancas pode ir
		}
		
		if (todasPossibilidades != null)
		{
			while ((i < todasPossibilidades.size()) && (!xeque))
			{
				if ((todasPossibilidades.get(i).getX() == this.getPosicao().getX()) && (todasPossibilidades.get(i).getY() == getPosicao().getY()))
				{
					xeque = true;
				}
				i++;
			}
		}
		
		if (xeque == true) // se o rei estiver em xegue, esta parte vai testar se ele esta em xeque mate
		{
			ArrayList<Posicao> possibilidadesDoRei = this.criaListaDestinosPossiveis(tabuleiro, todasPossibilidades);
			
			if ((possibilidadesDoRei != null) && (possibilidadesDoRei.size() > 0))
			{
				return ("Xeque");
			} else {
				return ("Xeque Mate");
			}
		}
		return "";
	}
	
	public ArrayList<Posicao> criaListaDestinosPossiveis(Tabuleiro tabuleiro)
	{
		/* Em alguns casos o vetor com todas as possibilidades vai estar preenchido
		 * entao separei uma função para preenche-lo antes de chegar a função principal se vier de um ponto onde nao esta preenchido
		 */
		if (this.getCor().compareTo(ECorPeca.BRANCO) == 0)
		{
			return criaListaDestinosPossiveis(tabuleiro, tabuleiro.getPosicoesPossiveisPecasPretasRei());
		} else {
			return criaListaDestinosPossiveis(tabuleiro, tabuleiro.getPosicoesPossiveisPecasBrancasRei());
		}
	}

	public ArrayList<Posicao> criaListaDestinosPossiveis(Tabuleiro tabuleiro, ArrayList<Posicao> todasPossibilidadesInimigo) 
	{
		// O rei pode andar apenas uma casa em qualquer direção(Rainha)
		
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		// para cima
		int buscaX = this.getPosicao().getX();
		int buscaY = this.getPosicao().getY() + 1;
		
		if (buscaY <= 7)
		{
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
			} else {
				posicoes.add(novaPos);
			}
		}
		// FIM para cima
		
		// esquerda - para cima
		buscaX = this.getPosicao().getX() - 1;
		buscaY = this.getPosicao().getY() + 1;
		
		if ((buscaX >= 0) && (buscaY <= 7))
		{
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
			} else {
				posicoes.add(novaPos);
			}
		}
		// FIM esquerda - para cima
		
		// esquerda
		buscaX = this.getPosicao().getX() - 1;
		buscaY = this.getPosicao().getY();
		
		if (buscaX >= 0)
		{
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
			} else {
				posicoes.add(novaPos);
			}
		}
		// FIM esquerda
		
		// esquerda - para baixo
		buscaX = this.getPosicao().getX() - 1;
		buscaY = this.getPosicao().getY() - 1;
		
		if ((buscaX >= 0) && (buscaY >= 0))
		{
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
			} else {
				posicoes.add(novaPos);
			}
		}
		// FIM esquerda - para baixo
		
		// para baixo
		buscaX = this.getPosicao().getX();
		buscaY = this.getPosicao().getY() - 1;
		
		if (buscaY >= 0)
		{
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
			} else {
				posicoes.add(novaPos);
			}
		}
		// FIM para baixo
		
		// direita - para baixo
		buscaX = this.getPosicao().getX() + 1;
		buscaY = this.getPosicao().getY() - 1;
		
		if ((buscaX <= 7) && (buscaY >= 0))
		{
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
			} else {
				posicoes.add(novaPos);
			}
		}
		// FIM direita - para baixo
		
		// direita
		buscaX = this.getPosicao().getX() + 1;
		buscaY = this.getPosicao().getY();
		
		if (buscaX <= 7)
		{
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
			} else {
				posicoes.add(novaPos);
			}
		}
		// FIM direita
		
		// direita - para cima
		buscaX = this.getPosicao().getX() + 1;
		buscaY = this.getPosicao().getY() + 1;
		
		if ((buscaX <= 7) && (buscaY <= 7))
		{
			Posicao novaPos = new Posicao(buscaX, buscaY);
			Peca pecaPos = Tabuleiro.temPeca(tabuleiro, novaPos);
			
			if(pecaPos != null) // verifica se tem alguma peça na posicao de destino
			{
				if(this.getCor() != pecaPos.getCor()) // verifica se a peça da posiçao de destino pode ser comida pela que esta sendo usada
					posicoes.add(novaPos);
			} else {
				posicoes.add(novaPos);
			}
		}
		// FIM direita - para cima

		
		// Verificando se o Rei vai se aproximar do outro Rei
		
		boolean achou = false;
		int i = 0;
		while (!achou) // Só verifica se achou o outro rei por que nao é possivel um tabuleiro sem os dois reis
		{
			if ((tabuleiro.getPecas().get(i) instanceof Rei) && (tabuleiro.getPecas().get(i).getCor().compareTo(this.getCor()) != 0))
			{
				int reiInimigoPosX = tabuleiro.getPecas().get(i).getPosicao().getX();
				int reiInimigoPosY = tabuleiro.getPecas().get(i).getPosicao().getY();
				
				Double distancia = Math.sqrt (Math.pow((reiInimigoPosX - this.getPosicao().getX()), 2) + Math.pow((reiInimigoPosY - this.getPosicao().getY()), 2));
				
				if (distancia < 3) // se a distancia entre os reis, pertencer aos numeros reais e for menor que tres, é preciso verificar se o vetor de posiçoes esta "deixando" o Rei ir para um ponto "colado" ao Rei Inimigo
				{
					for (int j = 0; j < posicoes.size(); j++)
					{
						distancia = Math.sqrt (Math.pow((reiInimigoPosX - posicoes.get(j).getX()), 2) + Math.pow((reiInimigoPosY - posicoes.get(j).getY()), 2));
						if (distancia < 2) // se a distancia pertencer aos reais e for menor que dois entre as posiçoes testadas, o Rei se coloca em xeque nesta posição
						{
							posicoes.remove(j); // esta posição deve ser removida da lista
							j--;
						}
					}
				}
				
				achou = true;
			}
			i++;
		}
		
		// verificando todas as possibilidades de ataque do inimigo
		int  j;
		i = 0;
		boolean retirou;
		while (i < posicoes.size())
		{
			j = 0;
			retirou = false;
			while ((j < todasPossibilidadesInimigo.size()) && (!retirou))
			{
				if ((posicoes.get(i).getX() == todasPossibilidadesInimigo.get(j).getX()) 
						&& (posicoes.get(i).getY() == todasPossibilidadesInimigo.get(j).getY())) // verifica se nesta posição alguma peça poderia pegar o Rei
				{
					posicoes.remove(i);
					retirou = true;
					i--;
				}
				j++;
			}
			i++;
		}
		
		return posicoes;
	}
}

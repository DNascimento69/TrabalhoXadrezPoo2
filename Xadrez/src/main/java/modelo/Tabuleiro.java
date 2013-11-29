package modelo;

import java.util.ArrayList;

import modelo.Enum.ECorPeca;
import modelo.pecas.Bispo;
import modelo.pecas.Cavalo;
import modelo.pecas.Peao;
import modelo.pecas.Peca;
import modelo.pecas.Rainha;
import modelo.pecas.Rei;
import modelo.pecas.Torre;

public class Tabuleiro
{
	private ArrayList<Peca> pecas = null;
	private ArrayList<Peca> pecasAnterior = null;
	ArrayList<Posicao> posicoesPossiveisPecasBrancas = new ArrayList<Posicao>();
	ArrayList<Posicao> posicoesPossiveisPecasPretas = new ArrayList<Posicao>();

	public Tabuleiro()
	{
		this.iniciaPecas();
	}

	public String liberarJogada(ECorPeca corDaPeca, ArrayList<Posicao> posicoes) // recebe uma jogada, faz as verifica��es necessarias e finaliza com a jogada realizada
	{
		int x = 0;
		boolean achouPeca = false;
		
		while ((x < pecas.size()) && (!achouPeca)) // buscando a pe�a que esta na posicao inicial que foi passada
		{
			if ((this.pecas.get(x).getPosicao().getX() == posicoes.get(0).getX()) && (this.pecas.get(x).getPosicao().getY() == posicoes.get(0).getY()))
			{
				if (!(this.pecas.get(x).getCor().compareTo(corDaPeca) == 0)) // verifica se o jogador pode usar aquela pe�a
				{
					return ("Escolha uma pe�a sua"); // msg de erro
				}
				
				if(this.verificaListaDePossibilidadesPorPeca(x, posicoes.get(1)))
				{
					this.mudaPosicao(x, posicoes.get(1));
				} else { // msg de erro
					return ("Esta pe�a nao pode ir para esta posi��o"); // msg de erro
				}
				achouPeca = true; // saida do loop de busca
			}
			x++;
		}
		if (!achouPeca)
			return ("N�o existe pe�a nessa posi��o"); // msg de erro
		
		// verificando se o Rei do proprio jogador esta em xeque ou xeque mate
		for (int i = 0; i < this.pecas.size(); i++)
		{
			if (this.pecas.get(i) instanceof Rei)
			{
				String xeque = ((Rei)this.pecas.get(i)).verificaXeque(this);
				if (this.pecas.get(i).getCor().compareTo(corDaPeca) == 0)
				{
					xeque = ((Rei)this.pecas.get(i)).verificaXeque(this);
					if (xeque.equalsIgnoreCase("Xeque")) // se o rei estiver em xeque o jogador joga de novo
					{
						this.pecas = this.pecasAnterior;
						return ("Voc� se colocou em " + xeque + ", fa�a uma nova Jogada");
					} else {
						if (xeque.equalsIgnoreCase("Xeque Mate"))
						{
							this.pecas = this.pecasAnterior;
							return ("Voc� se colocou em " + xeque + ", fa�a uma nova Jogada");
						}
					}
				} else {
					if (xeque.equalsIgnoreCase("Xeque")) // se o rei estiver em xeque o jogador joga de novo
					{
						this.pecas = this.pecasAnterior;
						return ("Voc� colocou seu adversario em " + xeque);
					} else {
						if (xeque.equalsIgnoreCase("Xeque Mate"))
						{
							return (xeque + ", Parab�ns");
						}
					}
				}
			}
			i++;
		}
		return ("Jogada Concluida"); // msg de conclusao
	}
	
	public boolean verificaListaDePossibilidadesPorPeca(int posPecaArray, Posicao posicaoDestino)
	{
		ArrayList<Posicao> posicoesPossiveis = this.pecas.get(posPecaArray).criaListaDestinosPossiveis(this);
		int x = 0;
		boolean pode = false;

		while ((x < posicoesPossiveis.size()) && (!pode)) // verificando em toda lista de posi�oes possiveis para aquela pe�a que sera movida
		{
			if ((posicoesPossiveis.get(x).getX() == posicaoDestino.getX()) 
					&& (posicoesPossiveis.get(x).getY() == posicaoDestino.getY())) // se for uma das posi�oes validas, ele retorna true
			{
				return true;
			}
			x++;
		}
		return false;
	}
	
	public void mudaPosicao(int posPecaArray, Posicao posFutura)
	{
		this.pecasAnterior = this.pecas;
		int x = 0;
		boolean achou = false;
		
		while ((x < pecas.size()) && (!achou)) // o jogo faz verifica�oes de movimento e de comer pe�as antes de chegar a este ponto
		{
			if ((this.pecas.get(x).getPosicao().getX() == posFutura.getX()) && (this.pecas.get(x).getPosicao().getY() == posFutura.getY()))
			{
				this.pecas.remove(x);
				achou = true;
			}
			x++;
		}
		this.pecas.get(posPecaArray).setMexeu(true); // informa ,se for um peao, que ele ja se movimentou
		this.pecas.get(posPecaArray).setPosicao(posFutura, this); // modifica a posi��o da pe�a no tabuleiro
	}
	
//	public void atualizaListaDeTodasJogadasPossiveis() // traz todas as jogadas possiveis para todo o tabuleiro
//	{
//		for (int i = 0; i < this.pecas.size(); i++)
//		{
//			if (this.pecas.get(i).getCor().compareTo(CorPeca.BRANCO) == 0)
//			{
//				this.posicoesPossiveisPecasBrancas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
//			} else {
//				this.posicoesPossiveisPecasPretas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
//			}
//		}
//	}
	
	public ArrayList<Posicao> getPosicoesPossiveisPecasBrancas() // traz todas as jogadas possiveis para as pe�as brancas
	{
		for (int i = 0; i < this.pecas.size(); i++)
		{
			if (this.pecas.get(i).getCor().compareTo(ECorPeca.BRANCO) == 0)
			{
				this.posicoesPossiveisPecasBrancas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
			}
		}
		return (this.posicoesPossiveisPecasBrancas);
	}
	
	public ArrayList<Posicao> getPosicoesPossiveisPecasPretas() // traz todas as jogadas possiveis para as pe�as pretas
	{
		for (int i = 0; i < this.pecas.size(); i++)
		{
			if (this.pecas.get(i).getCor().compareTo(ECorPeca.PRETO) == 0)
			{
				this.posicoesPossiveisPecasPretas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
			}
		}
		return (this.posicoesPossiveisPecasPretas);
	}
	
	public ArrayList<Posicao> getPosicoesPossiveisPecasBrancasRei() // traz todas as jogadas possiveis para as pe�as brancas de acordo com a necessidade do rei
	{
		for (int i = 0; i < this.pecas.size(); i++)
		{
			if ((this.pecas.get(i).getCor().compareTo(ECorPeca.BRANCO) == 0) && !(this.pecas.get(i) instanceof Rei))
			{
				this.posicoesPossiveisPecasBrancas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
			}
		}
		return (this.posicoesPossiveisPecasBrancas);
	}
	
	public ArrayList<Posicao> getPosicoesPossiveisPecasPretasRei() // traz todas as jogadas possiveis para as pe�as pretas de acordo com a necessidade do rei
	{
		for (int i = 0; i < this.pecas.size(); i++)
		{
			if ((this.pecas.get(i).getCor().compareTo(ECorPeca.PRETO) == 0) && !(this.pecas.get(i) instanceof Rei))
			{
				this.posicoesPossiveisPecasPretas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
			}
		}
		return (this.posicoesPossiveisPecasPretas);
	}
	
	public static Peca temPeca(Tabuleiro tabuleiro, Posicao posicao) // verifica se existe uma pe�a em um ponto qualquer do tabuleiro e retorna a pe�a se existir
	{
		for(int i = 0; i < tabuleiro.getPecas().size(); i++)
		{
			if((tabuleiro.getPecas().get(i).getPosicao().getX() == posicao.getX()) && (tabuleiro.getPecas().get(i).getPosicao().getY() == posicao.getY()))
			{
				return tabuleiro.getPecas().get(i);
			}
		}
		return null;
	}
	
//	public void iniciaTeste()
//	{
//		this.pecas = new ArrayList<Peca>();
//		
//		System.out.println("CRIANDO PE�AS");
//
//		this.pecas.add(new Rei(4, 5, CorPeca.BRANCO, "REIBRANCO"));
//		
//		this.pecas.add(new Rei(2, 4, CorPeca.PRETO, "REIPRETO"));
//		
//		ArrayList<Posicao> pos = this.pecas.get(0).criaListaDestinosPossiveis(this);
//		
//		System.out.println("FIM CRIAR PE�AS");
//	}
	
	public void iniciaPecas() // coloca todas a pe�as para iniciar o Xadrez
	{
		this.pecas = new ArrayList<Peca>();
		
		System.out.println("CRIANDO PE�AS");
		
		this.pecas.add(new Torre(0, 0, ECorPeca.BRANCO, "TORRE"));
		this.pecas.add(new Cavalo(1, 0, ECorPeca.BRANCO, "CAVALO"));
		this.pecas.add(new Bispo(2, 0, ECorPeca.BRANCO, "BISPO"));
		this.pecas.add(new Rainha(3, 0, ECorPeca.BRANCO, "RAINHA"));
		this.pecas.add(new Rei(4, 0, ECorPeca.BRANCO, "REI"));
		this.pecas.add(new Bispo(5, 0, ECorPeca.BRANCO, "BISPO"));
		this.pecas.add(new Cavalo(6, 0, ECorPeca.BRANCO, "CAVALO"));
		this.pecas.add(new Torre(7, 0, ECorPeca.BRANCO, "TORRE"));

		this.pecas.add(new Torre(0, 7, ECorPeca.PRETO, "TORRE"));
		this.pecas.add(new Cavalo(1, 7, ECorPeca.PRETO, "CAVALO"));
		this.pecas.add(new Bispo(2, 7, ECorPeca.PRETO, "BISPO"));
		this.pecas.add(new Rainha(3, 7, ECorPeca.PRETO, "RAINHA"));
		this.pecas.add(new Rei(4, 7, ECorPeca.PRETO, "REI"));
		this.pecas.add(new Bispo(5, 7, ECorPeca.PRETO, "BISPO"));
		this.pecas.add(new Cavalo(6, 7, ECorPeca.PRETO, "CAVALO"));
		this.pecas.add(new Torre(7, 7, ECorPeca.PRETO, "TORRE"));
		
		for (int i = 0; i < 8; i++) // Os pe�es podem ser colocados por um loop
		{
			this.pecas.add(new Peao(i, 1, ECorPeca.BRANCO, "PEAO"));
			this.pecas.add(new Peao(i, 6, ECorPeca.PRETO, "PEAO"));
		}
		
		System.out.println("FIM CRIAR PE�AS");
	}

	public ArrayList<Peca> getPecas()
	{
		return this.pecas;
	}

	public void setPecas(ArrayList<Peca> pecas) 
	{
		this.pecas = pecas;
	}
}

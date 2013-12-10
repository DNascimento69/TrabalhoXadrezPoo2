package modelo.cdp;

import java.util.ArrayList;

import modelo.cdp.Enum.ECorPeca;
import modelo.cdp.pecas.Peca;
import modelo.cdp.pecas.Rei;

public class Tabuleiro {
	private ArrayList<Peca> pecas = null;
	private ArrayList<Peca> pecasAnterior = null;
	private ArrayList<Posicao> posicoesPossiveisPecasBrancas = new ArrayList<Posicao>();
	private ArrayList<Posicao> posicoesPossiveisPecasPretas = new ArrayList<Posicao>();

	public Tabuleiro() { }

	// recebe uma jogada, faz as verificações necessarias e finaliza com a jogada realizada
	public String liberarJogada(ECorPeca corDaPeca, ArrayList<Posicao> posicoes) { int x = 0;
		boolean achouPeca = false;
		
		// buscando a peça que esta na posicao inicial que foi passada
		while ((x < pecas.size()) && (!achouPeca)) { 
			if ((this.pecas.get(x).getPosicao().getX() == posicoes.get(0).getX()) && (this.pecas.get(x).getPosicao().getY() == posicoes.get(0).getY())) {
				if (!(this.pecas.get(x).getCor().compareTo(corDaPeca) == 0)) { // verifica se o jogador pode usar aquela peça
					return ("Escolha uma peça sua"); // msg de erro
				}
				
				if(this.verificaListaDePossibilidadesPorPeca(x, posicoes.get(1))) {
					this.mudaPosicao(x, posicoes.get(1));
				} else { // msg de erro
					return ("Esta peça nao pode ir para esta posição"); // msg de erro
				}
				achouPeca = true; // saida do loop de busca
			}
			x++;
		}
		if (!achouPeca)
			return ("Não existe peça nessa posição"); // msg de erro
		
		// verificando se o Rei do proprio jogador esta em xeque ou xeque mate
		for (int i = 0; i < this.pecas.size(); i++) {
			if (this.pecas.get(i) instanceof Rei) {
				String xeque = ((Rei)this.pecas.get(i)).verificaXeque(this);
				if (this.pecas.get(i).getCor().compareTo(corDaPeca) == 0) {
					xeque = ((Rei)this.pecas.get(i)).verificaXeque(this);
					if (xeque.equalsIgnoreCase("Xeque")) { // se o rei estiver em xeque o jogador joga de novo
						this.pecas = this.pecasAnterior;
						return ("Você se colocou em " + xeque + ", faça uma nova Jogada");
					} else {
						if (xeque.equalsIgnoreCase("Xeque Mate")) {
							this.pecas = this.pecasAnterior;
							return ("Você se colocou em " + xeque + ", faça uma nova Jogada");
						}
					}
				} else {
					if (xeque.equalsIgnoreCase("Xeque")) { // se o rei estiver em xeque o jogador joga de novo
						this.pecas = this.pecasAnterior;
						return ("Você colocou seu adversario em " + xeque);
					} else {
						if (xeque.equalsIgnoreCase("Xeque Mate")) {
							return (xeque + ", Parabéns");
						}
					}
				}
			}
			i++;
		}
		return ("Jogada Concluida"); // msg de conclusao
	}
	
	public boolean verificaListaDePossibilidadesPorPeca(int posPecaArray, Posicao posicaoDestino) {
		ArrayList<Posicao> posicoesPossiveis = this.pecas.get(posPecaArray).criaListaDestinosPossiveis(this);
		int x = 0;
		boolean pode = false;

		while ((x < posicoesPossiveis.size()) && (!pode)) { // verificando em toda lista de posiçoes possiveis para aquela peça que sera movida
			if ((posicoesPossiveis.get(x).getX() == posicaoDestino.getX()) 
					&& (posicoesPossiveis.get(x).getY() == posicaoDestino.getY())) { // se for uma das posiçoes validas, ele retorna true
				return true;
			}
			x++;
		}
		return false;
	}
	
	public void mudaPosicao(int posPecaArray, Posicao posFutura) {
		this.pecasAnterior = this.pecas;
		int x = 0;
		boolean achou = false;
		
		// o jogo faz verificaçoes de movimento e de comer peças antes de chegar a este ponto
		while ((x < pecas.size()) && (!achou)) {
			if ((this.pecas.get(x).getPosicao().getX() == posFutura.getX()) && (this.pecas.get(x).getPosicao().getY() == posFutura.getY())) {
				this.pecas.remove(x);
				achou = true;
			}
			x++;
		}
		this.pecas.get(posPecaArray).setMexeu(true); // informa ,se for um peao, que ele ja se movimentou
		this.pecas.get(posPecaArray).setPosicao(posFutura, this); // modifica a posição da peça no tabuleiro
	}
	
//	public void atualizaListaDeTodasJogadasPossiveis() // traz todas as jogadas possiveis para todo o tabuleiro {
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
	
	public ArrayList<Posicao> getPosicoesPossiveisPecasBrancas() { // traz todas as jogadas possiveis para as peças brancas
		for (int i = 0; i < this.pecas.size(); i++) {
			if (this.pecas.get(i).getCor().compareTo(ECorPeca.BRANCO) == 0) {
				this.posicoesPossiveisPecasBrancas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
			}
		}
		return (this.posicoesPossiveisPecasBrancas);
	}
	
	public ArrayList<Posicao> getPosicoesPossiveisPecasPretas() { // traz todas as jogadas possiveis para as peças pretas
		for (int i = 0; i < this.pecas.size(); i++) {
			if (this.pecas.get(i).getCor().compareTo(ECorPeca.PRETO) == 0) {
				this.posicoesPossiveisPecasPretas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
			}
		}
		return (this.posicoesPossiveisPecasPretas);
	}
	
	public ArrayList<Posicao> getPosicoesPossiveisPecasBrancasRei() { // traz todas as jogadas possiveis para as peças brancas de acordo com a necessidade do rei
		for (int i = 0; i < this.pecas.size(); i++) {
			if ((this.pecas.get(i).getCor().compareTo(ECorPeca.BRANCO) == 0) && !(this.pecas.get(i) instanceof Rei)) {
				this.posicoesPossiveisPecasBrancas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
			}
		}
		return (this.posicoesPossiveisPecasBrancas);
	}
	
	public ArrayList<Posicao> getPosicoesPossiveisPecasPretasRei() { // traz todas as jogadas possiveis para as peças pretas de acordo com a necessidade do rei
		for (int i = 0; i < this.pecas.size(); i++) {
			if ((this.pecas.get(i).getCor().compareTo(ECorPeca.PRETO) == 0) && !(this.pecas.get(i) instanceof Rei)) {
				this.posicoesPossiveisPecasPretas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
			}
		}
		return (this.posicoesPossiveisPecasPretas);
	}
	
	// verifica se existe uma peça em um ponto qualquer do tabuleiro e retorna a peça se existir
	public static Peca temPeca(Tabuleiro tabuleiro, Posicao posicao) {
		for(int i = 0; i < tabuleiro.getPecas().size(); i++) {
			if((tabuleiro.getPecas().get(i).getPosicao().getX() == posicao.getX()) && (tabuleiro.getPecas().get(i).getPosicao().getY() == posicao.getY())) {
				return tabuleiro.getPecas().get(i);
			}
		}
		return null;
	}
	
//	public void iniciaTeste() {
//		this.pecas = new ArrayList<Peca>();
//		
//		System.out.println("CRIANDO PEÇAS");
//
//		this.pecas.add(new Rei(4, 5, CorPeca.BRANCO, "REIBRANCO"));
//		
//		this.pecas.add(new Rei(2, 4, CorPeca.PRETO, "REIPRETO"));
//		
//		ArrayList<Posicao> pos = this.pecas.get(0).criaListaDestinosPossiveis(this);
//		
//		System.out.println("FIM CRIAR PEÇAS");
////	}
//	
//	// coloca todas a peças para iniciar o Xadrez
//	public void iniciaPecas() { 
//		this.pecas = new ArrayList<Peca>();
//		
//		System.out.println("CRIANDO PEÇAS");
//		
//		this.pecas.add(new Torre(0, 0, ECorPeca.BRANCO, "TORRE"));
//		this.pecas.add(new Cavalo(1, 0, ECorPeca.BRANCO, "CAVALO"));
//		this.pecas.add(new Bispo(2, 0, ECorPeca.BRANCO, "BISPO"));
//		this.pecas.add(new Rainha(3, 0, ECorPeca.BRANCO, "RAINHA"));
//		this.pecas.add(new Rei(4, 0, ECorPeca.BRANCO, "REI"));
//		this.pecas.add(new Bispo(5, 0, ECorPeca.BRANCO, "BISPO"));
//		this.pecas.add(new Cavalo(6, 0, ECorPeca.BRANCO, "CAVALO"));
//		this.pecas.add(new Torre(7, 0, ECorPeca.BRANCO, "TORRE"));
//
//		this.pecas.add(new Torre(0, 7, ECorPeca.PRETO, "TORRE"));
//		this.pecas.add(new Cavalo(1, 7, ECorPeca.PRETO, "CAVALO"));
//		this.pecas.add(new Bispo(2, 7, ECorPeca.PRETO, "BISPO"));
//		this.pecas.add(new Rainha(3, 7, ECorPeca.PRETO, "RAINHA"));
//		this.pecas.add(new Rei(4, 7, ECorPeca.PRETO, "REI"));
//		this.pecas.add(new Bispo(5, 7, ECorPeca.PRETO, "BISPO"));
//		this.pecas.add(new Cavalo(6, 7, ECorPeca.PRETO, "CAVALO"));
//		this.pecas.add(new Torre(7, 7, ECorPeca.PRETO, "TORRE"));
//		
//		// Os peões podem ser colocados por um loop
//		for (int i = 0; i < 8; i++) { 
//			this.pecas.add(new Peao(i, 1, ECorPeca.BRANCO, "PEAO"));
//			this.pecas.add(new Peao(i, 6, ECorPeca.PRETO, "PEAO"));
//		}
//		
//		System.out.println("FIM CRIAR PEÇAS");
//	}

	public ArrayList<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(ArrayList<Peca> pecas) {
		this.pecas = pecas;
	}
}

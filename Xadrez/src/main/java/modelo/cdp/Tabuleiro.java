package modelo.cdp;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.cdp.Enum.ECorPeca;
import modelo.cdp.Enum.EPeca;
import modelo.cdp.pecas.Peca;

public class Tabuleiro implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Peca> pecas = null;
	private ArrayList<Peca> pecasAnterior = null;
	private ArrayList<Posicao> posicoesPossiveisPecasBrancas = new ArrayList<Posicao>();
	private ArrayList<Posicao> posicoesPossiveisPecasPretas = new ArrayList<Posicao>();

	public Tabuleiro() {
		this.pecas = new ArrayList<Peca>();
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
			if ((this.pecas.get(i).getCor().compareTo(ECorPeca.BRANCO) == 0) && !(this.pecas.get(i).getTipo() == EPeca.REI)) {
				this.posicoesPossiveisPecasBrancas.addAll(this.pecas.get(i).criaListaDestinosPossiveis(this));
			}
		}
		return (this.posicoesPossiveisPecasBrancas);
	}
	
	public ArrayList<Posicao> getPosicoesPossiveisPecasPretasRei() { // traz todas as jogadas possiveis para as peças pretas de acordo com a necessidade do rei
		for (int i = 0; i < this.pecas.size(); i++) {
			if ((this.pecas.get(i).getCor().compareTo(ECorPeca.PRETO) == 0) && !(this.pecas.get(i).getTipo() == EPeca.REI)) {
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
	
	public int calculaTotalPontosBranco() {
		int total = 0;
		for (int x = 0; x < pecas.size(); x++) {
			if (pecas.get(x).getCor() == ECorPeca.PRETO) {
				total += pecas.get(x).getPontos();
			}
		}
		return (39 - total);
	}
	
	public int calculaTotalPontosPreto() {
		int total = 0;
		for (int x = 0; x < pecas.size(); x++) {
			if (pecas.get(x).getCor() == ECorPeca.BRANCO) {
				total += pecas.get(x).getPontos();
			}
		}
		return (39 - total);
	}

	public ArrayList<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(ArrayList<Peca> pecas) {
		this.pecas = pecas;
	}

	public ArrayList<Peca> getPecasAnterior() {
		return pecasAnterior;
	}

	public void setPecasAnterior(ArrayList<Peca> pecasAnterior) {
		this.pecasAnterior = pecasAnterior;
	}
}

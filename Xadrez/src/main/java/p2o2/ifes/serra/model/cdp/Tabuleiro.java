package p2o2.ifes.serra.model.cdp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p2o2.ifes.serra.model.Enum.EPecaMoveu;

import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.EStatusPeca;

public class Tabuleiro {

	// <editor-fold defaultstate="collapsed" desc="Atributos">
	private Peca[][] matrizTabuleiro = new Peca[8][8];
	private List<Peca> listPecasComidas = new ArrayList<Peca>();
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="GetSeters">
	public void setPecaPosicao(Peca peca,int linha, int coluna) {
		matrizTabuleiro[linha][coluna] = peca;
	}
	
	public Peca getPecaPosicao(int linha, int coluna) {
		return this.matrizTabuleiro[linha][coluna];
	}

	public Peca[][] getMatrixTabuleiro() {
		return matrizTabuleiro;
	}

	public void setMatrixTabuleiro(Peca[][] matrixTabuleiro) {
		this.matrizTabuleiro = matrixTabuleiro;
	}

	public List<Peca> getListPecasComidas() {
		return listPecasComidas;
	}

	public void setListPecasComidas(List<Peca> listPecasComidas) {
		this.listPecasComidas = listPecasComidas;
	}
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="Processamento">
	// Calcula a pontuação das peças brancas foras do jogo
	public int ChecaPontosBrancos() {
		int pontuacao = 0;
		if (listPecasComidas.size() > 0) {
			for (int i = 0; i < listPecasComidas.size(); i++) {
				if (((listPecasComidas.get(i)).getCor()).equals(EPlayerColor.white)) {
					pontuacao += (listPecasComidas.get(i)).getPontuacao();
				}
			}
			return pontuacao;
		} else {
			return 0;
		}
	}

	// Calcula a pontuação das peças pretas fora do jogo
	public int ChecaPontosPretos() {
		int pontuacao = 0;
		if (listPecasComidas.size() > 0) {
			for (int i = 0; i < listPecasComidas.size(); i++) {
				if (((listPecasComidas.get(i)).getCor()).equals(EPlayerColor.black)) {
					pontuacao += (listPecasComidas.get(i)).getPontuacao();
				}
			}
			return pontuacao;
		} else {
			return 0;
		}
	}
		
	public boolean jogada(String posicao, EPlayerColor cor){
			int posicaoColunaInicial = Integer.parseInt(posicao.substring(1,2));
	 		int posicaoLinhaInicial = Integer.parseInt(posicao.substring(0,1));
			String posicaoDestino = posicao.substring(2);
			
			Peca pecaAMover = this.matrizTabuleiro[posicaoLinhaInicial][posicaoColunaInicial];
			
			if(pecaAMover == null || !pecaAMover.getCor().equals(cor)){
				return false;
			}
			else{
				List<String> lstMovimentos = pecaAMover.getComando().listaMovimentosPossiveis(this, pecaAMover);
								
				if(lstMovimentos.contains(posicaoDestino)){
					this.movePeca(pecaAMover,posicaoDestino);
					return true;
				}
				else{
					return false;
				}
			}
	
	}
		
	public void movePeca(Peca peca,String posicaoDestino){
		int posicaoColunaDestino = Integer.parseInt(posicaoDestino.substring(1,2));
	 	int posicaoLinhaDestino = Integer.parseInt(posicaoDestino.substring(0,1));
		int posicaoColunaInicial = Integer.parseInt(peca.getPosicao().substring(1,2));
	 	int posicaoLinhaInicial = Integer.parseInt(peca.getPosicao().substring(0,1));
		
		Peca pecaDestino = this.matrizTabuleiro[posicaoLinhaDestino][posicaoColunaDestino];
		
			if(pecaDestino != null){
				pecaDestino.setStatusPeca(EStatusPeca.morto);
				this.listPecasComidas.add(pecaDestino);
			}
			this.matrizTabuleiro[posicaoLinhaDestino][posicaoColunaDestino] = null;
			this.matrizTabuleiro[posicaoLinhaInicial][posicaoColunaInicial] = null;
			
			peca.setPosicao(posicaoDestino);
			peca.setPecaMoveu(EPecaMoveu.sim);
			this.matrizTabuleiro[posicaoLinhaDestino][posicaoColunaDestino] = peca;
	}
	
	public LinkedList<String> listaPosicoesPossiveis(LinkedList<Peca> listaPecas) {
		LinkedList<String> listaPosicoes = new LinkedList<String>();
		for(Peca l: listaPecas) {
				listaPosicoes.addAll(l.listaMovimentosPossiveisPeca(this)) ;
		}
		return listaPosicoes;
	}
	
	public List<Peca> listarPecasJogo(){
		List<Peca> lstPecas = new ArrayList<Peca>();
		lstPecas.addAll(this.listPecasComidas);
		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(this.matrizTabuleiro[i][j] != null){
					lstPecas.add(this.matrizTabuleiro[i][j]);
				}
			}
		}
		
		return lstPecas;
	}
	// </editor-fold>	
}

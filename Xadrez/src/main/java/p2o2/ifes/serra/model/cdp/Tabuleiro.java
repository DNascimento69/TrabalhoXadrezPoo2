package p2o2.ifes.serra.model.cdp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import p2o2.ifes.serra.model.Enum.EPlayerColor;

public class Tabuleiro {

	private Peca[][] matrizTabuleiro = new Peca[8][8];
	private List<Peca> listPecasComidas = new ArrayList<Peca>();
	
	public String verificaXeque(EPlayerColor eCor) { // pega todas as jogadas possiveis para o exercito inimigo e verifica se o rei esta em uma delas
		List<Peca> pecasInimigas = null;
		
		String posRei;
		if(eCor.equals(EPlayerColor.white)) {
			posRei = achaRei("KB");
			pecasInimigas = getPecasPretas();
		} else {
			posRei = achaRei("KP");
			pecasInimigas = getPecasBrancas();
		}
		int posReiX = Integer.getInteger(posRei.substring(0, 1));
		int posReiY = Integer.getInteger(posRei.substring(1));
		Peca rei = matrizTabuleiro[posReiX][posReiY];
		
		List<String> todasPossibilidadesInimigo = null;
		
		for(int x = 0; x < pecasInimigas.size(); x++)
			todasPossibilidadesInimigo.addAll(pecasInimigas.get(x).listaMovimentosPossiveisPeca(this));
		
		int x = 0;
		boolean xeque = false;
		if (todasPossibilidadesInimigo != null) {
			while ((x < todasPossibilidadesInimigo.size()) && (!xeque)) {
				if(todasPossibilidadesInimigo.get(x).equalsIgnoreCase(posRei)) {
					xeque = true;
				}
				x++;
			}
		}
		
		if (xeque == true) { // se o rei estiver em xegue, esta parte vai testar se ele esta em xeque mate
			List<String> todasPossibilidadesRei = rei.listaMovimentosPossiveisPeca(this);
			
			if ((todasPossibilidadesRei != null) && (todasPossibilidadesRei.size() > 0)) {
				return ("Xeque");
			} else {
				return ("Xeque Mate");
			}
		}
		return "";
	}
	
	private String achaRei(String idRei) {
		boolean achou = false;
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if(this.matrizTabuleiro[x][y].getPecaId().equalsIgnoreCase(idRei)) {
					return Integer.toString(x) + Integer.toString(y);
				}
			}
		}
		return null;
	}

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
	
	public LinkedList<Peca> getPecasBrancas() {
		LinkedList<Peca> listaPecas = new LinkedList<Peca>();
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (((matrizTabuleiro[x][y]).getCor()).equals(EPlayerColor.white)) {
					listaPecas.add(matrizTabuleiro[x][y]);
				}
			}
		}
		return listaPecas;
	}
	
	public LinkedList<Peca> getPecasPretas() {
		LinkedList<Peca> listaPecas = new LinkedList<Peca>();
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (((matrizTabuleiro[x][y]).getCor()).equals(EPlayerColor.black)) {
					listaPecas.add(matrizTabuleiro[x][y]);
				}
			}
		}
		return listaPecas;
	}
	
	public LinkedList<String> listaPosicoesPossiveis(LinkedList<Peca> listaPecas) {
		LinkedList<String> listaPosicoes = new LinkedList<String>();
		for(Peca l: listaPecas) {
				listaPosicoes.addAll(l.listaMovimentosPossiveisPeca(this)) ;
		}
		return listaPosicoes;
	}
	
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
}

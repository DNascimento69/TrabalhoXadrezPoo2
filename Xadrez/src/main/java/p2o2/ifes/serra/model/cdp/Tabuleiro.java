package p2o2.ifes.serra.model.cdp;

import java.util.ArrayList;
import java.util.List;

import p2o2.ifes.serra.model.Enum.EPlayerColor;

public class Tabuleiro {

	private Peca[][] matrizTabuleiro = new Peca[8][8];
	private List<Peca> listPecasComidas = new ArrayList<Peca>();

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

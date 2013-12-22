package controle.cgt;

import java.util.ArrayList;

import builder.TabuleiroConstrutor;
import builder.TabuleiroDiretor;
import modelo.cdp.Posicao;
import modelo.cdp.Tabuleiro;
import modelo.cdp.Enum.ECorPeca;
import modelo.cdp.Enum.EMsg;
import modelo.cdp.Enum.EPeca;
import modelo.cdp.pecas.Peca;
import modelo.cdp.pecas.Rei;

public class TabuleiroControle {
	
	private Tabuleiro tabuleiro = null;
	
	public TabuleiroControle() {
		this.novoTabuleiro();
	}
	
	private void novoTabuleiro() {
		TabuleiroDiretor tabDiretor = new TabuleiroDiretor();
		TabuleiroConstrutor tabConstrutor = new TabuleiroConstrutor();
		this.tabuleiro = tabDiretor.construir(tabConstrutor);
	}
	
	// recebe uma jogada, faz as verificações necessarias e finaliza com a jogada realizada
	public EMsg liberarJogada(ECorPeca corDaPeca, ArrayList<Posicao> posicoes) { 
		int x = 0;
		boolean achouPeca = false;
		
		// buscando a peça que esta na posicao inicial que foi passada
		while ((x < this.tabuleiro.getPecas().size()) && (!achouPeca)) { 
			if ((this.tabuleiro.getPecas().get(x).getPosicao().getX() == posicoes.get(0).getX()) && (this.tabuleiro.getPecas().get(x).getPosicao().getY() == posicoes.get(0).getY())) {
				if (!(this.tabuleiro.getPecas().get(x).getCor().compareTo(corDaPeca) == 0)) { // verifica se o jogador pode usar aquela peça
					return EMsg.ESCOLHA_UMA_PECA_SUA;
				}
				
				if(this.tabuleiro.verificaListaDePossibilidadesPorPeca(x, posicoes.get(1))) {
					this.mudaPosicao(x, posicoes.get(1));
				} else { // msg de erro
					return EMsg.ESTA_PEÇA_NAO_PODE_IR_PARA_ESTA_POSICAO;
				}
				
				achouPeca = true; // saida do loop de busca
			}
			x++;
		}
		if (!achouPeca)
			return EMsg.NÃO_EXISTE_PECA_NESSA_POSIÇÃO;
		
		// verificando se o Rei do proprio jogador esta em xeque ou xeque mate
		for (int i = 0; i < this.tabuleiro.getPecas().size(); i++) {
			if (this.tabuleiro.getPecas().get(i).getTipo() == EPeca.REI) {
				String xeque = ((Rei)this.tabuleiro.getPecas().get(i)).verificaXeque(this.tabuleiro);
				if (this.tabuleiro.getPecas().get(i).getCor().compareTo(corDaPeca) == 0) {
					xeque = ((Rei)this.tabuleiro.getPecas().get(i)).verificaXeque(this.tabuleiro);
					if (xeque.equalsIgnoreCase("Xeque")) { // se o rei estiver em xeque o jogador joga de novo
						this.tabuleiro.setPecas(this.tabuleiro.getPecasAnterior());
						return EMsg.VOCÊ_SE_COLOCOU_EM_XEQUE_FAÇA_UMA_NOVA_JOGADA;
					} else {
						if (xeque.equalsIgnoreCase("Xeque Mate")) {
							this.tabuleiro.setPecas(this.tabuleiro.getPecasAnterior());
							return EMsg.VOCÊ_SE_COLOCOU_EM_XEQUE_FAÇA_UMA_NOVA_JOGADA;
						}
					}
				} else {
					if (xeque.equalsIgnoreCase("Xeque")) { // se o rei estiver em xeque o jogador joga de novo
						this.tabuleiro.setPecas(this.tabuleiro.getPecasAnterior());
						return EMsg.VOCÊ_COLOCOU_SEU_ADVERSARIO_EM_XEQUE;
					} else {
						if (xeque.equalsIgnoreCase("Xeque Mate")) {
							return EMsg.XEQUE_MATE_PARABENS;
						}
					}
				}
			}
			i++;
		}
		return EMsg.JOGADA_CONCLUIDA;
	}
	
	public void mudaPosicao(int posPecaArray, Posicao posFutura) {
		this.tabuleiro.setPecasAnterior(tabuleiro.getPecas());
		ArrayList<Peca> pecas = tabuleiro.getPecas();
		
		int posRetirar = encontraPecaParaRetirar(pecas, posFutura);

		pecas.get(posPecaArray).setMexeu(true); // informa ,se for um peao, que ele ja se movimentou
		pecas.get(posPecaArray).setPosicao(posFutura, this.tabuleiro); // modifica a posição da peça no tabuleiro
		
		if (posRetirar >= 0) {
			pecas.remove(posRetirar);
		}
		
		this.tabuleiro.setPecas(pecas);
	}
	
	public int encontraPecaParaRetirar(ArrayList<Peca> pecas, Posicao posFutura) {
		int x = 0;
		
		// o jogo faz verificaçoes de movimento e de comer peças antes de chegar a este ponto
		while (x < pecas.size()) {
			if ((pecas.get(x).getPosicao().getX() == posFutura.getX()) && (pecas.get(x).getPosicao().getY() == posFutura.getY())) {
				return x;
			}
			x++;
		}
		return -1;
	}
	

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}

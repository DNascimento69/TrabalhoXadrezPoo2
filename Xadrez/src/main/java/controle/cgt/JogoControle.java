package controle.cgt;

import java.util.ArrayList;
import java.util.LinkedList;

import util.LeitorUtil;
import modelo.cdp.Jogo;
import modelo.cdp.Posicao;
import modelo.cdp.Enum.ECorPeca;
import modelo.cdp.Enum.EMsg;

public class JogoControle {

//	private TabuleiroViewControle tabuleiroViewControle = null;
	
	private Jogo jogo = null;
	private TabuleiroControle tabuleiroControle = null;
	
	public JogoControle() {	}
	
	public void novoJogo(String nomesJogadores) {
//		this.tabuleiroViewControle = new TabuleiroViewControle();
		this.jogo = new Jogo(nomesJogadores);
		this.tabuleiroControle = new TabuleiroControle();
		this.jogar();
	}

	public void jogar() {
		System.out.println("JOGAR");

		boolean jogadorBranco = true;
		boolean xequeMate = false;
		
		while (!xequeMate) {
			if (jogadorBranco) {
				while (jogadorBranco) {
					System.out.println("Vez de " + jogo.getJogadorBranco().getNome() + ": ");

					ArrayList<Posicao> posicoes = this.novaJogada();
					
					EMsg msg = this.tabuleiroControle.liberarJogada(ECorPeca.BRANCO, posicoes);
					
					System.out.println(msg.getMsg());
					
					if (msg == EMsg.XEQUE_MATE_PARABENS) {
						xequeMate = true;
						jogadorBranco = false;
					} else {
						if (msg == EMsg.JOGADA_CONCLUIDA) {
							jogadorBranco = false;
						}
					}
				}
			} else {
				while (!jogadorBranco) {
					System.out.println("Vez de " + jogo.getJogadorPreto().getNome() + ": ");

					ArrayList<Posicao> posicoes = this.novaJogada();
					
					EMsg msg = this.tabuleiroControle.liberarJogada(ECorPeca.PRETO, posicoes);
					
					System.out.println(msg.getMsg());
					
					if (msg == EMsg.XEQUE_MATE_PARABENS) {
						xequeMate = true;
						jogadorBranco = true;
					} else {
						if (msg == EMsg.JOGADA_CONCLUIDA) {
							jogadorBranco = true;
						}
					}
				}
			}
			xequeMate = true;
		}
		
		this.jogo.setTabuleiro(this.tabuleiroControle.getTabuleiro());
		this.jogo.calcularPontuacao();
		this.salvarJogo();
	}
	
	public ArrayList<Posicao> novaJogada() {
		ArrayList<Posicao> posicoes = this.novaCoordenada();
		
		while ((posicoes == null) || (!this.verificaPosicoes(posicoes))) {
			posicoes = this.novaCoordenada();
		}

		return posicoes;
	}

	public boolean verificaPosicoes(ArrayList<Posicao> posicoes) {
		if ((posicoes.get(0).getX() < 0 || posicoes.get(0).getX() > 7)
				|| (posicoes.get(1).getX() < 0 || posicoes.get(1).getX() > 7)
				|| (posicoes.get(0).getY() < 0 || posicoes.get(0).getY() > 7)
				|| (posicoes.get(1).getY() < 0 || posicoes.get(1).getY() > 7)) {
			System.out.println("Coordenadas incorretas");
			return false;
		}

		return true;
	}

//	public ArrayList<Posicao> novaCoordenada(ECorPeca corPeca) {
	public ArrayList<Posicao> novaCoordenada() {
		String coordenadas = LeitorUtil.lervalorInteiro().toString();
		
		if (!(coordenadas.length() == 4)) return null;
		
		int xPartida = new Integer(coordenadas.substring(0, 1)) - 1;
		int yPartida = new Integer(coordenadas.substring(1, 2)) - 1;
		int xChegada = new Integer(coordenadas.substring(2, 3)) - 1;
		int yChegada = new Integer(coordenadas.substring(3, 4)) - 1;
		
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		posicoes.add(new Posicao(xPartida, yPartida));
		posicoes.add(new Posicao(xChegada, yChegada));
		
		return posicoes;
	}
	
//	public ArrayList<Posicao> posicoesEspeciais(String coordenadas, ECorPeca corPeca) {
//		int xPartida = 0;
//		int yPartida = 0;
//		int xChegada = 0;
//		int yChegada = 0;
//		
//		if (coordenadas.equalsIgnoreCase("o-o-o")) {
//			if (corPeca == ECorPeca.BRANCO) {
//				xPartida = new Integer(1) - 1;
//				yPartida = new Integer(5) - 1;
//				xChegada = new Integer(1) - 1;
//				yChegada = new Integer(7) - 1;
//			} else {
//				xPartida = new Integer(8) - 1;
//				yPartida = new Integer(5) - 1;
//				xChegada = new Integer(8) - 1;
//				yChegada = new Integer(7) - 1;
//			}
//		} else {
//			if (coordenadas.equalsIgnoreCase("o-o")) {
//				if (corPeca == ECorPeca.BRANCO) {
//					xPartida = new Integer(1) - 1;
//					yPartida = new Integer(5) - 1;
//					xChegada = new Integer(1) - 1;
//					yChegada = new Integer(3) - 1;
//				} else {
//					xPartida = new Integer(8) - 1;
//					yPartida = new Integer(5) - 1;
//					xChegada = new Integer(8) - 1;
//					yChegada = new Integer(3) - 1;
//				}
//			}
//		}
//
//		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
//		posicoes.add(new Posicao(xPartida, yPartida));
//		posicoes.add(new Posicao(xChegada, yChegada));
//		
//		return posicoes;
//	}
	
	public void salvarJogo() {
		SerializeJogo.incluirJogo(this.jogo);
	}
	
	public LinkedList<Jogo> recuperarJogos() {
		return SerializeJogo.getJogos();
	}
}

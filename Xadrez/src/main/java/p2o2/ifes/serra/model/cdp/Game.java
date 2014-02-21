package p2o2.ifes.serra.model.cdp;

import p2o2.ifes.serra.model.Enum.EGameStatus;
import p2o2.ifes.serra.model.Enum.EPlayerColor;

public class Game {
	
	private Jogador jogador1;
	private Jogador jogador2;
	private Tabuleiro tabuleiro;
	public EPlayerColor jogadorDaVez;
	public EGameStatus statusJogo;
	
	public Game(){
		this.jogadorDaVez = EPlayerColor.white;
		 this.statusJogo = EGameStatus.EmAndamento;
	}
		
	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}


	public Jogador getJogador2() {
		return jogador2;
	}


	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}


	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}


	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}


	public EPlayerColor getJogadorDaVez() {
		return jogadorDaVez;
	}


	public void setJogadorDaVez(EPlayerColor jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}


	public EGameStatus getStatusJogo() {
		return statusJogo;
	}


	public void setStatusJogo(EGameStatus statusJogo) {
		this.statusJogo = statusJogo;
	}
	
	
	@Override
	public String toString() {
		return "Game [jogador1=" + jogador1 + ", jogador2=" + jogador2
				+ ", tabuleiro=" + tabuleiro + ", jogadorDaVez=" + jogadorDaVez
				+ "]";
	}

}

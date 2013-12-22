package modelo.cdp;

import java.io.Serializable;

public class Jogo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Jogador jogadorBranco;
	private Jogador jogadorPreto;
	private Tabuleiro tabuleiro;
	
	public Jogo(String nomesJogadores) {
		String nomes[] = nomesJogadores.split("##");  
		jogadorBranco = new Jogador(nomes[0]);
		jogadorPreto = new Jogador(nomes[1]);
	}
	
	public void calcularPontuacao() {
		jogadorBranco.setPontos(this.tabuleiro.calculaTotalPontosBranco());
		jogadorPreto.setPontos(this.tabuleiro.calculaTotalPontosPreto());
	}
	
	public Jogador getJogadorBranco() {
		return jogadorBranco;
	}
	
	public void setJogadorBranco(Jogador jogadorBranco) {
		this.jogadorBranco = jogadorBranco;
	}
	
	public Jogador getJogadorPreto() {
		return jogadorPreto;
	}
	
	public void setJogadorPreto(Jogador jogadorPreto) {
		this.jogadorPreto = jogadorPreto;
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}

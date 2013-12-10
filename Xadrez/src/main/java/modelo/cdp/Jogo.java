package modelo.cdp;

public class Jogo {
	
	private Jogador jogadorBranco;
	private Jogador jogadorPreto;
	private Tabuleiro tabuleiro;
	
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

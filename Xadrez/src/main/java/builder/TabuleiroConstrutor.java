package builder;

import fabrica.PecaFabrica;
import modelo.cdp.Posicao;
import modelo.cdp.Tabuleiro;
import modelo.cdp.Enum.ECorPeca;
import modelo.cdp.Enum.EPeca;

public class TabuleiroConstrutor {

	private Tabuleiro tabuleiro = null;
	private PecaFabrica pecaFabrica = null;
	
	TabuleiroConstrutor() {
		this.tabuleiro = new Tabuleiro();
		this.pecaFabrica = new PecaFabrica();
	}
	
	public void construirTorres() {
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.TORRE, ECorPeca.BRANCO, new Posicao(0, 0)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.TORRE, ECorPeca.BRANCO, new Posicao(7, 0)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.TORRE, ECorPeca.PRETO, new Posicao(0, 7)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.TORRE, ECorPeca.PRETO, new Posicao(7, 7)));
	}

	public void construirCavalos() {
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.CAVALO, ECorPeca.BRANCO, new Posicao(1, 0)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.CAVALO, ECorPeca.BRANCO, new Posicao(6, 0)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.CAVALO, ECorPeca.PRETO, new Posicao(1, 7)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.CAVALO, ECorPeca.PRETO, new Posicao(6, 7)));
	}

	public void construirBispos() {
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.BISPO, ECorPeca.BRANCO, new Posicao(2, 0)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.BISPO, ECorPeca.BRANCO, new Posicao(5, 0)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.BISPO, ECorPeca.PRETO, new Posicao(2, 7)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.BISPO, ECorPeca.PRETO, new Posicao(5, 7)));
	}

	public void construirRealeza() {
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.RAINHA, ECorPeca.BRANCO, new Posicao(3, 0)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.REI, ECorPeca.BRANCO, new Posicao(4, 0)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.RAINHA, ECorPeca.PRETO, new Posicao(3, 7)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.REI, ECorPeca.PRETO, new Posicao(4, 7)));
	}

	public void construirPeoes() {
		// Os peões podem ser colocados por um loop
		for (int i = 0; i < 8; i++) {
			this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.PEAO, ECorPeca.BRANCO, new Posicao(i, 1)));
			this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.PEAO, ECorPeca.PRETO, new Posicao(i, 6)));
		}
	}
	
	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}
}

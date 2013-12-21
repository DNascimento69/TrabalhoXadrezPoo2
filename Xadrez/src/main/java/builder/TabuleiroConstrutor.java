package builder;

import fabrica.PecaFabrica;
import modelo.cdp.Posicao;
import modelo.cdp.Tabuleiro;
import modelo.cdp.Enum.ECorPeca;
import modelo.cdp.Enum.EPeca;

public class TabuleiroConstrutor {

	private Tabuleiro tabuleiro = null;
	private PecaFabrica pecaFabrica = null;
	
	public TabuleiroConstrutor() {
		this.tabuleiro = new Tabuleiro();
		this.pecaFabrica = new PecaFabrica();
	}
	
	public void construirTorres() {
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.TORRE, ECorPeca.BRANCO, new Posicao(0, 0)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.TORRE, ECorPeca.BRANCO, new Posicao(0, 7)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.TORRE, ECorPeca.PRETO, new Posicao(7, 0)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.TORRE, ECorPeca.PRETO, new Posicao(7, 7)));
	}

	public void construirCavalos() {
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.CAVALO, ECorPeca.BRANCO, new Posicao(0, 1)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.CAVALO, ECorPeca.BRANCO, new Posicao(0, 6)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.CAVALO, ECorPeca.PRETO, new Posicao(7, 1)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.CAVALO, ECorPeca.PRETO, new Posicao(7, 6)));
	}

	public void construirBispos() {
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.BISPO, ECorPeca.BRANCO, new Posicao(0, 2)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.BISPO, ECorPeca.BRANCO, new Posicao(0, 5)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.BISPO, ECorPeca.PRETO, new Posicao(7, 2)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.BISPO, ECorPeca.PRETO, new Posicao(7, 5)));
	}

	public void construirRealeza() {
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.RAINHA, ECorPeca.BRANCO, new Posicao(0, 3)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.REI, ECorPeca.BRANCO, new Posicao(0, 4)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.RAINHA, ECorPeca.PRETO, new Posicao(7, 3)));
		this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.REI, ECorPeca.PRETO, new Posicao(7, 4)));
	}

	public void construirPeoes() {
		// Os peões podem ser colocados por um loop
		for (int i = 0; i < 8; i++) {
			this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.PEAO, ECorPeca.BRANCO, new Posicao(1, i)));
			this.tabuleiro.getPecas().add(this.pecaFabrica.criar(EPeca.PEAO, ECorPeca.PRETO, new Posicao(6, i)));
		}
	}
	
	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}
}

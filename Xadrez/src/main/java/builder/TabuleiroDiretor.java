package builder;

import modelo.cdp.Tabuleiro;

public class TabuleiroDiretor {
	
	public Tabuleiro construir(TabuleiroConstrutor construtor) {
		construtor.construirTorres();
		construtor.construirCavalos();
		construtor.construirBispos();
		construtor.construirRealeza();
		construtor.construirPeoes();
		return construtor.getTabuleiro();
	}
	
}

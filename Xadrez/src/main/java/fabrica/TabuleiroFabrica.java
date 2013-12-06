package fabrica;

import modelo.cdp.Tabuleiro;

public class TabuleiroFabrica {

	private static TabuleiroFabrica tabuleiroFabrica = null;

	public static TabuleiroFabrica getTabuleiroFabrica() {
		if (tabuleiroFabrica == null) {
			tabuleiroFabrica = new TabuleiroFabrica();
		}
		return tabuleiroFabrica;
	}

	public Tabuleiro getTabuleiro() {
		return new Tabuleiro();
	}
}

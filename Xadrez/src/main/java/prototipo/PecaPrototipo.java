package prototipo;

import modelo.cdp.pecas.Bispo;
import modelo.cdp.pecas.Cavalo;
import modelo.cdp.pecas.Peao;
import modelo.cdp.pecas.Peca;
import modelo.cdp.pecas.Rainha;
import modelo.cdp.pecas.Rei;
import modelo.cdp.pecas.Torre;

public class PecaPrototipo {
	private static PecaPrototipo INSTANCE;
	private Peca peao, rei, rainha, bispo, cavalo, torre;

	private PecaPrototipo() { }

	public static PecaPrototipo getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PecaPrototipo();
		}
		return INSTANCE;
	}

	public Peca createPeao() {
		if (peao == null) {
			peao = new Peao();
		}
		return (Peca) peao.clone();
	}

	public Peca createBispo() {
		if (bispo == null) {
			bispo = new Bispo();
		}
		return (Peca) bispo.clone();
	}

	public Peca createTorre() {
		if (torre == null) {
			torre = new Torre();
		}
		return (Peca) torre.clone();
	}

	public Peca createCavalo() {
		if (cavalo == null) {
			cavalo = new Cavalo();
		}
		return (Peca) cavalo.clone();
	}

	public Peca createRainha() {
		if (rainha == null) {
			rainha = new Rainha();
		}
		return (Peca) rainha.clone();
	}

	public Peca createRei() {
		if (rei == null) {
			rei = new Rei();
		}
		return (Peca) rei.clone();
	}
}
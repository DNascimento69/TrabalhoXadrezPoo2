package fabrica;

import modelo.cdp.Posicao;
import modelo.cdp.Enum.ECorPeca;
import modelo.cdp.Enum.EPeca;
import modelo.cdp.pecas.Bispo;
import modelo.cdp.pecas.Cavalo;
import modelo.cdp.pecas.Peao;
import modelo.cdp.pecas.Peca;
import modelo.cdp.pecas.Rainha;
import modelo.cdp.pecas.Rei;
import modelo.cdp.pecas.Torre;

public class PecaFabrica {
	
	public Peca criar(EPeca tipo, ECorPeca cor, Posicao pos) {
		Peca peca = selecionarPeca(tipo);
		peca.setCor(cor);
		peca.setPosicao(pos);
		
		return peca;
	}
	
	public Peca selecionarPeca(EPeca e) {
		if (e == EPeca.PEAO) {
			return new Peao();
		} else {
			if (e == EPeca.CAVALO) {
				return new Cavalo();
			} else {
				if (e == EPeca.BISPO) {
					return new Bispo();
				} else {
					if (e == EPeca.TORRE) {
						return new Torre();
					} else {
						if (e == EPeca.RAINHA) {
							return new Rainha();
						} else {
							return new Rei();
						}
					}
				}
			}
		}
	}
}

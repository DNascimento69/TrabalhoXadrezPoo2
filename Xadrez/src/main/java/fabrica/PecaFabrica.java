package fabrica;

import prototipo.PecaPrototipo;
import modelo.cdp.Posicao;
import modelo.cdp.Enum.ECorPeca;
import modelo.cdp.Enum.EPeca;
import modelo.cdp.pecas.Peca;

public class PecaFabrica {
	
	public Peca criar(EPeca tipo, ECorPeca cor, Posicao pos) {
		Peca peca = selecionarPeca(tipo);
		peca.setCor(cor);
		peca.setPosicao(pos);
		
		return peca;
	}
	
	public Peca selecionarPeca(EPeca e) {
		if (e == EPeca.PEAO) {
			return PecaPrototipo.getInstance().createPeao();
		} else {
			if (e == EPeca.CAVALO) {
				return PecaPrototipo.getInstance().createCavalo();
			} else {
				if (e == EPeca.BISPO) {
					return PecaPrototipo.getInstance().createBispo();
				} else {
					if (e == EPeca.TORRE) {
						return PecaPrototipo.getInstance().createTorre();
					} else {
						if (e == EPeca.RAINHA) {
							return PecaPrototipo.getInstance().createRainha();
						} else {
							return PecaPrototipo.getInstance().createRei();
						}
					}
				}
			}
		}
	}
}

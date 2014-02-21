package p2o2.ifes.serra.factory;

import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.ETipoPeca;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.prototipo.PecaPrototipo;

public class PecaFactory {

	public Peca getPiece(ETipoPeca tipo, EPlayerColor cor) {
		PecaPrototipo pecaPrototipo = new PecaPrototipo();
		Peca clone;

		clone = pecaPrototipo.creatPeca();
		switch (tipo) {
		case Torre:

			return clone;
		case Bispo:

			return clone;
		case Cavalo:

			return clone;
		case Rainha:

			return clone;
		case Rei:

			return clone;
		default:

			return clone;
		}

	}
}

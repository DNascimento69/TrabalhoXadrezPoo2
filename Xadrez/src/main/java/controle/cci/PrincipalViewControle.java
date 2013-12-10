package controle.cci;

import controle.cgt.JogoControle;
import util.LeitorUtil;
import visao.cih.PrincipalView;

public class PrincipalViewControle {

	private PrincipalView principalView = new PrincipalView();
	private JogoControle jogoControle = new JogoControle();
	
	public void inicio() {
		principalView.menu();
		int opcao = LeitorUtil.lervalorInteiro();

		switch (opcao) {
		case 1: {
			jogoControle.;
			break;
		}
		case 2: {
			opcaoCalculadora = ECalc.DOUBLE;
			break;
		}
		case 3: {
			principalView.mensagemFim();
			break;
		}
		default: {
			principalView.mensagemOpcaoInvalida();
			principalView.mensagemFim();
			break;
		}
		}
	}
}

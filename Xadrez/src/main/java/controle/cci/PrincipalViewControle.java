package controle.cci;

import controle.cgt.JogoControle;
import util.LeitorUtil;
import visao.cih.PrincipalView;

public class PrincipalViewControle {

	private PrincipalView principalView = null;
	private JogoControle jogoControle = null;
	
	public PrincipalViewControle() {
		this.principalView = new PrincipalView();
	}

	public void inicio() {
		principalView.menu();
		int opcao = 1;
		opcao = LeitorUtil.lervalorInteiro();

		switch (opcao) {
			case 1: {
				JogadorViewControle jogadorViewControle = new JogadorViewControle();
				String jogadores = jogadorViewControle.solicitarNomes();
				
				jogoControle = new JogoControle();
				jogoControle.novoJogo(jogadores);
				break;
			}
			case 2: {
				jogoControle = new JogoControle();
				principalView.mostrarDadosPartidas(jogoControle.recuperarJogos());
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

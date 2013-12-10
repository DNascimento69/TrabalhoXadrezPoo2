package visao.cih;

public class Validador implements Validacao {

	public boolean validaMovimento(Casa casa1, Casa casa2) {
		if (casa1.getPeca() != null & casa2.getPeca() != null)
			if (casa1.getPeca().cor == casa2.getPeca().cor)
				return false;
		return true;
	}

	public boolean validaSelecao(Casa casa) {
		if (casa.getPeca() == null
				& casa.tabuleiro.getCasaSelecionada() == null)
			return false;
		return true;
	}
}

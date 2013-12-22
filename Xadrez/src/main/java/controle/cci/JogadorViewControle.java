package controle.cci;

import util.LeitorUtil;
import visao.cih.JogadorView;

public class JogadorViewControle {

	JogadorView jogadorView = null;
	
	public JogadorViewControle() {
		jogadorView = new JogadorView();
	}
	
	public String solicitarNomes() {
		jogadorView.solicitarJogadorBranco();
		String nomes = LeitorUtil.lervalorString() + '#';
		
		jogadorView.solicitarJogadorPreto();
		nomes += '#' + LeitorUtil.lervalorString();
		
		return nomes;
	}
}

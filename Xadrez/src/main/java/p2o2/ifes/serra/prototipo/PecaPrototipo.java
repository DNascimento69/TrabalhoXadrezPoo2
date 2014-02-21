package p2o2.ifes.serra.prototipo;

import p2o2.ifes.serra.model.cdp.Peca;

public class PecaPrototipo {
	
	private Peca peca;
	
	//Iniciador dos Clones
	public PecaPrototipo(){
		peca = new Peca();

	}
	
	public Peca creatPeca(){
		return (Peca) peca.clone();
	}

}

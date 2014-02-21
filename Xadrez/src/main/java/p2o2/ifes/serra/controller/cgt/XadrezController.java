package p2o2.ifes.serra.controller.cgt;

import java.util.List;

import p2o2.ifes.serra.model.Enum.EGameModeMenu;

public class XadrezController extends AbstractXadrezController{
	
	private EGameModeMenu opcaoModoDeJogo;
	
	
	
	public void setOpcaoModoDeJogo(EGameModeMenu opcaoModoDeJogo) {
		this.opcaoModoDeJogo = opcaoModoDeJogo;
	}

	
	public void start(){

	}
	
	public void start(List<String> jogadoreLst){
		System.out.println(jogadoreLst.get(0));
		System.out.println(jogadoreLst.get(1));
		
		
		
	}
	
	public void imprimeTabuleiro(){
		
		
	}
}

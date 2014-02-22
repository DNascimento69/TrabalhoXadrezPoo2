package p2o2.ifes.serra.builder;

import p2o2.ifes.serra.model.cdp.Tabuleiro;

public class TabuleiroMaker {
	private TabuleiroBuilder tabuleiroBuilder;
	
	
	public TabuleiroMaker(int idGamer){
	    this.tabuleiroBuilder = new TabuleiroBuilder(idGamer);
	  }
	 
	  public Tabuleiro getTabuleiro() {
	    return this.tabuleiroBuilder.getTabuleiro();
	  }
	 
	  public void constructTabuleiro() {
	    this.tabuleiroBuilder.CriarPecas();
	  }

}

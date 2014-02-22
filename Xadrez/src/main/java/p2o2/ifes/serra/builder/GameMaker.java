package p2o2.ifes.serra.builder;

import p2o2.ifes.serra.model.cdp.Game;

public class GameMaker {
	
	private GameBuilder gameBuilder;
	
	
	public GameMaker(String nomePlayer1, String nomePLayer2){
	    this.gameBuilder = new GameBuilder(nomePlayer1,nomePLayer2);
	  }
	 
	  public Game getGame() {
	    return this.gameBuilder.getGame();
	  }
	 
	  public void constructGame() {
	    this.gameBuilder.setPlayers();
	    this.gameBuilder.setTabuleiro();
	  }

}

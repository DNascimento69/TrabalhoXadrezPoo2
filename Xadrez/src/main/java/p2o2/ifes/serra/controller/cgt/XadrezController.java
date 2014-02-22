package p2o2.ifes.serra.controller.cgt;

import java.util.List;

import p2o2.ifes.serra.builder.GameMaker;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.state.JogadorBrancoState;

public class XadrezController extends AbstractXadrezController{
	
	private EGameModeMenu opcaoModoDeJogo;
	
	
	
	public void setOpcaoModoDeJogo(EGameModeMenu opcaoModoDeJogo) {
		this.opcaoModoDeJogo = opcaoModoDeJogo;
	}
	
	public void start(List<String> jogadoreLst){
		GameMaker gameMaker = new GameMaker(jogadoreLst.get(0),jogadoreLst.get(1));
		gameMaker.constructGame();
		this.gameDaVez = gameMaker.getGame();
                this.imprimeTabuleiro();
                this.gameDaVez.setState(new JogadorBrancoState(gameDaVez));
		
	}
	
	public void imprimeTabuleiro()
	{
		 Peca[][] matriz = gameDaVez.getTabuleiro().getMatrixTabuleiro();
                 Peca peca;
                  System.out.println("Legenda:");
                  System.out.println("E - Pião, K - Rei, Q - Rainha, C - Cavalo, I - Bispo, T - Torre");
                  System.out.println("P - Preto, B - Branco");
                  System.out.println(" ");
		 
		for (int row = 0; row < matriz.length; row++) {
		        for (int column = 0; column < matriz.length; column++) {
		        	if(matriz[row][column] != null){
                                    peca = matriz[row][column];
                                    System.out.print(peca.toString() + " ");
                                }
                                else{
                                    System.out.print(" - ");
                                }                              
		    }
		    System.out.println();
		}
	}
}

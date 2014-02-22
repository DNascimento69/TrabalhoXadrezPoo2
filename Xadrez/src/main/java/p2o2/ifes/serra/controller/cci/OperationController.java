package p2o2.ifes.serra.controller.cci;

import java.util.ArrayList;
import java.util.List;

import p2o2.ifes.serra.controller.cgt.XadrezController;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.Enum.EMainMenu;
import p2o2.ifes.serra.util.LeitorUtil;
import p2o2.ifes.serra.view.cih.GameView;

public class OperationController {
	
	private EMainMenu opcaoMenuInicial;	
	private GameView gameView = new GameView();
	private EGameModeMenu opcaoModoDeJogo;
	private XadrezController xadrezController = new XadrezController();
	

	public void setOpcaoJogo(EMainMenu opcaoDoMenuInicial) {
		this.opcaoMenuInicial = opcaoDoMenuInicial;
	}
	
	
	public void start(){
		if(opcaoMenuInicial.equals(EMainMenu.NovoJogo))
		{
			iniciarNovoJogo();
		}
		if(opcaoMenuInicial.equals(EMainMenu.CarregarJogo))
		{
			carregarJogoSalvo();
		}
	}
	
	

	public void iniciarNovoJogo()
	{
		gameView.show();
		
		int opcaoMenuModoDeJogo = LeitorUtil.lervalorInteiro();

		verificandoOpcaoEscolhidaNoMenuDeModoDeJogo(opcaoMenuModoDeJogo);

		if (opcaoModoDeJogo != null) {
			
			xadrezController.setOpcaoModoDeJogo(opcaoModoDeJogo);
			
			if(opcaoModoDeJogo.equals(EGameModeMenu.OnePlayerGame)){
				//xadrezController.start();
			}
			else{
				xadrezController.start(getNomeJogadores());
			}
		}
	}
	
	public void carregarJogoSalvo(){
		
	}
	
	
	
	public List<String> getNomeJogadores(){
		List<String> nomeDosJogadoresList = new ArrayList<String>();
		String nome1;
		String nome2;
		System.out.println("Insira o Nome do 1° jogador");
		nome1 = LeitorUtil.lervalorString();
		nomeDosJogadoresList.add(nome1);
		
		System.out.println("Insira o Nome do 2° jogador");
		nome2 = LeitorUtil.lervalorString();
		nomeDosJogadoresList.add(nome2);
		
		return nomeDosJogadoresList;
	}

	/**
	 * Valida a escolha do Menu de modo de jogo
	 */
	private void verificandoOpcaoEscolhidaNoMenuDeModoDeJogo(int opcao) {
		switch (opcao) {
			case 1: 
				opcaoModoDeJogo = EGameModeMenu.OnePlayerGame;
				break;
			case 2: 
				opcaoModoDeJogo = EGameModeMenu.TwoPlayerGame;
				break;
			default: 
				gameView.mensagemOpcaoInvalida();
				gameView.mensagemFim();
				break;
		}

	}
}

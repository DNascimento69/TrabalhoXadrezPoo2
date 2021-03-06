package p2o2.ifes.serra.controller.cci;

import java.sql.SQLException;
import p2o2.ifes.serra.model.Enum.EMainMenu;
import p2o2.ifes.serra.util.LeitorUtil;
import p2o2.ifes.serra.view.cih.*;

public class MainController {
	
	private OperationController operationController = new OperationController();
	private MainView mainView = new MainView();
	private EMainMenu opcaoMenuInicial;
	

<<<<<<< HEAD
	public void start() throws SQLException, ClassNotFoundException {
=======
	public void start() throws ClassNotFoundException, SQLException {
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
		
		mainView.show();
		
		int opcaoMainMenu = LeitorUtil.lervalorInteiro();

		verificandoOpcaoEscolhidaMenuPrincipal(opcaoMainMenu);

		if (opcaoMenuInicial != null) {
			
			operationController.setOpcaoJogo(opcaoMenuInicial);
			
			operationController.start();
		}

	}
	
	private void verificandoOpcaoEscolhidaMenuPrincipal(int opcao) {
		switch (opcao) {
			case 1: 
				opcaoMenuInicial = EMainMenu.NovoJogo;
				break;
			case 2:
				opcaoMenuInicial = EMainMenu.CarregarJogo;
				break;
			case 3: 
				opcaoMenuInicial = EMainMenu.DadosDoJogo;
				break;
			case 4:
				mainView.mensagemFim();
				break;
			default: 
				mainView.mensagemOpcaoInvalida();
				mainView.mensagemFim();
				break;
		}

	}

}

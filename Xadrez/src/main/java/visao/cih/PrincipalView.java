package visao.cih;

public class PrincipalView {

	public void menu() {
		System.out.println("Escolha uma das opções: ");
		System.out.println("1. Iniciar uma nova partida ");
		System.out.println("2. Dados das partidas ");
		System.out.println("3. Sair ");
	}
	
	public void mensagemOpcaoInvalida (){
		System.out.println("Opcao invalida");
	}
	
	public void mensagemFim (){
		System.out.println("Fim do programa!");
	}
}

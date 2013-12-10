package visao.cih;

public class TrocaPecaView {

	public void menu() {
		System.out.println("Transformar o Peão em: ");
		System.out.println("1. Rainha ");
		System.out.println("2. Cavalo ");
		System.out.println("3. Bispo ");
		System.out.println("4. Torre ");
		System.out.println("5. Não Transformar ");
	}
	
	public void mensagemOpcaoInvalida (){
		System.out.println("Opcao invalida");
	}
	
	public void mensagemFim (){
		System.out.println("Fim do programa!");
	}
}

package visao.cih;

import java.util.LinkedList;

import modelo.cdp.Jogo;

public class PrincipalView {

	public void menu() {
		System.out.println("Escolha uma das op��es: ");
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
	
	public void mostrarDadosPartidas(LinkedList<Jogo> jogos) {
		for (int x=0; x<jogos.size(); x++) {
			System.out.println("Dados da partida " + x);

			System.out.println("Jogador: " + jogos.get(x).getJogadorBranco().getNome() + " / Pontua��o: " + jogos.get(x).getJogadorBranco().getPontos());

			System.out.println("Jogador: " + jogos.get(x).getJogadorPreto().getNome() + " / Pontua��o: " + jogos.get(x).getJogadorPreto().getPontos());
		}
	}
}

package pecas;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo 
{
	Tabuleiro tabuleiro = null;
	
	Jogo() 
	{
		tabuleiro = new Tabuleiro();
		this.jogar();
	}

	public void jogar()
	{
		System.out.println("JOGAR");
		
		boolean jogadorBranco = true;
		boolean xequeMate = false;
		
		while (!xequeMate)
		{
			if (jogadorBranco)
			{
				while (jogadorBranco)
				{
					System.out.println("Jogador Branco: ");
					
					ArrayList<Posicao> posicoes = this.novaJogada();
					
//					ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
//					posicoes.add(new Posicao(0, 1));
//					posicoes.add(new Posicao(0, 3));
					
					String msg = tabuleiro.liberarJogada(CorPeca.BRANCO, posicoes);
					
					System.out.println(msg);
					
					if (msg.equalsIgnoreCase("XEQUE MATE, PARABÉNS"))
					{
						xequeMate = true;
						jogadorBranco = false;
					} else {
						if (msg.equalsIgnoreCase("JOGADA CONCLUIDA"))
						{
							jogadorBranco = false;
						}
					}
				}
			} else {
				while (!jogadorBranco) {
					System.out.println("Jogador Preto: ");
					
					ArrayList<Posicao> posicoes = this.novaJogada();
					
					String msg = tabuleiro.liberarJogada(CorPeca.PRETO, posicoes);
					
					System.out.println(msg);
					
					if (msg.equalsIgnoreCase("XEQUE MATE, PARABÉNS"))
					{
						xequeMate = true;
						jogadorBranco = true;
					} else {
						if (msg.equalsIgnoreCase("JOGADA CONCLUIDA"))
						{
							jogadorBranco = true;
						}
					}
				}

				for (int a = 0; a < tabuleiro.getPecas().size(); a++)
				{
					System.out.println(tabuleiro.getPecas().get(a).getNome());
				}
				
				xequeMate = true;
			}
		}
	}
	
	public ArrayList<Posicao> novaJogada()
	{
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		System.out.println("Informe as cordenadas da peça:");
		posicoes.add(this.novaCordenada());

		System.out.println("Informe as cordenadas de destino da peça:");
		posicoes.add(this.novaCordenada());
		
		return posicoes;
	}
	
	public Posicao novaCordenada()
	{
		Scanner in = new Scanner(System.in);
		
		int x = -1;
		int y = -1;
		
		while(x < 0 || x > 7)
		{
			System.out.print("Informe a posição X: ");
			x = in.nextInt();
		}
		while(y < 0 || y > 7)
		{
			System.out.print("Informe a posição Y: ");
			y = in.nextInt();
		}
			
		return new Posicao(x, y);
	}
}

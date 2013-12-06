package modelo.cdp.pecas;

import java.util.ArrayList;

import modelo.cdp.Posicao;
import modelo.cdp.Enum.ECorPeca;
import modelo.cdp.Tabuleiro;

public abstract class Peca 
{
	private Posicao posicao;
	private ECorPeca cor;
	private String nome;
	private int pontos;
	
	Peca() {}

	public abstract ArrayList<Posicao> criaListaDestinosPossiveis(Tabuleiro tabuleiro);

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public static void informaNome(Peca peca, String nome)
	{
		peca.setNome(nome);
	}

	public Posicao getPosicao() 
	{
		return posicao;
	}

	public void setPosicao(Posicao posicao) 
	{
		this.posicao = posicao;
	}
	
	public void setPosicao(Posicao posicao, Tabuleiro tabuleiro) 
	{
		this.posicao = posicao;
	}

	public ECorPeca getCor() 
	{
		return cor;
	}

	public void setCor(ECorPeca cor) 
	{
		this.cor = cor;
	}
	
	public void setMexeu(boolean m)
	{ }

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
}
package pecas;

import java.util.ArrayList;

public abstract class Peca 
{
	private Posicao posicao;
	private CorPeca cor;
	private String nome;
	
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

	public CorPeca getCor() 
	{
		return cor;
	}

	public void setCor(CorPeca cor) 
	{
		this.cor = cor;
	}
	
	public void setMexeu(boolean m)
	{ }
}
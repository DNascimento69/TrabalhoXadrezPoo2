package modelo.cdp.pecas;

import java.util.ArrayList;

import modelo.cdp.Posicao;
import modelo.cdp.Enum.ECorPeca;
import modelo.cdp.Enum.EPeca;
import modelo.cdp.Tabuleiro;

public abstract class Peca implements Cloneable {
	private Posicao posicao = null;
	private ECorPeca cor = null;
	private String nome = null;
	private int pontos;
	private EPeca tipo = null;

	Peca() { }

	public abstract ArrayList<Posicao> criaListaDestinosPossiveis(Tabuleiro tabuleiro);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static void informaNome(Peca peca, String nome) {
		peca.setNome(nome);
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public void setPosicao(Posicao posicao, Tabuleiro tabuleiro) {
		this.posicao = posicao;
	}

	public ECorPeca getCor() {
		return cor;
	}

	public void setCor(ECorPeca cor) {
		this.cor = cor;
	}

	public void setMexeu(boolean m) {
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException exception) {
			System.err.println("A peca nao foi clonada");
		}
		return object;
	}

	public EPeca getTipo() {
		return tipo;
	}

	public void setTipo(EPeca tipo) {
		this.tipo = tipo;
	}
}
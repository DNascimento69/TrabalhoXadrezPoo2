package modelo.cdp;

import java.io.Serializable;

public class Jogador implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private int pontos;
	
	Jogador(String nome) {
		this.nome = nome;
		pontos = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
}

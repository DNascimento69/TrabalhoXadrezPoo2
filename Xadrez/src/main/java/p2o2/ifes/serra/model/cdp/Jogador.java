package p2o2.ifes.serra.model.cdp;

import p2o2.ifes.serra.model.cdp.reuse.Model;

public class Jogador extends Model{

	private int jogadorId;
	private String nome;
	private int pontos;
	
	
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
        
<<<<<<< HEAD
   
=======
        public int getID() {
		return this.jogadorId;
	}


	public void setID(int ID) {
		this.jogadorId = ID;
	}
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d

	
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", pontos=" + pontos + "]";
	}
}

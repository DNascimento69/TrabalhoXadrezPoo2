package p2o2.ifes.serra.model.cdp;

import p2o2.ifes.serra.model.cdp.reuse.Model;
<<<<<<< HEAD
=======

public class Jogador extends Model{
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f

public class Jogador extends Model{

	
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
<<<<<<< HEAD
   
=======
        public int getID() {
		return this.jogadorId;
	}


	public void setID(int ID) {
		this.jogadorId = ID;
	}
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f

	
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", pontos=" + pontos + "]";
	}
}

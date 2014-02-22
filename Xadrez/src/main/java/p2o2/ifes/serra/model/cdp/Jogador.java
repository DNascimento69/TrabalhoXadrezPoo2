package p2o2.ifes.serra.model.cdp;

public class Jogador {

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
        
        public int getID() {
		return this.jogadorId;
	}


	public void setID(int ID) {
		this.jogadorId = ID;
	}

	
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", pontos=" + pontos + "]";
	}
}

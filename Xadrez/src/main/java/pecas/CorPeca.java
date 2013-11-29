package pecas;

public enum CorPeca 
{
	BRANCO("Branco"),
	PRETO("Preto");

	private String nome;
	
	CorPeca(String n)
	{
		this.nome = n;
	}
	
	public String getNome()
	{
		return this.nome;
	}
}

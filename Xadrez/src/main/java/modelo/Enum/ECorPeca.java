package modelo.Enum;

public enum ECorPeca 
{
	BRANCO("Branco"),
	PRETO("Preto");

	private String nome;
	
	ECorPeca(String n)
	{
		this.nome = n;
	}
	
	public String getNome()
	{
		return this.nome;
	}
}

package modelo.cdp.Enum;

public enum EPeca {
	
	PEAO("Peão"),
	TORRE("Torre"),
	CAVALO("Cavalo"),
	BISPO("Bispo"),
	RAINHA("Rainha"),
	REI("Rei");
	
	private String tipo;

	EPeca(String t) {
		this.tipo = t;
	}
	
	public String getTipo() {
		return this.tipo;
	}
}

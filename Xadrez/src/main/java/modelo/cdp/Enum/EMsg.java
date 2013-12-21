package modelo.cdp.Enum;

public enum EMsg {

	ESCOLHA_UMA_PECA_SUA("Escolha uma peça sua"),
	ESTA_PEÇA_NAO_PODE_IR_PARA_ESTA_POSICAO("Esta peça nao pode ir para esta posição"),
	NÃO_EXISTE_PECA_NESSA_POSIÇÃO("Não existe peça nessa posição"),
	VOCÊ_SE_COLOCOU_EM_XEQUE_FAÇA_UMA_NOVA_JOGADA("Você se colocou em xeque, faça uma nova Jogada"),
	VOCÊ_COLOCOU_SEU_ADVERSARIO_EM_XEQUE("Você colocou seu adversario em xeque"),
	XEQUE_MATE_PARABENS("Xeque Mate Parabéns"),
	JOGADA_CONCLUIDA("Jogada Concluida");
	
	private String msg;

	EMsg(String m) {
		this.msg = m;
	}
	
	public String getMsg() {
		return this.msg;
	}
}

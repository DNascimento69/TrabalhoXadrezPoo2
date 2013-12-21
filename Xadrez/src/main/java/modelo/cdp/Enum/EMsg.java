package modelo.cdp.Enum;

public enum EMsg {

	ESCOLHA_UMA_PECA_SUA("Escolha uma pe�a sua"),
	ESTA_PE�A_NAO_PODE_IR_PARA_ESTA_POSICAO("Esta pe�a nao pode ir para esta posi��o"),
	N�O_EXISTE_PECA_NESSA_POSI��O("N�o existe pe�a nessa posi��o"),
	VOC�_SE_COLOCOU_EM_XEQUE_FA�A_UMA_NOVA_JOGADA("Voc� se colocou em xeque, fa�a uma nova Jogada"),
	VOC�_COLOCOU_SEU_ADVERSARIO_EM_XEQUE("Voc� colocou seu adversario em xeque"),
	XEQUE_MATE_PARABENS("Xeque Mate Parab�ns"),
	JOGADA_CONCLUIDA("Jogada Concluida");
	
	private String msg;

	EMsg(String m) {
		this.msg = m;
	}
	
	public String getMsg() {
		return this.msg;
	}
}

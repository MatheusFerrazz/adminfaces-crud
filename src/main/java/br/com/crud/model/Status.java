package br.com.crud.model;

public enum Status {
	ANDAMENTO("Em andamento"),
	FINALIZADO("Finalizado");
	
	private String descricao;
	
	Status(String descricao){
		this.descricao = descricao;
		
	}

	public String getDescricao() {
		return descricao;
	}	
}

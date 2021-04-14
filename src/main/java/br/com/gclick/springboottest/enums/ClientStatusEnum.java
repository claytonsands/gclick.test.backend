package br.com.gclick.springboottest.enums;

public enum ClientStatusEnum {
	DESATIVADO(0),
	ATIVADO(1),
	SUSPENSO(2);
	
	
	private int status;
	
	ClientStatusEnum(int status){
		this.status = status;
	}
		
	public int getStatus(){
		return this.status;
	}

	public void setStatus(int status){
		this.status = status;	
	}
	
}

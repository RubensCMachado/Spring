package tasks.modelo;

import java.util.Calendar;

import javax.validation.constraints.Size;

public class Task {

	private Long id;
	
	@Size(min=3, message="A descri��o deve ter pelo menos 3 caracteres")
	private String descricao;
	private boolean finalizada;
	private Calendar dataFinaliza��o;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	public Calendar getDataFinalizacao() {
		return dataFinaliza��o;
	}
	public void setDataFinalizacao(Calendar dataFinaliza��o) {
		this.dataFinaliza��o = dataFinaliza��o;
	}

}
package tasks.modelo;

import java.util.Calendar;

import javax.validation.constraints.Size;

public class Task {

	private Long id;
	
	@Size(min=3, message="A descrição deve ter pelo menos 3 caracteres")
	private String descricao;
	private boolean finalizada;
	private Calendar dataFinalizacao;
	
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
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
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Calendar dataFinalização) {
		this.dataFinalizacao = dataFinalização;
	}

}

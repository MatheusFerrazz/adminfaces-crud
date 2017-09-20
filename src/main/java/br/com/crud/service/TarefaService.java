package br.com.crud.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.crud.dao.TarefaDAO;
import br.com.crud.model.Tarefa;
import br.com.crud.util.Transacional;

public class TarefaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaDAO tarefaDAO;
	
	@Transacional
	public void salvar(Tarefa tarefa) {
		if (tarefa.isInclusao()) {
			tarefa.setCriação(new Date());
		}
		if (tarefa.isEdicao()) {
			tarefa.setEdicao(new Date());
		}
		
		tarefaDAO.salvar(tarefa);
	}
	
	@Transacional
	public void excluir(Tarefa tarefa) {
		tarefaDAO.excluir(tarefa);
	}
	
	public List<Tarefa> listaAll() {
		return tarefaDAO.listAll();
	}
	public Tarefa parId(Long id) {
		return tarefaDAO.porId(id);
	}
}
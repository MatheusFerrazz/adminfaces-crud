package br.com.crud.mb;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.crud.model.Tarefa;
import br.com.crud.service.TarefaService;
import br.com.crud.util.FacesUtil;
import br.com.crud.dao.*;

public class ListaTarefaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaService tarefaservice;
	
	private List<Tarefa> tarefas = new ArrayList<>();
	
	private List<Tarefa> TarefaSelecionadas = new ArrayList<>();
	
	@PostConstruct
	public void inicialziar() {
		tarefas = tarefaservice.listaAll();
	}
	
	public void excluirSelecionados() {
		for (Tarefa tarefa : TarefaSelecionadas) {
			tarefaservice.excluir(tarefa);
			tarefas.remove(tarefa);
			
		}
		FacesUtil.addInfoMassage("Tarefas Excluídas com sucesso!");
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Tarefa> getTarefaSelecionadas() {
		return TarefaSelecionadas;
	}

	public void setTarefaSelecionadas(List<Tarefa> tarefaSelecionadas) {
		TarefaSelecionadas = tarefaSelecionadas;
	}
	
}

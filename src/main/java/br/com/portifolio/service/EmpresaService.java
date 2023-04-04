package br.com.portifolio.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.portifolio.model.Empresa;
import br.com.portifolio.repository.EmpresaRepository;
import br.com.portifolio.util.Transacional;

public class EmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaRepository empresaRepository;
	
	public List<Empresa> todas() {
		return empresaRepository.todas();
	}
	
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresaRepository.salvar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresaRepository.remover(empresa);
	}


	public List<Empresa> pesquisar(String termoPesquisa) {
		 
		return empresaRepository.pesquisar(termoPesquisa);
	}
}

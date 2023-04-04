package br.com.portifolio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.portifolio.model.Empresa;
import br.com.portifolio.service.EmpresaService;

@Named
@ViewScoped
public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaService empresaService;
	
	private String termoPesquisa;

	private List<Empresa> listaEmpresas;
	
	public List<Empresa> getListaEmpresas() {
		this.listaEmpresas =  empresaService.todas();
		return this.listaEmpresas;
	}
	
	public void pesquisar() {
		this.listaEmpresas = empresaService.pesquisar(termoPesquisa);		
	}
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
}

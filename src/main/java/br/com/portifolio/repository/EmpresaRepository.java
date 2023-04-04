package br.com.portifolio.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.portifolio.model.Empresa;

public class EmpresaRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public EmpresaRepository() {
		
	}
	
	public EmpresaRepository(EntityManager entityManager) {
		this.manager = entityManager;
	}
	
	public Empresa porId(Integer id) {
		return manager.find(Empresa.class, id);
	}
	
	public List<Empresa> todas() {
		return manager.createQuery("from Empresa", Empresa.class).getResultList();
	}
	

	public Empresa salvar(Empresa empresa) {
		return manager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}

	public List<Empresa> pesquisar(String termoPesquisa) {		 
		TypedQuery<Empresa> query = manager.createQuery("from Empresa e WHERE e.razaoSocial LIKE :termoPesquisa", Empresa.class);
		query.setParameter("termoPesquisa", termoPesquisa + "%");
		return query.getResultList();
	}
}

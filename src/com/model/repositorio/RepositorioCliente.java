package com.model.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.model.entidade.Cliente;

public class RepositorioCliente {

	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioCliente() {
	
		emf = Persistence.createEntityManagerFactory("outback");
		em = emf.createEntityManager();
	}
	
	public Cliente buscarId(int id){
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		em.getTransaction().commit();
		emf.close();
		return cliente;
	}
	
	public void salvarCliente(Cliente c){
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void removerCliente(Cliente cliente){
		
		em.getTransaction().begin();
		em.remove(em.contains(cliente) ? cliente : em.merge(cliente));
		em.getTransaction().commit();
		emf.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos(){
		em.getTransaction().begin();
		javax.persistence.Query consulta = em.createQuery("select cliente from Cliente cliente");
		List<Cliente> clientes = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return clientes;
		
	}
	
}

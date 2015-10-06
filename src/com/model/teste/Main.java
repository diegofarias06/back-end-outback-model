package com.model.teste;

import java.util.ArrayList;
import java.util.List;

import com.model.entidade.Cliente;
import com.model.repositorio.RepositorioCliente;

public class Main {

	public static void main(String[] args) { 
				
		RepositorioCliente repositorioCliente = new RepositorioCliente();
		List<Cliente> clientes = new ArrayList();
		clientes = repositorioCliente.listarTodos();
		for(int i = 0; i < clientes.size(); i++){
			System.out.println(clientes.get(i).getNome());
			repositorioCliente.removerCliente(clientes.get(i));
		}
		
	}
}

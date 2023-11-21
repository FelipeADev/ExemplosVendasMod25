/**
 * 
 */
package br.com.faguirre.service;

import br.com.faguirre.dao.IClienteDAO;
import br.com.faguirre.dao.generics.IGenericDAO;
import br.com.faguirre.domain.Cliente;
import br.com.faguirre.service.generics.GenericService;

/**
 * 
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	
	private static IGenericDAO<Cliente, Long> service;

	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);		
	}

	public ClienteService() {
		super(service);
	}


	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}


	public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
		entityCadastrado.setCidade(entity.getCidade());
		entityCadastrado.setCpf(entity.getCpf());
		entityCadastrado.setEnd(entity.getEnd());
		entityCadastrado.setEstado(entity.getEstado());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setNumero(entity.getNumero());
		entityCadastrado.setTel(entity.getTel());
	}




}

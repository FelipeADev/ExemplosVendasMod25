/**
 * 
 */
package br.com.faguirre;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.faguirre.dao.ClienteDAOMock;
import br.com.faguirre.dao.IClienteDAO;
import br.com.faguirre.domain.Cliente;
import br.com.faguirre.exceptions.TipoChaveNaoEncontradaException;

/**
 * 
 */
public class ClienteDAOTest {
	
	private IClienteDAO clienteDAO;
	
	private Cliente cliente;
	
	public ClienteDAOTest() {
		clienteDAO = new ClienteDAOMock();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Felipe");
		cliente.setCidade("Catanduva");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(15);
		cliente.setTel(17999999999L);
		
		clienteDAO.cadastrar(cliente);
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteDAO.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteDAO.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Felipe Aguirre");
		clienteDAO.alterar(cliente);
		
		Assert.assertEquals("Felipe Aguirre", cliente.getNome());
	}
	
}

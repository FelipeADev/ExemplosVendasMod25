package br.com.faguirre;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.faguirre.dao.ClienteDAOMock;
import br.com.faguirre.dao.IClienteDAO;
import br.com.faguirre.domain.Cliente;
import br.com.faguirre.exceptions.TipoChaveNaoEncontradaException;
import br.com.faguirre.service.ClienteService;
import br.com.faguirre.service.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDAOMock();		
		clienteService = new ClienteService(dao);
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

	}
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteService.consultar(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Felipe Aguirre");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Felipe Aguirre", cliente.getNome());
	}
}

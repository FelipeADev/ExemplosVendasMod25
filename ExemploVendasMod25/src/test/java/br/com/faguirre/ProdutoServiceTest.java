package br.com.faguirre;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.faguirre.dao.IProdutoDAO;
import br.com.faguirre.dao.ProdutoDaoMock;
import br.com.faguirre.domain.Produto;
import br.com.faguirre.exceptions.TipoChaveNaoEncontradaException;
import br.com.faguirre.service.IProdutoService;
import br.com.faguirre.service.ProdutoService;

public class ProdutoServiceTest {
	
private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Televisao");
		produto.setNome("Televisao");
		produto.setValor(BigDecimal.TEN);
		
	}
	
	@Test
	public void pesquisar() {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException {
		Boolean retorno = produtoService.cadastrar(produto);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		produto.setNome("Felipe Aguirre");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Felipe Aguirre", produto.getNome());
	}
}

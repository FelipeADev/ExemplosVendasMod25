/**
 * 
 */
package br.com.faguirre.service;

import br.com.faguirre.dao.generics.IGenericDAO;
import br.com.faguirre.domain.Produto;
import br.com.faguirre.service.generics.GenericService;

/**
 * 
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService{

	public ProdutoService(IGenericDAO<Produto, String> dao) {
		super(dao);
	}
	
	public Class<Produto> getTipoClasse() {
		return Produto.class;
	}

	public void atualiarDados(Produto entity, Produto entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setDescricao(entity.getDescricao());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setValor(entity.getValor());
	}


}

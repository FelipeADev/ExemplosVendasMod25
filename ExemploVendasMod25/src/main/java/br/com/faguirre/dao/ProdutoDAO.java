/**
 * 
 */
package br.com.faguirre.dao;

import br.com.faguirre.dao.generics.GenericDAO;
import br.com.faguirre.domain.Produto;


/**
 * 
 */
public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO{

	public ProdutoDAO() {
		super();
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

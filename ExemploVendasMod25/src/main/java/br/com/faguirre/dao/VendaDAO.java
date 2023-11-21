/**
 * 
 */
package br.com.faguirre.dao;


import br.com.faguirre.dao.generics.GenericDAO;
import br.com.faguirre.domain.Venda;
import br.com.faguirre.domain.Venda.Status;
import br.com.faguirre.exceptions.TipoChaveNaoEncontradaException;

/**
 * 
 */
public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {
	
	public Class<Venda> getTipoClasse() {
		return Venda.class;
	}
	
	public void atualiarDados(Venda entity, Venda entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setStatus(entity.getStatus());

	}
	
	public void excluir(String valor) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException {
		venda.setStatus(Status.CONCLUIDA);
		super.alterar(venda);
	}

	
	

}

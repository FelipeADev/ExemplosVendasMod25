package br.com.faguirre.dao;

import br.com.faguirre.dao.generics.IGenericDAO;
import br.com.faguirre.domain.Venda;
import br.com.faguirre.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String>{

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;

}

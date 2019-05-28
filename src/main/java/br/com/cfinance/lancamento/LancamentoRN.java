package br.com.cfinance.lancamento;
import java.util.*;

import br.com.cfinance.conta.Conta;
import br.com.cfinance.usuario.Usuario;
import br.com.cfinance.util.DAOFactory;
public class LancamentoRN {
	private LancamentoDAO	lancamentoDAO;
	public LancamentoRN() {
		this.lancamentoDAO = DAOFactory.criarLancamentoDAO();
	}
	public void salvar(Lancamento lancamento) {
		this.lancamentoDAO.salvar(lancamento);
	}
	public void excluir(Lancamento lancamento) {
		this.lancamentoDAO.excluir(lancamento);
	}
	public Lancamento carregar(Integer lancamento) {
		return this.lancamentoDAO.carregar(lancamento);
	}
	public float saldo(Conta conta, Date data) { 
		float saldoInicial = conta.getSaldoInicial();
		float saldoNaData = this.lancamentoDAO.saldo(conta, data);
		return saldoInicial + saldoNaData;
	}
	public List<Lancamento> listar(Conta conta, Date dataInicio, Date dataFim) { 
		return this.lancamentoDAO.listar(conta, dataInicio, dataFim);
	}
}

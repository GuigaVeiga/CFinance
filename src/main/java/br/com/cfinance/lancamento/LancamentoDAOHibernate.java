package br.com.cfinance.lancamento;

import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;

import br.com.cfinance.conta.Conta;

import java.math.BigDecimal;

public class LancamentoDAOHibernate implements LancamentoDAO {
	private Session	session;
	public void setSession(Session session) {
		this.session = session;
	}
	public void salvar(Lancamento lancamento) {
		this.session.saveOrUpdate(lancamento);
	}
	public void excluir(Lancamento lancamento) {
		this.session.delete(lancamento);
	}
	public Lancamento carregar(Integer lancamento) {
		return (Lancamento) this.session.get(Lancamento.class, lancamento);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> listar(Conta conta, Date dataInicio, Date dataFim) { 
		Criteria criteria = this.session.createCriteria(Lancamento.class);

		if (dataInicio != null && dataFim != null) { 
			criteria.add(Restrictions.between("data", dataInicio, dataFim));
		} else if (dataInicio != null) {
			criteria.add(Restrictions.ge("data", dataInicio));
		} else if (dataFim != null) {
			criteria.add(Restrictions.le("data", dataFim));
		}

		criteria.add(Restrictions.eq("conta", conta));
		criteria.addOrder(Order.asc("data")); 
		return criteria.list();
	}
	public float saldo(Conta conta, Date data) { 
		StringBuffer sql = new StringBuffer(); 
		sql.append("select sum(l.valor * c.fator)");
		sql.append(" from LANCAMENTO l,");
		sql.append("		CATEGORIA c");
		sql.append(" where l.categoria = c.codigo");
		sql.append("  and l.conta = :conta");
		sql.append("  and l.data <= :data");
		SQLQuery query = this.session.createSQLQuery(sql.toString()); 
		query.setParameter("conta", conta.getConta());
		query.setParameter("data", data);
		BigDecimal saldo = (BigDecimal) query.uniqueResult();
		if (saldo != null) {
			return saldo.floatValue();
		}
		return 0f;
	}
}

package br.com.cfinance.web;

import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.cfinance.conta.Conta;
import br.com.cfinance.lancamento.Lancamento;
import br.com.cfinance.lancamento.LancamentoRN;

@ManagedBean
public class PrincipalBean {	
	private List<Lancamento>	listaAteHoje;
	private List<Lancamento>	listaFuturos;
	private List<Lancamento> 	listaConsulta;
	
	

	@ManagedProperty(value = "#{contextoBean}")
	private ContextoBean contextoBean;

	public List<Lancamento> getListaAteHoje() {
		if (this.listaAteHoje == null) {
			Conta conta = this.contextoBean.getContaAtiva();

			Calendar hoje = new GregorianCalendar();

			LancamentoRN lancamentoRN = new LancamentoRN();
			this.listaAteHoje = lancamentoRN.listar(conta, null, hoje.getTime());
		}
		return this.listaAteHoje;
	}

	public List<Lancamento> getListaFuturos() {
		if (this.listaFuturos == null) {
			Conta conta = this.contextoBean.getContaAtiva();

			Calendar amanha = new GregorianCalendar();
			amanha.add(Calendar.DAY_OF_MONTH, 1);

			LancamentoRN lancamentoRN = new LancamentoRN();
			this.listaFuturos = lancamentoRN.listar(conta, amanha.getTime(), null);
		}
		return this.listaFuturos;
	}

	public ContextoBean getContextoBean() {
		return contextoBean;
	}

	public void setContextoBean(ContextoBean contextoBean) {
		this.contextoBean = contextoBean;
	}

	public void setListaAteHoje(List<Lancamento> listaAteHoje) {
		this.listaAteHoje = listaAteHoje;
	}

	public void setListaFuturos(List<Lancamento> listaFuturos) {
		this.listaFuturos = listaFuturos;
	}
	
	public List<Lancamento> getListaConsulta() {
		return listaConsulta;
	}

	public void setListaConsulta(List<Lancamento> listaConsulta) {
		this.listaConsulta = listaConsulta;
	}
}

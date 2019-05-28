package br.com.cfinance.util;
import br.com.cfinance.categoria.CategoriaDAO;
import br.com.cfinance.categoria.CategoriaDAOHibernate;
import br.com.cfinance.conta.ContaDAO;
import br.com.cfinance.conta.ContaDAOHibernate;
import br.com.cfinance.lancamento.LancamentoDAO;
import br.com.cfinance.lancamento.LancamentoDAOHibernate;
import br.com.cfinance.usuario.UsuarioDAO;
import br.com.cfinance.usuario.UsuarioDAOHibernate;
public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO; 
	}
	
	public static ContaDAO criarContaDAO() { 
		ContaDAOHibernate contaDAO = new ContaDAOHibernate();
		contaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return contaDAO;
	}

	public static CategoriaDAO criarCategoriaDAO() {
		CategoriaDAOHibernate categoriaDAO = new CategoriaDAOHibernate();
		categoriaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return categoriaDAO;
	}

	public static LancamentoDAO criarLancamentoDAO() {
		LancamentoDAOHibernate lancamentoDAO = new LancamentoDAOHibernate();
		lancamentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return lancamentoDAO;
	}
		

}

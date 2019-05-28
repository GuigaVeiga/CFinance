package br.com.cfinance.categoria;

import java.util.List;

import br.com.cfinance.usuario.Usuario;

public interface CategoriaDAO {
	public Categoria salvar(Categoria categoria);

	public void excluir(Categoria categoria);

	public Categoria carregar(Integer categoria);

	public List<Categoria> listar(Usuario usuario);
}

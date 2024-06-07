package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

	public void cadastra(Produto produto) {

		Connection con = Conexao.obterConexao();

		String sql = "INSERT INTO produtos(id,nome,descricao,preco) VALUES(?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, produto.getId());
			preparador.setString(2, produto.getNome());
			preparador.setString(3, produto.getDescricao());
			preparador.setDouble(4, produto.getPreco());

			preparador.execute();

			preparador.close();

			System.out.println("PRODUTO CADASTRADO COM SUCESSO!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Produto> mostraTodos() {

		Connection con = Conexao.obterConexao();
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produtos";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Produto produto = new Produto();
				produto.setId(resultado.getInt("id"));
				produto.setNome(resultado.getString("nome"));
				produto.setDescricao(resultado.getString("descricao"));
				produto.setPreco(resultado.getDouble("preco"));

				produtos.add(produto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}

	public Produto mostraPorId(int id) {

		Connection con = Conexao.obterConexao();
		Produto produto = null;
		String sql = "SELECT * FROM produtos WHERE id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				produto = new Produto();
				produto.setId(resultado.getInt("id"));
				produto.setNome(resultado.getString("nome"));
				produto.setDescricao(resultado.getString("descricao"));
				produto.setPreco(resultado.getDouble("preco"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produto;

	}

	public void excluiPorId(int id) {

		Connection con = Conexao.obterConexao();

		String sql = "DELETE FROM produtos WHERE id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);

			preparador.execute();
			preparador.close();

			System.out.println("produto Excluído Com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void altera(Produto produto) {

		Connection con = Conexao.obterConexao();
		String sql = "UPDATE produtos SET nome=?,descricao=?,preco=? WHERE id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, produto.getNome());
			preparador.setString(2, produto.getDescricao());
			preparador.setDouble(3, produto.getPreco());
			preparador.setInt(4, produto.getId());
			
			preparador.execute();
			preparador.close();

			System.out.println("Produto Alterado Com Sucesso!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

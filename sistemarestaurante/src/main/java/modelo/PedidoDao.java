package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao {

	public void cadastra(Pedido Pedido) {

		Connection con = Conexao.obterConexao();

		String sql = "INSERT INTO Pedidos(idProduto,quantidade) VALUES(?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			//preparador.setInt(1, Pedido.getIdPedido());
			preparador.setInt(1, Pedido.getIdProduto());
			preparador.setInt(2, Pedido.getQuantidade());

			preparador.execute();

			preparador.close();

			System.out.println("PEDIDO CADASTRADO COM SUCESSO!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Pedido> mostraTodos() {

		Connection con = Conexao.obterConexao();
		List<Pedido> pedidos = new ArrayList<>();
		String sql = "SELECT * FROM Pedidos";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Pedido pedido = new Pedido();
				pedido.setIdPedido(resultado.getInt("idPedido"));
				pedido.setIdProduto(resultado.getInt("idProduto"));
				pedido.setQuantidade(resultado.getInt("quantidade"));

				pedidos.add(pedido);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pedidos;
	}

	public Pedido mostraPorId(int idPedido) {

		Connection con = Conexao.obterConexao();
		Pedido pedido = null;
		String sql = "SELECT * FROM Pedidos WHERE idPedido=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, idPedido);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				pedido = new Pedido();
				pedido.setIdPedido(resultado.getInt("idPedido"));
				pedido.setIdProduto(resultado.getInt("idProduto"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pedido;

	}

	public void excluiPorId(int idPedido) {

		Connection con = Conexao.obterConexao();

		String sql = "DELETE FROM Pedidos WHERE id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, idPedido);

			preparador.execute();
			preparador.close();

			System.out.println("Pedido Excluído Com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void altera(Pedido Pedido) {

		Connection con = Conexao.obterConexao();
		String sql = "UPDATE Pedidos SET idPedido=?,idProduto=?,quantidade=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, Pedido.getIdPedido());
			preparador.setInt(2, Pedido.getIdProduto());
			preparador.setInt(3, Pedido.getQuantidade());

			preparador.execute();
			preparador.close();

			System.out.println("Pedido Alterado Com Sucesso!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

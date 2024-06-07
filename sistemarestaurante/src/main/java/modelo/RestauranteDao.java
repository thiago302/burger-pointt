package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestauranteDao {

	public Restaurante totalFuncionarios() {

		Connection con = Conexao.obterConexao();
		Restaurante restaurante = new Restaurante();
		String sql = "SELECT COUNT(*) AS 'quantidadeFuncionario' FROM funcionarios";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				restaurante.setQuantidadeFuncionario(resultado.getInt("quantidadeFuncionario"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurante;
	}

	public Restaurante totalDispesas() {

		Connection con = Conexao.obterConexao();
		Restaurante restaurante = new Restaurante();
		String sql = "SELECT SUM(salario) AS 'dispesas' FROM funcionarios";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				restaurante.setDispesas(resultado.getInt("dispesas"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurante;
	}
	
	public Restaurante totalLucroLiquido() {

		Connection con = Conexao.obterConexao();
		Restaurante restaurante = new Restaurante();
		String sql = "SELECT (SUM(P.preco * Pd.quantidade) - SUM(F.salario)) AS lucroLiquido\r\n"
				+ "FROM Pedidos Pd\r\n"
				+ "JOIN Produtos P ON Pd.idProduto = P.id\r\n"
				+ "JOIN Funcionarios F;";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				restaurante.setLucroLiquido(resultado.getInt("lucroLiquido"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurante;
	}
	
	public Restaurante totalLucroBruto() {

		Connection con = Conexao.obterConexao();
		Restaurante restaurante = new Restaurante();
		String sql = "SELECT SUM(P.preco * Pd.quantidade) AS lucroBruto\r\n"
				+ "FROM Pedidos Pd\r\n"
				+ "JOIN Produtos P ON Pd.idProduto = P.id;";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				restaurante.setLucroBruto(resultado.getInt("lucroBruto"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurante;
	}
}

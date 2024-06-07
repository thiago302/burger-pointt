package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

	public void cadastra(Funcionario funcionario) {

		Connection con = Conexao.obterConexao();

		String sql = "INSERT INTO funcionarios(id,nome,cargo,salario) VALUES(?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, funcionario.getId());
			preparador.setString(2, funcionario.getNome());
			preparador.setString(3, funcionario.getCargo());
			preparador.setDouble(4, funcionario.getSalario());

			preparador.execute();

			preparador.close();

			System.out.println("FUNCIONARIO CADASTRADO COM SUCESSO!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Funcionario> mostraTodos() {

		Connection con = Conexao.obterConexao();
		List<Funcionario> funcionarios = new ArrayList<>();
		String sql = "SELECT * FROM funcionarios";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Funcionario funcionario = new Funcionario();
				funcionario.setId(resultado.getInt("id"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setCargo(resultado.getString("cargo"));
				funcionario.setSalario(resultado.getDouble("salario"));

				funcionarios.add(funcionario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionarios;
	}

	public Funcionario mostraPorId(int id) {

		Connection con = Conexao.obterConexao();
		Funcionario funcionario = null;
		String sql = "SELECT * FROM funcionarios WHERE id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				funcionario = new Funcionario();
				funcionario.setId(resultado.getInt("id"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setCargo(resultado.getString("cargo"));
				funcionario.setSalario(resultado.getDouble("salario"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionario;

	}

	public void excluiPorId(int id) {

		Connection con = Conexao.obterConexao();

		String sql = "DELETE FROM funcionarios WHERE id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);

			preparador.execute();
			preparador.close();

			System.out.println("Funcionario Excluído Com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void altera(Funcionario funcionario) {

		Connection con = Conexao.obterConexao();
		String sql = "UPDATE funcionarios SET nome=?,cargo=?,salario=? WHERE id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, funcionario.getNome());
			preparador.setString(2, funcionario.getCargo());
			preparador.setDouble(3, funcionario.getSalario());
			preparador.setInt(4, funcionario.getId());
			
			preparador.execute();
			preparador.close();

			System.out.println("Funcionario Alterado Com Sucesso!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

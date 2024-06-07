package teste;

import java.util.List;

import modelo.Funcionario;
import modelo.FuncionarioDao;

public class TesteMostraTodosAlunos {

	public static void main(String[] args) {
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> funcionarios = funcionarioDao.mostraTodos();
		
		for(Funcionario funcionario:funcionarios) {
			System.out.println("ID: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Cargo: " + funcionario.getCargo());
			System.out.println("Salário " + funcionario.getSalario());
		}
		

	}

}

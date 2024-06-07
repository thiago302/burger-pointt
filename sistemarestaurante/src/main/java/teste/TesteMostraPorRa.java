package teste;

import modelo.Funcionario;
import modelo.FuncionarioDao;

public class TesteMostraPorRa {

	public static void main(String[] args) {
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.mostraPorId(4);
		
		if(funcionario!=null) {
			System.out.println("ID: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Cargo: " + funcionario.getCargo());
			System.out.println("Salário " + funcionario.getSalario());
		}else {
			System.out.println("ID Não Existe!!!");
		}

	}

}

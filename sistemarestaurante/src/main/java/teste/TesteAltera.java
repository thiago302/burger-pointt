package teste;

import modelo.Funcionario;
import modelo.FuncionarioDao;

public class TesteAltera {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario(4,"Henrique Santos HEHE","Chef",4000);
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.altera(funcionario);

	}

}

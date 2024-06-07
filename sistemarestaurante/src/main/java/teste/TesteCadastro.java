package teste;

import modelo.Funcionario;
import modelo.FuncionarioDao;

public class TesteCadastro {

	public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Amaral Junior Neto","Chef",10000);
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.cadastra(funcionario);
	}

}

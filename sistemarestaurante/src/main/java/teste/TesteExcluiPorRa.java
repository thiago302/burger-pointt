package teste;

import modelo.FuncionarioDao;

public class TesteExcluiPorRa {

	public static void main(String[] args) {
		
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.excluiPorId(1);
		

	}

}

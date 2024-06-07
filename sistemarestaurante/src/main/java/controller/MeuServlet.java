package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Funcionario;
import modelo.FuncionarioDao;
import modelo.Produto;
import modelo.ProdutoDao;
import modelo.Pedido;
import modelo.PedidoDao;
import modelo.Restaurante;
import modelo.RestauranteDao;

@WebServlet("/chamadaservlet")
public class MeuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao.equals("cadastro")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastro.html");
			rd.forward(request, response);
		} else if (acao.equals("mostratodos")) {

			FuncionarioDao funcionarioDao = new FuncionarioDao();
			List<Funcionario> funcionarios = funcionarioDao.mostraTodos();

			request.setAttribute("funcionarios", funcionarios);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mostratodos.jsp");
			rd.forward(request, response);

		} else if (acao.equals("exclui")) {
			int id = Integer.parseInt(request.getParameter("id"));

			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioDao.excluiPorId(id);

			response.sendRedirect("http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodos");
		} else if (acao.equals("altera")) {

			int id = Integer.parseInt(request.getParameter("id"));

			FuncionarioDao funcionarioDao = new FuncionarioDao();
			Funcionario funcionario = funcionarioDao.mostraPorId(id);

			request.setAttribute("funcionario", funcionario);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/altera.jsp");
			rd.forward(request, response);

		} else if (acao.equals("home")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
			rd.forward(request, response);

		} else if (acao.equals("lucro")) {
			RestauranteDao restauranteDao = new RestauranteDao();

			Restaurante restauranteFuncionarios = restauranteDao.totalFuncionarios();
			Restaurante restauranteDespesas = restauranteDao.totalDispesas();
			Restaurante restauranteLucroLiquido = restauranteDao.totalLucroLiquido();
			Restaurante restauranteLucro = restauranteDao.totalLucroBruto();

			Restaurante restaurante = new Restaurante();

			restaurante.setQuantidadeFuncionario(restauranteFuncionarios.getQuantidadeFuncionario());
			restaurante.setDispesas(restauranteDespesas.getDispesas());
			restaurante.setLucroLiquido(restauranteLucroLiquido.getLucroLiquido());
			restaurante.setLucroBruto(restauranteLucro.getLucroBruto());

			request.setAttribute("restaurante", restaurante);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/lucro.jsp");
			rd.forward(request, response);
		}

		// PRODUTOS
		if (acao.equals("cadastroproduto"))

		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastroproduto.html");
			rd.forward(request, response);
		} else if (acao.equals("mostratodosproduto")) {

			ProdutoDao produtoDao = new ProdutoDao();
			List<Produto> produtos = produtoDao.mostraTodos();

			request.setAttribute("produtos", produtos);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mostratodosproduto.jsp");
			rd.forward(request, response);

		} else if (acao.equals("excluiproduto")) {
			int id = Integer.parseInt(request.getParameter("id"));

			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.excluiPorId(id);

			response.sendRedirect("http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodosproduto");
		} else if (acao.equals("alteraproduto")) {

			int id = Integer.parseInt(request.getParameter("id"));

			ProdutoDao produtoDao = new ProdutoDao();
			Produto produto = produtoDao.mostraPorId(id);

			request.setAttribute("produto", produto);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/alteraproduto.jsp");
			rd.forward(request, response);

		}
		// PEDIDOS
		if (acao.equals("cadastropedido")) {
			ProdutoDao produtoDao = new ProdutoDao();
			List<Produto> produtos = produtoDao.mostraTodos();

			request.setAttribute("produtos", produtos);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastropedido.html");
			rd.forward(request, response);
		} else if (acao.equals("mostratodospedido")) {

			PedidoDao pedidoDao = new PedidoDao();
			List<Pedido> pedidos = pedidoDao.mostraTodos();

			request.setAttribute("pedidos", pedidos);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mostratodospedido.jsp");
			rd.forward(request, response);

		} else if (acao.equals("excluipedido")) {
			int idPedido = Integer.parseInt(request.getParameter("id"));

			PedidoDao pedidoDao = new PedidoDao();
			pedidoDao.excluiPorId(idPedido);

			response.sendRedirect("http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodospedido");
		} else if (acao.equals("alterapedido")) {

			int idPedido = Integer.parseInt(request.getParameter("id"));

			PedidoDao pedidoDao = new PedidoDao();
			Pedido pedido = pedidoDao.mostraPorId(idPedido);

			request.setAttribute("pedido", pedido);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/alterapedido.jsp");
			rd.forward(request, response);

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao.equals("cadastro")) {
			String nome = request.getParameter("txtnome");
			String cargo = request.getParameter("txtcargo");
			double salario = Double.parseDouble(request.getParameter("txtsalario"));

			Funcionario funcionario = new Funcionario(nome, cargo, salario); // CORRIGIR

			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioDao.cadastra(funcionario);

			response.sendRedirect("http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodos");
		} else if (acao.equals("altera")) {

			int id = Integer.parseInt(request.getParameter("txtid"));
			String nome = request.getParameter("txtnome");
			String cargo = request.getParameter("txtcargo");
			double salario = Double.parseDouble(request.getParameter("txtsalario"));

			Funcionario funcionario = new Funcionario(id, nome, cargo, salario);

			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioDao.altera(funcionario);

			response.sendRedirect("http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodos");

		}
		// PRODUTOS
		if (acao.equals("cadastroproduto")) {
			String nome = request.getParameter("txtnome");
			String descricao = request.getParameter("txtdescricao");
			double preco = Double.parseDouble(request.getParameter("txtpreco"));

			Produto produto = new Produto(nome, descricao, preco);

			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.cadastra(produto);

			response.sendRedirect("http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodosproduto");
		} else if (acao.equals("alteraproduto")) {

			int id = Integer.parseInt(request.getParameter("txtid"));
			String nome = request.getParameter("txtnome");
			String descricao = request.getParameter("txtdescricao");
			double preco = Double.parseDouble(request.getParameter("txtpreco"));

			Produto produto = new Produto(id, nome, descricao, preco);

			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.altera(produto);

			response.sendRedirect("http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodosproduto");

		}
		// PEDIDOS
		if (acao.equals("cadastropedido")) {

			int idProduto = Integer.parseInt(request.getParameter("txtidProduto"));
			int quantidade = Integer.parseInt(request.getParameter("txtquantidade"));

			Pedido pedido = new Pedido(idProduto, quantidade);

			PedidoDao pedidoDao = new PedidoDao();
			pedidoDao.cadastra(pedido);

			response.sendRedirect("http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodospedido");
		} else if (acao.equals("alterapedido")) {

			int idPedido = Integer.parseInt(request.getParameter("txtidPedido"));
			int idProduto = Integer.parseInt(request.getParameter("txtidProduto"));
			int quantidade = Integer.parseInt(request.getParameter("txtquantidade"));

			Pedido pedido = new Pedido(idPedido, idProduto, quantidade);

			PedidoDao pedidoDao = new PedidoDao();
			pedidoDao.altera(pedido);

			response.sendRedirect("http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodospedido");
		}

	}
}
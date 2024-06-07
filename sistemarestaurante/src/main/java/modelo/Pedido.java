package modelo;

public class Pedido {

	public Pedido(int idPedido, int idProduto, int quantidade) {
		this.idPedido = idPedido;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public Pedido(int idProduto, int quantidade) {
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public Pedido() {
	}

	private int idPedido;
	private int idProduto;
	private int quantidade;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}

package modelo;

public class Restaurante {

	public Restaurante(int quantidadeFuncionario, double dispesas, double lucroLiquido, double lucroBruto) {
		this.quantidadeFuncionario = quantidadeFuncionario;
		this.dispesas = dispesas;
		this.lucroLiquido = lucroLiquido;
		this.lucroBruto = lucroBruto;
	}

	public Restaurante() {
	}

	private int quantidadeFuncionario;
	private double dispesas;
	private double lucroLiquido;
	private double lucroBruto;
	

	public int getQuantidadeFuncionario() {
		return quantidadeFuncionario;
	}

	public void setQuantidadeFuncionario(int quantidadeFuncionario) {
		this.quantidadeFuncionario = quantidadeFuncionario;
	}

	public double getDispesas() {
		return dispesas;
	}

	public void setDispesas(double dispesas) {
		this.dispesas = dispesas;
	}

	public double getLucroLiquido() {
		return lucroLiquido;
	}

	public void setLucroLiquido(double lucroLiquido) {
		this.lucroLiquido = lucroLiquido;
	}
	public double getLucroBruto() {
		return lucroBruto;
	}

	public void setLucroBruto(double lucroBruto) {
		this.lucroBruto = lucroBruto;
	}

}

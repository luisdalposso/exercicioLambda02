package entities;

public class Funcionario {

	private String nome;
	private Double salario;
	private String email;

	public Funcionario(String nome, String email, Double salario) {
		this.nome = nome;
		this.salario = salario;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public Double getSalario() {
		return salario;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", salario=" + salario + ", email=" + email + "]";
	}

}

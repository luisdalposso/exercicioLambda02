package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Entre com o caminho do arquivo: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Funcionario> lista = new ArrayList<>();

			String linha = br.readLine();
			while (linha != null) {
				String[] campos = linha.split(",");
				lista.add(new Funcionario(campos[0], campos[1], Double.parseDouble(campos[2])));
				linha = br.readLine();
			}

			System.out.print("ENTRE COM O VALOR: ");
			double salProc = sc.nextDouble();
			
			List<String> emails = lista.stream()
					.filter(p -> p.getSalario() >= salProc)
					.map(p -> p.getEmail())
					.sorted().collect(Collectors.toList());
			
			System.out.println("EMAIL EM ORDEM CRESCENTE DOS FUNCIONARIOS QUE RECEBEM MAIS QUE:" + salProc);
			emails.forEach(System.out::println);

			System.out.print("ENTRE COM A LETRA: ");
			char busca = sc.next().charAt(0);
			
			Double salLetra = lista.stream()
					.filter(p -> p.getNome().charAt(0) == busca)
					.map(p -> p.getSalario())
					.reduce(0.0, (x, y) -> x + y);
			
			System.out.println("SOMA DOS SALÁRIOS DOS FUNCIONARIOS QUE TEM O NOME COMEÇADO POR " 
			+ busca + String.format(" %.2f", salLetra));
			

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}

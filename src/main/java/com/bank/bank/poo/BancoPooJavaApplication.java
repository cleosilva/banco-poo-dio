package com.bank.bank.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BancoPooJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoPooJavaApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("\nBem-vindo ao Banco Console!");
			System.out.println("1 - Criar conta");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Transferir via PIX");
			System.out.println("5 - Criar investimento");
			System.out.println("6 - Ver histórico de transações");
			System.out.println("0 - Sair");
			System.out.print("Digite uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					// TODO: lógica para criar conta
					System.out.println("[Criar Conta] funcionalidade em construção");
					break;
				case 2:
					// TODO: lógica para depósito
					System.out.println("[Depositar] funcionalidade em construção");
					break;
				case 3:
					// TODO: lógica para saque
					System.out.println("[Sacar] funcionalidade em construção");
					break;
				case 4:
					// TODO: lógica para transferência via PIX
					System.out.println("[Transferir via PIX] funcionalidade em construção");
					break;
				case 5:
					// TODO: lógica para criar investimento
					System.out.println("[Investimento] funcionalidade em construção");
					break;
				case 6:
					// TODO: lógica para exibir histórico
					System.out.println("[Histórico de Transações] funcionalidade em construção");
					break;
				case 0:
					System.out.println("Saindo... Obrigado por usar o Banco Console!");
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
			}
		} while (opcao != 0);
	}
}

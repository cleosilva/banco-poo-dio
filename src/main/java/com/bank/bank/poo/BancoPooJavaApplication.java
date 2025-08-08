package com.bank.bank.poo;

import com.bank.bank.poo.enums.TipoConta;
import com.bank.bank.poo.models.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;

@SpringBootApplication
public class BancoPooJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoPooJavaApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		Cliente cliente = new Cliente("João Silva", "123.456.789-00", "joao@email.com");

		// Vamos manter todas as contas criadas neste cliente
		Map<Long, Conta> contas = new HashMap<>();

		int opcao;
		do {
			System.out.println("\n=== Banco Console ===");
			System.out.println("1 - Criar conta");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Transferir");
			System.out.println("5 - Criar investimento");
			System.out.println("6 - Ver histórico de transações");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					criarConta(scanner, cliente, contas);
					break;
				case 2:
					depositar(scanner, contas);
					break;
				case 3:
					sacar(scanner, contas);
					break;
				case 4:
					transferir(scanner, contas);
					break;
				case 5:
					criarInvestimento(scanner, contas);
					break;
				case 6:
					verHistorico(scanner, contas);
					break;
				case 0:
					System.out.println("Saindo... Obrigado por usar o Banco Console!");
					break;
				default:
					System.out.println("Opção inválida!");
			}
		} while (opcao != 0);

		scanner.close();
	}

	private static void criarConta(Scanner scanner, Cliente cliente, Map<Long, Conta> contas) {
		System.out.println("Escolha o tipo de conta: 1 - Corrente | 2 - Poupança | 3 - Investimento");
		int tipo = scanner.nextInt();
		System.out.print("Número da conta: ");
		long numero = scanner.nextLong();
		System.out.print("Agência: ");
		int agencia = scanner.nextInt();
		System.out.print("Saldo inicial: ");
		BigDecimal saldo = scanner.nextBigDecimal();
		BigDecimal limiteChequeEspecial = BigDecimal.ZERO;
		if (tipo == 1) {
			System.out.println("Limite Cheque Especial");
			limiteChequeEspecial = scanner.nextBigDecimal();
		}

		Conta conta = null;
		if (tipo == 1) {
			conta = new ContaCorrente(numero, agencia, saldo, cliente, limiteChequeEspecial);
		} else if (tipo == 2) {
			conta = new ContaPoupanca(numero, agencia, saldo, cliente);
		} else if (tipo == 3) {
			conta = new ContaInvestimento(numero, agencia, saldo, cliente);
		}

		if (conta != null) {
			cliente.adicionarConta(conta);
			contas.put(numero, conta);
			System.out.println("Conta criada com sucesso!");
		} else {
			System.out.println("Tipo de conta inválido!");
		}
	}

	private static void depositar(Scanner scanner, Map<Long, Conta> contas) {
		System.out.print("Número da conta: ");
		long numero = scanner.nextLong();
		Conta conta = contas.get(numero);
		if (conta != null) {
			System.out.print("Valor para depositar: ");
			BigDecimal valor = scanner.nextBigDecimal();
			conta.depositar(valor);
			System.out.println("Depósito realizado!");
		} else {
			System.out.println("Conta não encontrada!");
		}
	}

	private static void sacar(Scanner scanner, Map<Long, Conta> contas) {
		System.out.print("Número da conta: ");
		long numero = scanner.nextLong();
		Conta conta = contas.get(numero);
		if (conta != null) {
			System.out.print("Valor para sacar: ");
			BigDecimal valor = scanner.nextBigDecimal();
			conta.sacar(valor);
		} else {
			System.out.println("Conta não encontrada!");
		}
	}

	private static void transferir(Scanner scanner, Map<Long, Conta> contas) {
		System.out.print("Número da conta origem: ");
		long origemNum = scanner.nextLong();
		Conta origem = contas.get(origemNum);

		System.out.print("Número da conta destino: ");
		long destinoNum = scanner.nextLong();
		Conta destino = contas.get(destinoNum);

		if (origem != null && destino != null) {
			System.out.print("Valor para transferir: ");
			BigDecimal valor = scanner.nextBigDecimal();
			origem.transferir(destino, valor);
		} else {
			System.out.println("Conta de origem ou destino não encontrada!");
		}
	}

	private static void criarInvestimento(Scanner scanner, Map<Long, Conta> contas) {
		System.out.print("Número da conta investimento: ");
		long numero = scanner.nextLong();
		Conta conta = contas.get(numero);
		if (conta instanceof ContaInvestimento) {
			System.out.print("Valor do investimento: ");
			BigDecimal valor = scanner.nextBigDecimal();
			System.out.println("Rentabilidade mensal (ex: 0.5 para 50%)");
			BigDecimal rentabilidade = scanner.nextBigDecimal();
			Investimento inv = new Investimento(valor, OffsetDateTime.now(), rentabilidade, conta);
			((ContaInvestimento) conta).adicionarInvestimento(inv);
			System.out.println("Investimento criado!");
		} else {
			System.out.println("A conta informada não é de investimento!");
		}
	}

	private static void verHistorico(Scanner scanner, Map<Long, Conta> contas) {
		System.out.print("Número da conta: ");
		long numero = scanner.nextLong();
		Conta conta = contas.get(numero);
		if (conta != null) {
			conta.getTransacoes().forEach(System.out::println);
		} else {
			System.out.println("Conta não encontrada!");
		}
	}
}

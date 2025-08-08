# Sistema Bancário - Lab de Programação Orientada a Objetos (POO) em Java

## Descrição do Projeto
Este projeto é uma aplicação Java desenvolvida para consolidar conceitos fundamentais de Programação Orientada a Objetos (POO), tais como:

* Herança
* Encapsulamento
* Polimorfismo
* Abstração
* Reuso de código

A aplicação simula um sistema bancário básico com funcionalidades como:

* Criação de contas (Corrente, Poupança e Investimento)
* Depósitos, saques e transferências
* Criação e acompanhamento de investimentos
* Histórico de transações para cada conta

## Tecnologias Utilizadas
* Java 17
* Spring Boot (apenas para facilitar a execução da aplicação)
* Maven (gerenciamento de dependências)
* Lombok (para reduzir boilerplate com getters, setters e construtores)

## Estrutura do Projeto
* models/ — Entidades do domínio, como `Conta`, `Cliente`, `Investimento`, `Transacao` e suas subclasses
* enums/ — Enumerações como `TipoConta` e `TipoTransacao`
* BancoPooJavaApplication.java — Classe principal com menu interativo via console para executar as operações do sistema

## Como Executar
1. Clone o repositório:

```bash
git clone https://github.com/cleosilva/banco-poo-dio.git
cd banco-poo-dio
```

2. Compile e execute a aplicação com Maven:

```bash
./mvnw spring-boot:run
```

3. Utilize o menu no console para interagir com o sistema bancário:

* Criar contas
* Depositar, sacar e transferir valores
* Criar investimentos
* Visualizar histórico de transações

## Funcionalidades
* **Criação de Contas:** permite cadastrar clientes e criar diferentes tipos de contas bancárias.
* **Operações Bancárias:** depósito, saque e transferência com validações e controle de saldo.
* **Investimentos:** criação de investimentos vinculados às contas de investimento, com cálculo básico de rentabilidade.
* **Histórico:** registro e consulta de todas as transações realizadas nas contas.

## Conceitos de POO aplicados
* **Herança:** Classes específicas (ContaCorrente, ContaPoupanca, ContaInvestimento) herdam da classe abstrata Conta.
* **Encapsulamento:** Uso de atributos privados e métodos públicos para controlar o acesso e manipulação dos dados.
* **Polimorfismo:** Métodos abstratos sacar(), depositar() e transferir() implementados nas subclasses de forma específica.
* **Abstração:** A classe Conta define a estrutura comum e as subclasses especializam o comportamento.
* **Reuso:** Código compartilhado nas classes pai evita duplicação nas subclasses.

## Observações
* A persistência dos dados é simulada em memória durante a execução (sem banco de dados).
* A interação ocorre via console, para foco nos conceitos de POO.
* O projeto não contempla camada web, banco de dados real ou API REST, pois o objetivo é aprendizado de POO.

Autor
Cleo Silva – https://www.linkedin.com/in/cleo-silva/
package com.bank.bank.poo.models;

import com.bank.bank.poo.enums.TipoConta;
import com.bank.bank.poo.enums.TipoTransacao;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(long numeroConta, int agencia, BigDecimal saldo, Cliente cliente) {
        super(numeroConta, agencia, saldo, cliente, TipoConta.POUPANCA);
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0 ) {
            System.out.println("Valor do saque inválido");
        }

        if (valor.compareTo(getSaldo()) <= 0) {
            setSaldo(getSaldo().subtract(valor));
            registrarTransacao(TipoTransacao.SAQUE, valor, "Saque Conta Poupança");
        } else {
            System.out.println("Saldo insuficiente para saque");
        }
    }

    @Override
    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            setSaldo(getSaldo().add(valor));
            registrarTransacao(TipoTransacao.DEPOSITO, valor, "Depósito Conta Poupança");
        } else {
            System.out.println("Valor de depósito inválido");
        }
    }

    @Override
    public void transferir(Conta destino, BigDecimal valor) {
        if (destino ==  null) {
            System.out.println("Conta de destino inválida");
        }

        if (valor.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(getSaldo()) <= 0) {
            setSaldo(getSaldo().subtract(valor));
            destino.depositar(valor);
            registrarTransacao(TipoTransacao.TRANSFERENCIA, valor, "Transferência para a conta " + destino.getNumeroConta());
        } else {
            System.out.println("Saldo insuficiente para transferência");
        }
    }
}

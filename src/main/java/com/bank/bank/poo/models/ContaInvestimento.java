package com.bank.bank.poo.models;

import com.bank.bank.poo.enums.TipoConta;
import com.bank.bank.poo.enums.TipoTransacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContaInvestimento extends Conta{
    private final List<Investimento> investimentos = new ArrayList<>();

    public ContaInvestimento(long numeroConta, int agencia, BigDecimal saldo, Cliente cliente) {
        super(numeroConta, agencia, saldo, cliente, TipoConta.INVESTIMENTO);
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Valor de saque inválido");
        }

        if (valor.compareTo(getSaldo()) <= 0) {
            setSaldo(getSaldo().subtract(valor));
            registrarTransacao(TipoTransacao.SAQUE, valor, "Saque Conta Investimento");
        } else {
            System.out.println("Saldo insuficiente para saque");
        }

    }

    @Override
    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            setSaldo(getSaldo().add(valor));
            registrarTransacao(TipoTransacao.DEPOSITO, valor, "Depósito Conta Investimento");
        } else {
            System.out.println("Valor de depósito inválido");
        }
    }

    @Override
    public void transferir(Conta destino, BigDecimal valor) {
        if (destino == null) {
            System.out.println("Conta de destino inválida");
        }

        if (valor.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(getSaldo()) <= 0){
            setSaldo(getSaldo().subtract(valor));
            destino.depositar(valor);
            registrarTransacao(TipoTransacao.TRANSFERENCIA, valor, "Transferência para a conta " + destino.getNumeroConta());
        } else {
            System.out.println("Saldo insuficiente para transferência");
        }
    }

    public void adicionarInvestimento(Investimento investimento) {
        investimentos.add(investimento);
    }

    public List<Investimento> getInvestimentos() {
        return Collections.unmodifiableList(investimentos);
    }
}

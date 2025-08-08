package com.bank.bank.poo.models;

import com.bank.bank.poo.enums.TipoConta;
import com.bank.bank.poo.enums.TipoTransacao;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaCorrente extends Conta{
    private BigDecimal limiteChequeEspecial;

    public ContaCorrente(long numeroConta, int agencia, BigDecimal saldo, Cliente cliente, BigDecimal limiteChequeEspecial) {
        super(numeroConta, agencia, saldo, cliente, TipoConta.CORRENTE);
        this.limiteChequeEspecial = Objects.requireNonNullElse(limiteChequeEspecial, BigDecimal.ZERO);
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Valor de saque inválido");
        }
        BigDecimal saldDisponivel = getSaldo().add(limiteChequeEspecial);
        if (valor.compareTo(saldDisponivel) <= 0){
            setSaldo(getSaldo().subtract(valor));
            registrarTransacao(TipoTransacao.SAQUE, valor, "Saque realizado");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            setSaldo(getSaldo().add(valor));
            registrarTransacao(TipoTransacao.DEPOSITO, valor, "Depósito realizado");
        }
    }

    @Override
    public void transferir(Conta destino, BigDecimal valor) {
        if (destino == null) {
            System.out.println("Conta destino inválida");
        }
        BigDecimal saldoDisponivel = getSaldo().add(limiteChequeEspecial);
        if(valor.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(saldoDisponivel) <= 0){
            setSaldo(getSaldo().subtract(valor));
            destino.depositar(valor);
            registrarTransacao(TipoTransacao.TRANSFERENCIA, valor, "Transferência para conta " + destino.getNumeroConta());
        } else {
            System.out.println("Saldo insuficiente para transferência");
        }
    }

    public BigDecimal getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(BigDecimal limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
}

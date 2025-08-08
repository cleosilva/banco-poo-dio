package com.bank.bank.poo.models;

import com.bank.bank.poo.enums.TipoConta;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta{
    public ContaInvestimento(long numeroConta, int agencia, BigDecimal saldo, Cliente cliente, TipoConta tipoConta) {
        super(numeroConta, agencia, saldo, cliente, tipoConta);
    }

    @Override
    public void sacar(BigDecimal valor) {

    }

    @Override
    public void depositar(BigDecimal valor) {

    }

    @Override
    public void transferir(Conta destino, BigDecimal valor) {

    }
}

package com.bank.bank.poo.models;

import com.bank.bank.poo.enums.TipoConta;
import com.bank.bank.poo.enums.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Conta {

    private long numeroConta;
    private int agencia;
    private BigDecimal saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;
    private final TipoConta tipoConta;

    public Conta(long numeroConta, int agencia, BigDecimal saldo, Cliente cliente,TipoConta tipoConta) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo != null ? saldo : BigDecimal.ZERO;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
        this.tipoConta = tipoConta;
    }

    public abstract void sacar(BigDecimal valor);

    public abstract void depositar(BigDecimal valor);

    public abstract void transferir(Conta destino, BigDecimal valor);

    public void consultarSaldo() {
        System.out.println("O saldo atual é: " + saldo);
    }

    public void registrarTransacao(TipoTransacao tipo, BigDecimal valor, String descricao) {
        Transacao transacao = new Transacao(tipo, valor, descricao);
        this.transacoes.add(transacao);
    }
}

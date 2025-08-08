package com.bank.bank.poo.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class Investimento {
    private BigDecimal valorInvestido;
    private OffsetDateTime dataAplicacao;
    private OffsetDateTime dataResgate;
    private BigDecimal rentabilidade;
    private Conta contaAssociada;


    public Investimento(BigDecimal valorInvestido, OffsetDateTime dataAplicacao, BigDecimal rentabilidade, Conta conta) {
        if (valorInvestido == null || valorInvestido.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor investido deve ser maior que zero.");
        }
        if (rentabilidade == null || rentabilidade.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Rentabilidade não pode ser negativa.");
        }
        this.valorInvestido = valorInvestido;
        this.dataAplicacao = dataAplicacao != null ? dataAplicacao : OffsetDateTime.now();
        this.rentabilidade = rentabilidade;
        this.contaAssociada = conta;
    }

    public BigDecimal calcularValorResgate() {
        if (dataResgate == null) {
            throw new IllegalStateException("O investimento ainda não foi resgatado.");
        }
        long meses = ChronoUnit.MONTHS.between(dataAplicacao, dataResgate);
        return valorInvestido.add(valorInvestido.multiply(rentabilidade).multiply(BigDecimal.valueOf(meses)));
    }
}

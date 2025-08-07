package com.bank.bank.poo.models;

import com.bank.bank.poo.enums.TipoTransacao;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Transacao(
        TipoTransacao tipoTransacao,
        BigDecimal valor,
        OffsetDateTime createAt,
        String descricao) {
    public Transacao(TipoTransacao tipoTransacao, BigDecimal valor, String descricao) {
        this(tipoTransacao, valor, OffsetDateTime.now(), descricao);
    }
}

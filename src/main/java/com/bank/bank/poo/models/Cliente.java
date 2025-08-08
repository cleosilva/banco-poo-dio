package com.bank.bank.poo.models;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
@ToString
public class Cliente {
    private String nome;
    private final String cpf;
    private String email;
    private final List<Conta> contas;

    public Cliente(String nome, String cpf, String email) {
        if(nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido.");
        if(cpf == null || cpf.isBlank()) throw new IllegalArgumentException("CPF inválido");
        if(email == null || email.isBlank()) throw new IllegalArgumentException("Email inválido.");
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        if(conta == null) throw new IllegalArgumentException("Conta não pode ser nula.");
        contas.add(conta);
    }

    public List<Conta> getContas() {
        return Collections.unmodifiableList(contas);
    }

    public List<Investimento> listarInvestimentos() {
        return contas.stream()
                .flatMap(c -> c.getInvestimentos().stream())
                .toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return cpf.equals(cliente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}

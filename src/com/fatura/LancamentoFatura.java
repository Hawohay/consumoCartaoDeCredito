package com.fatura;

import java.time.LocalDate;

public class LancamentoFatura {
    private String descricao;
    private double valor;
    private LocalDate data;
    private boolean isPagamento;

    public LancamentoFatura(String descricao, double valor, LocalDate data, boolean isPagamento) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.isPagamento = isPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isPagamento() {
        return isPagamento;
    }

    @Override
    public String toString() {
        return (isPagamento ? "Pagamento: " : "Compra: ") + descricao + " - Valor: " + valor + " - Data: " + data;
    }
}

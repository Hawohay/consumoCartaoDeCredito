package com.fatura;

import com.cartao.Cartao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private String codigoIdentificador;
    private LocalDate dataDeVencimento;
    private LocalDate dataInicialDeLancamento;
    private LocalDate dataFinalDeLancamento;
    private String codigoDeBarraDaFatura;
    private List<LancamentoFatura> lancamentos = new ArrayList<>();
    private Cartao cartao;

    public Fatura(String codigoIdentificador, LocalDate dataDeVencimento, LocalDate dataInicialDeLancamento, LocalDate dataFinalDeLancamento, String codigoDeBarraDaFatura, Cartao cartao) {
        this.codigoIdentificador = codigoIdentificador;
        this.dataDeVencimento = dataDeVencimento;
        this.dataInicialDeLancamento = dataInicialDeLancamento;
        this.dataFinalDeLancamento = dataFinalDeLancamento;
        this.codigoDeBarraDaFatura = codigoDeBarraDaFatura;
        this.cartao = cartao;
    }

    // Adicionar um novo lançamento (compra)
    public void adicionarCompra(String descricao, double valor) {
        LancamentoFatura compra = new LancamentoFatura(descricao, valor, LocalDate.now(), false);
        lancamentos.add(compra);
    }

    // Adicionar um pagamento
    public void lancarPagamento(double valor) {
        LancamentoFatura pagamento = new LancamentoFatura("Pagamento", valor, LocalDate.now(), true);
        lancamentos.add(pagamento);
    }

    // Calcular o saldo total da fatura
    public double calcularSaldo() {
        double saldo = 0;
        for (LancamentoFatura lancamento : lancamentos) {
            if (lancamento.isPagamento()) {
                saldo -= lancamento.getValor();  // Pagamento reduz o saldo
            } else {
                saldo += lancamento.getValor();  // Compra aumenta o saldo
            }
        }
        return saldo;
    }

    // Verificar se a fatura está vencida
    public boolean estaVencida() {
        return LocalDate.now().isAfter(dataDeVencimento);
    }

    // Exibir a fatura e todos os lançamentos
    public void exibirFatura() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Fatura do Cartão: " + cartao.getNumeroDoCartao());
        System.out.println("Data de Vencimento: " + dataDeVencimento.format(formatter));
        System.out.println("Lançamentos:");
        for (LancamentoFatura lancamento : lancamentos) {
            System.out.println(lancamento);
        }
        System.out.println("Saldo total: " + calcularSaldo());
    }

    // Getter para obter os lançamentos (caso precise acessar externamente)
    public List<LancamentoFatura> getLancamentos() {
        return new ArrayList<>(lancamentos);  // Retorna uma cópia para preservar encapsulamento
    }
}

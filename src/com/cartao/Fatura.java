package com.cartao;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fatura {
    private LocalDate dataDeVencimento;
    private LocalDate dataInicialDeLancamento;
    private LocalDate dataFinalDeLancamento;
    private String codigoDeBarra;
    private ArrayList lancamento = new ArrayList<>();
    private Cartao cartao;


    public Fatura(LocalDate dataDeVencimento, LocalDate dataInicialDeLancamento, LocalDate dataFinalDeLancamento, String codigoDeBarra, ArrayList lancamento, Cartao cartao) {
        this.dataDeVencimento = dataDeVencimento;
        this.dataInicialDeLancamento = dataInicialDeLancamento;
        this.dataFinalDeLancamento = dataFinalDeLancamento;
        this.codigoDeBarra = codigoDeBarra;
        this.lancamento = lancamento;
        this.cartao = cartao;
    }

    public void pesquisarFatura(){

      }

    public void alterarDataDeVencimento(){

    }

    public boolean lancarPagamento(Cartao cartao){
        return true;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public LocalDate getDataInicialDeLancamento() {
        return dataInicialDeLancamento;
    }

    public void setDataInicialDeLancamento(LocalDate dataInicialDeLancamento) {
        this.dataInicialDeLancamento = dataInicialDeLancamento;
    }

    public LocalDate getDataFinalDeLancamento() {
        return dataFinalDeLancamento;
    }

    public void setDataFinalDeLancamento(LocalDate dataFinalDeLancamento) {
        this.dataFinalDeLancamento = dataFinalDeLancamento;
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    public ArrayList getLancamento() {
        return lancamento;
    }

    public void setLancamento(ArrayList lancamento) {
        this.lancamento = lancamento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}




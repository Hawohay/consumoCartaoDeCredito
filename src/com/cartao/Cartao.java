package com.cartao;

import com.bancodigital.Titular;
import com.fatura.Fatura;

import java.time.LocalDate;

public class Cartao {
    private String numeroDoCartao;
    private String bandeira;
    private String funcaoDoCartao;
    private LocalDate dataDeValidade;
    private double limiteDeCredito;
    private int cvv;
    private String senha;
    private Fatura fatura;
    private Titular titular;

    // Construtor
    public Cartao(String numeroDoCartao, String bandeira, String funcaoDoCartao, LocalDate dataDeValidade,
                  double limiteDeCredito, int cvv, String senha, Titular titular) {
        this.numeroDoCartao = numeroDoCartao;
        this.bandeira = bandeira;
        this.funcaoDoCartao = funcaoDoCartao;
        this.dataDeValidade = dataDeValidade;
        this.limiteDeCredito = limiteDeCredito;
        this.cvv = cvv;
        this.senha = senha;
        this.titular = titular;
    }

    // Getters e Setters para os atributos do Cartao
    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getFuncaoDoCartao() {
        return funcaoDoCartao;
    }

    public void setFuncaoDoCartao(String funcaoDoCartao) {
        this.funcaoDoCartao = funcaoDoCartao;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método para associar uma fatura ao cartão
    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    // Método para obter a fatura associada ao cartão
    public Fatura getFatura() {
        return fatura;
    }

    // Método para exibir as informações do cartão
    public void exibirInformacoesDoCartao() {
        System.out.println("Número do Cartão: " + numeroDoCartao);
        System.out.println("Bandeira: " + bandeira);
        System.out.println("Função: " + funcaoDoCartao);
        System.out.println("Validade: " + dataDeValidade);
        System.out.println("Limite de Crédito: " + limiteDeCredito);
        System.out.println("CVV: " + cvv);
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Senha: " + senha);
    }
}

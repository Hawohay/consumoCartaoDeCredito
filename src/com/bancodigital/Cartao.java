package com.bancodigital;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cartao {
    private String numeroDoCartao;
    private String bandeira;
    private String funcaoDoCartao;
    private int cvv;
    private String senha;
    private LocalDate dataDeValidade;
    private double limiteDeCredito;
    private Titular titular; // Referência ao titular

    // Construtor
    public Cartao(String numeroDoCartao, String bandeira, String funcaoDoCartao, LocalDate dataDeValidade, double limiteDeCredito, int cvv, String senha, Titular titular) {
        this.numeroDoCartao = numeroDoCartao;
        this.bandeira = bandeira;
        this.funcaoDoCartao = funcaoDoCartao;
        this.dataDeValidade = dataDeValidade;
        this.limiteDeCredito = limiteDeCredito;
        this.cvv = cvv;
        this.senha = senha;
        this.titular = titular;
    }

    public void exibirInformacoesDoCartao() {
        // Exibe informações pessoais do titular
        if (titular != null) {
            titular.exibirInformacoesDadosPessoais();
        }

        System.out.println("Número do Cartão: " + numeroDoCartao);
        System.out.println("Bandeira: " + bandeira);
        System.out.println("Função do Cartão: " + funcaoDoCartao);
        System.out.println("Senha: " + senha);
        System.out.println("CVV: " + cvv);

        if (dataDeValidade != null) {
            System.out.println("Data de Validade: " + dataDeValidade.format(DateTimeFormatter.ofPattern("MM/yy")));
        } else {
            System.out.println("Data de Validade: Não disponível");
        }

        System.out.println("Limite de Crédito: " + limiteDeCredito);
        System.out.println("Endereço: " + (titular != null ? (titular.getLogradouro() + ", " + titular.getBairro() + ", " + titular.getMunicipio() + " - " + titular.getUnidadeFederativa() + ", CEP: " + titular.getCep()) : "Não disponível"));
    }


    // Getters e Setters
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

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }
}

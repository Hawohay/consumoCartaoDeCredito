package com.lojaonline;

import java.util.ArrayList;
import java.util.List;


public class Produto {
    private String codigo;
    private String tipo;
    private String nome;
    private String descricao;
    private double valor;

    private static final List<Produto> listaDeProdutos = new ArrayList<>();

    public Produto(String codigo, String tipo, String nome, String descricao, double valor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    Produto produtoCadastrado = encontrarProdutoPorCodigo(codigo);

    Produto produto = new Produto(codigo, tipo, nome, descricao, valor);


    public static Produto encontrarProdutoPorCodigo(String codigo) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getCodigo().trim().equals(codigo.trim())) {
                return produto;
            }
        }
        return null;
    }

}

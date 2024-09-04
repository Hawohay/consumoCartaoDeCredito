package com.loja;

import com.utils.CodigoDeBarraUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {
    private String codigo;
    private String tipo;
    private String nome;
    private String descricao;
    private double valor;

    private static final List<Produto> listaDeProdutos = new ArrayList<>();

    public Produto(String tipo, String nome, String descricao, double valor) {
        this.codigo = gerarCodigoDeBarraValidoDoProduto(); // Gera código automaticamente
        this.tipo = tipo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produto() {
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

    public static Produto cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo do produto:");
        String tipo = scanner.nextLine().trim();

        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine().trim();

        System.out.println("Digite a descrição do produto:");
        String descricao = scanner.nextLine().trim();

        System.out.println("Digite o valor do produto:");
        double valor = lerValor(scanner);

        Produto novoProduto = new Produto(tipo, nome, descricao, valor);
        Produto produtoExistente = encontrarProdutoPorCodigo(novoProduto.getCodigo());

        if (produtoExistente != null) {
            System.out.println("Produto com número " + novoProduto.getCodigo() + " já existe.");
            System.out.println("Deseja atualizar as informações desse produto (s/n):");
            String resposta = scanner.nextLine().trim();

            if (resposta.equalsIgnoreCase("s")) {
                atualizarProduto(produtoExistente, tipo, nome, descricao, valor);
                System.out.println("As informações do produto foram atualizadas com sucesso.");
            }
            return produtoExistente;
        } else {
            listaDeProdutos.add(novoProduto);
            System.out.println("Produto cadastrado com sucesso.");
            System.out.println(novoProduto);
            return novoProduto;
        }
    }

    private static double lerValor(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Por favor, digite um número válido:");
            }
        }
    }

    private static void atualizarProduto(Produto produto, String tipo, String nome, String descricao, double valor) {
        produto.setTipo(tipo);
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setValor(valor);
    }

    public static Produto encontrarProdutoPorCodigo(String codigo) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    public static String gerarCodigoDeBarraValidoDoProduto() {
        String numeroProduto;
        boolean unico;

        do {
            String numeroBase = CodigoDeBarraUtils.gerarNumeroCodigoDeBarraBase();
            numeroProduto = numeroBase;
            unico = verificarUnicidade(numeroProduto);
        } while (!unico);

        return numeroProduto;
    }

    private static boolean verificarUnicidade(String codigo) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getCodigo().equals(codigo)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "CÓDIGO DE BARRAS: " + codigo + "; " +
                "TIPO: " + tipo + "; " +
                "NOME: " + nome + "; " +
                "DESCRIÇÃO: " + descricao + "; " +
                "VALOR: " + valor;
    }
}

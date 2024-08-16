package com.loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrinho {
    private static List<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>(); // Inicializa a lista de produtos
    }

    public void adicionarItemNoCarrinho() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o código do produto:");
        String codigo = scanner.nextLine().trim();

        Produto produto = Produto.encontrarProdutoPorCodigo(codigo);
        if (produto != null) {
            produtos.add(produto);
            System.out.println("O item: " + produto.getNome() + " foi adicionado no carrinho.");
        } else {
            System.out.println("Produto com código " + codigo + " não encontrado.");
        }
    }

    public static void exibirItensDoCarrinho() {
        if (produtos.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            System.out.println("Itens no carrinho:");
            for (Produto produto : produtos) {
                System.out.println(produto); // Usa o método toString() de Produto para exibição
            }
        }
    }
}

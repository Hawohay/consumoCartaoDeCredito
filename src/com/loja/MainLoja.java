package com.loja;

import java.util.Scanner;

public class MainLoja {
    public static void main(String[] args) {
        exibeMenuLoja(); // Chama o método para exibir o menu
    }

    public static void exibeMenuLoja() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------------");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Adicionar produto no carrinho");
            System.out.println("3 - Exibir produtos do carrinho");
            System.out.println("4 - finalizar compra");
            System.out.println("9 - Retornar para o menu anterior");
            System.out.println("0 - Sair");
            System.out.println("------------------------------");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    Produto.cadastrarProduto(); // Chamando o método estático
                    break;
                case 2:
                    Carrinho carrinho = new Carrinho(); // Instancia o carrinho
                    carrinho.adicionarItemNoCarrinho(); // Adiciona o item no carrinho
                    break;
                case 3:
                    Carrinho.exibirItensDoCarrinho(); // Chamando o método estático
                    break;
                case 9:
                    return;
                case 0:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}

package com.loja;

import com.bancodigital.MenuCartao;
import com.bancodigital.PagamentoCartaoCredito;
import com.bancodigital.Titular;

import java.util.Scanner;

public class MainLoja {
    public static void main(String[] args) {
        exibeMenuLoja(); // Chama o método para exibir o menu
    }

    public static void exibeMenuLoja() {
        Scanner scanner = new Scanner(System.in);
        Carrinho carrinho = new Carrinho(); // Instancie o carrinho aqui para compartilhar entre os casos

        while (true) {
            System.out.println("------------------------------");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Adicionar produto no carrinho");
            System.out.println("3 - Exibir produtos do carrinho");
            System.out.println("4 - Finalizar compra");
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
                    carrinho.adicionarItemNoCarrinho(); // Adiciona o item no carrinho
                    break;
                case 3:
                    carrinho.exibirItensDoCarrinho(); // Exibe os itens do carrinho
                    break;
                case 4:
                    double valorTotal = carrinho.calcularValorTotal(); // Calcula o valor total dos produtos no carrinho
                    PagamentoCartaoCredito pagamento = new PagamentoCartaoCredito(selecionarMenuCartao());
                    pagamento.processarPagamento(valorTotal);
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

    private static MenuCartao selecionarMenuCartao() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CPF do cliente para selecionar o cartão: ");
        String cpf = scanner.nextLine();

        Titular cliente = Titular.encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return null;
        }

        return new MenuCartao(cliente.getCartoes());
    }
}
package com.loja;

import com.cartao.Cartao;
import com.cartao.MenuCartao;
import com.cartao.PagamentoCartaoCredito;
import com.bancodigital.Titular;

import java.util.Scanner;

public class MainLoja {
    private static Scanner scanner = new Scanner(System.in); // Instância única de Scanner

    public static void main(String[] args) {
        exibeMenuLoja(); // Chama o método para exibir o menu
    }

    public static void exibeMenuLoja() {
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
                    finalizarCompra(carrinho); // Finaliza a compra
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

    private static void finalizarCompra(Carrinho carrinho) {
        double valorTotal = carrinho.calcularValorTotal(); // Calcula o valor total dos produtos no carrinho
        Cartao cartao = buscarCartaoDoCliente(); // Seleciona o cartão do cliente

        if (cartao != null) {
            PagamentoCartaoCredito pagamento = new PagamentoCartaoCredito(cartao);
            pagamento.processarPagamento(valorTotal);
        } else {
            System.out.println("Não foi possível processar o pagamento. Cartão inválido.");
        }
    }

    private static Cartao buscarCartaoDoCliente() {

        System.out.print("Digite o CPF do cliente para selecionar o cartão: ");
        String cpf = scanner.nextLine(); // Usar a mesma instância de Scanner

        Titular cliente = Titular.encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return null;
        }

        MenuCartao menuCartao = new MenuCartao(cliente.getCartoes());
        return menuCartao.selecionarCartao(cpf); // Chama o método que solicita e retorna o cartão selecionado
    }
}

package com.bancodigital;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuCartao {

    private final List<Cartao> cartoes;
    private final Scanner scanner;

    public MenuCartao(List<Cartao> cartoes) {
        this.cartoes = cartoes;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuCartao() {
        while (true) {
            System.out.println("M. Menu de Opções:");
            System.out.println("1. Adicionar Cartão");
            System.out.println("2. Exibir Cartões");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.println("9. Sair");
            System.out.print("E. Escolha uma opção: ");
            System.out.println();

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    adicionarCartao();
                    break;
                case 2:
                    exibirCartoes();
                    break;
                case 3:
                    System.out.println("Voltando ao Menu Principal...");
                    return;
                case 9:
                    System.out.println("Saindo...");
                    System.exit(0); // Termina o programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarCartao() {
        // Solicitar o CPF do cliente para associar o cartão
        System.out.print("Digite o CPF do cliente para associar o cartão: ");
        String cpf = scanner.nextLine();

        Titular cliente = Titular.encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado. Primeiro cadastre um cliente.");
            return;
        }

        // Verificar se o cliente já possui cartões
        List<Cartao> cartoesDoCliente = cliente.getCartoes();

        // Criar um novo cartão
        System.out.println("Criando um novo cartão...");

        String numeroDoCartao = GeradorCartao.gerarNumeroCartaoValido(cartoesDoCliente); // Usar a lista do cliente para verificar números
        int cvv = GeradorCartao.gerarCVV(cartoesDoCliente);
        System.out.println("Número do Cartão Gerado: " + numeroDoCartao);
        System.out.println("Número do CVV: " + cvv);

        // Solicitar detalhes adicionais do cartão
        Cartao novoCartao = new Cartao(numeroDoCartao, "", "", LocalDate.now(), 0, cvv, cliente); // Inicializar com valores padrão

        solicitarDetalhesCartao(novoCartao);

        // Verificar se o cartão já existe
        if (cartoesDoCliente.stream().anyMatch(c -> c.getNumeroDoCartao().equals(novoCartao.getNumeroDoCartao()))) {
            System.out.println("Cartão já existe para este cliente.");
        } else {
            cliente.getCartoes().add(novoCartao); // Adiciona o novo cartão à lista de cartões do titular
            System.out.println("Cartão adicionado com sucesso!");
        }
    }

    private void exibirCartoes() {
        // Solicitar o CPF do cliente para exibir os cartões
        System.out.print("Digite o CPF do cliente para exibir os cartões: ");
        String cpf = scanner.nextLine();

        Titular cliente = Titular.encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        List<Cartao> cartoesDoCliente = cliente.getCartoes();

        if (cartoesDoCliente == null || cartoesDoCliente.isEmpty()) {
            System.out.println("Nenhum cartão cadastrado para este cliente.");
        } else {
            for (Cartao cartao : cartoesDoCliente) {
                if (cartao != null) {
                    cartao.exibirInformacoesDoCartao();
                    System.out.println();
                } else {
                    System.out.println("Cartão nulo encontrado.");
                }
            }
        }
    }

    private void solicitarDetalhesCartao(Cartao cartao) {
        System.out.print("Bandeira: ");
        String bandeira = scanner.nextLine();

        System.out.print("Função do Cartão: ");
        String funcaoDoCartao = scanner.nextLine();

        System.out.print("Anos de Validade: ");
        int anosDeValidade = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Limite de Crédito: ");
        double limiteDeCredito = scanner.nextDouble();
        scanner.nextLine(); // Consumir nova linha

        cartao.setBandeira(bandeira);
        cartao.setFuncaoDoCartao(funcaoDoCartao);
        cartao.setDataDeValidade(LocalDate.now().plusYears(anosDeValidade));
        cartao.setLimiteDeCredito(limiteDeCredito);
    }
}

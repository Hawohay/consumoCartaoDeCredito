package com.cartao;

import com.bancodigital.Titular;
import com.fatura.Fatura;
import com.utils.GeradorCartao;
import com.utils.HashUtil;

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
            System.out.println("3. Exibir Fatura");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
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
                    exibirFatura();
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal...");
                    return;
                case 9:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarCartao() {
        System.out.print("Digite o CPF do cliente para associar o cartão: ");
        String cpf = scanner.nextLine();

        Titular cliente = Titular.encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado. Primeiro cadastre um cliente.");
            return;
        }

        List<Cartao> cartoesDoCliente = cliente.getCartoes();

        System.out.println("Criando um novo cartão...");

        String numeroDoCartao = GeradorCartao.gerarNumeroCartaoValido(cartoesDoCliente);
        int cvv = GeradorCartao.gerarCVV(cartoesDoCliente);
        System.out.println("Número do Cartão Gerado: " + numeroDoCartao);
        System.out.println("Número do CVV: " + cvv);

        Cartao novoCartao = new Cartao(numeroDoCartao, "", "", LocalDate.now(), 0, cvv, "", cliente);
        Fatura novaFatura = new Fatura("fatura-" + numeroDoCartao, LocalDate.now().plusMonths(1),
                LocalDate.now(), LocalDate.now().plusDays(30),
                "codigoDeBarra", novoCartao);

        novoCartao.setFatura(novaFatura);

        solicitarDetalhesCartao(novoCartao);

        if (cartoesDoCliente.stream().anyMatch(c -> c.getNumeroDoCartao().equals(novoCartao.getNumeroDoCartao()))) {
            System.out.println("Cartão já existe para este cliente.");
        } else {
            cliente.getCartoes().add(novoCartao);
            System.out.println("Cartão adicionado com sucesso!");
        }
    }

    private void exibirCartoes() {
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

    private void exibirFatura() {
        System.out.print("Digite o CPF do cliente para exibir a fatura: ");
        String cpf = scanner.nextLine();

        Cartao cartao = selecionarCartao(cpf);

        if (cartao != null && cartao.getFatura() != null) {
            cartao.getFatura().exibirFatura();
        } else {
            System.out.println("Nenhuma fatura encontrada para este cartão.");
        }
    }

    public Cartao selecionarCartao(String cpf) {
        Titular cliente = Titular.encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return null;
        }

        List<Cartao> cartoesDoCliente = cliente.getCartoes();

        if (cartoesDoCliente == null || cartoesDoCliente.isEmpty()) {
            System.out.println("Nenhum cartão cadastrado para este cliente.");
            return null;
        } else {
            System.out.println("Selecione o número do cartão:");
            for (int i = 0; i < cartoesDoCliente.size(); i++) {
                System.out.println((i + 1) + ". " + cartoesDoCliente.get(i).getNumeroDoCartao());
            }

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            if (escolha > 0 && escolha <= cartoesDoCliente.size()) {
                return cartoesDoCliente.get(escolha - 1);
            } else {
                System.out.println("Opção inválida.");
                return null;
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

        System.out.println("Informe a senha com 6 dígitos numéricos:");
        String senha = scanner.nextLine();

        if (senha.length() != 6 || !senha.matches("\\d{6}")) {
            System.out.println("A senha deve conter exatamente 6 dígitos numéricos.");
            return;
        } else {
            try {
                String senhaCifrada = HashUtil.hashSenha(senha);
                cartao.setSenha(senhaCifrada);
            } catch (Exception e) {
                System.out.println("Erro ao cifrar a senha: " + e.getMessage());
                return;
            }
        }

        cartao.setBandeira(bandeira);
        cartao.setFuncaoDoCartao(funcaoDoCartao);
        cartao.setDataDeValidade(LocalDate.now().plusYears(anosDeValidade));
        cartao.setLimiteDeCredito(limiteDeCredito);

        System.out.println("Detalhes do cartão atualizados com sucesso.");
    }
}

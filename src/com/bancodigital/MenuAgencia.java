package com.bancodigital;

import java.util.Scanner;

public class MenuAgencia {

    public static void exibeMenuAgencia() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------------");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Pesquisar Cliente");
            System.out.println("3 - Atualizar Dados do Cliente");
            System.out.println("4 - Cadastrar Agência");
            System.out.println("5 - Pesquisar Agência");
            System.out.println("6 - Cadastrar Conta Corrente");
            System.out.println("7 - Cadastrar Conta Poupança");
            System.out.println("8 - Retornar para o menu anterior");
            System.out.println("9 - Sair");
            System.out.println("------------------------------");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    new Titular().cadastrarCliente();
                    break;
                case 2:
                    new Titular().pesquisarCliente();
                    break;
                case 3:
                    new Titular().atualizarDadosCliente();
                    break;
                case 4:
                    Agencia.cadastrarAgencia();
                    break;
                case 5:
                    pesquisarAgencia();
                    break;
                case 6:
                    cadastrarContaCorrente();
                    break;
                case 7:
                    cadastrarContaPoupanca();
                    break;
                case 8:
                    return;
                case 9:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void pesquisarAgencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da agência:");
        String numero = scanner.nextLine();
        Agencia agencia = Agencia.encontrarAgenciaPorNumero(numero);

        if (agencia != null) {
            agencia.exibirInfo();
        } else {
            System.out.println("Agência com número " + numero + " não encontrada.");
        }
    }

    private static void cadastrarContaCorrente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF/CNPJ do titular:");
        String cpf = scanner.nextLine();
        Titular titular = Titular.encontrarClientePorCpf(cpf);

        if (titular == null) {
            System.out.println("Cliente não encontrado. Realize o cadastro do cliente primeiro.");
            return;
        }

        System.out.println("Digite o número da agência:");
        String numeroAgencia = scanner.nextLine();
        Agencia agencia = Agencia.encontrarAgenciaPorNumero(numeroAgencia);

        if (agencia == null) {
            System.out.println("Agência não encontrada. Realize o cadastro da agência primeiro.");
            return;
        }

        System.out.println("Digite a taxa de manutenção:");
        double taxaManutencao = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner

        ContaCorrente contaCorrente = new ContaCorrente(agencia.getContas(), titular, agencia, taxaManutencao);
        agencia.adicionarConta(contaCorrente);
        System.out.println("Conta Corrente cadastrada com sucesso. Número: " + contaCorrente.getNumero());
    }

    private static void cadastrarContaPoupanca() {
        // Implementar lógica para cadastrar conta poupança
    }
}

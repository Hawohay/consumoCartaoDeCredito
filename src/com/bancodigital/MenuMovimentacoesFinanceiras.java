package com.bancodigital;

import java.util.List;
import java.util.Scanner;

public class MenuMovimentacoesFinanceiras {
    private List<Conta> listaDeContas;
    private Agencia agencia;

    public MenuMovimentacoesFinanceiras(Agencia agencia) {
        this.listaDeContas = agencia.getContas();
        this.agencia = agencia;
    }

    public void exibirMenuMovimentacoesFinanceiras() {
        Scanner scanner = new Scanner(System.in);

        Deposito novoDeposito = new Deposito(listaDeContas, agencia);
        TransferenciaEntreContas novaTransferencia = new TransferenciaEntreContas(listaDeContas, agencia);
        Saque novoSaque = new Saque(agencia);
        Saldo exibeSaldo = new Saldo(listaDeContas, agencia);

        while (true) {
            System.out.println("Menu de Opções:");
            System.out.println("1. Depósito");
            System.out.println("2. Transferência");
            System.out.println("3. Saque");
            System.out.println("4. Saldo");
            System.out.println("7. Retornar");
            System.out.println("9. Sair...");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    novoDeposito.realizarDeposito();
                    break;
                case 2:
                    novaTransferencia.realizarTransferencia();
                    break;
                case 3:
                    novoSaque.realizarSaque();
                    break;
                case 4:
                    exibeSaldo.exibirSaldo();
                    break;
                case 7:
                    return;
                case 9:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
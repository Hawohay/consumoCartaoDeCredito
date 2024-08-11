package com.bancodigital;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Deposito {
    private List<Conta> listaDeContas;
    private Agencia agencia;
    private Scanner scanner = new Scanner(System.in);

    public Deposito(List<Conta> listaDeContas, Agencia agencia) {
        this.listaDeContas = listaDeContas;
        this.agencia = agencia;
    }

    public void realizarDeposito() {
        while (true) {
            System.out.println("------------------");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Poupança");
            System.out.println("3 - Retornar para o menu anterior");
            System.out.println("9 - Sair");
            System.out.println("-------------------");
            System.out.print("Informe uma opção: ");

            int opcaoDeposito = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcaoDeposito) {
                case 1:
                    realizarDepositoConta("Conta Corrente", ContaCorrente.class);
                    break;

                case 2:
                    realizarDepositoConta("Conta Poupança", ContaPoupanca.class);
                    break;

                case 3:
                    return; // Retorna ao menu anterior

                case 9:
                    System.out.println("Saindo...");
                    return; // Retorna do método e termina a execução da classe `Deposito`

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private <T extends Conta> void realizarDepositoConta(String tipoConta, Class<T> classeConta) {
        System.out.print("Digite o número da " + tipoConta + " do cliente que deseja realizar o depósito: ");
        String numeroConta = scanner.nextLine();

        Optional<Conta> contaOptional = Optional.ofNullable(agencia.buscarConta(numeroConta));

        if (contaOptional.isPresent() && classeConta.isInstance(contaOptional.get())) {
            T conta = classeConta.cast(contaOptional.get());
            System.out.print("Digite o valor do depósito: ");
            double valorAdicionar = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (valorAdicionar > 0) {
                conta.depositar(valorAdicionar);
                System.out.println("Depósito realizado com sucesso. Novo saldo: " + conta.getSaldo());
            } else {
                System.out.println("Valor de depósito inválido.");
            }
        } else {
            System.out.println("Conta com número " + numeroConta + " não encontrada ou não é uma " + tipoConta + ".");
        }
    }
}

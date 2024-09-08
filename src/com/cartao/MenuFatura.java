package com.cartao;

import com.fatura.Fatura;

import java.util.List;
import java.util.Scanner;

public class MenuFatura {

    private final List<Fatura> faturas;
    private final Scanner scanner;

    public MenuFatura(List<Fatura> faturas) {
        this.faturas = faturas;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuFatura() {
        while (true) {
            System.out.println("M. Menu de Opções:");
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.println("5. ........................");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            System.out.println();

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    //
                    break;
                case 2:
                    //
                    break;
                case 3:
                    //
                    break;
                case 4 :
                    System.out.println("Voltando ao Menu Principal...");
                    return;
                case 9:
                    System.out.println("Saindo...");
                    // Retorne para o menu principal ou encerre o programa de forma adequada
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

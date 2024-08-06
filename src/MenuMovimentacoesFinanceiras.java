import java.util.Scanner;

public class MenuMovimentacoesFinanceiras {

    public void exibirMenuMovimentacoesFinanceiras() {

        Scanner scanner = new Scanner(System.in);

        Deposito novoDeposito = new Deposito();
        TransferenciaEntreContas novaTransferencia = new TransferenciaEntreContas();
        Saque novoSaque = new Saque();
        Saldo exibeSaldo = new Saldo();



        while (true) {
            System.out.println("Menu de Opções:");
            System.out.println("1. Deposito");
            System.out.println("2. Transferência");
            System.out.println("3. Saque");
            System.out.println("4. Saldo");
            System.out.println("7. retornar");
            System.out.println("9. Sair...");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();

            scanner.nextLine(); // Consumir nova linha

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
                    System.exit(0); // Termina o programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}


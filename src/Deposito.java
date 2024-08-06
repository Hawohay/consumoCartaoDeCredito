import java.util.Scanner;

public class Deposito {
    private Agencia agencia;
    private Scanner scanner;

    public Deposito() {
        this.agencia = agencia;
        this.scanner = new Scanner(System.in);
    }

    public void realizarDeposito() {
        System.out.println("------------------");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Poupança");
        System.out.println("3 - Retornar para o menu anterior");
        System.out.println("9 - Sair...");
        System.out.println("-------------------");
        System.out.println("Informe uma opção");

        int opcaoDeposito = scanner.nextInt();

        while (true)

            switch (opcaoDeposito) {
                case 1:

                    System.out.println("Digite o número da conta do cliente que deseja realizar o depósito:");

                    String numeroContaCorrenteParaDeposito = scanner.nextLine();

                    ContaCorrente contaParaDeposito = (ContaCorrente) agencia.buscarConta(numeroContaCorrenteParaDeposito);

                    if (contaParaDeposito != null) {
                        System.out.println("Digite o valor do depósito:");
                        double valorAdicionar = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer do scanner

                        contaParaDeposito.depositar(valorAdicionar);
                    } else {
                        System.out.println("Conta com número " + numeroContaCorrenteParaDeposito + " não encontrada.");
                    }
                    break;

                case 2:

                    System.out.println("Digite o número da conta do cliente que deseja realizar o depósito:");

                    String numeroContaPoupancaParaDeposito = scanner.nextLine();

                    ContaPoupanca contaPoupancaParaDeposito = (ContaPoupanca) agencia.buscarConta(numeroContaPoupancaParaDeposito);

                    if (contaPoupancaParaDeposito != null) {
                        System.out.println("Digite o valor do depósito:");
                        double valorAdicionar = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer do scanner

                        contaPoupancaParaDeposito.depositar(valorAdicionar);
                    } else {
                        System.out.println("Conta com número " + numeroContaPoupancaParaDeposito + " não encontrada.");
                    }
                    break;

                case 3:
                    return;
                case 9:
                    break;
            }
    }
}

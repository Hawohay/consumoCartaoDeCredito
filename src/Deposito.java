import java.util.List;
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
            System.out.println("9 - Sair...");
            System.out.println("-------------------");
            System.out.print("Informe uma opção: ");

            int opcaoDeposito = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcaoDeposito) {
                case 1:
                    System.out.print("Digite o número da conta corrente do cliente que deseja realizar o depósito: ");
                    String numeroContaCorrenteParaDeposito = scanner.nextLine();

                    Conta contaCorrenteParaDeposito = agencia.buscarConta(numeroContaCorrenteParaDeposito);

                    if (contaCorrenteParaDeposito instanceof ContaCorrente) {
                        System.out.print("Digite o valor do depósito: ");
                        double valorAdicionar = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer do scanner

                        contaCorrenteParaDeposito.depositar(valorAdicionar);
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Conta com número " + numeroContaCorrenteParaDeposito + " não encontrada ou não é uma conta corrente.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o número da conta poupança do cliente que deseja realizar o depósito: ");
                    String numeroContaPoupancaParaDeposito = scanner.nextLine();

                    Conta contaPoupancaParaDeposito = agencia.buscarConta(numeroContaPoupancaParaDeposito);

                    if (contaPoupancaParaDeposito instanceof ContaPoupanca) {
                        System.out.print("Digite o valor do depósito: ");
                        double valorAdicionar = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer do scanner

                        contaPoupancaParaDeposito.depositar(valorAdicionar);
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Conta com número " + numeroContaPoupancaParaDeposito + " não encontrada ou não é uma conta poupança.");
                    }
                    break;

                case 3:
                    return; // Retorna ao menu anterior

                case 9:
                    System.out.println("Saindo...");
                    System.exit(0); // Termina o programa

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

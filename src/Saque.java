import java.util.List;
import java.util.Scanner;

public class Saque {
    private List<Conta> listaDeContas;
    private Agencia agencia;
    private Scanner scanner = new Scanner(System.in);

    public Saque(List<Conta> listaDeContas, Agencia agencia) {
        this.listaDeContas = listaDeContas;
        this.agencia = agencia;
    }

    public void realizarSaque() {
        while (true) {
            System.out.println("------------------");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Poupança");
            System.out.println("3 - Retornar para o menu anterior");
            System.out.println("9 - Sair...");
            System.out.println("-------------------");
            System.out.print("Informe uma opção: ");

            int opcaoSaque = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcaoSaque) {
                case 1:
                    System.out.print("Digite o número da conta corrente do cliente que deseja realizar o saque: ");
                    String numeroContaCorrenteParaSaque = scanner.nextLine();

                    Conta contaCorrenteParaSaque = agencia.buscarConta(numeroContaCorrenteParaSaque);

                    if (contaCorrenteParaSaque instanceof ContaCorrente) {
                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer do scanner

                        if (contaCorrenteParaSaque.getSaldo() >= valorSaque) {
                            contaCorrenteParaSaque.sacar(valorSaque);
                            System.out.println("Saque realizado com sucesso.");
                        } else {
                            System.out.println("Saldo insuficiente para o saque.");
                        }
                    } else {
                        System.out.println("Conta com número " + numeroContaCorrenteParaSaque + " não encontrada ou não é uma conta corrente.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o número da conta poupança do cliente que deseja realizar o saque: ");
                    String numeroContaPoupancaParaSaque = scanner.nextLine();

                    Conta contaPoupancaParaSaque = agencia.buscarConta(numeroContaPoupancaParaSaque);

                    if (contaPoupancaParaSaque instanceof ContaPoupanca) {
                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer do scanner

                        if (contaPoupancaParaSaque.getSaldo() >= valorSaque) {
                            contaPoupancaParaSaque.sacar(valorSaque);
                            System.out.println("Saque realizado com sucesso.");
                        } else {
                            System.out.println("Saldo insuficiente para o saque.");
                        }
                    } else {
                        System.out.println("Conta com número " + numeroContaPoupancaParaSaque + " não encontrada ou não é uma conta poupança.");
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

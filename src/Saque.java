import java.util.Optional;
import java.util.Scanner;

public class Saque {
    private Agencia agencia;
    private Scanner scanner = new Scanner(System.in);

    public Saque(Agencia agencia) {
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
                    realizarSaqueConta("Conta Corrente", ContaCorrente.class);
                    break;

                case 2:
                    realizarSaqueConta("Conta Poupança", ContaPoupanca.class);
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

    private <T extends Conta> void realizarSaqueConta(String tipoConta, Class<T> classeConta) {
        System.out.print("Digite o número da " + tipoConta + " do cliente que deseja realizar o saque: ");
        String numeroConta = scanner.nextLine();

        Optional<Conta> contaOptional = Optional.ofNullable(agencia.buscarConta(numeroConta));

        if (contaOptional.isPresent() && classeConta.isInstance(contaOptional.get())) {
            T conta = classeConta.cast(contaOptional.get());
            System.out.print("Digite o valor do saque: ");
            double valorSaque = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (conta.getSaldo() >= valorSaque) {
                conta.sacar(valorSaque);
                System.out.println("Saque realizado com sucesso. Novo saldo: " + conta.getSaldo());
            } else {
                System.out.println("Saldo insuficiente para o saque.");
            }
        } else {
            System.out.println("Conta com número " + numeroConta + " não encontrada ou não é uma " + tipoConta + ".");
        }
    }
}

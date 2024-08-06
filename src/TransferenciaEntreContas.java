import java.util.List;
import java.util.Scanner;

public class TransferenciaEntreContas {

    private List<Conta> listaDeContas;  // Lista de contas
    private Agencia agencia;
    private Scanner scanner = new Scanner(System.in);

    public TransferenciaEntreContas(List<Conta> listaDeContas, Agencia agencia) {
        this.listaDeContas = this.listaDeContas;
    }

    public void realizarTransferencia() {

        System.out.println("Digite o CPF/CNPJ do cliente remetente:");
        String cpfRemetente = scanner.nextLine();

        Conta contaRemetente = encontrarContaPorCpf(listaDeContas, cpfRemetente);

        if (contaRemetente != null) {
            System.out.println("Digite o CPF do cliente destinatário:");
            String cpfDestinatario = scanner.nextLine();

            Conta contaDestinatario = encontrarContaPorCpf(listaDeContas, cpfDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Digite o valor a ser transferido:");
                double valorDaTransferencia = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer do scanner

                if (contaRemetente.getSaldo() >= valorDaTransferencia) {
                    contaRemetente.sacar(valorDaTransferencia);
                    contaDestinatario.depositar(valorDaTransferencia);
                    System.out.println("Transferência realizada com sucesso.");
                } else {
                    System.out.println("Saldo insuficiente para a transferência.");
                }
            } else {
                System.out.println("Cliente destinatário com CPF " + cpfDestinatario + " não encontrado.");
            }
        } else {
            System.out.println("Cliente remetente com CPF " + cpfRemetente + " não encontrado.");
        }
    }

    private Conta encontrarContaPorCpf(List<Conta> listaDeContas, String cpf) {
        for (Conta conta : listaDeContas) {
            if (conta.getTitular().getCpf().equals(cpf)) {
                return conta;
            }
        }
        return null;
    }
}

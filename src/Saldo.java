import java.util.List;
import java.util.Scanner;

public class Saldo {
    private List<Conta> listaDeContas;
    private Agencia agencia;
    private Scanner scanner = new Scanner(System.in);

    public Saldo(List<Conta> listaDeContas, Agencia agencia) {
        this.listaDeContas = listaDeContas;
        this.agencia = agencia;
    }

    public void exibirSaldo() {
        System.out.println("Informe o CPF do cliente:");
        String cpfDoCliente = scanner.nextLine();

        Conta contaCliente = encontrarContaPorCpf(listaDeContas, cpfDoCliente);

        if (contaCliente != null) {
            System.out.println("Saldo do cliente: " + contaCliente.getSaldo());
        } else {
            System.out.println("Cliente com o CPF: " + cpfDoCliente + " não encontrado.");
        }
    }

    private Conta encontrarContaPorCpf(List<Conta> listaDeContas, String cpfCnpj) {
        for (Conta conta : listaDeContas) {
            if (conta.getTitular().getCpf().equals(cpfCnpj)) {
                return conta;
            }
        }
        return null;
    }
}

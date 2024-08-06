import java.util.Scanner;

public class ContaCorrente extends Conta {
    
    private double taxaManutencao;
    
    Scanner scanner = new Scanner(System.in);
    
    public ContaCorrente(String numero, Titular titular, Agencia agencia, double taxaManutencao) {
        super(numero, titular, agencia);
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso. Novo saldo: " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    @Override
    public void aplicarRendimento() {
        // Conta Corrente normalmente não tem rendimento, então não faz nada
    }

    public void cobrarTaxa() {
        if (saldo >= taxaManutencao) {
            saldo -= taxaManutencao;
            System.out.println("Taxa de manutenção de " + taxaManutencao + " cobrada. Novo saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para cobrar a taxa de manutenção.");
        }
    }
}


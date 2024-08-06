public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String numero, Titular titular, Agencia agencia, double taxaRendimento) {
        super(numero, titular, agencia);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void aplicarRendimento() {
        if (saldo > 0) {
            saldo += saldo * taxaRendimento;
        }
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
}

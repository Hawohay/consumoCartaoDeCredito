package com.bancodigital;

import java.util.List;

public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    /**
     * Construtor para inicializar uma conta corrente.
     *
     * @param contasExistentes A lista de contas existentes para garantir unicidade do número da conta.
     * @param titular O titular da conta.
     * @param agencia A agência associada à conta.
     * @param taxaManutencao A taxa de manutenção da conta corrente.
     */
    public ContaPoupanca(List<Conta> contasExistentes, Titular titular, Agencia agencia, double taxaManutencao) {
        super(contasExistentes, titular, agencia);
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

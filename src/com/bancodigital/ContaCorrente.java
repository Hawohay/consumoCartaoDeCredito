package com.bancodigital;

import java.util.List;

public class ContaCorrente extends Conta {

    private double taxaManutencao;

    /**
     * Construtor para inicializar uma conta corrente.
     *
     * @param contasExistentes A lista de contas existentes para garantir unicidade do número da conta.
     * @param titular O titular da conta.
     * @param agencia A agência associada à conta.
     * @param taxaManutencao A taxa de manutenção da conta corrente.
     */
    public ContaCorrente(List<Conta> contasExistentes, Titular titular, Agencia agencia, double taxaManutencao) {
        super(contasExistentes, titular, agencia);
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            throw new IllegalArgumentException("Valor de depósito inválido.");
        }
    }

    @Override
    public void aplicarRendimento() {
        // Conta Corrente normalmente não tem rendimento, então não faz nada
    }

    /**
     * Cobra a taxa de manutenção da conta corrente.
     */
    public void cobrarTaxa() {
        if (saldo >= taxaManutencao) {
            saldo -= taxaManutencao;
        } else {
            throw new IllegalStateException("Saldo insuficiente para cobrar a taxa de manutenção.");
        }
    }
}

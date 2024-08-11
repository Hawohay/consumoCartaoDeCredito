package com.bancodigital;

import java.util.List;

public abstract class Conta {
    protected String numero;
    protected double saldo;
    protected Titular titular;
    protected Agencia agencia;

    /**
     * Construtor para inicializar uma conta.
     *
     * @param contasExistentes A lista de contas existentes para garantir unicidade do número da conta.
     * @param titular O titular da conta.
     * @param agencia A agência associada à conta.
     */

    public Conta(List<Conta> contasExistentes, Titular titular, Agencia agencia) {
        this.numero = GeradorDeConta.gerarNumeroContaValida(contasExistentes);
        this.titular = titular;
        this.agencia = agencia;
        this.saldo = 0.0;

        // Associar a conta ao titular e à agência
        titular.getContas().add(this);
        agencia.getContas().add(this);
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Titular getTitular() {
        return titular;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta contaDestino, double valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    public abstract void aplicarRendimento();
}

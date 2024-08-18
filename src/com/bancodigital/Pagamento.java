package com.bancodigital;

public interface Pagamento {
        void processarPagamento(double valor);
    boolean validarPagamento(Cartao cartao);
}

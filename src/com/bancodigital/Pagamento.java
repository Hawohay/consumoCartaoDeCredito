package com.bancodigital;

import com.cartao.Cartao;

public interface Pagamento {
    void processarPagamento(double valor);
    boolean validarPagamento(Cartao cartao);
}

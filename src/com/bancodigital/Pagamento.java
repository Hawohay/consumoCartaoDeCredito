package com.bancodigital;

import com.cartao.Cartao;

public interface Pagamento {
    void processarPagamento(double valor, String descricao);
    boolean validarPagamento(Cartao cartao);
}

package com.bancodigital;

import com.loja.Carrinho;

import java.time.LocalDate;

public class PagamentoCartaoCredito implements Pagamento {
    private final MenuCartao menuCartao;

    public PagamentoCartaoCredito(MenuCartao menuCartao) {
        this.menuCartao = menuCartao;
    }

    @Override
    public void processarPagamento(double valor) {
        Cartao cartao = menuCartao.selecionarCartao();

        if (cartao == null) {
            System.out.println("Pagamento não realizado. Cartão inválido ou não encontrado.");
            return;
        }

        // Lógica para processar pagamento com o cartão selecionado
        if (validarPagamento(cartao)) {
            System.out.println("Pagamento de " + valor + " realizado com sucesso com o cartão " + cartao.getNumeroDoCartao());
            // Atualizar o saldo do cartão ou outra lógica de negócio
        } else {
            System.out.println("Pagamento não realizado. Cartão inválido.");
        }
    }

    @Override
    public boolean validarPagamento(Cartao cartao) {
        double limite = cartao.getLimiteDeCredito();
        return cartao.getDataDeValidade().isAfter(LocalDate.now());
    }
}

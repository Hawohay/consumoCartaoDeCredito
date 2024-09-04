package com.cartao;

import com.bancodigital.Pagamento;

import java.time.LocalDate;
import java.util.Scanner;

public class PagamentoCartaoCredito implements Pagamento {
    private final Cartao cartao;


    // Construtor atualizado para aceitar Cartao
    public PagamentoCartaoCredito(Cartao cartao) {
        this.cartao = cartao;
    }


    @Override
    public void processarPagamento(double valor) {
        if (cartao == null) {
            System.out.println("Pagamento não realizado. Cartão inválido ou não encontrado.");
            return;
        }

        // Lógica para processar pagamento com o cartão
        if (validarPagamento(cartao)) {
            double limite = cartao.getLimiteDeCredito();

            if (limite < valor) {
                System.out.println("Limite insuficiente, transação não autorizada!");
            } else {
                limite -= valor;
                cartao.setLimiteDeCredito(limite);
                System.out.println("Pagamento de " + valor + " realizado com sucesso com o cartão " + cartao.getNumeroDoCartao());
                //>>>
            }
        } else {
            System.out.println("Pagamento não realizado. Cartão inválido.");
        }
    }

    @Override
    public boolean validarPagamento(Cartao cartao) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar senha e CVV do usuário
        System.out.println("Informe a senha do cartão:");
        String senha = scanner.nextLine();
        System.out.println("Informe o CVV:");
        String cvv = scanner.nextLine();

        // Comparar os valores fornecidos com os armazenados no cartão
        if (cartao.getSenha().equals(senha) && cartao.getCvv() == Integer.parseInt(cvv)) {
            return cartao.getDataDeValidade().isAfter(LocalDate.now());
        } else {
            System.out.println("Dados informados inválidos");
            return false;
        }
    }
}

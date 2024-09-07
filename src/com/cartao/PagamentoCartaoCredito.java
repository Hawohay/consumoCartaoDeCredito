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
    public void processarPagamento(double valor, String descricao) {
        if (cartao == null) {
            System.out.println("Pagamento não realizado. Cartão inválido ou não encontrado.");
            return;
        }

        // Lógica para processar pagamento com o cartão
        if (validarPagamento(cartao)) { // Passe o Cartao para validarPagamento
            double limite = cartao.getLimiteDeCredito();

            if (limite < valor) {
                System.out.println("Limite insuficiente, transação não autorizada!");
            } else {
                limite -= valor;
                cartao.setLimiteDeCredito(limite);
                System.out.println("Pagamento de " + valor + " realizado com sucesso com o cartão " + cartao.getNumeroDoCartao());

                // Verifique se a fatura está associada antes de adicionar a compra
                if (cartao.getFatura() != null) {
                    cartao.getFatura().adicionarCompra(descricao, valor);
                } else {
                    System.out.println("Erro: O cartão não possui fatura associada.");
                }
            }
        } else {
            System.out.println("Pagamento não realizado. Dados do cartão inválidos.");
        }
    }

    @Override
    public boolean validarPagamento(Cartao cartao) { // Assinatura deve corresponder à interface
        Scanner scanner = new Scanner(System.in);

        // Solicitar senha e CVV do usuário
        System.out.println("Informe a senha do cartão:");
        String senha = scanner.nextLine();
        System.out.println("Informe o CVV:");
        String cvv = scanner.nextLine();

        try {
            int cvvInt = Integer.parseInt(cvv);
            if (cartao.getSenha().equals(senha) && cartao.getCvv() == cvvInt) {
                return cartao.getDataDeValidade().isAfter(LocalDate.now());
            }
        } catch (NumberFormatException e) {
            System.out.println("CVV inválido. Insira apenas números.");
        }

        System.out.println("Dados informados inválidos");
        return false;
    }
}

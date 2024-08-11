package com.bancodigital;

import java.util.Random;

public class CartaoUtils {
    public static String gerarNumeroCartaoBase() {
        Random random = new Random();
        StringBuilder numeroCartao = new StringBuilder();

        // Gerar 15 dígitos aleatórios (excluindo o dígito verificador)
        for (int i = 0; i < 15; i++) {
            int digito = random.nextInt(10);
            numeroCartao.append(digito);
        }

        return numeroCartao.toString();
    }
}

package com.utils;

import java.util.Random;

public class CodigoDeBarraUtils {

    public static String gerarNumeroCodigoDeBarraBase() {
        Random random = new Random();
        StringBuilder numeroProduto = new StringBuilder();

        // Gerar os primeiros 12 dígitos aleatórios
        for (int i = 0; i < 12; i++) {
            int digito = random.nextInt(10);
            numeroProduto.append(digito);
        }

        // Calcular o dígito verificador e adicionar como o 13º dígito
        int digitoVerificador = calcularDigitoVerificadorEAN13(numeroProduto.toString());
        numeroProduto.append(digitoVerificador);

        return numeroProduto.toString();
    }

    // Método para calcular o dígito verificador do EAN-13
    private static int calcularDigitoVerificadorEAN13(String numero) {
        int soma = 0;

        // Percorrer os 12 dígitos para calcular a soma ponderada
        for (int i = 0; i < numero.length(); i++) {
            int digito = Character.getNumericValue(numero.charAt(i));
            soma += (i % 2 == 0) ? digito : digito * 3; // Pesar os dígitos alternadamente
        }

        // Calcular o dígito verificador
        int modulo = soma % 10;
        return (modulo == 0) ? 0 : 10 - modulo;
    }
}

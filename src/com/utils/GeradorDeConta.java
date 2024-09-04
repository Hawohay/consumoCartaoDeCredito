package com.utils;

import com.bancodigital.Conta;

import java.util.List;

public class GeradorDeConta {

    // Método público para gerar um número de conta válido
    public static String gerarNumeroContaValida(List<Conta> contasExistentes) {
        String numeroDaConta;
        boolean unico;

        do {
            // Gera a parte base do número da conta
            String numeroBase = ContaUtils.gerarNumeroContaBase();
            // Calcula o dígito verificador usando o algoritmo de Luhn
            int digitoVerificador = LuhnAlgorithm.calcularDigitoVerificador(numeroBase);
            // Combina a parte base com o dígito verificador
            numeroDaConta = numeroBase + digitoVerificador;
            // Verifica se o número gerado é único na lista de contas existentes
            unico = verificarUnicidade(numeroDaConta, contasExistentes);
        } while (!unico); // Continua gerando até encontrar um número único

        return numeroDaConta;
    }

    // Método privado para verificar a unicidade do número da conta
    private static boolean verificarUnicidade(String numeroDaConta, List<Conta> contasExistentes) {
        if (contasExistentes == null) {
            return true; // Se a lista for nula, considera que o número é único
        }

        for (Conta conta : contasExistentes) {
            if (conta.getNumero().equals(numeroDaConta)) {
                return false; // Número não é único se já existir na lista
            }
        }
        return true; // Número é único se não for encontrado na lista
    }
}

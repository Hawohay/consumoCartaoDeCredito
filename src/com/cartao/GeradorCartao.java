package com.cartao;

import com.bancodigital.LuhnAlgorithm;

import java.util.List;
import java.util.Random;

public class GeradorCartao {

    public static String gerarNumeroCartaoValido(List<Cartao> cartoesExistentes) {
        String numeroCartao;
        boolean unico;

        do {
            String numeroBase = CartaoUtils.gerarNumeroCartaoBase();
            int digitoVerificador = LuhnAlgorithm.calcularDigitoVerificador(numeroBase);
            numeroCartao = numeroBase + digitoVerificador;
            unico = verificarUnicidade(numeroCartao, cartoesExistentes);
        } while (!unico);

        return numeroCartao;
    }

    public static int gerarCVV(List<Cartao> cartoesExistentes) {
        Random random = new Random();
        int cvv;
        boolean unico;

        do {
            cvv = 100 + random.nextInt(900); // Gera um número entre 100 e 999
            unico = verificarUnicidadeCVV(cvv, cartoesExistentes);
        } while (!unico);

        return cvv;
    }

    private static boolean verificarUnicidade(String numeroCartao, List<Cartao> cartoesExistentes) {
        for (Cartao cartao : cartoesExistentes) {
            if (cartao.getNumeroDoCartao().equals(numeroCartao)) {
                return false;
            }
        }
        return true;
    }

    private static boolean verificarUnicidadeCVV(int cvv, List<Cartao> cartoesExistentes) {
        for (Cartao cartao : cartoesExistentes) {
            if (cartao.getCvv() == cvv) {
                return false;
            }
        }
        return true;
    }
}

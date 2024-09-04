package com.utils;

public class LuhnAlgorithm {
    public static int calcularDigitoVerificador(String numeroBase) {
        int soma = 0;
        boolean alternar = true;

        for (int i = numeroBase.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numeroBase.charAt(i));

            if (alternar) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }

            soma += digito;
            alternar = !alternar;
        }

        return (10 - (soma % 10)) % 10;
    }

    public static boolean validarNumero(String numeroCartao) {
        int soma = 0;
        boolean alternar = false;

        for (int i = numeroCartao.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numeroCartao.charAt(i));

            if (alternar) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }

            soma += digito;
            alternar = !alternar;
        }

        return soma % 10 == 0;
    }
}

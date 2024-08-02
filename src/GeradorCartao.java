import java.util.List;

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

    private static boolean verificarUnicidade(String numeroCartao, List<Cartao> cartoesExistentes) {
        for (Cartao cartao : cartoesExistentes) {
            if (cartao.getNumeroDoCartao().equals(numeroCartao)) {
                return false;
            }
        }
        return true;
    }
}

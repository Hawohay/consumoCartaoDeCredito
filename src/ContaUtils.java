import java.util.Random;

public class ContaUtils {
    private static final int TAMANHO_NUMERO_CONTA = 8;

    /**
     * Gera a base do número da conta, composta por 8 dígitos aleatórios.
     *
     * @return A base do número da conta como uma String.
     */
    public static String gerarNumeroContaBase() {
        Random random = new Random();
        StringBuilder numeroDaConta = new StringBuilder(TAMANHO_NUMERO_CONTA);

        // Gerar 8 dígitos aleatórios (excluindo o dígito verificador)
        for (int i = 0; i < TAMANHO_NUMERO_CONTA; i++) {
            int digito = random.nextInt(10);
            numeroDaConta.append(digito);
        }

        return numeroDaConta.toString();
    }
}

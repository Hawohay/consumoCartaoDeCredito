import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cartao> cartoes = new ArrayList<>();

        cartoes.add(new Cartao(
                "Hawohay Santos Nakahara",
                LocalDate.of(1983, 1, 15),
                2093404,
                "SSP",
                "00154966193",
                8,
                "5255 1850 2337 1057",
                8,
                "Master",
                "Crédito",
                365,
                3,
                2000,
                "12345-678",
                "DF",
                "Brasília",
                "Asa Sul",
                "Quadra 702 Bloco H"
        ));

        for (Cartao cartao : cartoes) {
            cartao.exibirInfo();
            System.out.println();
        }
    }
}

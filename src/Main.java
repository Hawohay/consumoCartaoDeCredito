import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criar uma agência e uma lista de contas
        Agencia agencia = new Agencia("001", "Agência Principal");
        List<Conta> listaDeContas = new ArrayList<>();

        // Criar uma instância de MenuPrincipal com as dependências
        MenuPrincipal menuPrincipal = new MenuPrincipal(listaDeContas, agencia);
        menuPrincipal.exibirMenuPrincipal();
    }
}

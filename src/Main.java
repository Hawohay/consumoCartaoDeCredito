import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Agencia agencia = new Agencia();
        List<Conta> listaDeContas = new ArrayList<>();

        MenuPrincipal menuPrincipal = new MenuPrincipal(listaDeContas, agencia);
        menuPrincipal.exibirMenuPrincipal();
    }
}

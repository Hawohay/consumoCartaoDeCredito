import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private List<Conta> listaDeContas;
    private Agencia agencia;
    private Scanner scanner = new Scanner(System.in);

    // Construtor para inicializar listaDeContas e agencia
    public MenuPrincipal(List<Conta> listaDeContas, Agencia agencia) {
        this.listaDeContas = listaDeContas;
        this.agencia = agencia;
    }

    public void exibirMenuPrincipal() {
        MenuCartao menuCartao = new MenuCartao();
        MenuMovimentacoesFinanceiras menuMovimentacoesFinanceiras = new MenuMovimentacoesFinanceiras(agencia);

        while (true) {
            System.out.println("------------------------------");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Atualizar Cliente");
            System.out.println("3 - Pesquisar Cliente");
            System.out.println("4 - Menu Cartão");
            System.out.println("5 - Menu Movimentações Financeiras");
            System.out.println("9 - Sair");
            System.out.println("------------------------------");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    Titular cadastrarTitular = new Titular(); // Criar instância de Titular
                    cadastrarTitular.cadastrarCliente();
                    break;
                case 2:
                    Titular atualizarTitular = new Titular(); // Criar instância de Titular
                    atualizarTitular.atualizarDadosCliente();
                    break;
                case 3:
                    Titular pesquisarTitular = new Titular(); // Criar instância de Titular
                    pesquisarTitular.pesquisarCliente();
                    break;
                case 4:
                    menuCartao.exibirMenuCartao();
                    break;
                case 5:
                    menuMovimentacoesFinanceiras.exibirMenuMovimentacoesFinanceiras();
                    break;
                case 9:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Método main para inicialização e execução do menu
    public static void main(String[] args) {
        // Exemplo de criação de dados
        Agencia agencia = new Agencia("001", "Agência Principal");
        List<Conta> listaDeContas = agencia.getContas();

        // Criar uma instância de MenuPrincipal
        MenuPrincipal menuPrincipal = new MenuPrincipal(listaDeContas, agencia);
        menuPrincipal.exibirMenuPrincipal();
    }
}

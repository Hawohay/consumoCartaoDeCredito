import java.util.Scanner;

public class MenuPrincipal {

    public void exibirMenuPrincipal() {

        Scanner scanner = new Scanner(System.in);
        Titular titular = new Titular();

        MenuCartao menuCartao = new MenuCartao();
        MenuMovimentacoesFinanceiras menuMovimentacoesFinanceiras = new MenuMovimentacoesFinanceiras();

        while (true) {
            System.out.println("------------------------------");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Atualizar Cliente");
            System.out.println("3 - Pesquisar Cliente");
            System.out.println("4 - Menu Cartão");
            System.out.println("5 - Menu Movimentações Financeiras");
            System.out.println("9 - Sair");
            System.out.println("------------------------------");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    titular.cadastrarCliente();
                    break;
                case 2:
                    titular.atualizarDadosCliente();
                    break;
                case 3:
                    titular.pesquisarCliente();
                    break;
                case 4:
                    menuCartao.exibirMenuCartao();
                    break;
                case 5:
                    menuMovimentacoesFinanceiras.exibirMovimentacoesFinanceiras();
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
}

import java.util.Scanner;

public class MenuPrincipal {
    private Agencia agencia;
    private Scanner scanner = new Scanner(System.in);

    public void exibeMenuPrincipal() {
        MenuCartao menuCartao = new MenuCartao();
        MenuMovimentacoesFinanceiras menuMovimentacoesFinanceiras = null;

        while (true) {
            System.out.println("------------------------------");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Atualizar Cliente");
            System.out.println("3 - Pesquisar Cliente");
            System.out.println("4 - Menu Cartão");
            System.out.println("5 - Menu Movimentações Financeiras");
            System.out.println("6 - Manter Agência");
            System.out.println("7 - Manter Conta");
            System.out.println("9 - Sair");
            System.out.println("------------------------------");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    new Titular().cadastrarCliente();
                    break;
                case 2:
                    new Titular().atualizarDadosCliente();
                    break;
                case 3:
                    new Titular().pesquisarCliente();
                    break;
                case 4:
                    menuCartao.exibirMenuCartao();
                    break;
                case 5:
                    if (agencia == null) {
                        System.out.println("Nenhuma agência cadastrada. Crie uma agência primeiro.");
                    } else {
                        if (menuMovimentacoesFinanceiras == null) {
                            menuMovimentacoesFinanceiras = new MenuMovimentacoesFinanceiras(agencia);
                        }
                        menuMovimentacoesFinanceiras.exibirMenuMovimentacoesFinanceiras();
                    }
                    break;
                case 6:
                    MenuAgencia.exibeMenuAgencia();
                    break;
                case 7:
                    // Lógica para manter contas (se necessário)
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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private Agencia agencia;
    private Scanner scanner = new Scanner(System.in);
    private List<Cartao> cartoes = new ArrayList<>(); // Lista de cartões existente

    public void exibeMenuPrincipal() {
        // Criação do menu de movimentações financeiras deve ocorrer após a agência ser criada
        MenuCartao menuCartao = new MenuCartao(cartoes); // Passa a lista de cartões

        while (true) {
            if (agencia == null) {
                System.out.println("Nenhuma agência encontrada. Vamos criar uma nova agência.");
                agencia = Agencia.cadastrarAgencia(); // Atualiza a variável agencia
            }

            // Instancia o menu de movimentações financeiras após garantir que agência não é null
            MenuMovimentacoesFinanceiras menuMovimentacoesFinanceiras = new MenuMovimentacoesFinanceiras(agencia);

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
                    menuMovimentacoesFinanceiras.exibirMenuMovimentacoesFinanceiras();
                    break;
                case 6:
                    MenuAgencia.exibeMenuAgencia(); // Atualizar a agência se necessário
                    // Recria o menu de movimentações financeiras após atualizar a agência
                    menuMovimentacoesFinanceiras = new MenuMovimentacoesFinanceiras(agencia);
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
